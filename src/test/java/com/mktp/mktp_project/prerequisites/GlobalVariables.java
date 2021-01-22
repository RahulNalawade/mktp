package com.mktp.mktp_project.prerequisites;

import java.util.Properties;

import com.mktp.mktp_project.utilities.MobileUtils;

public class GlobalVariables {



	static String propFile = "config.properties";
	static Properties propertyFile = com.mktp.mktp_project.utilities.FunctionLibrary.getPropertyFile(propFile);
	
	public static String appiumURL=propertyFile.getProperty("appiumURL");
	
	public static String deviceName=propertyFile.getProperty("deviceName");
	
	public static String platformVersion=propertyFile.getProperty("platformVersion");
	
	public static String appName=propertyFile.getProperty("app_Name");

	public static String enviornment=propertyFile.getProperty("environment");
	
	public static String platform=propertyFile.getProperty("platform");
		
}
