package PageObject.Android;

import General.MainCall;
import General.webDriverFactory;
import General.webDriverWaits;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

import static Config.configProperties.appPackageValue;
import static General.MainCall.basicFlows;
import static General.MainCall.commonLocators;

public class prayerTimesView {

    public prayerTimesView() {
    }


    public static By byPrayerTimesIcon = By.xpath("//android.widget.CheckedTextView[@text='Prayer Times']");
    public static By byShareIcon = By.id(appPackageValue + "btn_share_daily_prayer_time");
    public static By byShareButton = By.id(appPackageValue + "action_share");
    public static By bySeeWeeklyButton = By.id(appPackageValue + "btn_see_all");
    public static By byMonthlyPrayerButton = By.id(appPackageValue + "btn_monthly_prayer_time");
    public static By byNextPageIcon = By.id(appPackageValue + "next_pager");
    public static By byPreviousPageIcon = By.id(appPackageValue + "previous_pager");
    public static By byHomeScreenSwipe = By.id(appPackageValue + "prayer_goal_frag");
    public static By byCurrentDay = By.id(appPackageValue + "prayer_details_current_date");

    public static By byGoalContinue = By.id(appPackageValue + "btn_continue_goal_card");
    public static By byCurrentPrayerTitleText = By.id(appPackageValue + "txt_current_prayer_title");
    public static By byTextCongrats = By.id(appPackageValue + "txt_congratulation");
    public static By byImgBadge = By.id(appPackageValue + "img_badge");
    public static By byTitleText = By.id(appPackageValue + "txt_title");
    public static By byCrossIcon = By.id(appPackageValue + "img_cross");
    public static By byBtnBismillah = By.id(appPackageValue + "btn_say_bismillah");
    public static By byTextDesc = By.id(appPackageValue + "txt_description");
    public static By byPrayerCountHome = By.id(appPackageValue + "txt_goal_prayer_offered_count");
    public static By byTitle = By.id(appPackageValue + "txt_user_name");
    public static By byBadgesText = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.athan:id/badges_grid']//android.widget.TextView");

    public static By byPrayerTimeAndName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView");

    public static By bySelectGmail = By.xpath("//android.widget.GridView[@resource-id='android:id/sem_resolver_pagemode_page_list']//android.widget.LinearLayout/android.widget.TextView");
    public static By byAthanAppLink = By.xpath("//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/content']/android.widget.RelativeLayout[@resource-id='com.google.android.gm:id/body_wrapper']//android.widget.EditText");
    public static By byAthanPrayerCard = By.xpath("//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/content']//android.widget.FrameLayout[@resource-id='com.google.android.gm:id/attachment_tile']");
    public static By byToField = By.xpath("//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/content']//android.widget.MultiAutoCompleteTextView");
    String sendIcon = "Send";


    //Locators For MonthPrayerTime

    public static By  byIslamicMonthOnCard = By.xpath("//android.view.View[@text='Rabi Al-Awwal 1441 - Rabi Al-Akhar 1441']");
    public static By  byCityOnCard = By.xpath("//android.view.View[@text='Prayer Times in Lahore']");
    public static By  byCustomAngleOnCard = By.xpath("//android.view.View[@text='Union of Islamic Organisations of France (UOIF)']");
    public static By  byIFLogo = By.xpath("//android.widget.Image[@text='if-logo']");

    public static By byMonthlyPrayers = By.xpath("//android.widget.GridView[@resource-id='monthly-prayers']/android.view.View");



    public void clickPrayerTimesIcon() {
        webDriverFactory.getDriver().findElement(byPrayerTimesIcon).click();
    }

    public Map prayerTimesAndNames() {
        List<MobileElement> prayerTimesAndNames = webDriverFactory.getDriver().findElements(byPrayerTimeAndName);
        Map hashMap = new HashMap();

        int i = 0;


        while (i < prayerTimesAndNames.size() - 1) {
            hashMap.put(prayerTimesAndNames.get(i).getText(), prayerTimesAndNames.get(i + 1).getText());
            i = i + 2;
        }

        return hashMap;

    }

