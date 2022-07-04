import java.lang.reflect.Array;

// Response Object

class User {
	// For Test Login
	String name, role, email, address, avatar, phone;
}

class Data{
    String access_token;
    String token_type;
    String expires_in;
    User user = new User();
    Auction[] auctions;
    String total;
}

class Category{
	String name;
	String image;
	String type;
}

class Auction{
	String auction_id;
    String selling_user_id;
    String title;
    String start_date, end_date;
    String statusId, status;
    Category catergory = new Category();
}

public class Rp {
    public int code;
    public String message;
    Data data = new Data();
}
