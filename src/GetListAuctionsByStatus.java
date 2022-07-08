import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetListAuctionsByStatus {
    private static HttpURLConnection connection;
    public static Rp3 rp;
    public String fixedId;

    public String getFixedId() {
		return fixedId;
	}


	public void setFixedId(String fixedId) {
		this.fixedId = fixedId;
	}


	public void Test07(int statusId, int index, int count, String token) {
    	// access_token is nullable
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        //https://auctions-app-2.herokuapp.com/api/auctions/listAuctionsByStatus?statusId=1&index=1&count=3
        try {
            URL url = new URL("https://auctions-app-2.herokuapp.com/api/auctions/listAuctionsByStatus?" 
            	    + statusId 
            		+ "&index=" + index 
            		+ "&count=" + count);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer" + token);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            this.setFixedId(statusId+"");
            
            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(respondContent.toString(), Rp3.class);

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
    
    public Data3 getData() {
    	return rp.data;
    }
}
