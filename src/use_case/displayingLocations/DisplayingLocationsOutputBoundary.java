package use_case.displayingLocations;

/**
 * This interface defines the boundary for presenting output data related to the display locations use case operations.
 * Implementing classes are responsible for preparing views based on the success or failure of the interactions.
 */
public interface DisplayingLocationsOutputBoundary {
    /**
     * Prepares for a successful display location use case operation, providing the relevant output data
     *
     * @param displayingLocationsOutputData the output data in case of a successful operation
     */
    void prepareSuccessView(DisplayingLocationsOutputData displayingLocationsOutputData);

    /**
     * Prepares for a failed display location use case operation, providing an error message
     *
     * @param error the error message
     */
    void prepareFailView(String error);
}
