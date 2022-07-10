
import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class CreateItem {
    private static HttpURLConnection connection;

    public static Rp rp;
    int rpCode;

    public String fixed_title;


    public void Test15(String auction_id, String name, int starting_price, int brand_id, String description, String series, String token) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        /// api/auctions/edit/{auctionId}
        try {
            URL url = new URL(BaseURL.baseURL + "items/create/" + auction_id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + token);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n \"name\": \"" + name
                    + "\",\n  \"brand_id\": \"" + brand_id
                    + "\",\n  \"starting_price\": \"" + starting_price
                    + "\",\n  \"description\": \"" + description
                    + "\",\n  \"series\": \"" + series
                    + "\"\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

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
    public int getCode() {
        return rp.code;
    }
    public int getHttpCode(){
        return rpCode;
    }

    public String getMessage() {
        return rp.message;
    }

    public Data getData() {
        return rp.data;
    }

    public String getFixed_title() {
        return fixed_title;
    }

    public void setFixed_title(String fixed_title) {
        this.fixed_title = fixed_title;
    }


}
