package use_case.signup;

/**
 * This interface defines the boundary for presenting output data related to signup use case operations. Implementing
 * classes are responsible for preparing views based on the success or failure of the interactions.
 */
public interface SignupOutputBoundary {
    /**
     * Prepares for a successful signup use case operation, providing the relevant output data
     *
     * @param user the output data in case of a successful operation
     */
    void prepareSuccessView(SignupOutputData user);

    /**
     * Prepares for a failed signup use case operation, providing an error message
     *
     * @param error the error message
     */
    void prepareFailView(String error);
}
