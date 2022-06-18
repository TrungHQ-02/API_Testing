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

	public static Test01 test01;
	public String mail;
	public String password;
	public Response_SignUp rp;

	// Getters and setters
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

	// Constructor: parm = add = api's name
	public Test01(String add) throws IOException {
		super(add);
		this.setRequestMethod("POST");
		this.makeMethod();
	}

	// Connect and parse Json
	public void convertJsonIntoObject() throws IOException {
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

			// print out Json
			System.out.println(content.toString());

			Gson g = new Gson();
			rp = g.fromJson(content.toString(), Response_SignUp.class);

		} finally {
			connection.disconnect(); // close connection
		}
	}

	public void setInfo(Test01 test, String email, String pw) throws IOException {
		test.setMail(email);
		test.setPassword(pw);
	}

	public void unit_test1() throws IOException {
		System.out.println("Unit test 1: The code and message strings shall be not NULL as well as non-empty:");
		test01 = new Test01("/login");
		test01.setInfo(test01, "thanh12345@gmail.com", "123456");
		test01.convertJsonIntoObject();
		assert (rp.code != null && !"".equals(rp.code));
		assert (rp.msg != null && !"".equals(rp.msg));
		System.out.println("Finished! Satisfied!");
	}

	public void unit_test2() throws IOException {
		System.out.println("Unit test 2: When email's length is more than 255 characters, the code is equal to 1001");
		test01 = new Test01("/login");
		test01.setInfo(test01, "thanh12345abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz@gmail.com", "123456");
		test01.convertJsonIntoObject();
		assert (rp.code != null && rp.code == "1001");
		System.out.println("Finished! Satisfied!");
	}
	
	public void unit_test3() throws IOException {
		System.out.println("Unit test 3: When email is empty, the code is equal to 1001");
		test01 = new Test01("/login");
		test01.setInfo(test01, "", "123456");
		test01.convertJsonIntoObject();
		assert (rp.code != null && rp.code == "1001");
		System.out.println("Finished! Satisfied!");
	}
	
	public void unit_test4() throws IOException {
		System.out.println("Unit test 4: When password is empty, the code is equal to 1001");
		test01 = new Test01("/login");
		test01.setInfo(test01, "thanh123@gmail.com", "");
		test01.convertJsonIntoObject();
		assert (rp.code != null && rp.code == "1001");
		System.out.println("Finished! Satisfied!");
	}
	
	public void unit_test5() throws IOException {
		System.out.println("Unit test 5: When both email and password are empty, the code is equal to 1001");
		test01 = new Test01("/login");
		test01.setInfo(test01, "", "");
		test01.convertJsonIntoObject();
		assert (rp.code != null && rp.code == "1001");
		System.out.println("Finished! Satisfied!");
	}
	
	public void unit_test6() throws IOException {
		System.out.println("Unit test 3: when email is not truly-formatted, the code is equal to 1001");
		test01 = new Test01("/login");
		test01.setInfo(test01, "", "123456");
		test01.convertJsonIntoObject();
		assert (rp.code != null && rp.code == "1001");
		System.out.println("Finished! Satisfied!");
	}
	
	public static void main(String[] args) throws IOException {
		Test01 test01_1 = new Test01("/login");
		test01_1.unit_test1();
		test01_1.unit_test2();
		test01_1.unit_test3();
		test01_1.unit_test4();
		test01_1.unit_test5();
		test01_1.unit_test6();
		
	}

}
