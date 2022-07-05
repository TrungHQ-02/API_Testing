import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalLikeOfAuctionTest {
    TotalLikeOfAuction totalLikeOfAuction = new TotalLikeOfAuction();
    Login login = new Login();
    
    @Test
    @DisplayName("Unit Test 1: Total Like Of Auction ID 100")
    public void UnitTest1(){
    	totalLikeOfAuction.Test23(null,"100");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
    }

    @Test
    @DisplayName("Unit Test 2: Total Like Of Auction ID 200")
    public void UnitTest2(){
    	totalLikeOfAuction.Test23(null,"200");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
    }
    
    /*
    //Loi -> khong ton tai id =0
    //co nhieu id khong ton tai nhu 10, 11, ...
    @Test
    @DisplayName("Unit Test 3: Total Like Of Auction ID 0")
    public void UnitTest3(){
    	totalLikeOfAuction.Test23(null,"0");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
    }*/
    
    @Test
    @DisplayName("Unit Test 4: Total Like Of Auction ID 1, have access_token")
    public void UnitTest4(){
    	login.Test01("dien1234@gmail.com", "123456");
    	totalLikeOfAuction.Test23(login.getToken(),"1");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
    }
    
    @Test
    @DisplayName("Unit Test 5: Total Like Of Auction ID 10, have access_token")
    public void UnitTest5(){
    	login.Test01("dien1234@gmail.com", "123456");
    	totalLikeOfAuction.Test23(login.getToken(),"109");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
    }
}