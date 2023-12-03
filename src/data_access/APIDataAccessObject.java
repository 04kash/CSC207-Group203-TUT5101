package data_access;

import java.io.*;
import java.net.URL;

import entity.*;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.api_returns.ApiUserDataAccessInterface;
import use_case.displayingLocations.DisplayingLocationsUserDataAccessInterface;

import java.net.HttpURLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIDataAccessObject implements ApiUserDataAccessInterface, DisplayingLocationsUserDataAccessInterface {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final HashMap<String, Location> accounts = new HashMap<>();


    public APIDataAccessObject(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("locations", 0);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();
                assert header.equals("locations");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String locations = String.valueOf(col[headers.get("locations")]);
                    ArrayList<Location> locationList = StringtoArrayList(locations);
                    save(locationList);
                    }
                }
            }
        }

    private ArrayList<Location> StringtoArrayList(String locations) {

        ArrayList<Location> locationsArrayList = new ArrayList<>();
        ArrayList<ArrayList> locationArrayList = stringtoArray(locations);
        for (int i = 0; i < locationArrayList.size(); i++) {
            ArrayList lists = locationArrayList.get(i);
            String locationName = (String) lists.get(0);
            Coordinate coordinate = (Coordinate) lists.get(1);
            String osmLink = (String) lists.get(2);
            String filter = (String) lists.get(3);
            Location location = new Location(locationName, coordinate, osmLink, filter);
            locationsArrayList.add(location);
        }
        return locationsArrayList;
    }

    private ArrayList<ArrayList> stringtoArray(String locations) {
        ArrayList<ArrayList> result = new ArrayList<>();

        String regex = "\\[([^\\[\\]]*(\\[[^\\[\\]]*\\])?[^\\[\\]]*)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(locations);

        while (matcher.find()) {
            // Extract the matched nested structure
            String match = matcher.group(1);

            // Recursively process nested structures
            if (match.startsWith("[")) {
                result.add(stringtoArray(match));
            } else {
                // Convert simple elements to ArrayList
                String[] elements = match.split(", ");
                List<String> list = List.of(elements);
                result.add(new ArrayList<>(list));
            }
        }
        return result;
    }
    public ArrayList<Location> getLocations(String cityName, String filter){

       LocationFetcher locationFetcher = new OpenTripMapLocationFetcher();
       return locationFetcher.getLocations(cityName,filter);
    }

    public void save(ArrayList<Location> locations) {
        for (Location location : locations) {
            accounts.put(location.getName(), location);
            this.save();
        }
    }
    public void save() {
        BufferedWriter writer;
        try {

            writer = new BufferedWriter(new FileWriter(csvFile, false));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();
            String line = "";
            for (Location location : accounts.values()) {
                String stringLocation = "[" + location.getName() + ", (" + location.getCoordinate().getLatitude() + ", " + location.getCoordinate().getLongitude() + "), " + location.getOsmLink() + ", " + location.getFilter() + "]";
                line = stringLocation;
                writer.write(line);
                writer.newLine();
            }

            writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

    public HashMap<String, Location> getAccounts() {
        return accounts;
    }
}