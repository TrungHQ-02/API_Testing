import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import random.RandomEmail;

public class DeleteCommentTest {
    DeleteComment deleteComment = new DeleteComment();
    Random rand = new Random();
    RandomEmail randString = new RandomEmail();
    String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOl"
            +"wvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MTg0N"
            +"DYzLCJleHAiOjE2NTc1NDQ0NjMsIm5iZiI6MTY1NzE4NDQ2MywianRpIjoiMlFnelNMR01VRkRjZkk3VyIsI"
            +"nN1YiI6MzAzLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.sW7j"
            +"sq54-8dcdOlScuWbDI3Hl08Z0FCIqfuyxOPvAOo";

    @Test//   xoa mot comment thanh cong
    public void unitTest1() {
        System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        deleteComment.Test31(accessToken);
        Assertions.assertEquals(1000,deleteComment.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
}