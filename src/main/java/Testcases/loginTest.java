package Testcases;

import General.MainCall;
import General.baseTest;
import General.envGlobals;
import General.webDriverFactory;
import org.testng.annotations.Test;

public class loginTest extends baseTest {

    @Test
    public static void applicationLaunch() {
        if (webDriverFactory.getDevice().equals("iOS"))
        {
            MainCall.login.launchApplication();

        } else {
            MainCall.loginView.launchApplication();
        }
        logStep("Testcase Application launched successfully executed");
    }

    @Test
    public static void loginIntoAthanApp()
    {
        if (webDriverFactory.getDevice().equals("iOS")) {
            MainCall.login.verifyHomeScreen();
            MainCall.login.loginIntoApp(envGlobals.userLoginEmail, envGlobals.userLoginPassword);

        } else {

            MainCall.loginView.verifyHomeScreen();
            MainCall.loginView.tapProfileLogo();
            MainCall.loginView.loginIntoApp(envGlobals.userLoginEmail, envGlobals.userLoginPassword);

        }
        logStep("Test case login user into application successfully executed");
    }


}
