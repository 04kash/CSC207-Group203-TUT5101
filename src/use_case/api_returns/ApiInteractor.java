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
//        Proximity proximity = new Proximity(apiInputData.getProximityLocation(), apiInputData.getProximityDistance());
        ArrayList<Location> locations = userDataAccessObject.getLocations(apiInputData.getLocation(), apiInputData.getFilter());
//        userDataAccessObject.save(locations);
        ApiOutputData apiOutputData = new ApiOutputData(locations, false);
        apiPresenter.prepareSuccessView(apiOutputData);
    }
}
