package org.appiumautomation.TheScoreApp;

import java.net.MalformedURLException;

public class LoginPage {

	public static void login() throws MalformedURLException, InterruptedException {

		BaseClassSteps.clickElement("loginPage", "dontAllowNotification", 5);
		BaseClassSteps.clickElement("loginPage", "getstartedButton");
		BaseClassSteps.clickElement("loginPage", "continueButton");
		BaseClassSteps.clickElement("loginPage", "maybeLaterButton");
		BaseClassSteps.clickElement("loginPage", "chooseFavoriteTeam");
		BaseClassSteps.clickElement("loginPage", "continueInTeamSelection");
		BaseClassSteps.clickElement("loginPage", "doneButton");

	}
}
