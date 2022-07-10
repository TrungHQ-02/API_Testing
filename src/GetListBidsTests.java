
import java.util.Random;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class GetListBidsTests {
	GetListBids bidList = new GetListBids();
	Random random = new Random();
	RandomEmail randomString = new RandomEmail();

	// On
	@Test
	public void unitTest1() {
		// Code 1000 message OK
		System.out.println("Code should be 1000 and message should be OK with the valid input");
		System.out.println("Testing unit1...");
		bidList.Test22(1, 1, 1, null);
		Assertions.assertEquals(1000, bidList.getCode());
		Assertions.assertEquals("OK", bidList.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		System.out.println("Code should be 1000 and message should be OK with the negative input for index and count");
		System.out.println("Testing unit2...");
		for (int i = 1; i <= 2; i++) {
			int randomId = random.nextInt(1,3);
			int randomIndex = random.nextInt(-5,-1);
			int randomCount = random.nextInt(-5,-1);
			bidList.Test22(randomId, randomIndex, randomCount, null);
			Assertions.assertEquals(1000, bidList.getCode());
			Assertions.assertEquals("OK", bidList.getMessage());
		}
		System.out.println("Unit 2: Satisfied!");
	}

	@Test
	public void unitTest3() {
		System.out.println("Code should be 1000 and message should be OK even when token is wrong");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 2; i++) {
			int randomId = random.nextInt(1, 3);
			int randomIndex = random.nextInt(1, 4);
			int randomCount = random.nextInt(1, 5);
			String random_token = randomString.getStringWithFixedLength(100);
			bidList.Test22(randomId, randomIndex, randomCount, random_token);
			Assertions.assertEquals(1000, bidList.getCode());
			Assertions.assertEquals("OK", bidList.getMessage());
		}
		System.out.println("Unit 3: Satisfied!");
	}

	@Test
	public void unitTest4() {
		System.out.println("User name should not be null");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 2; i++) {
			int randomId = random.nextInt(1, 3);
			int randomIndex = random.nextInt(1, 10);
			int randomCount = random.nextInt(1, 10);
			bidList.Test22(randomId, randomIndex, randomCount, null);
			Bid[] listOfBids = bidList.getData().bids.clone();
			for (Bid bid : listOfBids) {
				Assertions.assertNotEquals(null, bid.user_name);
			}
		}
		System.out.println("Unit 4: Satisfied!");
	}

	@Test
	public void unitTest5() {
		System.out.println("Update time should not be null");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 2; i++) {
			int randomId = random.nextInt(1, 3);
			int randomIndex = random.nextInt(1, 4);
			int randomCount = random.nextInt(1, 5);
			bidList.Test22(randomId, randomIndex, randomCount, null);
			Bid[] listOfBids = bidList.getData().bids.clone();
			for (Bid bid : listOfBids) {
				Assertions.assertNotEquals(null, bid.updated_at);
			}
		}
		System.out.println("Finished! Satisfied!");
	}

	@Test
	public void unitTest6() {
		System.out.println("Total of bids should be greater than or equals to zero");
		System.out.println("Testing unit6...");
		for (int i = 1; i <= 2; i++) {
			int randomId = random.nextInt(1, 3);
			int randomIndex = random.nextInt(1, 4);
			int randomCount = random.nextInt(1, 5);
			bidList.Test22(randomId, randomIndex, randomCount, null);
			int totalAuctions = Integer.parseInt(bidList.getData().total);
			Assertions.assertTrue(totalAuctions >= 0);
		}
		System.out.println("Unit 6: Satisfied!");
	}
}