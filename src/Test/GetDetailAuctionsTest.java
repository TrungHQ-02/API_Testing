

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetDetailAuctionsTest {
    Login login = new Login();
    GetDetailAuctions getDetailAuctions = new GetDetailAuctions();

    @Test
    @DisplayName("Unit Test 1: If Auction_ID is right, response code should be 1000 and message should be OK")
    public void UnitTest1(){
        getDetailAuctions.Test10(1, null);
        Assertions.assertEquals(1000,getDetailAuctions.getCode());
        Assertions.assertEquals("OK",getDetailAuctions.getMessage());
    }
    @Test
    @DisplayName("Unit Test 2: If Auction_ID is wrong, HTTP response code should not be 200")
    public void UnitTest2(){
        getDetailAuctions.Test10(0, null);
        Assertions.assertNotEquals(200, getDetailAuctions.getHttpResponseCode());
    }
    @Test
    @DisplayName("Unit Test 3: If token is not null, response code should be 1000")
    public void UnitTest3(){
        login.Test01("minh0915@gmail.com","123456");
        getDetailAuctions.Test10(1, login.getToken());
        Assertions.assertEquals(1000,getDetailAuctions.getCode());
        Assertions.assertEquals("OK",getDetailAuctions.getMessage());
    }
}