package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.apiReturns.ApiViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginOutputData;

import static org.junit.jupiter.api.Assertions.*;

class LoginPresenterTest {
    LoginPresenter loginPresenter;
    LoginViewModel loginViewModel;
    ApiViewModel apiViewModel;
    @BeforeEach
    void unit(){
        loginViewModel = new LoginViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        apiViewModel = new ApiViewModel();
        loginPresenter = new LoginPresenter(viewManagerModel,apiViewModel,loginViewModel);
    }

    @Test
    void prepareSuccessView() {
        LoginOutputData loginOutputData = new LoginOutputData("Kashish",false);
        loginPresenter.prepareSuccessView(loginOutputData);
        assertEquals("Kashish",apiViewModel.getState().getUsername());
    }

    @Test
    void prepareFailView() {
        loginPresenter.prepareFailView("Error");
        assertEquals("Error",loginViewModel.getState().getUsernameError());
    }
}