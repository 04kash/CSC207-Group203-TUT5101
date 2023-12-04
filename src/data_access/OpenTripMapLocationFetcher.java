package data_access;

import entity.Coordinate;
import entity.Location;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class OpenTripMapLocationFetcher implements LocationFetcher {
    private final String apiKey= "5ae2e3f221c38a28845f05b69a5f07fa5c748e49837877179a12c1a3";
    @Override
    public ArrayList<Location> getLocations(String cityName, String filter) {
        try {
            Coordinate coordinates = getCoordinates(cityName);
            double lat = coordinates.getLatitude();
            double lon = coordinates.getLongitude();

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
                        Coordinate curr_coordinates= new Coordinate(latitude,longitude);
                        Location location = new Location(name,curr_coordinates,osmLink,filter);
                        locations.add(location);
                    }
                }
                return locations;
            } else {
                //System.out.println("API Request failed with response code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
    private Coordinate getCoordinates(String cityName){
        try {
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
                //System.out.println("API Request failed with response code: " + responseCode);
            }
            // Close the connection
            connection.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
