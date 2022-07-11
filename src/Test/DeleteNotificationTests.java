
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

// Trung
public class DeleteNotificationTests {
	DeleteNotification deleteNotification = new DeleteNotification();
	Random rand = new Random();
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
		this.setToken();
		System.out.println(
				"If we use the proper account, code should be 1000/1006 and message should be OK/Khong co quyen");
		System.out.println("Testing unit1...");
		deleteNotification.Test22(proper_token, 1 + "");
		Assertions.assertTrue(deleteNotification.getCode() == 1000 || deleteNotification.getCode() == 1006);
//		Assertions.assertTrue(deleteNotification.getMessage() == "OK" 
//				|| deleteNotification.getMessage() == "Khong co quyen");

		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		this.setToken();
		System.out.println("If we use the negative id, code should not be 1000/1006 and message should not be OK/Khong co quyen");
		System.out.println("Testing unit2...");
		for (int i = 1; i <= 10; i++) {
			int random_auctionId = rand.nextInt(-100, -10);
			deleteNotification.Test22(proper_token, random_auctionId + "");
			Assertions.assertFalse(deleteNotification.getCode() == 1000 || deleteNotification.getCode() == 1006);
//			Assertions.assertFalse("OK", deleteNotification.getMessage());
		}
		System.out.println("Unit 2: Satisfied");

	}

	@Test
	public void unitTest3() {
		this.setToken();
		System.out.println("Using the wrong token");
		System.out.println("Testing unit3...");
		int random_auctionId = rand.nextInt(1, 100);
		deleteNotification.setNum(3);
		deleteNotification.Test22(proper_token + "abc", random_auctionId + "");
	}
}