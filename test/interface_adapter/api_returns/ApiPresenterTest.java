package interface_adapter.api_returns;

import entity.Coordinate;
import entity.Location;
import interface_adapter.ViewManagerModel;
import interface_adapter.apiReturns.ApiPresenter;
import interface_adapter.apiReturns.ApiViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.apiReturns.ApiOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ApiPresenterTest {
    ApiPresenter apiPresenter;
    ApiViewModel apiViewModel;
    DisplayingLocationsViewModel displayingLocationsViewModel;
    @BeforeEach
    void unit(){
        displayingLocationsViewModel = new DisplayingLocationsViewModel();
        apiViewModel = new ApiViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        apiPresenter = new ApiPresenter(apiViewModel,viewManagerModel,displayingLocationsViewModel);
    }

    @Test
    void prepareSuccessView() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("The Abbot",new Coordinate(-79.4134750366211,43.70365524291992),"node/7567822674","foods"));
        ApiOutputData apiOutputData = new ApiOutputData(locations,false);
        apiPresenter.prepareSuccessView(apiOutputData);
        assertEquals(locations,apiViewModel.getState().getLocations());
    }

    @Test
    void prepareFailView() {
        apiPresenter.prepareFailView("Error1");
        assertEquals("Error1",apiViewModel.getState().getLocationError());
    }
}