    public String getPrayerTime(String prayerName) {
        Map allPrayerTimes = prayerTimesAndNames();
        String prayerTime = allPrayerTimes.get(prayerName).toString();

        return prayerTime;

    }

    public List<String> getAllPrayerTime() {
        Map allPrayerTimes = prayerTimesAndNames();
        ArrayList<String> prayerTimes = new ArrayList<String>(allPrayerTimes.values());
        return prayerTimes;

    }

    public void verifyPrayerTimes(List<String> prayerTimesFetched, String[] prayerTimesSaved) {
        Assert.assertEquals(prayerTimesFetched, Arrays.asList(prayerTimesSaved), "Prayer times are different for the day");
    }

    public void verifyPrayerTimeAfterMethodChange(String timeBefore, String timeAfter) {

        Assert.assertFalse(timeBefore.equals(timeAfter), "No Change After Jurisdiction");

    }

    public void verifyTimeAfterAdjustment(String timeBefore, String timeAfter, String minutesAdjusted, String operator) {
        switch (operator) {
            case "-":
                Assert.assertFalse(timeBefore == timeAfter + minutesAdjusted);
                break;
            case "+":
                Assert.assertFalse(timeBefore == timeBefore + minutesAdjusted);
        }
    }


    public void tapShareIconOnPrayerTime() {
        webDriverFactory.getDriver().findElement(byShareIcon).click();
    }

    public void tapShareIconOnTimeCard() {
        webDriverFactory.getDriver().findElement(byShareButton).click();
    }

    public void tapSeePrayerTimesLink() {
        webDriverFactory.getDriver().findElement(loginView.byAllPrayerTimesBtn).click();
    }

    public void tapWeeklyPrayerTimeButton() {
        WebElement weeklyBtn = webDriverFactory.getDriver().findElement(bySeeWeeklyButton);
        weeklyBtn.click();
    }

    public void homeScreenImageFrame() {
        WebElement frame = webDriverFactory.getDriver().findElement(byHomeScreenSwipe);
        frame.click();
    }

    public void verifyDaysOfWeekDisplayed() {
        String currentDay = MainCall.genericFunctions.getDayFromDate();

    }

    public void tapOnPreviousIcon(int numOfTap) {
        for (int i = 0; i <= numOfTap - 1; i++) {
            webDriverFactory.getDriver().findElement(byPreviousPageIcon).click();
        }
    }

    public void tapOnNextIcon(int numOfTap) {
        for (int i = 0; i <= numOfTap - 1; i++) {
            webDriverFactory.getDriver().findElement(byNextPageIcon).click();
        }
    }

    public void tapAllPrayerLogBox() {
        int i = 3;
        do {
            WebElement circle = webDriverFactory.getDriver().findElement(By.xpath("(//android.widget.ImageButton[@content-desc=\"Athan\"])[" + i + "]"));
            circle.click();
            i = i + 2;
            basicFlows.swipeVertical("down");
        }
        while (i <= 13);

    }

    public void tapSpecificPrayerLogBox(int prayer)
    {
        MobileElement circle = webDriverFactory.getDriver().findElement(By.xpath("(//android.widget.ImageButton[@content-desc=\"Athan\"])[" + prayer + "]"));
        webDriverWaits.sleep250();
        circle.click();
    }

    public void verifyDayOnPage(String day) {
        String dayFetched = webDriverFactory.getDriver().findElement(byCurrentDay).getText();
        Assert.assertEquals(dayFetched, day, "Screen not navigated to expected day ");
    }

    public void goToPrayerTimesScreen() {
        tapSeePrayerTimesLink();
        commonLocators.verifyScreenHeading("Prayer Times");
        verifyDayOnPage("Today");
    }

