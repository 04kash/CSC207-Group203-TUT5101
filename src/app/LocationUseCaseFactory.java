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

    /**
     * This method creates a Location view that displays information based on the user's input and also allows them to
     * save a location to their planner
     *
     * @param viewManagerModel this is the view manager model that is needed to create both the controllers
     *                         (displayingLocations and savingLocations)
     * @param displayingLabelsViewModel this is the ViewModel that is specific to the displayingLabels use case and
     *                                  is needed to create the Location view as the displaying labels controller
     * @param savingLocationViewModel this is the ViewModel that is specific to the savingLocations use case and is
     *                                needed to create the Location view as the saving locations controller
     * @param displayingLocationsViewModel this is the ViewModel that is specific to the displayingLocations use case and
     *                                     is needed to create the Location view as the displaying locations controller
     * @param userDataAccessInterface this is the data access interface that is used by the displaying labels use case
     *                                and is required to create that use cases' controller
     * @param userDataAccessInterface2 this is the data access interface that is used by the saving locations use case
     *                                 and is required to create that use cases' controller
     * @return a Location view
     */
    public static LocationView create(ViewManagerModel viewManagerModel,
                                      DisplayingLocationsViewModel displayingLocationsViewModel,
                                      SavingLocationViewModel savingLocationViewModel,
                                      DisplayingLabelsViewModel displayingLabelsViewModel,
                                      DisplayingLocationsUserDataAccessInterface userDataAccessInterface,
                                      SavingLocationUserDataAccessInterface userDataAccessInterface2) {
        DisplayingLocationsController displayingLocationsController =
                createLocation(viewManagerModel, displayingLocationsViewModel, userDataAccessInterface);
        SavingLocationController savingLocationController =
                createSavingLocation(viewManagerModel, savingLocationViewModel, userDataAccessInterface2);

        return new LocationView(displayingLocationsViewModel,
                displayingLocationsController,
                savingLocationController,
                displayingLabelsViewModel,
                savingLocationViewModel);
    }

    private static DisplayingLocationsController createLocation(ViewManagerModel viewManagerModel,
                                                               DisplayingLocationsViewModel displayingLocationsViewModel,
                                                               DisplayingLocationsUserDataAccessInterface userDataAccessInterface) {
        DisplayingLocationsOutputBoundary displayingLocationsOutputBoundary =
                new DisplayingLocationsPresenter(displayingLocationsViewModel, viewManagerModel);
        DisplayingLocationsInputBoundary displayingLocationsInputBoundary =
                new DisplayingLocationsInteractor(userDataAccessInterface, displayingLocationsOutputBoundary);

        return new DisplayingLocationsController(displayingLocationsInputBoundary);
    }

    private static SavingLocationController createSavingLocation(ViewManagerModel viewManagerModel,
                                                                 SavingLocationViewModel savingLocationViewModel,
                                                                 SavingLocationUserDataAccessInterface userDataAccessInterface) {
        SavingLocationOutputBoundary savingLocationOutputBoundary =
                new SavingLocationPresenter(savingLocationViewModel, viewManagerModel);
        SavingLocationInputBoundary savingLocationInputBoundary =
                new SavingLocationInteractor(userDataAccessInterface, savingLocationOutputBoundary);

        return new SavingLocationController(savingLocationInputBoundary);
    }
}
