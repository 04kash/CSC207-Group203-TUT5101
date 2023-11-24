package use_case.api_returns;

import entity.Location;

import java.util.ArrayList;

public interface ApiUserDataAccessInterface {
    public ArrayList<Location> getLocations(String cityName, String filter);

}
