package interface_adapter.api_returns;

import entity.Coordinate;

public class ApiState {

    private String username = "";
    private String password = "";
    private String location = "";
    private String filter = "";
    private Coordinate proximityLocation = new Coordinate(0.0, 0.0);
    private double proximityDistance = 0.0;

    public ApiState(ApiState copy) {
        username = copy.username;
        password = copy.password;
        location = copy.location;
        filter = copy.filter;
        proximityLocation = copy.proximityLocation;
        proximityDistance = copy.proximityDistance;
    }

    public ApiState() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setProximityLocation(Coordinate proximityLocation) {
        this.proximityLocation = proximityLocation;
    }

    public void setProximityDistance(double proximityDistance) {
        this.proximityDistance = proximityDistance;
    }
}
