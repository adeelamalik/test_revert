package PageObject.iOS;

import General.baseTest;
import General.basicFlows;
import General.envGlobals;
import General.webDriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static General.MainCall.*;
import static General.webDriverFactory.driver;

public class appSettings extends baseTest
{
    public appSettings()
    {}

    public String hijriDateField = "//XCUIElementTypeApplication[@name=\"Athan\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]";

    //Change Location Locators
    public String searchLocationField = "//XCUIElementTypeStaticText[contains(@value,'Search Location Manually')]";
    public String currentLocationField = "//XCUIElementTypeStaticText[contains(@value,'CURRENT LOCATION')]";
    public String customLocationField = "//XCUIElementTypeStaticText[contains(@value,'Add Custom Location')]";
    public String detectedLocationField = "//XCUIElementTypeStaticText[contains(@value,'Auto Detect')]";

    public String setCityScreen = "//XCUIElementTypeOther[@name=\"Choose a city\"]";
    public String btnLetsGo = "Let's go";
    public String btnClear = "Clear text";
    public String selectNewYorkCity = "New York, United States";
    public String searchCityField = "//XCUIElementTypeApplication[@name=\"Athan\"]//XCUIElementTypeTextField";
    public String calMethods = "//XCUIElementTypeApplication[@name=\"Athan\"]//XCUIElementTypeTable//XCUIElementTypeCell//XCUIElementTypeStaticText";
    public String calculationHeading = "//XCUIElementTypeNavigationBar[@name=\"Calculation Method\"]";
    public String calculationWarning = "//XCUIElementTypeOther[@name=\"Any Adjustment in calculation method will affect Fajar and Isha prayer times.\"]";
    public By byprayerSection = By.xpath("//XCUIElementTypeStaticText[@name=\"PRAYERS\"]");


    //Calculation Field Locators
    public String calculationField = "//XCUIElementTypeStaticText[contains(@value,'Calculation Method')]";

    //Juristic Method Locators
    public String juristicMethodField = "//XCUIElementTypeStaticText[contains(@name,'Juristic Method')]";

    //SignOut Locators
    public static String signOutBtn = "Sign Out";




   //Low level Hijri Functions
    public void tapHijriDateField()
    {
       WebElement hijriField = webDriverFactory.getDriver().findElementByXPath(hijriDateField);
       hijriField.click();
    }

    public void selectHijriDate()
    {
//        webDriverFactory.getDriver().findElementByXPath(hijriDates).sendKeys("Two days ago");
        Dimension size = driver.manage().window().getSize();
        int x = size.width - 190;
        int y1 = size.height - 85;
        int y2 = size.height - 200;
        (new TouchAction(webDriverFactory.getDriver()))
                .press( x, y1)
                .moveTo( x, y2)
                .release()
                .perform();
    }

    //High Level Hijri Functions

    public void adjustHijriDate()
    {
        tapHijriDateField();
        selectHijriDate();
        commonLocatorsIOS.tapDoneIcon();
        commonLocatorsIOS.tapBackIcon();
    }


    //Low level Change Location Functions

    public void tapAutoLocationToggle()
    {
        String locationType = webDriverFactory.getDriver().findElementByXPath(currentLocationField).getAttribute("value");
        if (locationType.contains("Automatic")){
            webDriverFactory.getDriver().findElementByXPath(detectedLocationField).click();
        }
    }

    public void tapLocationField()
    {
        MobileElement locationField = webDriverFactory.getDriver().findElementByXPath(searchLocationField);
        locationField.click();
    }

    public void verifySearchScreen()
    {
        String screenName = webDriverFactory.getDriver().findElementByXPath(setCityScreen).getAttribute("name");
        Assert.assertEquals(screenName,"Choose a city","Search city screen not displayed");
    }

    public void enterSearchCity(String city)
    {
        MobileElement cityField = webDriverFactory.getDriver().findElementByXPath(searchCityField);
        cityField.sendKeys("");

        MobileElement clearBtn = webDriverFactory.getDriver().findElementByAccessibilityId(btnClear);
        clearBtn.click();
//        Assert.assertTrue(clearBtn.getAttribute("value").equals("Search city"));

        cityField.sendKeys(city);

    }

