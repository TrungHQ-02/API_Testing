import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class InfoItemTests {
    InfoItem infoItem = new InfoItem();

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3NTQ4MzIyLCJleHAiOjE2NTc5MDgzMjIsIm5iZiI6MTY1NzU0ODMyMiwianRpIjoiZDZYbGh4WE9UUUppQnl0QSIsInN1YiI6NDI0LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.9GfCpU9MAFNA9p_NjS1fMpa9ktcEmt2W4zmobryUo0s";
    @RepeatedTest(value = 4)
    public void unitTest01(){
        System.out.println("If token not null and item id was created, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");

        infoItem.Test33(1, token);
        Assertions.assertEquals(1000, infoItem.getCode());
        Assertions.assertEquals("OK", infoItem.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
}