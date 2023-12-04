//package app;
//
//import interface_adapter.CreateLabel.CreateLabelController;
//import interface_adapter.CreateLabel.CreateLabelPresenter;
//import interface_adapter.CreateLabel.CreateLabelViewModel;
//import interface_adapter.LocationsFromLabel.LocationsFromLabelController;
//import interface_adapter.LocationsFromLabel.LocationsFromLabelPresenter;
//import interface_adapter.LocationsFromLabel.LocationsFromLabelViewModel;
//import interface_adapter.ViewManagerModel;
//import interface_adapter.displayingLabels.DisplayingLabelsController;
//import interface_adapter.displayingLabels.DisplayingLabelsPresenter;
//import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
//import use_case.CreateLabel.CreateLabelDataAccessInterface;
//import use_case.CreateLabel.CreateLabelInputBoundary;
//import use_case.CreateLabel.CreateLabelInteractor;
//import use_case.CreateLabel.CreateLabelOutputBoundary;
//import use_case.LocationsFromLabel.LocationsFromLabelInputBoundary;
//import use_case.LocationsFromLabel.LocationsFromLabelInteractor;
//import use_case.LocationsFromLabel.LocationsFromLabelOutputBoundary;
//import use_case.LocationsFromLabel.LocationsFromLabelUserDataAccessInterface;
//import use_case.displayingLabels.DisplayingLabelsInputBoundary;
//import use_case.displayingLabels.DisplayingLabelsInteractor;
//import use_case.displayingLabels.DisplayingLabelsOutputBoundary;
//import use_case.displayingLabels.DisplayingLabelsUserDataAccessInterface;
//import view.PlannerView;
//
//public class PlannerUseCaseFactory {
//    private PlannerUseCaseFactory() {}
//
//    public static PlannerView create(ViewManagerModel viewManagerModel, DisplayingLabelsViewModel displayingLabelsViewModel, LocationsFromLabelViewModel locationsFromLabelViewModel, DisplayingLabelsUserDataAccessInterface userDataAccessInterface, LocationsFromLabelUserDataAccessInterface userDataAccessObject, CreateLabelViewModel createLabelViewModel, CreateLabelDataAccessInterface createLabelDataAccessObject) {
//        LocationsFromLabelController locationsFromLabelController = createLocationsfromLabel(viewManagerModel, locationsFromLabelViewModel, userDataAccessObject);
//        DisplayingLabelsController displayingLabelsController = createLabels(viewManagerModel, displayingLabelsViewModel, userDataAccessInterface);
//        CreateLabelController createLabelController = newLabels(createLabelViewModel,createLabelDataAccessObject);
//        return new PlannerView(displayingLabelsViewModel, displayingLabelsController, locationsFromLabelViewModel, locationsFromLabelController,createLabelController,createLabelViewModel);
//    }
//
//    public static LocationsFromLabelController createLocationsfromLabel(ViewManagerModel viewManagerModel, LocationsFromLabelViewModel locationsFromLabelViewModel, LocationsFromLabelUserDataAccessInterface userDataAccessInterface) {
//        LocationsFromLabelOutputBoundary locationsFromLabelOutputBoundary = new LocationsFromLabelPresenter(locationsFromLabelViewModel, viewManagerModel);
//        LocationsFromLabelInputBoundary locationsFromLabelInputBoundary = new LocationsFromLabelInteractor(userDataAccessInterface, locationsFromLabelOutputBoundary);
//        return new LocationsFromLabelController(locationsFromLabelInputBoundary);
//    }
//
//    public static DisplayingLabelsController createLabels(ViewManagerModel viewManagerModel, DisplayingLabelsViewModel displayingLabelsViewModel, DisplayingLabelsUserDataAccessInterface userDataAccessInterface) {
//        DisplayingLabelsOutputBoundary displayingLabelsOutputBoundary = new DisplayingLabelsPresenter(displayingLabelsViewModel, viewManagerModel);
//        DisplayingLabelsInputBoundary displayingLabelsInputBoundary = new DisplayingLabelsInteractor(userDataAccessInterface, displayingLabelsOutputBoundary);
//        return new DisplayingLabelsController(displayingLabelsInputBoundary);
//    }
//
//    public static CreateLabelController newLabels(CreateLabelViewModel createLabelViewModel, CreateLabelDataAccessInterface createLabelDataAccessInterface){
//        CreateLabelOutputBoundary createLabelOutputBoundary = new CreateLabelPresenter(createLabelViewModel);
//        CreateLabelInputBoundary createLabelInputBoundary = new CreateLabelInteractor(createLabelDataAccessInterface,createLabelOutputBoundary);
//        return new CreateLabelController(createLabelInputBoundary);
//    }
//}
