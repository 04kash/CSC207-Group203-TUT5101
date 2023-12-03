
package entity;

import org.json.JSONObject;

public class Location {
    private final String name;
    private Coordinate coordinate = null;
    private final String osmLink;
    private String filter = "interesting_places";

    public Location(String name, Coordinate coordinate, String osmLink, String filter) {
        this.name = name;
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

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("latitude", coordinate.getLatitude());
        json.put("longitude", coordinate.getLongitude());
        json.put("osmLink", osmLink);
        json.put("filter", filter);
        return json;
    }
}