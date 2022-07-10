
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

// Trung
public class DeleteNotificationTests {
	DeleteNotification deleteNotification = new DeleteNotification();
	Random rand = new Random();
	RandomEmail randomString = new RandomEmail();
	String proper_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3NDMwNzA0LCJleHAiOjE2NTc3OTA3MDQsIm5iZiI6MTY1NzQzMDcwNCwianRpIjoiMExRU0c1cmljalNGMUd6eSIsInN1YiI6NDU3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.sXq6QPW5yt1VRsotsAXWhCJWob6xdil3DGDV9P4twfA";

	// OK
	@Test
	public void unitTest1() {
		System.out.println(
				"If we use the proper account, code should be 1000/1006 and message should be OK/Không có quyền");
		System.out.println("Testing unit1...");
		deleteNotification.Test22(proper_token, 1 + "");
		Assertions.assertTrue(deleteNotification.getCode() == 1000 || deleteNotification.getCode() == 1006);
//		Assertions.assertTrue(deleteNotification.getMessage() == "OK" 
//				|| deleteNotification.getMessage() == "Không có quyền");

		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		System.out.println("If we use the negative id, code should not be 1000 and message should be OK");
		System.out.println("Testing unit2...");
		for (int i = 1; i <= 10; i++) {
			int random_auctionId = rand.nextInt(-100, -10);
			deleteNotification.Test22(proper_token, random_auctionId + "");
			Assertions.assertTrue(deleteNotification.getCode() == 1000 || deleteNotification.getCode() == 1006);
//			Assertions.assertEquals("OK", deleteNotification.getMessage());
		}
		System.out.println("Unit 2: Satisfied");

	}

	@Test
	public void unitTest3() {
		System.out.println("Using the wrong token");
		System.out.println("Testing unit3...");
		int random_auctionId = rand.nextInt(1, 100);
		deleteNotification.setNum(3);
		deleteNotification.Test22(proper_token + "abc", random_auctionId + "");
	}
}
