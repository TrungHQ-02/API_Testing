import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetListBids {
	private static HttpURLConnection connection;
	public static Rp rp;

	// On
	public void Test22(int auctionId, int index, int count, String token) {
		// access_token is nullable
		String line;
		BufferedReader reader;
		StringBuffer respondContent = new StringBuffer();

		// Connect and parse Json
		// https://auctions-app-2.herokuapp.com/api/bids/{auctionId}
		try {
			URL url = new URL(BaseURL.baseURL + "bids/" + auctionId + "?index=" + index
					+ "&count=" + count);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Bearer" + token);

			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				respondContent.append(line);
			}
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