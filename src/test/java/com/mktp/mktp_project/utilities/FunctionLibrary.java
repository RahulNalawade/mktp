package com.mktp.mktp_project.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Dimension;

import com.mktp.mktp_project.prerequisites.InitialSetUp;

import io.appium.java_client.TouchAction;

public class FunctionLibrary {
	
	
	
	//Function to Create random numbers less than 10
	
	public static String less_than_10_randomnum()
	
	{
		Random rand = new Random();
		
		String phone_no = "1";
		for(int i = 1;i<8;i++ )
		{
			phone_no = phone_no + Integer.toString(rand.nextInt(8));
			
		}
		
		return  phone_no ;
	}
	

// Function to create a random 10 characters
	
public static  String ten_randomchar() {
	
	int stringLength = 10;
	
	return RandomStringUtils.randomAlphabetic(stringLength);
	
}







//Function to Create random string more than 20

public static  String more_than_20randomchar() {
	
	int stringLength = 21;
	
	return RandomStringUtils.randomAlphabetic(stringLength);
	
}

public static Properties getPropertyFile(String propFile){
	
	Properties properties = new Properties();
	//String propFile = "config.properties";
	InputStream resourceAsStream = InitialSetUp.class.getClassLoader().getResourceAsStream(propFile);
	
	if(resourceAsStream!=null){
		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	return properties;
}

//Function to Create random email id

public static String randomEmail() {
	
	int stringLength = 5;
    return RandomStringUtils.randomAlphabetic(stringLength) + "@example.com";
}


public static void tapOnPoint(int x,int y)
{
	TouchAction deleteAlbum = new TouchAction(InitialSetUp.wd);
	deleteAlbum.tap(x, y).perform();
}
}
