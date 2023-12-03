package entity;

public class Coordinate {
    private final double latitude;
    private final double longitude;

    /**
     * This method creates a coordinate object, which contain the exact location of a place based on its longitude and
     * latitude
     *
     * @param latitude a double which represents the latitude value of the coordinates
     * @param longitude a double which represents the longitude value of the coordinates
     */
    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * this method gets back the value of the private variable latitude
     *
     * @return a double that represents the value of latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * this method gets back the value of the private variable longitude
     *
     * @return a double that represents the value of longitude
     */
    public double getLongitude() {
        return longitude;
    }
}
