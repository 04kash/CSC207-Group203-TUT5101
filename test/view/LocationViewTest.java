package view;

import interface_adapter.SavingLocation.SavingLocationController;
import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsController;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;
import org.junit.jupiter.api.Test;
import use_case.SavingLocation.SavingLocationInputBoundary;
import use_case.SavingLocation.SavingLocationInputData;
import use_case.displayingLocations.DisplayingLocationsInputBoundary;
import use_case.displayingLocations.DisplayingLocationsInputData;

public class LocationViewTest {
    @Test
    public void testLocationView() {
        DisplayingLocationsInputBoundary dib = new DisplayingLocationsInputBoundary() {
            @Override
            public void execute(DisplayingLocationsInputData displayingLocationsInputData) {

            }
        };
        SavingLocationInputBoundary slib = new SavingLocationInputBoundary() {
            @Override
            public void execute(SavingLocationInputData savingLocationInputData) {

            }
        };
        DisplayingLocationsController controllerLocations = new DisplayingLocationsController(dib);
        DisplayingLocationsViewModel viewModelLocation = new DisplayingLocationsViewModel();
        SavingLocationController controller = new SavingLocationController(slib);
        SavingLocationViewModel savingLocationViewModel = new SavingLocationViewModel();
        DisplayingLabelsViewModel viewModelLabel = new DisplayingLabelsViewModel();
        LocationView locationView = new LocationView(viewModelLocation, controllerLocations, controller, viewModelLabel, savingLocationViewModel);

    }
}
