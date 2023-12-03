package use_case.apiReturns;

import entity.Location;

import java.util.ArrayList;

public interface ApiUserDataAccessInterface {
    public ArrayList<Location> getLocations(String cityName, String filter);

    public void save(ArrayList<Location> locations);

}
