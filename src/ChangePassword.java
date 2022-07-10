import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class ChangePassword {
    private static HttpURLConnection connection;

    public static Rp5 rp;
    int rpCode;
   

    public String fixed_old_pass;
    public String fixed_new_pass;
    public String fixed_re_pass;
    public String fixed_email;


    public void Test07(String email, String old_pass, String new_pass, String re_pass, String access_token) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        /// api/comments/create/{auctionId}
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/changepass");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + access_token);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n \"email\": \"" + email + "\"" + ",    \n \"old_pass\": \"" + old_pass 
            		       + "\"" + "    ,\n  \"new_pass\": \"" + new_pass
					       + "\"" + "    ,\n \"re_pass\": \"" + re_pass + "\"" + " \n}";          
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            // set to model
            this.setFixed_email(email+"");
            this.setFixed_old_pass(old_pass+"");
            this.setFixed_new_pass(new_pass+"");
            this.setFixed_re_pass(re_pass+"");
            
            

            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(respondContent.toString(), Rp5.class);

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
    public int getHttpCode(){
        return rpCode;
    }

    public String getMessage() {
        return rp.message;
    }

    public String getData() {
        return rp.data;
    }
    
    public String getFixed_email() {
        return fixed_email;
    }

	public void setFixed_email(String fixed_email) {
        this.fixed_email = fixed_email;
    }
	
    public String getFixed_old_pass() {
        return fixed_old_pass;
    }

	public void setFixed_old_pass(String fixed_old_pass) {
        this.fixed_old_pass = fixed_old_pass;
    }
    
    public String getFixed_new_pass() {
        return fixed_new_pass;
    }

    public void setFixed_new_pass(String fixed_new_pass) {
        this.fixed_new_pass = fixed_new_pass;
    }
    
    public String getFixed_re_pass() {
        return fixed_re_pass;
    }

    public void setFixed_re_pass(String fixed_re_pass) {
        this.fixed_re_pass = fixed_re_pass;
    }
    
    



    
}