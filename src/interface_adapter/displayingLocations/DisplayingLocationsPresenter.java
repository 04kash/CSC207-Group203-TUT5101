package interface_adapter.displayingLocations;

import interface_adapter.ViewManagerModel;
import use_case.displayingLocations.DisplayingLocationsOutputBoundary;
import use_case.displayingLocations.DisplayingLocationsOutputData;

/**
 * Presenter class responsible for preparing the view based on the outcomes of the display locations use case.
 * This class implements the DisplayingLocationsOutputBoundary interface to handle success and failure scenarios.
 */
public class DisplayingLocationsPresenter implements DisplayingLocationsOutputBoundary {
    private final DisplayingLocationsViewModel displayingLocationsViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new DisplayingLocationsPresenter with the specified DisplayingLocationsViewModel and ViewManagerModel.
     *
     * @param displayingLocationsViewModel the view model associated with the display locations functionality
     * @param viewManagerModel the view manager model for handling overall view management
     */
    public DisplayingLocationsPresenter(DisplayingLocationsViewModel displayingLocationsViewModel, ViewManagerModel viewManagerModel) {
        this.displayingLocationsViewModel = displayingLocationsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful execution of the display locations use case.
     *
     * @param response the output data containing information about the displayed locations
     */
    @Override
    public void prepareSuccessView(DisplayingLocationsOutputData response) {
        DisplayingLocationsState displayingLocationsState = displayingLocationsViewModel.getState();
        displayingLocationsState.setLocations(response.getLocations());
        this.displayingLocationsViewModel.setState(displayingLocationsState);
        displayingLocationsViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed execution of the display locations use case.
     *
     * @param error a message indicating the failure of the display locations operation
     */
    @Override
    public void prepareFailView(String error) {
        DisplayingLocationsState displayingLocationsState = displayingLocationsViewModel.getState();
        displayingLocationsState.setLocationError(error);
        displayingLocationsViewModel.firePropertyChanged();
    }
}