    public void selectGmail(String shareMedium) {
        List<MobileElement> shareOptions = webDriverFactory.getDriver().findElements(bySelectGmail);
        for (MobileElement shareOption : shareOptions) {
            String text = shareOption.getText();
            if (text.equals(shareMedium)) {
                shareOption.click();
                break;
            }
        }
    }

    public void verifyAppLinkOnEmail() {
        MobileElement appLink = webDriverFactory.getDriver().findElement(byAthanAppLink);
        webDriverWaits.waitUntilElementNotDisplayed(appLink);
        Assert.assertEquals(appLink.getText(), "https://athaninvite.page.link/iGwv", "Wrong app link shown in email");
    }

    public void verifyPrayerCardOnEmail() {
        MobileElement prayerCard = webDriverFactory.getDriver().findElement(byAthanPrayerCard);
        Assert.assertTrue(prayerCard.isDisplayed());
    }

    public void entertoField() {
        webDriverFactory.getDriver().findElement(byToField).sendKeys("hello@g.com");
    }

    public void tapSendEmailIcon() {
        webDriverFactory.getDriver().findElementByAccessibilityId(sendIcon).click();
    }

    public void shareCardViaEmail(String shareMedium) {
        selectGmail(shareMedium);
        verifyAppLinkOnEmail();
        verifyPrayerCardOnEmail();
        entertoField();
        tapSendEmailIcon();
    }

    public void verifyPrayerTimings(String[] timings) {
        List<String> prayerTimesTODAY = MainCall.prayerTimesView.getAllPrayerTime();
        Collections.sort(prayerTimesTODAY);
        Assert.assertEquals(prayerTimesTODAY, Arrays.asList(timings));
    }

    public void verifyPrayerTimingsForWeek() {
    }

    ;

    public void tapGoalContinue() {
        MobileElement goal = webDriverFactory.getDriver().findElement(byGoalContinue);
        goal.click();
    }

    public void verifyCurrentTitle(String message) {
        MobileElement currentTitle = webDriverFactory.getDriver().findElement(byCurrentPrayerTitleText);
        String titleText = currentTitle.getText();
        Assert.assertEquals(titleText, message, "Titles does not match on home screen  ");
    }

    public void verifyCongratsMessage() {
        MobileElement congratulations = webDriverFactory.getDriver().findElement(byTextCongrats);
        String congratsText = congratulations.getText();
        Assert.assertEquals(congratsText, "Congratulations!", "No congrats message shown ");
    }

    public void verifyBadge() {
        webDriverWaits.waitUntilElementVisible(byImgBadge);
        MobileElement badge = webDriverFactory.getDriver().findElement(byImgBadge);
        Assert.assertTrue(badge.isDisplayed());
    }

    public void verifyBadgeText(String badgeAssigned) {
        MobileElement badge = webDriverFactory.getDriver().findElement(byTitleText);
        String badgeText = badge.getText();
        Assert.assertEquals(badgeText, badgeAssigned, "Badge text not shown or different");
    }

    public void tapCongratsScreenCrossIcon() {
        webDriverFactory.getDriver().findElement(byCrossIcon).click();
    }

    public void tapBismillahButton() {
        MobileElement btnBismillah = webDriverFactory.getDriver().findElement(byBtnBismillah);
        btnBismillah.click();
    }

    public void verifyDescText() {
        MobileElement desc = webDriverFactory.getDriver().findElement(byTextDesc);
        String description = desc.getText();
        Assert.assertEquals(description, "Next Goal: Offer 15 prayers", "Description not shown, or different");
    }

    public void verifyTitle(String badge) {
        MobileElement titleOnProfileScreen = webDriverFactory.getDriver().findElement(byTitle);

        Assert.assertEquals(titleOnProfileScreen.getText(), badge, "Badge on Profile Screen not shown or different");

    }

    public void badgesDisplayed(String title) {
        List<MobileElement> badges = webDriverFactory.getDriver().findElements(byBadgesText);
        for (MobileElement badge : badges) {
            String text = badge.getText();
            if (text.equals(title)) {
                break;
            }
        }
    }

