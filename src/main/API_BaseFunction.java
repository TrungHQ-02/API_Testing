package main;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import freq.BASE_URL;

public class API_BaseFunction {
	public URL url;
	public HttpsURLConnection connection;
	public String requestMethod;

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public HttpsURLConnection getConnection() {
		return connection;
	}

	public void setConnection(HttpsURLConnection connection) {
		this.connection = connection;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String method) {
		this.requestMethod = method;
	}

	public API_BaseFunction(String addition) throws IOException {
		this.url = new URL(BASE_URL.BASE + addition);
		this.connection = (HttpsURLConnection)this.url.openConnection();
	}

	public void connect() throws IOException {
		connection = (HttpsURLConnection) url.openConnection();
	}
	
	public void makeMethod() throws ProtocolException {
		this.connection.setRequestMethod(requestMethod);
	}

}
