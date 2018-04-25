package test.java.Runner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationframework.AppDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import pageobjects.Page;
 
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
		,glue={"stepDefinition"}
		,plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json","junit:target/cucumber.xml"}
//		,tags= {"@smoke"}  // Run tests in groups
//		,monochrome = false
//		,dryRun = true
		)
 
/*//@RunWith(ExtendedCucumberRunner.class)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public static void setUp() {
    	AutomationLog.info("In Before Suite");
    }
    @AfterSuite
    public static void tearDown() {
        System.out.println("In After Suite");
        AppDriver.clearBrowserContext(Page.driver);
        AutomationLog.info("Quiting Webdriver Instances");
   }     
}*/

public class TestRunner extends AbstractTestNGCucumberTests {
   

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
}


