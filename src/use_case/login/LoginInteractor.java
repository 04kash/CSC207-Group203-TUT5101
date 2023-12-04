package use_case.login;

import entity.User;

/**
 * This class represents the interactor for handling the log in use case.
 * It implements the interface, defining the logic for processing log in input data.
 */
public class LoginInteractor implements LoginInputBoundary {
    final LoginUserDataAccessInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    /**
     * Constructs a new instance of the log in interactor with specified data access object and output boundary
     *
     * @param userDataAccessInterface the data access object for the log in use case data operations
     * @param loginOutputBoundary the output boundary for log in use case related output data
     */
    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    /**
     * Executes the log in use case based on the provided input data
     *
     * @param loginInputData the input data for the use case operation
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.get(loginInputData.getUsername());
                userDataAccessObject.setCurrentUser((loginInputData.getUsername()));
                LoginOutputData loginOutputData = new LoginOutputData(user.getUsername(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}
