package use_case.login;

import data_access.JsonDataAccessObject;
import entity.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.login.*;

import java.io.IOException;

import static junit.framework.TestCase.*;

public class LoginInteractorTest {
    @Test
    public void successTest() {
        JsonDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new JsonDataAccessObject("./usersTest5.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LoginInputData inputData = new LoginInputData("akshaya", "password");
        LoginUserDataAccessInterface userRepository = userDataAccessObject;
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("akshaya", "password", new Planner());
        userRepository.save(user);
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertTrue(userRepository.existsByName("akshaya"));
                assertEquals("akshaya",user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failTest() {
        JsonDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new JsonDataAccessObject("./usersTest4.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LoginInputData inputData = new LoginInputData("akshaya", "password");
        LoginUserDataAccessInterface userRepository = userDataAccessObject;
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals( "akshaya: Account does not exist.", error);
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
    @Test
    public void failTest2() {
        JsonDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new JsonDataAccessObject("./usersTest3.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LoginInputData inputData = new LoginInputData("akshaya", "password");
        LoginUserDataAccessInterface userRepository = userDataAccessObject;
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("akshaya", "pwd", new Planner());
        userRepository.save(user);
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals( "Incorrect password for akshaya.", error);
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}
