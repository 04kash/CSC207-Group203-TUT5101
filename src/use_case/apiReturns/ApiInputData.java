package use_case.apiReturns;

/**
 * This class represents the input data for an API use case.
 * Instances of this class are used to collect information required
 */
public class ApiInputData {

    private final String location;
    private final String filter;

    /**
     * Constructs a new instance of the output data with the specified location and filter parameters.
     *
     * @param location The location name that the users wishes to retrieve locations from
     * @param filter   The filter with which the user would like the returned locations to be based on
     */
    public ApiInputData(String location, String filter) {
        this.location = location;
        this.filter = filter;
    }

    /**
     * Retrieves the location parameter associated with the use case
     *
     * @return The location parameter.
     */
    String getLocation() {
        return location;
    }

    /**
     * Retrieves the filter parameter associated with the use case
     *
     * @return The filter parameter.
     */
    String getFilter() {
        return filter;
    }
}
