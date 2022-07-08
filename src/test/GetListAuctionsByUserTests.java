package test;
import java.util.Random;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class GetListAuctionsByUserTests {
	GetListAuctionsByUser auctionsByUser = new GetListAuctionsByUser();
	Random random = new Random();
	RandomEmail randomString = new RandomEmail();
	String proper_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHA"
			+ "uY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MTAwMTY3LCJleHAiOjE2NTc0NjAxNjcsIm5iZiI6MTY1NzEwMDE2NywianRpIjoiWH"
			+ "dET3NROWtiVm9FY1czYiIsInN1YiI6NDU3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0."
			+ "Kn0DlO1VR5Dary4k9iM54zKp1zIhM-f9IB7BTscIFrY";

	@Test
	public void unitTest1() {
		// Code 1000 message OK
		System.out.println("Code should be 1000 and message should be OK with the valid input");
		System.out.println("Testing unit1...");
		auctionsByUser.Test08(1, 1, 1, proper_token);
//		System.out.println(auctionsByUser.getData().total);
		Assertions.assertEquals(1000, auctionsByUser.getCode());
		Assertions.assertEquals("OK", auctionsByUser.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		System.out.println("Code should be 1000 and message should be OK with the negative input");
		System.out.println("Testing unit2...");
		for (int i = 1; i <= 10; i++) {
			int randomId = random.nextInt(-1000,-1);
			int randomIndex = random.nextInt(-1000,-1);
			int randomCount = random.nextInt(-1000,-1);
			auctionsByUser.Test08(randomId, randomIndex, randomCount, proper_token);
			Assertions.assertEquals(1000, auctionsByUser.getCode());
			Assertions.assertEquals("OK", auctionsByUser.getMessage());
		}
		System.out.println("Unit 2: Satisfied!");
	}

	@Test
	public void unitTest3() {
		System.out.println("Code should be 1004 and message should be ã?¾ã? ãƒ­ã‚°ã‚¤ãƒ³ã?§ã?¯ã?‚ã‚Šã?¾ã?›ã‚“ even when token is wrong");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 10; i++) {
			int randomId = random.nextInt(1,10);
			int randomIndex = random.nextInt(1,10);
			int randomCount = random.nextInt(1,10);
			String random_token = randomString.getStringWithFixedLength(100);
			try {
				auctionsByUser.Test08(randomId, randomIndex, randomCount, random_token);
			} catch (Exception e) {}
			String contentRP = auctionsByUser.getContent();
			boolean contain_HTML = contentRP.contains("html");
			Assertions.assertTrue(contain_HTML);		
		}
		System.out.println("Unit 3: Satisfied!");
	}

	@Test
	public void unitTest4() {
		System.out.println("Status Id should be 1,2,3,4,5,6");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 10; i++) {
			int randomId = random.nextInt(1,1000);
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctionsByUser.Test08(randomId, randomIndex, randomCount, proper_token);
			Auction3[] aucList = auctionsByUser.getData().auctions.clone();
			for (Auction3 auction : aucList) {
				int aucID = Integer.parseInt(auction.statusId);
				Assertions.assertTrue(aucID == 1 || aucID == 2 || aucID == 3 || aucID == 4 || aucID == 5 || aucID == 6);
			}
		}
		System.out.println("Unit 4: Satisfied!");
	}
	

	@Test
	public void unitTest5() {
		System.out.println("Type id should be 1,2,3,4,5 ");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 10; i++) {
			int randomId = random.nextInt(1,1000);
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctionsByUser.Test08(randomId, randomIndex, randomCount, proper_token);
			Auction3[] aucList = auctionsByUser.getData().auctions.clone();
			for (Auction3 auction : aucList) {
				int aucID = Integer.parseInt(auction.catergory.type);
				Assertions.assertTrue(aucID == 1 || aucID == 2 || aucID == 3 || aucID == 4 || aucID == 5);
			}
		}
		System.out.println("Finished! Satisfied!");
	}

	@Test
	public void unitTest6() {
		System.out.println("Total of auctions should be greater than 0");
		System.out.println("Testing unit6...");
		for (int i = 1; i <= 10; i++) {
			int randomId = random.nextInt(1,1000);
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctionsByUser.Test08(randomId, randomIndex, randomCount, proper_token);
			int totalAuctions = Integer.parseInt(auctionsByUser.getData().total);
			Assertions.assertTrue(totalAuctions >= 0);
		}
		System.out.println("Unit 6: Satisfied!");
	}	

	@Test
	public void unitTest7() {
		System.out.println("Title of auction should be null");
		System.out.println("Testing unit7...");
		for (int i = 1; i <= 10; i++) {
			int randomId = random.nextInt(1,1000);
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctionsByUser.Test08(randomId, randomIndex, randomCount, proper_token);
			Auction3[] aucList = auctionsByUser.getData().auctions.clone();
			for (Auction3 auction : aucList) {
				Assertions.assertNotEquals(null, auction.title);
			}
		}
		System.out.println("Unit 7: Satisfied!");
	}
	
	@Test
	// bi sai
	public void unitTest8() {
		System.out.println("Status id we receive must equal to status id we send to API");
		System.out.println("Testing unit8...");
		for (int i = 1; i <= 10; i++) {
			int randomId = random.nextInt(1,6);
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctionsByUser.Test08(randomId, randomIndex, randomCount, proper_token);
			Auction3[] aucList = auctionsByUser.getData().auctions.clone();
			for (Auction3 auction : aucList) {
				int aucStatusID = Integer.parseInt(auction.statusId);
				Assertions.assertEquals(auctionsByUser.getFixedId(), aucStatusID);
			}
		}
		System.out.println("Unit 8: Satisfied!");
	}
}