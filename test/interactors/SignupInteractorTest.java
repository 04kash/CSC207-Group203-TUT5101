package interactors;

import data_access.JsonDataAccessObject;
import entity.CommonUserFactory;
import entity.Planner;
import entity.User;
import entity.UserFactory;
import org.junit.Test;
import use_case.signup.*;

import java.io.IOException;

import static junit.framework.TestCase.*;

public class SignupInteractorTest {
    @Test
    public void successTest() {
        JsonDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new JsonDataAccessObject("./usersTest.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SignupInputData inputData = new SignupInputData("akshaya", "password");
        SignupUserDataAccessInterface userRepository = userDataAccessObject;
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                assertEquals("akshaya", user.getUsername());
                assertTrue(userRepository.existsByName("akshaya"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new CommonUserFactory());
        interactor.execute(inputData);
    }

    @Test
    public void FailTest() {
        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./usersTest2.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SignupInputData inputData = new SignupInputData("akshaya", "password");
        SignupUserDataAccessInterface userRepository = userDataAccessObject;

        // Add Paul to the repo so that when we check later they already exist
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("akshaya", "pwd", new Planner());
        userRepository.save(user);

        // This creates a presenter that tests whether the test case is as we expect.
        SignupOutputBoundary failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("User already exists.", error);
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, failurePresenter, new CommonUserFactory());
        interactor.execute(inputData);
    }
}
