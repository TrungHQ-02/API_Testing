
import java.util.Random;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import freq.RandomEmail;

public class GetListRatesTests {
    GetListRates listRates = new GetListRates();
    Random random = new Random();
    RandomEmail randomString = new RandomEmail();

    @RepeatedTest(value = 4)
    public void unitTest01(){
        System.out.println("If all is correct, code should be 1000 and message should be OK");
        System.out.println("Testing unit01...");

        listRates.Test43(1, 1, 1, null);
        Assertions.assertEquals(1000, listRates.getCode());
        Assertions.assertEquals("OK", listRates.getMessage());
        System.out.println("Unit 1: Satisfied");
    }
    @RepeatedTest(value = 4)
    public void unitTest02() {
        System.out.println("Code should be 1000 and message should be OK with the negative input for index and count");
        System.out.println("Testing unit2...");
        for (int i = 1; i <= 2; i++) {
            int randomId = random.nextInt(1,3);
            int randomIndex = random.nextInt(-5,-1);
            int randomCount = random.nextInt(-5,-1);
            listRates.Test43(randomId, randomIndex, randomCount, null);
            Assertions.assertEquals(1000, listRates.getCode());
            Assertions.assertEquals("OK", listRates.getMessage());
        }
        System.out.println("Unit 2: Satisfied!");
    }

    @RepeatedTest(value = 4)
    public void unitTest03() {
        System.out.println("Code should be 1000 and message should be OK even when token is wrong");
        System.out.println("Testing unit3...");
        for (int i = 1; i <= 2; i++) {
            int randomId = random.nextInt(1, 3);
            int randomIndex = random.nextInt(1, 4);
            int randomCount = random.nextInt(1, 5);
            String random_token = randomString.getStringWithFixedLength(100);
            listRates.Test43(randomId, randomIndex, randomCount, random_token);
            Assertions.assertEquals(1000, listRates.getCode());
            Assertions.assertEquals("OK", listRates.getMessage());
        }
        System.out.println("Unit 3: Satisfied!");
    }

    @RepeatedTest(value = 4)
    public void unitTest04() {
        System.out.println("Total of bids should be greater than or equals to zero");
        System.out.println("Testing unit4...");
        for (int i = 1; i <= 2; i++) {
            int randomId = random.nextInt(1, 3);
            int randomIndex = random.nextInt(1, 4);
            int randomCount = random.nextInt(1, 5);
            listRates.Test43(randomId, randomIndex, randomCount, null);
            int totalAuctions = Integer.parseInt(listRates.getData().total);
            Assertions.assertTrue(totalAuctions >= 0);
        }
        System.out.println("Unit 4: Satisfied!");
    }
}