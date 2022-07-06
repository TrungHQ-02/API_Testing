package clone;

import java.util.Scanner;
import java.util.TreeMap;

public class Body {
	TreeMap<Integer, String> bodyFieldName = new TreeMap<Integer, String>();
	TreeMap<Integer, String> bodyFieldData = new TreeMap<Integer, String>();
	String postData;

	public TreeMap<Integer, String> getBodyFieldName() {
		return bodyFieldName;
	}

	public void setBodyFieldName(TreeMap<Integer, String> bodyFieldName) {
		this.bodyFieldName = bodyFieldName;
	}

	public TreeMap<Integer, String> getBodyFieldData() {
		return bodyFieldData;
	}

	public void setBodyFieldData(TreeMap<Integer, String> bodyFieldData) {
		this.bodyFieldData = bodyFieldData;
	}

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public void putIntoTreeMap(TreeMap<Integer, String> map, int key, String value) {
		Integer key_object = Integer.valueOf(key);
		map.put(key_object, value);
	}

	public String getBodyName(int i) {
		return this.bodyFieldName.get(i);
	}
	
	public String getBodyData(int i) {
		return this.bodyFieldData.get(i);
	}

	public void inputBodyName() {
		String choice = "YES";
		int i = 1;
		try (Scanner sc = new Scanner(System.in)) {
			while (choice != "0") {
				System.out.println("Nhap vao ten header thu " + i);
				String body_name = sc.nextLine();
				this.putIntoTreeMap(bodyFieldName, i, body_name);
			}
		}
	}

	public void inputBodyData() {
		String choice = "YES";
		int i = 1;
		try (Scanner sc = new Scanner(System.in)) {
			while (choice != "0") {
				System.out.println("Nhap vao gia tri header " + getBodyName(i) + ":");
				String header_data = sc.nextLine();
				this.putIntoTreeMap(bodyFieldData, i, header_data);
			}
		}
	}
}
