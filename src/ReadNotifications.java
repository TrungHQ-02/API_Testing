import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

import freq.BaseURL;

public class ReadNotifications {
    private static HttpURLConnection connection;
    public static Rp rp;
    public String respondContentString;

    public String getRespondContentString() {
        return respondContentString;
    }

    public void setRespondContentString(String respondContentString) {
        this.respondContentString = respondContentString;
    }

    public void Test28(String token, String auctionDenyId) {
        // access_token is not nullable
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2OTkyMjc5LCJleHAiOjE2NTczNTIyNzksIm5iZiI6MTY1Njk5MjI3OSwianRpIjoiWFdFSjBROWNiWGxxcmI2cCIsInN1YiI6NDU3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.Qo1zeuy9p9AKabz7uS1WNQI1qxXiN7p_WCowPZP2k-E
        // https://auctions-app-2.herokuapp.com/api/notifications?index=2&count=10&is_not_read=1
        try {
            URL url = new URL(BaseURL.baseURL + "notifications/read/" + auctionDenyId);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer" + token);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }

            this.setRespondContentString(respondContent.toString());
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
}

