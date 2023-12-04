package use_case.SavingLocation;

/**
 * This interface defines the interface for use case to process saving locations input data
 */
public interface SavingLocationInputBoundary {

    /**
     * Executes the savingLocation use case based on the provided input data
     *
     * @param savingLocationInputData The input data for the use case operation
     */
    public void execute(SavingLocationInputData savingLocationInputData);
}
