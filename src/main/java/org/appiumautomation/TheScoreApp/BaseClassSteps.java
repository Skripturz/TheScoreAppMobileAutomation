package org.appiumautomation.TheScoreApp;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClassSteps {
	public static AndroidDriver aDriver;

	public static String property(String files, String Global) {
		Properties pro = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\Locators\\Locators.properties");
			pro.load(file);
			String browserurl = pro.getProperty(files);
			FileInputStream Locator = new FileInputStream(System.getProperty("user.dir") + browserurl);
			pro.load(Locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String variable = pro.getProperty(Global);
		return variable;
	}

	public static AndroidDriver initiateDriverProperties() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel8");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.TIMEOUTS, 60);
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "\\src\\test\\resources\\ScoreApp.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		aDriver = new AndroidDriver(url, cap);
		return aDriver;
	}

	public static WebElement findElementByXpath(String pageName, String elementName, int timeout)
			throws InterruptedException {
		waitTillClickable(timeout);
		WebElement element = aDriver.findElement(AppiumBy.xpath(property(pageName, elementName)));
		return element;
	}

	public static void clickElement(String pageName, String elementName, int timeout) throws InterruptedException {
		findElementByXpath(pageName, elementName, timeout).click();
	}

	public static void clickElement(String pageName, String elementName) throws InterruptedException {
		findElementByXpath(pageName, elementName, 2).click();
	}

	public static void waitTillClickable(int timeout) throws InterruptedException {
		Thread.sleep(timeout * 1000);
	}

	public static void exitApplication() {
		aDriver.quit();
	}
}
