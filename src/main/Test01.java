package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import freq.Response_SignUp;

public class Test01 extends API_BaseFunction {
	
	public String mail;
	public String password;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	// Config
	public Test01(String add) throws IOException {
		super(add);
		this.setRequestMethod("POST");
		this.makeMethod();
	}
	
	public void test() throws IOException {
		Map<String, String> params = new HashMap<>();
	    params.put("email", mail);
	    params.put("password", password);

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
	        Response_SignUp rp = g.fromJson(content.toString(), Response_SignUp.class);
	        
	        // Unit test 1
	        System.out.println("Unit test 1: The code and message strings shall be not NULL as well as non-empty:");
	        assert(rp.code != null && !"".equals(rp.code));
	        assert(rp.msg != null && !"".equals(rp.msg));
	        System.out.println("Finished! Satisfied!");
	        
	        // Unit test 2
	        
	        		
	    } finally {
	        connection.disconnect(); // close connection
	    }
	}
	
	public static void main(String[] args) throws IOException {
		Test01 test01 = new Test01("/login");
		test01.setMail("thanh12345@gmail.com");
		test01.setPassword("123456");
		test01.test();
	}



}
