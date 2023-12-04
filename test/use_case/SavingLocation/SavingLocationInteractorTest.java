package use_case.SavingLocation;

import data_access.InMemorySavingLocation;
import entity.Coordinate;
import entity.Label;
import entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.SavingLocation.SavingLocationInputData;
import use_case.SavingLocation.SavingLocationInteractor;
import use_case.SavingLocation.SavingLocationOutputBoundary;
import use_case.SavingLocation.SavingLocationUserDataAccessInterface;

import static org.junit.Assert.assertEquals;

public class SavingLocationInteractorTest {
    SavingLocationUserDataAccessInterface Repository;
    @Test
    void successTest(){
        Repository = new InMemorySavingLocation();
        SavingLocationOutputBoundary successPresenter = new SavingLocationOutputBoundary() {
            @Override
            public void prepareSuccessView(String success) {
                assertEquals("Location saved successfully",success);
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case success is unexpected.");
            }
        };
         SavingLocationInputData savingLocationInputData = new SavingLocationInputData("favorite","The Abbot",-79.4134750366211,43.70365524291992,"node/7567822674","foods");
         SavingLocationInteractor savingLocationInteractor = new SavingLocationInteractor(Repository,successPresenter);
         savingLocationInteractor.execute(savingLocationInputData);
    }
    @Test
    //Location already exists,
    void failLocationExistsTest(){
        Repository = new InMemorySavingLocation();
        Repository.addLocation("Kashish",new Location("The Abbot",new Coordinate(-79.4134750366211,43.70365524291992),"node/7567822674","foods"),new Label("favorite"));
        SavingLocationOutputBoundary successPresenter = new SavingLocationOutputBoundary() {
            @Override
            public void prepareSuccessView(String success) {
                Assertions.fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Location is already saved.",error);
            }
        };
        SavingLocationInputData savingLocationInputData = new SavingLocationInputData("favorite","The Abbot",-79.4134750366211,43.70365524291992,"node/7567822674","foods");
        SavingLocationInteractor savingLocationInteractor = new SavingLocationInteractor(Repository,successPresenter);
        savingLocationInteractor.execute(savingLocationInputData);

    }
}
