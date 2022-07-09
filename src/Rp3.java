

// DUng cho getListAuctionsByStatus
class Auction3 {
	String auction_id;
	String selling_user_id;
	String title;
	String start_date, end_date;
	String statusId, status;
	Category3 catergory = new Category3();
	Boolean isLiked; // Trung them cho getListLikes
}

class Data3 {
	Auction3[] auctions;
	String total;
}

class Category3 {
	String name;
	String image;
	String type;
}

public class Rp3 {
	public int code;
	public String message;
	public Data3 data = new Data3();
}
