package interface_adapter.apiReturns;

import entity.Location;

import java.util.ArrayList;

public class ApiState {

    private String username = "";
    private String password = "";
    private static ArrayList<Location> locations = new ArrayList<>();

    private String locationError = "";

    /**
     * This method initialises the api state by taking in a copy of the state and assigning its values to the variables
     *
     * @param copy the api state from which the values of variables are being copied
     */
    public ApiState(ApiState copy) {
        username = copy.username;
        password = copy.password;
        locations = copy.locations;
        locationError = copy.locationError;
    }

    public ApiState() {}

    /**
     * This method allows us to access the value of the private variable username
     *
     * @return a string which represents the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method allows us to access the value of the private variable password
     *
     * @return a string which represents the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method allows us to access the value of the private variable locations
     *
     * @return an array list of locations that contains all the locations from the users input
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * This method allows us to set a value of the private variable username
     *
     * @param username a string which the variable username is assigned to
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method allows us to set a value of the private variable password
     *
     * @param password a string which the variable password is assigned to
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method allows us to set a value of the private variable locations
     *
     * @param locations an array list of locations which the variable locations is assigned to
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * This method allows us to set a value of the the location error
     *
     * @param error a string which contains the error message
     */
    public void setLocationError(String error) { this.locationError = locationError;}
}