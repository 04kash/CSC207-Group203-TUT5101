package use_case.SavingLocation;

public class SavingLocationInputData {
    private String chosenLabel = "favourites";
    private String locationName;
    double latitude;
    double longitude;
    private String mapLink;
    private String filter;

    /**
     * Initializes the input data for the saving locations use case
     *
     * @param chosenLabel the string representing the label under which they want to save the location under
     * @param locationName the string representing the name of the location the user wishes to save
     * @param latitude the double representing the latitude of the location the user wishes to save
     * @param longitude the double representing the longitude of the location the user wishes to save
     * @param mapLink the string representing the osmlink of the location the user wishes to save
     * @param filter the string representing the filter associated with the location the user wishes to save
     */
    public SavingLocationInputData(String chosenLabel, String locationName, double latitude, double longitude, String mapLink, String filter) {
        this.chosenLabel = chosenLabel;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mapLink = mapLink;
        this.filter = filter;
    }

    /**
     * Get back the latitude of the location the user wishes to save
     *
     * @return a double
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Get back the longitude of the location the user wishes to save
     *
     * @return a double
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Get back the osmlink of the location the user wishes to save
     *
     * @return a string
     */
    public String getLink() {
        return mapLink;
    }

    /**
     * Get back the label under which the user wishes to save the location under
     *
     * @return a string
     */
    public String getChosenLabel() {
        return chosenLabel;
    }

    /**
     * Get back the filer associated wth the location the user wishes to save
     *
     * @return a string
     */
    public String getFilters() {
        return filter;
    }

    /**
     * Get back the name of the location the user wishes to save
     *
     * @return a string
     */
    public String getLocationName() {
        return locationName;
    }
}
