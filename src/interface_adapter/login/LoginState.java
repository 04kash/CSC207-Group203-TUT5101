package interface_adapter.login;

/**
 * Represents the state associated with the login functionality.
 * This class holds information such as the entered username and password, as well as any associated errors.
 */
public class LoginState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;

    /**
     * Constructs a new LoginState by copying the contents of another instance.
     *
     * @param copy the LoginState instance to copy
     */
    public LoginState(LoginState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    /**
     * Default constructor for LoginState.
     * Since there is a copy constructor, the default constructor must be explicit.
     */
    public LoginState() {}

    /**
     * Gets the entered username.
     *
     * @return the entered username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets any error message associated with the entered username.
     *
     * @return the error message for the username
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Gets the entered password.
     *
     * @return the entered password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets any error message associated with the entered password.
     *
     * @return the error message for the password
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Sets the entered username.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets any error message associated with the entered username.
     *
     * @param usernameError the error message for the username
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the entered password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets any error message associated with the entered password.
     *
     * @param passwordError the error message for the password
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
}