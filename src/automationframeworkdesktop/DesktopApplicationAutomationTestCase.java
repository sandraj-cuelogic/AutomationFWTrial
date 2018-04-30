package automationframeworkdesktop;

import java.util.HashMap;
import cucumber.api.java.Before;
import pageobject.DesktopApplicationPage;


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
    String path;

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
    
    
    public String getAppPath(String appPath) {
    	path = appPath;
    	return path;
    }
    
    @Before
	public void invoke() {
    try {
    	if(initializationType.equalsIgnoreCase("single")) {
    		System.out.println("Single initializationType found");
	     if (!initialized){
	    	 	System.out.println("initialized true");
	            initialized = true;
	            System.out.println("it came here");
	            System.out.println(path);
	              setup(path);   
	              
	              System.out.println("Setting up Single Instance Type invokation");
	            //DAAutomationLog.info("Setting up Single Instance Type invokation");
	        }
			else {
				System.out.println("Instance is already invoked");
				//DAAutomationLog.info("Instance is already invoked");
			}
	      }
    	else if(initializationType.equalsIgnoreCase("multiple")) {
    	 //   consetup();
 	          setup(path);    
 	          System.out.println("Setting up Multiple Instance Type invokation");
    		  //DAAutomationLog.info("Setting up Multiple Instance Type invokation");
    	}
    	else {
    		System.out.println("Wrong Instance Type invokation parameter. Please check the configurations");
    		//DAAutomationLog.error("Wrong Instance Type invokation parameter. Please check the configurations");
    	}
    }
    catch(Exception ex) {
    	//DAAutomationLog.error("Exception occured in setup");
    	System.out.println("Exception occured in setup");
    	//DAAutomationLog.error(ex.getMessage());
    	ex.printStackTrace();
    }
  } 
    
    public void setup(String path) throws Exception 
    {
    	System.out.println("its in setup "+path);
        //DAAutomationLog.startTestCase(executingTestCaseName);
        new DesktopApplicationPage(DesktopApplicationDriverSetup.setup(path));
       // populate test case data from csv
        testCaseData = DATestDataProvider.getTestData(executingTestCaseFileName);
    }
    
/*    public void consetup() 
    {
        //DAAutomationLog.startTestCase(executingTestCaseName);
		new Page(AppDriver.getDriver(Configuration.getConfigurationValueForProperty("browser")));
       // populate test case data from csv
        testCaseData = TestDataProvider.getTestData(executingTestCaseFileName);
    }*/
    
    
    
    
    public void cleanup()
    {

    //	Page.driver.quit();  // As per suggestion by shubham

        //DAAutomationLog.endTestCase(executingTestCaseName);
        
        if (testCaseData != null)
            testCaseData.clear();
        DesktopApplicationDriverSetup.clearBrowserContext(DesktopApplicationPage.driver);
    }

    public void testcasePassed(String customMessage) 
    {
        //DAAutomationLog.info(executingTestCaseName + " " + customMessage);
    }

    public void testcaseFailed(String customMessage) 
    {
       // //DAAutomationLog.info(executingTestCaseName + " " + customMessage);
    	//DAAutomationLog.info("Failed report to send = " + customMessage);
		//Quitting the driver and all pages
    	DesktopApplicationDriverSetup.clearBrowserContext(DesktopApplicationPage.driver);
    }    
}
