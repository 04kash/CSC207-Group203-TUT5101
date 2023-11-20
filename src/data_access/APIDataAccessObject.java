package data_access;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import entity.Location;
import org.json.JSONArray;
import org.json.JSONObject;
import entity.Coordinate;
import use_case.api_returns.ApiUserDataAccessInterface;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Objects;

public class APIDataAccessObject implements ApiUserDataAccessInterface {
//    public static void main(String[] args){
//        ArrayList<Location> l=getLocations("Mumbai",1000000,"malls");
//        for(int i=0;i<l.size();i++){
//            System.out.println(l.get(i).getName());
//            System.out.println(l.get(i).getCoordinate().getLatitude());
//            System.out.println(l.get(i).getCoordinate().getLongitude());
//            System.out.println(l.get(i).getOsmLink());
//            System.out.println(l.get(i).getFilter());
//        }
//    }
    public ArrayList<Location> getLocations(String cityName, double proximity, String filter){
        try {
//            String apiKey = System.getenv("API_KEY");
            String apiKey = "insert API KEY";
            Coordinate coordinates = getCoordinates(cityName);
            double lat = coordinates.getLatitude();
            double lon = coordinates.getLongitude();

            // Define the URL for fetching places in Toronto
            String apiUrl = "https://api.opentripmap.com/0.1/en/places/radius?radius="+ proximity +"&lon="+lon+"&lat="+lat+"&kinds="+filter+"&format=json&apikey="+apiKey;

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
                for (int i = 0; i < jsonArray.length(); i++) {
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
        public static Coordinate getCoordinates(String cityName){
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