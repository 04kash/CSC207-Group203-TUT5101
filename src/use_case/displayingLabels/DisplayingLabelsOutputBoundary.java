package use_case.displayingLabels;

/**
 * This interface defines the boundary for presenting output data related to the display labels use case operations.
 * Implementing classes are responsible for preparing views based on the success or failure of the interactions.
 */
public interface DisplayingLabelsOutputBoundary {
    /**
     * Prepares for a successful display label use case operation, providing the relevant output data
     *
     * @param displayingLabelsOutputData the output data in case of a successful operation
     */
    void prepareSuccessView(DisplayingLabelsOutputData displayingLabelsOutputData);

    /**
     * Prepares for a failed display label use case operation, providing an error message
     *
     * @param error the error message
     */
    void prepareFailView(String error);
}
