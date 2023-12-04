package use_case.LocationsFromLabel;

import entity.Location;

import java.util.ArrayList;

/**
 * This class represents the output data of a locations from label use case operation
 */
public class LocationsFromLabelOutputData {
    private final ArrayList<Location> locations;
    private final boolean useCaseFailed;

    /**
     * Constructs an instance of the output data with the locations of the user from a specific label and the success or
     * failure status of the corresponding use case operation.
     *
     * @param locations the array list of locations from the users planner based on a specific label
     * @param useCaseFailed true if the corresponding use case operation has failed, false otherwise.
     */
    public LocationsFromLabelOutputData(ArrayList<Location> locations, boolean useCaseFailed) {
        this.locations = locations;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the array list of locations from a label retrieved from the user's planner
     *
     * @return the array list of locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }
}
