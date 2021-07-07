package PageObject.iOS;

import General.*;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import javax.swing.*;

public class login extends baseTest
{
    public login(){}

    public String btnLater = "Later";
    public String btnLogin = "Login";
    public String txtLogin = "Please login to continue";
    public String profileIcon = "profile icon";
    public String loginProfileIcon = "//XCUIElementTypeButton[@name=\"ProfileEditScreen DefaultImage\"]";
    public String coinImg = "//XCUIElementTypeImage[contains(@name,'Coin')]";
    public String startText = "//XCUIElementTypeStaticText[@name=\"Please enter your profile information\"]";
    public String emailField = "emailText";
    public String passwordField = "passwordText";
    public String loginButton = "LOGIN";
    public String nextBtn = "NEXT";
    public String skipBtn = "//XCUIElementTypeButton[@name=\"Skip\"]";
    public String continueBtn = "//XCUIElementTypeButton[@name=\"Continue\"]";
    public String getMyLocBtn = "//XCUIElementTypeApplication[@name=\"Athan\"]//XCUIElementTypeButton[contains(@name,'Get')]";
    public String allowOption = "Allow";
    public String privacyMsg = "//XCUIElementTypeStaticText[@name=\"By tapping 'Continue' you agree to our Terms & Conditions and Privacy Policy\"]";
    public String modalMsg = "//XCUIElementTypeStaticText[@name=\"Allow “Athan” to access your location while you are using the app?\"]";


    //Launch App

    public void tapContinueButton()
    {
        webDriverWaits.sleep1000();
        webDriverFactory.getDriver().findElementByXPath(continueBtn).click();

        logStep("User taps on continue button");
    }

    public void tapGetMyLocBtn()
    {
        webDriverWaits.sleep1000();
        webDriverFactory.getDriver().findElementByXPath(getMyLocBtn).click();

        logStep("User taps on getMyLocation button");
    }

    public void tapAllow()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(allowOption).click();
        logStep("User taps on device Allow prompt button");
    }

    public void verifyPrivacyMessage()
    {
        logActualResult("User should be shown privacy message");

        webDriverWaits.sleep(7000);
        String msg = webDriverFactory.getDriver().findElementByXPath(privacyMsg).getAttribute("name");
        Assert.assertEquals(msg,"By tapping 'Continue' you agree to our Terms & Conditions and Privacy Policy","No privscy msg shown or screen not displayed");

        logExpectedResult("Privacy message successfully verified");
    }

    public void verifyAllowMessage()
    {
        logActualResult("Allow pop up should be shown");

        String msg = webDriverFactory.getDriver().findElementByXPath(modalMsg).getAttribute("name");
        Assert.assertEquals(msg,"Allow “Athan” to access your location while you are using the app?","No privscy msg shown or screen not displayed");

        logExpectedResult("Allow prompt message verified");
    }

    public void tapNext()
    {
        logActualResult("Tap on next button");

        webDriverFactory.getDriver().findElementByAccessibilityId(nextBtn).click();
        logExpectedResult("User taps on next button");
    }

    public void launchApplication()
    {
        verifyPrivacyMessage();
        tapContinueButton();
        tapGetMyLocBtn();
        verifyAllowMessage();
        tapAllow();
        tapNext();
        tapAllow();
        tapNext();
        verifyHomeScreen();
    }


    //PrayerLogging login Modal Functions
    public void tapLoginOnModal()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(btnLogin).click();
    }

    public void tapLaterOnLoginModal()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(btnLater).click();
        logStep("User taps on LaterOn button on Login Modal");

    }

    public void verifyModalDisplayed()
    {
        MobileElement coin = webDriverFactory.getDriver().findElementByXPath(coinImg);
        Assert.assertTrue(coin.getAttribute("name").contains("Coin"),"Coin not displayed on login modal");

        logStep("Modal is displayed");
    }

    public void verifyLoginMessageOnModal()
    {
        String text = webDriverFactory.getDriver().findElementByAccessibilityId(txtLogin).getAttribute("value");
        Assert.assertEquals(text,"Please login to continue","Login modal not displayed");

        logStep("Message on login Modal verified");
    }

    public void tapProfileIcon()
    {
        logActualResult("Tap on profile icon");

        MobileElement profile = webDriverFactory.getDriver().findElementByAccessibilityId(profileIcon);
        profile.click();

        logExpectedResult("User taps on Profile icon in logged out state");
    }

    public void tapLoginProfileIcon()
    {
        MobileElement profile = webDriverFactory.getDriver().findElementByXPath(loginProfileIcon);
        profile.click();
        logStep("User taps on Profile icon in logged in state");


    }

    public void verifyStartMessage()
    {
        logActualResult("User should be able to see start message");

        String text = webDriverFactory.getDriver().findElementByXPath(startText).getAttribute("value");
        Assert.assertEquals(text,"Please enter your profile information","Login screen message not shown");

        logExpectedResult("Message verified on login screen");
    }

    public void enterLoginDetails(String email, String pass)
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(emailField).sendKeys(email);
        logStep("User enters email in login form");
        commonLocators.keyboardNextBtn();

        webDriverFactory.getDriver().findElementByAccessibilityId(passwordField).sendKeys(pass);
        logStep("User enters password in login form");
        commonLocators.keyboardDoneBtn();
    }

    public void tapLoginButton()
    {
        MobileElement loginBtn = webDriverFactory.getDriver().findElementByAccessibilityId(loginButton);
        loginBtn.click();
        webDriverWaits.sleep(2000);
        logStep("User taps on login button");
    }

    public void verifyHomeScreen()
    {
        logActualResult("Verify user is redirected to home screen");

        String text = webDriverFactory.getDriver().findElementByAccessibilityId(prayerTimes.prayerTimesLink).getText();
        Assert.assertEquals(text,"Swipe for all prayer times","No visibility of swipe link on home screen");

        logExpectedResult("Home screen successfully verified, prayer times link displayed");
    }


    public String verifyIfAlreadyLoggedIn()
    {
        String profile = "";
        try {
            profile = webDriverFactory.getDriver().findElementByXPath(loginProfileIcon).getAttribute("label");
        }
        catch (Exception e)
        {

        }

        return profile;

    }

    public void loginIntoApp(String email, String pass)
    {
        if (!verifyIfAlreadyLoggedIn().contains("ProfileEditScreen"))
        {
            logActualResult("User should be logged in");
            MainCall.login.tapProfileIcon();
            verifyStartMessage();
            enterLoginDetails(envGlobals.userLoginEmail, envGlobals.userLoginPassword);
            tapLoginButton();
            MainCall.prayerTimes.tapCongratsScreenCrossIcon();
            MainCall.prayerTimes.tapBismillahButton();

            logExpectedResult("User is logged in");

        }

        else
            System.out.println("User already logged in");

    }

}
