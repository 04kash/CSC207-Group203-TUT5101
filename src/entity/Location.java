package entity;

public class Location {
    private final String name;
    private final Coordinate coordinate;
    private final double proximity;
    private final String filter;

    public Location(String name, Coordinate coordinate, double proximity, String filter) {
        this.name = name;
        this.coordinate = coordinate;
        this.proximity = proximity;
        this.filter = filter;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getProximity() {
        return proximity;
    }

    public String getFilter() {
        return filter;
    }
}
