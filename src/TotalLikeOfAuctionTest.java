import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalLikeOfAuctionTest {
    TotalLikeOfAuction totalLikeOfAuction = new TotalLikeOfAuction();
    Login login = new Login();
    
    @Test
    @DisplayName("Unit Test 1: Total Like Of Auction ID 100")
    public void UnitTest1(){
    	totalLikeOfAuction.Test29(null,"100");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
        System.out.println("Unit 1: Satisfied!");
    }

    @Test
    @DisplayName("Unit Test 2: Total Like Of Auction ID , ID isn't exist")
    public void UnitTest2(){
    	totalLikeOfAuction.Test29(null,"16");
        Assertions.assertNotEquals(200,totalLikeOfAuction.getRpCode());
        System.out.println("Unit 2: Satisfied!");
    }

    
    @Test
    @DisplayName("Unit Test 1: Total Like Of Auction ID 20")
    public void UnitTest3(){
    	totalLikeOfAuction.Test29(null,"20");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
        System.out.println("Unit 3: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 4: Total Like Of Auction ID 1, have access_token")
    public void UnitTest4(){
    	login.Test03("dien1234@gmail.com", "123456");
    	totalLikeOfAuction.Test29(login.getToken(),"1");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
        System.out.println("Unit 4: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 5: Total Like Of Auction ID 10, have access_token")
    public void UnitTest5(){
    	login.Test03("dien1234@gmail.com", "123456");
    	totalLikeOfAuction.Test29(login.getToken(),"109");
        Assertions.assertEquals(1000,totalLikeOfAuction.getCode());
        Assertions.assertEquals("OK",totalLikeOfAuction.getMessage());
        Assertions.assertNotEquals(null, totalLikeOfAuction.getData());
        System.out.println("Unit 5: Satisfied!");
    }
}