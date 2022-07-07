import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateCommentTest {
    CreateComment createComment = new CreateComment();
    Login login = new Login();
    @Test
    @DisplayName("Unit Test 1: create comment ")
    public void UnitTest1(){
    	login.Test01("dien1234@gmail.com", "123456");
    	createComment.Test14( 1, login.getToken(), "hi everyone" ,1);
        Assertions.assertEquals(1000,createComment.getCode());
        Assertions.assertEquals("OK",createComment.getMessage());
        //Assertions.assertNotEquals(null, createComment.getData());
    }

}