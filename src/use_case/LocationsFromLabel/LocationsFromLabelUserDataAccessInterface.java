package use_case.LocationsFromLabel;

import entity.Label;
import entity.Location;

import java.util.ArrayList;

/**
 * This interface defines methods for accessing user data related to accessing the users saved locations from a particular label
 */
public interface LocationsFromLabelUserDataAccessInterface {
    /**
     * Get back an array list of locations based on a specific label in the user's planner
     *
     * @param username a string representing the username of the user
     * @param label a label object whose associated locations in the planner we want to retrieve
     * @return an array list of locations
     */
    ArrayList<Location> getLocationsFromLabel(String username,Label label);

    /**
     * Informs on whether that label exists in the users planner
     *
     * @param username a string containing the username of the user
     * @param label a label object whose associated locations in the planner we want to retrieve
     * @return a boolean on whether that label is in the planner
     */
    boolean labelExists(String username,Label label);

    /**
     * Gets back the username of the user currently running the program
     *
     * @return a string containing the username
     */
    String getCurrentUser();

    /**
     * Informs on whether there are any locations inside the label
     *
     * @param username a string containing the username of the user
     * @param label a label object whose associated locations in the planner we want to retrieve
     * @return a boolean on whether there are any locations associated with that label
     */
    boolean labelIsEmpty(String username,Label label);
}
