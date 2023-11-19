package interface_adapter.api_returns;

import entity.City;
import entity.Coordinate;
import entity.Location;

import java.util.ArrayList;

public class ApiState {

    private String username = "";
    private String password = "";
    private ArrayList<Location> locations = new ArrayList<Location>();

    private String locationError = "";

    public ApiState(ApiState copy) {
        username = copy.username;
        password = copy.password;
        locations = copy.locations;
        locationError = copy.locationError;
    }

    public ApiState() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public void setLocationError(String error) { this.locationError = locationError;}
}
