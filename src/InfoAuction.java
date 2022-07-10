import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InfoAuction {
	private static HttpURLConnection connection;
	public static Rp rp;
	public String fixedId; // de check
	public String content;
	// de check html

	public String getFixedId() {
		return fixedId;
	}

	public void setFixedId(String fixedId) {
		this.fixedId = fixedId;
	}

	public void Test14(String auctionId, String token) {
		// access_token is nullable
		String line;
		BufferedReader reader;
		StringBuffer respondContent = new StringBuffer();

		try {
			URL url = new URL(BaseURL.baseURL + "auctions/info/" + auctionId);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Bearer" + token);

			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				respondContent.append(line);
			}
			System.out.println(respondContent);
			
			this.setFixedId(auctionId);
			this.setContent(respondContent.toString());

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
}
