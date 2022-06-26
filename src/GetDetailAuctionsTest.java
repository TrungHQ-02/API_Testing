import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetDetailAuctionsTest {

    @Test
    @DisplayName("When Auction_ID is right, response code should be 1000 and message should be OK")
    public void AuctionIdIs1(){
        GetDetailAuctions getDetailAuctions = new GetDetailAuctions();
        getDetailAuctions.Test09(1, null);
        Assertions.assertEquals(1000, getDetailAuctions.getCode());
        Assertions.assertEquals("OK",getDetailAuctions.getMessage());
    }
    @Test
    @DisplayName("When Auction_ID is 0, HTTP response code should be 500 ")
    public void AuctionIdIs0(){
        GetDetailAuctions getDetailAuctions = new GetDetailAuctions();
        getDetailAuctions.Test09(0, null);
        Assertions.assertEquals(500, getDetailAuctions.getHttpResponseCode());
    }


}