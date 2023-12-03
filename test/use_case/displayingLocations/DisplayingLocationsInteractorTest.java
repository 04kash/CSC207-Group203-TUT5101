package test.use_case.displayingLocations;

import data_access.APIDataAccessObject;
import entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.api_returns.*;
import use_case.displayingLocations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DisplayingLocationsInteractorTest {

    APIDataAccessObject apiUserDataAccessObject;

    @BeforeEach
    void unit() {
        try {
            apiUserDataAccessObject = new APIDataAccessObject("./test.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ApiUserDataAccessInterface userDataAccessInterface0 = apiUserDataAccessObject;
        ApiOutputBoundary successPresenter0 = new ApiOutputBoundary() {
            @Override
            public void prepareSuccessView(ApiOutputData user) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        ApiInputData inputData0 = new ApiInputData("chennai", "transport");
        ApiInputBoundary interactor0 = new ApiInteractor(userDataAccessInterface0, successPresenter0);
            interactor0.execute(inputData0);
    }
    @Test
    void successTest() {
        DisplayingLocationsUserDataAccessInterface userDataAccessInterface = apiUserDataAccessObject;
        DisplayingLocationsOutputBoundary successPresenter = new DisplayingLocationsOutputBoundary() {
            @Override
            public void prepareSuccessView(DisplayingLocationsOutputData displayingLocationsOutputData) {
                assertNotNull(displayingLocationsOutputData.getLocations());
                HashMap<String, Location> accounts = userDataAccessInterface.getAccounts();
                ArrayList<Location> locations = new ArrayList<>();
                for (String key : accounts.keySet()) {
                    locations.add(accounts.get(key));
                }
                assertEquals(locations, displayingLocationsOutputData.getLocations());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };

        DisplayingLocationsInputData inputData = new DisplayingLocationsInputData();
        DisplayingLocationsInputBoundary interactor = new DisplayingLocationsInteractor(userDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failTest() {

    }
}
