package app;

import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.SignupUserDataAccessInterface;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.*;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.SignUp;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    private SignupUseCaseFactory() {}

    public static SignUp create(ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            SignupUserDataAccessInterface userDataAccessObject) {

        try {
            SignupController signupController =
                    createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);

            return new SignUp(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * This method creates a Sign up view that allows users to create an account so that they can save their desired
     * locations
     *
     * @param viewManagerModel this is the view manager model that is needed to create the controller for both the use
     *                         cases (sign up and log in)
     * @param signupViewModel this is the ViewModel that is specific to the signup use case and is needed to create the
     *                        signup view as well as the signup controller.
     * @param loginViewModel this is the ViewModel that is specific to the log in use case and is needed to create the
     *                       signup view as well as the log in controller
     * @param userDataAccessObject this is the data access interface that is used by the log in use case and is required
     *                             to create that use cases' controller
     * @return a Signup view
     */
    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel,
                                                            SignupViewModel signupViewModel,
                                                            LoginViewModel loginViewModel,
                                                            SignupUserDataAccessInterface userDataAccessObject) throws IOException {

        SignupOutputBoundary signupOutputBoundary =
                new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }
}

