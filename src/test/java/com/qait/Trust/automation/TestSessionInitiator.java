package com.qait.Trust.automation;

import com.qait.Trust.automation.keywords.ManageSystemsPageActions;
import com.qait.Trust.automation.keywords.CreateAndConfigureMonitorsPageActions;
import com.qait.Trust.automation.keywords.CreateNotificationActions;
import com.qait.Trust.automation.keywords.DetailScreenPageActions;
import com.qait.Trust.automation.keywords.DetailScreen_GroupActions;
import com.qait.Trust.automation.keywords.ManageRegionPageActions;
import com.qait.Trust.automation.keywords.ManageRolePageActions;
import com.qait.Trust.automation.keywords.PlatformAvailabilityPageActions;
import com.qait.Trust.automation.keywords.RegionOnSplashActions;
import com.qait.Trust.automation.keywords.RegressionTestsPageActions;
import com.qait.Trust.automation.keywords.ValidationOfAboutPageActions;
import com.qait.Trust.automation.utils.HTMLCodeSniffer;

import com.qait.Trust.automation.utils.ReportMsg;

import com.qait.Trust.automation.utils.TakeScreenshot;
import static com.qait.Trust.automation.utils.YamlReader.setYamlFilePath;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import static com.qait.Trust.automation.utils.ConfigPropertyReader.getProperty;
import java.io.File;
import org.apache.commons.io.FileUtils;

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
    public HTMLCodeSniffer codeSniffer;
    public PlatformAvailabilityPageActions platformAvailabilityPage;
    public DetailScreenPageActions detailScreenPage;
    public ManageRolePageActions manageRolePage;
    public CreateAndConfigureMonitorsPageActions createAndConfigPage;
    public ManageSystemsPageActions manageSystemPage;
    public ManageRegionPageActions manageRegionPage;
    public DetailScreen_GroupActions detailScreen_group;
    public RegionOnSplashActions regionSplashPage;
    public TakeScreenshot takescreenshot;
    public ValidationOfAboutPageActions aboutPage;
    public RegressionTestsPageActions regressionTestPage;
    public CreateNotificationActions createNotificationPage;

    public WebDriver getDriver() {
        return this.driver;
    }

    private void _initPage() {
        codeSniffer = new HTMLCodeSniffer(driver);
        platformAvailabilityPage = new PlatformAvailabilityPageActions(driver);
        detailScreenPage = new DetailScreenPageActions(driver);
        manageRolePage = new ManageRolePageActions(driver);
        createAndConfigPage = new CreateAndConfigureMonitorsPageActions(driver);
        manageSystemPage = new ManageSystemsPageActions(driver);
        manageRegionPage = new ManageRegionPageActions(driver);
        detailScreen_group = new DetailScreen_GroupActions(driver);
        regionSplashPage = new RegionOnSplashActions(driver);
        aboutPage = new ValidationOfAboutPageActions(driver);
        regressionTestPage = new RegressionTestsPageActions(driver);
        createNotificationPage = new CreateNotificationActions(driver);
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

    public void launchApplication(String base_url) {
        ReportMsg.info(" The application url is :- " + base_url);
        String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
        System.out.println("Current OS Browser configuration:" + uAgent);
        driver.manage().deleteAllCookies();
//        clearHistoryFromBrowser();
        driver.get(base_url);
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

    public static void testMethodName(String testMethodName) {
        Reporter.log("\n", true);
        Reporter.log("********** TEST METHOD  : - " + testMethodName.toUpperCase() + " ***************", true);
        Reporter.log("\n", true);
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
    private static final String SRC_FOLDER = "10.161.127.37\\C:\\Users\\qaadmin\\AppData\\Local\\Google\\Chrome\\User Data\\Default";

    private void clearHistoryFromBrowser() throws IOException {
//        try {
//            FileUtils.cleanDirectory(new File("C:\\Users\\qaadmin\\AppData\\Local\\Google\\Chrome\\User Data\\Default"));
//            System.out.println("Delete operation is failed.");
////            File file = new File("C:\\Users\\qaadmin\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
////
////            if (file.delete()) {
////                System.out.println(file.getName() + " is deleted!");
////            } else {
////                System.out.println("Delete operation is failed.");
////            }
//
//        } catch (Exception e) {
//System.out.println("Delete operation is failed.");
//            e.printStackTrace();
//
//        }

//        File directory = new File(SRC_FOLDER);
//
//        //make sure directory exists
//        if (!directory.exists()) {
//
//            System.out.println("Directory does not exist.");
//            System.exit(0);
//
//        } else {
//            System.out.println("Directory does  exist.");
//            try {
//
//                delete(directory);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.exit(0);
//            }
//        }
//
//        System.out.println("Done");
        
        
//        File f=new File("abc.txt"); //Takes the default path, else, you can specify the required path
//            if(f.exists())
//            {
//                f.delete();
//            }
//            f.createNewFile(); 
//            FileObject destn=VFS.getManager().resolveFile(f.getAbsolutePath());
//            UserAuthenticator auth=new StaticUserAuthenticator("", "myusername", "secret_password");
//            FileSystemOptions opts=new FileSystemOptions();
//            DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
//            FileObject fo=VFS.getManager().resolveFile("\\\\192.168.0.1\\direcory\\to\\GetData\\sourceFile.txt",opts);
//            destn.copyFrom(fo,Selectors.SELECT_SELF);
//            destn.close();
    }

    public static void delete(File file)
            throws IOException {

        if (file.isDirectory()) {

            //directory is empty, then delete it
            if (file.list().length == 0) {

                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());

            } else {

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    delete(fileDelete);
                }

                //check the directory again, if empty then delete it
                if (file.list().length == 0) {
                    file.delete();
                    System.out.println("Directory is deleted : "
                            + file.getAbsolutePath());
                }
            }

        } else {
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }

}
