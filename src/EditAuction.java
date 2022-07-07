import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class EditAuction {
	private static HttpURLConnection connection;

	public static Rp rp;
	
	public String fixed_id;
	
	public String fixed_start_date, fixed_end_date;
	
	public String fixed_auction_id, fixed_title;


	public void Test12(String auctionId, String category_id, String start_date, String end_date, String title_ni,String accessToken) {
		String line;
		BufferedReader reader;
		StringBuffer respondContent = new StringBuffer();
		// Connect and parse Json
		/// api/auctions/edit/{auctionId}
		try {
			URL url = new URL("https://auctions-app-2.herokuapp.com/api/auctions/edit/" + auctionId);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Bearer" + accessToken);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			String data = "{\n \"category_id\": \"" + category_id + "\"" + "    ,\n  \"start_date\": \"" + start_date
					+ "\"" + "    ,\n  \"end_date\": \"" + end_date + "\"" + "    ,\n  \"title_ni\": \"" + start_date
					+ "\"" + "\n}";
			byte[] out = data.getBytes(StandardCharsets.UTF_8);
			OutputStream stream = connection.getOutputStream();
			stream.write(out);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				respondContent.append(line);
			}

			// set to model
			this.setFixed_id(category_id+"");
			this.setFixed_auction_id(auctionId);
			this.setFixed_end_date(end_date);
			this.setFixed_start_date(start_date);
			this.setFixed_title(title_ni);
			
			// Parse JSON
			Gson g = new Gson();
			rp = g.fromJson(respondContent.toString(), Rp.class);

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

	public Data getData() {
		return rp.data;
	}
	
	public String getFixed_auction_id() {
		return fixed_auction_id;
	}

	public void setFixed_auction_id(String fixed_auction_id) {
		this.fixed_auction_id = fixed_auction_id;
	}

	public String getFixed_title() {
		return fixed_title;
	}

	public void setFixed_title(String fixed_title) {
		this.fixed_title = fixed_title;
	}

	public String getFixed_start_date() {
		return fixed_start_date;
	}

	public void setFixed_start_date(String fixed_start_date) {
		this.fixed_start_date = fixed_start_date;
	}

	public String getFixed_end_date() {
		return fixed_end_date;
	}

	public void setFixed_end_date(String fixed_end_date) {
		this.fixed_end_date = fixed_end_date;
	}

	public String getFixed_id() {
		return fixed_id;
	}

	public void setFixed_id(String fixed_id) {
		this.fixed_id = fixed_id;
	}
}
