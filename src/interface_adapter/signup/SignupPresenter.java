package interface_adapter.signup;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;
import interface_adapter.ViewManagerModel;

/**
 * Presenter class responsible for preparing the view based on the outcomes of the user signup use case.
 * This class implements the SignupOutputBoundary interface to handle success and failure scenarios.
 */
public class SignupPresenter implements SignupOutputBoundary {
    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new SignupPresenter with the specified ViewManagerModel, SignupViewModel, and LoginViewModel.
     *
     * @param viewManagerModel the view manager model for handling overall view management
     * @param signupViewModel the view model associated with the signup functionality
     * @param loginViewModel the login view model to switch to on successful signup
     */
    public SignupPresenter(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Prepares the view for a successful user signup attempt.
     *
     * @param response the signup output data containing information about the successful signup
     */
    @Override
    public void prepareSuccessView(SignupOutputData response) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed user signup attempt.
     *
     * @param error a message indicating the failure of the user signup operation
     */
    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}
