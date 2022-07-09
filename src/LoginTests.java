
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;
// Trung
public class LoginTests {
	Login login = new Login();
	RandomEmail email = new RandomEmail();

	@Test
	public void unitTest01() {
		System.out.println("Code and message should not be NULL or empty under any circumstances");
		System.out.println("Testing unit1...");
		for (int i = 1; i < 3; i++) {
			String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
			login.Test01(randomMail, "123456");
			Assertions.assertTrue(Integer.valueOf(login.getCode()) != null);
			Assertions.assertTrue(login.getMessage() != null);

		}
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest02() {
		// Run 1 test case
		System.out.println(
				"If both email and password are empty or null, code should be 1001 and msg should be email: 7002 &password: ");
		login.Test01(null, null);
		System.out.println("Testing unit2...");
		Assertions.assertEquals(1001, login.getCode());
		Assertions.assertEquals("email: 7002 &password: ", login.getMessage());
		System.out.println("Unit 2: Satisfied!");
	}

	@Test
	public void unitTest03() {
		// Run 3 test cases
		System.out.println("If email is null,code should be 1001 and msg should be email: 7002 &password:  ");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 3; i++) {
			login.Test01(null, email.getStringWithFixedLength(10));
			Assertions.assertEquals(1001, login.getCode());
			Assertions.assertEquals("email: 7002 &password: ", login.getMessage());

		}
		System.out.println("Unit 3: Satisfied!");
	}

