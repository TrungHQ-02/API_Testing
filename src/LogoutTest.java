import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LogoutTest {
    Login login = new Login();
    Logout logout = new Logout();

    @Test
    @DisplayName("Unit Test 1: If access token is right, response code should be 1000 and message should be OK")
    public void UnitTest1(){
        login.Test01("minh0915@gmail.com", "123456");
        logout.Test04(login.getToken());
        Assertions.assertEquals(1000, logout.getCode(), "Wrong code");
        Assertions.assertEquals("OK", logout.getMessage(), "Wrong message");
    }

}