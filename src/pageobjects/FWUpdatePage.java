package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;


public class FWUpdatePage extends DesktopApplicationPage {
	public static WebElement element;
	public boolean isPopup = true;
	public boolean isError = true;
	public boolean isContinue = true;
	
	public FWUpdatePage(WiniumDriver driver) {
		super(driver);
	}

	
	protected boolean isSecured() {
		return true;
	}

	public boolean popupDisplayed() throws Exception {
		try {
			if (driver.findElementsByName("OK").isEmpty())
				isPopup = false;

		} catch (Exception e) {

			System.out.println("Error in getting login screen");
		}
		return isPopup;
	}

	public boolean errorDisplayed() throws Exception {
		try {
			if (driver
					.findElementsByXPath("//*[contains(@ControlType,'ControlType.Button') and contains(@Name,'Quit')]")
					.isEmpty())
				isError = false;

		} catch (Exception e) {

			System.out.println("Error in getting Quit Alert screen");
		}
		return isError;
	}

	public boolean continueAlertDisplayed() throws Exception {
		try {
			if (driver.findElementsByName("Continue").isEmpty())
				isContinue = false;

		} catch (Exception e) {

			System.out.println("Error in getting Quit Alert screen");
		}
		return isContinue;
	}

	public WebElement getSportsMode() throws Exception {
		try {
			element = driver.findElement(By.name("Sports Mode"));

		} catch (Exception e) {

			System.out.println("Error in getting Sports Mode field");
		}
		return element;
	}

	public WebElement selectSerialNumber() throws Exception {
		try {
			element = driver
					.findElementByXPath("//*[contains(@ControlType,'ControlType.Edit') and contains(@Name,'Broker:')]");

		} catch (Exception e) {

			System.out.println("Error in getting Serial Number field");
		}
		return element;
	}

	public WebElement getConnect() throws Exception {
		try {
			element = driver.findElement(By.name("Connect"));

		} catch (Exception e) {

			System.out.println("Error in getting Connect button");
		}
		return element;
	}

	public WebElement selectStatus() throws Exception {
		try {
			element = driver.findElementByXPath(
					"//*[contains(@ControlType,'ControlType.Document') and contains(@Name,'Status:')]");

		} catch (Exception e) {

			System.out.println("Error in getting Status");
		}
		return element;
	}

	public WebElement selectFWVersion() throws Exception {
		try {
			element = driver.findElementByName("FW version");

		} catch (Exception e) {

			System.out.println("Error in getting FW version button");
		}
		return element;
	}

	public WebElement selectStartFWUpdate() throws Exception {
		try {
			element = driver.findElementByName("Start Update");

		} catch (Exception e) {

			System.out.println("Error in getting Start Update button");
		}
		return element;
	}

	public WebElement selectContinue() throws Exception {
		try {
			element = driver.findElementByName("Continue");

		} catch (Exception e) {

			System.out.println("Error in getting Continue button");
		}
		return element;
	}

	public WebElement getClearLogElement() throws Exception {
		try {
			element = driver.findElementByXPath("//*[contains(@AutomationId,'textBoxMqttLog')]");

		} catch (Exception e) {

			System.out.println("Error in getting Clear Log field");
		}
		return element;
	}

	public WebElement selectOK() throws Exception {
		try {
			element = driver.findElement(By.name("OK"));

		} catch (Exception e) {

			System.out.println("Error in getting OK button");
		}
		return element;
	}

	public WebElement selectDisconnect() throws Exception {
		try {
			element = driver.findElementByName("Disconnect");

		} catch (Exception e) {

			System.out.println("Error in getting Disconnect button");
		}
		return element;
	}

	public WebElement selectQuit() throws Exception {
		try {
			element = driver
					.findElementByXPath("//*[contains(@ControlType,'ControlType.Button') and contains(@Name,'Quit')]");

		} catch (Exception e) {

			System.out.println("Error in getting Quit button");
		}
		return element;
	}

	public WebElement selectClose() throws Exception {
		try {
			element = driver
					.findElementByXPath("//*[contains(@ControlType,'ControlType.Button') and contains(@Name,'Close')]");

		} catch (Exception e) {

			System.out.println("Error in getting Close icon");
		}
		return element;
	}

}
