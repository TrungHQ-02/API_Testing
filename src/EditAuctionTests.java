import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import random.RandomEmail;

public class EditAuctionTests {
	EditAuction editAuction = new EditAuction();
	Random rand = new Random();
	RandomEmail randString = new RandomEmail();
	String proper_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcH"
			+ "AuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2OTkyMjc5LCJleHAiOjE2NTczNTIyNzksIm5iZiI6MTY1Njk5MjI3OSwianRpIjoiWF"
			+ "dFSjBROWNiWGxxcmI2cCIsInN1YiI6NDU3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.Q"
			+ "o1zeuy9p9AKabz7uS1WNQI1qxXiN7p_WCowPZP2k-E";

	// String auctionId, int category_id, String start_date, String end_date, String
	// title_ni,String accessToken
	@Test
	public void unitTest1() {
		System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
		System.out.println("Testing unit1...");
		editAuction.Test12("100", 2, null, null, "Nguyen Mai Huyen", proper_token);
		Assertions.assertEquals(1000, editAuction.getCode());
		Assertions.assertEquals("OK", editAuction.getMessage());
	}
	
	@Test
	public void unitTest2() {
		System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
		System.out.println("Testing unit2...");
		editAuction.Test12("100", 2, null, null, "Nguyen Mai Huyen", proper_token);
		Assertions.assertEquals(1000, editAuction.getCode());
		Assertions.assertEquals("OK", editAuction.getMessage());
	}

}
