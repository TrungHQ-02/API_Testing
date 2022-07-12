

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class DeleteCommentTest {
    DeleteComment deleteComment = new DeleteComment();
    Random rand = new Random();
    RandomEmail randString = new RandomEmail();
    Login login= new Login();
    CreateComment crecmt = new CreateComment();
    GetListComments getListComments = new GetListComments();
    @Test//   xoa mot comment thanh cong
   // @DisplayName("Unit test 1: If we send to api valid input, code should be 1000 and message should be OK")
    public void unitTest1() {

        login.Test01("trinhquan100402@gmail.com", "1004");
         System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        crecmt.Test18(12, login.getToken(),"work",1);
        getListComments.Test20(12,0,1, login.getToken());
        deleteComment.Test19(login.getToken(),getListComments.getCommentId(getListComments.getComments()));
        Assertions.assertEquals(1000,deleteComment.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test//  khong co quyen xoa neu la cmt cua nguoi khac
    public void unitTest2() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If someone else's comment is, Server will return code 1006");
        System.out.println("Testing unit2...");
        deleteComment.Test19(login.getToken(),1);//1 la cua ngkhac
        Assertions.assertEquals(1006,deleteComment.getCode());
        System.out.println("Unit 2: Satisfied!");
    }
}