package interface_adapter.LocationsFromLabel;

import use_case.LocationsFromLabel.LocationsFromLabelInputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelInputData;
import use_case.LocationsFromLabel.LocationsFromLabelInteractor;
import use_case.SavingLocation.SavingLocationInputBoundary;
import use_case.SavingLocation.SavingLocationInputData;

public class LocationsFromLabelController {
    final LocationsFromLabelInputBoundary locationsFromLabelInputBoundary;
    public LocationsFromLabelController(LocationsFromLabelInputBoundary locationsFromLabelInputBoundary){
        this.locationsFromLabelInputBoundary = locationsFromLabelInputBoundary;
    }
    public void execute(String chosenLabel){
        LocationsFromLabelInputData savingLocationInputData = new LocationsFromLabelInputData(chosenLabel);
        locationsFromLabelInputBoundary.execute(savingLocationInputData);
    }
}
