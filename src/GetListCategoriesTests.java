package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetListCategoriesTests {
	GetListCategories categories = new GetListCategories();

	@Test
	public void unitTest1() {
		System.out.println("Code should always be 1000 and message should always be OK ");
		System.out.println("Testing unit1...");
		categories.Test18();
//		Data[] dataArray = categories.getData().clone();
//		System.out.println(dataArray[1].category_id);
		Assertions.assertEquals(1000, categories.getCode());
		Assertions.assertEquals("OK", categories.getMessage());
		System.out.println("Unit 1: Satisfied");
	}

	@Test
	public void unitTest2() {
		System.out.println("Category id should be greater than zero and less than 10");
		System.out.println("Testin unit2...");
		categories.Test18();
		Data[] dataArray = categories.getData().clone();
		for (int i = 0; i < dataArray.length; i++) {
			Assertions.assertTrue(
					10 > Integer.parseInt(dataArray[i].category_id) && Integer.parseInt(dataArray[i].category_id) > 0);
		}
		System.out.println("Unit 2: Satisfied");
	}

	@Test
	public void unitTest3() {
		System.out.println("Category name should not be null or empty");
		System.out.println("Testin unit3...");
		categories.Test18();
		Data[] dataArray = categories.getData().clone();
		for (int i = 0; i < dataArray.length; i++) {
			Assertions.assertNotEquals(null, dataArray[i].name);
			Assertions.assertNotEquals("", dataArray[i].name);
		}
		System.out.println("Unit 3: Satisfied");
	}
	
	@Test
	public void unitTest4() {
		System.out.println("Category image should not be null or empty");
		System.out.println("Testin unit4...");
		categories.Test18();
		Data[] dataArray = categories.getData().clone();
		for (int i = 0; i < dataArray.length; i++) {
			Assertions.assertNotEquals(null, dataArray[i].image);
			Assertions.assertNotEquals("", dataArray[i].image);
		}
		System.out.println("Unit 4: Satisfied");
	}
	
	@Test
	public void unitTest5() {
		System.out.println("Category type should be 1 2 3 4 5");
		System.out.println("Testin unit5...");
		categories.Test18();
		Data[] dataArray = categories.getData().clone();
		for (int i = 0; i < dataArray.length; i++) {
			Assertions.assertTrue(Integer.parseInt(dataArray[i].type) > 0);
			Assertions.assertTrue(Integer.parseInt(dataArray[i].type) < 6);
		}
		System.out.println("Unit 5: Satisfied");
	}
}
