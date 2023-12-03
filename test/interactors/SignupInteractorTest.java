package interactors;

import data_access.JsonDataAccessObject;
import entity.CommonUserFactory;
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
}
