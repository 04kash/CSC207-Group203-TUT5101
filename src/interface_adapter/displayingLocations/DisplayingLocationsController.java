package interface_adapter.displayingLocations;

import use_case.displayingLocations.DisplayingLocationsInputBoundary;
import use_case.displayingLocations.DisplayingLocationsInputData;

public class DisplayingLocationsController {
    final DisplayingLocationsInputBoundary displayingLocationsUseCaseInteractor;

    public DisplayingLocationsController(DisplayingLocationsInputBoundary displayingLocationsUseCaseInteractor) {
        this.displayingLocationsUseCaseInteractor = displayingLocationsUseCaseInteractor;
    }

    public void execute() {
        DisplayingLocationsInputData displayingLocationsInputData = new DisplayingLocationsInputData();
        displayingLocationsUseCaseInteractor.execute(displayingLocationsInputData);
    }
}
