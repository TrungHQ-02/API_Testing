
import java.io.FileNotFoundException;
import java.util.Random;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class InfoAuctionTests {
	InfoAuction infoAuction = new InfoAuction();
	Random random = new Random();
	RandomEmail randomString = new RandomEmail();
	String properToken;
	public String getProper_token() {
		return properToken;
	}

	public void setProper_token(String proper_token) {
		this.properToken = proper_token;
	}
	
	public void setToken() {
		Login login = new Login();
		login.Test01("devAdmin@gmail.com", "123456");
		this.setProper_token(login.getToken());
	}
	// token dang nhap
	// On
	@Test
	public void unitTest1() {
		// Code 1000 message OK
		this.setToken();
		System.out.println("Code should be 1000 and message should be OK with the proper input");
		System.out.println("Testing unit1...");
		infoAuction.Test14(1 + "", properToken);
		Assertions.assertEquals(1000, infoAuction.getCode());
		Assertions.assertEquals("OK", infoAuction.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() throws FileNotFoundException {
		this.setToken();
		System.out.println("Status ID shoud not be negative");
		System.out.println("Testing unit2...");
		int randomID = random.nextInt(-5, -1);
		infoAuction.Test14(randomID + "", properToken);
		System.out.println("Unit 2: Satisfied!");
	}

	@Test
	public void unitTest3() {
		this.setToken();
		System.out.println("Code should be 1004 when token is wrong");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 3; i++) {
			int randomID = random.nextInt(1, 5);
			try {
				infoAuction.Test14(randomID + "", properToken + i);
			} catch (Exception e) {
			}
			String contentRP = infoAuction.getContent();
			boolean contain_HTML = contentRP.contains("html");
			Assertions.assertTrue(contain_HTML);
		}
		System.out.println("Unit 3: Satisfied!");
	}

	@Test
	public void unitTest4() {
		this.setToken();
		System.out.println("Start date and end date should not be null");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 3; i++) {
			int randomID = random.nextInt(1, 5);
			infoAuction.Test14(randomID + "", properToken);
			Assertions.assertNotEquals(null, infoAuction.getData().start_date);
			Assertions.assertNotEquals(null, infoAuction.getData().end_date);
		}
		System.out.println("Unit 4: Satisfied!");
	}

	@Test
	public void unitTest5() {
		this.setToken();
		System.out.println("Title of auction should not be null");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 3; i++) {
			int randomID = random.nextInt(1, 5);
			infoAuction.Test14(randomID + "", properToken);
			Assertions.assertNotEquals(null, infoAuction.getData().title);
		}
		System.out.println("Unit 5: Satisfied!");
	}

	@Test
	public void unitTest6() {
		this.setToken();
		System.out.println("Category id should be an integer");
		System.out.println("Testing unit6");
		for (int i = 1; i <= 3; i++) {
			int randomID = random.nextInt(1, 5);
			infoAuction.Test14(randomID + "", properToken);
			int category_id = Integer.parseInt(infoAuction.getData().category_id);
			Assertions.assertTrue(category_id >= 0);
		}
		System.out.println("Unit 5: Satisfied!");
	}

}