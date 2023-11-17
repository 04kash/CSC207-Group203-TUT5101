import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;


public class OpenTripMapAPIClient {
    public static void main(String[] args) {
        try {
//            String apiKey = System.getenv("API_KEY");
            String apiKey = "5ae2e3f221c38a28845f05b69a5f07fa5c748e49837877179a12c1a3";

            // Define the URL for fetching places in Toronto
            String apiUrl = "https://api.opentripmap.com/0.1/en/places/radius?radius=10000&lon=-79.3832&lat=43.6532&kinds=interesting_places&format=json&apikey="+apiKey;

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

                // Extract and print name and coordinates for each place
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject place = jsonArray.getJSONObject(i);
                    String name = place.optString("name", "");
                    JSONObject point = place.getJSONObject("point");
                    double latitude = point.getDouble("lat");
                    double longitude = point.getDouble("lon");

                    if (!name.isEmpty()) {
                        System.out.println("Name: " + name);
                        System.out.println("Latitude: " + latitude);
                        System.out.println("Longitude: " + longitude);
                        System.out.println();
                    }
                }
            } else {
                System.out.println("API Request failed with response code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}