package interface_adapter.SavingLocation;

import interface_adapter.ViewManagerModel;
import use_case.SavingLocation.SavingLocationOutputBoundary;

public class SavingLocationPresenter implements SavingLocationOutputBoundary {
    SavingLocationViewModel savingLocationViewModel;
    private ViewManagerModel viewManagerModel;

    public SavingLocationPresenter(SavingLocationViewModel savingLocationViewModel, ViewManagerModel viewManagerModel){
        this.savingLocationViewModel = savingLocationViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(String success) {
        SavingLocationState currState = savingLocationViewModel.getState();
        currState.setDisplayMsg(success);
        savingLocationViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SavingLocationState currState = savingLocationViewModel.getState();
        currState.setDisplayMsg(error);
        savingLocationViewModel.firePropertyChanged();

    }
}
