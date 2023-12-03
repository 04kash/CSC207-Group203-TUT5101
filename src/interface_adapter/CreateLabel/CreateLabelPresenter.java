package interface_adapter.CreateLabel;

import use_case.CreateLabel.CreateLabelOutputBoundary;

/**
 * Presenter class responsible for preparing the view based on the outcomes of the create label use case.
 * This class implements the CreateLabelOutputBoundary interface to handle success and failure scenarios.
 */
public class CreateLabelPresenter implements CreateLabelOutputBoundary {

    /**
     * The view model associated with the create label functionality.
     */
    CreateLabelViewModel createLabelViewModel;

    /**
     * Constructs a new CreateLabelPresenter with the specified CreateLabelViewModel.
     *
     * @param createLabelViewModel the view model associated with the create label functionality
     */
    public CreateLabelPresenter(CreateLabelViewModel createLabelViewModel){
        this.createLabelViewModel = createLabelViewModel;
    }

    /**
     * Prepares the view for a successful execution of the create label use case.
     *
     * @param success a message indicating the success of the create label operation
     */
    @Override
    public void prepareSuccessView(String success){
        CreateLabelState state = createLabelViewModel.getState();
        state.setDisplayMessage(success);
        createLabelViewModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed execution of the create label use case.
     *
     * @param error a message indicating the failure of the create label operation
     */
    @Override
    public void prepareFailView(String error){
        CreateLabelState state = createLabelViewModel.getState();
        state.setDisplayMessage(error);
        createLabelViewModel.firePropertyChanged();
    }
}
