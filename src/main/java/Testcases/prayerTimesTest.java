package Testcases;

import General.MainCall;
import General.baseTest;
import General.envGlobals;
import General.webDriverFactory;
import PageObject.Android.appSettingsView;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;

import static Config.configProperties.appPackageValue;


public class prayerTimesTest extends baseTest
{
    public String selectNewYorkCity = "New York, United States";

    @Test(description = "C41390",priority = 1)
    public void matchingPrayerTimesForNewYork()
    {
        if (webDriverFactory.getDevice().equals("iOS"))
        {
            MainCall.commonLocatorsIOS.goToScreen("App Settings");
            MainCall.appSettings.changeLocationManually("New York",selectNewYorkCity);
            MainCall.appSettings.verifyLocationName("New York");
            MainCall.appSettings.verifyCalculationMethod("North America\nFajr 15.0 degrees, Isha 15.0 degrees");
            MainCall.commonLocatorsIOS.tapBackIcon();
            MainCall.commonLocatorsIOS.tapMoreScreenElement("Prayer Times");
            List<String> prayerTimesNY = MainCall.prayerTimes.getAllPrayerTime();
            Collections.sort(prayerTimesNY);
            MainCall.prayerTimes.verifyPrayerTimes(prayerTimesNY,envGlobals.iOSpreviousPrayerTimesNY);

        }

        else
            {
            MainCall.commonLocators.goToScreenFromHome("App\nsettings");
            MainCall.appSettingsView.changeLocationManually("New York");
            MainCall.appSettingsView.verifyLocationName("New York");
            MainCall.appSettingsView.verifyCalculationMethod("North America (ISNA)\nFajr 15°, Isha 15°");
            MainCall.commonLocators.backToHomeScreen();
            MainCall.prayerTimesView.tapSeePrayerTimesLink();
            List<String> prayerTimesNY = MainCall.prayerTimesView.getAllPrayerTime();
            Collections.sort(prayerTimesNY);
            MainCall.prayerTimesView.verifyPrayerTimes(prayerTimesNY,envGlobals.previousPrayerTimesNY);
        }
    }
}



