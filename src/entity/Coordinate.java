package entity;

public class Coordinate {
    private final double latitude;
    private final double longitude;

    public Coordinate() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
