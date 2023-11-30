package interface_adapter.LocationsFromLabel;

import entity.Location;

import java.util.ArrayList;

public class LocationsFromLabelState {
    private static ArrayList<Location> location = new ArrayList<>();

    private String locationsError = "";

    public LocationsFromLabelState() {}

    public LocationsFromLabelState(LocationsFromLabelState copy) {
        location = copy.location;
        locationsError = copy.locationsError;
    }

    public static void setLocation(ArrayList<Location> location) {
        LocationsFromLabelState.location = location;
    }

    public void setLocationsError(String locationsError) {
        this.locationsError = locationsError;
    }

    public static ArrayList<Location> getLocation() {
        return location;
    }
}
