package use_case.displayingLabels;

/**
 * This interface defines the interface for use case to process displaying labels input data use case
 */
public interface DisplayingLabelsInputBoundary {
    /**
     * Executes the displayingLabel use case based on the provided input data
     *
     * @param displayingLabelsInputData The input data for the use case operation
     */
    void execute(DisplayingLabelsInputData displayingLabelsInputData);
}
