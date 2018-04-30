package pageobjects.Qaconsole;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

import pageobject.DesktopApplicationPage;


public class QACPageRMS extends DesktopApplicationPage {
	public static WebElement element;
	
	public QACPageRMS() {
		super(driver);
	}

	
	protected boolean isSecured() {
		return true;
	}

	public WebElement selectRMS() throws Exception {
		try {
			element = driver.findElement(By.name("RMS"));

		} catch (Exception e) {

			Assert.fail("Error in getting RMS tab");
		}
		return element;
	}

	public WebElement selectSerialNumber() throws Exception {
		try {
			element = driver.findElementByXPath("//*[@AutomationId='textBoxRotiSerialNo']");

		} catch (Exception e) {

			Assert.fail("Error in getting Serial Number field");
		}
		return element;
	}
	
	public WebElement selectStatus() throws Exception {
		try {
			element = driver.findElementByXPath("//*[@AutomationId='textBoxBrokerConnStatus']");

		} catch (Exception e) {

			Assert.fail("Error in getting Status field");
		}
		return element;
	}
	
	public WebElement selectDisconnectClient() throws Exception {
		try {
			element = driver.findElement(By.name("Disconnect"));

		} catch (Exception e) {

			Assert.fail("Error in getting Disconnect Client button");
		}
		return element;
	}


}
