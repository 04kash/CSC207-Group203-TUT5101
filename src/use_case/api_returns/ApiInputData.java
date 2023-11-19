package use_case.api_returns;

import entity.City;
import entity.Coordinate;

public class ApiInputData {
    final private String location;
    final private String filter;
    final private Coordinate proximityLocation;
    final private double proximityDistance;

    public ApiInputData(String location, String filter,Coordinate proximityLocation,double proximityDistance) {
        this.location = location;
        this.filter = filter;
        this.proximityLocation = proximityLocation;
        this.proximityDistance = proximityDistance;
    }

    String getLocation() {
        return location;
    }

    String getFilter() {
        return filter;
    }

    Coordinate getProximityLocation() {
        return proximityLocation;
    }

    double getProximityDistance() {
        return proximityDistance;
    }
}
