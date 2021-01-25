package com.mktp.mktp_project.testRunner;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.mktp.mktp_project.prerequisites.GlobalVariables;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.junit.Cucumber;

 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/mktp/resources/User_registration_web_validation.feature"},
		glue={"teno.com.cucumber.stepDefinition"},
		format = {"pretty", "json:target/json/output.json", "html:target/html/"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		tags = {"@register"}
		
		)
 
public class AndroidWebRunner extends AbstractTestNGCucumberTests{
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTestInterruptedException testexception;
	private TestNGCucumberRunner testNGCucumberRunner;
	@Parameters({"URL_","deviceName_","platformVersion_"})
    @org.testng.annotations.BeforeClass(alwaysRun = true)
    public void setUpClass(String URL_,String deviceName_,String platformVersion_) throws Exception {
		
		GlobalVariables.appiumURL=URL_;
		GlobalVariables.deviceName=deviceName_;
		GlobalVariables.platformVersion=platformVersion_;
		System.out.println(URL_);
		System.out.println(deviceName_);
		System.out.println(platformVersion_);
		
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
	 @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
		 
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	 
}


