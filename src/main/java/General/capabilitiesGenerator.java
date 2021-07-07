package General;

import Config.configProperties;
import org.openqa.selenium.remote.DesiredCapabilities;

public class capabilitiesGenerator {

    public static DesiredCapabilities getCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", configProperties.platformName);
        capabilities.setCapability("platformVersion",configProperties.platformVersion);
        capabilities.setCapability("deviceName",configProperties.deviceName);
        capabilities.setCapability("automationName", configProperties.automationName);
        capabilities.setCapability("app", configProperties.appPath);
        capabilities.setCapability("appActivity", configProperties.appActivity);
        capabilities.setCapability("appPackage", configProperties.appPackage);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);

        return capabilities;
    }

}
