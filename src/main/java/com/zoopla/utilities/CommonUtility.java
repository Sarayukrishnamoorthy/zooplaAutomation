package com.zoopla.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;


public class CommonUtility {

	Properties prop = new Properties();
	FileInputStream file = null;
	
	public  String sUserDir = System.getProperty("user.dir");
	String sProjectBasePath = "/src/main/java/com/zoopla/";
	public  String sConfigPath = sUserDir + sProjectBasePath +"properties/config.properties";
	public  String slog4jPath = sUserDir + sProjectBasePath +"properties/log4j.properties";
	
	public void loadPropertyFile(String sPath) {
		try {
			file = new FileInputStream(sPath);
			prop.load(file); 
			System.getProperties().putAll(prop);
		} catch (Exception e) {
			
		}
	}
	
	public void loadLog4jPropertyFile(String sPath) {
		try {
			file = new FileInputStream(sPath);
			prop.load(file);
			PropertyConfigurator.configure(prop);
		} catch (Exception e) {
		}
	}
	
	public String getBrowserName() {
		return System.getProperty("browser");
	}
	public String getUrl() {
		return System.getProperty("url");
	}
}
