package interface_adapter.LocationsFromLabel;

public class LocationsFromLabelState {
    private static String displayMsg = null;


    public LocationsFromLabelState() {}

    public LocationsFromLabelState(LocationsFromLabelState copy) {
        displayMsg = copy.displayMsg;
    }

    public static void setDisplayMsg(String msg) {
        LocationsFromLabelState.displayMsg = msg;
    }

    public static String getDisplayMsg() {
        return displayMsg;
    }
}
