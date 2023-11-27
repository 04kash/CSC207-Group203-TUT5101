package use_case.displayingLocations;

import entity.Location;

import java.util.HashMap;

public interface DisplayingLocationsUserDataAccessInterface {
    public HashMap<String, Location> getAccounts();
}
