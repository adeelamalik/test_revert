package General;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import static General.webDriverFactory.driver;

public class basicFlows {
    public static Dimension size;

    public void swipeHorizontal(String swipe){
        size = driver.manage().window().getSize();

        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        int startx = (int) (size.width * 0.70);
        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * 0.30);
        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = size.height / 2;

        switch (swipe){
            case "Right":
            case "right":
                //Swipe from Right to Left.
                driver.swipe(startx, starty, endx, starty, 3000);

                break;
            case "Left":
            case "left":
                //Swipe from Left to Right.
                driver.swipe(endx, starty, startx, starty, 3000);

                break;
        }
    }

    public void swipeVertical(String swipe){
        size = driver.manage().window().getSize();

        //Find swipe start and end point from screen's with and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int) (size.height * 0.80);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.20);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;

        switch (swipe){
            case "Up":
            case "up":
                //Swipe from Bottom to Top.
                driver.swipe(startx, starty, startx, endy, 3000);
//                }
                break;
            case "Down":
            case "down":
                //Swipe from Top to Bottom.
                driver.swipe(startx, endy, startx, starty, 3000);
                break;
        }
    }

    public void moveBack(){
        driver.navigate().back();
    }

   public static void scrollDown(By startLocator, By endLocator )
   {

       MobileElement el0 = webDriverFactory.getDriver().findElement(startLocator);
       MobileElement el1 = webDriverFactory.getDriver().findElement(endLocator);


       TouchAction action = new TouchAction(driver);
       action.press(el0).moveTo(el1).release();

//       TouchAction action = new TouchAction(driver);
//       action.press(el0).moveTo(el1).release();

//       action.scroll(element, 10, 100);
//       action.perform();
   }

    public void swipe(){
        org.openqa.selenium.Dimension size=webDriverFactory.getDriver().manage().window().getSize();
        int width= size.width/2;
        int startPoint=(int)(size.getHeight() * 0.70);
        int endPoint=(int)(size.getHeight() * 0.20);
        int duration=6000;
        webDriverFactory.getDriver().swipe(width, startPoint, width, endPoint, duration);
    }

    public void swipeLess(){
        org.openqa.selenium.Dimension size=webDriverFactory.getDriver().manage().window().getSize();
        int width= size.width/2;
        int startPoint=(int)(size.getHeight() * 0.70);
        int endPoint=(int)(size.getHeight() * 0.20);
        int duration=2000;
        webDriverFactory.getDriver().swipe(width, startPoint, width, endPoint, duration);
    }

    public void swipeFullUpDown(int x1, int y1, int x2, int y2) {
        io.appium.java_client.TouchAction action = new io.appium.java_client.TouchAction(driver);
                action.press(945, 308)
                .moveTo(22, 1013)
                .release()
                .perform();

//        webDriverFactory.getDriver().swipe(517, 1700, 34, -1700, 200);
    }

    //Swipe by elements
    public void swipeByElements (AndroidElement startElement, AndroidElement endElement)
    {

        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(webDriverFactory.getDriver())
                .press(startX,startY)
                .waitAction(1000)
                .moveTo(endX, endY)
                .release().perform();
    }

    public static void scrollToElement(String elementText)
    {
        webDriverFactory.getDriver().findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + elementText + "\"));"));
    }

    public static void scrollUp(By locator)
    {
        webDriverFactory.getDriver().findElement(locator).swipe(SwipeElementDirection.UP, 1000);
    }

    public static void scrollDown(By locator)
    {
        webDriverFactory.getDriver().findElement(locator).swipe(SwipeElementDirection.DOWN, 1000);
    }


}
