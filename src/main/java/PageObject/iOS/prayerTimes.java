package PageObject.iOS;

import General.MainCall;
import General.baseTest;
import General.webDriverFactory;
import General.webDriverWaits;
import io.appium.java_client.MobileElement;
import net.sf.cglib.asm.$Label;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

public class prayerTimes extends baseTest
{
    public prayerTimes(){}

    public static String prayerTimesLink = "Swipe for all prayer times";
    public static String backFromProfileIcon = "back template";
    public String dayToday = "//XCUIElementTypeStaticText[@name=\"TODAY\"]";
    public String dayYesterday = "//XCUIElementTypeStaticText[@name=\"YESTERDAY\"]";
    public String previousPageIcon = "back template";
    public String nextPageIcon = "forward template";
    public String shareCardBtn = "Standard Share";
    public String shareIcon = "share icon";
    public String saveImage = "Save Image";
    public String printOption = "Print";
    public String pngAthan = "SharePTime-Screen_AthanIcon.png";
    public String printScreen = "//XCUIElementTypeOther[@name=\"Printer Options\"]";
    public String textOnImg = "Page 1";
    public String headingAthan = "//XCUIElementTypeStaticText[@name=\"Athan\"]";
    public String addPhotoPrompt = "//XCUIElementTypeStaticText[@name=\"“Athan” Would Like to Add to your Photos\"]";


    public String prayerTimes = "//XCUIElementTypeApplication[@name=\"Athan\"]//XCUIElementTypeTable//XCUIElementTypeCell//XCUIElementTypeStaticText";

    public String continueBtn = "//XCUIElementTypeButton[@name=\"Continue\"]";
    public String congratsMsg = "Congratulations!";
    public String badgeProgressor = "PROGRESSOR";
    public String crossIcon = "close";
    public String BismillahBtn = "Say Bismillah";
    public String nextGoalMsg = "//XCUIElementTypeStaticText[contains(@name,'Next goal')]";
    public String coinImg = "//XCUIElementTypeStaticText[contains(@name,'Coin')]";
    public String prayerCnt = "//XCUIElementTypeStaticText[contains(@name,'/')]";
    public String monthlyIcon = "monthlyPrayers icon";
    public String IslamicMonthOnCard = "Rabi Al-Awwal 1441 - Rabi Al-Akhar 1441";
    public String CityOnCard = "Prayer Times in Lahore";
    public String CustomAngleOnCard = "University Of Islamic Sciences, Karachi (UISK)";
    public String IFLogo = "if-logo";
    public String monthlyPrayer = "//XCUIElementTypeApplication[@name=\"Athan\"]//XCUIElementTypeTable//XCUIElementTypeCell";






