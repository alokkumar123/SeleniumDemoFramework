package com.qait.mt4Platform.automation;

import static com.qait.mt4Platform.automation.utils.ConfigPropertyReader.getProperty;

import com.qait.mt4Platform.automation.utils.TakeScreenshot;
import com.qait.mt4Platform.automation.utils.AXE;
import com.qait.mt4Platform.automation.utils.HTMLCodeSniffer;
import com.qait.mt4Platform.keywords.MindTapCourseHomePageActions;
import com.qait.mt4Platform.keywords.MindTapCourseTopicViewPageActions;
import com.qait.mt4Platform.keywords.AppSplashPageActions;
import com.qait.mt4Platform.keywords.SsoLoginApiActions;

import static com.qait.mt4Platform.automation.utils.YamlReader.getYamlValue;
import static com.qait.mt4Platform.automation.utils.YamlReader.setYamlFilePath;
import com.qait.mt4Platform.keywords.CengageBrainCreateCoursePageActions;
import com.qait.mt4Platform.keywords.CengageBrainManageCoursePageActions;
import com.qait.mt4Platform.keywords.CengageBrainLoginActions;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import com.qait.mt4Platform.keywords.MindTapCourseRollingWeekViewPageActions;
import com.qait.mt4Platform.keywords.CengageBrainEditCoursePageActions;
import com.qait.mt4Platform.keywords.MindTapCourseSearchBoxPageActions;
import com.qait.mt4Platform.keywords.MindTapCourseSettingActions;
import com.qait.mt4Platform.keywords.MindTapCourseUIOfTopicViewPageActions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

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
    public SsoLoginApiActions ssoApi;
    public CengageBrainLoginActions cengageBrainLogin;
    public CengageBrainManageCoursePageActions cengageBrainManagePage;
    public CengageBrainCreateCoursePageActions cengageBrainCourseCreatePage;
    public CengageBrainEditCoursePageActions cengageBrainCourseEditPage;
    public MindTapCourseHomePageActions mindTapCourseHomePage;
    public MindTapCourseTopicViewPageActions mindTapCourseTopicView;
    public MindTapCourseRollingWeekViewPageActions mindTapCourseRollingWeekViewPage;
    public MindTapCourseSettingActions mindTapCourseSetting;
    public MindTapCourseUIOfTopicViewPageActions mindTapCourseUIOfTopicView;
    public MindTapCourseSearchBoxPageActions mindTapCourseSearchBox;

    public HTMLCodeSniffer codeSniffer;

    public AppSplashPageActions appSplashPage;
    public TakeScreenshot takescreenshot;

    public WebDriver getDriver() {
        return this.driver;
    }

    private void _initPage() {
        ssoApi = new SsoLoginApiActions(driver);
        cengageBrainLogin = new CengageBrainLoginActions(driver);
        cengageBrainManagePage = new CengageBrainManageCoursePageActions(driver);
        cengageBrainCourseCreatePage = new CengageBrainCreateCoursePageActions(driver);
        cengageBrainCourseEditPage = new CengageBrainEditCoursePageActions(driver);
        mindTapCourseHomePage = new MindTapCourseHomePageActions(driver);
        mindTapCourseTopicView = new MindTapCourseTopicViewPageActions(driver);
        mindTapCourseRollingWeekViewPage = new MindTapCourseRollingWeekViewPageActions(driver);
        mindTapCourseSetting = new MindTapCourseSettingActions(driver);
        mindTapCourseUIOfTopicView = new MindTapCourseUIOfTopicViewPageActions(driver);
        appSplashPage = new AppSplashPageActions(driver);
        mindTapCourseSearchBox = new MindTapCourseSearchBoxPageActions(driver);
        codeSniffer = new HTMLCodeSniffer(driver);
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

    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// Accessibility Test Methods ---> AXE ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    // JSONObject - Unordered list of name/value pairs is a string wrapped in curly braces 
    //              with colons between name and pairs
    // JSONArray - Ordered sequence of values is a string wrapped in square bracket 
    //              with commas separating the values  
    public void testAccessibility(String methodName, URL scriptUrl) {
        Reporter.log("\nJS Library: " + scriptUrl, true);

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue(true, "[Assertion Passed]: No violations found");
        } else {
            Reporter.log(AXE.report(violations), true);
            Assert.assertTrue(false, AXE.report(violations));
        }
    }

    public void testAccessibilityWithOptions(String methodName, URL scriptUrl) {
        Reporter.log("\nJS Library: " + scriptUrl, true);

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).
                options("{ rules: { 'accesskeys': { enabled: false } } }").analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue(true, "[Assertion Passed]: No violations found");
        } else {
            AXE.writeResults(methodName, responseJSON);
            Reporter.log(AXE.report(violations), true);
            Assert.assertTrue(false, AXE.report(violations));
        }
    }

    public void testAccessibilityWithSelector(String methodName, URL scriptUrl) {
        Reporter.log("\nJS Library: " + scriptUrl, true);

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).
                include("title").include("p").analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue(true, "[Assertion Passed]: No violations found");
        } else {
            AXE.writeResults(methodName, responseJSON);
            Reporter.log(AXE.report(violations), true);
            Assert.assertTrue(false, AXE.report(violations));
        }
    }

    public void testAccessibilityWithIncludesAndExcludes(String methodName, URL scriptUrl) {
        Reporter.log("\nJS Library: " + scriptUrl, true);

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).
                include("div").exclude("h1").analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue(true, "[Assertion Passed]: No violations found");
        } else {
            AXE.writeResults(methodName, responseJSON);
            Reporter.log(AXE.report(violations), true);
            Assert.assertTrue(false, AXE.report(violations));
        }
    }

    public void testAccessibilityWithWebElement(String methodName, URL scriptUrl) {
        Reporter.log("\nJS Library: " + scriptUrl, true);

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).
                analyze(driver.findElement(By.tagName("p")));
        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue(true, "No violations found");
        } else {
            AXE.writeResults(methodName, responseJSON);
            Reporter.log(AXE.report(violations), true);
            Assert.assertTrue(false, AXE.report(violations));
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////// Accessibility Test Methods ---> HTML Code Sniffer ////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    public void accessibilityTestViaFrontPageTesterMethodInHTMLCodeSniffer() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        BufferedReader br = null;
        String inject = "";
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("src/test/resources/injectingFrontPageTesterToDOM.js"));
            while ((sCurrentLine = br.readLine()) != null) {
                inject += sCurrentLine;
                inject += "\n";
            }
        } catch (IOException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
            }
        }
        jse.executeScript(inject);
    }

    public void injectBookMarkletMethodOnWebPage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        BufferedReader br = null;
        String inject = "";
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("src/test/resources/injectingHTMLCodeSnifferBookMarkletToDOM.js"));
            while ((sCurrentLine = br.readLine()) != null) {
                inject += sCurrentLine;
                inject += "\n";
            }
        } catch (IOException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
            }
        }
        jse.executeScript(inject);

        // NOTE: To avoid StaleElement Exception when we have injected HTML Code Sniffer
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
    }

}
