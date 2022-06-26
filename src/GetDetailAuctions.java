import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetDetailAuctions{
    private static HttpURLConnection connection;
    public static Rp rp;

    public static void Test09(String Auct_ID, String token) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/auctions/detail/"+Auct_ID);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer" + token);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }

            // Print Json
            System.out.println(respondContent.toString());

            // Convert to Object
            Gson g = new Gson();
            rp = g.fromJson(respondContent.toString(), Rp.class);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }

    }
    public static void unit_test01(){
        System.out.println("Unit test 1: Test with auction_ID = 1, The code and message String shall be not NULL as well as non-empty:");
            Test09("1", null);
            assert rp.code == 1000 : "Wrong code" ;
            assert rp.message .equals("OK") : "Wrong message";
            System.out.println("Finished! Satisfied!");
    }
    public static void main(String[] args){
        unit_test01();
    }
}
