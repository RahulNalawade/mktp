package com.mktp.mktp_project.testRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.Parameters;

import cucumber.junit.Cucumber;
import com.mktp.mktp_project.prerequisites.GlobalVariables;

@RunWith(Cucumber.class)
@Cucumber.Options(
		
		
        format={"pretty", "html:target/cucumber"},
        features="mktp_project/src/test/java/com/resources/User_registration_web_validation.feature"
        )
public class AndroidWebRunner {

	@Parameters({"URL_","deviceName_","platformVersion_"})
    @org.testng.annotations.BeforeClass(alwaysRun = true)
    public void setUpClass(String URL_,String deviceName_,String platformVersion_) throws Exception {
		
		GlobalVariables.appiumURL=URL_;
		GlobalVariables.deviceName=deviceName_;
		GlobalVariables.platformVersion=platformVersion_;
	}
}