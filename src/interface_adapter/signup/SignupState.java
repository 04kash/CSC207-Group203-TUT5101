package interface_adapter.signup;

/**
 * State class representing the state of the signup functionality.
 * This class stores information such as the entered username, username error, entered password, and password error.
 */
public class SignupState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;

    /**
     * Constructs a new SignupState with the same state as the provided copy.
     *
     * @param copy the SignupState to copy the state from
     */
    public SignupState(SignupState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    /**
     * Default constructor. Because of the previous copy constructor, it must be explicit.
     */
    public SignupState() {
    }

    /**
     * Gets the entered username.
     *
     * @return the entered username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the error associated with the entered username.
     *
     * @return the username error
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
     * Gets the error associated with the entered password.
     *
     * @return the password error
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Sets the entered username.
     *
     * @param username the entered username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the error associated with the entered username.
     *
     * @param usernameError the username error to set
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the entered password.
     *
     * @param password the entered password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the error associated with the entered password.
     *
     * @param passwordError the password error to set
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * Returns a string representation of the SignupState.
     *
     * @return a string representation of the SignupState
     */
    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
