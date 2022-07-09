
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

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MzY0MDkzLCJleHAiOjE2NTc3MjQwOTMsIm5iZiI6MTY1NzM2NDA5MywianRpIjoiYk92cjJGWXVLMUU4UThuNyIsInN1YiI6MzAzLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.nKJv4CFkUX4HrvXjaiCkiI5F8nIoBRQGdBNEsHs2cqk";
    @Test
    public void unitTest1(){
        createItem.Test13(2,"iphone pro max svip",1000000,1,"mua 1 tang 2", null,null , token );
        Assertions.assertEquals("OK", createItem.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
}