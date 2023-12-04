package use_case.signup;

/**
 * This class represents the input data for a sign up use case
 */
public class SignupInputData {
    final private String username;
    final private String password;

    /**
     * Initializes the input data
     *
     * @param username the string containing the username
     * @param password the string containing the password
     */
    public SignupInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets back the username
     *
     * @return a string containing the username
     */
    String getUsername() {
        return username;
    }

    /**
     * Gets back the password
     *
     * @return a string containing the password
     */
    String getPassword() {
        return password;
    }
}
