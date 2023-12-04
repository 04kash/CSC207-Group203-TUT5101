package interface_adapter.login;

import interface_adapter.apiReturns.ApiState;
import interface_adapter.apiReturns.ApiViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import interface_adapter.ViewManagerModel;

/**
 * Presenter class responsible for preparing the view based on the outcomes of the login use case.
 * This class implements the LoginOutputBoundary interface to handle success and failure scenarios.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final ApiViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new LoginPresenter with the specified ViewManagerModel, ApiViewModel, and LoginViewModel.
     *
     * @param viewManagerModel the view manager model for handling overall view management
     * @param loggedInViewModel the view model associated with the logged-in state
     * @param loginViewModel the view model associated with the login functionality
     */
    public LoginPresenter(ViewManagerModel viewManagerModel,
                          ApiViewModel loggedInViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Prepares the view for a successful login attempt.
     *
     * @param response the output data containing information about the login attempt
     */
    @Override
    public void prepareSuccessView(LoginOutputData response) {
        ApiState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed login attempt.
     *
     * @param error a message indicating the failure of the login operation
     */
    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
