package Config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")

public class ApplicationConfigReader {

    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    @Property(value = "platformName")
    private String platformName;

    @Property(value = "platformVersion")
    private String platformVersion;

    @Property(value = "deviceName")
    private String deviceName;

    @Property(value = "automationName")
    private String automationName;

    @Property(value = "Environment")
    private String Environment;

    @Property(value = "dbUrl")
    private String dbUrl;

    @Property(value = "dbUserName")
    private String dbUserName;

    @Property(value = "dbPassword")
    private String dbPassword;

    @Property(value = "appPath")
    private String appPath;

    @Property(value = "packageName")
    private String packageName;

    @Property(value = "userName")
    private String userName;

    @Property(value = "userPassword")
    private String password;

    @Property(value = "appActivity")
    private String appActivity;

    @Property(value = "appPackage")
    private String appPackage;

    @Property(value = "appPackageValue")
    private String appPackageValue;
    @Property(value = "To")
    private String[] To;

    @Property(value = "SendEmailAfterExecution")
    private String SendEmailAfterExecution;

    @Property(value = "From")
    private String From;

    @Property(value = "FromPassword")
    private String FromPassword;

    @Property(value = "ProjectDescription")
    private String ProjectDescription;


    public String getappActivity() { return appActivity; }

    public String getappPackage() {
        return appPackage;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getAppPath() {
        return appPath;
    }

    public String getEnvironment() {
        return Environment;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getPackageName() {
        return packageName;
    }

    public String appPackageValue() {
        return appPackageValue;
    }
    public String[] getTo()
    {
        return To;
    }
    public String getFromEmail()
    {
        return From;
    }
    public String getFromPassword()
    {
        return FromPassword;
    }
    public String getSendEmailAfterExecution()
    {
        return SendEmailAfterExecution;
    }
    public String getProjectDescription()
    {
        return ProjectDescription;
    }

}
