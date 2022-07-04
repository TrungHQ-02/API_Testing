import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchTest {
    Search search = new Search();
    @Test
    @DisplayName("Unit Test 1:")
    public void UnitTest1(){
        search.Test29(1,1,null);
        Assertions.assertEquals(1000, search.getCode());
        Assertions.assertEquals("OK",search.getMessage());

    }

}