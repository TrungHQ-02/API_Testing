import javax.security.auth.login.LoginContext;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import random.RandomEmail;

public class LoginTests {
	Login login = new Login();
	RandomEmail email = new RandomEmail();
	
	@Test
	public void unitTest1() {
		// Code and message should not be NULL or empty
		System.out.println("Code and message should not be NULL or empty under any circumstances");
		System.out.println("Try to login with 20 emails and check:");
		System.out.println("Testing unit1...");
		for (int i = 1; i < 21; i++) {
			String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
			login.Test01(randomMail, "123456");
			Assertions.assertTrue(Integer.valueOf(login.getCode()) != null);
			Assertions.assertTrue(login.getMessage() != null);
			
		}	
		System.out.println("Satisfied");	
	}
	
	@Test
	public void unitTest2() {
		// Run 1 test case
		System.out.println("If both email and password are empty or null, msg should be email: 7000 &password: 7000");
		login.Test01(null, null);
		Assertions.assertEquals(login.getCode(), 1001); 
		Assertions.assertEquals(login.getMessage(), "email: 7000 &password: 7000");
		System.out.println("Satisfied!");
	}
	
	@Test
	public void unitTest3() {
		// Run 10 testcases
		System.out.println("If email is null, msg should be email: 7000 &password: ");
		for (int i = 1 ; i <= 10; i++) {
			login.Test01(null, email.getStringWithFixedLength(10));
			Assertions.assertTrue(login.getCode() == 1001 && login.getMessage() == "email: 7000 &password: ");
			System.out.println("Finished! Satisfied!");
		}
	}
	
	@Test
	public void unitTest4() {
		// Run 10 testcases
		System.out.println("If email is null, msg should be email: 7000 &password: ");
		for (int i = 1 ; i <= 10; i++) {
			login.Test01("", email.getStringWithFixedLength(10));
			Assertions.assertTrue(login.getCode() == 1001 && login.getMessage() == "email: 7000 &password: ");
			System.out.println("Finished! Satisfied!");
		}
	}
	
	@Test
	public void unitTest5() {
		// Run 10 testcases
		System.out.println("If password is null, msg should be email:  &password: 7000");
		for (int i = 1 ; i <= 10; i++) {
			login.Test01(email.getSaltString() + "@gmail.com",null);
			Assertions.assertTrue(login.getCode() == 1001 && login.getMessage() == "email:  &password: 7000");
			System.out.println("Finished! Satisfied!");
		}
	}
	
	@Test
	public void unitTest6() {
		// Run 10 testcases
		System.out.println("If password is empty, msg should be 必須項目が未入力です。");
		for (int i = 1 ; i <= 10; i++) {
			String random = email.getSaltString();
			System.out.println(random);
			login.Test01(random + "@gmail.com","");
			System.out.println(login.getCode() + " /// " + login.getMessage() + ".");
			Assertions.assertTrue(login.getCode() == 1001 && login.getMessage() == "email:  &password: 7000");
			System.out.println("Finished! Satisfied!");
		}
	}
}
