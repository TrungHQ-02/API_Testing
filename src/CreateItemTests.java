
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;
public class CreateItemTests {
    CreateItem createItem = new CreateItem();
    Random rand = new Random();
    RandomEmail email = new RandomEmail();
    CreateAuction createAuction = new CreateAuction();

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MzY0MDkzLCJleHAiOjE2NTc3MjQwOTMsIm5iZiI6MTY1NzM2NDA5MywianRpIjoiYk92cjJGWXVLMUU4UThuNyIsInN1YiI6MzAzLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.nKJv4CFkUX4HrvXjaiCkiI5F8nIoBRQGdBNEsHs2cqk";
    @RepeatedTest(value = 2)
    public void unitTest1(){

        System.out.println("If all is correct, code should be 1000 and message should be OK");
        System.out.println("Testing unit1...");

        String randomTitle = email.getSaltString();
        String randomSeries = email.getStringWithFixedLength(10);

        createAuction.Test11("2","2022/07/12 11:11","2023/08/21 11:11", randomTitle, token);
        createItem.Test15(createAuction.getAuctionId(),"iphone 15 pro max ",100, 1,"mua 1 tang 2", randomSeries, token);

        Assertions.assertEquals(1000, createItem.getCode());
        Assertions.assertEquals("OK", createItem.getMessage());
        System.out.println("Unit 1: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest2(){

        System.out.println("If brand_id > 10, code should be 1001 and message should be brand: The selected brand id is invalid.&name: &series: &description: &starting_price: ");
        System.out.println("Testing unit2...");

        String randomTitle = email.getSaltString();
        String randomSeries = email.getStringWithFixedLength(10);

        createAuction.Test11("2","2022/07/12 11:11","2023/08/21 11:11", randomTitle, token);
        createItem.Test15(createAuction.getAuctionId(),"iphone 15 pro max",100, 11,"mua 1 tang 2", randomSeries,token );

        Assertions.assertEquals(1001, createItem.getCode());
        Assertions.assertEquals("brand: The selected brand id is invalid.&name: &series: &description: &starting_price: ", createItem.getMessage());
        System.out.println("Unit 2: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest3(){

        System.out.println("If name > 255, code should be 1001 and message should be brand: &name: 7001&series: &description: &starting_price: ");
        System.out.println("Testing unit3...");

        String randomTitle = email.getSaltString();
        String randomSeries = email.getStringWithFixedLength(10);
        String randomName = email.getStringWithFixedLength(260);

        createAuction.Test11("2","2022/07/12 11:11","2023/08/21 11:11", randomTitle, token);
        createItem.Test15(createAuction.getAuctionId(),randomName,100, 1,"mua 1 tang 2", randomSeries, token );

        Assertions.assertEquals(1001, createItem.getCode());
        Assertions.assertEquals("brand: &name: 7001&series: &description: &starting_price: ", createItem.getMessage());
        System.out.println("Unit 3: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest4(){

        System.out.println("If series > 10, code should be 1001 and message should be brand: &name: &series: 7011&description: &starting_price:");
        System.out.println("Testing unit4...");

        String randomTitle = email.getSaltString();
        String randomSeries = email.getStringWithFixedLength(11);

        createAuction.Test11("2","2022/07/12 11:11","2023/08/21 11:11", randomTitle,token);
        createItem.Test15(createAuction.getAuctionId(),"iphone 15 pro max ",100, 1,"mua 1 tang 2", randomSeries,token);

        Assertions.assertEquals(1001, createItem.getCode());
        Assertions.assertEquals("brand: &name: &series: 7011&description: &starting_price: ", createItem.getMessage());
        System.out.println("Unit 4: Satisfied!");
    }
    @RepeatedTest(value = 2)
    public void unitTest5(){

        System.out.println("If series is null, code should be 1001 and message should be brand: &name: &series: 7004&description: &starting_price: ");
        System.out.println("Testing unit5...");

        String randomTitle = email.getSaltString();
        String randomSeries = email.getStringWithFixedLength(10);

        createAuction.Test11("2","2022/07/12 11:11","2023/08/21 11:11", randomTitle,token);
        createItem.Test15(createAuction.getAuctionId(),"iphone 15 pro max ",100, 1,"mua 1 tang 2", null,token );

        Assertions.assertEquals(1001, createItem.getCode());
        Assertions.assertEquals("brand: &name: &series: 7004&description: &starting_price: ", createItem.getMessage());
        System.out.println("Unit 5: Satisfied!");
    }

}