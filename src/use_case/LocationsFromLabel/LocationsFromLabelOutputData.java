package use_case.LocationsFromLabel;

import entity.Location;

import java.util.ArrayList;

public class LocationsFromLabelOutputData {
    public final ArrayList<Location> locations;
    private final boolean useCaseFailed;

    public LocationsFromLabelOutputData(ArrayList<Location> locations, boolean useCaseFailed) {
        this.locations = locations;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
}
