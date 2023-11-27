package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.displayingLocations.DisplayingLocationsController;
import interface_adapter.displayingLocations.DisplayingLocationsPresenter;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import use_case.displayingLocations.DisplayingLocationsInputBoundary;
import use_case.displayingLocations.DisplayingLocationsInteractor;
import use_case.displayingLocations.DisplayingLocationsOutputBoundary;
import use_case.displayingLocations.DisplayingLocationsUserDataAccessInterface;
import view.LocationView;

public class LocationUseCaseFactory {

    private LocationUseCaseFactory() {}

    public static LocationView create(ViewManagerModel viewManagerModel, DisplayingLocationsViewModel displayingLocationsViewModel, DisplayingLocationsUserDataAccessInterface userDataAccessInterface) {
        DisplayingLocationsController displayingLocationsController = createLocationUser(viewManagerModel, displayingLocationsViewModel, userDataAccessInterface);
        return new LocationView(displayingLocationsViewModel, displayingLocationsController);
    }

    public static DisplayingLocationsController createLocationUser(ViewManagerModel viewManagerModel, DisplayingLocationsViewModel displayingLocationsViewModel, DisplayingLocationsUserDataAccessInterface userDataAccessInterface) {
        DisplayingLocationsOutputBoundary displayingLocationsOutputBoundary = new DisplayingLocationsPresenter(displayingLocationsViewModel, viewManagerModel);
        DisplayingLocationsInputBoundary displayingLocationsInputBoundary = new DisplayingLocationsInteractor(userDataAccessInterface, displayingLocationsOutputBoundary);

        return new DisplayingLocationsController(displayingLocationsInputBoundary);
    }
}
