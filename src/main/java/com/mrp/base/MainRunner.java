package com.mrp.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class MainRunner {
	
	public static void main(String[] args) {

		//String myCurrentDir = System.getProperty("user.dir");
		//String filePath = myCurrentDir + File.separator+"testngFiles";
		
		
//		File folder = new File(myCurrentDir);
//		File[] listOfFiles = folder.listFiles();
		// Create object of TestNG Class
		TestNG runner=new TestNG();

		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();

		// Add xml file which you have to execute
		suitefiles.add("src/main/java/com/mrp/config/testngFiles/testng_Smoke.xml");
		runner.setTestSuites(suitefiles);
		runner.run();
		}
}
