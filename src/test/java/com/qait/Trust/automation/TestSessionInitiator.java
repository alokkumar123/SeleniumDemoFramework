package com.qait.Trust.automation;

import static com.qait.Trust.automation.utils.ConfigPropertyReader.getProperty;

import com.qait.Trust.automation.utils.TakeScreenshot;
import static com.qait.Trust.automation.utils.YamlReader.getYamlValue;
import static com.qait.Trust.automation.utils.YamlReader.setYamlFilePath;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import org.openqa.selenium.Dimension;

public class TestSessionInitiator {

    protected WebDriver driver;
    private final WebDriverFactory wdfactory;
    public static HashMap<String, String> configSettings;
    DesiredCapabilities capabilities;
    String browser;
    String seleniumserver;
    String seleniumserverhost;
    String appbaseurl;
    String applicationpath;
    String chromedriverpath;
    String datafileloc = "";
    static int timeout;
    Map<String, Object> chromeOptions = null;

    /**
     * Initiating the page objects
     *
     */
    
    public TakeScreenshot takescreenshot;

    public WebDriver getDriver() {
        return this.driver;
    }

    private void _initPage() {
        
    }

    /**
     * Page object Initiation done
     *
     */
    public TestSessionInitiator(String testname) {
        wdfactory = new WebDriverFactory();
        testInitiator(testname);
    }

    public TestSessionInitiator(String testname, int xAxis, int yAxis) {
        wdfactory = new WebDriverFactory();
        testInitiator(testname, xAxis, yAxis);
    }

    private void testInitiator(String testname) {
        setYamlFilePath();
        _configureBrowser();
        _initPage();
        takescreenshot = new TakeScreenshot(testname, this.driver);
    }

    private void testInitiator(String testname, int xAxis, int yAxis) {
        setYamlFilePath();
        _configureBrowser(xAxis, yAxis);
        _initPage();
        takescreenshot = new TakeScreenshot(testname, this.driver);
    }

    private void _configureBrowser() {
        driver = wdfactory.getDriver(_getSessionConfig());
        driver.manage().window().maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(Integer.parseInt(getProperty("timeout")),
                        TimeUnit.SECONDS);
    }

    private void _configureBrowser(int xAxis, int yAxis) {
        driver = wdfactory.getDriver(_getSessionConfig());
        driver.manage().window().setSize(new Dimension(xAxis, yAxis));
        driver.manage()
                .timeouts()
                .implicitlyWait(Integer.parseInt(getProperty("timeout")),
                        TimeUnit.SECONDS);
    }

    private Map<String, String> _getSessionConfig() {
        String[] configKeys = {"tier", "browser", "seleniumserver",
            "seleniumserverhost", "timeout", "driverpath"};
        Map<String, String> config = new HashMap<String, String>();
        for (String string : configKeys) {
            config.put(string, getProperty("./Config.properties", string));
        }
        return config;
    }

    public void launchApplication() {
        launchApplication(getYamlValue("app_url"));
    }

    public void launchApplication(String baseurl) {
        Reporter.log("\nThe application url is :- " + baseurl, true);
        Reporter.log("The test browser is :- " + _getSessionConfig().get("browser") + "\n", true);
        driver.manage().deleteAllCookies();
        driver.get(baseurl);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void closeBrowserSession() {
        Reporter.log("\n", true);
        driver.quit();
    }

    public void stepStartMessage(String testStepName) {
        Reporter.log(" ", true);
        Reporter.log("***** STARTING TEST STEP:- " + testStepName.toUpperCase()
                + " *****", true);
        Reporter.log(" ", true);
    }
    
}
