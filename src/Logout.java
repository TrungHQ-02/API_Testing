import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Logout {
    private static HttpURLConnection connection;

    public static Rp4 rp;
    int rpCode;

    public void Test05(String token) {
        String line;
        BufferedReader reader;
        StringBuilder respondContent = new StringBuilder();
        // Connect and parse Json
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/logout");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + token);
            rpCode = connection.getResponseCode();
            System.out.println(rpCode);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            // Parse Json
            Gson g = new Gson();
            rp = g.fromJson(respondContent.toString(), Rp4.class);

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
    public int getHttpCode(){
       return rpCode;
    }
}
