package interactors;

import data_access.InMemoryLocationsFromLabel;
import entity.Coordinate;
import entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.LocationsFromLabel.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LocationsFromLabelInteractorTest {
    LocationsFromLabelUserDataAccessInterface Repository;
    ArrayList<Location> locations;

    @BeforeEach
    void unit() throws IOException {
        locations = new ArrayList<>();
        locations.add(new Location("The Abbot",new Coordinate(-79.4134750366211,43.70365524291992),"node/7567822674","foods"));
        Repository = new InMemoryLocationsFromLabel("restaurants",locations);
    }
    @Test
    void successTest() {
        LocationsFromLabelOutputBoundary successPresenter = new LocationsFromLabelOutputBoundary() {
            @Override
            public void prepareSuccessView(LocationsFromLabelOutputData outputData) {
                Assertions.assertNotNull(outputData.getLocations());
                assertEquals(locations.get(0).getName(), outputData.getLocations().get(0).getName());
                assertEquals(locations.get(0).getCoordinate().getLatitude(), outputData.getLocations().get(0).getCoordinate().getLatitude(), 0.01);
                assertEquals(locations.get(0).getCoordinate().getLongitude(), outputData.getLocations().get(0).getCoordinate().getLongitude(), 0.01);
                assertEquals(locations.get(0).getOsmLink(), outputData.getLocations().get(0).getOsmLink());
                assertEquals(locations.get(0).getFilter(), outputData.getLocations().get(0).getFilter());


            }

            @Override
            public void prepareFailView(String error) {
                 Assertions.fail("Use case failure is unexpected.");
            }
        };
        LocationsFromLabelInputData locationsFromLabelInputData = new LocationsFromLabelInputData("restaurants");
        LocationsFromLabelInteractor locationsFromLabelInteractor = new LocationsFromLabelInteractor(Repository,successPresenter);
        locationsFromLabelInteractor.execute(locationsFromLabelInputData);
    }
    @Test
    //Label doesn't exist
    void FailLabelTest(){
        LocationsFromLabelOutputBoundary failPresenter = new LocationsFromLabelOutputBoundary() {
            @Override
            public void prepareSuccessView(LocationsFromLabelOutputData outputData) {
                Assertions.fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("This Label does not exist",error);
            }
        };
        LocationsFromLabelInputData locationsFromLabelInputData = new LocationsFromLabelInputData("Favorites Places to Shop");
        LocationsFromLabelInteractor locationsFromLabelInteractor = new LocationsFromLabelInteractor(Repository,failPresenter);
        locationsFromLabelInteractor.execute(locationsFromLabelInputData);
    }
    @Test
    void FailLocationTest(){
        LocationsFromLabelOutputBoundary failPresenter = new LocationsFromLabelOutputBoundary() {
            @Override
            public void prepareSuccessView(LocationsFromLabelOutputData outputData) {
                Assertions.fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("No locations have been saved under this Label.",error);
            }
        };
        LocationsFromLabelInputData locationsFromLabelInputData = new LocationsFromLabelInputData("favorite");
        LocationsFromLabelInteractor locationsFromLabelInteractor = new LocationsFromLabelInteractor(Repository,failPresenter);
        locationsFromLabelInteractor.execute(locationsFromLabelInputData);
    }
}
