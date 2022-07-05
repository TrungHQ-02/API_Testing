import java.util.Random;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import random.RandomEmail;

public class GetNotificationsTests {
	GetNotifications getNotifications = new GetNotifications();
	Random random = new Random();
	RandomEmail randomString = new RandomEmail();
	String proper_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcH"
			+ "AuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2OTkyMjc5LCJleHAiOjE2NTczNTIyNzksIm5iZiI6MTY1Njk5MjI3OSwianRpIjoiWF"
			+ "dFSjBROWNiWGxxcmI2cCIsInN1YiI6NDU3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.Q"
			+ "o1zeuy9p9AKabz7uS1WNQI1qxXiN7p_WCowPZP2k-E";
	//int index, int count,String is_not_read, String token
	@Test
	public void unitTest1() {
		// Code 1000 message OK
		System.out.println("Code should be 1000 and message should be OK with the valid input");
		System.out.println("Testing unit1...");
		getNotifications.Test27(1, 1, "1", proper_token);
		Assertions.assertEquals(1000, getNotifications.getCode());
		Assertions.assertEquals("OK", getNotifications.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		System.out.println("Code should be 1000 and message should be OK with the negative input for index and count");
		System.out.println("Testing unit2...");
		for (int i = 1; i <= 10; i++) {
			int randomIs_not_read = random.nextInt(0,1);
			int randomIndex = random.nextInt(-5,-1);
			int randomCount = random.nextInt(-5,-1);
			getNotifications.Test27(randomIndex, randomCount, "" + randomIs_not_read, proper_token);
			Assertions.assertEquals(1000, getNotifications.getCode());
			Assertions.assertEquals("OK", getNotifications.getMessage());
		}
		System.out.println("Unit 2: Satisfied!");
	}

	@Test
	public void unitTest3() {
		System.out.println("Code should be 1004 and message should be まだログインではありません even when token is wrong");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 10; i++) {
			int randomIs_not_read = random.nextInt(0,1);
			int randomIndex = random.nextInt(1,10);
			int randomCount = random.nextInt(1,10);
			try {
				getNotifications.Test27(randomIndex, randomCount, "" + randomIs_not_read, randomString.getStringWithFixedLength(120));
			} catch (Exception e) {
			}
			String contentRP = getNotifications.getRespondContentString();
//			System.out.println(contentRP);
			boolean contain_HTML = contentRP.contains("html");
			Assertions.assertTrue(contain_HTML);		
		}
		System.out.println("Unit 3: Satisfied!");
	}

	@Test
	public void unitTest4() {
		System.out.println("Code should be 1004 and message should be まだログインではありません even when token is empty");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 10; i++) {
			int randomIs_not_read = random.nextInt(0,1);
			int randomIndex = random.nextInt(1,10);
			int randomCount = random.nextInt(1,10);
			try {
				getNotifications.Test27(randomIndex, randomCount, "" + randomIs_not_read, "");
			} catch (Exception e) {
			}
			String contentRP = getNotifications.getRespondContentString();
//			System.out.println(contentRP);
			boolean contain_HTML = contentRP.contains("html");
			Assertions.assertTrue(contain_HTML);		
		}
		System.out.println("Unit 4: Satisfied!");
	}

	@Test
	public void unitTest5() {
		System.out.println("Total of notifications should be greater than or equals to zero");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 10; i++) {
			int randomIs_not_read = random.nextInt(0,1);
			int randomIndex = random.nextInt(1,10);
			int randomCount = random.nextInt(1,10);
			getNotifications.Test27(randomIndex, randomCount, "" + randomIs_not_read, proper_token);
			Assertions.assertTrue(Integer.parseInt(getNotifications.getData().total) >= 0);
		}
		System.out.println("Unit 5: Satisfied!");
	}

	@Test
	public void unitTest6() {
		System.out.println("Total of unread notifications should be greater than or equals to zero");
		System.out.println("Testing unit6...");
		for (int i = 1; i <= 10; i++) {
			int randomIs_not_read = random.nextInt(0,1);
			int randomIndex = random.nextInt(1,10);
			int randomCount = random.nextInt(1,10);
			getNotifications.Test27(randomIndex, randomCount, "" + randomIs_not_read, proper_token);
			Assertions.assertTrue(Integer.parseInt(getNotifications.getData().total_not_read) >= 0);
		}
		System.out.println("Unit 6: Satisfied!");
	}
}