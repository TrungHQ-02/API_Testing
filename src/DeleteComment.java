import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteComment {
    private static HttpURLConnection connection;

    public static Rp rp;
    //public String fixed_comment_id;

    public void Test31(String accessToken) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();
        try {
            URL url = new URL(BaseURL.baseURL + "comments/delete/301");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + accessToken);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

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

    public String getMessage() {return rp.message; }

    public Data getData() {
        return rp.data;
    }


}