    public void selectSearchedCity(String city)
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(city).click();
    }

    public void saveCity()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(btnLetsGo).click();
    }

    public List<String> getLocationName()
    {
        List<String> locationName = new ArrayList<>();
        String detectedLoc = webDriverFactory.getDriver().findElementByXPath(detectedLocationField).getAttribute("value");
        String manualLoc   = webDriverFactory.getDriver().findElementByXPath(searchLocationField).getAttribute("value");
        String customLoc   = webDriverFactory.getDriver().findElementByXPath(customLocationField).getAttribute("value");

        locationName.add(detectedLoc);
        locationName.add(manualLoc);
        locationName.add(customLoc);

        return locationName;
    }


    //High Level Functions Change Location

    public void changeLocationManually(String city,String cityToSelect)
    {
        String currentLoc  = webDriverFactory.getDriver().findElementByXPath(searchLocationField).getAttribute("value");
        if(!currentLoc.contains(city))
        {
            tapAutoLocationToggle();
            tapLocationField();
            verifySearchScreen();
            enterSearchCity(city);
            selectSearchedCity(cityToSelect);
            saveCity();

        }
    }

    public void verifyLocationName(String changedLocation)
    {
        List<String> location = getLocationName();
        for (String loc:location)
        {
            Assert.assertTrue(loc.contains(changedLocation),"Location should have been" +" "+changedLocation +" "+"but is still" +" "+loc);
        }

    }


    //SignOut Of the Application

    public void tapSignOut()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(signOutBtn).click();
    }

    public void signOutOfApplication()
    {
        basicFlows.swipeVertical("up");
        basicFlows.swipeVertical("up");
        tapSignOut();
        commonLocatorsIOS.verifyModalMessage();
        commonLocatorsIOS.tapModalYes();

    }


    //Change calculation method low level functions
    public void tapCalculationMethodField()
    {
        webDriverFactory.getDriver().findElementByXPath(calculationField).click();
    }

    public void selectCalculationMethod(String calculationMethod)
    {
        List<MobileElement> calculationMethods = webDriverFactory.getDriver().findElementsByXPath(calMethods);
//        for (MobileElement calculateMethod:calculationMethods)
        for (int i = 0; i < calculationMethods.size() - 1; i++)
        {
            String text = calculationMethods.get(i).getAttribute("value");
            if (text.equals(calculationMethod))
            {
                if (!text.contains(envGlobals.alreadyMethod)) {
                    calculationMethods.get(i).click();
                    break;
                } else
                    System.out.println("Entered calculation Method already selected");
                System.out.println("Selecting method by default");
                if (i == calculationMethods.size() - 1)
                {
                    calculationMethods.get(0).click();
                    break;
                }
                else {
                    i=i+2;
                    calculationMethods.get(i).click();
                    break;
                }
            }
        }
    }

    public String getCalculationMethodText()
    {
        String calculationMethod = webDriverFactory.getDriver().findElementByXPath(calculationField).getAttribute("value");
        return calculationMethod;
    }

    public void getCalculationScreenName()
    {
       String heading = webDriverFactory.getDriver().findElementByXPath(calculationHeading).getAttribute("name");
       Assert.assertEquals(heading,"Calculation Method","Wrong screen or not naviagted to calculation screen");
    }

    public void calculationWarningMessage()
    {
        String message = webDriverFactory.getDriver().findElementByXPath(calculationWarning).getAttribute("name");
        Assert.assertEquals(message,"Any Adjustment in calculation method will affect Fajar and Isha prayer times.","Mo warning shown about isha and fajr time change");
    }

    public void backFromCalMethods()
    {
        MobileElement backIcon = webDriverFactory.getDriver().findElementByAccessibilityId("Settings");
        backIcon.click();
    }

    public void verifyCalculationMethod(String method)
    {
        String calculationMethod = webDriverFactory.getDriver().findElementByXPath(calculationField).getAttribute("value");
        Assert.assertTrue(calculationMethod.contains(method),"Calculation Method is different according to city selected");

    }


    //High level Calculation method
    public void changeCalculationMethod(String method)
    {
//        General.basicFlows.scrollUp(byprayerSection);
        envGlobals.alreadyMethod = getCalculationMethodText().split("\n")[1];
        tapCalculationMethodField();
        getCalculationScreenName();
        calculationWarningMessage();
        selectCalculationMethod(method);
        backFromCalMethods();
    }

    //Juristic Method Functions Low level

    public void tapJuristicMethodDropdown()
    {
        WebElement juristicDropdwn = webDriverFactory.getDriver().findElementByXPath(juristicMethodField);
        juristicDropdwn.click();
    }

    public void selectJuristicMethod()
    {
        Dimension size = driver.manage().window().getSize();
        (new TouchAction(webDriverFactory.getDriver()))
                .press( 183, 523)
                .moveTo( 188, 562)
                .release()
                .perform();

    }

    //High level Juristic
    public void changeJuristicMethod()
    {
        basicFlows.swipeVertical("up");
        tapJuristicMethodDropdown();
        selectJuristicMethod();
        commonLocatorsIOS.tapDoneIcon();
    }

}
