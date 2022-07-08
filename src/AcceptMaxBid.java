import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AcceptMaxBid {
    private static HttpURLConnection connection;

    public static Rp rp;

    public void Test20(int auction_id, String selling_info, String token) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/accept/" + auction_id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + token);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n  \"selling_info\": \"" + selling_info + "\"}";
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
    public int getCode(){
        return rp.code;
    }
    public String getMessage(){
        return rp.message;
    }

}
