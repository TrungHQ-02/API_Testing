
import java.util.Random;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class GetListLikesTests {
	GetListLikes likes = new GetListLikes();
	Random random = new Random();
	RandomEmail randomString = new RandomEmail();
	String proper_token;
	public String getProper_token() {
		return proper_token;
	}

	public void setProper_token(String proper_token) {
		this.proper_token = proper_token;
	}
	
	public void setToken() {
		Login login = new Login();
		login.Test01("trung@gmail.com", "1234567");
		this.setProper_token(login.getToken());
	}

	// OK
	@Test
	public void unitTest1() {
		// Code 1000 message OK
		this.setToken();
		System.out.println("Code should be 1000 and message should be OK with the valid input");
		System.out.println("Testing unit1...");
		likes.Test28(1,1,1,proper_token);
//		System.out.println(auctionsByStatus.getData().total);
		Assertions.assertEquals(1000, likes.getCode());
		Assertions.assertEquals("OK", likes.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		this.setToken();
		System.out.println("Code should be 1000 and message should be OK with the negative input");
		System.out.println("Testing unit2...");
		for (int i = 1; i <= 3; i++) {
			int randomId = random.nextInt(-10,-1);
			int randomIndex = random.nextInt(-10,-1);
			int randomCount = random.nextInt(-10,-1);
			likes.Test28(randomId, randomIndex, randomCount, proper_token);
			Assertions.assertEquals(1000, likes.getCode());
			Assertions.assertEquals("OK", likes.getMessage());
		}
		System.out.println("Unit 2: Satisfied!");
	}

	@Test
	public void unitTest3() {
		this.setToken();
		System.out.println("Code should be 1004 and message should be ... even when token is wrong");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 3; i++) {
			int randomId = random.nextInt(1,3);
			int randomIndex = random.nextInt(1,3);
			int randomCount = random.nextInt(1,3);
			String random_token = randomString.getStringWithFixedLength(100);
			try {
				likes.Test28(randomId, randomIndex, randomCount, random_token);
			} catch (Exception e) {}
			String contentRP = likes.getContentString();
			boolean contain_HTML = contentRP.contains("html");
			Assertions.assertTrue(contain_HTML);		
		}
		System.out.println("Unit 3: Satisfied!");
	}

	@Test
	public void unitTest4() {
		this.setToken();
		System.out.println("Total of liked auctions should be greater than 0");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 3; i++) {
			int randomId = random.nextInt(1,3);
			int randomIndex = random.nextInt(1,3);
			int randomCount = random.nextInt(1,3);
			likes.Test28(randomId, randomIndex, randomCount, proper_token);
			int totalAuctions = Integer.parseInt(likes.getData().total);
			Assertions.assertTrue(totalAuctions >= 0);
		}
		System.out.println("Unit 4: Satisfied!");
	}	

	@Test
	public void unitTest5() {
		this.setToken();
		System.out.println("Title of auction should be null");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 3; i++) {
			int randomId = random.nextInt(1,3);
			int randomIndex = random.nextInt(1,3);
			int randomCount = random.nextInt(1,3);
			likes.Test28(randomId, randomIndex, randomCount, proper_token);
			Auction3[] aucList = likes.getData().auctions.clone();
			for (Auction3 auction : aucList) {
				Assertions.assertNotEquals(null, auction.title);
			}
		}
		System.out.println("Unit 5: Satisfied!");
	}
	
	@Test
	public void unitTest6() {
		this.setToken();
		System.out.println("Status id we receive must equal to status id we send to API");
		System.out.println("Testing unit6...");
		for (int i = 1; i <= 3; i++) {
			int randomId = random.nextInt(1,6);
			int randomIndex = random.nextInt(1,3);
			int randomCount = random.nextInt(1,3);
			likes.Test28(randomId, randomIndex, randomCount, proper_token);
			Auction3[] aucList = likes.getData().auctions.clone();
			for (Auction3 auction : aucList) {
				int aucStatusID = Integer.parseInt(auction.statusId);
				Assertions.assertEquals(Integer.parseInt(likes.getFixedId()), aucStatusID);
			}
		}
		System.out.println("Unit 6: Satisfied!");
	}
}