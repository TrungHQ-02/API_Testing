import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetNewsTest {
	GetNews getNews = new GetNews();
	Login login = new Login();

	@Test
	@DisplayName("Unit Test 1")
	public void UnitTest1() {
		getNews.Test25(1, 1, null);
		Assertions.assertEquals(1000, getNews.getCode());
		Assertions.assertNotEquals(null, getNews.getTotal());

	}

	@Test
	@DisplayName("Unit Test 2:")
	public void UnitTest2() {
		login.Test01("minh0915@gmail.com", "123456");
		getNews.Test25(1, 1, login.getToken());
		Assertions.assertEquals(1000, getNews.getCode());
		Assertions.assertNotEquals(null, getNews.getTotal());
	}
}