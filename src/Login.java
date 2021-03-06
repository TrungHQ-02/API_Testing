import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Login {
    private static HttpURLConnection connection;

    public static Rp rp;

    public void Test01(String email, String pass) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        try {
            URL url = new URL(BaseURL.baseURL + "login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n \"email\": \"" + email + "\",\n  \"password\": \"" + pass + "\"\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }


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
    
    public String getToken(){
        return rp.data.access_token;
    }
    
    public int getCode() {
    	return rp.code;
    }
    
    public String getMessage() {
    	return rp.message;
    }
    
    // Trung them
    public Data getData() {
    	return rp.data;
    }
}