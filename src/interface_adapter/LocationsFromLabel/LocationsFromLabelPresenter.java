package interface_adapter.LocationsFromLabel;

import entity.Location;
import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.api_returns.ApiState;
import interface_adapter.api_returns.ApiViewModel;
import use_case.LocationsFromLabel.LocationsFromLabelInputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelOutputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelOutputData;
import use_case.api_returns.ApiOutputData;

import java.util.ArrayList;

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
        ArrayList<Location> locations= locationsFromLabelOutputData.getLocations();
        StringBuilder outputDataBuilder = new StringBuilder();

        for (Location l : locations) {
            outputDataBuilder.append(l.getName())
                    .append("\n")
                    .append(l.getOsmLink())
                    .append("\n\n");
        }

        String outputData = outputDataBuilder.toString();
        locationsFromLabelState.setLocation(outputData);
        this.locationsFromLabelViewModel.setState(locationsFromLabelState);
        this.locationsFromLabelViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(locationsFromLabelViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        LocationsFromLabelState locationsFromLabelState = locationsFromLabelViewModel.getState();
        locationsFromLabelState.setLocationsError(error);
        locationsFromLabelViewModel.firePropertyChanged();
    }
}