	@Test
	public void unitTest04() {
		// Run 3 test cases
		System.out.println("If email is empty, code should be 1001 and msg should be email: 7000 &password: ");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 3; i++) {
			login.Test01("", email.getStringWithFixedLength(10));
			Assertions.assertEquals(1001, login.getCode());
			Assertions.assertEquals("email: 7000 &password: ", login.getMessage());
		}
		System.out.println("Unit 4: Satisfied!");

	}

	@Test
	public void unitTest05() {

//		Failed: truyen len null nhung lai tra ve sai mk

		// Run 3 test cases
		System.out.println("If password is null, code should be 1001 and msg should be email: 7000 &password: ");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 3; i++) {
			login.Test01(email.getSaltString() + "@gmail.com", null);
			Assertions.assertEquals(1001, login.getCode());
			Assertions.assertEquals("email:  &password: 7000", login.getMessage());
		}
		System.out.println("Finished! Satisfied!");

	}

	@Test
	public void unitTest06() {
		// Run 3 test cases
		System.out.println("If password is empty, code should be 1001 and msg should be ");
		System.out.println("Testing unit6...");
		for (int i = 1; i <= 3; i++) {
			String random = email.getSaltString();
//			System.out.println(i + ":" + random + "@gmail.com");
			login.Test01(random + "@gmail.com", "");
//			System.out.println(login.getCode() + " /// " + login.getMessage() + ".");
			Assertions.assertEquals(1001, login.getCode());
			Assertions.assertEquals("email:  &password: 7000", login.getMessage());

		}
		System.out.println("Unit 6: Satisfied!");
	}

	@Test
	public void unitTest07() {
		// Run 3 test cases
		System.out.println("If email is long but not more than 255 characters and password is incorrect, "
				+ "response code should be 1002 and message should be メールとパスワードは違いました");
		System.out.println("Testing unit7...");
		for (int i = 230; i <= 233; i++) {
			String random = email.getStringWithFixedLength(i) + "@gmail.com";
			System.out.println(random);
			System.out.println(random.length());
			login.Test01(random, "123123");
			Assertions.assertEquals(1002, login.getCode());
			Assertions.assertEquals("メールとパスワードは違いました", login.getMessage());
		}
		System.out.println("Unit 7: Satisfied!");
	}

	@Test
	public void unitTest08() {
		// Run 3 test cases
		System.out
				.println("If email is more than 255 characters and password is incorrect, response code should be 1001 "
						+ "and message should be email: 7002 &password: ");
		System.out.println("Testing unit8...");
		for (int i = 250; i <= 253; i++) {
			String random = email.getStringWithFixedLength(i) + "@gmail.com";
//			System.out.println(random);
			login.Test01(random, "123123");
			Assertions.assertEquals(1001, login.getCode());
			Assertions.assertEquals("email: 7001 &password: ", login.getMessage());
		}
		System.out.println("Unit 8: Satisfied!");
	}

	@Test
	// trung@gmail.com, 1234567
	public void unitTest09() {
		System.out.println("If email is about 250 characters and password is correct, "
				+ "response code should be 1000 and data should not be null");
		// Thay bang signup
		// XmYxGE4Qm4Kg2yZ7lCEXfJAGlmrQC4i9uSvEuDcatmQn1MLpnHbSZ6OLj2KgIYj2KDD2ZvkvXcmbBPsB064vRjKfVc4qjqr1d01opFEJYFSeK0daXIeGvxHttRVXUUpX9ZQpDHmvEhrj7W9XZgkkEmKRhQSrJjULBSPgvOETz1mZRYYDZr1fpjGrfUo3UBd3FqChvqIUNeZfURtutUkNhrdP4XPqJv15c8mRy1aFXaZFgDHy@gmail.com
		// mail nay da signup
		String mail_250 = "ZpRqF16RPhjias47dy4EvTAB5P9AceT67ofnmhNygSc99iKANRF6I3ln0DlWcx51qQrWngygTTuIL4hSxaEQ1AnH3ACUHccbCUCr0TU87XE12"
				+ "34561234Qh6KBPAouC43sAWJpsHM93IMaycJgNXV40cQiW57INGkH3UtoU7oLgEX6KVNoAOGTDFLBrTg3CTF0vpYkGzCdkSEWjdXADvVmVDduYZ57si3FlljNnp8KR1zgRJ@gmail.com";
		System.out.println("Testing unit9...");
		login.Test01(mail_250, "1234567");
		Assertions.assertEquals(1000, login.getCode());
		Assertions.assertNotEquals(null, login.getData());

		String mail_250_2 = "XmYxGE4Qm4Kg2yZ7lCEXfJAGlmrQC4i9uSvEuDcatmQn1MLpnHbSZ6OLj2KgIYj2KDD2ZvkvXcmbBPsB064vRjKfVc4qjqr1d01opFEJYFSeK0daXIeGvxHttRVXUUpX9ZQpDHmvEhrj7W9XZgkkEmKRhQSrJjULBSPgvOETz1mZRYYDZr1fpjGrfUo3UBd3FqChvqIUNeZfURtutUkNhrdP4XPqJv15c8mRy1aFXaZFgDHy@gmail.com";
		login.Test01(mail_250_2, "1234567");
		Assertions.assertEquals(1000, login.getCode());
		Assertions.assertNotEquals(null, login.getData());

		System.out.println("Unit 9: Satisfied!");
	}

	@Test
	public void unitTest10() {
		System.out.println("If email is not formatted properly, "
				+ "response code should be 1001 and message should be email: 7002 &password:");
		System.out.println("Testing unit10...");
		for (int i = 1; i <= 3; i++) {
			String random = email.getSaltString();
			if (i % 3 == 0) {
				login.Test01(random, "1233456");
				Assertions.assertEquals(1001, login.getCode());
				Assertions.assertEquals("email: 7002 &password: ", login.getMessage());
			} else if (i % 3 == 1) {
				login.Test01(random + "@", "1233456");
				Assertions.assertEquals(1001, login.getCode());
				Assertions.assertEquals("email: 7002 &password: ", login.getMessage());
			} else {
				login.Test01(random + "@gmail", "1233456");
				Assertions.assertEquals(1001, login.getCode());
				Assertions.assertEquals("email: 7002 &password: ", login.getMessage());
			}
		}

		System.out.println("Unit 10: Satisfied");
	}

	@Test
	public void unitTest11() {
		System.out.println("If email is properly formatted but password is longer than 255 characters, "
				+ "response code should be 1001 and message should be email:  &password: 7001");
		System.out.println("Testing unit11...");
		for (int i = 1; i <= 3; i++) {
			String random = email.getStringWithFixedLength(257);
			login.Test01("trung@gmail.com", random);
			Assertions.assertEquals(1001, login.getCode());
			Assertions.assertEquals("email:  &password: 7001", login.getMessage());
		}
		System.out.println("Unit 11: Satisfied");
	}

	@Test
	public void unitTest12() {
		// If email and password are correct, response code shoule be 1000 and data is
		// not null
		System.out.println("If email and password are correct, response code shoule be 1000 and data is not null");
		System.out.println("Testing unit12...");

		/*
		 * Sau nay doan nay thay bang 1 loat signup va xoa account
		 */

		login.Test01("trung@gmail.com", "1234567");
		Assertions.assertEquals(1000, login.getCode());
		Assertions.assertEquals("OK", login.getMessage());
		Assertions.assertNotEquals(null, login.getData());

		System.out.println("Unit 12: Satisfied!");
	}

	@Test
	public void unitTest13() {
		// If password is incorrect, response code should be 1002, and message should be
		// ãƒ¡ãƒ¼ãƒ«ï¿½?ï¿½ãƒ‘ã‚¹ãƒ¯ãƒ¼ãƒ‰ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½
		System.out.println(
				"If password is incorrect, response code should be 1002, and message should be メールとパスワードは違いました");
		SignUp signUp = new SignUp();
		for (int i = 1; i <= 10; i++) {
			String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
			String randomPass = email.getStringWithFixedLength(10);
			signUp.Test02(randomMail, randomPass, randomPass, null, "Hoang Trung", "03830090109", null);
			login.Test01(randomMail, randomPass + i);
			System.out.println("Testing unit13...");
			Assertions.assertEquals(1002, login.getCode());
			Assertions.assertEquals("メールとパスワードは違いました", login.getMessage());
		}

		System.out.println("Unit 13: Satisfied!");
	}

	@Test
	public void unitTest14() {
		// If we use the admin account,response code should be 1000, message should be
		// OK and the role in data should be 1
		System.out.println(
				"If we use the admin account,response code should be 1000, message should be OK and the role in data should be 1");
		System.out.println("Testing unit14...");
		login.Test01("devAdmin@gmail.com", "123456");
		Assertions.assertEquals(1000, login.getCode());
		Assertions.assertEquals("OK", login.getMessage());
		Assertions.assertEquals("1", login.getData().user.role);
		System.out.println("Unit 14: Satisfied");
	}

	@Test
	public void unitTest15() {
		// If we log in an account that is not admin, code should be 1000, , message
		// should be OK and the role should be 2
		System.out.println(
				"If we log in an account that is not admin, code should be 1000, message should be OK and the role should be 2");
		System.out.println("Testing unit 15...");
		login.Test01("trung@gmail.com", "1234567");
		Assertions.assertEquals(1000, login.getCode());
		Assertions.assertEquals("OK", login.getMessage());
		Assertions.assertEquals("2", login.getData().user.role);
		System.out.println("Unit 15: Satisfied");
	}

	@Test
	public void unitTest16() {
		// If we login in an proper account, access_token should not be null, token_type
		// should be bearer and expires_in should not be null
		System.out.println("If we login in an proper account, access_token should not be null,"
				+ " token_type should be bearer and expires_in should not be null");
		System.out.println("Testing unit 16...");
		login.Test01("trung@gmail.com", "1234567");
		Assertions.assertNotEquals(null, login.getData().access_token);
		Assertions.assertEquals("bearer", login.getData().token_type);
		Assertions.assertNotEquals(null, login.getData().expires_in);
		System.out.println("Unit 16: Satisfied");
	}

	// Test 20 la du
}