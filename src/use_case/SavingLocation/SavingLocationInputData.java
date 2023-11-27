package use_case.SavingLocation;

public class SavingLocationInputData {
    final private String username;
    private String chosenLabel = "favourites";
    String locationName;
    double latitude;
    double longitude;
    String mapLink;
    String filter;

    public SavingLocationInputData(String username, String chosenLabel, String locationName, double latitude, double longitude, String mapLink, String filter) {
        this.username = username;
        this.chosenLabel = chosenLabel;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mapLink = mapLink;
        this.filter = filter;
    }

    public String getUsername() {
        return username;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getLink() {
        return mapLink;
    }

    public String getChosenLabel() {
        return chosenLabel;
    }

    public String getFilters() {
        return filter;
    }

    public String getLocationName() {
        return locationName;
    }
}
