package org.appiumautomation.TheScoreApp;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MobileAppLogin {
	@BeforeTest
	public static void setMobileCapabilities() throws MalformedURLException {

		BaseClassSteps.initiateDriverProperties();

	}

	@Test
	public static void lauchApp() throws MalformedURLException, InterruptedException {

		LoginPage.login();
		
		SearchTeam.searchAndValidateTeam("Arsenal");

	}

	@AfterTest
	public static void teardownSteps() {

		BaseClassSteps.exitApplication();

	}

}
