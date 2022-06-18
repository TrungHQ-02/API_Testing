package main;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import freq.BASE_URL;



public class Vd01 {

	public static void main(String[] args) throws MalformedURLException, ProtocolException, 
	IOException {
		// create URL
	    URL url = new URL(BASE_URL.BASE);
	    
	    // create URL connection
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    // set request method
	    connection.setRequestMethod("POST");
	    
	    
	    Map<String, String> params = new HashMap<>();
	    params.put("phonenumber", "0987768886");
	    params.put("password", "123456789");

	    StringBuilder postData = new StringBuilder();
	    for (Map.Entry<String, String> param : params.entrySet()) {
	        if (postData.length() != 0) {
	            postData.append('&');
	        }
	        postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	        postData.append('=');
	        postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	    }

	    byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	    connection.setDoOutput(true);
	    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
	        writer.write(postDataBytes);
	        writer.flush();
	        writer.close();

	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	        String line;
	        content = new StringBuilder();
	           while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	        System.out.println(content.toString());
	        
	        Gson g = new Gson(); 
	        ResponseSignUp rp = g.fromJson(content.toString(), ResponseSignUp.class);
	        
	        // Unit test 1
	        System.out.println("Unit test 1: The code and message strings shall be not NULL as well as non-empty:");
	        assert(rp.code != null && !"".equals(rp.code));
	        assert(rp.message != null && !"".equals(rp.message));
	        System.out.println("Finished! Satisfied!");
	        		
	    } finally {
	        connection.disconnect(); // close connection
	    }
	}

}

class ResponseSignUp{
	public String code;
	public String message;
}
