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
}
public class Rp {
    public int code;
    public String message;
    Data data = new Data();
}
