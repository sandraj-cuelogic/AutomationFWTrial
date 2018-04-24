package automationframeworkdesktop;

public class DesktopAutomationFramework 
{
    public static void initWithGlobalConfiguration(String globalConfigureationFileWithPath)
    {
        DesktopApplicationConfiguration.globalConfiguration().setGlobalConfigurationFile(globalConfigureationFileWithPath);
    }

}
