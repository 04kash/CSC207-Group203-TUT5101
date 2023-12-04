package use_case.login;

/**
 * This class represents the input data for a log in use case
 */
public class LoginInputData {
    final private String username;
    final private String password;

    /**
     * Initializes the input data
     *
     * @param username the string containing the username
     * @param password the string containing the password
     */
    public LoginInputData(String username, String password) {
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
