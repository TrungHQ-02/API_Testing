import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Logout {
    private static HttpURLConnection connection;

    public static Rp rp;

    public static void Test04(String token) {
        String line;
        BufferedReader reader;
        StringBuilder respondContent = new StringBuilder();
        // Connect and parse Json
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/logout");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + token);


            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            
            // Print Json
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
    public static void Unit_test1(){
        System.out.println("Unit test 1: If Access token is right, Respond code is 1000 and message is OK:");
        Test04("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2MjMxOTgzLCJleHAiOjE2NTY1OTE5ODMsIm5iZiI6MTY1NjIzMTk4MywianRpIjoiTjNRU3U4WnlLQmtoSEQ0cCIsInN1YiI6MjMwLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.itq0AgEmUmLohB6-iF_64PHfxHynPJUs568T5VEwW3I");
        assert rp.code == 1000 : "Wrong code";
        assert rp.message.equals("OK") : "Wrong message";
        System.out.println("Finished! Satisfied!");
    }

    // Run unit test
    public static void main(String[] args){
        Unit_test1();
    }
}
