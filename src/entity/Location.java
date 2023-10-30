package entity;

public class Location {
    private final String name;
    private final Coordinate coordinate;
    private final double proximity;
    private final Filters filters;

    Location(String name, Coordinate coordinate, double proximity, Filters filters) {
        this.name = name;
        this.coordinate = coordinate;
        this.proximity = proximity;
        this.filters = filters;
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

    public Filters getFilters() {
        return filters;
    }
}
