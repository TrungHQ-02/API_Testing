import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

public class LikeAuction {
	private static HttpURLConnection connection;

	public static Rp rp;
	
	public String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void Test22(String accessToken, String auctionId) {
		String line;
		BufferedReader reader;
		StringBuffer respondContent = new StringBuffer();

		// Connect and parse Json
		try {
			URL url = new URL("https://auctions-app-2.herokuapp.com/api/updateLike/" + auctionId);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Bearer" + accessToken);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

            String data = "{\n \"auction_id\": \"" + auctionId + "\"\n}";
			byte[] out = data.getBytes(StandardCharsets.UTF_8);
			OutputStream stream = connection.getOutputStream();
			stream.write(out);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				respondContent.append(line);
			}

			this.setContent(respondContent.toString());
			System.out.println(respondContent);
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

	public String getToken() {
		return rp.data.access_token;
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
