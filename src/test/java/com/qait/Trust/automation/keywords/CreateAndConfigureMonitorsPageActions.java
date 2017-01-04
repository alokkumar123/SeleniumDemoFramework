/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class CreateAndConfigureMonitorsPageActions extends GetPage {

    WebDriver driver;
    String monitorName = "Monitor created by automation script";
    String externalServiceId = "123";

    public CreateAndConfigureMonitorsPageActions(WebDriver driver) {
        super(driver, "CreateAndConfigureMonitors");
        this.driver = driver;
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

    public void navigateToManageSystem() {
        isElementDisplayed("div_adminMenu");
        ReportMsg.info("Admin Menu list is displaying on admin ");
        isElementDisplayed("link_manageMonitors");
        element("link_manageMonitors").click();
        ReportMsg.info("Navigate to manage System");
    }

    public void clickOnCreateButton() {
        isElementDisplayed("button_Create");
        element("button_Create").click();
        ReportMsg.info("Click on create button");

    }

    public void enterAllMandatoryFieldsAndClickOnSave() {
        isElementDisplayed("div_monitorName");
        element("div_monitorName").click();
        element("div_monitorName").clear();
        element("div_monitorName").sendKeys(monitorName);
        ReportMsg.info("Entered monitor name : " + monitorName + " in mandatory field");
        isElementDisplayed("div_externalServiceId");
        element("div_externalServiceId").click();
        element("div_externalServiceId").clear();
        element("div_externalServiceId").sendKeys(externalServiceId);
        ReportMsg.info("Entered external service id : " + externalServiceId + " in mandatory field");
        isElementDisplayed("button_save");
        element("button_save").click();
        ReportMsg.info("Click On save button");
    }

    public void newCreatedMonitorShouldBeOpen() {
        isElementDisplayed("link_newCreatedMonitor", monitorName);
        element("link_newCreatedMonitor", monitorName).click();
        ReportMsg.info("New created monitor is opened ");
    }

    public void newCreatedMonitorsShouldBeSeenOnTheList() {
        isElementDisplayed("link_newCreatedMonitor", monitorName);
        ReportMsg.info("New Created monitor is displaying on manage monitor list ");
    }

    public void allInformationEnteredInFormShouldBeSaved() {
        String savedMonitorName = element("div_monitorName").getAttribute("value");
        assertEquals(savedMonitorName, monitorName, "Saved information is not correct for moitor name ");
        ReportMsg.info("Verified saved monitor name is " + savedMonitorName);
        isElementDisplayed("div_externalServiceId");
        element("div_externalServiceId").getText();
        String savedExternamServiceId = element("div_externalServiceId").getAttribute("value");
        assertEquals(savedExternamServiceId, externalServiceId, "Saved information is not correct for external service id ");
        ReportMsg.info("Verified saved service external id is " + externalServiceId);
    }

    public void logOutFromAdmin() {
        isElementDisplayed("button_Admin");
        element("button_Admin").click();
        ReportMsg.info("Click on admin button");
        isElementDisplayed("logout_adminPage");
        element("logout_adminPage").click();
        element("link_ok").click();
        ReportMsg.info("Log out from admin account");
    }

    public void gridShouldBeAvailableFor(String string) {
        isElementDisplayed("table_appTableGrid");
        isElementDisplayed("span_gridFields", string);
        ReportMsg.info("Grid is available for " + string);
    }

    public void createButtonAndSearchTextBarShouldBeAvailable() {
        isElementDisplayed("button_Create");
        ReportMsg.info("Created button is available ");
        isElementDisplayed("input_serachBox");
        ReportMsg.info("Search box is available ");
    }

    public void breadcrumbShouldBeAvailableForNavigation(String breadCrumb) {
        isElementDisplayed("link_breadCrumb", breadCrumb);
        ReportMsg.info("Verified breadcrumb for admin");
    }

}
