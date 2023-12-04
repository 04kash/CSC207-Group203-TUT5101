package use_case.LocationsFromLabel;

/**
 * This interface defines the boundary for presenting output data related to retrieving locations from a label use case
 * operations. Implementing classes are responsible for preparing views based on the success or failure of the
 * interactions.
 */
public interface LocationsFromLabelOutputBoundary {
    /**
     * Prepares for a successful location from label use case operation, providing the relevant output data
     *
     * @param locations the output data in case of a successful operation
     */
    void prepareSuccessView(LocationsFromLabelOutputData locations);

    /**
     * Prepares for a failed location from label use case operation, providing an error message
     *
     * @param error the error message
     */
    void prepareFailView(String error);
}
