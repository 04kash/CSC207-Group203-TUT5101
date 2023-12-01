package data_access;

import entity.*;
import use_case.SavingLocation.SavingLocationUserDataAccessInterface;
import use_case.CreateLabel.CreateLabelDataAccessInterface;
import use_case.LocationsFromLabel.LocationsFromLabelUserDataAccessInterface;
import use_case.displayingLabels.DisplayingLabelsUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, CreateLabelDataAccessInterface, SavingLocationUserDataAccessInterface, LocationsFromLabelUserDataAccessInterface, DisplayingLabelsUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();
    private UserFactory userFactory;

    private String currentUser;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("planner", 2);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password,planner");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    Planner planner1 = new Planner();
                    if (!String.valueOf(col[headers.get("planner")]).equals("[]")) {
                        String planner = String.valueOf(col[headers.get("planner")]);
                        planner1 = parsePlanner(planner);
                    }
                    User user = userFactory.create(username, password, planner1);
                    accounts.put(username, user);
                }
            }
        }
    }

    private static Planner parsePlanner(String plannerInfo) {

        Planner planner = new Planner();
        ArrayList<ArrayList> nestedArrayList = stringToNestedArrayList(plannerInfo);
        for (int i = 0; i < nestedArrayList.size(); i++) {
            ArrayList lists = nestedArrayList.get(i);
            Label label = (Label) lists.get(0);
            Location[] locationArray = (Location[]) lists.get(1);
            ArrayList<Location> locations = new ArrayList<>(Arrays.asList(locationArray));
            planner.setLabel(label, locations);
        }
        return planner;
    }

    private static ArrayList<ArrayList> stringToNestedArrayList(String stringRepresentation) {
        ArrayList<ArrayList> result = new ArrayList<>();

        String regex = "\\[([^\\[\\]]*(\\[[^\\[\\]]*\\])?[^\\[\\]]*)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringRepresentation);

        while (matcher.find()) {
            // Extract the matched nested structure
            String match = matcher.group(1);

            // Recursively process nested structures
            if (match.startsWith("[")) {
                result.add(stringToNestedArrayList(match));
            } else {
                // Convert simple elements to ArrayList
                String[] elements = match.split(", ");
                List<String> list = List.of(elements);
                result.add(new ArrayList<>(list));
            }
        }
        return result;
    }

    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    public void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
//                String line = String.format("%s,%s",
//                        user.getUsername(), user.getPassword());
                Planner planner = user.getPlanner();
                Set<Label> label = planner.getLabel();
                ArrayList<ArrayList> stringPlanner = new ArrayList<>();
                for (Label category : label) {
                    ArrayList<Object> hashmap = new ArrayList<>();
                    hashmap.add(String.valueOf(category));
                    hashmap.add(String.valueOf(new ArrayList<>(List.of(planner.getLocations(category)))));
                    stringPlanner.add(hashmap);
                }
                String line = String.format("%s,%s,%s",
                        user.getUsername(), user.getPassword(), stringPlanner);
//                line += String.valueOf(stringPlanner);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addLocation(String username, Location location, Label newLabel) {
        Set<Label> labels = accounts.get(username).getPlanner().getLabel();
        Label savedLabel = new Label();
        boolean inPlanner = false;
        for (Label label: labels) {
            System.out.println(label.getTitle());
            System.out.println(newLabel.getTitle());
            if (label.getTitle().equals(newLabel.getTitle())) {
                savedLabel = label;
                inPlanner = true;
            }
        }
        if (inPlanner) {
            accounts.get(username).getPlanner().getLocations(savedLabel).add(location);
        } else {
            ArrayList<Location> list = new ArrayList<>();
            list.add(location);
            accounts.get(username).getPlanner().setLabel(savedLabel, list);
        }
//        System.out.println(accounts.get(username).getPlanner().getLocations(savedLabel));
        save();
        }


    @Override
    public boolean locationExists(String username, Coordinate coordinate) {
        User user = accounts.get(username);
        Label[] labels = user.getPlanner().getLabel().toArray(new Label[0]);
        for (Label label : labels) {
            ArrayList<Location> locations = user.getPlanner().getLocations(label);

            for (Location location : locations) {
                if (location.getCoordinate().equals(coordinate)) {
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
    public ArrayList<Location> getLocationsFromLabel(String username, Label label) {
        ArrayList<Location> locations = accounts.get(username).getPlanner().getLocations(label);
        return locations;
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
    public void setCurrentUser(String currentString) {
        this.currentUser = currentString;
    }
}
