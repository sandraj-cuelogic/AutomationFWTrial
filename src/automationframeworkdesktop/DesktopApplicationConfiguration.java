package automationframeworkdesktop;
/**
 * @author Shubham Jain
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import automationframework.Configuration;

public class DesktopApplicationConfiguration 
{
    private Properties properties = new Properties();
    private static DesktopApplicationConfiguration globalConfiguration = null;
    // TODO: figure out how we can have a default config file for framework specified.
    //Here is the properties file path of which properties' need to be loaded
    private final static String DEFAULT_CONFIG_PATH = "src/configuration/desktopApplication.properties";

    protected DesktopApplicationConfiguration()
    {
        // Load default configuration from framework specific location.
        loadAllProperties(DEFAULT_CONFIG_PATH);
    }

    private void loadAllProperties(String configFilePath) 
    {
        properties = new Properties();
        try 
        {
            properties.load(new FileInputStream(configFilePath));
        }
        catch (IOException e) 
        {
            throw new RuntimeException("Could not read the properties file");
        }
    }

    public void setGlobalConfigurationFile(String configFile)
    {
        reloadAllProperties(configFile);
    }

    private void reloadAllProperties(String configFile)
    {
        loadAllProperties(configFile);
    }

    public static DesktopApplicationConfiguration globalConfiguration()
    {
        if (globalConfiguration == null)
        {
            globalConfiguration = new DesktopApplicationConfiguration();
        }
        return globalConfiguration;
    }

    private String readConfigurationProperty(String propertyName) 
    {
        String defaultValue = "";
        return properties.getProperty(propertyName, defaultValue);
    }

    public static String getConfigurationValueForProperty(String propertyName)
    {
        return DesktopApplicationConfiguration.globalConfiguration().readConfigurationProperty(propertyName);
    }
        
    public static String getValue(String variableName) {
    	
    	return DesktopApplicationConfiguration.getConfigurationValueForProperty(variableName);
	}
}
