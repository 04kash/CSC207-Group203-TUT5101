package interface_adapter.SavingLocation;

import use_case.SavingLocation.SavingLocationOutputBoundary;

public class SavingLocationPresenter implements SavingLocationOutputBoundary {
    SavingLocationViewModel savingLocationViewModel;

    public SavingLocationPresenter(SavingLocationViewModel savingLocationViewModel){
        this.savingLocationViewModel=savingLocationViewModel;
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
