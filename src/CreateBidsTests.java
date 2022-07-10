
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class CreateBidsTests {
   CreateBids createBids = new CreateBids();
    RandomEmail randString = new RandomEmail();
    Login login = new Login();
    SignUp signup = new SignUp();

    @Test
    public void unitTest1() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If we send to api valid input,code should be 1000 ");
        System.out.println("Testing unit1...");
        createBids.Test21(9000500,1, login.getToken(),218);//500 Internal Server Error
        Assertions.assertEquals(1000, createBids.getCode());
        System.out.println("Unit 1: Satisfied!");
    }

    @Test
    public void unitTest2() {
     login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("bid lower than the highest price, Server will return code 1001");
        System.out.println("Testing unit2...");
        createBids.Test21(30,0, login.getToken(),231);//tra gia thap hon hien tai
        Assertions.assertEquals(1001, createBids.getCode());
        System.out.println("Unit 2: Satisfied!");
    }

    @Test
    //loi k the gui accesstoken sai , bat buoc gui thi p gui dung
    public void unitTest3() {
        System.out.println("If we not input yet, Server will return code 1004");
        System.out.println("Testing unit3..");
        createBids.Test21(400,0,"aaa",231);
        Assertions.assertEquals(1004, createBids.getCode());
        System.out.println("Unit 3: Satisfied!");
    }
    @Test
    public void unitTest4() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("if the auction has ended, the server returns 1008");//vd,7,8,9
        System.out.println("Testing unit4..");
        createBids.Test21(1000000,0, login.getToken(),7);
        Assertions.assertEquals(1008, createBids.getCode());//ketthuc van tra gia dc vd cai 7
        System.out.println("Unit 4: Satisfied!");
    }
}