import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class CreateComment {
    private static HttpURLConnection connection;

    public static Rp rp;
    int rpCode;


    public int fixed_comment_last_id;

    public String fixed_content;


    public void Test18(int auction_id, String access_token, String content, int comment_last_id) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        /// api/comments/create/{auctionId}
        try {
            URL url = new URL(BaseURL.baseURL + "comments/create/" + auction_id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + access_token);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n \"content\": \"" + content + "\"" + "    ,\n  \"comment_last_id\": \"" + comment_last_id
                    + "\"" + " \n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            // set to model
            this.setFixed_content(content+"");
            this.setFixed_comment_last_id(comment_last_id);


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
    public int getHttpCode(){
        return rpCode;
    }

    public String getMessage() {
        return rp.message;
    }

    public Data getData() {
        return rp.data;
    }

    public int getCodeData() {
        return rp.data.code;
    }
    public String getFixed_content() {
        return fixed_content;
    }

    public void setFixed_content(String fixed_content) {
        this.fixed_content = fixed_content;
    }

    public int getFixed_comment_last_id() {
        return fixed_comment_last_id;
    }

    public void setFixed_comment_last_id(int comment_last_id) {
        this.fixed_comment_last_id = comment_last_id;
    }


}