package use_case.CreateLabel;

/**
 * This interface defines the boundary for presenting output data related to the create labels use case operations.
 * Implementing classes are responsible for preparing views based on the success or failure of the interactions.
 */
public interface CreateLabelOutputBoundary {
    /**
     * Prepares for a failed create label use case operation, providing an error message
     *
     * @param error the error message
     */
    void prepareFailView(String error);

    /**
     * Prepares for a successful create label use case operation, providing the relevant output data
     *
     * @param success the message to be displayed in case of a successful operation
     */
    void prepareSuccessView(String success);
}
