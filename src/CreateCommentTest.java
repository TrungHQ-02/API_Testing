
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public class CreateCommentTest {
    CreateComment createComment = new CreateComment();
    Login login = new Login();
    Logout logout = new Logout();

/*
    @Test  
    @DisplayName("When account don't sign in")
    public void unitTest1() {
        
        login.Test01("dien1234@gmail.com", "123456");
        logout.Test05(login.getToken());
        createComment.Test14(null, login.getToken(), "xin chao", 1);
        Assertions.assertEquals(1004, createComment.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
    */
    @RepeatedTest(2)
    public void unitTest2() {
        
        login.Test01("minh0915@gmail.com", "123456");
       
        createComment.Test18(12, login.getToken(), "comment for work", 1);
        Assertions.assertEquals(1000, createComment.getCode());
        System.out.println("Unit 2: Satisfied!");
    }

    @Test  
    @DisplayName("Unit test 3: When content is null")
    public void unitTest3() {
        
        login.Test01("dien1234@gmail.com", "123456");
       
        createComment.Test18(12, login.getToken(),"" , 1);
        Assertions.assertEquals(1001, createComment.getCode());
        System.out.println("Unit 3: Satisfied!");
    }
    
    @Test  
    @DisplayName("Unit test 4: When we can't comment")
    public void unitTest4() {
        
        login.Test01("dien1234@gmail.com", "123456");
       
        createComment.Test18(2, login.getToken(),"hi" , 1);
        Assertions.assertEquals(1008, createComment.getCodeData());
        System.out.println("Unit 4: Satisfied!");
    }
    
    @Test  
    public void unitTest5() {
        
        login.Test01("dien1234@gmail.com", "123456");
       
        createComment.Test18(1, login.getToken(), "hello", 10);
        Assertions.assertEquals(1000, createComment.getCode());
        System.out.println("Unit 5: Satisfied!");
    }
}