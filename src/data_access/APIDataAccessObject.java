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

//    public static void main(String[] args){
//        ArrayList<Location> l = getLocations("Mumbai","interesting_places");
//        for (int i = 0; i < l.size();i++) {
//            System.out.println(l.get(i).getName());
//            System.out.println(l.get(i).getCoordinate().getLatitude());
//            System.out.println(l.get(i).getCoordinate().getLongitude());
//            System.out.println(l.get(i).getOsmLink());
//            System.out.println(l.get(i).getFilter());
//        }
//    }
    public ArrayList<Location> getLocations(String cityName, String filter){

        try {
//            String apiKey = System.getenv("API_KEY");
            String apiKey = "5ae2e3f221c38a28845f05b69a5f07fa5c748e49837877179a12c1a3";
            Coordinate coordinates = getCoordinates(cityName);
            double lat = coordinates.getLatitude();
            double lon = coordinates.getLongitude();

            // Define the URL for fetching places in Toronto
            String apiUrl = "https://api.opentripmap.com/0.1/en/places/radius?radius="+ 10000 +"&lon="+lon+"&lat="+lat+"&kinds="+filter+"&format=json&apikey="+apiKey;


            // Create a URL object
            URL url = new URL(apiUrl);


            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            // Set the request method to GET
            connection.setRequestMethod("GET");


            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response data

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the JSON response
                JSONArray jsonArray = new JSONArray(response.toString());
                 //System.out.println(jsonArray);
                // Extract and print name and coordinates for each place
                ArrayList<Location> locations= new ArrayList<>();
                for (int i = 0; i < jsonArray.length() && i<=10; i++) {
                    JSONObject place = jsonArray.getJSONObject(i);
                    String name = place.optString("name", "");
                    String osmLink = place.optString("osm","");
                    if(Objects.equals(osmLink, "")){
                        continue;
                    }
                    JSONObject point = place.getJSONObject("point");
                    double latitude = point.getDouble("lat");
                    double longitude = point.getDouble("lon");

                    if (!name.isEmpty()) {
//                        System.out.println("Name: " + name);
//                        System.out.println("Latitude: " + latitude);
//                        System.out.println("Longitude: " + longitude);
//                        System.out.println();
                        Coordinate curr_coordinates= new Coordinate(latitude,longitude);
                        Location location = new Location(name,curr_coordinates,osmLink,filter);
                        locations.add(location);
                    }
                }
                return locations;
            } else {
                System.out.println("API Request failed with response code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
        public Coordinate getCoordinates(String cityName){
        try {
            //String apiKey = System.getenv("API_KEY");
            String apiKey = "5ae2e3f221c38a28845f05b69a5f07fa5c748e49837877179a12c1a3";

            // Define the URL for fetching places in Toronto
            String apiUrl = "https://api.opentripmap.com/0.1/en/places/geoname?name=+"+cityName+"&apikey="+apiKey;
            URL url = new URL(apiUrl);
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response data
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                //Parse the JSON string into a JSONObject
                JSONObject json = new JSONObject(response.toString());

                // Access the lat and lon values
                double lat = json.getDouble("lat");
                double lon = json.getDouble("lon");

                // Print the values
               Coordinate coordinates = new Coordinate(lat,lon);
               return coordinates;
        }else {
                System.out.println("API Request failed with response code: " + responseCode);
            }
            // Close the connection
            connection.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }
            return null;
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