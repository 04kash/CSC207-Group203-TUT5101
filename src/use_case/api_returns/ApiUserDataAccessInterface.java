package use_case.api_returns;

import entity.Location;
import entity.Proximity;

import java.util.ArrayList;

public interface ApiUserDataAccessInterface {
    public ArrayList<Location> getLocations(String cityName, Proximity proximity, String filter);

}
