
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;
public class DeleteAuctionTests {
    DeleteAuction deleteAuction = new DeleteAuction();
    Random rand = new Random();
    Login login= new Login();
    Logout logout = new Logout();
    CreateAuction creauc = new CreateAuction();
    @Test//   xoa mot auction ch dc duyet thanh cong
    @DisplayName("Unit test 1: If we send to api valid input, code should be 1000 and message should be OK")
    public void unitTest1() {
        login.Test01("devAdmin@gmail.com", "123456");
        System.out.println("Testing unit1...");
        int top = 5;
        char data;
        String title = "";
        for (int i=0; i<=top; i++) {
            data = (char)(rand.nextInt(25)+97);
            title = data + title;
        }
        creauc.Test11("1", "2022/07/12 11:11", "2023/08/21 11:11", title, login.getToken());
        deleteAuction.Test13(login.getToken(),creauc.getData().auction_id);
        Assertions.assertEquals(1000,deleteAuction.getCode());
        Assertions.assertEquals("OK",deleteAuction.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test//  khong the xoa phien dau gia da duoc duyet
    @DisplayName("Unit test 2: if you delete the approved auction, the server returns 9994")
    public void unitTest2() {
        login.Test01("trinhquan100402@gmail.com", "1004");
        System.out.println("Testing unit2...");
        deleteAuction.Test13(login.getToken(),"513");
        Assertions.assertEquals(9994,deleteAuction.getCode());
        Assertions.assertEquals("Không thể xóa",deleteAuction.getMessage());
        System.out.println("Unit 2: Satisfied!");
    }
    @Test//  khong the xoa nhung phien dau gia do nguoi khac tao
    @DisplayName("Unit test 3: if you delete an auction created by someone else, the server returns 1006")
    public void unitTest3() {
        login.Test01("devAdmin@gmail.com", "123456");
        System.out.println("Testing unit3...");
        deleteAuction.Test13(login.getToken(),"529");//quan tao
        Assertions.assertEquals(1006,deleteAuction.getCode());
        Assertions.assertEquals("Không có quyền",deleteAuction.getMessage());//ở file là không có quyền xóa
        System.out.println("Unit 3: Satisfied!");
    }
/*
    @Test//  loi ch dang nhap
    @DisplayName("Unit test 4: If we not input yet, Server will return code 1004")
    public void unitTest4() {
        login.Test01("devAdmin@gmail.com", "123456");
        logout.Test05(login.getToken());
        System.out.println("Testing unit3...");//loi 401
        //yêu cầu ứng dụng khách chưa được hoàn thành vì nó thiếu thông tin xác thực hợp lệ cho tài nguyên được yêu cầu.
        deleteAuction.Test13(null, "1107");
        Assertions.assertEquals(1004,deleteAuction.getCode());
        Assertions.assertEquals("Chưa đăng nhập",deleteAuction.getMessage());
        System.out.println("Unit 4: Satisfied!");
    }
*/
}
