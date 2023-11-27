package interface_adapter.api_returns;

import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import use_case.api_returns.ApiOutputBoundary;
import use_case.api_returns.ApiOutputData;
import view.LocationView;
import view.ViewManager;

public class ApiPresenter implements ApiOutputBoundary {
    private final ApiViewModel apiViewModel;
    private final DisplayingLocationsViewModel displayingLocationsViewModel;
    private ViewManagerModel viewManagerModel;

    public ApiPresenter(ApiViewModel apiViewModel, ViewManagerModel viewManagerModel, DisplayingLocationsViewModel displayingLocationsViewModel) {
        this.apiViewModel = apiViewModel;
        this.displayingLocationsViewModel = displayingLocationsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ApiOutputData response) {
        ApiState apiState = apiViewModel.getState();
        apiState.setLocations(response.getLocations());

        this.apiViewModel.setState(apiState);

        viewManagerModel.setActiveView(displayingLocationsViewModel.getViewName());
//        displayingLocationsViewModel.getState().setLocations(response.getLocations());
        displayingLocationsViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
//        ViewManager.showLocationView();
    }

    @Override
    public void prepareFailView(String error) {
        ApiState apiState = apiViewModel.getState();
        apiState.setLocationError(error);
        apiViewModel.firePropertyChanged();
    }
}
