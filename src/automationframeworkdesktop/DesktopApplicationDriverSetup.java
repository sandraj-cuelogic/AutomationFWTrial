package automationframeworkdesktop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import pageobjects.Page;



public class DesktopApplicationDriverSetup{
	static WiniumDriver driver;
 
	
	public static WiniumDriver setup(String path) throws Exception {
		try {
			DesktopOptions options = new DesktopOptions();
			options.setApplicationPath(path);

			String WiniumDriverPath = "src//dependencies//Winium.Desktop.Driver.exe";
			File drivePath = new File(WiniumDriverPath);
			WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath)
					.usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
			service.start();
			driver = new WiniumDriver(service, options);
		} catch (Exception e) {
			System.err.println("\n Driver setup failed");
		}
		return driver;

	}
	
	public static void clearBrowserContext(WiniumDriver driver) {
		try {
			if (Page.driver != null) {
				Page.driver.quit();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			Page.driver.quit();
		}
	}

	
}
