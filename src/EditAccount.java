import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class EditAccount {
    private static HttpURLConnection connection;

    public static Rp rp;
    int rpCode;
   

    public String fixed_email;
    public String fixed_password;
    public String fixed_re_pass;
    public String fixed_address;
    public String fixed_name;
    public String fixed_phone;
    public File fixed_avatar;


    public void Test05(String access_token, String email, String password, String re_pass, String address, String name, String phone, File avatar) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        /// api/comments/create/{auctionId}
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/edit");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + access_token);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n \"email\": \"" + email + "\"" + "    ,\n  \"password\": \"" + password
					+ "\"" + "    ,\n  \"re_pass\": \"" + re_pass + "\"" + "    ,\n  \"address\": \"" + address
					+ "\"" + "    ,\n \"name\": \"" + name + "\"" + "   , \n \"phone\": \"" + phone 
					+ "\"" + "    ,\n \"avatar\": \"" + avatar + "\"" + " \n}";          
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
            this.setFixed_password(password+"");
            this.setFixed_re_pass(re_pass+"");
            this.setFixed_address(address+"");
            this.setFixed_name(name+"");
            this.setFixed_phone(phone+"");
            this.setFixed_avatar(avatar);
            
            

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
    
	
	private void setFixed_avatar(File avatar) {
		// TODO Auto-generated method stub
		
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

    public Data getData() {
        return rp.data;
    }
    
    public int getCodeData() {
    	return rp.data.code;
    }
    public String getFixed_email() {
        return fixed_email;
    }

    public void setFixed_email(String fixed_email) {
        this.fixed_email = fixed_email;
    }
    
    public String getFixed_password() {
        return fixed_password;
    }

    public void setFixed_password(String fixed_password) {
        this.fixed_password = fixed_password;
    }
    
    public String getFixed_re_pass() {
        return fixed_re_pass;
    }

    public void setFixed_re_pass(String fixed_re_pass) {
        this.fixed_re_pass = fixed_re_pass;
    }
    
    public String getFixed_address() {
        return fixed_address;
    }

    public void setFixed_address(String fixed_address) {
        this.fixed_address = fixed_address;
    }
    
    public String getFixed_name() {
        return fixed_name;
    }

    public void setFixed_name(String fixed_name) {
        this.fixed_name = fixed_name;
    }
    
    public String getFixed_phone() {
        return fixed_phone;
    }

    public void setFixed_phone(String fixed_phone) {
        this.fixed_phone = fixed_phone;
    }

    public File getFixed_avatar() {
        return fixed_avatar;
    }



    
}