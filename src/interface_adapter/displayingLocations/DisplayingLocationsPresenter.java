package interface_adapter.displayingLocations;

import interface_adapter.ViewManagerModel;
import interface_adapter.api_returns.ApiState;
import use_case.displayingLocations.DisplayingLocationsOutputBoundary;
import use_case.displayingLocations.DisplayingLocationsOutputData;

public class DisplayingLocationsPresenter implements DisplayingLocationsOutputBoundary {
    private final DisplayingLocationsViewModel displayingLocationsViewModel;
    private ViewManagerModel viewManagerModel;

    public DisplayingLocationsPresenter(DisplayingLocationsViewModel displayingLocationsViewModel, ViewManagerModel viewManagerModel) {
        this.displayingLocationsViewModel = displayingLocationsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DisplayingLocationsOutputData response) {
        DisplayingLocationsState displayingLocationsState = displayingLocationsViewModel.getState();
        displayingLocationsState.setLocations(response.getLocations());
        this.displayingLocationsViewModel.setState(displayingLocationsState);
        displayingLocationsViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        DisplayingLocationsState displayingLocationsState = displayingLocationsViewModel.getState();
        displayingLocationsState.setLocationError(error);
        displayingLocationsViewModel.firePropertyChanged();
    }
}
