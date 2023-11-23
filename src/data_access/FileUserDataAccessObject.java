package data_access;

import entity.*;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();
    private UserFactory userFactory;

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
                assert header.equals("username,password,creation_time");

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
            Location[] locations = (Location[]) lists.get(1);
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
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public boolean existsByName(String identifier) {
        return false;
    }
}
