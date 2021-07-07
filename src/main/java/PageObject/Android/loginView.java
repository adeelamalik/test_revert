package PageObject.Android;

import General.MainCall;
import General.baseTest;
import General.webDriverFactory;
import General.webDriverWaits;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import static Config.configProperties.appPackageValue;

public class loginView extends baseTest {
    public loginView(){}

    //LaunchScreenLocators
    public static By byContinueButton                   =By.id(appPackageValue + "tap_To_continue");
    public static By byOnBoardingButtons                =By.id(appPackageValue + "btn_on_boarding");
    public static By byLoader                           =By.id(appPackageValue + "progressBar");
    public static By byLoaderTitle                      =By.id(appPackageValue + "dia_title____");
    public static By byImageCrossIcon                   =By.id(appPackageValue + "img_cross_icon");



    //LoginPageLocators
    public static By byProfileLogo                  = By.id(appPackageValue + "img_home_header_profile");
    public static By byEmail                        = By.id(appPackageValue + "email");
    public static By byPassword                     = By.id(appPackageValue + "password");
    public static By byLoginButton                  = By.id(appPackageValue + "mSignUpView");
    public static By byAllPrayerTimesBtn            = By.id(appPackageValue + "txt_button_all_prayer_times");
    public static By byStartText                    = By.id(appPackageValue + "start_text");
    public static By bySkipText                     = By.id(appPackageValue + "skips_txt");

    //PrayerLoggingLoginModalLocators
    public static By byModalSignUp          = By.id(appPackageValue + "btn_sign_up");
    public static By byModalNotYet          = By.id(appPackageValue + "btn_not_yet");
    public static By byModalText            = By.id(appPackageValue + "txt_share_feedback");
    public static By byPrayerBarText        = By.id(appPackageValue + "txt_section");
    public static By byLoginModalText       = By.xpath("/hierarchy/android.widget.FrameLyout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView");
    public static String startMesage        = "Build your prayer habits with Athan!";



//On-boarding Activity Functions

    public void tapSkipButton()
    {
        webDriverFactory.getDriver().findElement(bySkipText).click();
    }

    public void clickContinueButton()
    {
        webDriverWaits.visibilityOfElementLocated(byContinueButton);
        webDriverFactory.getDriver().findElement(byContinueButton).click();
    }

    public void waitUntilLoaderStops()
    {
        webDriverWaits.invisibilityOfElementLocated(byLoader);
    }


    public void clickGetMyLocationButton(){

        webDriverFactory.getDriver().findElement(byOnBoardingButtons).click();
    }

    public void clickNextButton()
    {
        webDriverWaits.sleep(2000);
        MobileElement next = webDriverFactory.getDriver().findElement(byOnBoardingButtons);
        next.click();

    }

    public void tapCrossIcon()
    {
        webDriverWaits.visibilityOfElementLocated(byImageCrossIcon);
        webDriverFactory.getDriver().findElement(byImageCrossIcon).click();
    }

    public void verifyProfileLogoDisplayed()
    {
        MobileElement profileLogo = webDriverFactory.getDriver().findElement(byProfileLogo);
        Assert.assertTrue(profileLogo.isDisplayed());
    }

    public void verifyHomeScreen()
    {
        logActualResult("Verify user is redirected to home screen");

        MobileElement text = webDriverFactory.getDriver().findElement(byAllPrayerTimesBtn);
        Assert.assertTrue(text.isDisplayed());

        logExpectedResult("Home screen successfully verified, prayer times link displayed");

    }

    public void launchApplication()
    {
        tapSkipButton();
        clickContinueButton();
        clickGetMyLocationButton();
        MainCall.commonLocators.clickAllowPrompt();
        MainCall.commonLocators.clickOKPrompt();
        clickNextButton();
        clickNextButton();
        tapCrossIcon();
        MainCall.commonLocators.clickOKPrompt();
        verifyProfileLogoDisplayed();
        verifyHomeScreen();
    }


    //Login  low level Functions
    public void tapProfileLogo()
    {
        webDriverFactory.getDriver().findElement(byProfileLogo).click();

    }

    public void verifyStartMessage()
    {
        String text = webDriverFactory.getDriver().findElement(byStartText).getText();
        Assert.assertEquals(text,startMesage,"Login screen message not shown");
    }

    public void enterLoginDetails(String email, String pass)
    {
        webDriverFactory.getDriver().findElement(byEmail).sendKeys(email);
        webDriverFactory.getDriver().findElement(byPassword).sendKeys(pass);
    }

    public void tapLoginButton()  {
        MobileElement loginBtn = webDriverFactory.getDriver().findElement(byLoginButton);
        Assert.assertTrue(loginBtn.isDisplayed());
        loginBtn.click();
    }

    public String verifyIfAlreadyLoggedIn()
    {
        String text = "";
        try {

            text = webDriverFactory.getDriver().findElement(byPrayerBarText).getText();


        }
        catch (NoSuchElementException e)
        {

        }

        return text;
    }

//Login High level Function

    public void loginIntoApp(String email, String pass)
    {
        if (!verifyIfAlreadyLoggedIn().equals("Prayer Goals"))
        {
            verifyStartMessage();
            enterLoginDetails(email, pass);
            tapLoginButton();
            MainCall.commonLocators.alertLoaderStops();
        }

        else
            MainCall.commonLocators.tapBackIcon();
    }

}
