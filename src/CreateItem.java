import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CreateItem {
    private static HttpURLConnection connection;

    public static Rp rp;

    public void Test13(String token, String name, int starting_price, int brand_id, String description, String series, String images) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/items/create/1");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + token);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n \"token\": \"" + token
                    + "\",\n  \"name\": \"" + name
                    + "\",\n  \"starting_price\": \"" + starting_price
                    + "\",\n  \"brand_id\": \"" + brand_id
                    + "\",\n  \"description\": \"" + description
                    + "\",\n  \"series\": \"" + series
                    + "\",\n  \"images\": \"" + images
                    + "\"\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }

            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(respondContent.toString(), Rp.class);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

    }

    public String getToken(){
        return rp.data.access_token;
    }

    public int getCode() {
        return rp.code;
    }

    public String getMessage() {
        return rp.message;
    }

    // Trung them
    public Data getData() {
        return rp.data;
    }

}