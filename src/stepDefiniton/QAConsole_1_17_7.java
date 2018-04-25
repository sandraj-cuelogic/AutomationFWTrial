package stepDefiniton;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;


import commonautomationframework.ExcelLib;
import commonautomationframework.ScreenshotAndTestNgReporterListener;
import cucumber.api.java.en.Given;
import pageobjects.DesktopApplicationPage;
import pageobjects.QAConsolePage;
import automationframework.AutomationFramework;
import automationframeworkdesktop.DAAutomationTestCaseVerification;
import automationframeworkdesktop.DesktopApplicationConfiguration;
import automationframeworkdesktop.DesktopApplicationDriverSetup;
import automationframeworkdesktop.DesktopAutomationFramework;
import utilities.*;


public class QAConsole_1_17_7 extends DAAutomationTestCaseVerification {
	WiniumDriver driver;
	ExcelLib xl = new ExcelLib();
	gmailLogin glogin = new gmailLogin();
	QAConsolePage qaconsole = new QAConsolePage(DesktopApplicationPage.driver);
	String xclPath = DesktopApplicationConfiguration.getValue("Excelfile");
	String FOLDER_QACONSOLE = DesktopApplicationConfiguration.getValue("FOLDER_QACONSOLE");

	String path = xl.getXLcellValue("TestData", 5, 1, xclPath);
	String serialNumber = xl.getXLcellValue("TestData", 1, 1, xclPath);
	String status = "";
	String connectedStatus = "Rotimatic connected";
	String machineStatus = "";
	String notConnectedStatus = "Server connected";
	public boolean ispowerOff;

	WebElement RMS, serialNoElement, settings, power, gSignIn, OK, disconnectClient, closeIcon;
	
	/*public QAConsole_1_17_7() {
//		invoke(path);
	}
	*/
	@BeforeClass
	public void setup() throws Exception
	{
		DesktopApplicationDriverSetup.setup(path);
	}
	

	@Test(priority=1)
	@Given("^I am able to access the QAConsole$")
		public boolean powerOFF() throws IOException {

		try {
			Thread.sleep(5000); // waiting for app to get in focus
			assertTrue(!qaconsole.loginDisplayed(), "QAConsole login failed, please try again");

			// Login to QAConsole
			qaConsoleLogin();

			// Check whether qaconsole is opened successfully or not
			if (qaconsole.homeDisplayed()) {
				ispowerOff = false;
				ScreenshotAndTestNgReporterListener.customScreenshot();
//				getScreenshot(driver, FOLDER_QACONSOLE);
				Assert.fail(" QAConsole login failed, please try again");
			}
			// Connect to serial number
			connectClient();

			settings = qaconsole.selectSettings();
			settings.click();
			Thread.sleep(1000);
			ScreenshotAndTestNgReporterListener.customScreenshot();
//			getScreenshot(driver, FOLDER_QACONSOLE);

			// Check machine is power off / On Step 4
			power = qaconsole.selectPower();
			power.click();

			disconnectClient();
			ispowerOff = true;
			System.out.println("qaConsole login passed from poweroff");

		} catch (Exception e) {
		}

		System.out.println("After qa 1.17 " + ispowerOff);
		return ispowerOff;
	}

	private void connectClient() throws Exception {

		// Clicking on RMS tab and connecting to machine
		RMS = qaconsole.selectRMS();
		RMS.click();

		serialNoElement = qaconsole.selectSerialNumber();
		serialNoElement.clear();
		serialNoElement.sendKeys(serialNumber);

		driver.findElement(By.name("Connect")).click();
		Thread.sleep(3000);

		// Check status
		status = qaconsole.selectStatus().getText();
		ScreenshotAndTestNgReporterListener.customScreenshot();
//		getScreenshot(driver, FOLDER_QACONSOLE);

		// Check machine is connected to Internet or not
		if (status.contains(notConnectedStatus)) {
			ScreenshotAndTestNgReporterListener.customScreenshot();
//			getScreenshot(driver, FOLDER_QACONSOLE);
			System.err.println("\n Machine is not connected to internet");
			disconnectClient();
			try {
				Assert.fail("\n Machine is not connected to internet");

			} catch (Exception e) {
			}
		}

		if (status.contains(connectedStatus))
			System.out.println("Status is :- " + status);

	}

	private void qaConsoleLogin() throws Exception {
		String windowsHandle = driver.getWindowHandle();

		glogin.webDriverSetup();
		gSignIn = qaconsole.selectGoogleSignIn();
		gSignIn.click();
		Thread.sleep(5000);

		if (!qaconsole.popupDisplayed()) {
			System.out.println("\n User is already logged in");

			OK = qaconsole.selectOK();
			OK.click();

			System.out.println("OK button to continue login clicked on");
		} else if (qaconsole.homeDisplayed()) {
			System.out.println("User is logged in to the QA Console login system");
		} else {
			System.out.println("popup to confirm login with OK button did not show");
			System.out.println(glogin.wb.setUpTrue);

			if (glogin.wb.setUpTrue) {
				System.out.println("Navigated to the QAConsole1.17.7");
				Thread.sleep(5000);
				System.out.println("it came here");
				System.out.println(glogin.wb.windowsId);
				glogin.isGmailLoggedIn(glogin.wb.windowsId);
				System.out.println("gmail log in setup done");
			} else {
				System.out.println("gmail log in setup failed"); // It can be case where user is already logged in to
																	// gmail.
			}
		}
		Thread.sleep(2000);
	}

	private void disconnectClient() throws Exception {

		// Go to RMS and click on disconnect
		RMS.click();
		Thread.sleep(1000);

		disconnectClient = qaconsole.selectDisconnectClient();
		disconnectClient.click();

		closeIcon = qaconsole.selectClose();
		closeIcon.click();

	}
}