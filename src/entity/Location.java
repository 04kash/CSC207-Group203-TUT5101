package entity;

public class Location {
    private final String name;
    private final Coordinate coordinate;

    private final Proximity proximity;
    private final String osmLink;
    private final String filter;

    public Location(String name, Coordinate coordinate, Proximity proximity, String osmLink,String filter){
        this.name = name;
        this.coordinate = coordinate;
        this.proximity = proximity;
        this.osmLink = osmLink;
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Proximity getProximity() {
        return proximity;
    }

    public String getName() {
        return name;
    }

    public String getOsmLink() {
        return osmLink;
    }
}
