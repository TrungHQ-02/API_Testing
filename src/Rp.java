// Response Object

class User {
	// For Test Login
	String name, role, email, address, avatar, phone;
}

class Data {
	String access_token;
	String token_type;
	String expires_in;
	User user = new User();
	Deny[] denys;
	Bid[] bids;
	String total_not_read; // for notif by Trung
	String total;
	String user_id; // For likeauction by Trung
	String auction_id;
	String is_liked;
	
	// for edit auction by Trung
	String title, category_id, selling_user_id;
	String start_date, end_date;
	String status, reason;
	
	// for getCategories
	String name;
	String image;
	String type;
	
	String content;
	String update_at;
}


class Category {
	String name;
	String image;
	String type;
}

class Deny {
	String title;
	String start_date, end_date;
	String reason;
	String auction_id;
	String updated_at;
	String type;
	String is_read;
}

class Bid {
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
