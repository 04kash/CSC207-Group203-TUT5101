package interface_adapter.LocationsFromLabel;

/**
 * Represents the state associated with the locations from label functionality.
 * This class holds information such as the displayed message related to retrieved locations.
 */
public class LocationsFromLabelState {
    private static String displayMsg = null;

    /**
     * Default constructor for LocationsFromLabelState.
     */
    public LocationsFromLabelState() {}

    /**
     * Constructs a new LocationsFromLabelState by copying the contents of another instance.
     *
     * @param copy the LocationsFromLabelState instance to copy
     */
    public LocationsFromLabelState(LocationsFromLabelState copy) {
        displayMsg = copy.displayMsg;
    }

    /**
     * Sets the displayed message related to retrieved locations.
     *
     * @param msg the message to set
     */
    public static void setDisplayMsg(String msg) {
        LocationsFromLabelState.displayMsg = msg;
    }

    /**
     * Gets the displayed message related to retrieved locations.
     *
     * @return the displayed message
     */
    public static String getDisplayMsg() {
        return displayMsg;
    }
}
