package pageobjects.Qaconsole;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

import pageobject.DesktopApplicationPage;

public class QACPageSettings extends DesktopApplicationPage {
	public static WebElement element;
	public boolean isSaveEEPROM = false;
	
	public QACPageSettings() {
		super(driver);
	}

	
	protected boolean isSecured() {
		return true;
	}

	public WebElement selectSettings() throws Exception {
		try {
			element = driver.findElement(By.name("Settings"));

		} catch (Exception e) {

			Assert.fail("Error in getting Settings tab");
		}
		return element;
	}

	public WebElement selectPower() throws Exception {
		try {
			element = driver.findElementByName("POWER");

		} catch (Exception e) {

			Assert.fail("Error in getting Power field");
		}
		return element;
	}

	public WebElement selectSaveEEPROM() throws Exception {
		try {
			element = driver.findElementByXPath("//*[@AutomationId='btn_SavEepToFile']");

		} catch (Exception e) {

			Assert.fail("Error in getting Save EEPROM to File button");
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

			Assert.fail("Error in getting Save EEPROM popup");
		}
		return isSaveEEPROM;
	}
}
