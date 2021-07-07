package General;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class screenshots {

        public static File screenShot;
        public static  String filePath;

        public static final String takeScreenshot(String test) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_hh-mm-ss"); //windows not support colon (Bug fixing for windows users)
            Calendar now = Calendar.getInstance();

            screenShot  = ((TakesScreenshot)webDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

            filePath = System.getProperty("user.dir") + "/screenshots/" + test + "_" + formatter.format(now.getTime())+".jpg";

            try {
                FileUtil.copyFile(screenShot, new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            filePath = filePath.replace(System.getProperty("user.dir"), "..");
            return filePath;
        }
}
