package Testcases.screens;

import Config.ApplicationConfigReader;
import Config.configProperties;
import General.GenericFunctions;
import General.webDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class droobiLoginView extends GenericFunctions {


    public By txtPhoneNumber=By.id(""+ configProperties.appPackageValue +"id/etPhoneNumber");
    public By txtPassword=By.id(""+configProperties.appPackageValue+"id/etPassword");
    public By txtName=By.id(""+configProperties.appPackageValue+"id/etName");
    public By btnWithoutCode=By.id(""+configProperties.appPackageValue+"id/btnWithoutCode");
    public By btnWithCode=By.id(""+configProperties.appPackageValue+"id/btnWithCode");
    public By checkBoxTerms=By.id(""+configProperties.appPackageValue+"id/chTerms");
    public By labelTerms=By.id(""+configProperties.appPackageValue+"id/tvTerms");

    public By btnSignUp=By.id(""+configProperties.appPackageValue+"id/btnSignUp");
    public By btnSignIn=By.id(""+configProperties.appPackageValue+"id/btnSignIn");
    public By togglePassword=By.id(""+configProperties.appPackageValue+"id/text_input_password_toggle");
    public By loginButton=By.id(""+configProperties.appPackageValue+"id/login_login_btn");
    public By lblSignIn = By.xpath("//*[@text = 'Sign in']");

    public By cmbFlag=By.id(""+configProperties.appPackageValue+"id/flag");


    public By popMessage=By.id("android:id/message");
    public By lblError=By.id(""+configProperties.appPackageValue+"id/textinput_error");



}
