package pageobjectsOld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class QAConsolePage extends pageobject.DesktopApplicationPage {
	private WebElement element;

	public QAConsolePage(WiniumDriver driver) {
		super(driver);
		System.out.println("in constructor");
		System.out.println(driver);
	}

	public boolean isLogin;
	public boolean isManual = false;
	public boolean isPopup = false;
	public boolean isSaveEEPROM = false;

/*	public QAConsolePage() {
		super(driver);
		System.out.println(driver + " 2");
	}*/

	protected boolean isSecured() {
		return true;
	}
	

	public boolean loginDisplayed() throws Exception {
		try {
			System.out.println("its in loginDisplayed");
			System.out.println(driver);
			Thread.sleep(7000);
			if (driver.findElementByName("Log in").isDisplayed())
				isLogin = true;

		} catch (Exception e) {

			System.out.println("Error in getting login screen");
		}
		return isLogin;
	}

	public WebElement selectGoogleSignIn() throws Exception {
		try {
			element = driver.findElementByXPath("//*[contains(@AutomationId,'pictureBoxGSignIn')]");

		} catch (Exception e) {

			System.out.println("Error in getting Google Sign In field");
		}
		return element;
	}

	public boolean popupDisplayed() throws Exception {
		try {
			if (driver.findElementsByName("OK").isEmpty())
				isPopup = true;

		} catch (Exception e) {

			System.out.println("Error in getting popup screen");
		}
		return isPopup;
	}

	public WebElement selectOK() throws Exception {
		try {
			element = driver.findElementByName("OK");

		} catch (Exception e) {

			System.out.println("Error in getting OK button");
		}
		return element;
	}

	public boolean homeDisplayed() throws Exception {
		try {
			if (driver.findElementsByName("Manual").isEmpty())
				isManual = true;

		} catch (Exception e) {

			System.out.println("Error in getting Manual tab");
		}
		return isManual;
	}

	public WebElement selectRMS() throws Exception {
		try {
			element = driver.findElement(By.name("RMS"));

		} catch (Exception e) {

			System.out.println("Error in getting RMS tab");
		}
		return element;
	}

	public WebElement selectSerialNumber() throws Exception {
		try {
			element = driver.findElementByXPath(
					"//*[contains(@ControlType,'ControlType.Edit') and contains(@Name,'Rotimatic Serial: ')]");

		} catch (Exception e) {

			System.out.println("Error in getting Serial Number field");
		}
		return element;
	}

	public WebElement selectStatus() throws Exception {
		try {
			element = driver.findElementByXPath(
					"//*[contains(@ControlType,'ControlType.Document') and contains(@Name,'Status: ')]");

		} catch (Exception e) {

			System.out.println("Error in getting Status field");
		}
		return element;
	}

	public WebElement selectSettings() throws Exception {
		try {
			element = driver.findElement(By.name("Settings"));

		} catch (Exception e) {

			System.out.println("Error in getting Settings tab");
		}
		return element;
	}

	public WebElement selectPower() throws Exception {
		try {
			element = driver.findElementByName("POWER");

		} catch (Exception e) {

			System.out.println("Error in getting Power field");
		}
		return element;
	}

	public WebElement selectSaveEEPROM() throws Exception {
		try {
			element = driver.findElementByName("Save EEPROM to File");

		} catch (Exception e) {

			System.out.println("Error in getting Save EEPROM to File button");
		}
		return element;
	}

	public boolean saveEEPROMAlertDisplayed() throws Exception {
		try {
			if (driver
					.findElementsByXPath(
							"//*[contains(@ControlType,'ControlType.Window') and contains(@Name,'modalForm')]")
					.isEmpty())
				isSaveEEPROM = true;

		} catch (Exception e) {

			System.out.println("Error in getting Manual tab");
		}
		return isSaveEEPROM;
	}

	public WebElement selectDisconnectClient() throws Exception {
		try {
			element = driver.findElement(By.name("Disconnect"));

		} catch (Exception e) {

			System.out.println("Error in getting Disconnect Client button");
		}
		return element;
	}

	public WebElement selectClose() throws Exception {
		try {
			element = driver.findElement(By.name("Close"));

		} catch (Exception e) {

			System.out.println("Error in getting Close icon");
		}
		return element;
	}

}
