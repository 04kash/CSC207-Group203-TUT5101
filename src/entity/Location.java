package entity;

public class Location {
    private final String name;
    private final Coordinate coordinate;
    private final String osmLink;
    private final String filter;

    public Location(String name, Coordinate coordinate, String osmLink,String filter){
        this.name=name;
        this.coordinate = coordinate;
        this.osmLink = osmLink;
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getName() {
        return name;
    }

    public String getOsmLink() {
        return osmLink;
    }
}
