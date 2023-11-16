package use_case.api_returns;

import entity.Coordinate;

public class ApiInteractor implements ApiInputBoundary{
    final ApiUserDataAccessInterface userDataAccessObject;
    final ApiOutputBoundary apiPresenter;

    public ApiInteractor(ApiUserDataAccessInterface userDataAccessInterface, ApiOutputBoundary apiOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.apiPresenter = apiOutputBoundary;
    }

    @Override
    public void execute(ApiInputData apiInputData) {
        String location = apiInputData.getLocation();
        String filter = apiInputData.getFilter();
        Coordinate proximityLocation = apiInputData.getProximityLocation();
        double proximityDistance = apiInputData.getProximityDistance();

        ApiOutputData apiOutputData = new ApiOutputData(location, filter, proximityLocation, proximityDistance, false);
        apiPresenter.prepareSuccessView(apiOutputData);
    }
}
