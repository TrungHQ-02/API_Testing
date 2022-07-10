
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchTest {
    Search search = new Search();
    @Test
    @DisplayName("Unit Test 1: Tim kiem theo gia khoi diem")
    public void UnitTest1(){
        search.Test35(1,"1",null);
        Assertions.assertEquals(1000, search.getCode());
        Assertions.assertEquals("OK",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 2: Tim kiem theo thoi gian bat dau")
    public void UnitTest2(){
        search.Test35(2,"7",null);
        Assertions.assertEquals(1000, search.getCode());
        Assertions.assertEquals("OK",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 3: Tim kiem theo thoi gian ket thuc")
    public void UnitTest3(){
        search.Test35(3,"8",null);
        Assertions.assertEquals(1000,search.getCode());
        Assertions.assertEquals("OK",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 3: Tim kiem theo ten")
    public void UnitTest4(){
        search.Test35(4,"a",null);
        Assertions.assertEquals(1000,search.getCode());
        Assertions.assertEquals("OK",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 5: If key is null, response code should be 9998 and message should be Khong tim thay")
    public void UnitTest5(){
        search.Test35(1, null, null);
        Assertions.assertEquals(9998,search.getCode());
        Assertions.assertEquals("Khong tim thay",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 6: If type is not between 1 and 4, response code should not be 1000")
    public void UnitTest6(){
        search.Test35(6,"1",null);
        Assertions.assertNotEquals(1000,search.getCode());
    }
    @Test
    @DisplayName("Unit Test 7: Key khong dung voi kieu tim kiem: theo gia khoi diem")
    public void UnitTest7(){
        search.Test35(1, "a", null);
        Assertions.assertEquals(9998,search.getCode());
        Assertions.assertEquals("Khong tim thay",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 8: Key khong dung voi kieu tim kiem: theo thoi gian bat dau")
    public void UnitTest8(){
        search.Test35(2, "a", null);
        Assertions.assertEquals(9998,search.getCode());
        Assertions.assertEquals("Khong tim thay",search.getMessage());
    }
    @Test
    @DisplayName("Unit Test 9: Key khong dung voi kieu tim kiem: theo thoi gian ket thuc")
    public void UnitTest9(){
        search.Test35(3, "a", null);
        Assertions.assertEquals(9998,search.getCode());
        Assertions.assertEquals("Khong tim thay",search.getMessage());
    }
}