import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;
public class CreateItemTests {
   CreateItem createItem = new CreateItem();
    Random rand = new Random();
    RandomEmail email = new RandomEmail();
    Login login = new Login();
    Logout logout = new Logout();

    String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MDg3NTgyLCJleHAiOjE2NTc0NDc1ODIsIm5iZiI6MTY1NzA4NzU4MiwianRpIjoiUDJ2dWQ2MVV0d3V4TjAwaiIsInN1YiI6MzAzLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.AfGhz_ltry1zkdLJMvUFqY1MHZufibsyY6FHBk--e3M";
    @Test
    public void unitTest1(){
        System.out.println("If ??????, code should be 9995 and message should be Không thể thêm item mới với phiên đấu giá này");
        System.out.println("Testing unit1...");

        String randomName = email.getSaltString();
        String randomBrandid = email.getStringWithFixedLength(10);

        createItem.Test13("1", token, randomName, "10", randomBrandid, "jkfsdhjfb", null, null);

        Assertions.assertEquals(9995, createItem.getCode());
        Assertions.assertEquals("Không thể thêm item mới với phiên đấu giá này", createItem.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
}