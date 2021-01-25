package com.mktp.mktp_project.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mktp.mktp_project.prerequisites.GlobalVariables;
import com.mktp.mktp_project.prerequisites.InitialSetUp;


public class Login_Screen extends InitialSetUp{
	
	public static WebElement element=null;
	
	public static WebElement Email()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.id("mat-input-3"));
		return element;
	}
	
	public static WebElement password()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.id("password"));
		return element;
	}
	
	public static WebElement register()
	{
		if(GlobalVariables.platform =="Android" || GlobalVariables.deviceName!=null)
		{
			element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-login/div/section/div/div/form/div[7]/div/div[2]/a/button"));
		}
		else
		{
			element =  (WebElement)InitialSetUp.driver.findElement(By.xpath("//*[contains(text(),'Register')]"));
		}
																		   
		return element;
	}
	
	public static WebElement Accept()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[contains(text(),'Accept')]"));
		//element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-consent/div/section/div/div/footer/div/div/div/button/span"));
		return element;
	}
	public static WebElement SignupTitle()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//h1[contains(text(),'Let’s get you on board')]"));
		return element;
	}
	
	public static WebElement MobileNumber()
	{
		
		element = (WebElement) InitialSetUp.driver.findElement(By.id("mat-input-2"));
		return element;
	}
	
	public static WebElement PanCard()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.id("mat-input-4"));
		return element;
	}
	
	public static WebElement SetBirthdate()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-registration/div[1]/section/div/div/form/div[6]/mat-form-field/div/div[1]/div[1]"));
		return element;
	}
	
	public static WebElement SetPriviousMonths()
	{
		
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[2]"));
		return element;
	}
	public static WebElement SetDate()
	{
		                                                                 
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[3]/div"));
		return element;
	}
	
	public static WebElement SetDate1()
	{
		                                                                 
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[2]/div"));
		return element;
	}
	
	public static WebElement SetDate2()
	{
		                                                                 
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[3]/div"));
		return element;
	}
	
	public static WebElement SetDate3()
	{
		                                                                 
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[4]/div"));
		return element;
	}
	
	public static WebElement SetDate4()
	{
		                                                                 
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[5]/div"));
		return element;
	}
	
	public static WebElement TickCheckbox()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-registration/div[1]/section/div/div/form/div[8]/div[1]/ul/li[1]/div/div[1]"));
		return element;
	}
	
	public static WebElement Next()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-registration/div[1]/section/div/div/footer/div/div/div/button/span"));
		return element;
	}
	
	public static WebElement MobileValidationMsg()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[contains(text(),'Please enter a valid mobile number')]"));
		return element;
	}
	
	public static WebElement EmailValidationMsg()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[contains(text(),'Please enter a valid Email Id')]"));
		return element;
	}
	
	public static WebElement PANValidationMsg()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[contains(text(),'Please enter a valid PAN')]"));
		return element;
	}
	
	public static WebElement SigninValidationError()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-login/div/section/div/div/form/div[6]/div/div/h2"));
		return element;
																		
	}
	
	public static WebElement SigninValidationforAttemp()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-login/div/section/div/div/form/div[6]/div/div/h2/span"));
		return element;
	}
	
	public static WebElement SigninEmailValidationError()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[@id=\"mat-error-1\"]"));
		return element;
	}
	
	public static WebElement SigninPageTitle()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-login/div/section/div/div/form/div[1]/h1"));
		return element;
	}
	
	public static WebElement SigninEmail()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
		return element;
	}
	
	public static WebElement SigninButton()
	{
		element = (WebElement) InitialSetUp.driver.findElement(By.xpath("/html/body/ieco-root/div/div[2]/ieco-main/div/div[2]/div[1]/ieco-login/div/section/div/div/footer/div/div/div/button/span"));
		return element;
	}
	
	
	
	
	
}
