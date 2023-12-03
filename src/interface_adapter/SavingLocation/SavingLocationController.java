package interface_adapter.SavingLocation;

import use_case.SavingLocation.SavingLocationInputBoundary;
import use_case.SavingLocation.SavingLocationInputData;

/**
 * Controller class responsible for executing the saving location use case.
 * This class acts as an interface adapter between the external system and the saving location use case.
 */
public class SavingLocationController {

    /**
     * The input boundary for the saving location use case.
     */
    final SavingLocationInputBoundary userSavingLocationInteractor;

    /**
     * Constructs a new SavingLocationController with the specified SavingLocationInputBoundary.
     *
     * @param userSavingLocationInteractor the input boundary for the saving location use case
     */
    public SavingLocationController(SavingLocationInputBoundary userSavingLocationInteractor) {
        this.userSavingLocationInteractor = userSavingLocationInteractor;
    }

    /**
     * Executes the saving location use case with the provided parameters.
     *
     * @param chosenLabel the label chosen for the location
     * @param locationName the name of the location
     * @param latitude the latitude of the location
     * @param longitude the longitude of the location
     * @param mapLink the map link associated with the location
     * @param filter the filter for the location
     */
    public void execute(String chosenLabel, String locationName, double latitude, double longitude, String mapLink, String filter) {
        SavingLocationInputData savingLocationInputData = new SavingLocationInputData(chosenLabel, locationName, latitude, longitude, mapLink, filter);
        userSavingLocationInteractor.execute(savingLocationInputData);
    }
}
