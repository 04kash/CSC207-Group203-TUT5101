package data_access;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import entity.Coordinate;

import java.net.HttpURLConnection;
import java.net.URL;

public class APIDataAccessObject {
//    public void getLocations(String cityName){
//
// }
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
        }}