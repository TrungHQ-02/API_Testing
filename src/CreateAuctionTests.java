import java.nio.charset.Charset;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import random.RandomEmail;

public class CreateAuctionTests {
    CreateAuction createAuction = new CreateAuction();
    Random rand = new Random();
    RandomEmail randString = new RandomEmail();

//    @Test
//    public void givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
//        byte[] array = new byte[7]; // length is bounded by 7
//        new Random().nextBytes(array);
//        String generatedString = new String(array, Charset.forName("UTF-8"));
//
//        System.out.println(generatedString);
//    }
    String proper_token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MDk4NDQ5LCJleHAiOjE2NTc0NTg0NDksIm5iZiI6MTY1NzA5ODQ0OSwianRpIjoibWE1enNFMFRtMzVjclI3UyIsInN1YiI6MzAzLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.AeVg3ipTIDrIeZsvB0eWYeOWi_UzRV9sEcnCj8J2cgw";

    // String auctionId, int category_id, String start_date, String end_date, String
    // title_ni,String accessToken



    @Test//    tao thanh cong 1 phien dau gia moi
    public void unitTest1() {
        System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        createAuction.Test11("3", "2024/06/20 11:11", "2024/06/21 11:11", "ABCCcc",proper_token);
        Assertions.assertEquals(1000, createAuction.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test//chua dang nhap
    //loi k the gui accesstoken sai ,neu gui thi p gui dung
    public void unitTest2() {
        //logout token
        System.out.println("If we not input yet, Server will return code 1004");
        System.out.println("Testing unit2...");
        createAuction.Test11("3", "2024/06/20 11:11", "2024/06/21 11:11", "ABCCccAA","aaaa");
        Assertions.assertEquals(1004, createAuction.getCode());
        System.out.println("Unit 2: Satisfied!");
    }

    @Test
    public void unitTest3() {
        System.out.println("no 'category_id' field entered or the value exists, Server will return code 1001");
        System.out.println("Testing unit3...");
        createAuction.Test11("", "2024/06/20 11:11", "2024/06/21 11:11", "DauGia",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 3: Satisfied!");
        }

    @Test
    public void unitTest4() {
        System.out.println("field 'start_date' has not been entered, Server will return code 1001");
        System.out.println("Testing unit4...");
        createAuction.Test11("4", "", "2023/06/18 11:11", "DauGia",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 4: Satisfied!");
        }
    @Test
    public void unitTest5() {
        System.out.println("Data format of field 'start_date' incorrect, Server will return code 1001");
        System.out.println("Testing unit5...");
        createAuction.Test11("1", "2023_06_20", "2023/06/21 11:11", "DauGia",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 5: Satisfied!");
    }
    @Test
    public void unitTest6() {
        System.out.println("start time must be one day from current time, Server will return code 1001");
        System.out.println("Testing unit6...");
        createAuction.Test11("1", "2021/06/21 11:11", "2023/06/21 11:11", "DauGia",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 6: Satisfied!");
    }

    @Test
    public void unitTest7() {
        System.out.println("field 'end_date' has not been entered, Server will return code 1001");
        System.out.println("Testing unit7...");
        createAuction.Test11("1", "2023/06/20 11:11", "", "DauGia",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 7: Satisfied!");
        }
    @Test
    public void unitTest8() {
        System.out.println("Data format of field 'end_date' incorrect, Server will return code 1001");
        System.out.println("Testing unit8...");
        createAuction.Test11("1", "2023/06/21 11:11", "2023_06_21", "DauGia",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 8: Satisfied!");
    }
    @Test
    public void unitTest9() {
        System.out.println("the end time must be greater than the start time, Server will return code 1001");
        System.out.println("Testing unit9...");
        createAuction.Test11("1", "2023/06/25 11:11", "2023/06/21 11:11", "DauGia",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 9: Satisfied!");
    }
    @Test
    public void unitTest10() {
        System.out.println("Dfield 'title_ni' has not been entered, Server will return code 1001");
        System.out.println("Testing unit10...");
        createAuction.Test11("1", "2023/06/20 11:11", "2023/06/21 11:11", "",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 10: Satisfied!");
    }
    @Test
    public void unitTest11() {
        System.out.println("Auction title is unique, Server will return code 1001");
        System.out.println("Testing unit11...");
        createAuction.Test11("1", "2023/06/20 11:11", "2023/06/21 11:11", "DauGia",proper_token);
        Assertions.assertEquals(1001, createAuction.getCode());
        System.out.println("Unit 11: Satisfied!");
    }

}