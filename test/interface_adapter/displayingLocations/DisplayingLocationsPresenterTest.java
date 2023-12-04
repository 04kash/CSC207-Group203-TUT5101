package interface_adapter.displayingLocations;

import entity.Coordinate;
import entity.Location;
import interface_adapter.ViewManagerModel;
import interface_adapter.displayingLabels.DisplayingLabelsPresenter;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.displayingLabels.DisplayingLabelsOutputData;
import use_case.displayingLocations.DisplayingLocationsOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisplayingLocationsPresenterTest {
    DisplayingLocationsPresenter displayingLocationsPresenter;
    DisplayingLocationsViewModel displayingLocationsViewModel;
    @BeforeEach
    void unit(){
        displayingLocationsViewModel = new DisplayingLocationsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        displayingLocationsPresenter = new DisplayingLocationsPresenter(displayingLocationsViewModel,viewManagerModel);
    }
    @Test
    void prepareSuccessView() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("The Abbot",new Coordinate(-79.4134750366211,43.70365524291992),"node/7567822674","foods"));
        DisplayingLocationsOutputData displayingLocationsOutputData = new DisplayingLocationsOutputData(locations,false);
        displayingLocationsPresenter.prepareSuccessView(displayingLocationsOutputData);
        assertEquals(locations,displayingLocationsViewModel.getState().getLocations());
    }

    @Test
    void prepareFailView() {
        displayingLocationsPresenter.prepareFailView("Error");
        assertEquals("Error",displayingLocationsViewModel.getState().getLocationError());
    }
}