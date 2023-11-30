package interface_adapter.LocationsFromLabel;

import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.api_returns.ApiState;
import interface_adapter.api_returns.ApiViewModel;
import use_case.LocationsFromLabel.LocationsFromLabelInputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelOutputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelOutputData;
import use_case.api_returns.ApiOutputData;

public class LocationsFromLabelPresenter implements LocationsFromLabelOutputBoundary {
    private final LocationsFromLabelViewModel locationsFromLabelViewModel;
    private ViewManagerModel viewManagerModel;

    public LocationsFromLabelPresenter(LocationsFromLabelViewModel locationsFromLabelViewModel, ViewManagerModel viewManagerModel) {
        this.locationsFromLabelViewModel = locationsFromLabelViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(LocationsFromLabelOutputData locationsFromLabelOutputData) {
        LocationsFromLabelState locationsFromLabelState = locationsFromLabelViewModel.getState();
        locationsFromLabelState.setLocations(locationsFromLabelOutputData.locations);
        this.locationsFromLabelViewModel.setState(locationsFromLabelState);
        this.locationsFromLabelViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(locationsFromLabelViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        LocationsFromLabelState locationsFromLabelState = locationsFromLabelViewModel.getState();
        locationsFromLabelState.setError(error);
        locationsFromLabelViewModel.firePropertyChanged();
    }
}
