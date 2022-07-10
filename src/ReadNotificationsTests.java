

import jdk.jpackage.internal.Log;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class ReadNotificationsTests {
    ReadNotifications readNotifications = new ReadNotifications();
    Login login = new Login();
    @RepeatedTest(value = 2)
    public void unitTest1() {
        System.out.println("If token not null, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        login.Test01("minh0915@gmail.com","123456");

        readNotifications.Test33(1, login.getToken());
        Assertions.assertEquals(1000, readNotifications.getCode());
        Assertions.assertEquals("OK", readNotifications.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
}
