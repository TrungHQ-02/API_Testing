
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetListCommentsTest {
    GetListComments getListComments = new GetListComments();
    Login login = new Login();

    @Test
    @DisplayName("Unit Test 1: If input is correct, response code should be 1000 and message should be OK")
    public void UnitTest1(){
        login.Test01("minh0915@gmail.com","123456");
        getListComments.Test15(12,1,1,login.getToken());
        Assertions.assertEquals(1000,getListComments.getCode());
        Assertions.assertEquals("OK",getListComments.getMessage());
    }
    @Test
    @DisplayName("If count is 0, comments array should be empty")
    public void UnitTest2(){
        getListComments.Test15(1,1,0,null);
        Assertions.assertEquals(0, getListComments.getCommentsLength());
    }
}