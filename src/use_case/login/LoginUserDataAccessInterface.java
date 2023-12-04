package use_case.login;

import entity.User;

/**
 * This interface defines methods for accessing user data related to logging in
 */
public interface LoginUserDataAccessInterface {

    /**
     * Informs on whether this username exists in the database
     *
     * @param identifier the username that has been inputted
     * @return a boolean that is true if the username does exist, false otherwise
     */
    boolean existsByName(String identifier);

    /**
     * Save the user object to the database
     *
     * @param user the user object of the user that is logging in
     */
    void save(User user);

    /**
     * Get back the User object of the user based on their username
     *
     * @param username the string containing the username of the user
     * @return a user object
     */
    User get(String username);

    /**
     * Sets the value of the current user as the user currently logging in
     *
     * @param username the string containing the username of the user logging in
     */
    void setCurrentUser(String username);
}
