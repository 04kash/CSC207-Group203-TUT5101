package interface_adapter.signup;

import interface_adapter.LocationsFromLabel.LocationsFromLabelPresenter;
import interface_adapter.LocationsFromLabel.LocationsFromLabelViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupOutputData;

import static org.junit.jupiter.api.Assertions.*;

class SignupPresenterTest {

    SignupPresenter signupPresenter;
    SignupViewModel signupViewModel;
    LoginViewModel loginViewModel;
    @BeforeEach
    void unit(){
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        signupPresenter = new SignupPresenter(viewManagerModel,signupViewModel,loginViewModel);
    }
    @Test
    void prepareSuccessView() {
        SignupOutputData signupOutputData = new SignupOutputData("Kashish",false);
        signupPresenter.prepareSuccessView(signupOutputData);
        assertEquals("Kashish",loginViewModel.getState().getUsername());
    }

    @Test
    void prepareFailView() {
        signupPresenter.prepareFailView("Error");
        assertEquals("Error",signupViewModel.getState().getUsernameError());
    }
}