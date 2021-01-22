package com.mktp.mktp_project.utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;

import com.mktp.mktp_project.prerequisites.InitialSetUp;

public class JavaUtils {
	public static  Properties readPropertyFile()
	{
		//Read Property File
				String propFile = "config.properties";
				Properties propertyFile = JavaUtils.getPropertyFile(propFile);
				return propertyFile;
	}
	
	public static Properties getPropertyFile(String propFile)
	{
		Properties properties = new Properties();
		InputStream resourceAsStream = JavaUtils.class.getClassLoader().getResourceAsStream(propFile);
		if(resourceAsStream!=null){
		try {
		properties.load(resourceAsStream);
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

		return properties;
		}
	
	public static void uploadFile() throws InterruptedException, Throwable
	{
		Robot robot = new Robot();
	     Thread.sleep(4000);
	     // attach file
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     Thread.sleep(4000);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     //robot.keyRelease(KeyEvent.VK_V);
	     Thread.sleep(6000);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     Thread.sleep(4000);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     Thread.sleep(4000); 
	}
	
	
	
}
