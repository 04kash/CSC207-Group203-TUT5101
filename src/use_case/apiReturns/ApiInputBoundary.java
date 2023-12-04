package use_case.apiReturns;

/**
 * This interface defines the interface for use case to process API input data and saves a list of the locations saved
 * from the API call
 */
public interface ApiInputBoundary {

    /**
     * Executes the API use case logic based on the provided input data.
     *
     * @param apiInputData The input data for the use case operation.
     */
    void execute(ApiInputData apiInputData);
}
