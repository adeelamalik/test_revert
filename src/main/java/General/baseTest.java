package General;

import Testcases.loginTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.venturedive.base.database.connection.SonarDB;
import com.venturedive.base.exception.APIException;
import com.venturedive.base.utility.JIRA;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.LogHelper;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static Config.configProperties.platformName;
import static emailSetup.SendEmailAfterExecution.sendReportAfterExecution;

public class baseTest extends LogHelper {


    SonarDB dbconn= new SonarDB();   // need to open after jira integration

    static Date startTime = null;
    static Date endTime = null;
    static Integer passedCount = 0;
    static Integer failedCount = 0;
    static Integer skippedCount = 0;
    public static ArrayList<String> automationSteps;
    static Integer beforeAddingStepsLength;
    static Integer afterAddingStepsLength;
    static Integer beforeAddingExpectedResultLength;
    static Integer afterAddingExpectedResultLength;
    public static ArrayList<String> expectedResults;
    static ArrayList<File> screenShotCollection = new ArrayList<File>();

    private static ExtentTest extentLogger;
    //public static RequestSpecification REQUEST;


    @BeforeSuite()
    public void startReport() throws IOException {

        MainCall.startReport();
        webDriverFactory.startDriver();
        startTime = getTime();
        automationSteps = new ArrayList<String>();
        expectedResults=new ArrayList<String>();

    }

    @BeforeMethod()
    public void beforeTest(Method method) throws IOException {
        beforeAddingStepsLength=automationSteps.size();
        beforeAddingExpectedResultLength=expectedResults.size();
        System.out.println("before"+beforeAddingStepsLength);
        System.out.println("before"+beforeAddingExpectedResultLength);

        extentLogger = MainCall.getExtentReport().startTest(method.getName(), "");
        extentLogger.setStartedTime(getTime());

    }

    @AfterMethod()
    public void QuitDriver(ITestResult result, ITestContext ctx, Method method) throws IOException, com.venturedive.base.exception.APIException {

        afterAddingStepsLength=automationSteps.size();
        afterAddingExpectedResultLength=expectedResults.size();
        System.out.println("After Actual"+afterAddingStepsLength);
        System.out.println("After Expected"+afterAddingExpectedResultLength);
        try
        {
            if (result.getStatus() == ITestResult.FAILURE) {
                failedCount++;
                extentLogger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
                extentLogger.log(LogStatus.FAIL, extentLogger.addScreenCapture(screenshots.takeScreenshot(result.getMethod().getMethodName())));
                screenShotCollection.add(screenshots.screenShot);

                JIRA.CreateJiraWithScreenShot(result,screenshots.screenShot , beforeAddingStepsLength, afterAddingStepsLength, automationSteps);
                JIRA.PostMobileIssuesJira();
            }
            else if (result.getStatus() == ITestResult.SKIP) {
                skippedCount++;
                extentLogger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
            }
            else {
                passedCount++;
                extentLogger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");
            }
            extentLogger.setEndedTime(getTime());
            MainCall.getExtentReport().endTest(extentLogger);
        }

        finally {}
        com.venturedive.base.utility.TestRail.getCaseIdandResultmobile(result, ctx, method , beforeAddingStepsLength, afterAddingStepsLength, automationSteps, beforeAddingExpectedResultLength, afterAddingExpectedResultLength,expectedResults);
    }

    private Date getTime()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    @AfterSuite()
    public void endReport() throws SQLException, IOException, APIException, com.venturedive.base.exception.APIException, MessagingException {
//        webDriverFactory.finishDriver();
//        MainCall.getExtentReport().flush();
//        MainCall.getExtentReport().close();
        endTime = getTime();
//        com.venturedive.base.utility.TestRail.createSuite();
//        com.venturedive.base.utility.TestRail.updateTestRail();
//        com.venturedive.base.utility.TestRail.AttachImagesWithTestResults(screenShotCollection);
        sendReportAfterExecution();
//        sendReportAfterExecution(passedCount,failedCount,skippedCount);

        dbconn.insertReportingDataIntoDB(startTime, passedCount, failedCount, skippedCount, startTime, endTime); //need to open after jira integration

    }
}
