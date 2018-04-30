package test.java.Runner;
import org.junit.runner.RunWith;

//import automationframeworkdesktop.DAAutomationLog;
import automationframeworkdesktop.DesktopApplicationDriverSetup;
import cucumber.api.CucumberOptions;
import pageobjectsOld.DesktopApplicationPage;
 
//@RunWith(Cucumber.class)
@ExtendedCucumberOptions(
		jsonReport = "target/cucumber.json",
		retryCount = 3,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		toPDF = true,
		outputFolder = "target"
		)
@CucumberOptions(
		features = "Feature"
		,glue={"stepDefiniton"}
		,plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json","junit:target/cucumber.xml"}
//		,tags= {"@fwupdate"}  // Run tests in groups
//		,monochrome = false
//		,dryRun = true
		)
 
@RunWith(ExtendedCucumberRunner.class)
public class TestRunner {
    @BeforeSuite
    public static void setUp() {
//    	DAAutomationLog.info("In Before Suite");
    }
    @AfterSuite
    public static void tearDown() {
        System.out.println("In After Suite");
        DesktopApplicationDriverSetup.clearBrowserContext(DesktopApplicationPage.driver);
//        DAAutomationLog.info("Quiting Webdriver Instances");
   }     
}

/*public class TestRunner extends AbstractTestNGCucumberTests {
   

	private TestNGCucumberRunner testNGCucumberRunner;
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}*/


