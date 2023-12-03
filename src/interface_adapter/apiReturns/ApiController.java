package interface_adapter.apiReturns;

import use_case.apiReturns.ApiInputBoundary;
import use_case.apiReturns.ApiInputData;

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
