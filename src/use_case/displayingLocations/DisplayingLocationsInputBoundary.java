package use_case.displayingLocations;

/**
 * This interface defines the interface for use case to process displaying locations input data
 */
public interface DisplayingLocationsInputBoundary {

    /**
     * Executes the displayingLocation use case based on the provided input data
     *
     * @param displayingLocationsInputData The input data for the use case operation
     */
    void execute(DisplayingLocationsInputData  displayingLocationsInputData);
}
