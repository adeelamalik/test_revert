package General;

import Config.configProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Config.configProperties.appPackage;
import static Config.configProperties.platformName;


public class webDriverFactory {
    public static AppiumDriver driver;

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }

    public static AppiumDriver startDriver() throws IOException {
        switch (platformName)
        {
            case "Android":
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesGenerator.getCapabilities());
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                break;

            case "iOS":
                driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesGenerator.getCapabilities());
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static String getDevice()
    {
        webDriverWaits.sleep250();
        return configProperties.platformName;
    }


    public static void finishDriver() throws IOException {
        if (driver != null)
        {
            webDriverWaits.sleep1000();
            driver.quit();
            driver = null;
        }
    }
}
