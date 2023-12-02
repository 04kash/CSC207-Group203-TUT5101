package interface_adapter.LocationsFromLabel;

import entity.Location;
import interface_adapter.ViewManagerModel;
import use_case.LocationsFromLabel.LocationsFromLabelOutputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelOutputData;

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
        ArrayList<Location> locations = locationsFromLabelOutputData.getLocations();
        StringBuilder outputDataBuilder = new StringBuilder();
        if (locations != null) {
            for (Location l : locations) {
                outputDataBuilder.append(l.getName())
                        .append("\n")
                        .append(l.getOsmLink())
                        .append("\n\n");
            }

            String outputData = outputDataBuilder.toString();
            locationsFromLabelState.setDisplayMsg(outputData);
            this.locationsFromLabelViewModel.setState(locationsFromLabelState);
            locationsFromLabelViewModel.firePropertyChanged();
            viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public void prepareFailView(String error) {
        LocationsFromLabelState locationsFromLabelState = locationsFromLabelViewModel.getState();
        locationsFromLabelState.setDisplayMsg(error);
        locationsFromLabelViewModel.firePropertyChanged();
    }
}
