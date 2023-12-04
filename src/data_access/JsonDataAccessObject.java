package data_access;

import entity.*;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.CreateLabel.CreateLabelDataAccessInterface;
import use_case.LocationsFromLabel.LocationsFromLabelUserDataAccessInterface;
import use_case.SavingLocation.SavingLocationUserDataAccessInterface;
import use_case.displayingLabels.DisplayingLabelsUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, CreateLabelDataAccessInterface, SavingLocationUserDataAccessInterface, LocationsFromLabelUserDataAccessInterface, DisplayingLabelsUserDataAccessInterface {
    private final Map<String, User> accounts = new HashMap<>();
    private final String JSONpath;
    private String currentUser;

    public static void main(String[] args) {
//        // To convert CommonUser to JSON
//        ArrayList<Location> locations = new ArrayList<>();
//        locations.add(new Location("Bla", new Coordinate(0.0, 1.0), "link here", "food"));
//        locations.add(new Location("Heyy", new Coordinate(5.0, 6.0), "link here1", "games"));
//        HashMap<Label, ArrayList<Location>> planner1 = new HashMap<>();
//        Label label = new Label("Restaurants");
//        planner1.put(label, locations);
//        Planner planner = new Planner(planner1);
//        CommonUser user = new CommonUser("john_doe", "secure_password", planner);
//        CommonUser juser = new CommonUser("jane_doe","not_joe",new Planner(new HashMap<>()));
//        JSONObject userJson = JsonDataAccessObject.userToJSON(user);
//        JSONObject janeJson = JsonDataAccessObject.userToJSON(juser);
//        System.out.println(userJson);
//
//        // Write the JSON objects to the file without overwriting
//        ArrayList<JSONObject> usersList = new ArrayList<>();
//        usersList.add(userJson);
//        usersList.add(janeJson);
//        writeJsonListToFile(usersList, "user_data.json");
//
//        ArrayList<JSONObject> myread = readJsonFromFile("user_data.json");
//        System.out.println(myread);
//
//        // To convert JSON to CommonUser
//        assert myread != null;
//        CommonUser newUser = JsonDataAccessObject.userFromJSON(myread.get(1));
//        System.out.println(newUser.getPlanner());
//
//        for (Label l : newUser.getPlanner().getLabel()) {
//            System.out.println(l.getTitle());
//        }
    }

    public JsonDataAccessObject(String JSONpath) throws IOException {
        this.JSONpath = JSONpath;

        // Check if the file exists and is not empty before reading
        File file = new File(JSONpath);
        if (file.exists() && file.length() > 0) {
            ArrayList<JSONObject> readerJSON = readJsonFromFile(JSONpath);
            for (JSONObject jsonUser : readerJSON) {
                User user = userFromJSON(jsonUser);
                accounts.put(user.getUsername(), user);
            }
        } else {
            // File is empty or does not exist, initialize with an empty map
           save();
        }
    }


    @Override
    public void save(User user){
        accounts.put(user.getUsername(),user);
        this.save();
    }
    public void save(){
        ArrayList<JSONObject> usersToWrite = new ArrayList<>();
        for (User user:accounts.values()){
            JSONObject jsonObject = userToJSON(user);
            usersToWrite.add(jsonObject);
        }
        writeJsonListToFile(usersToWrite,JSONpath);
    }
    public JSONObject userToJSON(User user) {
        JSONObject json = new JSONObject();
        json.put("username", user.getUsername());
        json.put("password", user.getPassword());
        json.put("planner", plannertoJSON(user.getPlanner()));
        return json;
    }

    public JSONObject plannertoJSON(Planner planner) {
        JSONObject json = new JSONObject();

        JSONArray labelsArray = new JSONArray();
        for (Label label : planner.getLabel()) {

            JSONArray locationsArray = new JSONArray();
            for (Location location : planner.getLocations(label)) {
                locationsArray.put(locationToJSON(location));
            }

            json.put(label.getTitle(), locationsArray);
        }

        return json;
    }

    public JSONObject locationToJSON(Location location) {
        JSONObject json = new JSONObject();
        json.put("name", location.getName());
        json.put("latitude", location.getCoordinate().getLatitude());
        json.put("longitude", location.getCoordinate().getLongitude());
        json.put("osmLink", location.getOsmLink());
        json.put("filter", location.getFilter());
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
        Planner planner = new Planner(new HashMap<>());

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


    private static void writeJsonListToFile(List<JSONObject> jsonList, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (JSONObject json : jsonList) {
                json.write(fileWriter);
                fileWriter.write("\n"); // Add a newline character to separate JSON objects
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<JSONObject> readJsonFromFile(String fileName) {
        ArrayList<JSONObject> jsonObjects = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (!line.isEmpty()) {
                    // Parse the line as a JSON object
                    jsonObjects.add(new JSONObject(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObjects;
    }

    @Override
    public void addLocation(String username, Location location, Label newLabel) {
        Set<Label> labels = accounts.get(username).getPlanner().getLabel();
        Label savedLabel = new Label();
        boolean inPlanner = false;
        for (Label label: labels) {
            if (label.getTitle().equals(newLabel.getTitle())) {
                savedLabel = label;
                inPlanner = true;
            }
        }
        if (inPlanner) {
            accounts.get(username).getPlanner().getLocations(savedLabel).add(location);
        }
//        else {
//            ArrayList<Location> list = new ArrayList<>();
//            list.add(location);
//            accounts.get(username).getPlanner().setLabel(savedLabel, list);
//        }
        save();
    }


    @Override
    public boolean locationExists(String username, Location chosenLocation) {
        User user = accounts.get(username);
        Label[] labels = user.getPlanner().getLabel().toArray(new Label[0]);
        for (Label label : labels) {
            ArrayList<Location> locations = user.getPlanner().getLocations(label);

            for (Location location : locations) {
                if ((Double.compare(location.getCoordinate().getLatitude(),chosenLocation.getCoordinate().getLatitude())==0 && Double.compare(location.getCoordinate().getLongitude(),chosenLocation.getCoordinate().getLongitude())==0 ) && location.getName().equals(chosenLocation.getName())){
                    //System.out.println("chosen location:"+chosenLocation.getName()+"location:"+location.getName());
                    return true;
                }
            }
        }

        return false;
    }


    public void addLabelToPlanner(String username, Label newLabel) {
        Planner userPlanner = accounts.get(username).getPlanner();
        userPlanner.setLabel(newLabel, new ArrayList<>());
        save();
        //TODO: Check If this is creating 2 copies of the user: existing one and new one. We only want new one.
    }

    @Override
    public ArrayList<Location> getLocationsFromLabel(String username, Label newLabel) {
        Set<Label> labels = accounts.get(username).getPlanner().getLabel();
        Label savedLabel = new Label();
        boolean inPlanner = false;
        for (Label label : labels) {
            if (label.getTitle().equals(newLabel.getTitle())) {
                savedLabel = label;
                inPlanner = true;
            }
        }
        if (inPlanner) {
            return accounts.get(username).getPlanner().getLocations(savedLabel);
        } else {
            ArrayList<Location> list = new ArrayList<>();
            return list;
        }
    }


    @Override
    public boolean labelExists(String username,Label label) {
        User user = accounts.get(username);
        Label[] labels = user.getPlanner().getLabel().toArray(new Label[0]);
        for(Label labelInPlanner:labels){
            if(Objects.equals(labelInPlanner.getTitle(), label.getTitle())){
                return true;
            }

        }
        return false;
    }



    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public String getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean labelIsEmpty(String username,Label label) {
        User user = accounts.get(username);
        Label[] labels = user.getPlanner().getLabel().toArray(new Label[0]);
        for(Label labelInPlanner:labels){
            if(Objects.equals(labelInPlanner.getTitle(), label.getTitle())){
                if(user.getPlanner().getLocations(labelInPlanner).isEmpty()){
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public void setCurrentUser(String currentString) {
        this.currentUser = currentString;
    }


}

