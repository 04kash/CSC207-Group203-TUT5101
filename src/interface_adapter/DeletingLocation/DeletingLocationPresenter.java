package interface_adapter.DeletingLocation;

import interface_adapter.ViewManagerModel;
import use_case.DeletingLocation.DeletingLocationOutputBoundary;
import use_case.DeletingLocation.DeletingLocationOutputData;

public class DeletingLocationPresenter implements DeletingLocationOutputBoundary {
    private final DeletingLocationViewModel deletingLocationViewModel;
    private final ViewManagerModel viewManagerModel;

    public DeletingLocationPresenter(ViewManagerModel viewManagerModel,
                                     DeletingLocationViewModel deletingLocationViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.deletingLocationViewModel = deletingLocationViewModel;
    }

    @Override
    public void prepareSuccessView(DeletingLocationOutputData response) {
        DeletingLocationState deletingLocationState = deletingLocationViewModel.getState();
        deletingLocationState.setDeletedLocation(response.getDeletedUsers());
        this.deletingLocationViewModel.setState(deletingLocationState);
        deletingLocationViewModel.firePropertyChanged();
    }
}