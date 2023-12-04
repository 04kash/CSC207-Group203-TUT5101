package use_case.LocationsFromLabel;

/**
 * This class represents the input data for a locations from label use case
 */
public class LocationsFromLabelInputData {
    final private String label;

    /**
     * Initializes the input data with the label name as a string
     *
     * @param label the string containing the label name from which we want to retrieve the locations
     */
    public LocationsFromLabelInputData(String label){
        this.label = label;
    }

    /**
     * Gets back the label name
     *
     * @return a string containing the label name
     */
    public String getLabel() {
        return label;
    }
}
