package interface_adapter.LocationsFromLabel;

import use_case.LocationsFromLabel.LocationsFromLabelInputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelInputData;

/**
 * Controller class responsible for executing the locations from label use case.
 * This class acts as an interface adapter between the external system and the use case.
 */
public class LocationsFromLabelController {

    /**
     * The input boundary for the locations from label use case.
     */
    final LocationsFromLabelInputBoundary locationsFromLabelInputBoundary;

    /**
     * Constructs a new LocationsFromLabelController with the specified LocationsFromLabelInputBoundary.
     *
     * @param locationsFromLabelInputBoundary the input boundary for the locations from label use case
     */
    public LocationsFromLabelController(LocationsFromLabelInputBoundary locationsFromLabelInputBoundary){
        this.locationsFromLabelInputBoundary = locationsFromLabelInputBoundary;
    }

    /**
     * Executes the locations from label use case with the provided chosen label.
     *
     * @param chosenLabel the label for which to retrieve locations
     */
    public void execute(String chosenLabel) {
        LocationsFromLabelInputData locationsFromLabelInputData = new LocationsFromLabelInputData(chosenLabel);
        locationsFromLabelInputBoundary.execute(locationsFromLabelInputData);
    }
}
