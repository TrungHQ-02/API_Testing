

import com.google.gson.Gson;

import freq.BaseURL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ContactUs {
    private static HttpURLConnection connection;
    public static Rp rp;

    public String fixed_name,fixed_phone, fixed_email,fixed_file, fixed_report_type;
    public String fixed_content;
    public void Test26(String name, String phone, String email, String content, String file, String report_type, String accessToken) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        try {
            URL url = new URL(BaseURL.baseURL +"contactUs" );
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + accessToken);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n \"name\": \"" + name + "\"" + "    ,\n  \"phone\": \"" +phone
                    + "\"" + "    ,\n  \"email\": \"" + email + "\"" + "    ,\n  \"content\": \"" + content
                    + "\"" + "    ,\n  \"file\": \"" + file + "\"" + "    ,\n  \"report_type\": \"" + report_type + "\"" + "\n }";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            // set to model
            this.setFixed_name(name);
            this.setFixed_phone(phone);
            this.setFixed_email(email);
            this.setFixed_content(content);
            this.setFixed_file(file);
            this.setFixed_report_type(report_type);

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


    public String getFixed_name() {return fixed_name;}

    public void setFixed_name(String name) { this.fixed_name = name; }

    public String getFixed_phone() {return fixed_phone;}

    public void setFixed_phone(String phone) {
        this.fixed_phone= phone;
    }

    public String getFixed_email() {
        return fixed_email;
    }

    public void setFixed_email(String fixed_email) { this.fixed_email = fixed_email; }

    public String getFixed_content() {
        return fixed_content;
    }

    public void setFixed_content(String fixed_content) { this.fixed_content = fixed_content; }

    public String getFixed_file() {
        return fixed_file;
    }

    public void setFixed_file (String fixed_file) {this.fixed_file = fixed_file; }

    public String getFixed_report_type() {
        return fixed_report_type;
    }

    public void setFixed_report_type(String fixed_report_type) { this.fixed_report_type = fixed_report_type;}

}
