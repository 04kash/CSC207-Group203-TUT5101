package test.interactors.CreateLabels;

import data_access.InMemoryCreateLabel;
import entity.Label;
import org.junit.jupiter.api.Test;
import use_case.CreateLabel.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CreateLabelInteractorTest {
    CreateLabelDataAccessInterface Repository;
    @Test
    void successTest(){
        Repository = new InMemoryCreateLabel();
        CreateLabelOutputBoundary successPresenter = new CreateLabelOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                fail("Use case is not expected to fail.");
            }

            @Override
            public void prepareSuccessView(String success) {
               assertEquals("Label saved successfully",success);
               assertEquals(true,Repository.labelExists("Kashish",new Label("Restaurants")));
            }
        };
        CreateLabelInputData createLabelInputData= new CreateLabelInputData("Restaurants");
        CreateLabelInputBoundary createLabelInteractor = new CreateLabelInteractor(Repository,successPresenter);
        createLabelInteractor.excecute(createLabelInputData);
    }
    @Test
    void failTest(){
        Repository = new InMemoryCreateLabel();
        CreateLabelOutputBoundary successPresenter = new CreateLabelOutputBoundary() {
            @Override
            public void prepareSuccessView(String success) {
                fail("Use case is not expected to succeed.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Label Name already exists",error);
            }
        };
        CreateLabelInputData createLabelInputData= new CreateLabelInputData("favorite");
        CreateLabelInputBoundary createLabelInteractor = new CreateLabelInteractor(Repository,successPresenter);
        createLabelInteractor.excecute(createLabelInputData);
    }
}
