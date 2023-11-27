package app;

import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.api_returns.ApiController;
import interface_adapter.api_returns.ApiPresenter;
import interface_adapter.api_returns.ApiViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsController;
import interface_adapter.displayingLocations.DisplayingLocationsPresenter;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import use_case.api_returns.ApiInputBoundary;
import use_case.api_returns.ApiInteractor;
import use_case.api_returns.ApiOutputBoundary;
import use_case.api_returns.ApiUserDataAccessInterface;
import use_case.displayingLocations.DisplayingLocationsInputBoundary;
import use_case.displayingLocations.DisplayingLocationsInteractor;
import use_case.displayingLocations.DisplayingLocationsOutputBoundary;
import use_case.displayingLocations.DisplayingLocationsUserDataAccessInterface;
import view.SearchView;
import view.ViewManager;

public class SearchUseCaseFactory {

    private SearchUseCaseFactory() {
    }

    public static SearchView create(ViewManagerModel viewManagerModel, ApiViewModel apiViewModel, DisplayingLocationsViewModel displayingLocationsViewModel, ApiUserDataAccessInterface userDataAccessInterface, DisplayingLocationsUserDataAccessInterface userDataAccessInterface2) {
        ApiController apiController = createSearchUser(viewManagerModel, apiViewModel, displayingLocationsViewModel, userDataAccessInterface);
        DisplayingLocationsController displayingLocationsController = createInstance(viewManagerModel, displayingLocationsViewModel, userDataAccessInterface2);
        return new SearchView(apiViewModel, apiController, displayingLocationsController);
    }

    private static ApiController createSearchUser(ViewManagerModel viewManagerModel, ApiViewModel apiViewModel, DisplayingLocationsViewModel displayingLocationsViewModel, ApiUserDataAccessInterface userDataAccessInterface) {
        ApiOutputBoundary apiOutputBoundary = new ApiPresenter(apiViewModel, viewManagerModel, displayingLocationsViewModel);
        ApiInputBoundary apiInputBoundary = new ApiInteractor(userDataAccessInterface, apiOutputBoundary);

        return new ApiController(apiInputBoundary);
    }

    private static DisplayingLocationsController createInstance(ViewManagerModel viewManagerModel, DisplayingLocationsViewModel displayingLocationsViewModel, DisplayingLocationsUserDataAccessInterface userDataAccessInterface) {
        DisplayingLocationsOutputBoundary displayingLocationsOutputBoundary = new DisplayingLocationsPresenter(displayingLocationsViewModel, viewManagerModel);
        DisplayingLocationsInputBoundary displayingLocationsInputBoundary = new DisplayingLocationsInteractor(userDataAccessInterface, displayingLocationsOutputBoundary);

        return new DisplayingLocationsController(displayingLocationsInputBoundary);

    }
}
