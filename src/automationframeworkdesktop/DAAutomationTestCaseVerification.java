package automationframeworkdesktop;

import java.util.Collection;



//import mailReport.MyReporterListener;
//import mailReport.SendMailClass;

public abstract class DAAutomationTestCaseVerification extends DesktopApplicationAutomationTestCase
{
    public DAAutomationTestCaseVerification()
    {
        super();
    }
    
    protected DAAutomationTestCaseVerification(String executingTestCase)
    {
        super(executingTestCase);
    }

    public void invoke()
    {
        super.invoke();
    }
        
    public void setup(String path) throws Exception
    {
        super.setup(path);
    }

/*    public void Consetup()
    {
        super.consetup();
    }*/
    
    public void cleanup()
    {
        super.cleanup();
    }

    public Boolean compareTwoCollections(Collection<String> collection1, Collection<String> collection2)
    {
        if(collection1.size() == collection2.size())
        {
            if(collection1.containsAll(collection2) && collection2.containsAll(collection1))
            return true;
        }
        return false;
    }
  
 /*   protected abstract void verifyTestCases() throws Exception;
    protected abstract String successMessage();
    protected abstract String failureMessage();
    protected abstract String successMessage();
    protected abstract String failureMessage();
*/
    public void Execute(String path) throws Exception
    {
        try
        {
            setup(path);
        //    verifyTestCases();
         //   testcasePassed(successMessage());
        }
        catch(Exception e)
        {
            handleTestCaseFailure(e.getMessage());
        }
        catch(Throwable throwable)
        {
            handleTestCaseFailure(throwable.getMessage());
        }
        finally
        {
            cleanup();
        }
    }
    
/*    public void ConExecute() throws Exception
    {
        try
        {
        	Consetup();
           // verifyTestCases();
           // testcasePassed(successMessage());
        }
        catch(Exception e)
        {
            handleTestCaseFailure(e.getMessage());
        }
        catch(Throwable throwable)
        {
            handleTestCaseFailure(throwable.getMessage());
        }
        finally
        {
           // cleanup();
        }
    }*/

    private void handleTestCaseFailure(String message) throws Exception
    {
        //DAAutomationLog.error(message);
 //       System.out.println("Faliure message = " +failureMessage());
        testcaseFailed(message);
//        SendMailClass email = new SendMailClass();
//        email.execute("Logs.txt");
//        AppDriver.killChromePhantomInstance(Page.driver);
        throw (new Exception(message));
    }
}
