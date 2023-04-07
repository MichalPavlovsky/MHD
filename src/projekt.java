import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Properties;
public class projekt {
    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        props.load(new FileReader(".env"));
        String apiKey = props.getProperty("API_KEY");
        URL url = new URL("http://dataservice.accuweather.com/currentconditions/v1/300226?apikey=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String json = response.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        String weatherText = rootNode.get(0).get("WeatherText").asText();
        if (weatherText != null) {
            System.out.println("Current weather: " + weatherText);
        } else {
            System.out.println("Weather data not available.");
        }
    }
}