/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DetailScreenPageActions extends GetPage {

    WebDriver driver;

    public DetailScreenPageActions(WebDriver driver) {
        super(driver, "DetailScreen");
        this.driver = driver;
    }

    public void selectAppsFromPlatformScreen(String appName) {
        try {
            ReportMsg.info("App name is = " + appName);
            element("allApps", appName).click();
            ReportMsg.info("Clicked on " + appName);
        } catch (StaleElementReferenceException e) {
            ReportMsg.info("App name is = " + appName);
            element("allApps", appName).click();
            ReportMsg.info("Clicked on " + appName);
        }
    }

    public void verifyBreadcrumb() {

        int i = 0;
        for (WebElement el : elements("listOfApps")) {
            String appName = null;

            try {
                wait.waitForElementToBeVisible(elements("listOfApps").get(i));
                appName = elements("listOfApps").get(i).getText();
            } catch (StaleElementReferenceException e) {
                wait.waitForElementToBeVisible(el);
                appName = el.getText();
                e.printStackTrace();
            }
            selectAppsFromPlatformScreen(appName);
            verifyBreadcrumb(appName);
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
            i++;
        }
    }

    private void verifyBreadcrumb(String appName) {
        isElementDisplayed("link_breadCrumb", appName);
        ReportMsg.info("Verified breadcrumb for '" + appName + "' app");
    }

    public void userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome() {
        isElementDisplayed("link_platfromAvailabilityHome");
        element("link_platfromAvailabilityHome").click();
        ReportMsg.info("Clicked on Platfrom Availability Home");
        isElementDisplayed("text_screenPage");
        ReportMsg.info("verified user navigate to platform Availabilty Screen");
    }

    public void verifyDropDownOptionsWithOptions(String string) {
        System.out.println("*************** Verifying drop down options for " + string + " on all apps ********************");
        int i = 0;
        for (WebElement el : elements("listOfApps")) {
            String appName = null;

            try {
                wait.waitForElementToBeVisible(elements("listOfApps").get(i));
                appName = elements("listOfApps").get(i).getText();
            } catch (StaleElementReferenceException e) {
                wait.waitForElementToBeVisible(el);
                appName = el.getText();
                e.printStackTrace();
            }
            selectAppsFromPlatformScreen(appName);
            i++;
            if (string.equals("last 12 hours")) {
                isElementDisplayed("span_DropDownSelector");
            } else {
                isElementDisplayed("span_DropDownSelector");
                element("span_DropDownSelector").click();
                isElementDisplayed("list_dropdownOptions", string);
            }

            ReportMsg.info("Verified " + string + " drop down for " + appName);
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
            ReportMsg.info("verified " + string + "drop down " + appName + " app");
        }
        ReportMsg.info("verified " + string + " drop down for all the app");
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

    public void verifyTimeZoneForUser(String string) {
        System.out.println("*************** Verifying time zone for " + string + " on all apps ********************");
//        ReportMsg.info("*************** Verifying time zone for " + string + " on all apps ********************");
        int i = 0;
        for (WebElement el : elements("listOfApps")) {
            String appName = null;

            try {
                wait.waitForElementToBeVisible(elements("listOfApps").get(i));
                appName = elements("listOfApps").get(i).getText();
            } catch (StaleElementReferenceException e) {
                wait.waitForElementToBeVisible(el);
                appName = el.getText();
                e.printStackTrace();
            }
            selectAppsFromPlatformScreen(appName);
            i++;
            if (string.equals("EST (local)")) {
                isElementDisplayed("span_timeZoneDropDownSelector");

            } else {
                isElementDisplayed("span_timeZoneDropDownSelector");
                element("span_timeZoneDropDownSelector").click();
                isElementDisplayed("list_timezonedropdownOptions", string);

            }
            ReportMsg.info("Verified " + string + " drop down for " + appName);
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
            ReportMsg.info("verified " + string + "time zone for " + appName + " app");
        }
        ReportMsg.info("verified " + string + " time zone for all the app");
    }

    public void verifyInformationAvailableForHours(String lastHours, String hours) {
        int i = 0;
        for (WebElement el : elements("listOfApps")) {
            String appName = null;

            try {
                wait.waitForElementToBeVisible(elements("listOfApps").get(i));
                appName = elements("listOfApps").get(i).getText();
            } catch (StaleElementReferenceException e) {
                wait.waitForElementToBeVisible(el);
                appName = el.getText();
                e.printStackTrace();
            }
            i++;
            selectAppsFromPlatformScreen(appName);
            if (!lastHours.contains("last 12 hours")) {
                selectLastAvailableHours(lastHours);
            }
            columnShouldRepresentLastHoursFromCurrent(hours);
            verifyLeagendShouldBeAvailable();
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        }
    }

    private void selectLastAvailableHours(String string) {
        element("span_DropDownSelector").click();
        isElementDisplayed("list_dropdownOptions", string);
        element("list_dropdownOptions", string).click();
        ReportMsg.info("Verified " + string + " drop down");
    }

    private void columnShouldRepresentLastHoursFromCurrent(String last_12_hours) {
        Date date = new Date();
        String strDateFormat = "HH a";
        DateFormat sdf = new SimpleDateFormat(strDateFormat);
        sdf.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        String systemTime = sdf.format(date).toLowerCase();
        if (systemTime.contains("0")) {
            systemTime = systemTime.replace("0", "");
        }
        ReportMsg.info("System time=" + systemTime);
        wait.waitForElementToBeVisible(element("applicationCurrentTime", systemTime));
        isElementDisplayed("applicationCurrentTime", systemTime);
        isElementDisplayed("tr_lastHours", systemTime);

        int hoursSize = Integer.parseInt(last_12_hours);
        ReportMsg.info("hourse size = " + hoursSize);
        int rowSize = elements("tr_lastHours", systemTime).size();
        ReportMsg.info("row size = " + rowSize);
        //Assert.assertEquals(rowSize, hoursSize);
    }

    public void verifyLeagendShouldBeAvailable() {
        isElementDisplayed("span_noIssues");
        isElementDisplayed("span_minorDisruption");
        isElementDisplayed("span_serviceTemporarilyUnavailable");
        isElementDisplayed("span_plannedMaintenance");
    }

    public void verifyInformationAvailableForLast30Days(String last_30_days) {
        int i = 0;
        for (WebElement el : elements("listOfApps")) {
            String appName = null;

            try {
                wait.waitForElementToBeVisible(elements("listOfApps").get(i));
                appName = elements("listOfApps").get(i).getText();
            } catch (StaleElementReferenceException e) {
                wait.waitForElementToBeVisible(el);
                appName = el.getText();
                e.printStackTrace();
            }
            selectAppsFromPlatformScreen(appName);
            selectLastAvailableHours(last_30_days);
            verifiInformationOnGregorianCalendar();
            onHoverOverOnAnyDay24HourClockShouldBeSeen();
            verifyLeagendShouldBeAvailable();
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        }
    }

    private void verifiInformationOnGregorianCalendar() {
        verifyDaysOnGregorianCalender();
        verifyCurrentAndLastMonth();
    }

    private void verifyCurrentAndLastMonth() {
        Calendar cal = Calendar.getInstance();
        String currentMonth = new SimpleDateFormat("MMM").format(cal.getTime());
        isElementDisplayed("text_currentMonth", currentMonth);
        ReportMsg.info("verified current month " + currentMonth + " is displaying on calender");
        cal.add(Calendar.MONTH, -1);
        String lastMonth = new SimpleDateFormat("MMM").format(cal.getTime());
        isElementDisplayed("text_currentMonth", currentMonth);
        ReportMsg.info("verified last month " + lastMonth + " is displaying on calender");
    }

    private void verifyDaysOnGregorianCalender() {
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
            ReportMsg.info("verified " + day + " is displaying on calender");
        }

    }

    public void onHoverOverOnAnyDay24HourClockShouldBeSeen() {
        hoverOnAnyDay("1");
        verifyDayHeading("1");
    }

    private void hoverOnAnyDay(String day) {
        hover(element("hover_anyday", day));
        ReportMsg.info("hover on day");
    }

    private void verifyDayHeading(String dayNo) {
        isElementDisplayed("text_dayHeading", dayNo);
        ReportMsg.info("verified heading of the selected day");
    }

    public void clickOnApp(String last_30_days) {
        element("app_singleApp").click();
        selectLastAvailableHours(last_30_days);
        verifiInformationOnGregorianCalendar();
    }

    public void checkCurrecntInformationAlertButtonforLastDays(String last_30_days) {
        int i = 0;
        for (WebElement el : elements("listOfApps")) {
            String appName = null;

            try {
                wait.waitForElementToBeVisible(elements("listOfApps").get(i));
                appName = elements("listOfApps").get(i).getText();
            } catch (StaleElementReferenceException e) {
                wait.waitForElementToBeVisible(el);
                appName = el.getText();
                e.printStackTrace();
            }
            selectAppsFromPlatformScreen(appName);
            selectLastAvailableHours(last_30_days);
            verifyCurrentInformationAlerts();
        }
    }

    private void verifyCurrentInformationAlerts() {
        isElementDisplayed("btn_currnetInformationAlerts");
        element("btn_currnetInformationAlerts").click();
        ReportMsg.info("clicked on current information alerts button");
        isElementDisplayed("txt_informationalAlert");
        ReportMsg.info("verified text Informational alerts text on pop up");
        isElementDisplayed("btn_close");
        element("btn_close").click();
        ReportMsg.info("Message bar is close when clicked on close button");
        isElementDisplayed("btn_currnetInformationAlerts");
    }
}
