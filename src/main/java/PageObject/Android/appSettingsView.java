package PageObject.Android;

import General.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static Config.configProperties.appPackageValue;
import static General.MainCall.commonLocators;

public class appSettingsView extends baseTest {

    public appSettingsView()
    {}

    //Juristic Method Locators
    public static By byJuristicMethodDropdown  = By.id(appPackageValue + "lyt_juristic_method");
    public static By byHanafiMethod            = By.xpath("//android.widget.CheckedTextView[@text='Hanafi']");
    public static By byShafiMethod             = By.xpath("//android.widget.CheckedTextView[@text='Shafi/Maliki/Hanbali']");

    //Change Calculation Method Locators
    public static By byCalculationMethodField  = By.id(appPackageValue + "lyt_calculation_method");
    public static By byCalculationMethodText  = By.id(appPackageValue + "txt_calculation_method");
    public static By byCalculationMethods      = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.TextView[1]");

    //Change Location Locators
    public static By byAutoLocationToggle      = By.id(appPackageValue + "switch_auto_detect");
    public static By byLocationSearchManually  = By.id(appPackageValue + "lyt_search_manually");
    public static By bySearchCityField         = By.id(appPackageValue + "auto_txt_city_search");
    public static By bySelectSearchedCity      = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View[2]");
    public static By bySaveCity                = By.id(appPackageValue + "btn_loaction_lets_go");
    public static By byLocationTypeText        = By.id(appPackageValue + "txt_location_type");
    public static By byCurrentLocTypeText      = By.id(appPackageValue + "txt_current_location");
    public static By byDetectedLocText         = By.id(appPackageValue + "txt_detected_location");
    public static By byManualLocText           = By.id(appPackageValue + "txt_manual_location");
    public static By byCustomLocText           = By.id(appPackageValue + "txt_custom_location");
    public static By byHomeTown                = By.id(appPackageValue + "lyt_home_town");
    public static By byGetLocationText         = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[3]/android.widget.TextView[2]");

    //Adjust PrayerTimes Locators
    public static By byPrayerAdjustmentTab     = By.id(appPackageValue + "txt_prayer_time_adjustment");
    public static By byTimeList                = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView");
    public static By byTimeScroll                = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]");

    //Logout Locators

    public static By byProfileSection          = By.id(appPackageValue + "location_settings");
    public static By bySignOut          = By.id(appPackageValue + "txt_siginout");
    public static By byUpgradeMessage          = By.id(appPackageValue + "upgrade");


    //Hijri Adjustment Locators
    public static By byHijriAdjustmentField          = By.id(appPackageValue + "hijri_date_adjustment");
    public static By byHijriAdjustmentHeading         = By.id(appPackageValue + "alertTitle");
    public static By byHijriAdjustmentDays         = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView");




    //Juristic Method Functions Low level

    public void tapJuristicMethodDropdown()
    {
       WebElement juristicDropdwn = webDriverFactory.getDriver().findElement(byJuristicMethodDropdown);
       juristicDropdwn.click();
    }

    public void selectJuristicMethod()
    {
        MobileElement hanafiJuristicMethod = webDriverFactory.getDriver().findElement(byHanafiMethod);
        MobileElement shafiJuristicMethod = webDriverFactory.getDriver().findElement(byShafiMethod);

        if (hanafiJuristicMethod.getAttribute("checked").equals("true"))
        {
            shafiJuristicMethod.click();
        }

        else
            hanafiJuristicMethod.click();
    }

    //High level Juristic
    public void changeJuristicMethod()
    {
        basicFlows.scrollToElement("Juristic Method");
        tapJuristicMethodDropdown();
        selectJuristicMethod();
        commonLocators.tapDoneButton();
    }


    //Change Calculation Method Functions Low level
    public void tapCalculationMethodField()
    {
        webDriverFactory.getDriver().findElement(byCalculationMethodField).click();
    }

    public void selectCalculationMethod(String calculationMethod) {
        List<MobileElement> calculationMethods = webDriverFactory.getDriver().findElements(byCalculationMethods);
//        for (MobileElement calculateMethod:calculationMethods)
        for (int i = 0; i < calculationMethods.size() - 1; i++) {
            String text = calculationMethods.get(i).getText();
            if (text.equals(calculationMethod)) {
                if (!envGlobals.alreadyMethod.equals(text)) {
                    calculationMethods.get(i).click();
                    break;
                } else
                    System.out.println("Entered calculation Method already selected");
                System.out.println("Selecting method by default");
                if (i == calculationMethods.size() - 1) {
                    calculationMethods.get(0).click();
                }
                else {
                    i++;
                calculationMethods.get(i).click();
                }
            }
        }
    }

    public String getCalculationMethodText()
    {
        String calculationMethod = webDriverFactory.getDriver().findElement(byCalculationMethodText).getText();
        return calculationMethod;
    }

    public void verifyCalculationMethod(String method)
    {
        basicFlows.scrollUp(byHomeTown);
        String calculationMethod = getCalculationMethodText();
        Assert.assertEquals(calculationMethod,method,"Calculation method not changed to"+" "+ method);
    }

    //High level Calculation method
    public void changeCalculationMethod(String method)
    {
        basicFlows.scrollUp(byHomeTown);
        envGlobals.alreadyMethod = getCalculationMethodText().split("\n")[0];
        tapCalculationMethodField();
        selectCalculationMethod(method);
        commonLocators.tapBackIcon();
    }


    //Prayer Adjustment Functions
    public void tapPrayerAdjustment()
    {
        webDriverFactory.getDriver().findElement(byPrayerAdjustmentTab).click();
    }

    public void tapTimeDropdown(String  prayerName)
    {
        webDriverFactory.getDriver().findElementById(prayerName).click();
    }

    public void adjustPrayerTime(String time)
    {
//        tapTimeDropdown(prayerName);
        selectMinutesToAdjust(time);
        commonLocators.tapDoneButton();
    }


