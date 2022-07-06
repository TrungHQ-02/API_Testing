import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import random.RandomEmail;

public class SignUpTests {
    SignUp signUp = new SignUp();
    RandomEmail email = new RandomEmail();

    @Test
    public void unitTest1(){

        System.out.println("If all is not null, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");

        for(int i = 1; i <= 10; i++){
            String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
            String randomPass = email.getStringWithFixedLength(10);
            String randomName = email.getSaltString();
            signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "0854960116", null);
            Assertions.assertEquals(1000, signUp.getCode());
            Assertions.assertEquals("OK", signUp.getMessage());
        }
        System.out.println("Unit 1: Satisfied!");
    }
    @Test
    public void unitTest2(){

        System.out.println("If email > 255, code should be 1001 and message should be name &phone: &address: &email: 7001&password: &re_pass:  &avatar: ");
        System.out.println("Testing unit2...");

        for(int i = 1; i <= 10; i++){
            String randomMail = email.getStringWithFixedLength(260) + "@gmail.com";
            String randomPass = email.getStringWithFixedLength(10);
            String randomName = email.getSaltString();
            signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "0854960116", null);
            Assertions.assertEquals(1001, signUp.getCode());
            Assertions.assertEquals("name: &phone: &address: &email: 7001&password: &re_pass:  &avatar: ", signUp.getMessage());
        }
        System.out.println("Unit 2: Satisfied!");
    }
    @Test
    public void unitTest3() {

        System.out.println("If password > 255, code should be 1001 and message should be name: &phone: &address: &email: &password: 7001&re_pass: 7001 &avatar: ");
        System.out.println("Testing unit3...");

        for (int i = 1; i <= 10; i++) {
            String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
            String randomPass = email.getStringWithFixedLength(260);
            String randomName = email.getSaltString();
            signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "0854960116", null);
            Assertions.assertEquals(1001, signUp.getCode());
            Assertions.assertEquals("name: &phone: &address: &email: &password: 7001&re_pass: 7001 &avatar: ", signUp.getMessage());
        }
        System.out.println("Unit 3: Satisfied!");
    }
    @Test
    public void unitTest4() {

        System.out.println("If phone number is null, code should be 1001 and message should be name: &phone: The phone format is invalid.&address: &email: &password: &re_pass:  &avatar: ");
        System.out.println("Testing unit4...");

        for (int i = 1; i <= 10; i++) {
            String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
            String randomPass = email.getStringWithFixedLength(10);
            String randomName = email.getSaltString();
            signUp.Test02(randomMail, randomPass, randomPass, null, randomName, null, null);
            Assertions.assertEquals(1001, signUp.getCode());
            Assertions.assertEquals("name: &phone: The phone format is invalid.&address: &email: &password: &re_pass:  &avatar: ", signUp.getMessage());
        }
        System.out.println("Unit 4: Satisfied!");
    }
}
