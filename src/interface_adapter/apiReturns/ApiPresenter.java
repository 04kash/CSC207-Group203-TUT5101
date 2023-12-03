package interface_adapter.apiReturns;

import interface_adapter.ViewManagerModel;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import use_case.apiReturns.ApiOutputBoundary;
import use_case.apiReturns.ApiOutputData;

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
