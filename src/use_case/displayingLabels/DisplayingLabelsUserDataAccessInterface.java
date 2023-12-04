package use_case.displayingLabels;

import entity.User;

/**
 * This interface defines methods for accessing user data related to displaying the users saved labels
 */
public interface DisplayingLabelsUserDataAccessInterface {

    /**
     * Get the user object from the username
     *
     * @param username the user's username
     * @return the user object associated with that username
     */
    public User get(String username);

    /**
     * Get back the username of the user currently running the program
     *
     * @return a string that represents the username of the user
     */
    public String getCurrentUser();
}
