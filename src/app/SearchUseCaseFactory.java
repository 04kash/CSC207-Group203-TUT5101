//package app;
//
//import interface_adapter.ViewManagerModel;
//import interface_adapter.api_returns.ApiController;
//import interface_adapter.api_returns.ApiPresenter;
//import interface_adapter.api_returns.ApiViewModel;
//import interface_adapter.displayingLabels.DisplayingLabelsController;
//import interface_adapter.displayingLabels.DisplayingLabelsPresenter;
//import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
//import interface_adapter.displayingLocations.DisplayingLocationsController;
//import interface_adapter.displayingLocations.DisplayingLocationsPresenter;
//import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
//import use_case.api_returns.ApiInputBoundary;
//import use_case.api_returns.ApiInteractor;
//import use_case.api_returns.ApiOutputBoundary;
//import use_case.api_returns.ApiUserDataAccessInterface;
//import use_case.displayingLabels.DisplayingLabelsInputBoundary;
//import use_case.displayingLabels.DisplayingLabelsInteractor;
//import use_case.displayingLabels.DisplayingLabelsOutputBoundary;
//import use_case.displayingLabels.DisplayingLabelsUserDataAccessInterface;
//import use_case.displayingLocations.DisplayingLocationsInputBoundary;
//import use_case.displayingLocations.DisplayingLocationsInteractor;
//import use_case.displayingLocations.DisplayingLocationsOutputBoundary;
//import use_case.displayingLocations.DisplayingLocationsUserDataAccessInterface;
//import view.SearchView;
//
//public class SearchUseCaseFactory {
//
//    private SearchUseCaseFactory() {
//    }
//
//    public static SearchView create(ViewManagerModel viewManagerModel, ApiViewModel apiViewModel, DisplayingLocationsViewModel displayingLocationsViewModel, ApiUserDataAccessInterface userDataAccessInterface, DisplayingLocationsUserDataAccessInterface userDataAccessInterface2, DisplayingLabelsViewModel displayingLabelsViewModel, DisplayingLabelsUserDataAccessInterface displayingLabelsUserDataAccessInterface) {
//        ApiController apiController = createApi(viewManagerModel, apiViewModel, displayingLocationsViewModel, userDataAccessInterface);
//        DisplayingLocationsController displayingLocationsController = createDisplayingLocation(viewManagerModel, displayingLocationsViewModel, userDataAccessInterface2);
//        DisplayingLabelsController displayingLabelsController = createDisplayingLabel(viewManagerModel,displayingLabelsViewModel,displayingLabelsUserDataAccessInterface);
//        return new SearchView(apiViewModel, apiController, displayingLocationsController, displayingLabelsController);
//    }
//
//    private static ApiController createApi(ViewManagerModel viewManagerModel, ApiViewModel apiViewModel, DisplayingLocationsViewModel displayingLocationsViewModel, ApiUserDataAccessInterface userDataAccessInterface) {
//        ApiOutputBoundary apiOutputBoundary = new ApiPresenter(apiViewModel, viewManagerModel, displayingLocationsViewModel);
//        ApiInputBoundary apiInputBoundary = new ApiInteractor(userDataAccessInterface, apiOutputBoundary);
//
//        return new ApiController(apiInputBoundary);
//    }
//
//    private static DisplayingLocationsController createDisplayingLocation(ViewManagerModel viewManagerModel, DisplayingLocationsViewModel displayingLocationsViewModel, DisplayingLocationsUserDataAccessInterface userDataAccessInterface) {
//        DisplayingLocationsOutputBoundary displayingLocationsOutputBoundary = new DisplayingLocationsPresenter(displayingLocationsViewModel, viewManagerModel);
//        DisplayingLocationsInputBoundary displayingLocationsInputBoundary = new DisplayingLocationsInteractor(userDataAccessInterface, displayingLocationsOutputBoundary);
//
//        return new DisplayingLocationsController(displayingLocationsInputBoundary);
//
//    }
//    private static DisplayingLabelsController createDisplayingLabel(ViewManagerModel viewManagerModel,DisplayingLabelsViewModel displayingLabelsViewModel,DisplayingLabelsUserDataAccessInterface displayingLabelsUserDataAccessInterface){
//        DisplayingLabelsOutputBoundary displayingLabelsOutputBoundary = new DisplayingLabelsPresenter(displayingLabelsViewModel,viewManagerModel);
//        DisplayingLabelsInputBoundary displayingLabelsInputBoundary = new DisplayingLabelsInteractor(displayingLabelsUserDataAccessInterface,displayingLabelsOutputBoundary);
//        return new DisplayingLabelsController(displayingLabelsInputBoundary);
//    }
//}
