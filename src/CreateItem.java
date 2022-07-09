
import com.google.gson.Gson;

import freq.BaseURL;

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
    int rpCode;
    public String fixed_id;

    public String fixed_start_date, fixed_end_date;

    public String fixed_title;


    public void Test13(String auction_id, String token, String name, String starting_price, String brand_id, String description,String series, String images) {
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

            String data = "{\n \"auction_id\": \"" + auction_id
                    + "\",\n  \"brand_id\": \"" + brand_id
                    + "\",\n  \"series\": \"" + series
                    + "\",\n  \"name\": \"" + name
                    + "\",\n  \"description\": \"" + description
                    + "\",\n  \"images\": \"" + images
                    + "\"\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            // set to model
            this.setFixed_id(auction_id);
            this.setFixed_id(brand_id);
            this.setFixed_id(series);
            this.setFixed_id(name);
            this.setFixed_id(description);
            this.setFixed_id(images);

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

    public String getFixed_start_date() {
        return fixed_start_date;
    }

    public void setFixed_start_date(String fixed_start_date) {
        this.fixed_start_date = fixed_start_date;
    }

    public String getFixed_end_date() {
        return fixed_end_date;
    }

    public void setFixed_end_date(String fixed_end_date) {
        this.fixed_end_date = fixed_end_date;
    }

    public String getFixed_id() {
        return fixed_id;
    }

    public void setFixed_id(String fixed_id) {
        this.fixed_id = fixed_id;
    }
}
