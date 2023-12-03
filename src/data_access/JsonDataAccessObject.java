package data_access;

import entity.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonDataAccessObject {
    public static void main(String[] args) {
        // To convert CommonUser to JSON
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Bla", new Coordinate(0.0, 1.0), "link here", "food"));
        locations.add(new Location("Heyy", new Coordinate(5.0, 6.0), "link here1", "games"));
        HashMap<Label, ArrayList<Location>> planner1 = new HashMap<>();
        Label label = new Label("Restaurants");
        planner1.put(label, locations);
        Planner planner = new Planner(planner1);
        CommonUser user = new CommonUser("john_doe", "secure_password", planner);
        JSONObject userJson = JsonDataAccessObject.userToJSON(user);
        System.out.println(userJson);

        // Write the JSON object to a file
        writeJsonToFile(userJson, "user_data.json");

        // To convert JSON to CommonUser
        CommonUser newUser = JsonDataAccessObject.userFromJSON(userJson);
        System.out.println(newUser.getPlanner().getLocations(label).get(0).getName());

        for (Location l : newUser.getPlanner().getLocations(label)) {
            System.out.println(l.getName());
            System.out.println(l.getOsmLink());
        }
    }
    public static JSONObject userToJSON(CommonUser user) {
        JSONObject json = new JSONObject();
        json.put("username", user.getUsername());
        json.put("password", user.getPassword());
        json.put("planner", user.getPlanner().toJSON());
        return json;
    }

    public static CommonUser userFromJSON(JSONObject json) {
        String username = json.getString("username");
        String password = json.getString("password");

        // Assuming planner is stored as a nested JSON object with the key "planner"
        Planner planner = plannerFromJSON(json.getJSONObject("planner"));

        return new CommonUser(username, password, planner);
    }

    private static Planner plannerFromJSON(JSONObject json) {
        Planner planner = new Planner();
        System.out.println("JsonKeySet:" + json.keySet());

        // Extract labels and locations from JSON
        for (String labelTitle : json.keySet()) {
            Label label = new Label(labelTitle);
            planner.setLabel(label, locationsFromJSON(json.getJSONArray(labelTitle)));
        }

        return planner;
    }

    private static ArrayList<Location> locationsFromJSON(JSONArray json) {
        ArrayList<Location> locations = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            String name = (String) json.getJSONObject(i).get("name");
            double latitude = json.getJSONObject(i).getDouble("latitude");
            double longitude = (json.getJSONObject(i).getDouble("longitude"));
            String osmLink = json.getJSONObject(i).getString("osmLink");
            String filter = json.getJSONObject(i).getString("filter");

            locations.add(new Location(name, new Coordinate(latitude, longitude), osmLink, filter));
        }

        return locations;
    }

    private static void writeJsonToFile(JSONObject json, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            json.write(fileWriter);
            System.out.println("JSON written to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

