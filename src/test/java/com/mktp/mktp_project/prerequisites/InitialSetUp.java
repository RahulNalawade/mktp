package com.mktp.mktp_project.prerequisites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

import com.mktp.mktp_project.utilities.FunctionLibrary;
import com.mktp.mktp_project.utilities.JavaUtils;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class InitialSetUp {
	
	
    static AppiumDriverLocalService appiumService;
    public static WebDriver driver;
    public static MobileDriver wd;
	public static AndroidDriver<MobileElement> ad;
	
	static String propFile = "config.properties";
    static Properties propertyFile = FunctionLibrary.getPropertyFile(propFile);
    
    static DesiredCapabilities capabilities = new DesiredCapabilities();
    
	/*
	 * protected static String platformName = propertyFile.getProperty("platform");
	 * protected static String environment =
	 * propertyFile.getProperty("environment"); protected static String appName =
	 * propertyFile.getProperty("app_Name"); protected static String deviceName =
	 * propertyFile.getProperty("deviceName"); public static String platform_Name =
	 * propertyFile.getProperty("platform"); public static String app_Name =
	 * propertyFile.getProperty("app_Name"); public static String platformVersion =
	 * propertyFile.getProperty("platformVersion"); public static String device_Name
	 * = propertyFile.getProperty("deviceName");
	 */

    
    public static void initializationAppium() {
		
		
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  System.out.println("URL = "+propertyFile.getProperty("mktp_URL"));
		  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
		  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "c372d4c6");
		  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,MobileBrowserType.CHROME);
		  capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		  capabilities.setCapability("unicodeKeyboard", true);
		  capabilities.setCapability("resetKeyboard", true);
		  //capabilities.setCapability("app-package","com.google.android.apps.chrome");
		  //capabilities.setCapability("app-activity", "com.google.android.apps.chrome.main");
		  capabilities.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"/testdata/chromedriver.exe");
		  try {
			  driver= new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities); 
			  driver.get("https://www.kotakcherry.com/"); 
		  } catch(MalformedURLException e) 
		  { // TODO Auto-generated catch block
		  e.printStackTrace(); 
		  }
		 
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
			

    public static void initializeWebdriver()
    {
    	   
    	String propFile = "config.properties";
		Properties propertyFile = JavaUtils.getPropertyFile(propFile);
		System.setProperty("webdriver.chrome.driver", ".\\testdata\\chromedriver.exe");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("marionette", false);
		driver = new ChromeDriver();
		System.out.println("URL = "+propertyFile.getProperty("mktp_URL"));
		//driver.get(propertyFile.getProperty("mktp_URL"));
		driver.get("https://www.kotakcherry.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    
	
	@AfterTest
	  public static void afterTest() throws InterruptedException {
	  
	  InitialSetUp.wd.quit(); }
	  
	  public static void adminafterTest() throws InterruptedException {
	  
	  InitialSetUp.wd.resetApp(); }
	 

}
