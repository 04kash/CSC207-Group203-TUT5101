package use_case.signup;

import entity.User;

/**
 * This interface defines methods for accessing user data related to signing up
 */
public interface SignupUserDataAccessInterface {

    /**
     * Informs on whether this username already exists in the database
     *
     * @param identifier the username that has been inputted
     * @return a boolean that is true if the username does exist, false otherwise
     */
    boolean existsByName(String identifier);

    /**
     * Save the user object to the database
     *
     * @param user the user object of the user that is signing up
     */
    void save(User user);
}
