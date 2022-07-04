
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
    Deny[] denys;
    Bid[] bids;
    String total_not_read; // for notif by Trung
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

class Deny{
	String title;
	String start_date, end_date;
	String reason;
	String auction_id;
	String updated_at;
	String type;
	String is_read;
}

class Bid{
	String user_name;
	String user_avatar;
	String price;
	String updated_at;
}

public class Rp {
    public int code;
    public String message;
    Data data = new Data();
}
