
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class DeleteCommentTest {
    DeleteComment deleteComment = new DeleteComment();
    Random rand = new Random();
    RandomEmail randString = new RandomEmail();
    Login login= new Login();
    @Test//   xoa mot comment thanh cong
    public void unitTest1() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        deleteComment.Test31(login.getToken());
        Assertions.assertEquals(1000,deleteComment.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test//  khong co quyen xoa neu la cmt cua nguoi khac
    public void unitTest2() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If someone else's comment is, Server will return code 1006");
        System.out.println("Testing unit2...");
        deleteComment.Test31(login.getToken());
        Assertions.assertEquals(1006,deleteComment.getCode());
        System.out.println("Unit 2: Satisfied!");
    }
}