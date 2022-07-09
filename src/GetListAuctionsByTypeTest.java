import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetListAuctionsByTypeTest {
	GetListAuctionsByType getListAuctionsByType = new GetListAuctionsByType();
	Login login = new Login(); 

    @Test
    @DisplayName("Unit Test 1: get list auction by type : index=1, count=1")
    public void UnitTest1(){
    	getListAuctionsByType.Test09(null,"1","1");
        Assertions.assertEquals(1000,getListAuctionsByType.getCode());
        Assertions.assertEquals("OK",getListAuctionsByType.getMessage());
        Assertions.assertNotEquals(null, getListAuctionsByType.getData());
        System.out.println("Unit 1: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 2: get list auction by type : index=2, count=3")
    public void UnitTest2(){
    	getListAuctionsByType.Test09(null,"2","3");
        Assertions.assertEquals(1000,getListAuctionsByType.getCode());
        Assertions.assertEquals("OK",getListAuctionsByType.getMessage());
        Assertions.assertNotEquals(null, getListAuctionsByType.getData());
        System.out.println("Unit 2: Satisfied!");
    }

    @Test
    @DisplayName("Unit Test 3: get list auction by type : index=0, count=0")
    public void UnitTest3(){
    	getListAuctionsByType.Test09(null,"0","0");
        Assertions.assertEquals(1000,getListAuctionsByType.getCode());
        Assertions.assertEquals("OK",getListAuctionsByType.getMessage());
        Assertions.assertNotEquals(null, getListAuctionsByType.getData());
        System.out.println("Unit 3: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 4: get list auction by type : index=1000, count=1000")
    public void UnitTest4(){
    	getListAuctionsByType.Test09(null,"1000","1000");
        Assertions.assertEquals(1000,getListAuctionsByType.getCode());
        Assertions.assertEquals("OK",getListAuctionsByType.getMessage());
        Assertions.assertNotEquals(null, getListAuctionsByType.getData());
        System.out.println("Unit 4: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 5: get list auction by type : have access_token")
    public void UnitTest5(){
    	login.Test01("dien1234@gmail.com", "123456");
    	getListAuctionsByType.Test09(login.getToken() ,"10","5");
        Assertions.assertEquals(1000,getListAuctionsByType.getCode());
        Assertions.assertEquals("OK",getListAuctionsByType.getMessage());
        Assertions.assertNotEquals(null, getListAuctionsByType.getData());
        System.out.println("Unit 5: Satisfied!");
    
    }
       
}