package use_case.apiReturns;

import entity.Location;

import java.util.ArrayList;

/**
 * This class represents the output data of an API use case operation, providing information about the locations and the
 * success or failure status of the operation.
 */
public class ApiOutputData {

    /**
     * The list of locations retrieved or affected by the API operation.
     */
    private final ArrayList<Location> locations;

    private boolean useCaseFailed;

    /**
     * Constructs an instance of the output data with the specified locations and the success or failure status of the
     * corresponding use case operation.
     *
     * @param locations     The list of locations retrieved by the API call
     * @param useCaseFailed true if the corresponding use case operation has failed, false otherwise.
     */
    public ApiOutputData(ArrayList<Location> locations, boolean useCaseFailed) {
        this.locations = locations;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the list of locations retrieved by the API call
     *
     * @return The list of locations.
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }
}
