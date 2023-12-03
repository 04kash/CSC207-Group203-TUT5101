package test.interactors;

import data_access.APIDataAccessObject;
import entity.Coordinate;
import entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.apiReturns.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class ApiInteractorTest {

    private String location;
    private String filter;

    @BeforeEach
    void init() {
        this.location = "chennai";
        this.filter = "transport";

    }

    @Test
    void successTest() {
        APIDataAccessObject apiUserDataAccessObject;
        try {
            apiUserDataAccessObject = new APIDataAccessObject("./test.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ApiUserDataAccessInterface userDataAccessInterface = apiUserDataAccessObject;
        ApiOutputBoundary successPresenter = new ApiOutputBoundary() {
            @Override
            public void prepareSuccessView(ApiOutputData response) {
                ArrayList<Location> locations = new ArrayList<>();
                Location location1 = new Location("HP", new Coordinate(13.09499454498291, 80.29278564453125), "node/393768353", "transport");
                Location location2 = new Location("IOC - Otteri", new Coordinate(13.092050552368164, 80.25126647949219), "node/4627597189", "transport");
                Location location3 = new Location("Indian Oil", new Coordinate(13.07228946685791, 80.25179135498047), "node/7057699185", "transport");
                locations.add(location1);
                locations.add(location2);
                locations.add(location3);
                assertEquals(locations.get(0).getName(), response.getLocations().get(0).getName());
                assertEquals(locations.get(0).getCoordinate().getLatitude(), response.getLocations().get(0).getCoordinate().getLatitude(), 0.01);
                assertEquals(locations.get(0).getCoordinate().getLongitude(), response.getLocations().get(0).getCoordinate().getLongitude(), 0.01);
                assertEquals(locations.get(0).getOsmLink(), response.getLocations().get(0).getOsmLink());
                assertEquals(locations.get(0).getFilter(), response.getLocations().get(0).getFilter());

                assertEquals(locations.get(1).getName(), response.getLocations().get(1).getName());
                assertEquals(locations.get(1).getCoordinate().getLatitude(), response.getLocations().get(1).getCoordinate().getLatitude(), 0.01);
                assertEquals(locations.get(1).getCoordinate().getLongitude(), response.getLocations().get(1).getCoordinate().getLongitude(), 0.01);
                assertEquals(locations.get(1).getOsmLink(), response.getLocations().get(1).getOsmLink());
                assertEquals(locations.get(1).getFilter(), response.getLocations().get(1).getFilter());

                assertEquals(locations.get(2).getName(), response.getLocations().get(2).getName());
                assertEquals(locations.get(2).getCoordinate().getLatitude(), response.getLocations().get(2).getCoordinate().getLatitude(), 0.01);
                assertEquals(locations.get(2).getCoordinate().getLongitude(), response.getLocations().get(2).getCoordinate().getLongitude(), 0.01);
                assertEquals(locations.get(2).getOsmLink(), response.getLocations().get(2).getOsmLink());
                assertEquals(locations.get(2).getFilter(), response.getLocations().get(2).getFilter());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };
        ApiInputData inputData = new ApiInputData(this.location, this.filter);
        ApiInputBoundary interactor = new ApiInteractor(userDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }
}
