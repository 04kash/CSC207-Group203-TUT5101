package interface_adapter.api_returns;

import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.ViewManagerModel;
import use_case.api_returns.ApiOutputBoundary;
import use_case.api_returns.ApiOutputData;

public class ApiPresenter implements ApiOutputBoundary {
    private final ApiViewModel apiViewModel;
    private final SavingLocationViewModel savingLocationViewModel;
    private ViewManagerModel viewManagerModel;

    public ApiPresenter(ApiViewModel apiViewModel, SavingLocationViewModel savingLocationViewModel, ViewManagerModel viewManagerModel) {
        this.apiViewModel = apiViewModel;
        this.savingLocationViewModel = savingLocationViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ApiOutputData response) {
        ApiState apiState = apiViewModel.getState();
        apiState.setLocations(response.getLocations());

        this.apiViewModel.setState(apiState);
        viewManagerModel.setActiveView(apiViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ApiState apiState = apiViewModel.getState();
        apiState.setLocationError(error);
        apiViewModel.firePropertyChanged();
    }
}
