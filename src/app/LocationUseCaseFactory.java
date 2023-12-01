package app;

import interface_adapter.SavingLocation.SavingLocationController;
import interface_adapter.SavingLocation.SavingLocationPresenter;
import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsController;
import interface_adapter.displayingLocations.DisplayingLocationsPresenter;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import use_case.SavingLocation.SavingLocationInputBoundary;
import use_case.SavingLocation.SavingLocationInteractor;
import use_case.SavingLocation.SavingLocationOutputBoundary;
import use_case.SavingLocation.SavingLocationUserDataAccessInterface;
import use_case.displayingLocations.DisplayingLocationsInputBoundary;
import use_case.displayingLocations.DisplayingLocationsInteractor;
import use_case.displayingLocations.DisplayingLocationsOutputBoundary;
import use_case.displayingLocations.DisplayingLocationsUserDataAccessInterface;
import view.LocationView;

public class LocationUseCaseFactory {

    private LocationUseCaseFactory() {}

    public static LocationView create(ViewManagerModel viewManagerModel, DisplayingLocationsViewModel displayingLocationsViewModel, SavingLocationViewModel savingLocationViewModel, DisplayingLabelsViewModel displayingLabelsViewModel, DisplayingLocationsUserDataAccessInterface userDataAccessInterface, SavingLocationUserDataAccessInterface userDataAccessInterface2) {
        DisplayingLocationsController displayingLocationsController = createLocationUser(viewManagerModel, displayingLocationsViewModel, userDataAccessInterface);
        SavingLocationController savingLocationController = createInstance(viewManagerModel, savingLocationViewModel, userDataAccessInterface2);
        return new LocationView(displayingLocationsViewModel, displayingLocationsController, savingLocationController,displayingLabelsViewModel);
    }

    public static DisplayingLocationsController createLocationUser(ViewManagerModel viewManagerModel, DisplayingLocationsViewModel displayingLocationsViewModel, DisplayingLocationsUserDataAccessInterface userDataAccessInterface) {
        DisplayingLocationsOutputBoundary displayingLocationsOutputBoundary = new DisplayingLocationsPresenter(displayingLocationsViewModel, viewManagerModel);
        DisplayingLocationsInputBoundary displayingLocationsInputBoundary = new DisplayingLocationsInteractor(userDataAccessInterface, displayingLocationsOutputBoundary);

        return new DisplayingLocationsController(displayingLocationsInputBoundary);
    }

    public static SavingLocationController createInstance(ViewManagerModel viewManagerModel, SavingLocationViewModel savingLocationViewModel, SavingLocationUserDataAccessInterface userDataAccessInterface) {
        SavingLocationOutputBoundary savingLocationOutputBoundary = new SavingLocationPresenter(savingLocationViewModel, viewManagerModel);
        SavingLocationInputBoundary savingLocationInputBoundary = new SavingLocationInteractor(userDataAccessInterface, savingLocationOutputBoundary);

        return new SavingLocationController(savingLocationInputBoundary);
    }
}
