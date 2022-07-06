package com.mrp.pageObjects.variables;

import java.util.HashMap;

public class GlobaVariables {

	public static HashMap<String, String> testData;

	public static String userName;
	public static String password;

	public static void setData(HashMap<String, String> Data) {
		testData = Data;
	}

	public static String getValue(String key) {
		return testData.get(key).trim();
	}

	public static void setCourseVariables() {
		userName = getValue("userName");
		password = getValue("password");
	}

}
