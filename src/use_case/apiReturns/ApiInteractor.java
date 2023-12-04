package use_case.apiReturns;

import entity.Location;

import java.util.ArrayList;

/**
 * This class represents the interactor for handling the API use case.
 * It implements the interface, defining the logic for processing API input data.
 */
public class ApiInteractor implements ApiInputBoundary {

    private final ApiUserDataAccessInterface userDataAccessObject;
    private final ApiOutputBoundary apiPresenter;

    /**
     * Constructs a new instance of the API interactor with the specified data access object and output boundary.
     *
     * @param userDataAccessInterface The data access object for API use case data operations.
     * @param apiOutputBoundary      The output boundary for presenting API use case related output data.
     */
    public ApiInteractor(ApiUserDataAccessInterface userDataAccessInterface, ApiOutputBoundary apiOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.apiPresenter = apiOutputBoundary;
    }

    /**
     * Executes the API use case based on the provided input data.
     * Retrieves locations, saves them using the data access object, and prepares the output data for presentation using
     * the output boundary.
     *
     * @param apiInputData The input data for the API use case operation
     */
    @Override
    public void execute(ApiInputData apiInputData) {
        ArrayList<Location> locations = userDataAccessObject.getLocations(apiInputData.getLocation(), apiInputData.getFilter());
        userDataAccessObject.save(locations);
        ApiOutputData apiOutputData = new ApiOutputData(locations, false);
        apiPresenter.prepareSuccessView(apiOutputData);
    }
}
