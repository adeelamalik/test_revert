package General;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GenericFunctions {


    public static By byNextDate                = By.id("android:id/next");
    public static By bySelectNextDate          = By.xpath("//android.view.View[@text='14']");
    public static By byDateOkBtn               = By.id("android:id/button1");



    public static void selectCalenderDate()
    {
        webDriverFactory.getDriver().findElement(byNextDate).click();
        webDriverFactory.getDriver().findElement(bySelectNextDate).click();
        webDriverFactory.getDriver().findElement(byDateOkBtn).click();
    }

    //Fetch Day
    public static String getDayFromDate() {

        Date now = new Date();

//        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
//        System.out.println(simpleDateformat.format(now));

        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        return simpleDateformat.format(now);

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // the day of the week in numerical format

    }


    //Set device time to any date
    public static void setEmulatorTime(String command) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder();

        // -- Linux --

        // Run a shell command
        processBuilder.command("bash", "-c", command);

        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
//        processBuilder.command("cmd.exe", "/c", command);

        // Run a bat file
        //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success! Time changed to"+ " " +envGlobals.dateToSet);
                System.out.println(output);
//                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    //Generate Random String
      public static String generateRandomString(int length) {
        String name = RandomStringUtils.randomAlphabetic(length);
        String first_letter = name.substring(0, 1).toUpperCase();
        String other_letters = name.substring(1).toLowerCase();
        String finalname = "dummyKey" + first_letter + other_letters;
        return finalname;
    }
    public static void sendKeysFunction(By fieldLocator, String fieldText)
    {
        webDriverWaits.elementToBeClickable(fieldLocator);
        webDriverFactory.getDriver().findElement(fieldLocator).sendKeys(fieldText);
    }
    public static String fetchText(By fieldLocator)
    {
        webDriverWaits.elementToBeClickable(fieldLocator);
        return webDriverFactory.getDriver().findElement(fieldLocator).getText();
    }

    public static void clearFieldFunction(By fieldLocator)
    {
        webDriverWaits.elementToBeClickable(fieldLocator);
        webDriverFactory.getDriver().findElement(fieldLocator).clear();
    }
    public static void clickFunction(By element)
    {
        webDriverWaits.elementToBeClickable(element);
        webDriverFactory.getDriver().findElement(element).click();
    }


    public static void navigateBack()
    {
        webDriverFactory.getDriver().navigate().back();
        logger.Log.info("Navigated Back from previous Screen");
    }

    public static void closeKeyboard()
    {
        webDriverFactory.getDriver().hideKeyboard();
    }


    public static void MobileCheckbox(By checkBoxLocator, String status)
    {
        MobileElement element =  webDriverFactory.getDriver().findElement(checkBoxLocator);
        String checkbox = element.getAttribute("checked");
        //    CommonAssertions.logInfo(checkbox);

        if(status.equals("checked") || status.equals("Checked"))
        {
            if(checkbox.equals("false"))
            {
                GenericFunctions.clickFunction(checkBoxLocator);
            }
        }
        else if(status.equals("unchecked") || status.equals("Unchecked"))
        {
            if(checkbox.equals("false"))
            {
                GenericFunctions.clickFunction(checkBoxLocator);
            }

        }
    }

    public static void verticalScroll() {
        Dimension size = webDriverFactory.getDriver().manage().window().getSize();
        int y_start = (int) (size.height * 0.60);
        int y_end = (int) (size.height * 0.30);
        int x = size.width / 2;
        webDriverFactory.getDriver().swipe(x, y_start, x, y_end, 3000);

    }

    public static void performSearchThroughSearchBar(String Text , By searchlocator ,By searchResults)
    {
        sendKeysFunction(searchlocator,Text);
        webDriverWaits.visibilityOfElementLocated(searchResults);
        clickFunction(searchResults);

    }

    public static void tapAction(int xTapped, int yTapped)
    {
        webDriverWaits.sleep(2000);
        TouchAction touchAction = new TouchAction(webDriverFactory.getDriver());

        touchAction.tap(xTapped, (yTapped)).perform();
        webDriverWaits.sleep(2000);
    }

    public static void selectOverLoop(List<MobileElement> valueOfTheList , String option)
    {
        // List<MobileElement> radioButtons = webDriverFactory.getDriver().findElements(radioButtononAddWomanScreen);
//        System.out.println("Length of Radio buttons arary\n" + radioButtons.size());
        for (int i = 0; i < valueOfTheList.size(); i++) {
            if (valueOfTheList.get(i).getText().equals(option)) {
                webDriverWaits.sleep(2000);
                valueOfTheList.get(i).click();
                break;
            }
        }
        logger.Log.info("Radio Button "+option+" has been clicked");
    }

    public static void offTheNet()
    {
        webDriverFactory.getDriver().getSettings();
    }

}


