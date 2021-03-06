

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;


public class EditAuctionTests {
	EditAuction editAuction = new EditAuction();
	Random rand = new Random();
	RandomEmail randString = new RandomEmail();
	Login login = new Login();
	Logout logout = new Logout();
	//String proper_token = "";
	// String auctionId, int category_id, String start_date, String end_date, String
	// title_ni,String accessToken
	@Test
	public void unitTest01() {
		int top = 3;
		char data = ' ';
		String title = "";
		for (int i=0; i<=top; i++) {
			data = (char)(rand.nextInt(25)+97);
			title = data + title;
		}
		//chinh sua phien dau gia ch dc duyet
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
		System.out.println("Testing unit1...");
		editAuction.Test12("515", "1", "2024/07/09 11:11", "2024/09/09 11:11", title, login.getToken());
		Assertions.assertEquals(1000, editAuction.getCode());
		Assertions.assertEquals("OK", editAuction.getMessage());
		System.out.println("Unit 1: Satisfied!");
	}
	@Test
	public void unitTest02() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("if auctions have been approved, Server will return code 1005");
		//auciton dc duyet roi thi k sua duoc
		System.out.println("Testing unit2...");
		editAuction.Test12("513", "1", null, null, "Dragonia", login.getToken());
		Assertions.assertEquals(1005, editAuction.getCode());
		Assertions.assertEquals("Không thể chỉnh sửa", editAuction.getMessage());
		System.out.println("Unit 2: Satisfied!");
	}
	@Test
	//loi chua dang nhap
	public void unitTest03() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		//loi ch dang nhap
        logout.Test06(login.getToken());
		System.out.println("If we not input yet, Server will return code 1004");
		System.out.println("Testing unit3...");
		editAuction.Test12("515", "1", null, null, "Dagoiaffaiiiii",login.getToken());
		Assertions.assertEquals(1004, editAuction.getCode());
		System.out.println("Unit 3: Satisfied!");
	}
	@Test
	public void unitTest04() {
		//khong co quyen chinh sua nhung cai k do user tao
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("if the auctions are created by someone else,Server will return code 1006");
		System.out.println("Testing unit4...");
		editAuction.Test12("443", "1", null, null, null, login.getToken());
		Assertions.assertEquals(1006, editAuction.getCode());
		Assertions.assertEquals("Không có quyền chỉnh sửa", editAuction.getMessage());
		System.out.println("Unit 4: Satisfied!");
	}
	@Test
	public void unitTest05() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("no 'category_id' field entered or the value exists, Server will return code 1001");
		System.out.println("Testing unit5...");
		editAuction.Test12("515", "", null, null, null, login.getToken());
		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 5: Satisfied!");
	}
	@Test
	public void unitTest06() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("field 'start_date' has not been entered, Server will return code 1001");
		System.out.println("Testing unit6...");
		editAuction.Test12("515",null, "", null, null,login.getToken());
		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 6: Satisfied!");
	}
	@Test
	public void unitTest07() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("Data format of field 'start_date' incorrect, Server will return code 1001");
		System.out.println("Testing unit7...");
		editAuction.Test12("515",null, "2023_06_20", null, null,login.getToken());
		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 7: Satisfied!");
	}
	@Test
	public void unitTest08() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("start time must be one day from current time, Server will return code 1001");
		System.out.println("Testing unit8...");
		editAuction.Test12("515", null, "2021/06/21 11:11", null,null,login.getToken());
		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 8: Satisfied!");
	}

	@Test
	public void unitTest09() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("field 'end_date' has not been entered, Server will return code 1001");
		System.out.println("Testing unit9...");
		editAuction.Test12("515", "1", null, "",null,login.getToken());
		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 9: Satisfied!");
	}
	@Test
	public void unitTest10() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("Data format of field 'end_date' incorrect, Server will return code 1001");
		System.out.println("Testing unit10...");
		editAuction.Test12("515", null ,null, "22_03_03", null, login.getToken());
		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 10: Satisfied!");
	}
	@Test
	public void unitTest11() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("the end time must be greater than the start time, Server will return code 1001");
		System.out.println("Testing unit11...");
		editAuction.Test12("515", null, "2023/06/25 11:11", "2023/06/21 11:11", null, login.getToken());
		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 11: Satisfied!");
	}
	@Test
	public void unitTest12() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("field 'title_ni' has not been entered, Server will return code 1001");
		System.out.println("Testing unit12...");
		editAuction.Test12("515", null, null, null, "", login.getToken());

		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 12: Satisfied!");
	}
	@Test
	public void unitTest13() {
		login.Test01("trinhquan100402@gmail.com", "1004");
		System.out.println("Auction title is unique, Server will return code 1001");
		System.out.println("Testing unit11...");
		editAuction.Test12("515", null, null, null, "abcc", login.getToken());
		Assertions.assertEquals(1001, editAuction.getCode());
		System.out.println("Unit 11: Satisfied!");

//		        "auction_id": 515,
//				"category_id": "1",
//				"title": "Acameraaaa",
//				"start_date": "2024/07/09 11:11",
//				"end_date": "2024/08/21 11:11",
//				"status": 4,
//				"reason": null,
//				"created_at": "2022-07-06T16:49:37.000000Z",
//				"updated_at": "2022-07-06T16:50:14.000000Z",
//				"deleted_at": null,
//				"selling_user_id": 303
	}
}

