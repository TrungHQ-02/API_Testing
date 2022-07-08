import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import random.RandomEmail;
public class CreateItemTests {
   CreateItem createItem = new CreateItem();
    Random rand = new Random();
    RandomEmail email = new RandomEmail();
    Login login = new Login();
    Logout logout = new Logout();

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MjkwNDcyLCJleHAiOjE2NTc2NTA0NzIsIm5iZiI6MTY1NzI5MDQ3MiwianRpIjoibThXTnM3Y2dXMHkxQVNLaCIsInN1YiI6NDI0LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.RlWtuISoFF6UwExGipMjIYoBVtkmltIPhl0eR2XafBs";
    @Test
    public void unitTest1(){
        System.out.println("If , code should be 9995 and message should be ");
        System.out.println("Testing unit1...");

        String randomName = email.getSaltString();
        String randomBrandid = email.getStringWithFixedLength(10);

        createItem.Test13("594", token, randomName, "100", randomBrandid, "ha ha", null, null);

        Assertions.assertEquals(9995, createItem.getCode());
        Assertions.assertEquals("OK", createItem.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
}