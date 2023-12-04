package interface_adapter.LocationsFromLabel;

import entity.Location;
import interface_adapter.ViewManagerModel;
import use_case.LocationsFromLabel.LocationsFromLabelOutputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelOutputData;

import java.util.ArrayList;

/**
 * Presenter class responsible for preparing the view based on the outcomes of the locations from label use case.
 * This class implements the LocationsFromLabelOutputBoundary interface to handle success and failure scenarios.
 */
public class LocationsFromLabelPresenter implements LocationsFromLabelOutputBoundary {
    private final LocationsFromLabelViewModel locationsFromLabelViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new LocationsFromLabelPresenter with the specified LocationsFromLabelViewModel and ViewManagerModel.
     *
     * @param locationsFromLabelViewModel the view model associated with the locations from label functionality
     * @param viewManagerModel the view manager model for handling overall view management
     */
    public LocationsFromLabelPresenter(LocationsFromLabelViewModel locationsFromLabelViewModel, ViewManagerModel viewManagerModel) {
        this.locationsFromLabelViewModel = locationsFromLabelViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful execution of the locations from label use case.
     *
     * @param locationsFromLabelOutputData the output data containing information about the retrieved locations
     */
    @Override
    public void prepareSuccessView(LocationsFromLabelOutputData locationsFromLabelOutputData) {
        LocationsFromLabelState locationsFromLabelState = locationsFromLabelViewModel.getState();
        ArrayList<Location> locations = locationsFromLabelOutputData.getLocations();
        StringBuilder outputDataBuilder = new StringBuilder();
        if (locations != null) {
            for (Location l : locations) {
                outputDataBuilder.append(l.getName())
                        .append("\n")
                        .append("https://www.openstreetmap.org/"+l.getOsmLink())
                        .append("\n\n");
            }

            String outputData = outputDataBuilder.toString();
            locationsFromLabelState.setDisplayMsg(outputData);
            this.locationsFromLabelViewModel.setState(locationsFromLabelState);
            locationsFromLabelViewModel.firePropertyChanged();
            viewManagerModel.firePropertyChanged();
        }
    }

    /**
     * Prepares the view for a failed execution of the locations from label use case.
     *
     * @param error a message indicating the failure of the locations from label operation
     */
    @Override
    public void prepareFailView(String error) {
        LocationsFromLabelState locationsFromLabelState = locationsFromLabelViewModel.getState();
        locationsFromLabelState.setDisplayMsg(error);
        locationsFromLabelViewModel.firePropertyChanged();
    }
}
