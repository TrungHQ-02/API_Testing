import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import random.RandomEmail;

import java.util.Random;

public class CreateBidsTests {
   CreateBids createBids = new CreateBids();
    RandomEmail randString = new RandomEmail();
    String proper_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MDk5ODI1LCJleHAiOjE2NTc0NTk4MjUsIm5iZiI6MTY1NzA5OTgyNSwianRpIjoiU3liR1lvRGp1dHlUVHlsSSIsInN1YiI6MzAzLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.DOqeRZ5KbeGNFrzCKRGsUCdBNUD9kRhKJwBy_465TzI";

    @Test
    public void unitTest1() {
        System.out.println("If we send to api valid input, code should be 1000 ");
        System.out.println("Testing unit1...");
        createBids.Test16("3232500","1", proper_token);
        Assertions.assertEquals(1000, createBids.getCode());
        System.out.println("Unit 1: Satisfied!");
    }

    @Test
    public void unitTest2() {
        System.out.println("bid lower than the highest price, Server will return code 1001");
        System.out.println("Testing unit2...");
        createBids.Test16("323230","10", proper_token);
        Assertions.assertEquals(1001, createBids.getCode());
        System.out.println("Unit 2: Satisfied!");
    }

    @Test
    //loi k the gui accesstoken sai , bat buoc gui thi p gui dung
    public void unitTest3() {
        System.out.println("If we not input yet, Server will return code 1004");
        System.out.println("Testing unit3..");
        createBids.Test16("323230","10", null);
        Assertions.assertEquals(1004, createBids.getCode());
        System.out.println("Unit 3: Satisfied!");
    }
}