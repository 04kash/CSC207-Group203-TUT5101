package use_case.SavingLocation;

import entity.*;

/**
 * This interface defines methods for accessing user data related to saving the users requested location
 */
public interface SavingLocationUserDataAccessInterface {

  /**
   * Adds the specified location to the users planner in the specified label
   *
   * @param username the string containing the users username
   * @param location the location object representing the location the user wishes to save
   * @param newLabel the label under which the user wishes to save the location
   */
  void addLocation(String username, Location location, Label newLabel);

  /**
   * Gets back whether this location already exists in the users planner
   *
   * @param username the string containing the users username
   * @param location the location object representing the location the user wishes to save
   * @return a boolean true if the location already exists, false otherwise
   */
  boolean locationExists(String username, Location location);

  /**
   * Gets the current users username back
   *
   * @return a string containing the username of the current user
   */
  String getCurrentUser();
}
