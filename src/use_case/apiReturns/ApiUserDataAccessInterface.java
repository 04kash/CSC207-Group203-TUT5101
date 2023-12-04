package use_case.apiReturns;

import entity.Location;

import java.util.ArrayList;

/**
 * This interface defines methods for accessing user data related to the locations retrieved by an API call.
 */
public interface ApiUserDataAccessInterface {

    /**
     * Retrieves a list of locations based on the specified city name and filter.
     *
     * @param cityName The name of the city for which locations are to be retrieved.
     * @param filter   A filter to narrow down the locations, if applicable.
     * @return An ArrayList of locations matching the specified criteria.
     */
    ArrayList<Location> getLocations(String cityName, String filter);

    /**
     * Saves the provided list of locations.
     *
     * @param locations The list of locations to be saved.
     */
    void save(ArrayList<Location> locations);

}
