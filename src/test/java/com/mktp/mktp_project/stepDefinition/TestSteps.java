package com.mktp.mktp_project.stepDefinition;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import com.mktp.mktp_project.page.objects.Login_Screen;
import com.mktp.mktp_project.prerequisites.InitialSetUp;
import com.mktp.mktp_project.utilities.FunctionLibrary;

import cucumber.api.java.en.Given;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.ExamplesTableRow;

public class TestSteps extends InitialSetUp {

	static String propFile = "config.properties";
	static Properties propertyFile = FunctionLibrary.getPropertyFile(propFile);
	static Dimension size; 
	public static String MSg;

	

	@Given("^user launch login web page$")
	public void user_launch_login_web_page() throws Throwable {
		//InitialSetUp.initializeWebdriver();
		InitialSetUp.initializationAppium();
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Sign in to your account')]")));
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user click register button$")
	public void user_click_register_button() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		Thread.sleep(5000);
		Login_Screen.register().isDisplayed();
		Thread.sleep(1000);
		Login_Screen.register().click();
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user accept point$")
	public void user_accept_point() throws Throwable {
		Login_Screen.Accept().click();
		//LoginLibrary.AdminLogin();
	}
	@Given("^user verify signup page$")
	public void user_verify_signup_page () throws Throwable {
		Login_Screen.SignupTitle().click();
		//LoginLibrary.AdminLogin();
	}
	@Given("^user enter invalid mobile number \"([^\"]*)\"$")
	public void user_enter_invalid_mobile_number(String mobilenumber) throws Throwable {
		Login_Screen.MobileNumber().click();
		Login_Screen.MobileNumber().sendKeys(mobilenumber);
		//LoginLibrary.AdminLogin();
	}
	@Given("^user enter invalid email id \"([^\"]*)\"$")
	public void user_enter_invalid_email_id(String emailId) throws Throwable {
		Thread.sleep(1000);
		Login_Screen.Email().click();
		Login_Screen.Email().sendKeys(emailId);
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user enter invalid PAN number \"([^\"]*)\"$")
	public void user_enter_invalid_PAN_number(String panNumber) throws Throwable {
		Login_Screen.PanCard().click();
		Login_Screen.PanCard().sendKeys(panNumber);
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user \"([^\"]*)\" set birthdate$")
	public void user_set_birthdate(String srno) throws Throwable {
		Login_Screen.SetBirthdate().click();
		Thread.sleep(1000);
		Login_Screen.SetPriviousMonths().click();
		Thread.sleep(1000);
		if(srno.equalsIgnoreCase("1"))
		{
			Login_Screen.SetDate1().click();
		}
		else if(srno.equalsIgnoreCase("2"))
		{
			Login_Screen.SetDate2().click();

		}else if(srno.equalsIgnoreCase("3"))
		{
			Login_Screen.SetDate3().click();
		}
		else
		{
			Login_Screen.SetDate4().click();
		}
		
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user tick the checkbox of tnc and privacy policy$")
	public void user_tick_the_checkbox_of_tnc_and_privacy_policy() throws Throwable {
		//InitialSetUp.driver.
	    // driver.scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(1000);
		Login_Screen.TickCheckbox().click();
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user tap on Next button$")
	public void user_tap_on_Next_button() throws Throwable {
		Login_Screen.Next().click();
		//LoginLibrary.AdminLogin();
	}

	@Given("^user verify validation error$")
	public void user_verify_validation_error() throws Throwable {
		Login_Screen.MobileValidationMsg().isDisplayed();
		Login_Screen.EmailValidationMsg().isDisplayed();
		Login_Screen.PANValidationMsg().isDisplayed();
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user verify sign in page$")
	public void user_verify_sign_in_page() throws Throwable {
		String text=Login_Screen.SigninPageTitle().getText();
		Assert.assertEquals(text, "Sign in to your account","Sign in title displayed correctly");
	}
	
	@Given("^user enter invalid email id \"([^\"]*)\" on sign in form$")
	public void user_enter_invalid_email_id_on_sign_in_form(String emailId) throws Throwable {
		Thread.sleep(1000);
		Login_Screen.SigninEmail().click();
		Login_Screen.SigninEmail().sendKeys(emailId);
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user enter password \"([^\"]*)\"$")
	public void user_enter_password(String emailId) throws Throwable {
		Thread.sleep(1000);
		Login_Screen.password().click();
		Login_Screen.password().sendKeys(emailId);
		//LoginLibrary.AdminLogin();
	}
	
	@Given("^user click on sign in button$")
	public void user_enter_password() throws Throwable {
		Thread.sleep(1000);
		Login_Screen.SigninButton().click();
	}
	
	@Given("^user verify sign in validation error$")
	public void user_verify_sign_in_validation_error() throws Throwable {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)", "");
		Login_Screen.SigninValidationError().isDisplayed();
		System.out.println(Login_Screen.SigninValidationError().getText());
		
		//Login_Screen.SigninValidationforAttemp().isDisplayed();
	}
	
	
	
	
	
	
}