    public void prayerCountOnHome(String prayerValue) {
        MobileElement prayerCount = webDriverFactory.getDriver().findElement(byPrayerCountHome);
        String value = prayerCount.getText();
        Assert.assertEquals(value, prayerValue, "Prayer count different on home screen");
    }

    public void verifyPrayerCountOnHome() {
        MobileElement prayerCount = webDriverFactory.getDriver().findElement(byPrayerCountHome);
        String value = prayerCount.getText();
        String firstValue = value.split("/")[0];
        String secondValue = value.split("/")[1];

        Assert.assertTrue(Integer.parseInt(secondValue) >= 5);
        if (secondValue.equals("5")) {
            Assert.assertTrue(Integer.parseInt(firstValue) == 5);
        }

    }

    public void verifyBadgeAssigned() {
        WebElement countOnHome = webDriverFactory.getDriver().findElement(byPrayerCountHome);
        if (countOnHome.getText().equals("10/10")) {
            verifyCurrentTitle("Congratulations!");
            tapGoalContinue();
            verifyCongratsMessage();
            verifyBadge();
            verifyBadgeText("PROGRESSOR");
            tapCongratsScreenCrossIcon();
            verifyBadge();
//            verifyDescText();
            tapBismillahButton();
            verifyCurrentTitle("Get ready for the next Prayer");
            prayerCountOnHome("0/15");
        } else
            verifyPrayerCountOnHome();
    }

    public void badgeOnProfileScreen(String badgeName) {
        MainCall.commonLocators.alertLoaderStops();
        verifyTitle(badgeName);
        badgesDisplayed(badgeName);
    }

    //Low Level Monthly Card Function

    public void tapMonthlyCardIcon() {
        MobileElement monthlyIcon = webDriverFactory.getDriver().findElement(byMonthlyPrayerButton);
        monthlyIcon.click();
    }

    public void verifyIslamicMonthOnCard(String month) {
        MobileElement islamicMonth = webDriverFactory.getDriver().findElement(byIslamicMonthOnCard);
        Assert.assertTrue(islamicMonth.isDisplayed(), "Islamic Month not shown or different");
        String monthName = islamicMonth.getText();
        Assert.assertEquals(monthName, month, "Islamic Month displayed on calendar is different");

    }

    public void verifyCityOnCard(String city) {
        MobileElement cityOnCard = webDriverFactory.getDriver().findElement(byCityOnCard);
        Assert.assertTrue(cityOnCard.isDisplayed(), "City not shown or different");
        String cityName = cityOnCard.getText();;
        Assert.assertEquals(cityName, city, "Islamic Month displayed on calendar is different");

    }

    public void verifyAngleOnCard(String angle) {
        MobileElement angleOnCard = webDriverFactory.getDriver().findElement(byCustomAngleOnCard);
        Assert.assertTrue(angleOnCard.isDisplayed(), "Angle not shown or different");
        String angleName = angleOnCard.getText();;
        Assert.assertEquals(angleName, angle, "Islamic Month displayed on calendar is different");

    }

    public void verifyLogoDisplayed()
    {
        webDriverWaits.sleep1000();
        MobileElement IF_logo = webDriverFactory.getDriver().findElement(byIFLogo);
        Assert.assertTrue(IF_logo.isDisplayed());
    }

    //High Level Monthly Card Function

    public void verifyPrayerTimeOnCard(int date, String[] timings) {
        List<MobileElement> monthlyTimings = webDriverFactory.getDriver().findElements(byMonthlyPrayers);
        List<String> timingsForDay = new ArrayList<>();

        List<MobileElement> prayerTimes = monthlyTimings.get(date).findElementsByXPath("//android.view.View");


        for (MobileElement time : prayerTimes) {
//            String text = time.getAttribute("content-desc");
            String text = time.getText();
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




