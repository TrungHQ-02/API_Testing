
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;
// Trung
public class LikeAuctionTests {
	LikeAuction likeAuction = new LikeAuction();
	Random rand = new Random();
	RandomEmail randomString = new RandomEmail();
	String proper_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MzU5Nzc5LCJleHAiOjE2NTc3MTk3NzksIm5iZiI6MTY1NzM1OTc3OSwianRpIjoiOXNMSFczMm9HNjhFRkJlaCIsInN1YiI6MTAxNywicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.eKkxJrwX3rQVo8bA7aNlmUItFpK91E0kDzHrqKkWe50";

	// OK
	@Test
	public void unitTest1() {
		System.out.println("If we use the proper account, code should be 1000 and message should be OK");
		System.out.println("Testing unit1...");

		// Than Unit
		likeAuction.Test27(proper_token, 1 + "");
		Assertions.assertEquals(1000, likeAuction.getCode());
		Assertions.assertEquals("OK", likeAuction.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		System.out.println("If we use the negative id, code should be 1000 and message should be OK");
		System.out.println("Testing unit2...");
		for (int i = 1; i <= 2; i++) {
			int random_auctionId = rand.nextInt(-100, -10);
			likeAuction.Test27(proper_token, random_auctionId + "");
			Assertions.assertEquals(1000, likeAuction.getCode());
			Assertions.assertEquals("OK", likeAuction.getMessage());
		}
		System.out.println("Unit 2: Satisfied");

	}

	@Test
	public void unitTest3() {
		System.out.println("Auction ID which we use to post must equal to auction_id that we receive from API");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 2; i++) {
			int random_auctionId = rand.nextInt(1, 1000);
			likeAuction.Test27(proper_token, random_auctionId + "");
			Assertions.assertEquals(likeAuction.getAuction_id(), likeAuction.getData().auction_id);
		}
		System.out.println("Unit 3: Satisfied");
	}
	
	@Test
	public void unitTest4() {
		System.out.println("User ID should be a non-negative integer");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 2; i++) {
			int random_auctionId = rand.nextInt(1, 1000);
			likeAuction.Test27(proper_token, random_auctionId + "");
			Assertions.assertTrue(Integer.parseInt(likeAuction.getData().user_id) > 0);
		}
		System.out.println("Unit 4: Satisfied");
	}
	@Test
	public void unitTest5() {
		System.out.println("The is_liked field should be proper");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 2; i++) {
			int random_auctionId = rand.nextInt(1, 1000);
			likeAuction.Test27(proper_token, random_auctionId + "");
			if (likeAuction.getData().is_liked == "true") {
				likeAuction.Test27(proper_token, random_auctionId + "");
				Assertions.assertEquals("false", likeAuction.getData().is_liked);
			} else {
				likeAuction.Test27(proper_token, random_auctionId + "");
				Assertions.assertEquals("true", likeAuction.getData().is_liked);
			}
		}
		System.out.println("Unit 5: Satisfied");
	}
}
