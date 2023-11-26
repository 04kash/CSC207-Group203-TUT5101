package interface_adapter.CreateLabel;
import use_case.CreateLabel.CreateLabelOutputBoundary;

public class CreateLabelPresenter implements CreateLabelOutputBoundary {
    CreateLabelViewModel createLabelViewModel;

    public CreateLabelPresenter(CreateLabelViewModel createLabelViewModel){
        this.createLabelViewModel = createLabelViewModel;
    }
    @Override
    public void prepareSuccessView(String success){
        CreateLabelState state = createLabelViewModel.getState();
        state.setDisplayMessage(success);
        createLabelViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error){
        CreateLabelState state = createLabelViewModel.getState();
        state.setDisplayMessage(error);
        createLabelViewModel.firePropertyChanged();
    }
}
