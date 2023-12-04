package use_case.signup;

import entity.Planner;
import entity.User;
import entity.UserFactory;

import java.util.HashMap;

/**
 * This class represents the interactor for handling the signup use case.
 * It implements the interface, defining the logic for processing signup input data.
 */
public class SignupInteractor implements SignupInputBoundary{
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    /**
     * Constructs a new instance of the signup interactor with specified data access object and output boundary
     *
     * @param signupDataAccessInterface the data access object for the signup use case data operations
     * @param signupOutputBoundary the output boundary for the signup use case related output data
     */
    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    /**
     * Executes the signup use case based on the provided input data
     *
     * @param signupInputData the input data for the use case operation
     */
    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else {
            Planner planner = new Planner();
            User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword(), planner);
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }


}
