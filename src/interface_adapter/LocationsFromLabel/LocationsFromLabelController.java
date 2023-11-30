package interface_adapter.LocationsFromLabel;

import use_case.LocationsFromLabel.LocationsFromLabelInputData;
import use_case.LocationsFromLabel.LocationsFromLabelInteractor;
import use_case.SavingLocation.SavingLocationInputBoundary;
import use_case.SavingLocation.SavingLocationInputData;

public class LocationsFromLabelController {
    final LocationsFromLabelInteractor locationsFromLabelInteractor;
    public LocationsFromLabelController(LocationsFromLabelInteractor locationsFromLabelInteractor){
        this.locationsFromLabelInteractor=locationsFromLabelInteractor;
    }
    public void execute(String chosenLabel){
        LocationsFromLabelInputData savingLocationInputData = new LocationsFromLabelInputData(chosenLabel);
        locationsFromLabelInteractor.execute(savingLocationInputData);
    }
}
