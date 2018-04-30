package pageobjectsOld;
/**
 * @author Shubham Jain
 * */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;
import automationframeworkdesktop.DesktopPageFactory;


public class DesktopApplicationPage 
{
    public static WiniumDriver driver;

    public DesktopApplicationPage(WiniumDriver driver)
    {
    	System.out.println(driver+ "+ from pageObjectsOld");
        DesktopApplicationPage.driver = driver;
        System.out.println(driver);
//    	DesktopApplicationPage.driver = DesktopApplicationDriverSetup.setup(path);
    	DesktopPageFactory.initElements(driver, this);
		System.out.println(driver);
    }
    
 
    protected boolean isSecured()
    {
        return false;
    }

/*    public static Header header()
    {
        return PageFactory.initElements(driver, Header.class);
    }
    public static Footer footer() 
    {
        return PageFactory.initElements(driver, Footer.class);
    }
    public static ContentPagesLeftMenu contentPagesLeftMenu()
    {
        return PageFactory.initElements(driver, ContentPagesLeftMenu.class);
    }*/

   

    public String currentPageTitle() throws Exception
    {
        return driver.getTitle();
    }

    protected String getTextfromElement(WebElement element) throws Exception
    {
        return element.getText();
    }

/*    public static SubNavigation subNavigation()
    {
        return PageFactory.initElements(driver, SubNavigation.class);
    }*/

    public String pageHeading() throws Exception
    {
        // TODO: To throw Expection for pages that do not have Page Headings 
        return "";
    }
}