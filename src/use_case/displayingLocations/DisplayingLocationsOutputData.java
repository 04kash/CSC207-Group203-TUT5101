package use_case.displayingLocations;

import entity.Location;

import java.util.ArrayList;

/**
 * This class represents the output data of a display locations use case operation
 */
public class DisplayingLocationsOutputData {
    private final ArrayList<Location> locations;
    private boolean useCaseFailed;

    /**
     * Constructs an instance of the output data with the locations of the user and the success or failure status of the
     * corresponding use case operation.
     *
     * @param locations the array list of locations from the users search request
     * @param useCaseFailed true if the corresponding use case operation has failed, false otherwise.
     */
    public DisplayingLocationsOutputData(ArrayList<Location> locations, boolean useCaseFailed) {
        this.locations = locations;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the array list of locations retrieved from the user's search request
     *
     * @return the array list of locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }
}
