package clone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class PostmanClone {
	public Body body = new Body();
	public Header header = new Header();
	public Token token = new Token();
	public String method;
	public String data;
	public String request_url;
	public String header_msg;
	public String body_msg;

	public String respond;

	public String getRespond() {
		return respond;
	}

	public void setRespond(String respond) {
		this.respond = respond;
	}

	String line;
	BufferedReader reader;
	StringBuffer respondContent = new StringBuffer();

	private static HttpURLConnection connection;

	public String getHeader_msg() {
		return header_msg;
	}

	public void setHeader_msg(String header_msg) {
		this.header_msg = header_msg;
	}

	public String getBody_msg() {
		return body_msg;
	}

	public void setBody_msg(String body_msg) {
		this.body_msg = body_msg;
	}

	public String getRequest_url() {
		return request_url;
	}

	public void setRequest_url(String request_url) {
		this.request_url = request_url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setProperties() {
		PostmanClone clone = new PostmanClone();
		System.out.println("Enter Request URL");
		int choice1 = -1;
		try (Scanner sc = new Scanner(System.in)) {
			request_url = sc.nextLine();
			clone.setRequest_url(request_url);

			System.out.println("\nToken:");
			System.out.println("Press 1 to add a token \nPress 0 if you do not need a token");
			while (choice1 != 1 && choice1 != 0) {
				choice1 = sc.nextInt();
				if (choice1 != 1 && choice1 != 0) {
					System.out.println("Re-enter");
				}

				if (choice1 == 0) {
					clone.token.setToken("NO TOKEN");
					break;
				} else {
					String token_authen = sc.nextLine();
					clone.token.setToken(token_authen);
				}
			}

			int choice2 = -1;

			System.out.println("\nMethod: ");
			System.out.println("Press 1 as POST \nPress 2 as GET");
			while (choice2 != 1 && choice2 != 2) {
				choice2 = sc.nextInt();
				if (choice2 != 1 && choice2 != 2) {
					System.out.println("Re-enter");
				}
				if (choice2 == 1) {
					clone.setMethod("POST");
				} else {
					clone.setMethod("GET");
				}
			}

			int choice3 = -1;

			System.out.println("\nHeader: ");
			System.out.println("Press 1 if you need to use header \nPress 0 if you do not");
			while (choice3 != 1 && choice3 != 0) {
				choice3 = sc.nextInt();
				if (choice3 != 1 && choice3 != 0) {
					System.out.println("Re-enter");
				}

				if (choice3 == 0) {
					clone.setHeader_msg("None");
					break;
				} else {
					clone.setHeader_msg("YES");
					int choice_4 = -1;
					while (choice_4 != 0) {
						System.out.println("Start to enter header name\nPress 1 to continue\nPress 0 to stop");
						choice_4 = sc.nextInt();
						while(choice_4 != 0) {		
							if (choice_4 == 1) {
								clone.header.inputHeaderName();								
							} else {
								
							}
						}
						System.out.println("Start to enter header data\\nPress 1 to continue\\nPress 0 to stop");
						choice_4 = sc.nextInt();
						while(choice_4 != 0) {		
							if (choice_4 == 1) {
							} else {
								clone.header.inputHeaderData();								
							}
						}
					}
				}
			}

			int choice4 = -1;

			System.out.println("\nBody: ");
			System.out.println("Press 1 if you need to use header \nPress 0 if you do not");
			while (choice4 != 1 && choice4 != 0) {
				choice4 = sc.nextInt();
				if (choice4 != 1 && choice4 != 0) {
					System.out.println("Re-enter");
				}

				if (choice4 == 0) {
					clone.setBody_msg("None");
					break;
				} else {
					clone.setBody_msg("YES");
					while (true) {
						System.out.println("Start to enter header name\nPress 1 to continue\nPress 0 to stop");
						clone.body.inputBodyName();
						System.out.println("Start to enter header data\nPress 1 to continue\nPress 0 to stop");
						clone.body.inputBodyData();
					}
				}
			}
		}
		// send request
		try {
			String addi = "";
			if (clone.header_msg == "YES") {
				addi += "?";
				Set<Integer> keySet = clone.header.headerFieldName.keySet();
//				Set<Integer> keySet2 = clone.header.headerFieldData.keySet();
				for (int i = 1; i <= keySet.size(); i++) {
					addi = addi + clone.header.getHeaderName(i) + "=" + clone.header.getHeaderData(i);
					if (i != keySet.size()) {
						addi = addi + "&";
					}
				}
			}
			URL url = new URL(clone.request_url + addi);
			System.out.println(clone.request_url + addi);

			// Still OKE with get no token

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(clone.method);
			System.out.println(clone.method);
			// STILL OKE
			if (clone.token.getToken() != "NO TOKEN") {
				connection.setRequestProperty("Authorization", "Bearer" + clone.token.getToken());
			}

			if (clone.getMethod() == "POST") {
				connection.setRequestProperty("Accept", "application/json");
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setDoOutput(true);

				if (clone.getBody_msg() == "YES") {
					Set<Integer> keySet = clone.body.bodyFieldName.keySet();
					String data = "{";
					for (int i = 1; i <= keySet.size(); i++) {
						data = data + "\n \"" + clone.body.getBodyName(i) + "\": \"" + clone.body.getBodyData(i) + "\"";
						if (i != keySet.size()) {
							data += ",";
						}
					}
					data += "\n}";
//					String data = "{\n \"email\": \"" + email + "\","
//							+ "     \n  \"password\": \"" + pass + "\","
//									+ "\n}";
					byte[] out = data.getBytes(StandardCharsets.UTF_8);
					OutputStream stream = connection.getOutputStream();
					stream.write(out);
				}

			}
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				respondContent.append(line);
			}

			this.setRespond(respondContent.toString());
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
	}

	public static void main(String[] args) {
		PostmanClone clone = new PostmanClone();
		clone.setProperties();
		System.out.println(clone.getRespond());
	}
}
