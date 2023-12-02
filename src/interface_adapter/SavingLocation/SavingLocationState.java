package interface_adapter.SavingLocation;

public class SavingLocationState {
//    private String username=""; //TODO:get username from APIState
//    private String chosenLabel = "favourites";
//    private String locationName="";
//    private double latitude=0;
//    private double longitude=0;
//    private double proximity=0;
//    private String filter="";
    private String displayMsg=null;
    public SavingLocationState(SavingLocationState copy){
//        username = copy.username;
//        chosenLabel = copy.chosenLabel;
//        locationName = copy.locationName;
//        latitude = copy.latitude;
//        longitude = copy.longitude;
//        proximity = copy.proximity;
//        filter = copy.filter;
        displayMsg = copy.displayMsg;
    }
    SavingLocationState(){};

//    public String getChosenLabel() {
//        return chosenLabel;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getLocationName() {
//        return locationName;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//
//    public double getProximity() {
//        return proximity;
//    }
//
   public String getDisplayMsg() {
        return displayMsg;
}
//
//    public String getFilter() {
//        return filter;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setLocationName(String locationName) {
//        this.locationName = locationName;
//    }
//
//    public void setChosenLabel(String chosenLabel) {
//        this.chosenLabel = chosenLabel;
//    }
//
//    public void setFilter(String filter) {
//        this.filter = filter;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public void setProximity(double proximity) {
//        this.proximity = proximity;
//    }

    public void setDisplayMsg(String displayMsg) {
        this.displayMsg = displayMsg;
    }
}
