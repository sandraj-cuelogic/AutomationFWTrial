package pageobjects.Qaconsole;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

import pageobject.DesktopApplicationPage;


public class QACPageLogin extends DesktopApplicationPage {

	public static WebElement element;
	public boolean isLogin = false;
	public boolean isManual = true;
	public boolean isPopup = true;
	
	public QACPageLogin() {
		super(driver);
	}

	
	protected boolean isSecured() {
		return true;
	}

	

	public boolean loginDisplayed() throws Exception {
		try {
			if (driver.findElementsByName("Log in").isEmpty())
				isLogin = true;

		} catch (Exception e) {

			Assert.fail("Error in getting login screen");
		}
		return isLogin;
	}

	public WebElement selectGoogleSignIn() throws Exception {
		try {
			element = driver.findElementByXPath("//*[contains(@AutomationId,'pictureBoxGSignIn')]");

		} catch (Exception e) {

			Assert.fail("Error in getting Google Sign In field");
		}
		return element;
	}

	public boolean popupDisplayed() throws Exception {
		try {
			if (driver.findElementsByName("OK").isEmpty())
				isPopup = false;

		} catch (Exception e) {

			Assert.fail("Error in getting popup screen");
		}
		return isPopup;
	}

	public WebElement selectOK() throws Exception {
		try {
			element = driver.findElementByName("OK");

		} catch (Exception e) {

			Assert.fail("Error in getting OK button");
		}
		return element;
	}

	public boolean homeDisplayed() throws Exception {
		try {
			if (driver.findElementsByName("Manual").isEmpty())
				isManual = false;

		} catch (Exception e) {

			Assert.fail("Error in getting Manual tab");
		}
		return isManual;
	}

	
	public WebElement selectClose() throws Exception {
		try {
			element = driver.findElement(By.name("Close"));

		} catch (Exception e) {

			Assert.fail("Error in getting Close icon");
		}
		return element;
	}

}
