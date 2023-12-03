package interface_adapter.displayingLabels;

import interface_adapter.ViewManagerModel;
import use_case.displayingLabels.DisplayingLabelsOutputBoundary;
import use_case.displayingLabels.DisplayingLabelsOutputData;

/**
 * Presenter class responsible for preparing the view based on the outcomes of the display labels use case.
 * This class implements the DisplayingLabelsOutputBoundary interface to handle success and failure scenarios.
 */
public class DisplayingLabelsPresenter implements DisplayingLabelsOutputBoundary {

    /**
     * The view model associated with the display labels functionality.
     */
    private final DisplayingLabelsViewModel displayingLabelsViewModel;

    /**
     * The view manager model for handling overall view management.
     */
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new DisplayingLabelsPresenter with the specified DisplayingLabelsViewModel and ViewManagerModel.
     *
     * @param displayingLabelsViewModel the view model associated with the display labels functionality
     * @param viewManagerModel the view manager model for handling overall view management
     */
    public DisplayingLabelsPresenter(DisplayingLabelsViewModel displayingLabelsViewModel, ViewManagerModel viewManagerModel) {
        this.displayingLabelsViewModel = displayingLabelsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful execution of the display labels use case.
     *
     * @param response the output data containing information about the displayed labels
     */
    @Override
    public void prepareSuccessView(DisplayingLabelsOutputData response) {
        DisplayingLabelsState displayingLabelsState = displayingLabelsViewModel.getState();
        displayingLabelsState.setLabels(response.getLabels());
        this.displayingLabelsViewModel.setState(displayingLabelsState);
        displayingLabelsViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed execution of the display labels use case.
     *
     * @param error a message indicating the failure of the display labels operation
     */
    @Override
    public void prepareFailView(String error) {
        DisplayingLabelsState displayingLabelsState = displayingLabelsViewModel.getState();
        displayingLabelsState.setLabelError(error);
        displayingLabelsViewModel.firePropertyChanged();
    }
}
