import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.charset.Charset;
class ChangePasswordTest {
    ChangePassword changePassword = new ChangePassword();
    Login login = new Login();
    
    
    
    @Test
    @DisplayName("Unit Test 1:  test OK")
    public void UnitTest01(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "123456", "dien123", "dien123", login.getToken());
        Assertions.assertEquals(1000,changePassword.getCode());
        Assertions.assertEquals("OK",changePassword.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }

    @Test
    @DisplayName("Unit Test 2:  test OK")
    public void UnitTest02(){
    	login.Test01("tdien10@gmail.com", "dien123");
    	changePassword.Test07("tdien10@gmail.com", "dien123", "123456", "123456", login.getToken());
        Assertions.assertEquals(1000,changePassword.getCode());
        Assertions.assertEquals("OK",changePassword.getMessage());
        System.out.println("Unit 2: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 3:  old pass NULL")
    public void UnitTest03(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "", "dien123", "dien123", login.getToken());
        Assertions.assertEquals(1001,changePassword.getCode());
        Assertions.assertEquals("old_pass: 7000&new_pass: &re_pass: ",changePassword.getMessage());
        System.out.println("Unit 3: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 4:  old_pass's length is more than 255 characters")
    public void UnitTest04(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "dien123fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz", 
				  "dien123", "dien123", login.getToken());
        Assertions.assertEquals(1001,changePassword.getCode());
        Assertions.assertEquals("old_pass: 7001&new_pass: &re_pass: ",changePassword.getMessage());
        System.out.println("Unit 4: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 5:  new pass NULL")
    public void UnitTest05(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "123456", "", "dien123", login.getToken());
        Assertions.assertEquals(1001,changePassword.getCode());
        Assertions.assertEquals("old_pass: &new_pass: 7000&re_pass: 7003",changePassword.getMessage());
        System.out.println("Unit 5: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 6:  new_pass's length is more than 255 characters")
    public void UnitTest06(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "123456", 
    			"dien123fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz", 
				"dien123", login.getToken());
        Assertions.assertEquals(1001,changePassword.getCode());
        Assertions.assertEquals("old_pass: &new_pass: 7001&re_pass: 7003",changePassword.getMessage());
        System.out.println("Unit 6: Satisfied!");
    }
   
    @Test
    @DisplayName("Unit Test 7:  re pass NULL")
    public void UnitTest07(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "123456", "dien123", "", login.getToken());
        Assertions.assertEquals(1001,changePassword.getCode());
        Assertions.assertEquals("old_pass: &new_pass: &re_pass: 7000",changePassword.getMessage());
        System.out.println("Unit 7: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 8:  re_pass's length is more than 255 characters")
    public void UnitTest08(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "123456", "dien123",
    			"dien123fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz", 
				 login.getToken());
        Assertions.assertEquals(1001,changePassword.getCode());
        Assertions.assertEquals("old_pass: &new_pass: &re_pass: 7003",changePassword.getMessage());
        System.out.println("Unit 8: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 9:  new pass = re pass : NULL")
    public void UnitTest09(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "123456", "", "", login.getToken());
        Assertions.assertEquals(1001,changePassword.getCode());
        Assertions.assertEquals("old_pass: &new_pass: 7000&re_pass: ",changePassword.getMessage());
        System.out.println("Unit 9: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 10:  re_pass's length is more than 255 characters, new pass=re pass")
    public void UnitTest10(){
    	login.Test01("tdien10@gmail.com", "123456");
    	changePassword.Test07("tdien10@gmail.com", "123456", 
    			"dien123fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz",
    			"dien123fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz", 
				 login.getToken());
        Assertions.assertEquals(1001,changePassword.getCode());
        Assertions.assertEquals("old_pass: &new_pass: 7001&re_pass: 7001",changePassword.getMessage());
        System.out.println("Unit 10: Satisfied!");
    }
}