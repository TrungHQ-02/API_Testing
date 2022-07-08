import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchTest {
    Search search = new Search();
    @Test
    @DisplayName("Unit Test 1: With correct type and key, response code should be 1000 and message should be OK")
    public void UnitTest1(){
        search.Test30(1,"1",null);
        Assertions.assertEquals(1000, search.getCode());
        Assertions.assertEquals("OK",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 2: If key is wrong, response code should be 9998 and message should be Khong tim thay")
    public void UnitTest2(){
        search.Test30(1,"a",null);
        Assertions.assertEquals(9998,search.getCode());
        Assertions.assertEquals("Khong tim thay",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 3: If key is null, response code should be 9998 and message should be Khong tim thay")
    public void UnitTest3(){
        search.Test30(1, null, null);
        Assertions.assertEquals(9998,search.getCode());
        Assertions.assertEquals("Khong tim thay",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 4: If type is not between 1 and 4, response code should not be 1000")
    public void UnitTest4(){
        search.Test30(6,"1",null);
        Assertions.assertNotEquals(1000,search.getCode());
    }


}