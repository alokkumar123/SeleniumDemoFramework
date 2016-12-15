/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import com.qait.Trust.automation.utils.SeleniumWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

public class DetailScreenPageActions extends GetPage {

    WebDriver driver;
    // public static WebElement el;

    public DetailScreenPageActions(WebDriver driver) {
        super(driver, "DetailScreen");
        this.driver = driver;
    }

    public void slecectAppsFromPlatformScreen(String appName) {
        try {
            ReportMsg.info("App name is = " + appName);
            element("allApps", appName).click();
            ReportMsg.info("Clicked on " + appName);
        } catch (StaleElementReferenceException e) {
            ReportMsg.info("App name is = " + appName);
            element("allApps", appName).click();
            ReportMsg.info("Clicked on " + appName);
            e.printStackTrace();
        }
    }

    public void verifyBreadcrumb() {
        List<WebElement> a = elements("listOfApps");
        // ReportMsg.info("size= " + a.size());
        for (WebElement el : a) {

            wait.waitForElementToBeVisible(el);
            String appName = el.getText();
            ReportMsg.info("App name is = " + appName);
            slecectAppsFromPlatformScreen(appName);
            verifyBreadcrumb(appName);
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        }
    }

    private void verifyBreadcrumb(String appName) {
        isElementDisplayed("link_breadCrumb", appName);
        ReportMsg.info("verified breadcrumb for " + appName + "app");
    }

    public void userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome() {
        isElementDisplayed("link_platfromAvailabilityHome");
        element("link_platfromAvailabilityHome").click();
        ReportMsg.info("Clicked on Platfrom Availability Home");
        isElementDisplayed("text_screenPage");
        ReportMsg.info("verified user navigate to platform Availabilty Screen");
    }

    public void verfifyDropDownOptionsWithOptions(String string) {
        element("span_DropDownSelector").click();
        isElementDisplayed("list_dropdownOptions", string);
    }

    public void verifyDropDownOptionsWithOptions(String string) {
        element("DropDownSelector").click();
        isElementDisplayed("dropdownOptions", string);
        ReportMsg.info("Verified " + string + " drop down");
    }

    public void clickOnSingleApp(String appName) {
        element("allApps", appName).click();
        ReportMsg.info("Clicked on " + appName + " app");
    }

    public void verifyTimeZoneForUser(String string) {
        element("span_timeZoneDropDownSelector").click();
        isElementDisplayed("list_timezonedropdownOptions", string);
        ReportMsg.info("Verified " + string + " drop down");
    }

    public void verifyInformationAvailableForHours(String lastHours, String hours) {
        List<WebElement> a = elements("listOfApps");

        for (WebElement el : a) {

            String appName = el.getText();
            ReportMsg.info("App name is = " + appName);
            slecectAppsFromPlatformScreen(appName);
            selectLastAvailableHours(lastHours);
            columnShouldRepresentLastHoursFromCurrent(hours);
            leagendShouldBeAvailable();
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        }

    }

    private void selectLastAvailableHours(String string) {
        element("spapn_DropDownSelector").click();
        isElementDisplayed("list_dropdownOptions", string);
        element("list_dropdownOptions", string).click();
        ReportMsg.info("Verified " + string + " drop down");
    }

    private void columnShouldRepresentLastHoursFromCurrent(String last_12_hours) {
        Date date = new Date();
        String strDateFormat = "HH a";
        DateFormat sdf = new SimpleDateFormat(strDateFormat);
        String systemTime = sdf.format(date);
        ReportMsg.info("System time=" + systemTime);
        isElementDisplayed("applicationCurrentTime", systemTime);
        isElementDisplayed("tr_lastHours", systemTime);

        int hoursSize = Integer.parseInt(last_12_hours);
        int rowSize = elements("tr_lastHours", systemTime).size();
        Assert.assertEquals(rowSize, hoursSize);
    }

    private void leagendShouldBeAvailable() {
        isElementDisplayed("span_noIssues");
        isElementDisplayed("span_minorDisruption");
        isElementDisplayed("span_serviceTemporarilyUnavailable");
        isElementDisplayed("span_plannedMaintenance");
    }

    public void verifyInformationAvailableForLast30Days() {
        List<WebElement> a = elements("listOfApps");

        for (WebElement el : a) {

            String appName = el.getText();
            ReportMsg.info("App name is = " + appName);
            slecectAppsFromPlatformScreen(appName);

            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        }
    }
}
