import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetListCommentsTest {
    GetListComments getListComments = new GetListComments();

    @Test
    @DisplayName("test")
    public void UnitTest1(){
        getListComments.Test14(1,1,1,null);
        Assertions.assertEquals(1000,getListComments.getCode());
        Assertions.assertEquals("OK",getListComments.getMessage());
    }

}