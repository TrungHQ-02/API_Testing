import com.google.gson.Gson;

import freq.BaseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class GetListComments {
    private static HttpURLConnection connection;
    public static Rp4 rp;

    public void Test15(int acuction_id, int index, int count, String token) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();
        try {
            URL url = new URL(BaseURL.baseURL + "comments/" + acuction_id +"?count=" + count + "&index=" + index);
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
            rp = g.fromJson(respondContent.toString(), Rp4.class);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
    public int getCode(){
        return rp.code;
    }
    public String getMessage(){
        return rp.message;
    }
    public int getCommentsLength(){
        return rp.data.comments.length;
    }
    public comments[] getComments(){
        return rp.data.comments;
    }
    public int getCommentId(comments[] comments){
        return comments[0].comment_id;
    }

}
