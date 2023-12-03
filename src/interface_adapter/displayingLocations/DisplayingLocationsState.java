package interface_adapter.displayingLocations;

import entity.Location;

import java.util.ArrayList;

public class DisplayingLocationsState {
    private static ArrayList<Location> locations = new ArrayList<>();

    private String locationError = "";

    public DisplayingLocationsState() {}
    public DisplayingLocationsState(DisplayingLocationsState copy) {
        locations = copy.locations;
        locationError = copy.locationError;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public void setLocationError(String error) { this.locationError = error;}
}
