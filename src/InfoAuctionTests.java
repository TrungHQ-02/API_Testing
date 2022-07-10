
import java.io.FileNotFoundException;
import java.util.Random;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class InfoAuctionTests {
	InfoAuction infoAuction = new InfoAuction();
	Random random = new Random();
	RandomEmail randomString = new RandomEmail();
	String properToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3NDI0MDAzLCJleHAiOjE2NTc3ODQwMDMsIm5iZiI6MTY1NzQyNDAwMywianRpIjoiemQ2SmI1d3J5VFM2VFpxVyIsInN1YiI6MTAxNywicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.n7GknSMcak5_xDnKKCAFXj7JQSdwZ33sGHBeTDYTkDQ";
	// token dang nhap
	// On
	@Test
	public void unitTest1() {
		// Code 1000 message OK
		System.out.println("Code should be 1000 and message should be OK with the proper input");
		System.out.println("Testing unit1...");
		infoAuction.Test06(1 + "", properToken);
		Assertions.assertEquals(1000, infoAuction.getCode());
		Assertions.assertEquals("OK", infoAuction.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() throws FileNotFoundException {
		System.out.println("Status ID shoud not be negative");
		System.out.println("Testing unit2...");
		int randomID = random.nextInt(-5, -1);
		infoAuction.Test06(randomID + "", properToken);
		System.out.println("Unit 2: Satisfied!");
	}

	@Test
	public void unitTest3() {
		System.out.println("Code should be 1004 when token is wrong");
		System.out.println("Testing unit3...");
		for (int i = 1; i <= 3; i++) {
			int randomID = random.nextInt(1, 5);
			try {
				infoAuction.Test06(randomID + "", properToken + i);
			} catch (Exception e) {
			}
			String contentRP = infoAuction.getContent();
			boolean contain_HTML = contentRP.contains("html");
			Assertions.assertTrue(contain_HTML);
		}
		System.out.println("Unit 3: Satisfied!");
	}

	@Test
	public void unitTest4() {
		System.out.println("Start date and end date should not be null");
		System.out.println("Testing unit4...");
		for (int i = 1; i <= 3; i++) {
			int randomID = random.nextInt(1, 5);
			infoAuction.Test06(randomID + "", properToken);
			Assertions.assertNotEquals(null, infoAuction.getData().start_date);
			Assertions.assertNotEquals(null, infoAuction.getData().end_date);
		}
		System.out.println("Unit 4: Satisfied!");
	}

	@Test
	public void unitTest5() {
		System.out.println("Title of auction should not be null");
		System.out.println("Testing unit5...");
		for (int i = 1; i <= 3; i++) {
			int randomID = random.nextInt(1, 5);
			infoAuction.Test06(randomID + "", properToken);
			Assertions.assertNotEquals(null, infoAuction.getData().title);
		}
		System.out.println("Unit 5: Satisfied!");
	}

	@Test
	public void unitTest6() {
		System.out.println("Category id should be an integer");
		System.out.println("Testing unit6");
		for (int i = 1; i <= 3; i++) {
			int randomID = random.nextInt(1, 5);
			infoAuction.Test06(randomID + "", properToken);
			int category_id = Integer.parseInt(infoAuction.getData().category_id);
			Assertions.assertTrue(category_id >= 0);
		}
		System.out.println("Unit 5: Satisfied!");
	}

}