    public void tapSeePrayerTimesLink()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(prayerTimesLink).click();
    }

    public Map prayerTimesAndNames()
    {
        List<MobileElement> prayerTimesAndNames = webDriverFactory.getDriver().findElementsByXPath(prayerTimes);
        Map hashMap = new HashMap();

        int i = 0;



        while (i < prayerTimesAndNames.size()-1)
        {
            hashMap.put(prayerTimesAndNames.get(i).getText(), prayerTimesAndNames.get(i + 1).getText());
            i = i + 2;
        }

        return hashMap;

    }

    public String getPrayerTime(String prayerName)
    {
        Map allPrayerTimes =  prayerTimesAndNames();
        String prayerTime = allPrayerTimes.get(prayerName).toString();

        return prayerTime;

    }

    public List<String> getAllPrayerTime()
    {
        Map allPrayerTimes =  prayerTimesAndNames();
        ArrayList<String> prayerTimes = new ArrayList<String>(allPrayerTimes.values());
        return prayerTimes;

    }

    public void verifyPrayerTimes(List<String> prayerTimesFetched, String[] prayerTimesSaved)
    {
        Assert.assertEquals(prayerTimesFetched, Arrays.asList(prayerTimesSaved),"Prayer times are different for the day");
    }

    public void tapAllPrayerLogBox()
    {
        List<MobileElement> circles = webDriverFactory.getDriver().findElementsByXPath("(//XCUIElementTypeButton[@name=\"HomeScreen NotLoggedEnable\"])");
        for (MobileElement prayerCircle: circles)
        {
         prayerCircle.click();
        }


    }

    public void tapSpecificPrayerLogBox(int prayer)
    {
        MobileElement circle = webDriverFactory.getDriver().findElementByXPath("(//XCUIElementTypeButton[@name=\"HomeScreen NotLoggedEnable\"])["+ prayer+"]");
        circle.click();
    }

    public void verifyDayToday()
    {
        MobileElement dayFetched = webDriverFactory.getDriver().findElementByXPath(dayToday);
        Assert.assertEquals(dayFetched.getAttribute("value"),"TODAY","Screen not navigated to expected day ");
    }

    public void verifyDayYesterday()
    {
        MobileElement dayFetched = webDriverFactory.getDriver().findElementByXPath(dayYesterday);
        Assert.assertEquals(dayFetched.getAttribute("value"),"YESTERDAY","Screen not navigated to expected day ");
    }

    public void tapOnPreviousIcon(int numOfTap)
    {
        for (int i=0; i<=numOfTap-1; i++){
            webDriverFactory.getDriver().findElementByAccessibilityId(previousPageIcon).click();}
    }

    public void tapOnNextIcon(int numOfTap)

    {
        for (int i=0; i<=numOfTap-1; i++){
            webDriverFactory.getDriver().findElementByAccessibilityId(nextPageIcon).click();
        }
    }


    public void verifyBadgeAssigned()
    {
        WebElement message = webDriverFactory.getDriver().findElementByAccessibilityId(congratsMsg);
        if (message.getText().equals("Congratulations!"))
        {
            verifyCurrentTitle("Congratulations!");
            prayerCount("10 / 10");
            tapGoalContinue();
            verifyCongratsMessage();
//            verifyBadge();
            verifyInitiatorBadge("PROGRESSOR");
            tapCongratsScreenCrossIcon();
//            verifyBadge();
            verifyDescText();
            tapBismillahButton();
//            verifyCurrentTitle("Keep it going!");
            prayerCount("0 / 15");

        }
        else
            prayerCount("0 / 15");

    }

    public void tapGoalContinue()
    {
        MobileElement goal = webDriverFactory.getDriver().findElementByXPath(continueBtn);
        goal.click();
    }

    public void verifyCurrentTitle(String message)
    {
        MobileElement currentTitle = webDriverFactory.getDriver().findElementByAccessibilityId(congratsMsg);
        String titleText = currentTitle.getAttribute("value");
        Assert.assertEquals(titleText,message,"Titles does not match on home screen  ");
    }

    public void verifyCongratsMessage()
    {
        MobileElement congratulations = webDriverFactory.getDriver().findElementByAccessibilityId(congratsMsg);
        String congratsText = congratulations.getAttribute("name");
        Assert.assertEquals(congratsText,"Congratulations!","No congrats message shown ");
    }

    public void verifyBadge()
    {
        MobileElement badge = webDriverFactory.getDriver().findElementByXPath(coinImg);
        Assert.assertTrue(badge.isDisplayed());
    }

    public void verifyInitiatorBadge(String badgeAssigned)
    {
        MobileElement badge = webDriverFactory.getDriver().findElementByAccessibilityId(badgeProgressor);
        String badgeText = badge.getAttribute("value");
        Assert.assertEquals(badgeText,badgeAssigned,"Badge text not shown or different");
    }

    public void tapCongratsScreenCrossIcon()
    {
        try {
            webDriverFactory.getDriver().findElementByAccessibilityId(crossIcon).click();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void tapBismillahButton()
    {
        try {

            MobileElement btnBismillah = webDriverFactory.getDriver().findElementByAccessibilityId(BismillahBtn);
            btnBismillah.click();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void verifyDescText()
    {
        MobileElement desc = webDriverFactory.getDriver().findElementByXPath(nextGoalMsg);
        String description = desc.getAttribute("name");
        Assert.assertEquals(description,"Next goal: Offer 15 Prayers","Description not shown, or different");
    }


    public void prayerCount(String prayerValue)
    {
        MobileElement prayerCount = webDriverFactory.getDriver().findElementByXPath(prayerCnt);
        String value = prayerCount.getText();
        Assert.assertEquals(value,prayerValue,"Prayer count different on home screen");
    }



    //Share Functionality Low level functions

    public void tapShareIcon()
    {
        MobileElement share = webDriverFactory.getDriver().findElementByAccessibilityId(shareCardBtn);
        share.click();
    }

    public void verifyCard()
    {
       MobileElement img = webDriverFactory.getDriver().findElementByAccessibilityId(pngAthan);
       Assert.assertTrue(img.isDisplayed(),"Athan Logo not displayed on card");
    }

    public void verifyTextOnCard()
    {
        String heading = webDriverFactory.getDriver().findElementByXPath(headingAthan).getAttribute("name");
        Assert.assertEquals(heading,"Athan","Heading not shown or different on card");
    }

    public void tapSaveImageOption()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(saveImage).click();
    }

    public void tapShareIconOnCardScreen()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(shareIcon).click();
    }

    public void tapPrintOption()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(printOption).click();
    }

    public void verifyPrinterScreen()
    {
        String screen = webDriverFactory.getDriver().findElementByXPath(printScreen).getAttribute("name");
        Assert.assertEquals(screen,"Printer Options","Print screen or heading not displayed");
    }

    public void verifyPrintScreen()
    {
        MobileElement prayerCard = webDriverFactory.getDriver().findElementByAccessibilityId(textOnImg);
        Assert.assertEquals(prayerCard.getAttribute("name"),"Page 1","Text on card not shown or card not shown");
    }

    public void verifyModalMessage()
    {
        String msg = webDriverFactory.getDriver().findElementByXPath(addPhotoPrompt).getAttribute("name");
        Assert.assertEquals(msg,"“Athan” Would Like to Add to your Photos","No permission prompt showm");
    }

    //Share Functionality High level Functions

    public void sharePrayerCard()
    {
        tapShareIcon();
//        verifyCard();
        verifyTextOnCard();
        tapSaveImageOption();
        verifyModalMessage();
        commonLocators.tapOK();
        tapShareIcon();
        tapPrintOption();
        verifyPrinterScreen();
        verifyPrintScreen();

    }


    public void verifyPrayerTimeAfterMethodChange(String timeBefore, String timeAfter)
    {

        Assert.assertFalse(timeBefore.equals(timeAfter),"No Change After Jurisdiction method change");

    }

    public void verifyPrayerTimings(String[] timings)
    {
        List<String> prayerTimesTODAY = MainCall.prayerTimes.getAllPrayerTime();
        Collections.sort(prayerTimesTODAY);
        Assert.assertEquals(prayerTimesTODAY,Arrays.asList(timings));
    }

    public void backFromProfileScreen()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(backFromProfileIcon).click();
    }

    //Monthly Prayer Times Card Low-level Function
    public void tapMonthlyCardIcon() {
        MobileElement month = webDriverFactory.getDriver().findElementByAccessibilityId(monthlyIcon);
        month.click();
    }
    public void verifyIslamicMonthOnCard(String month) {
        MobileElement islamicMonth = webDriverFactory.getDriver().findElementByAccessibilityId(IslamicMonthOnCard);
        Assert.assertTrue(islamicMonth.isDisplayed(), "Islamic Month not shown or different");
        String monthName = islamicMonth.getText();
        Assert.assertEquals(monthName, month, "Islamic Month displayed on calendar is different");

    }

    public void verifyCityOnCard(String city) {
        MobileElement cityOnCard = webDriverFactory.getDriver().findElementByAccessibilityId(CityOnCard);
        Assert.assertTrue(cityOnCard.isDisplayed(), "City not shown or different");
        String cityName = cityOnCard.getText();;
        Assert.assertEquals(cityName, city, "Islamic Month displayed on calendar is different");

    }

    public void verifyAngleOnCard(String angle) {
        MobileElement angleOnCard = webDriverFactory.getDriver().findElementByAccessibilityId(CustomAngleOnCard);
        Assert.assertTrue(angleOnCard.isDisplayed(), "Angle not shown or different");
        String angleName = angleOnCard.getText();;
        Assert.assertEquals(angleName, angle, "Islamic Month displayed on calendar is different");

    }

    public void verifyLogoDisplayed()
    {
        webDriverWaits.sleep1000();
        MobileElement IF_logo = webDriverFactory.getDriver().findElementByAccessibilityId(IFLogo);
        Assert.assertTrue(IF_logo.isDisplayed());
    }


    //Monthly Prayer Times Card High-level Function
    public void verifyPrayerTimeOnCard(int date, String[] timings) {
        List<MobileElement> monthlyTimings = webDriverFactory.getDriver().findElementsByXPath(monthlyPrayer);
        List<String> timingsForDay = new ArrayList<>();

        List<MobileElement> prayerTimes = monthlyTimings.get(date).findElementsByXPath("//XCUIElementTypeStaticText");


        for (MobileElement time : prayerTimes) {
            String text = time.getAttribute("value");
//            String text = time.getText();
            if (!text.equals("")) {
                timingsForDay.add(text);
            }
        }
        Collections.sort(timingsForDay);

        Assert.assertEquals(timingsForDay, Arrays.asList(timings),"Prayer timings not correct on calendar");

    }

    public void verifyDetailsOnMonthlyCard(String month, String city, String angle) {
        verifyLogoDisplayed();
        verifyIslamicMonthOnCard(month);
        verifyCityOnCard(city);
        verifyAngleOnCard(angle);
    }

}
