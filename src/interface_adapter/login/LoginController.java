package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

/**
 * Controller class responsible for executing the login use case.
 * This class acts as an interface adapter between the external system and the login use case.
 */
public class LoginController {

    /**
     * The input boundary for the login use case.
     */
    final LoginInputBoundary loginUseCaseInteractor;

    /**
     * Constructs a new LoginController with the specified LoginInputBoundary.
     *
     * @param loginUseCaseInteractor the input boundary for the login use case
     */
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the login use case with the provided username and password.
     *
     * @param username the username for the login
     * @param password the password for the login
     */
    public void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(username, password);
        loginUseCaseInteractor.execute(loginInputData);
    }
}
