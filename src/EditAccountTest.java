import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.charset.Charset;
class EditAccountTest {
    EditAccount editAccount = new EditAccount();
    Login login = new Login();
    
    //test 1 chay Ok nhung chay xong email bi doi password khong biet duoc
    /*
    @Test
    @DisplayName("Unit Test 1:  The code and message strings shall be not NULL as well as non-empty:")
    public void UnitTest01(){
    	login.Test01("dien12@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien12@gmail.com", "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1000,editAccount.getCode());
        Assertions.assertEquals("OK",editAccount.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }*/

    @Test
    @DisplayName("Unit Test 2:   When name's length is more than 255 characters, the code is equal to 1001")
    public void UnitTest02(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien1@gmail.com", "123456", "123456", "hanoi" , 
        		          "dien123fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
        				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
        				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
        				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
        				, "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: 7001&phone: &address: &email:  &avatar: ",editAccount.getMessage());
        System.out.println("Unit 2: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 3:   When name is empty, the code is equal to 1001")
    public void UnitTest03(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien1@gmail.com", "123456", "123456", "hanoi" , "", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: 7000&phone: &address: &email:  &avatar: ",editAccount.getMessage());
        System.out.println("Unit 3: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 4:   when email is existed, the code is equal to 1001")
    public void UnitTest04(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "thanh12345@gmail.com", "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7004 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 4: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 5:   when email is not truly-formatted, the code is equal to 1001")
    public void UnitTest05(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien1", "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7002 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 5: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 6:   When email's length is more than 255 characters, the code is equal to 1001")
    public void UnitTest06(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien1kffggggfkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz@gmail.com"
				, "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7001 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 6: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 7:   When email is empty, the code is equal to 1001")
    public void UnitTest07(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "", "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7000 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 7: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 8:   when phone's length is more than 60 characters, the code is equal to 1001")
    public void UnitTest08(){
    	login.Test01("tdien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "tdien1@gmail.com", "123456", "123456", "hanoi" , "dien", "0123456789012345678901234567890123456789012345678901234567890123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: 7013&address: &email:  &avatar: ",editAccount.getMessage());
        System.out.println("Unit 8: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 9:   when phone is empty, the code is equal to 1001")
    public void UnitTest09(){
    	login.Test01("tdien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "tdien1@gmail.com", "123456", "123456", "hanoi" , "dien", "", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: 7000&address: &email:  &avatar: ",editAccount.getMessage());
        System.out.println("Unit 9: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 10:   when address's length is more than 255 characters, the code is equal to 1001")
    public void UnitTest10(){
    	login.Test01("tdien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "tdien1@gmail.com", "123456", "123456", 
        		  "hanoi123fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcd"
				, "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: 7001&email:  &avatar: ",editAccount.getMessage());
        System.out.println("Unit 10: Satisfied!");
    }
}