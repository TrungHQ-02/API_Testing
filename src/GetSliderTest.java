import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetSliderTest {
    GetSlider getSlider = new GetSlider();
    Login login = new Login();
    @Test
    @DisplayName("Unit Test 1 : get slider")
    public void UnitTest1(){
       	getSlider.Test34(null);
        Assertions.assertEquals(1000,getSlider.getCode());
        Assertions.assertEquals("OK",getSlider.getMessage());
        //Assertions.assertNotEquals(null, getSlider.getData());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test
    @DisplayName("Unit Test 2: get slider : have access_token")
    public void UnitTest2(){
    	login.Test03("dien1234@gmail.com", "123456");
       	getSlider.Test34(login.getToken());
        Assertions.assertEquals(1000,getSlider.getCode());
        Assertions.assertEquals("OK",getSlider.getMessage());
        //Assertions.assertNotEquals(null, getSlider.getData());
        System.out.println("Unit 2: Satisfied!");
    }
}