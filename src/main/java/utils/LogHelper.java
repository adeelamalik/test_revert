package utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.io.File;

import static General.baseTest.automationSteps;
import static General.baseTest.expectedResults;


public class LogHelper {
//    private static Logger log = LogManager.getLogger("### "); //Concatenate project name here as well for logging (From Config File)
//    final Level VERBOSE = Level.forName("VERBOSE", 200);

    // Create a Logger
    private   static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(org.apache.log4j.Logger.class);

    public String log4jConfigFile = System.getProperty("user.dir")
            + File.separator + "log4j.xml";

    protected void logInfo(String comment) {
        log.info(comment + "\n");
    }

    public static void logStep(String comment) {
        log.info("STEP: " + comment + "\n");
        // WebDriverFactory.saveAllureScreenshot();
    }

    protected void logVerifyTrue(Object expected, Object actual,String comment) {
        log.info(comment + "\n");
        Assert.assertEquals(expected, actual,comment);

    }

    protected void logVerifyContains(String actual, String expected,String comment) {
        log.info(comment + "\n");
        Assert.assertTrue(actual.contains(expected),comment);

    }

    protected void logVerifyTrue(Object[] actual, Object[] expected,String comment) {
        log.info(comment + "\n");
        for(int i=0;i<actual.length;i++)
            Assert.assertEquals(expected[i], actual[i],comment);

    }

    protected void logVerifyTrue( Object actual,String comment) {
        log.info(comment + "\n");
        Assert.assertEquals(true,actual,comment);
    }

    protected void logVerifyFalse(Object actual,String comment) {
        log.info(comment + "\n");
        Assert.assertEquals(false,actual,comment);
    }

    protected void logVerifyFalse(Object actual, Object expected,String comment) {
        log.info(comment+ "\n");
        Assert.assertFalse(actual.equals(expected),comment);
    }

    protected void logVerifyNull(Object actual,String comment) {
        log.info(comment+ "\n");
        Assert.assertNull(actual,comment);
    }

    protected void logVerifyNotNull(Object actual,String comment) {
        log.info(comment+ "\n");
        Assert.assertNotNull(actual,comment);
    }
    public static void logActualResult(String Comment)

    {
        log.info(Comment);
        automationSteps.add(Comment);

    }
    public static void logExpectedResult(String Commeent)
    {

        log.info(Commeent);
        expectedResults.add(Commeent);

    }

}

