package use_case.login;

/**
 * This class represents the output data of a login use case operation
 */
public class LoginOutputData {
    private final String username;
    private boolean useCaseFailed;

    /**
     * Constructs an instance of the output data with the username of the user logging in and the success or failure
     * status of the corresponding use case operation.
     *
     * @param username the string containing the username of the user currently logging in
     * @param useCaseFailed true if the corresponding use case operation has failed, false otherwise.
     */
    public LoginOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Get the username of the user back
     *
     * @return a string containing the username
     */
    public String getUsername() {
        return username;
    }
}
