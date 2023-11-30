package use_case.displayingLocations;

import entity.Location;

import java.util.ArrayList;

public class DisplayingLocationsOutputData {
    public final ArrayList<Location> locations;
    private boolean useCaseFailed;
    public DisplayingLocationsOutputData(ArrayList<Location> locations, boolean useCaseFailed) {
        this.locations = locations;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
}
