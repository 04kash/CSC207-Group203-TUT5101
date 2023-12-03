package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * Controller class responsible for executing the user signup use case.
 * This class acts as an interface adapter between the external system and the user signup use case.
 */
public class SignupController {

    /**
     * The input boundary for the user signup use case.
     */
    final SignupInputBoundary userSignupUseCaseInteractor;

    /**
     * Constructs a new SignupController with the specified SignupInputBoundary.
     *
     * @param userSignupUseCaseInteractor the input boundary for the user signup use case
     */
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the user signup use case with the provided parameters.
     *
     * @param username the username for the new user
     * @param password1 the first password for the new user
     */
    public void execute(String username, String password1) {
        SignupInputData signupInputData = new SignupInputData(username, password1);
        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
