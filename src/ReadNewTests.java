import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import random.RandomEmail;

import java.util.Random;

class ReadNewTests {
    ReadNew readNew = new ReadNew();
    Login login = new Login();
    Logout logout= new Logout();
    public void unitTest1() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        readNew.Test25(login.getToken());
        Assertions.assertEquals(1000, readNew.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test
    public void unitTest2() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        logout.Test05(login.getToken());
        System.out.println("If we not input yet, Server will return code 1004");
        System.out.println("Testing unit1...");
        readNew.Test25(null);
        Assertions.assertEquals(1004, readNew.getCode());//loi so voi bao cao, k truyen token van ok
        System.out.println("Unit 2: Satisfied!");
    }
}
