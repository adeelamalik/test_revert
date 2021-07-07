package PageObject.Android;

import General.MainCall;
import General.envGlobals;
import General.webDriverFactory;
import General.webDriverWaits;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

import static Config.configProperties.appPackageValue;
import static General.MainCall.commonLocators;
import static utils.LogHelper.logStep;

public class commonLocatorsView {

    public static By byMoreTabElements = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget" +
            ".LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]" +
            "/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview" +
            ".widget.RecyclerView/android.widget.FrameLayout");


    public static By byBackIcon                = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    public static By byHomeIcon                = By.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.ImageView");
    public static By byMoreIcon                = By.xpath("//android.widget.FrameLayout[@content-desc=\"More\"]/android.widget.ImageView");
    public static By byDoneButton              = By.xpath("//android.widget.Button[@text='DONE']");
    public static By byCancelButton            = By.xpath("//android.widget.Button[@text='CANCEL']");
    public static By byPageText                = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                                                "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/" +
                                                "android.widget.TextView");
    public static By byOKPromptButton          =By.id("android:id/button1");
    public static By byAlertMessage            =By.id("android:id/message");
    public static By byAlertLoader             =By.id("android:id/progress");
    public static By byGreetMessage            =By.id(appPackageValue + "txt_user_name");
    public static By byUserName                =By.id(appPackageValue + "txt_business_name");
    public static By byTextView                =By.className("android.widget.TextView");

    public static By byAllowPromptButton        =By.id("com.android.packageinstaller:id/permission_allow_button");


    public void tapMoreTabElement(String elementName)
    {
        List<MobileElement> moreTabElements = webDriverFactory.getDriver().findElements(byMoreTabElements);
        for (MobileElement moreTabElement: moreTabElements)
        {
            if(moreTabElement.findElement(byTextView).getText().trim().equals(elementName))
            {
                webDriverWaits.elementToBeClickable(byTextView);
                moreTabElement.click();
                break;
            }

        }
    }


    public void tapDoneButton()
    {
        MobileElement footerDoneButton = webDriverFactory.getDriver().findElement(byDoneButton);
        footerDoneButton.click();
    }


    public void tapCancelButton()
    {
        MobileElement footerCancelButton = webDriverFactory.getDriver().findElement(byCancelButton);
        footerCancelButton.click();
    }

    public void tapBackIcon()
    {
        webDriverWaits.sleep(1200);
        MobileElement backIcon = webDriverFactory.getDriver().findElement(byBackIcon);
        backIcon.click();
        webDriverWaits.sleep(1200);
    }

    public void tapMoreIcon()
    {
        WebElement moreIcon = webDriverFactory.getDriver().findElement(byMoreIcon);
        webDriverWaits.waitUntilElementIsClickable(moreIcon);
        moreIcon.click();
    }

    public void tapHomeIcon()
    {
        WebElement homeIcon =webDriverFactory.getDriver().findElement(byHomeIcon);
        webDriverWaits.waitUntilElementIsClickable(homeIcon);
        homeIcon.click();
    }

    public void clickOKPrompt()
    {
        try {
            webDriverFactory.getDriver().findElementById("android:id/button1").click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void clickAllowPrompt()
    {
        webDriverFactory.getDriver().findElement(byAllowPromptButton).click();
    }

    public void verifyAlertMessage(String message)
    {
        MobileElement alert = webDriverFactory.getDriver().findElement(byAlertMessage);
        String text = alert.getText();
        Assert.assertEquals(text,message,"No alert shown or alert message is different");

    }


    public void alertLoaderStops()
    {
        webDriverWaits.invisibilityOfElementLocated(byAlertLoader);
    }

    public void verifyScreenHeading(String heading)
    {
        String pageName = webDriverFactory.getDriver().findElement(byPageText).getText();
        Assert.assertEquals(pageName,heading,"User navigated to wrong screen");
    }

    public void goToScreenFromHome(String screen)
    {
        tapMoreIcon();
        tapMoreTabElement(screen);
    }

    public void backToHomeScreen()
    {
        tapBackIcon();
        tapHomeIcon();
    }

    public void goBackToAnyScreen(String screen)
    {
        MainCall.commonLocators.tapBackIcon();
        MainCall.commonLocators.tapMoreTabElement(screen);
    }

    public void verifyUserLogOut()
    {
        tapMoreIcon();

        String name = webDriverFactory.getDriver().findElement(byUserName).getText();
        Assert.assertEquals(name,"Log your prayers","User not successfully logged out");

        commonLocators.tapBackIcon();
    }

    public void verifyUserLogIn()
    {
        tapMoreIcon();

        String name = webDriverFactory.getDriver().findElement(byUserName).getText();
        Assert.assertFalse(name.equals("Log your prayers"),"User not successfully logged in");

        commonLocators.tapBackIcon();
    }






}
