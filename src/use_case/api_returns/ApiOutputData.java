package use_case.api_returns;

import entity.Coordinate;

public class ApiOutputData {
    public final String locationName;
    public final String filter;
    public final Coordinate proximityLocation;
    public final double proximityDistance;
    private boolean useCaseFailed;
    public ApiOutputData(String locationName, String filter, Coordinate proximityLocation, double proximityDistance, boolean useCaseFailed) {
        this.locationName = locationName;
        this.filter = filter;
        this.proximityLocation = proximityLocation;
        this.proximityDistance = proximityDistance;
        this.useCaseFailed = useCaseFailed;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getFilter() {
        return filter;
    }

    public Coordinate getProximityLocation() {
        return proximityLocation;
    }

    public double getProximityDistance() {
        return proximityDistance;
    }
}
