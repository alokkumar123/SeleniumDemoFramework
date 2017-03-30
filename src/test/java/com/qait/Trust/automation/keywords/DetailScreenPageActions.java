package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import static com.qait.Trust.automation.utils.ConfigPropertyReader.getProperty;
import com.qait.Trust.automation.utils.ReportMsg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import java.util.TimeZone;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

public class DetailScreenPageActions extends GetPage {

    WebDriver driver;
    ArrayList<String> timeList = new ArrayList<String>() {
        {
            add("05");
            add("10");
            add("15");
            add("20");
            add("25");
            add("30");
            add("35");
            add("40");
            add("45");
            add("50");
            add("55");
            add("60");
        }
    };

    public DetailScreenPageActions(WebDriver driver) {
        super(driver, "DetailScreen");
        this.driver = driver;
    }

    public void userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome() {
        element("link_platfromAvailabilityHome").click();
        ReportMsg.info("Clicked on Platform Availability Home");
        isElementDisplayed("text_screenPage");
        ReportMsg.info("User navigated to Splash Page on PlatformAvailability Page");
    }

    public void verifyDropDownWithOptions(String string) {
        element("DropDownSelector").click();
        isElementDisplayed("dropdownOptions", string);
        ReportMsg.info("Verified " + string + " drop down");
    }

    public void clickOnSingleApp(String appName) {
        element("allApps", appName).click();
        ReportMsg.info("Clicked on " + appName + " app");
    }

    private void selectLastAvailableHours(String string) {
//        String viewTimeFormat = "last 30 days";
//        String selectedTimeFormat = (String) executeJavascript("return document.getElementsByClassName('rw-input')[0].textContent");
//        System.out.println("Value of Time Format: " + selectedTimeFormat);
//        if (!(selectedTimeFormat.equalsIgnoreCase(viewTimeFormat))) {
//            executeJavascript("document.getElementsByClassName('rw-input')[0].click()");
//            for (WebElement listItem : elements("list_timeViewFormat")) {
//                if (listItem.getText().equalsIgnoreCase(viewTimeFormat)) {
//                    listItem.click();
//                    ReportMsg.info("Clicked on '" + viewTimeFormat + "' option");
//                } else {
//                    System.out.println("Selected value: '" + viewTimeFormat + "'");
//                }
//            }
//            isElementDisplayed("list_dropdownOptions", viewTimeFormat);
//            ReportMsg.info("Verified '" + viewTimeFormat + "' drop down");
//        }
        if (string.contains("last 12 hours")) {
            isElementDisplayed("span_DropDownSelector");
        } else {
            wait.waitForElementToBeVisible(element("span_DropDownSelector"));
            element("span_DropDownSelector").click();
            isElementDisplayed("select_hours", string);
            element("select_hours", string).click();
        }
        ReportMsg.info("Selected " + string + " from drop down");
    }

    private void columnShouldRepresentLastHoursFromCurrent(String last_12_hours) {
        Date date = new Date();
        Date date1 = new Date();
        String strDateFormat = "HH a";
        DateFormat sdf = new SimpleDateFormat(strDateFormat);
        sdf.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        String systemTime = sdf.format(date).toLowerCase();
        String strDateFormat1 = "HH:MM z";
        DateFormat sdf1 = new SimpleDateFormat(strDateFormat1);
        sdf1.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        String systemTime1 = sdf1.format(date1);
        ReportMsg.info("System time = " + systemTime1);
        if (systemTime.contains("0")) {
            systemTime = systemTime.replace("0", "");
        }
        wait.waitForElementToBeVisible(element("applicationCurrentTime", systemTime));
        isElementDisplayed("applicationCurrentTime", systemTime);
        isElementDisplayed("tr_lastHours", systemTime);

        int hoursSize = Integer.parseInt(last_12_hours);
        ReportMsg.info("hours size in table = " + hoursSize + " for last " + last_12_hours + " hours");
    }

