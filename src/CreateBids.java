import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CreateBids {
    private static HttpURLConnection connection;

    public static Rp rp;

    public String fixed_price;

    public String fixed_bid_last_id;


    public void Test16(String price, String bid_last_id,String accessToken) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        /// api/auctions/edit/{auctionId}
        try {
            URL url = new URL(BaseURL.baseURL + "bids/create/218");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + accessToken);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            String data = "{\n \"price\": \"" + price + "\"" + "   ,\n  \"bid_last_id\": \"" + bid_last_id  + "\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            // set to model
            this.setFixed_price(price);
            this.setFixed_bid_last_id(bid_last_id);

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

    public String getMessage() {
        return rp.message;
    }

    public Data getData() {
        return rp.data;
    }


    public String getFixed_price() { return fixed_price; }
    public void setFixed_price(String fixed_price) {
        this.fixed_price = fixed_price;
    }

    public String getFixed_bid_last_id() { return fixed_bid_last_id; }
    public void setFixed_bid_last_id(String fixed_bid_last_id) {
        this.fixed_price = fixed_bid_last_id;
    }

}
