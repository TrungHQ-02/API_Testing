import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetListCommentsTest {
    GetListComments getListComments = new GetListComments();
    CreateComment cmt = new CreateComment();
    @Test
    @DisplayName("Unit Test 1: With correct input")
    public void UnitTest1(){
        getListComments.Test15(12,1,10,null);
        Assertions.assertEquals(1000,getListComments.getCode());
        Assertions.assertEquals("OK",getListComments.getMessage());
        Assertions.assertNotEquals(null, getListComments.getData());
    }
}