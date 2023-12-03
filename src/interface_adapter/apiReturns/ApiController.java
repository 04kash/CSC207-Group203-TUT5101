package interface_adapter.apiReturns;

import use_case.apiReturns.ApiInputBoundary;
import use_case.apiReturns.ApiInputData;

public class ApiController {
    final ApiInputBoundary apiUseCaseInteractor;

    /**
     * This method initializes the api controller and sets the value of the api interactor
     *
     * @param apiUseCaseInteractor the api input boundary
     */
    public ApiController(ApiInputBoundary apiUseCaseInteractor) {
        this.apiUseCaseInteractor = apiUseCaseInteractor;
    }

    /**
     * This method executes the entire api use case by executing the input boundary with the input data
     *
     * @param location a string which contains the location name that the user wishes to receive locations on
     * @param filter a string which contains the filter that the user wishes the locations to be sorted on
     */
    public void execute(String location, String filter) {
        ApiInputData apiInputData = new ApiInputData(location, filter);

        apiUseCaseInteractor.execute(apiInputData);
    }
}
