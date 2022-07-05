import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetListBrandsTest {
	GetListBrands getListBrands = new GetListBrands();

    @Test
    @DisplayName("Unit Test : get list brands")
    public void UnitTest(){
    	getListBrands.Test18();
        Assertions.assertEquals(1000,getListBrands.getCode());
        Assertions.assertEquals("OK",getListBrands.getMessage());
        Assertions.assertNotEquals(null, getListBrands.getData());
    }

}