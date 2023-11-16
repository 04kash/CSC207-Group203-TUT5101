package use_case.SavingLocation;

public class SavingLocationInputData {
    final private String username;
    private final String password;
    private String chosenLabel = "favourites";
    String locationName;
    double latitude;
    double longitude;
    double proximity;
    String filter;

    public SavingLocationInputData(String username,String password, String chosenLabel, String locationName, double latitude, double longitude, double proximity, String filter) {
        this.username = username;
        this.password = password;
        this.chosenLabel = chosenLabel;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.proximity = proximity;
        this.filter = filter;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getProximity() {
        return proximity;
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
