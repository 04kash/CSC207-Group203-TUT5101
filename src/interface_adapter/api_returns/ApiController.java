package interface_adapter.api_returns;

import entity.Coordinate;
import use_case.api_returns.ApiInputBoundary;
import use_case.api_returns.ApiInputData;

public class ApiController {
    final ApiInputBoundary apiUseCaseInteractor;

    public ApiController(ApiInputBoundary apiUseCaseInteractor) {
        this.apiUseCaseInteractor = apiUseCaseInteractor;
    }

    public void execute(String location, String filter) {
        ApiInputData apiInputData = new ApiInputData(location, filter);

        apiUseCaseInteractor.execute(apiInputData);
    }
}
