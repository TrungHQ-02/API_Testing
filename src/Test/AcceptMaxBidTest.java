

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AcceptMaxBidTest {
    AcceptMaxBid acceptMaxBid = new AcceptMaxBid();
    Login login = new Login();
    @Test
    @DisplayName("With correct token, if auction not over yet, response code should be 1009 and message should be Phiên đấu giá chưa kết thúc")
    public void UnitTest1(){
        login.Test01("minh0915@gmail.com","123456");
        acceptMaxBid.Test25(541, "sold for minh", login.getToken());
        Assertions.assertEquals(1009, acceptMaxBid.getCode());
        Assertions.assertEquals("Phiên đấu giá chưa kết thúc",acceptMaxBid.getMessage());
    }
    @Test
    @DisplayName("If token is not the one that create auctions, response code should be 1006")
    public void UnitTest2(){
        login.Test01("minh0915@gmail.com","123456");
        acceptMaxBid.Test25(1,"sold for minh",login.getToken());
        Assertions.assertEquals(1006, acceptMaxBid.getCode());
        Assertions.assertEquals("Không có quyền", acceptMaxBid.getMessage());
    }
    @Test
    @DisplayName("If access token is null, response code should be 1004 and message should be Chua dang nhap")
    public void UnitTest3(){
        acceptMaxBid.Test25(1,"sold", null);
        Assertions.assertEquals(1004, acceptMaxBid.getCode());
        Assertions.assertEquals("Chưa đăng nhập",acceptMaxBid.getMessage());
    }

}