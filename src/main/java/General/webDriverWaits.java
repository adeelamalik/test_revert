package General;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class webDriverWaits {
    public static WebDriverWait wait = new WebDriverWait(webDriverFactory.getDriver(),20);

    public static WebElement fluentWait(final WebElement locator, int timeout){

        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriverFactory.getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void visibilityOfElementLocated( By locator )
    {
       new WebDriverWait(webDriverFactory.getDriver(), 50).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void invisibilityOfElementLocated( By locator )
    {
        new WebDriverWait(webDriverFactory.getDriver(), 50).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void elementToBeClickable( By locator )
    {
        new WebDriverWait(webDriverFactory.getDriver(),50).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitUntilElementIsClickable( WebElement webElement)
    {
        webElement = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public static void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }





    public static boolean waitForElToBeAppeared(String element) {
        try {
            webDriverFactory.getDriver().manage().timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);

            WebDriverWait wait = new WebDriverWait(webDriverFactory.getDriver(), 1000, 7000);

            return wait
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public static void waitUntilElementVisible(By locator){
        new WebDriverWait(webDriverFactory.getDriver(), 50).until(ExpectedConditions.visibilityOfElementLocated(locator)); // wait for Loading panel to close
    }

    public static WebElement waitUntilElementNotDisplayed(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriverFactory.getDriver(), TIMEOUT);
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    webElement.isDisplayed();
                    return true;
                }
                catch (NoSuchElementException e ) {
                    return false;
                }
            }
        };
        wait.until(elementIsDisplayed);
        return webElement;
    }

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleep250(){
        sleep(250);
    }
    public static void sleep500(){
        sleep(500);
    }
    public static void sleep1000(){
        sleep(1000);
    }

}