//    public void tapFajrTimeDropdwn()
//    {
//        webDriverFactory.getDriver().findElement(byPrayerTimeAdjustFajr).click();
//    }
//
//    public void tapDuhrTimeDropdwn()
//    {
//        webDriverFactory.getDriver().findElement(byPrayerTimeAdjustDhuhr).click();
//    }
//
//    public void tapAsrTimeDropdwn()
//    {
//        webDriverFactory.getDriver().findElement(byPrayerTimeAdjustAsr).click();
//    }
//
//    public void tapMagribTimeDropdwn()
//    {
//        webDriverFactory.getDriver().findElement(byPrayerTimeAdjustMagrib).click();
//    }
//
//    public void tapIshaTimeDropdwn()
//    {
//        webDriverFactory.getDriver().findElement(byPrayerTimeAdjustIsha).click();
//    }
//
//    public void tapQiyamTimeDropdwn()
//    {
//        webDriverFactory.getDriver().findElement(byPrayerTimeAdjustQiyam).click();
//    }

    public void selectMinutesToAdjust(String adjustedTime)
    {
        List<MobileElement> timings = webDriverFactory.getDriver().findElements(byTimeList);
        for (MobileElement time:timings)
        {
            if(time.getText().equals(adjustedTime))
            {
                time.click();
                break;
            }

        }
    }
    public void adjustAnyPrayerTime(String... args)
    {
//        basicFlows.scrollToElement("Prayer Time Adjustment");
        basicFlows.scrollUp(byHomeTown);
        MainCall.basicFlows.swipeVertical("up");
        tapPrayerAdjustment();
        String[] prayers = args;
        for (int i = 0; i <= args.length-1 ; i++)
        {
            tapTimeDropdown(prayers[i]);
            if (i>0)
            {
                basicFlows.scrollDown(byTimeScroll);
            }
            adjustPrayerTime(envGlobals.adjustedTime[i]);
        }

        MainCall.commonLocators.tapBackIcon();
    }

    public void re_adjustAnyPrayerTime(String... args)
    {
//        basicFlows.scrollToElement("Prayer Time Adjustment");
        basicFlows.scrollUp(byHomeTown);
        MainCall.basicFlows.swipeVertical("up");
        tapPrayerAdjustment();
        String[] prayers = args;
        for (int i = 0; i <= args.length-1 ; i++)
        {
            tapTimeDropdown(prayers[i]);
            if (i!=1)
            {
                basicFlows.scrollDown(byTimeScroll);
            }
            adjustPrayerTime(envGlobals.re_adjustedTime[i]);
        }

        MainCall.commonLocators.tapBackIcon();
    }

    //Set Location Manually or Change Location Method Functions

    //LOW_LEVEL FUNCTIONS
    public void tapAutoLocationToggle()
    {
        String locationType = webDriverFactory.getDriver().findElement(byLocationTypeText).getText();
        if (locationType.equals("Automatic")){
        webDriverFactory.getDriver().findElement(byAutoLocationToggle).click();
        }
    }

    public void tapLocationField()
    {
        webDriverFactory.getDriver().findElement(byLocationSearchManually).click();
    }

    public void enterSearchCity(String city)
    {
        WebElement cityField = webDriverFactory.getDriver().findElement(bySearchCityField);
        cityField.sendKeys(city);

    }

    public void selectSearchedCity()
    {
        webDriverFactory.getDriver().findElement(bySelectSearchedCity).click();
    }

    public void saveCity()
    {
        webDriverFactory.getDriver().findElement(bySaveCity).click();
    }

    public List<String>  getLocationName()
    {
        List<String> locationName = new ArrayList<>();
        String currentLoc  = webDriverFactory.getDriver().findElement(byCurrentLocTypeText).getText();
        String detectedLoc = webDriverFactory.getDriver().findElement(byDetectedLocText).getText();
        String manualLoc   = webDriverFactory.getDriver().findElement(byManualLocText).getText();
        String customLoc   = webDriverFactory.getDriver().findElement(byCustomLocText).getText();

        locationName.add(currentLoc);
        locationName.add(detectedLoc);
        locationName.add(manualLoc);
        locationName.add(customLoc);

        return locationName;
    }


    //HIGH-LEVEL FUNCTION
    public void changeLocationManually(String city)
    {
        String currentLoc  = webDriverFactory.getDriver().findElement(byCurrentLocTypeText).getText();
        if(!city.equals(currentLoc))
        {
        tapAutoLocationToggle();
        tapLocationField();
        enterSearchCity(city);
        selectSearchedCity();
        saveCity();
        }

    }

    public void verifyLocationName(String changedLocation)
    {
        List<String> location = getLocationName();
        for (String loc:location)
        {
            Assert.assertEquals(loc,changedLocation,"Location should have been" +" "+changedLocation +" "+"but is still" +" "+loc);
        }

    }





    // Sign Out

    public void verifyProfileSectionHeading()
    {
        String profileHeading =webDriverFactory.getDriver().findElement(byProfileSection).getText();
        Assert.assertEquals(profileHeading,"Profile");
    }

    public static void tapSignOut()
    {
        webDriverFactory.getDriver().findElement(bySignOut).click();
    }

    public void signOutOfApplication()
    {
        basicFlows.scrollToElement("Sign Out");
        MainCall.appSettingsView.tapSignOut();
        commonLocators.verifyAlertMessage("Are you sure you want to sign out?");
        commonLocators.clickOKPrompt();
        commonLocators.verifyAlertMessage("You have some PrayerBook,Ramadan Book logs and Jamat events pending to upload. Do you want to sync with server?");
        commonLocators.clickOKPrompt();
        commonLocators.alertLoaderStops();
        commonLocators.clickOKPrompt();
//        commonLocators.verifyUserLogOut();

    }



    //Hijri Adjustment Functions

    //Low level Functions
    public void tapHijriAdjustmentField()
    {
        webDriverFactory.getDriver().findElement(byHijriAdjustmentField).click();
    }

    public void verifyHijriListHeading()
    {
        String hijriHeading = webDriverFactory.getDriver().findElement(byHijriAdjustmentHeading).getText();
        Assert.assertEquals(hijriHeading,"Hijri Date Adjustment");
    }

    public void selectHijriDate(int days)
    {
        WebElement date = webDriverFactory.getDriver().findElements(byHijriAdjustmentDays).get(days);
//        if (date.getAttribute("checked").equals("true"))
//        {
//            System.out.println("Already selected");
//            commonLocators.clickOKPrompt();
//        }
//        else
            date.click();
            commonLocators.clickOKPrompt();
            commonLocators.tapBackIcon();
    }

    //High Level Functions

    public void adjustHijriDate()
    {
        tapHijriAdjustmentField();
        verifyHijriListHeading();
        selectHijriDate(0);
    }



}



