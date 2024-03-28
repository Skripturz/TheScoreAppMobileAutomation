package org.appiumautomation.TheScoreApp;

import org.testng.Assert;

public class SearchTeam {

	public static void searchAndValidateTeam(String teamName) throws InterruptedException {
		
		BaseClassSteps.clickElement("searchPage", "closePopUp");
		BaseClassSteps.clickElement("searchPage", "searchBar", 5);
		BaseClassSteps.findElementByXpath("searchPage", "searchBarSetText", 2).sendKeys(teamName);
		BaseClassSteps.clickElement("searchPage", "teamsTab");
		BaseClassSteps.clickElement("searchPage", "selectArsenal");
		Assert.assertTrue(BaseClassSteps.findElementByXpath("searchPage", "arsenalPageLoaded", 5).isDisplayed());
		BaseClassSteps.clickElement("searchPage", "arsenalNewsSelection");
		BaseClassSteps.clickElement("searchPage", "backButton");
		Assert.assertTrue(BaseClassSteps.findElementByXpath("searchPage", "arsenalPageLoaded", 5).isDisplayed());

	}
}
