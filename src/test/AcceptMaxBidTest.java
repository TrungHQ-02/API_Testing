package test;
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
        acceptMaxBid.Test20(541, "sold for minh", login.getToken());
        Assertions.assertEquals(1009, acceptMaxBid.getCode());
        Assertions.assertEquals("Phiên đấu giá chưa kết thúc",acceptMaxBid.getMessage());
    }
    @Test
    @DisplayName("With wrong token, response")
    public void UnitTest2(){
        login.Test01("minh0915@gmail.com","123456");
        acceptMaxBid.Test20(541,"sold for minh",login.getToken());
        Assertions.assertEquals(1006,acceptMaxBid.getCode());
    }

}