package entity;

public class Location {
    private final String name;
    private Coordinate coordinate = null;
    private final String osmLink;
    private String filter ="interesting_places";

    /**
     * This method create a location object in which a places name, exact coordinates, osm link and filter are saved
     *
     * @param name this is a string in which the name of the location is stored
     * @param coordinate this is a coordinate object in which the exact location based on longitude and latitude are
     *                   stored
     * @param osmLink this is the osm link that allows us to provide a link to a map that pinpoints where this location
     *                is exactly
     * @param filter this is a string that specifies the type of locations the user would like to receive information
     *               about
     */
    public Location(String name, Coordinate coordinate, String osmLink,String filter){
        this.name = name;
        this.coordinate = coordinate;
        this.osmLink = osmLink;
        this.filter = filter;
    }

    /**
     * This method returns back the value of the private variable filter
     *
     * @return a string that represents the value of filter
     */
    public String getFilter() {
        return filter;
    }

    /**
     * This method returns back the value of the private variable coordinate
     *
     * @return a coordinate object
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * This method returns back the value of the private variable name
     *
     * @return a string that represents the value of the location name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns back the value of the private variable osm link
     *
     * @return a string that represents the value of the link to the map
     */
    public String getOsmLink() {
        return osmLink;
    }
}
