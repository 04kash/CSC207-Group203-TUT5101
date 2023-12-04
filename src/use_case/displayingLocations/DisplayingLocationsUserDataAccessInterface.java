package use_case.displayingLocations;

import entity.Location;

import java.util.HashMap;

/**
 * This interface defines methods for accessing user data related to displaying the users saved locations
 */
public interface DisplayingLocationsUserDataAccessInterface {
    /**
     * Get the users accounts which details their saved locations
     *
     * @return a hash map containing the location name as the key and a location object as its associated value
     */
    public HashMap<String, Location> getAccounts();
}
