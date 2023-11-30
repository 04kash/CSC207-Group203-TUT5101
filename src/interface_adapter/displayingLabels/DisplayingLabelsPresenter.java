package interface_adapter.displayingLabels;

import interface_adapter.ViewManagerModel;
import use_case.displayingLabels.DisplayingLabelsOutputBoundary;
import use_case.displayingLabels.DisplayingLabelsOutputData;

public class DisplayingLabelsPresenter implements DisplayingLabelsOutputBoundary {
    private final DisplayingLabelsViewModel displayingLabelsViewModel;
    private ViewManagerModel viewManagerModel;

    public DisplayingLabelsPresenter(DisplayingLabelsViewModel displayingLabelsViewModel, ViewManagerModel viewManagerModel) {
        this.displayingLabelsViewModel = displayingLabelsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DisplayingLabelsOutputData response) {
        DisplayingLabelsState displayingLabelsState = displayingLabelsViewModel.getState();
        displayingLabelsState.setLabels(response.getLabels());
        this.displayingLabelsViewModel.setState(displayingLabelsState);
        displayingLabelsViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DisplayingLabelsState displayingLabelsState = displayingLabelsViewModel.getState();
        displayingLabelsState.setLabelError(error);
        displayingLabelsViewModel.firePropertyChanged();
    }
}
