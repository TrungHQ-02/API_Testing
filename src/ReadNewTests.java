import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import random.RandomEmail;

import java.util.Random;

class ReadNewTests {
    ReadNew readNew = new ReadNew();
    String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MDg3NTgyLCJleHAiOjE2NTc0NDc1ODIsIm5iZiI6MTY1NzA4NzU4MiwianRpIjoiUDJ2dWQ2MVV0d3V4TjAwaiIsInN1YiI6MzAzLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.AfGhz_ltry1zkdLJMvUFqY1MHZufibsyY6FHBk--e3M";

    @Test
    public void unitTest1() {
        System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        readNew.Test25(token);
        Assertions.assertEquals(1000, readNew.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test
    public void unitTest2() {
        System.out.println("If we not input yet, Server will return code 1004");
        System.out.println("Testing unit1...");
        readNew.Test25(null);
        Assertions.assertEquals(1004, readNew.getCode());//loi so voi bao cao, k truyen token van ok
        System.out.println("Unit 1: Satisfied!");
    }
}

