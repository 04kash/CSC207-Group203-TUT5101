package use_case.login;

/**
 * This interface defines the interface for use case to log in from input data
 */
public interface LoginInputBoundary {
    /**
     * Executes the login use case based on the provided input data
     *
     * @param loginInputData The input data for the use case operation
     */
    void execute(LoginInputData loginInputData);
}