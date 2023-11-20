package use_case.api_returns;

import entity.City;
import entity.Coordinate;
import entity.Location;

import java.util.ArrayList;

public class ApiInteractor implements ApiInputBoundary{
    final ApiUserDataAccessInterface userDataAccessObject;
    final ApiOutputBoundary apiPresenter;

    public ApiInteractor(ApiUserDataAccessInterface userDataAccessInterface, ApiOutputBoundary apiOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.apiPresenter = apiOutputBoundary;
    }

    @Override
    public void execute(ApiInputData apiInputData) {
        ArrayList<Location> locations = userDataAccessObject.getLocations(apiInputData.getLocation(), apiInputData.getProximityDistance(), apiInputData.getFilter());

        ApiOutputData apiOutputData = new ApiOutputData(locations, false);
        apiPresenter.prepareSuccessView(apiOutputData);
    }
}
