package automationframeworkdesktop;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.winium.WiniumDriver;

public class DesktopPageFactory extends PageFactory {

	 public static void initElements(WiniumDriver driver, Object page) {
		   		   		final WiniumDriver driverRef = driver;
			    initElements(new DefaultElementLocatorFactory(driverRef), page);
		   
		  }
}
