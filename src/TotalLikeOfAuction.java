import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class TotalLikeOfAuction {
    private static HttpURLConnection connection;
    public static Rp rp;

    public void Test24(String access_token, String auction_id) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/totalLikes/" + auction_id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer" + access_token);

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
    public Data getData(){
        return rp.data;
    }

}
