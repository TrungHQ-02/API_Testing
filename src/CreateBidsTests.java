
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class CreateBidsTests {
   CreateBids createBids = new CreateBids();
    RandomEmail randString = new RandomEmail();
    Random  rand = new Random();
    Login login = new Login();
    SignUp signup = new SignUp();


    @Test
    public void unitTest1() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If we send to api valid input,code should be 1000 ");
        System.out.println("Testing unit1...");
        createBids.Test16(323300,0, login.getToken());//gia cao nhat hien tai 218 la 323260
        Assertions.assertEquals(1000, createBids.getCode());
        System.out.println("Unit 1: Satisfied!");
    }

    @Test
    public void unitTest2() {
     login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("bid lower than the highest price, Server will return code 1001");
        System.out.println("Testing unit2...");
        createBids.Test16(323230,1, login.getToken());
        Assertions.assertEquals(1001, createBids.getCode());
        System.out.println("Unit 2: Satisfied!");
    }

    @Test
    //loi k the gui accesstoken sai , bat buoc gui thi p gui dung
    public void unitTest3() {
        System.out.println("If we not input yet, Server will return code 1004");
        System.out.println("Testing unit3..");
        createBids.Test16(323280,1,null);
        Assertions.assertEquals(1004, createBids.getCode());
        System.out.println("Unit 3: Satisfied!");
    }
}