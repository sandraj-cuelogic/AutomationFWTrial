package automationframeworkdesktop;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import pageobject.DesktopApplicationPage;

public class DesktopApplicationDriverSetup {
	static WiniumDriver driver;

	public static WiniumDriver setup(String path) throws Exception {
		System.out.println("1");
		DesktopOptions options = new DesktopOptions();
		System.out.println("2 " +path);
		options.setApplicationPath(path);
		System.out.println("3");
		String WiniumDriverPath = "src//dependencies//Winium.Desktop.Driver.exe";
		System.out.println("4");
		File drivePath = new File(WiniumDriverPath);
		System.out.println("5");
		WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999)
				.withVerbose(true).withSilent(false).buildDesktopService();
		System.out.println("6");
		service.start();
		System.out.println("7");
		driver = new WiniumDriver(service, options);
		System.out.println("8");
		return driver;

	}

	public static void clearBrowserContext(WiniumDriver driver) {
		try {
			if (DesktopApplicationPage.driver != null) {
				DesktopApplicationPage.driver.quit();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			DesktopApplicationPage.driver.quit();
		}
	}

}
