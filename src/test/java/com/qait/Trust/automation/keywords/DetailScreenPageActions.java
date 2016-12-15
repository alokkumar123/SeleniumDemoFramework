/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailScreenPageActions extends GetPage {

    WebDriver driver;

    public DetailScreenPageActions(WebDriver driver) {
        super(driver, "DetailScreen");
        this.driver = driver;
    }

    public void verifyBreadcrumb() {
        String appName = null;
        List<WebElement> a = elements("app_List");

        for (WebElement el : a) {
            waitTOSync();
            appName = el.getText();
            ReportMsg.info("App name is = " + appName);
            element("app", appName).click();
            ReportMsg.info("Clicked on " + appName);
            selectAppAndVerifyBreadcrumb(appName);
            waitTOSync();
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
            waitTOSync();
        }
    }

    private void selectAppAndVerifyBreadcrumb(String appName) {
        assert element("breadCrumb", appName).isDisplayed();
        ReportMsg.info("verified breadcrumb for " + appName + "app");
    }

    private void userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome() {
        assert element("platfromAvailabilityHome").isDisplayed();
        element("platfromAvailabilityHome").click();
        ReportMsg.info("Clicked on Platfrom Availability Home");
        waitTOSync();
        isElementDisplayed("screenPage");
        ReportMsg.info("verified user navigate to platform Availabilty Screen");
    }

    public void verifyDropDownOptionsWithOptions(String string) {
        element("DropDownSelector").click();
        isElementDisplayed("dropdownOptions", string);
        ReportMsg.info("Verified " + string + " drop down");
    }

    public void clickOnSingleApp(String appName) {
        element("app", appName).click();
        ReportMsg.info("Clicked on " + appName + " app");
    }

    public void verifyTimeZoneForUser(String string) {
        element("timeZoneDropDownSelector").click();
        isElementDisplayed("timezonedropdownOptions", string);
        ReportMsg.info("Verified " + string + " drop down");
    }
}
