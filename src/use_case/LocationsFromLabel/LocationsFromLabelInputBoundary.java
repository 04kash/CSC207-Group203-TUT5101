package use_case.LocationsFromLabel;

/**
 * This interface defines the interface for use case to process locations from label input data
 */
public interface LocationsFromLabelInputBoundary {

    /**
     * Executes the locationsFromLabel use case based on the provided input data
     *
     * @param locationsFromLabelInputData The input data for the use case operation
     */
    void execute(LocationsFromLabelInputData locationsFromLabelInputData);
}
