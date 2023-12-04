package use_case.SavingLocation;

/**
 * This interface defines the boundary for presenting output data related to the saving locations use case operations.
 * Implementing classes are responsible for preparing views based on the success or failure of the interactions.
 */
public interface SavingLocationOutputBoundary {
    /**
     * Prepares for a successful saving location use case operation, providing the relevant output data
     *
     * @param success the string output data in case of a successful operation
     */
    void prepareSuccessView(String success);

    /**
     * Prepares for a failed saving location use case operation, providing an error message
     *
     * @param error the error message
     */
    void prepareFailView(String error);
}
