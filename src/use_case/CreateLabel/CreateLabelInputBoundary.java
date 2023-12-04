package use_case.CreateLabel;

/**
 * This interface defines the interface for use case to process creating labels input data use case
 */
public interface CreateLabelInputBoundary {
    /**
     * Executes the createLabel use case based on the provided input data
     *
     * @param createLabelInputData The input data for the use case operation
     */
    public void execute(CreateLabelInputData createLabelInputData);
}
