package interface_adapter.apiReturns;

import interface_adapter.ViewManagerModel;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import use_case.apiReturns.ApiOutputBoundary;
import use_case.apiReturns.ApiOutputData;

public class ApiPresenter implements ApiOutputBoundary {
    private final ApiViewModel apiViewModel;
    private final DisplayingLocationsViewModel displayingLocationsViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * This method initializes the api presenter
     *
     * @param apiViewModel this is the api view model that informs the current view on changes that are being made
     * @param viewManagerModel this is the view manager model that manages the view that is currently being displayed
     * @param displayingLocationsViewModel this is the displaying locations view model that we want the screen to display
     *                                     at the end of this use case
     */
    public ApiPresenter(ApiViewModel apiViewModel, ViewManagerModel viewManagerModel, DisplayingLocationsViewModel displayingLocationsViewModel) {
        this.apiViewModel = apiViewModel;
        this.displayingLocationsViewModel = displayingLocationsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * This method displays the location view if called
     *
     * @param response is the output data that is retrieved from the api calls
     */
    @Override
    public void prepareSuccessView(ApiOutputData response) {
        ApiState apiState = apiViewModel.getState();
        apiState.setLocations(response.getLocations());

        this.apiViewModel.setState(apiState);

        viewManagerModel.setActiveView(displayingLocationsViewModel.getViewName());
        displayingLocationsViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
    }

    /**
     * This method displays an error if called as it implies that something went wrong during this ude case and the api
     * call has not returned any values
     *
     * @param error the string that contains the error message
     */
    @Override
    public void prepareFailView(String error) {
        ApiState apiState = apiViewModel.getState();
        apiState.setLocationError(error);
        apiViewModel.firePropertyChanged();
    }
}
