package interface_adapter.displayingLocations;

import entity.Location;

import java.util.ArrayList;

/**
 * Represents the state associated with the display of locations.
 * This class holds information such as the displayed locations and any potential location-related errors.
 */
public class DisplayingLocationsState {
    private static ArrayList<Location> locations = new ArrayList<>();
    private String locationError = "";

    /**
     * Default constructor for DisplayingLocationsState.
     */
    public DisplayingLocationsState() {}

    /**
     * Constructs a new DisplayingLocationsState by copying the contents of another instance.
     *
     * @param copy the DisplayingLocationsState instance to copy
     */
    public DisplayingLocationsState(DisplayingLocationsState copy) {
        locations = copy.locations;
        locationError = copy.locationError;
    }

    /**
     * Gets the list of locations to be displayed.
     *
     * @return the list of locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Sets the list of locations to be displayed.
     *
     * @param locations the list of locations to set
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Sets the error message related to location display.
     *
     * @param error the error message to set
     */
    public void setLocationError(String error) { this.locationError = error;}

    /**
     * Gets back the error message related to location display.
     *
     * @return the error message
     */
    public String getLocationError() {
        return locationError;
    }
}