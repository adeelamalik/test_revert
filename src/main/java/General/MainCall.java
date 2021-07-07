package General;



import PageObject.Android.*;
import PageObject.iOS.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import dbconnection.dbConn;

import static Config.configProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    static ExtentTest test;

    public static ExtentReports startReport(){
        extent = new ExtentReports(System.getProperty("user.dir") +"/reports/ExtentReport.html", true);
        extent.addSystemInfo("Environment", String.valueOf(Environment));;
        return extent;
    }

    public static ExtentReports getExtentReport(){
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }


//    public final static webDriverWaits webDriverWait = new webDriverWaits();

    public final static dbConn DbConn = new dbConn();
    public final static basicFlows basicFlows = new basicFlows();

    public final static loginView loginView = new loginView();
    public final static login login = new login();

    public final static prayerTimesView prayerTimesView = new prayerTimesView();
    public final static appSettingsView appSettingsView = new appSettingsView();

    public final static appSettings appSettings = new appSettings();
    public final static prayerTimes prayerTimes = new prayerTimes();

    public final static commonLocatorsView commonLocators = new commonLocatorsView();
    public final static commonLocators commonLocatorsIOS = new commonLocators();

    public final static GenericFunctions genericFunctions = new GenericFunctions();




}

