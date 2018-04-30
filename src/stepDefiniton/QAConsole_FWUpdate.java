/*package stepDefiniton;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

import automationframeworkdesktop.DAAutomationTestCaseVerification;
import automationframeworkdesktop.DesktopApplicationAutomationTestCase;
import automationframeworkdesktop.DesktopApplicationConfiguration;
import automationframeworkdesktop.DesktopApplicationDriverSetup;
import commonautomationframework.ExcelLib;
import pageobjects.Qaconsole.QACPageLogin;
import pageobjects.Qaconsole.QACPageSettings;


public class QAConsole_FWUpdate extends DAAutomationTestCaseVerification {
	WiniumDriver driver;
	ExcelLib xl = new ExcelLib();
	gmailLogin glogin = new gmailLogin();
	QACPageLogin qacLogin = new QACPageLogin();
	QACPageSettings qacSettings = new QACPageSettings();
	QAConsole qaconsole = new QAConsole();
	FWUpdate fw = new FWUpdate();
	String xclPath = DesktopApplicationConfiguration.getValue("Excelfile");


	String path1 = xl.getXLcellValue("TestData", 5, 1, xclPath); // 1.17.7
	String serialNumber = xl.getXLcellValue("TestData", 1, 1, xclPath); 
	String path2 = xl.getXLcellValue("TestData", 6, 1, xclPath); // 1.18.7

	public boolean ispowerOff;
	WebElement RMS, serialNoElement, settings, power, saveEEPROM, gSignIn, OK, disconnectClient, closeIcon;
	
	

	public boolean powerOFF() throws IOException {

		try {
			
			driver = DesktopApplicationDriverSetup.setup(path1);
			Thread.sleep(5000); // waiting for app to get in focus
			Assert.assertTrue(!qacLogin.loginDisplayed());

			// Login to QAConsole
			qaconsole.qaConsoleLogin();

			// Check whether qaconsole is opened successfully or not
			if (!qacLogin.homeDisplayed()) {
				ispowerOff = false;
				//getScreenshot(driver, FOLDER_QACONSOLE);
				Assert.fail(" QAConsole login failed, please try again");
			}
			// Connect to serial number
			qaconsole.connectClient(driver, serialNumber);

			settings = qacSettings.selectSettings();
			settings.click();
			Thread.sleep(1000);
			//getScreenshot(driver, FOLDER_QACONSOLE);

			// Check machine is power off / On Step 4
			power = qacSettings.selectPower();
			power.click();

			qaconsole.disconnectClient();
			ispowerOff = true;
			System.out.println("qaConsole login passed from poweroff");

		} catch (Exception e) {
		}

		System.out.println("After qa 1.17 " + ispowerOff);
		return ispowerOff;
	}


	public void saveRotiFile() throws Exception {

		driver = DesktopApplicationDriverSetup.setup(path2);

		Thread.sleep(5000);
		System.out.println("inside QAConsole 1.18.7, value = " + fw.isFWUpdate);
		Assert.assertTrue(fw.isFWUpdate);
		Assert.assertTrue(!qacLogin.loginDisplayed());

		// Login to QAConsole
		qaconsole.qaConsoleLogin();

		// Check whether qaconsole is opened successfully or not
		if (!qacLogin.homeDisplayed()) {
			//getScreenshot(driver, FOLDER_QACONSOLE);
			Assert.fail(" QAConsole login failed, please try again");
		}

		qaconsole.connectClient(driver, serialNumber);

		settings = qacSettings.selectSettings();
		settings.click();
		Thread.sleep(1000);
		//getScreenshot(driver, FOLDER_QACONSOLE);

		// Power On machine / On Step 12
		power = qacSettings.selectPower();
		power.click();

		// Save rotifile Step 13
		saveEEPROM = qacSettings.selectSaveEEPROM();
		saveEEPROM.click();

		// Checking wait dialog
		if (!qacSettings.saveEEPROMAlertDisplayed()) {
			System.out.println("\n Saving EEPROM file");
			//getScreenshot(driver, FOLDER_QACONSOLE);
			Thread.sleep(20000);
		} else
			System.out.println("\n Saving EEPROm file process not started");

		// Checking success/error dialog
		if (qacLogin.popupDisplayed()) {
			System.err.println("\n EEPROM transaction fail! (Timeout after 30s)");
			//getScreenshot(driver, FOLDER_QACONSOLE);
			qacLogin.selectOK().click();
			try {
				qaconsole.disconnectClient();
				Assert.fail(" EEPROM transaction fail! (Timeout after 30s)");
			} catch (Exception e) {
			}
		}

		// need to check EEPROM success condition

		// Check rotifile saved location here

		qaconsole.disconnectClient();

		driver.close();

	}

}*/