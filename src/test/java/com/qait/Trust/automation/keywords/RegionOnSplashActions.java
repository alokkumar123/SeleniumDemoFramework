/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;

public class RegionOnSplashActions extends GetPage {

    public RegionOnSplashActions(WebDriver driver) {
        super(driver, "RegionSpashPage");
        this.driver = driver;
    }

    public void setSystemToAllRegion(String appName) {
        isElementDisplayed("td_systemApp", appName);
        element("td_systemApp", appName).click();
        element("div_regionField").click();
        ReportMsg.info(" set region to all on " + appName + " app");
    }

    public void clickOnButton(String button) {
        element("btn_save", button).click();
        ReportMsg.info("Clicked on save button ");
    }

    public void verifyAppIsDisplayingOnPage(String appName) {
        try {
            isElementDisplayed("singleApp", appName);
            ReportMsg.info("App is dispalying on splash page");
        } catch (Exception e) {
            ReportMsg.info("App is not dispalying on splash page");
        }
    }

    public void navigateToAdminPage() {
        element("link_admin").click();
        element("link_adminPage").click();
    }

    public void setSystemToOtherRegion(String appName, String region) {
        isElementDisplayed("td_systemApp", appName);
        element("td_systemApp", appName).click();
        element("div_regionField").click();
        element("li_otherRegion ", region).click();
        ReportMsg.info("set reigon to "+region);
    }

    public void setRegionFromSplashPage(String region) {
        element("div_spalshLocation").click();
        element("option_setRegion",region).click();
        element("btn_ok").click();
        ReportMsg.info("set reigon to "+region);
    }
}
