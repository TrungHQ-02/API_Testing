

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class ContactUsTests{
    ContactUs contactUs = new ContactUs();
    Random rand = new Random();
    RandomEmail randString = new RandomEmail();
    Login login = new Login();

    @Test//lien he thanh cong

    public void unitTest1() {
        String email = String.valueOf(new RandomEmail());
        System.out.println("If we send to api valid input, code should be 1000 ");
        System.out.println("Testing unit1...");
        contactUs.Test26("TT111","0383859368",email,"aaa",null,"1", null);
        Assertions.assertEquals(1000, contactUs.getCode());
        System.out.println("Unit 1: Satisfied!");
    }
    @Test
    public void unitTest2() {
        String email = String.valueOf(new RandomEmail());
        System.out.println("if not enter name, server return about 1001");
        System.out.println("Testing unit2...");
        contactUs.Test26("","0383859368",email,"aaa",null,"2", null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 2: Satisfied!");
    }
    @Test
    public void unitTest3() {
        String email = String.valueOf(new RandomEmail());
        System.out.println("if not enter phone, server return about 1001");
        System.out.println("Testing unit3...");
        contactUs.Test26("TT","",email,"aaa",null,"2", null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 3: Satisfied!");
    }
    @Test
    public void unitTest4() {
        // String email = String.valueOf(new RandomEmail());
        System.out.println("if not enter email, server return about 1001");
        System.out.println("Testing unit4...");
        contactUs.Test26("TT","","", "aaa",null,"2", null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 4: Satisfied!");
    }
    @Test
    public void unitTest5() {
        String email = String.valueOf(new RandomEmail());
        System.out.println("if not enter content, server return about 1001");
        System.out.println("Testing unit5...");
        contactUs.Test26("TT","0383859368",email,"",null,"2", null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 5: Satisfied!");
    }
    @Test
    public void unitTest6() {
        String email = String.valueOf(new RandomEmail());
        System.out.println("if not enter report_type, server return about 1001");
        System.out.println("Testing unit6...");
        contactUs.Test26("TT","0383859368",email,"aaa",null,"",null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 6: Satisfied!");
    }
    @Test
    public void unitTest7() {
        String email = String.valueOf(new RandomEmail());
        int top = 260;
        char data;
        String name = "";
        for (int i=0; i<=top; i++) {
            data = (char)(rand.nextInt(25)+97);
            name = data + name;
        }
        System.out.println("If enter a name longer than 255,server return about 1001");
        System.out.println("Testing unit7...");
        contactUs.Test26(name,"0383859368",email,"aaa",null,"2", null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 7: Satisfied!");
    }
    @Test
    public void unitTest8() {
        int top = 260;
        char data;
        String email = "";
        for (int i=0; i<=top; i++) {
            data = (char)(rand.nextInt(25)+97);
            email = data + email;
        }
        email = email+"@gmail.com";
        System.out.println("If enter a email longer than 255,server return about 1001 ");
        System.out.println("Testing unit8...");
        contactUs.Test26("TT","0383859368",email,"aaa",null,"2", null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 8: Satisfied!");
    }
    @Test
    public void unitTest9() {
        int top = 20;
        char data;
        String email = "";
        for (int i=0; i<=top; i++) {
            data = (char)(rand.nextInt(25)+97);
            email = data + email;
        }
        System.out.println("If Enter the wrong email format,server return about 1001");
        System.out.println("Testing unit9...");
        contactUs.Test26("TT","phone",email,"aaa",null,"2", null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 9: Satisfied!");
    }
    @Test
    public void unitTest10() {
        String email = String.valueOf(new RandomEmail());
        int top = 70;
        char data;
        String phone = "";
        for (int i=0; i<=top; i++) {
            data = (char)(rand.nextInt(25)+97);
            phone = data+phone;
        }
        System.out.println("If enter a phone longer than 60,server return about 1001");
        System.out.println("Testing unit10...");
        contactUs.Test26("TT",phone ,email,"aaa",null,"2", null);
        Assertions.assertEquals(1001, contactUs.getCode());
        System.out.println("Unit 10: Satisfied!");
    }

}