    public void verifyLegendShouldBeAvailable() {
//        scrollDown(element("span_noIssues"));
//        scrollDown();
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.DOWN).perform();

//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//        scrollDown(element("table_systemStatus"));
//        ReportMsg.log("Scrolled down");
//        executeJavascript("window.scrollTo(0,Math.max(document.documentElement."
//                + "scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        isElementDisplayed("span_noIssues");
        isElementDisplayed("span_minorDisruption");
        isElementDisplayed("span_serviceTemporarilyUnavailable");
        isElementDisplayed("span_plannedMaintenance");

//        scrollTop();
//        ReportMsg.log("Scrolled up");
    }

    private void verifyInformationOnGregorianCalendar(String appName) {
        verifyDaysOnGregorianCalender(appName);
        verifyCurrentAndLastMonth(appName);
    }

    private void verifyCurrentAndLastMonth(String appName) {
        scrollDown(element("table_systemStatus"));
        Calendar cal = Calendar.getInstance();
        String currentMonth = new SimpleDateFormat("MMM").format(cal.getTime());
        isElementDisplayed("text_currentMonth", currentMonth);
        ReportMsg.info("verified current month " + currentMonth + " is displaying on calender for " + appName);
        cal.add(Calendar.MONTH, -1);
        String lastMonth = new SimpleDateFormat("MMM").format(cal.getTime());
        isElementDisplayed("text_currentMonth", currentMonth);
        ReportMsg.info("verified last month " + lastMonth + " is displaying on calender for " + appName);
    }

    private void verifyDaysOnGregorianCalender(String appName) {
        ArrayList mylist = new ArrayList();
        mylist.add("Sun");
        mylist.add("Mon");
        mylist.add("Tue");
        mylist.add("Wed");
        mylist.add("Thu");
        mylist.add("Fri");
        mylist.add("Sat");

        Iterator it = mylist.iterator();
        while (it.hasNext()) {
            Object day = it.next();
            isElementDisplayed("text_days", (String) day);
            ReportMsg.info("verified " + day + " is displaying on calender for " + appName);
        }
    }

    public void onHoverOverOnAnyDay24HourClockShouldBeSeen() {
        hoverOnAnyDay("18");
        verifyDayHeading();
    }

    private void hoverOnAnyDay(String day) {
        hover(element("hover_anyday", day));
        //hover(element("btn_currentInformationalAlerts"));
        ReportMsg.info("hover on day " + day);
    }

    private void verifyDayHeading() {
        isElementDisplayed("text_dayHeading");
        ReportMsg.info(element("text_dayHeading").getText() + " heading is displaying while hover on day");
    }

    private void verifyCurrentInformationAlerts(String appName) {
        try {
            // NOTE: Unable to click on 'Current Informational Alerts' button due to 
            //       hovering of date displaying 
            // element("btn_currentInformationalAlerts").click();
            executeJavascript("document.getElementsByClassName('info-alerts')[0].click()");
            ReportMsg.info("Clicked on current information alerts button");
            isElementDisplayed("txt_informationalAlert");
            ReportMsg.info("Verified text Informational alerts text on pop up");
            executeJavascript("document.getElementsByClassName('btn btn-default')[0].click()");
            ReportMsg.info("Message bar is closed when clicked on close button");
            //isElementDisplayed("btn_currentInformationalAlerts");
        } catch (Exception e) {
            ReportMsg.info("Creating new alert notification");
            isElementDisplayed("link_login");
            element("link_login").click();

            element("userName").clear();
            element("userName").click();
            element("userName").sendKeys("qaadmin");

            element("password").clear();
            element("password").click();
            element("password").sendKeys("Cengage1");
            element("button_login").click();

            isElementDisplayed("button_createNotification");
            element("button_createNotification").click();
            ReportMsg.info("Click on create new notification button");
            isElementDisplayed("div_selectMonitor");
            element("div_selectMonitor").click();
            isElementDisplayed("list_allApp");
            element("list_allApp").click();
            element("commentSection").click();
            ReportMsg.info("Select system all app from slect monitors");
            isElementDisplayed("select_endDate");
            element("select_endDate").click();
            String currentDate = element("text_currentDate").getText();

            int a = Integer.parseInt(currentDate);
            if (a < 31) {
                a = a + 1;
            } else {
                a = 1;
            }
            String date = Integer.toString(a);
            element("text_endDate", date).click();
            ReportMsg.info("Set end date ");
            isElementDisplayed("button_OK");
            try {
                isElementDisplayed("btn_close");
                element("btn_close").click();

                element("button_OK").click();

            } catch (NoSuchElementException e1) {
                element("button_OK").click();
            }

            ReportMsg.info("Click on Ok button");
            isElementDisplayed("commentSection");
            element("commentSection").click();
            element("commentSection").clear();
            element("commentSection").sendKeys("creating notification");
            ReportMsg.info("send commnets creating notification");
            isElementDisplayed("button_save");
            element("button_save").click();
            ReportMsg.info("Click On save button");
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
            isElementDisplayed("singleApp", appName);
            element("singleApp", appName).click();
            ReportMsg.info("Click on App = " + appName);
            isElementDisplayed("txt_appName");
            appName = element("txt_appName").getText();
            String b[] = appName.split("> ");
            appName = b[1];
            ReportMsg.info("AppName = " + appName);

        }
    }

    public void checkColorNotationGreenInPlatformAvailability() {
        int i = 0;
        for (WebElement el : elements("listOfApps")) {
            String appName = null;
            try {
                wait.waitForElementToBeVisible(elements("listOfApps").get(i));
                appName = elements("listOfApps").get(i).getText();
                ReportMsg.info("App Namr = " + appName);
            } catch (StaleElementReferenceException e) {
                wait.waitForElementToBeVisible(el);
                appName = el.getText();
                e.printStackTrace();
            }
            i++;
            verifyAppIsAvailableAndGreenInColor(appName);
        }
    }

    private void verifyAppIsAvailableAndGreenInColor(String appName) {
        isElementDisplayed("img_AppColor", appName);
        String img = element("img_AppColor", appName).getAttribute("src");
        ReportMsg.info("img color for " + appName + " is " + img);
        if (img.contains("green.png")) {
            img = "green.png";
        }
        Assert.assertEquals(img, "green.png", "app color is not green");
        ReportMsg.info("Verified color is green for " + appName);
        isElementDisplayed("text_appAvailability", appName);
        String appStatus = element("text_appAvailability", appName).getText();
        Assert.assertEquals(appStatus, "Available", "App is not avilable on");
        ReportMsg.info(appName + " app is available on platform ");
    }

    public void verifyBreadCrumb(String appName) {
        Reporter.log("############## TRUST-317: Verifying Breadcrumb ##############\n", true);
        isElementDisplayed("txt_appName");
        appName = element("txt_appName").getText();

        String a[] = appName.split("> ");
        appName = a[1];
        ReportMsg.info("System: " + appName);

        isElementDisplayed("link_breadCrumb", appName);
        ReportMsg.info("Verified breadcrumb for " + appName + " app");
    }

    public void verifyDropDownOptionsForLastHours() {
        System.out.println("\n############## Verifying Drop Down options for last hours, TRUST-318 ##############\n");

        String viewTimeFormat = "last 12 hours";
        String selectedTimeFormat = (String) executeJavascript("return document.getElementsByClassName('rw-input')[0].textContent");
        System.out.println("Value of Time Format: " + selectedTimeFormat);
        if (!(selectedTimeFormat.equalsIgnoreCase(viewTimeFormat))) {
            executeJavascript("document.getElementsByClassName('rw-input')[0].click()");
            for (WebElement listItem : elements("list_timeViewFormat")) {
                if (listItem.getText().equalsIgnoreCase(viewTimeFormat)) {
                    listItem.click();
                    ReportMsg.info("Clicked on '" + viewTimeFormat + "' option");
                } else {
                    System.out.println("Selected value: '" + viewTimeFormat + "'");
                }
            }
            isElementDisplayed("list_dropdownOptions", viewTimeFormat);
            ReportMsg.info("Verified " + viewTimeFormat + " from last hours drop down");
        }

        viewTimeFormat = "last 24 hours";
        selectedTimeFormat = (String) executeJavascript("return document.getElementsByClassName('rw-input')[0].textContent");
        System.out.println("Value of Time Format: " + selectedTimeFormat);
        if (!(selectedTimeFormat.equalsIgnoreCase(viewTimeFormat))) {
            executeJavascript("document.getElementsByClassName('rw-input')[0].click()");

            for (WebElement listItem : elements("list_timeViewFormat")) {
                if (listItem.getText().equalsIgnoreCase(viewTimeFormat)) {
                    listItem.click();
                    ReportMsg.info("Clicked on '" + viewTimeFormat + "' option");
                } else {
                    System.out.println("Selected value: '" + viewTimeFormat + "'");
                }
            }
            isElementDisplayed("list_dropdownOptions", viewTimeFormat);
            ReportMsg.info("Verified " + viewTimeFormat + " from last hours drop down");
        }
    }

    public void verifyTimeZoneDropDownForUser() {
        System.out.println("\n############## Verifying Drop Down options for Time Zones, TRUST-319 ##############\n");
        String timeZone = "EDT (local)";
        executeJavascript("document.getElementsByClassName('rw-input')[1].click()");
        ReportMsg.info("Verified " + timeZone + " from time zone drop down");
        timeZone = "CDT";
        isElementDisplayed("list_timezonedropdownOptions", timeZone);
        ReportMsg.info("Verified " + timeZone + " from time zone drop down");
        timeZone = "PDT";
        isElementDisplayed("list_timezonedropdownOptions", timeZone);
        ReportMsg.info("Verified " + timeZone + " from time zone drop down");
        timeZone = "GMT";
        isElementDisplayed("list_timezonedropdownOptions", timeZone);
        executeJavascript("document.getElementsByClassName('rw-input')[1].click()");
        ReportMsg.info("Verified " + timeZone + " from time zone drop down");
    }

    public void verifyInformationAvailableForLastHours(String lastHours, String hours, String appName) {
        String JiraId = "TRUST-321";
        if (!lastHours.contains("last 12 hours")) {
            JiraId = "TRUST-322";
        }
        try {
            System.out.println("\n############## Verifying Information Available for " + lastHours + " on Detail Screen Page, " + JiraId + " ##############\n");
            isElementDisplayed("table_systemStatus");
            ReportMsg.info("Verified system status of table");
            columnShouldRepresentLastHoursFromCurrent(hours);
            verifyLegendShouldBeAvailable();
            // userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        } catch (Exception e1) {
            ReportMsg.info("table system status is not availabe for app");
            isElementDisplayed("div_errorMessage");
            String message = element("div_errorMessage").getText();
            ReportMsg.info("App Information is not available, Message is appearing with text :- " + message + " for " + lastHours);
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
            isElementDisplayed("singleApp", appName);
            element("singleApp", appName).click();
            ReportMsg.info("Click on App = " + appName);
            isElementDisplayed("txt_appName");
            appName = element("txt_appName").getText();
            String a[] = appName.split("> ");
            appName = a[1];
            ReportMsg.info("AppName = " + appName);
        }
    }

    public void verifyInformationAvailableForLast30Days(String last_30_days, String appName) {
        System.out.println("\n############## Verifying Information Available for " + last_30_days + " on Detail Screen Page, TRUST-323 ##############\n");
        selectLastAvailableHours(last_30_days);
        try {
            isElementDisplayed("table_systemStatus");
            element("table_systemStatus").isDisplayed();
            ReportMsg.info("Verifying table system stutus");
            verifyInformationOnGregorianCalendar(appName);
            onHoverOverOnAnyDay24HourClockShouldBeSeen();
            verifyLegendShouldBeAvailable();
        } catch (Exception e) {
            ReportMsg.info("table system status is not availabe for app");
            isElementDisplayed("div_errorMessage");
            String message = element("div_errorMessage").getText();
            ReportMsg.info("App Information is not available, Message is appearing with text :- " + message + " for " + last_30_days);
        }
    }

    public void checkCurrentInformationalAlertButtonforLast30Days(String appName) {
        String tier = System.getProperty("tier");
        if (tier == null) {
            tier = getProperty("Config.properties", "tier").trim();
        }

        if (tier.equalsIgnoreCase("stg")) {
            System.out.println("\n############## Verifying Current Informational Alert For All last hours , TRUST-324, TRUST-340, TRUST-345 ##############\n");
            String lastHours = "last 12 hours";
            selectLastAvailableHours(lastHours);
            verifyCurrentInformationAlerts(appName);
            lastHours = "last 24 hours";
            selectLastAvailableHours(lastHours);
            verifyCurrentInformationAlerts(appName);
            lastHours = "last 30 days";
            selectLastAvailableHours(lastHours);
            verifyCurrentInformationAlerts(appName);
        } else {
            ReportMsg.info("'Current Informational Alerts' button is NOT AVAILABLE on PRODUCTION environment!!!");
        }
    }

    public void checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(String appName) {
        System.out.println("\n############## Verifying Green Color notation, TRUST-346 ##############\n");
        try {
            isElementDisplayed("div_appColorOnPlatform", appName);
            ReportMsg.info("Verified color for " + appName + " app is green on Platform Availability Screen");
            isElementDisplayed("singleApp", appName);
            element("singleApp", appName).click();
            isElementDisplayed("txt_appName");
            appName = element("txt_appName").getText();
            String a[] = appName.split("> ");
            appName = a[1];
            ReportMsg.info("Click on '" + appName + "' system and navigated to Detail screen");
            ReportMsg.info("Set time frame for 12 hours");
            ReportMsg.info("Set timezone to EST");
            isElementDisplayed("table_systemStatus");
            ReportMsg.info("Verifying table system status");
            isElementDisplayed("greenColor_timeFrame");
            ReportMsg.info("Verified current color notation is green");
            int size = elements("greenColor_timeFrame").size();
            ReportMsg.info("Number of current time frames in green color are " + size + " for 12 hours and EST time zone on Detail Screen");
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        } catch (Exception e) {
            ReportMsg.info("table system status is not availabe for app");
            isElementDisplayed("div_errorMessage");
            String message = element("div_errorMessage").getText();
            ReportMsg.info("App Information is not available, Message is appearing with text :- " + message + " for " + appName);
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        }
    }

    public void checkForColorNotationInThePlatformAvailabilityAndDetailScreen(String appName, String color) {
        System.out.println("\n############## Verifying " + color + " color notation for 12 and 24 hours, TRUST-347 ##############\n");
//       // isElementDisplayed("div_appColorOnPlatform", appName);
//        ReportMsg.info("Verified color for " + appName + " app is green on Platform Availability Screen");
//        isElementDisplayed("singleApp", appName);
//        element("singleApp", appName).click();
        // ReportMsg.info("Click on App = " + appName);
        isElementDisplayed("txt_appName");
        appName = element("txt_appName").getText();
        String a[] = appName.split("> ");
        appName = a[1];
        ReportMsg.info("Click on App " + appName + " and navigate to the details screen");
        ReportMsg.info("Set time frame for 12 hours");
        ReportMsg.info("Set timezone to EDT");
        ReportMsg.info("****** Verifying Slight disruption ,Minor disruption ,Service temporarily unavailable ,orange and Planned maintenance color for 12 hours ******");
        verifyColorInTimeFrameColor(color);
//        verifyColorInTimeFrameColor("yellow");
//        verifyColorInTimeFrameColor("orange");
//        verifyColorInTimeFrameColor("empty");
        selectLastAvailableHours("last 24 hours");
        ReportMsg.info("****** Verifying " + color + " color for 24 hours ****");
        verifyColorInTimeFrameColor(color);
//        verifyColorInTimeFrameColor("yellow");
//        verifyColorInTimeFrameColor("orange");
//        verifyColorInTimeFrameColor("empty");
        userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    public void verifyColorInTimeFrameColor(String color) {
        try {
            isElementDisplayed("table_systemStatus");
            ReportMsg.info("Verifying table system status");
            isElementDisplayed("td_colorFrame", color);
            for (WebElement el : elements("td_colorFrame", color)) {
                String hours = el.getText();
                Iterator itr = timeList.iterator();
                ReportMsg.info("hours " + hours);
                wait.waitForElementsToBeVisible(elements("minute", hours));
//                ReportMsg.info("hours " + hours);
                waitTOSync();
                for (WebElement ele : elements("minute", hours)) {
                    String minuteTime = itr.next().toString();
                    if (ele.getAttribute("class").equals(color)) {
                        ReportMsg.info(color.toUpperCase() + " color is showing at " + hours + ":" + minuteTime);
                    }
                }
            }
            //userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        } catch (NoSuchElementException e) {
            ReportMsg.info(color.toUpperCase() + " color frame is not visible on time frame");
            //userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        }
    }

    public void logAsAdmin() {
        isElementDisplayed("link_login");
        element("link_login").click();
        element("userName").clear();
        element("userName").click();
        element("userName").sendKeys("Admin");
        element("password").clear();
        element("password").click();
        element("password").sendKeys("Cengage1");
        element("button_login").click();
        ReportMsg.info("Login into admin account");
    }

}
