package PageObject.iOS;

import General.MainCall;
import General.baseTest;
import General.webDriverFactory;
import General.webDriverWaits;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

import java.util.List;

import static General.MainCall.commonLocatorsIOS;

public class commonLocators extends baseTest
{


    public commonLocators(){}

    public String moreScreenElements  = "//XCUIElementTypeApplication[@name=\"Athan\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther//XCUIElementTypeCell";
    public String textView = "//XCUIElementTypeStaticText";
    public static String moreButton = "//XCUIElementTypeButton[@name=\"More\"]";
    public static String homeButton = "//XCUIElementTypeButton[@name=\"Home\"]";
    public static String backButton = "Back";
    public static String doneButton = "Done";
    public static String keyboardDone = "Toolbar Done Button";
    public static String keyboardNext = "Toolbar Next Button";
    public static String cancelButton = "Cancel";
    public static String modalYes = "Yes";
    public static String modalNo = "No";
    public static String btnOK = "OK";
    public static String modalMessage = "//XCUIElementTypeStaticText[@name=\"Are you sure you want to sign out?\"]";




    //iOS Function
    public void tapMoreScreenElement(String elementName)
    {
        List<MobileElement> moreTabElements = webDriverFactory.getDriver().findElementsByXPath(moreScreenElements);
        for (MobileElement moreTabElement: moreTabElements)
        {
            if(moreTabElement.findElementByXPath(textView).getText().trim().equals(elementName))
            {
                moreTabElement.click();
                break;
            }

        }
    }

    public static void tapMoreViewButton()
    {
        webDriverWaits.sleep1000();
        webDriverFactory.getDriver().findElementByXPath(moreButton).click();
    }
    public static void tapHomeViewButton() { webDriverFactory.getDriver().findElementByXPath(homeButton).click(); }

    public void goToScreen(String screen)
    {
//        verifyDateOnHomeScreen();

        tapMoreViewButton();
        tapMoreScreenElement(screen);
    }

    public static void tapBackIcon()
    {
        MobileElement backIcon = webDriverFactory.getDriver().findElementByAccessibilityId(backButton);
        backIcon.click();
    }
    public static void tapDoneIcon()
    {
        MobileElement doneBtn = webDriverFactory.getDriver().findElementByAccessibilityId(doneButton);
        webDriverWaits.visibilityOf(doneBtn);
        doneBtn.click();
    }
    public static void tapCancelIcon()
    {
        MobileElement cancelBtn = webDriverFactory.getDriver().findElementByAccessibilityId(cancelButton);
        webDriverWaits.visibilityOf(cancelBtn);
        cancelBtn.click();
    }

    public void goBackToAnyScreen(String screen)
    {
        commonLocatorsIOS.tapBackIcon();
        commonLocatorsIOS.tapMoreScreenElement(screen);
    }

    public static void keyboardDoneBtn()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(keyboardDone).click();
        logStep("User taps on done button on device keyboard");
    }

    public static void keyboardNextBtn()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(keyboardNext).click();
        logStep("User tap on below icon on device keyboard ");
    }

    public static void tapModalYes()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(modalYes).click();
    }

    public static void tapModalNo()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(modalNo).click();
    }

    public static void verifyModalMessage()
    {
        String message = webDriverFactory.getDriver().findElementByXPath(modalMessage).getAttribute("value");
        Assert.assertEquals(message,"Are you sure you want to sign out?","SignOut modal message different or not shown");


    }

    public void backToHome()
    {
        commonLocatorsIOS.tapBackIcon();
        commonLocatorsIOS.tapHomeViewButton();
    }

    public static void tapOK()
    {
        webDriverFactory.getDriver().findElementByAccessibilityId(btnOK).click();
    }

}
