package app;

import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.api_returns.ApiController;
import interface_adapter.api_returns.ApiPresenter;
import interface_adapter.api_returns.ApiViewModel;
import use_case.api_returns.ApiInputBoundary;
import use_case.api_returns.ApiInteractor;
import use_case.api_returns.ApiOutputBoundary;
import use_case.api_returns.ApiUserDataAccessInterface;
import view.SearchView;

public class SearchUseCaseFactory {

    private SearchUseCaseFactory() {
    }

    public static SearchView create(ViewManagerModel viewManagerModel, ApiViewModel apiViewModel, ApiUserDataAccessInterface userDataAccessInterface) {
        ApiController apiController = createSearchUser(viewManagerModel, apiViewModel, userDataAccessInterface);
        return new SearchView(apiViewModel, apiController);
    }

    private static ApiController createSearchUser(ViewManagerModel viewManagerModel, ApiViewModel apiViewModel, ApiUserDataAccessInterface userDataAccessInterface) {
        ApiOutputBoundary apiOutputBoundary = new ApiPresenter(apiViewModel, viewManagerModel);
        ApiInputBoundary apiInputBoundary = new ApiInteractor(userDataAccessInterface, apiOutputBoundary);

        return new ApiController(apiInputBoundary);
    }
}
