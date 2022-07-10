
public class Rp5 {
// DUng cho getListAuctions
	int code; 
	String message;
	DataForGLA data = new DataForGLA();
}

class CategoryForGLA{
	String name;
	String image;
	String type;
}

class AuctionForGLA{
	String auction_id;
	String selling_user_id;
	String title;
	String start_date;
	String end_date;
	String statusId;
	String status;
	CategoryForGLA category;
}

class UserInfoForGLA{
	String name;
	String avatar;
	String phone;
	String email;
	String role;
	String address;
}

class DataForGLA{
	AuctionForGLA[] auctions;
	UserInfoForGLA user_info;
	String type;
	String category;
	String total;
}