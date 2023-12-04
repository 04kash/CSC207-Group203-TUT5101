package interface_adapter.api_returns;

import entity.Coordinate;
import entity.Location;
import interface_adapter.ViewManagerModel;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.api_returns.ApiOutputData;

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
        apiPresenter.prepareFailView("Error");
        assertEquals("Error",apiViewModel.getState().getLocationError());
    }
}