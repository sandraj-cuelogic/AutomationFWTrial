package automationframeworkdesktop;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import commonautomationframework.AutomationLog;
import commonautomationframework.TestDataProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageobjects.DesktopApplicationPage;
/*import pageobjects.Homepage;
import pageobjects.LoginPage;*/
import pageobjects.Page;

public class DesktopApplicationAutomationTestCase 
{
/*	Homepage homePage = Homepage.homePage();
	LoginPage loginPage = new LoginPage(Page.driver);*/
    protected HashMap<String, HashMap<String, String>> testCaseData;
    private static boolean initialized = false;
    private static boolean loginInitialized = false;
	String initializationType = DesktopApplicationConfiguration.getConfigurationValueForProperty("execution-type");

    private String executingTestCaseName = null;
    private String executingTestCaseFileName = null;

    public DesktopApplicationAutomationTestCase() 
    {
        this.executingTestCaseName = this.getClass().getSimpleName();
        this.executingTestCaseFileName = executingTestCaseName;
    }

    protected DesktopApplicationAutomationTestCase(String executingTestCaseName) 
    {
        this.executingTestCaseName = this.getClass().getSimpleName();
        this.executingTestCaseFileName = executingTestCaseName;
    }
    
    @Before
	public void invoke(String path) {
    try {
    	if(initializationType.equalsIgnoreCase("single")) {
	     if (!initialized){
	            initialized = true;
	              setup(path);   
	            AutomationLog.info("Setting up Single Instance Type invokation");
	        }
			else {
				AutomationLog.info("Instance is already invoked");
			}
	      }
    	else if(initializationType.equalsIgnoreCase("multiple")) {
    	 //   consetup();
 	          setup(path);    
    		  AutomationLog.info("Setting up Multiple Instance Type invokation");
    	}
    	else {
    		AutomationLog.error("Wrong Instance Type invokation parameter. Please check the configurations");
    	}
    }
    catch(Exception ex) {
    	AutomationLog.error("Exception occured in setup");
    	AutomationLog.error(ex.getMessage());
    	ex.printStackTrace();
    }
  } 
    
    public void setup(String path) throws Exception 
    {
        AutomationLog.startTestCase(executingTestCaseName);
        new Page(DesktopApplicationDriverSetup.setup(path));
       // populate test case data from csv
        testCaseData = TestDataProvider.getTestData(executingTestCaseFileName);
    }
    
/*    public void consetup() 
    {
        AutomationLog.startTestCase(executingTestCaseName);
		new Page(AppDriver.getDriver(Configuration.getConfigurationValueForProperty("browser")));
       // populate test case data from csv
        testCaseData = TestDataProvider.getTestData(executingTestCaseFileName);
    }*/
    
    
    
    
    public void cleanup()
    {

    //	Page.driver.quit();  // As per suggestion by shubham

        AutomationLog.endTestCase(executingTestCaseName);
        
        if (testCaseData != null)
            testCaseData.clear();
        DesktopApplicationDriverSetup.clearBrowserContext(DesktopApplicationPage.driver);
    }

    public void testcasePassed(String customMessage) 
    {
        AutomationLog.info(executingTestCaseName + " " + customMessage);
    }

    public void testcaseFailed(String customMessage) 
    {
       // AutomationLog.info(executingTestCaseName + " " + customMessage);
    	AutomationLog.info("Failed report to send = " + customMessage);
		//Quitting the driver and all pages
    	DesktopApplicationDriverSetup.clearBrowserContext(DesktopApplicationPage.driver);
    }    
}
