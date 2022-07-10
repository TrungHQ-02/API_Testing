
import java.util.Random;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class GetListAuctionsTests {
	GetListAuctions auctions = new GetListAuctions();
	Random random = new Random();
	RandomEmail randomString = new RandomEmail();
<<<<<<< HEAD
	
	String proper_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3NDYzNzkzLCJleHAiOjE2NTc4MjM3OTMsIm5iZiI6MTY1NzQ2Mzc5MywianRpIjoiazkxTnBTaUNrUXdZNkwyVyIsInN1YiI6NjIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.lhm9cDZ1jJe0nSydM7oQEEW2T8O9KY892b9tlArGRDk";
=======
>>>>>>> parent of 1ef17d4 (Merge branch 'master' of https://github.com/TrungHQ-02/API_Testing)

	// On
	@Test
	public void unitTest1() {
		// Code 1000 message OK
		System.out.println("Code should be 1000 and message should be OK with the valid input");
		System.out.println("Testing unit1...");
		auctions.Test06(1, 1, null);
//		System.out.println(auctions.getData().total);
		Assertions.assertEquals(1000, auctions.getCode());
		Assertions.assertEquals("OK", auctions.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		System.out.println("Code should be 1000 and message should be OK with the negative input");
		System.out.println("Testing unit2...");
		for (int i = 1; i <= 10; i++) {
			int randomIndex = random.nextInt(-1000,-1);
			int randomCount = random.nextInt(-1000,-1);
			auctions.Test06(randomIndex, randomCount, null);
			Assertions.assertEquals(1000, auctions.getCode());
			Assertions.assertEquals("OK", auctions.getMessage());
		}
		System.out.println("Unit 2: Satisfied!");
	}

	@Test
	public void unitTest3() {
		System.out.println("Code should be 1000 and message should be OK even when token is wrong");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 10; i++) {
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			String random_token = randomString.getStringWithFixedLength(100);
			auctions.Test06(randomIndex, randomCount, random_token);
			Assertions.assertEquals(1000, auctions.getCode());
			Assertions.assertEquals("OK", auctions.getMessage());
		}
		System.out.println("Unit 3: Satisfied!");
	}

	@Test
	public void unitTest4() {
		System.out.println("Status Id should be from 1 to 6 (except 4)");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 20; i++) {
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctions.Test06(randomIndex, randomCount, null);
			Auction3[] aucList = auctions.getData().auctions.clone();
			for (Auction3 auction : aucList) {
				int aucID = Integer.parseInt(auction.statusId);
				Assertions.assertTrue(aucID == 1 || aucID == 2 || aucID == 3 || aucID == 5 || aucID == 6);
			}
		}
		System.out.println("Unit 4: Satisfied!");
	}
	

	@Test
	public void unitTest5() {
		System.out.println("Type id should be 1,2,3,4,5 ");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 10; i++) {
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctions.Test06(randomIndex, randomCount, null);
			Auction3[] aucList = auctions.getData().auctions.clone();
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
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctions.Test06(randomIndex, randomCount, null);
			int totalAuctions = Integer.parseInt(auctions.getData().total);
			Assertions.assertTrue(totalAuctions >= 0);
		}
		System.out.println("Unit 6: Satisfied!");
	}	

	@Test
	public void unitTest7() {
		System.out.println("Title of auction should be null");
		System.out.println("Testing unit7...");
		for (int i = 1; i <= 10; i++) {
			int randomIndex = random.nextInt(1,1000);
			int randomCount = random.nextInt(1,1000);
			auctions.Test06(randomIndex, randomCount, null);
			Auction3[] aucList = auctions.getData().auctions.clone();
			for (Auction3 auction : aucList) {
				Assertions.assertNotEquals(null, auction.title);
			}
		}
		System.out.println("Unit 7: Satisfied!");
	}
	
<<<<<<< HEAD
	@Test
	public void unitTest16() {
		System.out.println("Auction status id should not be 4");
		System.out.println("Testing unit16...");
		getListAuctions.Test07(4, "", "2","",1,10, null);
		AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
		for (AuctionForGLA auction : auctionForGLA) {
			Assertions.assertNotEquals(4, Integer.parseInt(auction.statusId));
		}
		
		System.out.println("Unit 16: Satisfied");
	}
	
	// test truyen category id
	@Test
	public void unitTest17() {
		System.out.println("Auction status id should not be 4 (using category id)");
		System.out.println("Testing unit17...");
		getListAuctions.Test07(4, "", "","2",1,10, null);
		AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
		for (AuctionForGLA auction : auctionForGLA) {
			Assertions.assertNotEquals(4, Integer.parseInt(auction.statusId));
		}
		
		System.out.println("Unit 17: Satisfied");
	}
	
	@Test
	public void unitTest18() {
		System.out.println("User info should be null if we use 2 null param");
		System.out.println("Testing unit18..");
		for (int i = 1; i <= 3; i++) {
			getListAuctions.Test07(i, "", "","2",i,10, null);
			Assertions.assertEquals(null, getListAuctions.getData().user_info);
		}
		System.out.println("Unit 18: Satisfied");
	}
	
	// test truyen user_id
	// Can token
	public void unitTest19() {
		System.out.println("Auction status id should not be 4 (using user_id)");
		System.out.println("Testing unit19...");
		getListAuctions.Test07(4, "", "","823",1,10, proper_token);
		AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
		for (AuctionForGLA auction : auctionForGLA) {
			Assertions.assertNotEquals(4, Integer.parseInt(auction.statusId));
		}
		
		System.out.println("Unit 17: Satisfied");
	}
	
	public void unitTest20() {
		System.out.println("User info fields should not be null");
		System.out.println("Testing unit20...");
		for (int i = 1; i <= 3; i++) {
			String randomID = random.nextInt(1, 20) + "";
			getListAuctions.Test07(i, "", "",randomID,i,10, proper_token);
			Assertions.assertNotEquals(null, getListAuctions.getData().user_info.name);
			Assertions.assertNotEquals(null, getListAuctions.getData().user_info.email);
			Assertions.assertNotEquals(null, getListAuctions.getData().user_info.phone);
		}
		System.out.println("Unit 20: Satisfied");
	}
=======
>>>>>>> parent of 1ef17d4 (Merge branch 'master' of https://github.com/TrungHQ-02/API_Testing)
}