package interface_adapter.displayingLocations;

import use_case.displayingLocations.DisplayingLocationsInputBoundary;
import use_case.displayingLocations.DisplayingLocationsInputData;

/**
 * Controller class responsible for executing the display locations use case.
 * This class acts as an interface adapter between the external system and the use case.
 */
public class DisplayingLocationsController {

    /**
     * The input boundary for the display locations use case.
     */
    final DisplayingLocationsInputBoundary displayingLocationsUseCaseInteractor;

    /**
     * Constructs a new DisplayingLocationsController with the specified DisplayingLocationsInputBoundary.
     *
     * @param displayingLocationsUseCaseInteractor the input boundary for the display locations use case
     */
    public DisplayingLocationsController(DisplayingLocationsInputBoundary displayingLocationsUseCaseInteractor) {
        this.displayingLocationsUseCaseInteractor = displayingLocationsUseCaseInteractor;
    }

    /**
     * Executes the display locations use case.
     */
    public void execute() {
        DisplayingLocationsInputData displayingLocationsInputData = new DisplayingLocationsInputData();
        displayingLocationsUseCaseInteractor.execute(displayingLocationsInputData);
    }
}
