
import java.util.Random;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class GetListAuctionsTests {
	GetListAuctions getListAuctions = new GetListAuctions();
	Random random = new Random();
	RandomEmail randomString = new RandomEmail();
	
	String proper_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3NDM3ODY3LCJleHAiOjE2NTc3OTc4NjcsIm5iZiI6MTY1NzQzNzg2NywianRpIjoiV1J0TFZmTnF4UmRuMFk3OSIsInN1YiI6NjIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.dTBXxQ2nQH2twRsZIcxkWPCm29j0G6BnPiWA9099L48";

	//int statusId, String user_id,String type, String category_id, int index, int count, String token
	
	// Day la 3 unit chung cho ca 3 TH
	// Vi 2 trong 3 phai null nen co 3 test cho 1000 OK
	
	@Test
	public void unitTest01() {
		// Code 1000 message OK
		System.out.println("Code should be 1000 and message should be OK with the valid input (only type)");
		System.out.println("Testing unit1...");
		getListAuctions.Test07(2, "", 2+"","",1,10, null);
		Assertions.assertEquals(1000, getListAuctions.getCode());
		Assertions.assertEquals("OK", getListAuctions.getMessage());
		System.out.println("Unit 1: Satisfied");
	}
	

	@Test
	public void unitTest02() {
		System.out.println("Code should be 1000 and message should be OK with the valid input (only category_id)");
		System.out.println("Testing unit2...");
		getListAuctions.Test07(2, "", "",2+"",1,10, null);
		Assertions.assertEquals(1000, getListAuctions.getCode());
		Assertions.assertEquals("OK", getListAuctions.getMessage());
		System.out.println("Unit 2: Satisfied");
	}

	@Test
	public void unitTest03() {
		System.out.println("Code should be 1000 and message should be OK with the valid input (only user_id)");
		System.out.println("Testing unit3...");
		getListAuctions.Test07(2, "", "",2+"",1,10, null);
		Assertions.assertEquals(1000, getListAuctions.getCode());
		Assertions.assertEquals("OK", getListAuctions.getMessage());
		System.out.println("Unit 3: Satisfied");
	}
	
	@Test
	public void unitTest22() {
		System.out.println("Code should be 1000 and message should be OK with the valid input (3 null)");
		System.out.println("Testing unit3...");
		getListAuctions.Test07(2, "", "","",1,10, null);
		Assertions.assertEquals(1000, getListAuctions.getCode());
		Assertions.assertEquals("OK", getListAuctions.getMessage());
		System.out.println("Unit 3: Satisfied");
	}
	
	
	
	
	
	// Test voi ca 3 truong deu null
	@Test
	public void unitTest23() {
		System.out.println("API should return all auctions whose status equals to what we send to API");
		System.out.println("Testing unit23...");
		for (int i = 1; i <= 5; i++) {
			getListAuctions.Test07(i, "", "","",i,10, null);
			AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
			for (AuctionForGLA auctionForGLA2 : auctionForGLA) {
				Assertions.assertEquals(getListAuctions.getFixedId(), auctionForGLA2.statusId);
			}
		}
		
		System.out.println("Unit 23: Satisfied");
	}
	
	
	@Test
	public void unitTest24() {
		System.out.println("Auction id should be greater than 0");
		System.out.println("Testing unit24...");
		for (int i = 1; i <= 5; i++) {
			getListAuctions.Test07(i, "", "","",i,10, null);
			AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
			for (AuctionForGLA auctionForGLA2 : auctionForGLA) {
				Assertions.assertTrue(Integer.parseInt(auctionForGLA2.auction_id) >= 0);;
			}
		}
		System.out.println("Unit 24: Satisfied");
	}
	
	@Test
	public void unitTest25() {
		System.out.println("Selling user id should be greater than 0");
		System.out.println("Testing unit25...");
		for (int i = 1; i <= 5; i++) {
			getListAuctions.Test07(i, "", "","",i,10, null);
			AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
			for (AuctionForGLA auctionForGLA2 : auctionForGLA) {
				Assertions.assertTrue(Integer.parseInt(auctionForGLA2.selling_user_id) >= 0);;
			}
		}
		System.out.println("Unit 25: Satisfied");
	}
	
	@Test
	public void unitTest26() {
		System.out.println("Title should not be null");
		System.out.println("Testing unit26...");
		for (int i = 1; i <= 5; i++) {
			getListAuctions.Test07(i, "", "","",i,10, null);
			AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
			for (AuctionForGLA auctionForGLA2 : auctionForGLA) {
				Assertions.assertNotEquals("", auctionForGLA2.title);
			}
		}
		System.out.println("Unit 26: Satisfied");
	}
	
	@Test
	public void unitTest27() {
		System.out.println("Auction Id of a auction must be different from others'");
		System.out.println("Testing unit26...");
		for (int i = 1; i <= 5; i++) {
			getListAuctions.Test07(i, "", "","",i,10, null);
			AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
			TreeSet<String> set = new TreeSet<String>();
			for (AuctionForGLA auctionForGLA2 : auctionForGLA) {
				set.add(auctionForGLA2.auction_id);
			}
			Assertions.assertEquals(auctionForGLA.length, set.size());
		}
		System.out.println("Unit 27: Satisfied");
	}
	
	@Test
	public void unitTest28() {
		System.out.println("Category should not be null");
		System.out.println("Testing unit28..");
		for (int i = 1; i <= 5; i++) {
			getListAuctions.Test07(i, "", "","",i,10, null);
			AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
			for (AuctionForGLA auctionForGLA2 : auctionForGLA) {
				Assertions.assertNotEquals(null, auctionForGLA2.category);
			}
		}
		System.out.println("Unit 28: Satisfied");
	}
	
	@Test
	public void unitTest29() {
		System.out.println("Category type should be 1 2 3 4 5");
		System.out.println("Testing unit29...");
		for (int i = 1; i <= 3; i++) {
			getListAuctions.Test07(i, "", "","",i,10, null);
			AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
			for (AuctionForGLA auctionForGLA2 : auctionForGLA) {
				boolean b = (Integer.parseInt(auctionForGLA2.category.type) == 1 ||
						Integer.parseInt(auctionForGLA2.category.type) == 2 ||
								Integer.parseInt(auctionForGLA2.category.type) == 3||
										Integer.parseInt(auctionForGLA2.category.type) == 4||
												Integer.parseInt(auctionForGLA2.category.type) == 5);
												
				Assertions.assertTrue(b);
			}
		}
		System.out.println("Unit 29: Satisfied");
	}
	
	@Test
	public void unitTest30() {
		System.out.println("Auction status id should not be 4");
		System.out.println("Testing unit24...");
		getListAuctions.Test07(4, "", "","",1,10, null);
		AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
		for (AuctionForGLA auction : auctionForGLA) {
			Assertions.assertNotEquals(4, Integer.parseInt(auction.statusId));
		}
		
		System.out.println("Unit 24: Satisfied");
	}
	
	@Test
	public void unitTest31() {
		System.out.println("User info should be null if we use 3 null param");
		System.out.println("Testing unit31..");
		for (int i = 1; i <= 3; i++) {
			getListAuctions.Test07(i, "", "","",i,10, null);
			Assertions.assertEquals(null, getListAuctions.getData().user_info);
		}
		System.out.println("Unit 28: Satisfied");
	}
	
	
	
	
	// test truyen type

	@Test
	public void unitTest32() {
		System.out.println("API should return all auctions that have type equals to what we send to API");
		System.out.println("Testing unit32...");
		for (int i = 1; i <= 5; i++) {
			getListAuctions.Test07(i, "", "2","",i,10, null);
			AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
			for (AuctionForGLA auctionForGLA2 : auctionForGLA) {
				Assertions.assertEquals(getListAuctions.getFixedType(), auctionForGLA2.category.type);
			}
		}
		
		System.out.println("Unit 32: Satisfied");
	}
	
	@Test
	public void unitTest33() {
		System.out.println("User info should be null if we use 2 null param");
		System.out.println("Testing unit33..");
		for (int i = 1; i <= 3; i++) {
			getListAuctions.Test07(i, "", i+"","",i,10, null);
			Assertions.assertEquals(null, getListAuctions.getData().user_info);
		}
		System.out.println("Unit 33: Satisfied");
	}
	
	@Test
	public void unitTest34() {
		System.out.println("Auction status id should not be 4");
		System.out.println("Testing unit34...");
		getListAuctions.Test07(4, "", "2","",1,10, null);
		AuctionForGLA[] auctionForGLA = getListAuctions.getData().auctions.clone();
		for (AuctionForGLA auction : auctionForGLA) {
			Assertions.assertNotEquals(4, Integer.parseInt(auction.statusId));
		}
		
		System.out.println("Unit 34: Satisfied");
	}
	
	// test truyeenf category id
}