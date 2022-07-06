package clone;

import java.util.Scanner;
import java.util.TreeMap;

public class Header {
	TreeMap<Integer, String> headerFieldName = new TreeMap<Integer, String>();
	TreeMap<Integer, String> headerFieldData = new TreeMap<Integer, String>();
	String headerURL;
	int i = 1, j =1;

	public String getHeaderURL() {
		return headerURL;
	}

	public void setHeaderURL(String headerURL) {
		this.headerURL = headerURL;
	}

	public TreeMap<Integer, String> getHeaderFieldName() {
		return headerFieldName;
	}

	public void setHeaderFieldName(TreeMap<Integer, String> headerFieldName) {
		this.headerFieldName = headerFieldName;
	}

	public TreeMap<Integer, String> getHeaderFieldData() {
		return headerFieldData;
	}

	public void setHeaderFieldData(TreeMap<Integer, String> headerFieldData) {
		this.headerFieldData = headerFieldData;
	}

	public void putIntoTreeMap(TreeMap<Integer, String> map, int key, String value) {
		Integer key_object = Integer.valueOf(key);
		map.put(key_object, value);
	}

	public String getHeaderName(int i) {
		return this.headerFieldName.get(i);
	}

	public String getHeaderData(int i) {
		return this.headerFieldData.get(i);
	}

	public void inputHeaderName() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Nhap vao ten header thu " + i);
			sc.nextLine();
			String header_name = sc.nextLine();
			this.putIntoTreeMap(headerFieldName, i, header_name);
			i++;
		}
	}

	public void inputHeaderData() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Nhap vao gia tri header " + getHeaderName(i) + " : ");
			String header_name = sc.nextLine();
			this.putIntoTreeMap(headerFieldData, i, header_name);
			i++;
		}
	}
}
