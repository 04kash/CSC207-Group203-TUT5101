package use_case.login;

/**
 * This interface defines the boundary for presenting output data related to log in use case operations. Implementing
 * classes are responsible for preparing views based on the success or failure of the interactions.
 */
public interface LoginOutputBoundary {
    /**
     * Prepares for a successful log in use case operation, providing the relevant output data
     *
     * @param user the output data in case of a successful operation
     */
    void prepareSuccessView(LoginOutputData user);

    /**
     * Prepares for a failed log in use case operation, providing an error message
     *
     * @param error the error message
     */
    void prepareFailView(String error);
}
