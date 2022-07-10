
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class SignUpTests {
    SignUp signUp = new SignUp();
    RandomEmail email = new RandomEmail();


    @RepeatedTest(value = 2)
    public void unitTest1(){

        System.out.println("If all is not null, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");

        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "0854960116", null);
        Assertions.assertEquals(1000, signUp.getCode());
        Assertions.assertEquals("OK", signUp.getMessage());

        System.out.println("Unit 1: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest2(){

        System.out.println("If email > 255, code should be 1001 and message should be name &phone: &address: &email: 7001&password: &re_pass:  &avatar: ");
        System.out.println("Testing unit2...");

        String randomMail = email.getStringWithFixedLength(260) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "0854960116", null);
        Assertions.assertEquals(1000, signUp.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7001&password: &re_pass:  &avatar: ", signUp.getMessage());

        System.out.println("Unit 2: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest3() {

        System.out.println("If password > 255, code should be 1001 and message should be name: &phone: &address: &email: &password: 7001&re_pass: 7001 &avatar: ");
        System.out.println("Testing unit3...");

        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(260);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "0854960116", null);
        Assertions.assertEquals(1000, signUp.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: &password: 7001&re_pass: 7001 &avatar: ", signUp.getMessage());

        System.out.println("Unit 3: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest4() {

        System.out.println("If phone number is null, code should be 1001 and message should be name: &phone: The phone format is invalid.&address: &email: &password: &re_pass:  &avatar: ");
        System.out.println("Testing unit4...");

        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, randomPass, randomPass, null, randomName, null, null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: &phone: The phone format is invalid.&address: &email: &password: &re_pass:  &avatar: ", signUp.getMessage());

        System.out.println("Unit 4: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest5() {

        System.out.println("If email is wrong format, code should be 1001 and message should be name: &phone: &address: &email: 7002&password: &re_pass:  &avatar: ");
        System.out.println("Testing unit5...");

        String randomMail = email.getStringWithFixedLength(10);
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "0854960116", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7002&password: &re_pass:  &avatar: ", signUp.getMessage());

        System.out.println("Unit 5: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest6() {

        System.out.println("If pass != re_pass, code should be 1001 and message should be name: &phone: &address: &email: 7002&password: &re_pass: 7003 &avatar: ");
        System.out.println("Testing unit6...");

        String randomMail = email.getStringWithFixedLength(10);
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, randomPass, "123456", null, randomName, "0854960116", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7002&password: &re_pass: 7003 &avatar: ", signUp.getMessage());

        System.out.println("Unit 6: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest7() {

        System.out.println("If do not enter name, code should be 1001 and message should ");
        System.out.println("Testing unit7...");

        String randomMail = email.getStringWithFixedLength(10);
        String randomPass = email.getStringWithFixedLength(10);
        signUp.Test02(randomMail, randomPass, randomPass, null, "", "0854960116", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: 7000&phone: &address: &email: 7002&password: &re_pass:  &avatar: ", signUp.getMessage());

        System.out.println("Unit 7: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest8(){

        System.out.println("If name > 255, code should be 1001 and message should be name: 7001&phone: &address: &email: &password: &re_pass:  &avatar: ");
        System.out.println("Testing unit8...");

        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getStringWithFixedLength(260);
        signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "0854960116", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: 7001&phone: &address: &email: &password: &re_pass:  &avatar: ", signUp.getMessage());

        System.out.println("Unit 8: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest9(){

        System.out.println("If do not enter phone number, code should be 1001 and message should be name: &phone: 7000&address: &email: &password: &re_pass:  &avatar: ");
        System.out.println("Testing unit9...");

        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, randomPass, randomPass, null, randomName, "", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: &phone: 7000&address: &email: &password: &re_pass:  &avatar: ", signUp.getMessage());

        System.out.println("Unit 9: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest10(){

        System.out.println("If address > 255, code should be 1001 and message should be name: &phone: &address: 7001&email: &password: &re_pass:  &avatar: ");
        System.out.println("Testing unit10...");

        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        String randomAddress = email.getStringWithFixedLength(260);
        signUp.Test02(randomMail, randomPass, randomPass, randomAddress, randomName, "0854960116", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: &phone: &address: 7001&email: &password: &re_pass:  &avatar: ", signUp.getMessage());

        System.out.println("Unit 10: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest11(){

        System.out.println("If do not enter re_password, code should be 1001 and message should be name: &phone: &address: &email: &password: &re_pass: 7000 &avatar: ");
        System.out.println("Testing unit11...");

        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, randomPass, "", null, randomName, "0854960116", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: &password: &re_pass: 7000 &avatar: ", signUp.getMessage());

        System.out.println("Unit 11: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest12(){

        System.out.println("If do not enter password, code should be 1001 and message should be name: &phone: &address: &email: &password: 7000&re_pass: 7003 &avatar: ");
        System.out.println("Testing unit12...");

        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02(randomMail, "", randomPass, null, randomName, "0854960116", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: &password: 7000&re_pass: 7003 &avatar: ", signUp.getMessage());

        System.out.println("Unit 12: Satisfied!");
    }

    @RepeatedTest(value = 2)
    public void unitTest13(){

        System.out.println("If do not enter email, code should be 1001 and message should be name: &phone: &address: &email: 7000&password: &re_pass:  &avatar: ");
        System.out.println("Testing unit13...");

        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        signUp.Test02("", randomPass, randomPass, null, randomName, "0854960116", null);
        Assertions.assertEquals(1001, signUp.getCode());
        Assertions.assertEquals("name: &phone: &address: &email: 7000&password: &re_pass:  &avatar: ", signUp.getMessage());

        System.out.println("Unit 13: Satisfied!");
    }
}
