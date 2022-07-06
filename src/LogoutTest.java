import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;


class LogoutTest {
    Login login = new Login();
    Logout logout = new Logout();

    @Test
    @DisplayName("Unit Test 1: If access token is right, response code should be 1000 and message should be OK")
    @RepeatedTest(value = 5)
    public void UnitTest1() {
        login.Test01("minh0915@gmail.com", "123456");
        logout.Test05(login.getToken());
        Assertions.assertEquals(1000, logout.getCode(), "Wrong code");
        Assertions.assertEquals("OK", logout.getMessage(), "Wrong message");
    }
}
