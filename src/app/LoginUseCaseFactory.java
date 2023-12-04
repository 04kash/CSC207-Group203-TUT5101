//package app;
//
//import entity.CommonUserFactory;
//import entity.UserFactory;
//import interface_adapter.ViewManagerModel;
//import interface_adapter.api_returns.ApiViewModel;
//import interface_adapter.login.LoginController;
//import interface_adapter.login.LoginPresenter;
//import interface_adapter.login.LoginViewModel;
//import use_case.login.LoginInputBoundary;
//import use_case.login.LoginOutputBoundary;
//import use_case.login.LoginInteractor;
//import use_case.login.LoginUserDataAccessInterface;
//import view.LogInView;
//
//import javax.swing.*;
//import java.io.IOException;
//
//public class LoginUseCaseFactory {
//
//    /** Prevent instantiation. */
//    private LoginUseCaseFactory() {}
//
//    public static LogInView create(
//            ViewManagerModel viewManagerModel,
//            LoginViewModel loginViewModel,
//            ApiViewModel loggedInViewModel,
//            LoginUserDataAccessInterface userDataAccessObject) {
//
//        try {
//            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
//            return new LogInView(loginViewModel, loginController);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open user data file.");
//        }
//
//        return null;
//    }
//
//    private static LoginController createLoginUseCase(
//            ViewManagerModel viewManagerModel,
//            LoginViewModel loginViewModel,
//            ApiViewModel loggedInViewModel,
//            LoginUserDataAccessInterface userDataAccessObject) throws IOException {
//
//        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);
//
//        UserFactory userFactory = new CommonUserFactory();
//
//        LoginInputBoundary loginInteractor = new LoginInteractor(
//                userDataAccessObject, loginOutputBoundary);
//
//        return new LoginController(loginInteractor);
//    }
//}