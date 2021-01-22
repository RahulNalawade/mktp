package com.mktp.mktp_project.testRunner;
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		
		
        format={"pretty", "html:target/cucumber"},
        features="mktp_project/src/test/java/com/resources/User_registration_web_validation.feature"
        )
public class WebRunner {

	
}