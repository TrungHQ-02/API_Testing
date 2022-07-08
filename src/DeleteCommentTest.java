import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import random.RandomEmail;

public class DeleteCommentTest {
    DeleteComment deleteComment = new DeleteComment();
    Random rand = new Random();
    RandomEmail randString = new RandomEmail();
    Login login= new Login();
    CreateComment createcmt = new CreateComment();
    GetListComments cmt = new GetListComments();
    @Test//   xoa mot comment thanh cong
    public void unitTest1() {
        login.Test01("trinhquan100402@gmail.com", "1004");
       // createcmt.Test14("12", login.getToken(), "xin chaaao", 1);
        cmt.Test15(12,0, 1,null);
        System.out.println("If we send to api valid input, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");
        //deleteComment.Test31(cmt.getData().comment_id,login.getToken());//lay cmt cua mk
        deleteComment.Test31("465",login.getToken());//lay cmt cua mk
        Assertions.assertEquals(1000,deleteComment.getCode());
        //Assertions.assertEquals("Đã xóa comment", deleteComment.getData());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test//  khong co quyen xoa neu la cmt cua nguoi khac
    public void unitTest2() {
        int randomId = rand.nextInt(0,500);
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("If someone else's comment is, Server will return code 1006");
        System.out.println("Testing unit2...");
        deleteComment.Test31(String.valueOf(randomId),login.getToken());//lay idcmt bat ky khac cua mk
        Assertions.assertEquals(1006,deleteComment.getCode());
        System.out.println("Unit 2: Satisfied!");
    }
}