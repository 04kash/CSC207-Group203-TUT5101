package use_case.apiReturns;

import entity.Location;

import java.util.ArrayList;

public class ApiOutputData {
    public final ArrayList<Location> locations; //TODO: Can we use entities inside OutputData?
    private boolean useCaseFailed;
    public ApiOutputData(ArrayList<Location> locations, boolean useCaseFailed) {
        this.locations = locations;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
}
