
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class CreateAuctionTests {
    CreateAuction createAuction = new CreateAuction();
    Random rand = new Random();
    RandomEmail randString = new RandomEmail();
    Login login = new Login();
    Logout logout = new Logout();

    // String auctionId, int category_id, String start_date, String end_date, String
    // title_ni,String accessToken


    @Test//    tao thanh cong 1 phien dau gia moi
    public void unitTest1() {// tao tieu de ngau nhien
        int top = 3;
        char data;
        String title = "";
        for (int i=0; i<=top; i++) {
            data = (char)(rand.nextInt(25)+97);
            title = data + title;
        }
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        //auctionId:514
        createAuction.Test11("3", "2022/07/11 07:00", "2022/07/11 08:00", title, login.getToken());
        Assertions.assertEquals(1000, createAuction.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test//chua dang nhap
    //loi k the gui accesstoken sai ,neu gui thi p gui dung, gui dung loi 401
    public void unitTest2() {
        //logout token
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If we not input yet, Server will return code 1004");
        System.out.println("Testing unit2...");
        createAuction.Test11("3", "2024/06/20 11:11", "2024/06/21 11:11", "Aaaa", null);
        Assertions.assertEquals(1004, createAuction.getCode());//Server returned HTTP response code: 401 for URL
        System.out.println("Unit 2: Satisfied!");//yêu cầu ứng dụng khách chưa được hoàn thành vì nó thiếu thông tin xác thực hợp lệ cho tài nguyên được yêu cầu.
    }

    @Test
    public void unitTest3() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("no 'category_id' field entered or the value exists, Server will return code 1001");
        System.out.println("Testing unit3...");
        createAuction.Test11("", "2024/06/20 11:11", "2024/06/21 11:11", "DauGia",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 3: Satisfied!");
        }
    @Test
    public void unitTest4() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("field 'start_date' has not been entered, Server will return code 1001");
        System.out.println("Testing unit4...");
        createAuction.Test11("4", "", "2023/06/18 11:11", "DauGia",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 4: Satisfied!");
        }
    @Test
    public void unitTest5() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("Data format of field 'start_date' incorrect, Server will return code 1001");
        System.out.println("Testing unit5...");
        createAuction.Test11("1", "2023_06_20", "2023/06/21 11:11", "DauGia",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 5: Satisfied!");
    }
    @Test
    public void unitTest6() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("start time must be one day from current time, Server will return code 1001");
        System.out.println("Testing unit6...");
        createAuction.Test11("1", "2021/06/21 11:11", "2023/06/21 11:11", "DauGia",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 6: Satisfied!");
    }
    @Test
    public void unitTest7() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("field 'end_date' has not been entered, Server will return code 1001");
        System.out.println("Testing unit7...");
        createAuction.Test11("1", "2023/06/20 11:11", "", "DauGia",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 7: Satisfied!");
        }
    @Test
    public void unitTest8() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("Data format of field 'end_date' incorrect, Server will return code 1001");
        System.out.println("Testing unit8...");
        createAuction.Test11("1", "2023/06/21 11:11", "2023_06_21", "DauGia",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 8: Satisfied!");
    }
    @Test
    public void unitTest9() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("the end time must be greater than the start time, Server will return code 1001");
        System.out.println("Testing unit9...");
        createAuction.Test11("1", "2023/06/25 11:11", "2023/06/21 11:11", "DauGia",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 9: Satisfied!");
    }
    @Test
    public void unitTest10() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("field 'title_ni' has not been entered, Server will return code 1001");
        System.out.println("Testing unit10...");
        createAuction.Test11("1", "2023/06/20 11:11", "2023/06/21 11:11", "",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 10: Satisfied!");
    }
    @Test
    public void unitTest11() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("Auction title is unique, Server will return code 1001");
        System.out.println("Testing unit11...");
        createAuction.Test11("1", "2023/06/20 11:11", "2023/06/21 11:11", "DauGia",login.getToken());
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 11: Satisfied!");
    }

}