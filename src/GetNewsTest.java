import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetNewsTest {
    GetNews getNews = new GetNews();
    @Test
    @DisplayName("Unit Test 1")
    public void UnitTest1(){
        getNews.Test24(1,1,null);
        Assertions.assertEquals(1000, getNews.getCode() );
        Assertions.assertNotEquals(null, getNews.getTotal());

    }

}