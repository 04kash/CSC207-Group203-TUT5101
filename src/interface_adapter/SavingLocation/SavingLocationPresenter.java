package interface_adapter.SavingLocation;

import interface_adapter.ViewManagerModel;
import use_case.SavingLocation.SavingLocationOutputBoundary;

/**
 * Presenter class responsible for preparing the view based on the outcomes of the saving location use case.
 * This class implements the SavingLocationOutputBoundary interface to handle success and failure scenarios.
 */
public class SavingLocationPresenter implements SavingLocationOutputBoundary {

    /**
     * The view model associated with the saving location functionality.
     */
    SavingLocationViewModel savingLocationViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new SavingLocationPresenter with the specified SavingLocationViewModel and ViewManagerModel.
     *
     * @param savingLocationViewModel the view model associated with the saving location functionality
     * @param viewManagerModel the view manager model for handling overall view management
     */
    public SavingLocationPresenter(SavingLocationViewModel savingLocationViewModel, ViewManagerModel viewManagerModel) {
        this.savingLocationViewModel = savingLocationViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful saving location attempt.
     *
     * @param success a message indicating the success of the saving location operation
     */
    @Override
    public void prepareSuccessView(String success) {
        SavingLocationState currState = savingLocationViewModel.getState();
        currState.setDisplayMsg(success);
        savingLocationViewModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed saving location attempt.
     *
     * @param error a message indicating the failure of the saving location operation
     */
    @Override
    public void prepareFailView(String error) {
        SavingLocationState currState = savingLocationViewModel.getState();
        currState.setDisplayMsg(error);
        savingLocationViewModel.firePropertyChanged();
    }
}
