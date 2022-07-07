import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class CreateComment {
    private static HttpURLConnection connection;

    public static Rp rp;
    int rpCode;

    public void Test14(int auction_id, String access_token, String content, int comment_last_id) {
        String line;
        BufferedReader reader;
        StringBuilder respondContent = new StringBuilder();
        // Connect and parse Json
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/comments/create/" + auction_id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + access_token);
            /*rpCode = connection.getResponseCode();
            System.out.println(rpCode);*/
            
            String data = "{\n  \"content\": \"" + content + "\",\n \"comment_last_id\": \"" + comment_last_id + "\"\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            // Parse Json
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
    public int getHttpCode(){
       return rpCode;
    }
    public Data getData() {
    	return rp.data;
    }
}