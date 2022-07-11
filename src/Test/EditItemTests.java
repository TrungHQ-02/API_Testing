import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class EditItemTests {
    EditItem editItem = new EditItem();
    Random rand = new Random();
    RandomEmail email = new RandomEmail();

    CreateItem createItem = new CreateItem();

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MzY0MDkzLCJleHAiOjE2NTc3MjQwOTMsIm5iZiI6MTY1NzM2NDA5MywianRpIjoiYk92cjJGWXVLMUU4UThuNyIsInN1YiI6MzAzLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.nKJv4CFkUX4HrvXjaiCkiI5F8nIoBRQGdBNEsHs2cqk";
    // Note: trong file excel data tra ve day du thong tin san pham, nhung test bang postman thi chi tra ve minh name va images
    // Khong co api nao co data tra ve co chua item_id, 255 o duoi la tim duoc cai item ma minh da create nen moi co quyen chinh sua
    @RepeatedTest(value = 2)
    public void unitTest1(){

        System.out.println("If all is correct, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");

        String randomSeries = email.getStringWithFixedLength(10);

        editItem.Test16("255","iphone 17 pro max",1010, 1,"mua 1 tang 3", randomSeries, token);

        Assertions.assertEquals(1000, editItem.getCode());
        Assertions.assertEquals("OK", editItem.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest2(){

        System.out.println("If do not enter name, code should be 1001 and message should be brand: &name: 7000&series: &description: &starting_price: ");
        System.out.println("Testing unit2...");

        String randomSeries = email.getStringWithFixedLength(10);

        editItem.Test16("255","",1010, 1,"mua 1 tang 3", randomSeries, token);

        Assertions.assertEquals(1001, editItem.getCode());
        Assertions.assertEquals("brand: &name: 7000&series: &description: &starting_price: ", editItem.getMessage());
        System.out.println("Unit 2: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest3(){

        System.out.println("If all is correct, code should be 1000 and message should be brand: &name: &series: &description: 7000&starting_price: ");
        System.out.println("Testing unit3...");

        String randomSeries = email.getStringWithFixedLength(10);

        editItem.Test16("255","iphone 17 pro max",1010, 1,"", randomSeries, token);

        Assertions.assertEquals(1001, editItem.getCode());
        Assertions.assertEquals("brand: &name: &series: &description: 7000&starting_price: ", editItem.getMessage());
        System.out.println("Unit 3: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest4(){

        System.out.println("If do not enter description, code should be 1001 and message should be brand: &name: &series: &description: 7000&starting_price: ");
        System.out.println("Testing unit4...");

        String randomSeries = email.getStringWithFixedLength(10);

        editItem.Test16("255","iphone 15 pro max",1000, 4,"", randomSeries, token);

        Assertions.assertEquals(1001, editItem.getCode());
        Assertions.assertEquals("brand: &name: &series: &description: 7000&starting_price: ", editItem.getMessage());
        System.out.println("Unit 4: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest5(){

        System.out.println("If series > 10, code should be 1001 and message should be brand: &name: &series: 7011&description: &starting_price: ");
        System.out.println("Testing unit5...");

        String randomSeries = email.getStringWithFixedLength(11);

        editItem.Test16("255","iphone 17 pro max",1010, 1,"mua 1 tang 3", randomSeries, token);

        Assertions.assertEquals(1001, editItem.getCode());
        Assertions.assertEquals("brand: &name: &series: 7011&description: &starting_price: ", editItem.getMessage());
        System.out.println("Unit 5: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest6(){

        System.out.println("If not creator of the item, code should be 1005 and message should be Không thể chỉnh sửa");
        System.out.println("Testing unit6...");

        String randomSeries = email.getStringWithFixedLength(10);

        editItem.Test16("1","iphone 17 pro max",1010, 4,"mua 1 tang 3", randomSeries, token);

        Assertions.assertEquals(1005, editItem.getCode());
        Assertions.assertEquals("Không thể chỉnh sửa", editItem.getMessage());
        System.out.println("Unit 6: Satisfied!");
    }
}
