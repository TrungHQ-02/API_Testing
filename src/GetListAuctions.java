import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetListAuctions {
    private static HttpURLConnection connection;
    public static Rp5 rp;
    public String fixedId; // de check
    public String fixedType;

    public String getFixedType() {
		return fixedType;
	}

	public void setFixedType(String fixedType) {
		this.fixedType = fixedType;
	}

	public String getFixedId() {
		return fixedId;
    }

	public void setFixedId(String fixedId) {
		this.fixedId = fixedId;
	}
	
	


	public void Test07(int statusId, String user_id,String type, String category_id, int index, int count, String token) {
    	// access_token is nullable
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        // https://auctions-app-2.herokuapp.com/api/auctions/2?index=1&count=10&user_id&type=1&category_id
        try {
            URL url = new URL(BaseURL.baseURL + "auctions/" 
            	    + statusId 
            		+ "?index=" + index 
            		+ "&count=" + count
            		+ "&user_id=" + user_id
            		+ "&type=" + type
            		+ "&category_id=" + category_id
            		);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer" + token);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            this.setFixedId(statusId+"");
            this.setFixedType(type);
            
            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(respondContent.toString(), Rp5.class);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
    
    public int getCode() {
    	return rp.code;
    }
    
    public String getMessage() {
    	return rp.message;
    }
    
    public DataForGLA getData() {
    	return rp.data;
    }
}
