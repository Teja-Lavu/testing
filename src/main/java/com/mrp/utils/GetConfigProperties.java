package com.mrp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetConfigProperties {

	public static Properties prop = new Properties();
	public static FileInputStream fis;

	public static Properties initConfig() {
		try {
			fis = new FileInputStream("src"+File.separator+"main"+File.separator+"java"+ File.separator+"com"+File.separator+"mrp"+ File.separator+"config"+File.separator+"Configurationfiles"+File.separator+"Config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getPropValue(String key) {    
		String cmdline = System.getProperty(key);
		if (cmdline != null) return cmdline;
		return initConfig().getProperty(key);    
	}

}
