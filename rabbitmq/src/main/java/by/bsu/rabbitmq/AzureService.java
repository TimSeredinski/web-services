package by.bsu.rabbitmq;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class AzureService {

    public String sendMessageToAzureFunction(String message) {

        URL url;
        StringBuilder response = new StringBuilder();
        try {
            String fullUrl = "http://localhost:7071/api/HttpTrigger-Java?message=" + URLEncoder.encode(message, StandardCharsets.UTF_8.toString());
            url = new URL(fullUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
