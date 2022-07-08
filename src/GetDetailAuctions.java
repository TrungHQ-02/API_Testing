import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetDetailAuctions{
    private static HttpURLConnection connection;
    public static Rp rp;
    int rpCode;

    public void Test10(int Auct_ID, String token) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();
        try {
            URL url = new URL(BaseURL.baseURL + "auctions/detail/"+Auct_ID);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer" + token);
            rpCode = connection.getResponseCode();

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
        }finally {
            connection.disconnect();
        }
    }
    public int getCode(){
        return rp.code;
    }
    public String getMessage(){
        return rp.message;
    }
    public int getHttpResponseCode(){
        return rpCode;
    }

}
