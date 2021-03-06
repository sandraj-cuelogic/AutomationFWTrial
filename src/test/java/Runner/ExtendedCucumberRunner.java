package test.java.Runner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

//import automationframeworkdesktop.//DAAutomationLog;
import cucumber.api.junit.Cucumber;

public class ExtendedCucumberRunner extends Runner {

    private Class clazz;
    private Cucumber cucumber;

    public ExtendedCucumberRunner(Class clazzValue) throws Exception {
        clazz = clazzValue;
        cucumber = new Cucumber(clazzValue);
    }

    @Override
    public Description getDescription() {
        return cucumber.getDescription();
    }

    private void runPredefinedMethods(Class annotation) throws Exception {
        if (!annotation.isAnnotation()) {
            return;
        }
        Method[] methodList = this.clazz.getMethods();
        for (Method method : methodList) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation item : annotations) {
                if (item.annotationType().equals(annotation)) {
                    method.invoke(null);
                    break;
                }
            }
        }
    }

    @Override
    public void run(RunNotifier notifier) {
        try {
            runPredefinedMethods(BeforeSuite.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cucumber.run(notifier);
        try {
            runPredefinedMethods(AfterSuite.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   // @Override
    public void testFailure(Failure failure){
     //   super.testFailure(failure);
        if (!failure.getDescription().isSuite()) {
//        	ScreenshotAndTestNgReporterListener.customScreenshot();
        	//DAAutomationLog.error("In Custom Failer Class of Junit");
            System.out.println("FAILED!!!!!"); //Here pass your screenshot capture event
        }
//    	ScreenshotAndTestNgReporterListener.customScreenshot();
    	//DAAutomationLog.error("In Custom Failer Class of Junit");
        System.out.println("FAILED!!!!!"); //Here pass your screenshot capture event
    }
    
}