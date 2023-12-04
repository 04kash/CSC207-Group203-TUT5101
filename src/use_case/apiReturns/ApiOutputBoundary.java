package use_case.apiReturns;

/**
 * This interface defines the boundary for presenting output data related to the API use case operations. Implementing
 * classes are responsible for preparing views based on the success or failure of the interactions.
 */
public interface ApiOutputBoundary {

    /**
     * Prepares the view for a successful API use case operation, providing the relevant output data.
     *
     * @param apiOutputData The output data for a successful API use case operation.
     */
    void prepareSuccessView(ApiOutputData apiOutputData);

    /**
     * Prepares the view for a failed API use case operation, providing an error message.
     *
     * @param error The error message describing the cause of the API use case operation failure.
     */
    void prepareFailView(String error);
}
