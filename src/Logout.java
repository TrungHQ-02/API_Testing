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

            // Convert to Object
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
        System.out.println("Unit test 1: If Access token is right, The code and message String shall be not NULL as well as non-empty:");
        Test04("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU1ODIzMTAwLCJleHAiOjE2NTYxODMxMDAsIm5iZiI6MTY1NTgyMzEwMCwianRpIjoiVnN6Uk41b2l0V1RCdjBxQyIsInN1YiI6MjMwLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.Vq4KZ6Y8NBCKgQiX6BCYrIUwR_wNzDY4NK_t6Mx6j8U");
        assert (rp.code != null && !"".equals(rp.code));
        assert (rp.msg != null && !"".equals(rp.msg));
        System.out.println("Finished! Satisfied!");
    }

    // Run unit test
    public static void main(String[] args){
        Unit_test1();
    }
}
