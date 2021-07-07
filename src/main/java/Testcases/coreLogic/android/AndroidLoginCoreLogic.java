package Testcases.coreLogic.android;

import General.GenericFunctions;
import General.baseTest;
import General.webDriverFactory;
import General.webDriverWaits;
import Testcases.coreLogic.base.LoginCoreLogic;
import Testcases.screens.droobiLoginView;
import logger.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * contains all methods to login on android app
 */
public class AndroidLoginCoreLogic extends baseTest {

    /**
     * method to login to android app
     *
     * @param userName emailId to be used for login
     * @param password - valid password
     */

    droobiLoginView login = new droobiLoginView();

    //@Test
    public void verifyLoginScenarioWhenCredentialsAreCorrect() throws InterruptedException {
        GenericFunctions.clickFunction(login.lblSignIn);
        GenericFunctions.sendKeysFunction(login.txtPhoneNumber,"3323761318");
        GenericFunctions.sendKeysFunction(login.txtPassword,"ABCabc@123");
        GenericFunctions.clickFunction(login.btnSignIn);
    }

    @Test
    public void verifyLoginScenarioWhenIncorrectPhoneNumber() throws InterruptedException {
        GenericFunctions.clickFunction(login.lblSignIn);
        GenericFunctions.sendKeysFunction(login.txtPhoneNumber,"9999999999");
        GenericFunctions.sendKeysFunction(login.txtPassword,"ABCabc@123");
        GenericFunctions.clickFunction(login.btnSignIn);
        webDriverWaits.sleep(5000);
        Assert.assertEquals(GenericFunctions.fetchText(login.popMessage).replaceAll("\\s+", ""),"Sorry, that’s the wrong password. Contact your system admin for more details.".replaceAll("\\s+", ""));
        Assert.assertFalse(true);

    }

    @Test
    public void verifyLoginScenarioWhenIncorrectPassword() throws InterruptedException {
        GenericFunctions.clickFunction(login.lblSignIn);
        GenericFunctions.sendKeysFunction(login.txtPhoneNumber,"3323761318");
        GenericFunctions.sendKeysFunction(login.txtPassword,"Invalid@999");
        GenericFunctions.clickFunction(login.btnSignIn);
        webDriverWaits.sleep(5000);
        Assert.assertEquals(GenericFunctions.fetchText(login.popMessage).replaceAll("\\s+", ""),"Sorry, that’s the wrong password. Contact your system admin for more details.".replaceAll("\\s+", ""));
    }

    @Test
    public void verifyLoginScenarioWhenPhoneNumberIsEmpty() throws InterruptedException {
        GenericFunctions.clickFunction(login.lblSignIn);
        GenericFunctions.sendKeysFunction(login.txtPhoneNumber,"");
        GenericFunctions.sendKeysFunction(login.txtPassword,"Invalid@999");
        GenericFunctions.clickFunction(login.btnSignIn);
        Assert.assertEquals(GenericFunctions.fetchText(login.lblError).replaceAll("\\s+", ""),"Oops - that doesn’t look like a mobile number. Please try again.".replaceAll("\\s+", ""));
    }

    @Test
    public void verifyLoginScenarioWhenPasswordIsEmpty() throws InterruptedException {
        GenericFunctions.clickFunction(login.lblSignIn);
        GenericFunctions.sendKeysFunction(login.txtPhoneNumber,"3323761318");
        GenericFunctions.sendKeysFunction(login.txtPassword,"");
        GenericFunctions.clickFunction(login.btnSignIn);
        Assert.assertEquals(GenericFunctions.fetchText(login.lblError).replaceAll("\\s+", ""),"Please enter your password".replaceAll("\\s+", ""));
    }


    @Test
    public void verifySignUpScenario() throws InterruptedException {
        GenericFunctions.clickFunction(login.btnWithoutCode);
        GenericFunctions.sendKeysFunction(login.txtName,"Test Automation");
        GenericFunctions.sendKeysFunction(login.txtPhoneNumber,"3323761318");
        GenericFunctions.sendKeysFunction(login.txtPassword,"ABCabc@123");
        GenericFunctions.clickFunction(login.btnSignUp);
    }

    @Test
    public void verifyPasswordToggle() throws InterruptedException {
        GenericFunctions.clickFunction(login.lblSignIn);
        GenericFunctions.sendKeysFunction(login.txtPhoneNumber,"3323761318");
        GenericFunctions.sendKeysFunction(login.txtPassword,"SomeText");
        System.out.println("this:"+GenericFunctions.fetchText(login.txtPassword));

        GenericFunctions.clickFunction(login.togglePassword);
        System.out.println("this:"+GenericFunctions.fetchText(login.txtPassword));

    }
    @Test
    public void trying() throws InterruptedException {
        Assert.assertTrue(true);
    }
}

