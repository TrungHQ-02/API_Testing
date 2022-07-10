
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InfoTests {
    ReadNew readNew = new ReadNew();
    Login login = new Login();
    Logout logout = new Logout();

    @Test
    public void unitTest1() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        readNew.Test31(login.getToken());
        Assertions.assertEquals(1000, readNew.getCode());
        Assertions.assertEquals("OK", readNew.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
}
