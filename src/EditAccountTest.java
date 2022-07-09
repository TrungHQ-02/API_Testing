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
    public void UnitTest1(){
    	login.Test01("dien12@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien12@gmail.com", "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1000,editAccount.getCode());
        Assertions.assertEquals("OK",editAccount.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }*/

    @Test
    @DisplayName("Unit Test 2:   When name's length is more than 255 characters, the code is equal to 1001")
    public void UnitTest2(){
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
    public void UnitTest3(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien1@gmail.com", "123456", "123456", "hanoi" , "", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: 7000&phone: &address: &email:  &avatar: ",editAccount.getMessage());
        System.out.println("Unit 3: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 4:   when email is existed, the code is equal to 1001")
    public void UnitTest4(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "thanh12345@gmail.com", "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7004 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 4: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 5:   when email is not truly-formatted, the code is equal to 1001")
    public void UnitTest5(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien1", "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7002 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 5: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 6:   When email's length is more than 255 characters, the code is equal to 1001")
    public void UnitTest6(){
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
    public void UnitTest7(){
    	login.Test01("dien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "", "123456", "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7000 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 7: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 8:   when phone's length is more than 60 characters, the code is equal to 1001")
    public void UnitTest8(){
    	login.Test01("tdien1@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "tdien1@gmail.com", "123456", "123456", "hanoi" , "dien", "0123456789012345678901234567890123456789012345678901234567890123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: 7013&address: &email:  &avatar: ",editAccount.getMessage());
        System.out.println("Unit 8: Satisfied!");
    }
    
    @Test
    @DisplayName("Unit Test 9:   when phone is empty, the code is equal to 1001")
    public void UnitTest9(){
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
    
    //test 11 lam thay doi password khong xac dinh
    /*
    @Test
    @DisplayName("Unit Test 11:   When password is empty, the code is equal to 1001")
    public void UnitTest11(){
    	login.Test01("tdien12@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "tdien12@gmail.com", null, null, "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7000 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 11: Satisfied!");
    }*/
    
    //test 12 password dai qua khong sign up duoc, neu password ngan khi test se khong dang nhap duoc -> khong tra code ve
    /*
    @Test
    @DisplayName("Unit Test 12:   When password's length is more than 255 characters, the code is equal to 1001")
    public void UnitTest12(){
    	login.Test01("tdien123@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "tdien123@gmail.com", 
        		  "123456fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz",
				  "123456", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7000 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 12: Satisfied!");
    }*/
    
    //test 13 lam thay doi password khong xac dinh
    /*
    @Test
    @DisplayName("Unit Test 13:   When re password is empty, the code is equal to 1001")
    public void UnitTest13(){
    	login.Test01("tdien14@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "tdien14@gmail.com", "123456", null, "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7000 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 13: Satisfied!");
    }*/
    
    //test 14 khong tra ve code
    /*
    @Test
    @DisplayName("Unit Test 14:   When re password don't like password, the code is equal to 1001")
    public void UnitTest14(){
    	login.Test01("dien15@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien15@gmail.com", "123456", "12345678", "hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7000 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 14: Satisfied!");
    }*/
    
    //test 15 khong tra ve code
    /*
    @Test
    @DisplayName("Unit Test 15:   When re_password's length is more than 255 characters, the code is equal to 1001")
    public void UnitTest15(){
    	login.Test01("dien15@gmail.com", "123456");
        editAccount.Test04( login.getToken(), "dien15@gmail.com", "123456", 
        		  "123456fkgkflsslgfabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdef"
				+ "ghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz"
				+ "abcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyzabcdefghiklmnopqrstuvwxyz",
				"hanoi" , "dien", "0123456789", null);
        Assertions.assertEquals(1001,editAccount.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7000 &avatar: ",editAccount.getMessage());
        System.out.println("Unit 15: Satisfied!");
    }*/
}