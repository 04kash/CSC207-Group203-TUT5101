package use_case.signup;

/**
 * This interface defines the interface for use case to sign up from input data
 */
public interface SignupInputBoundary {
    /**
     * Executes the signup use case based on the provided input data
     *
     * @param signupInputData The input data for the use case operation
     */
    public void execute(SignupInputData signupInputData);
}
