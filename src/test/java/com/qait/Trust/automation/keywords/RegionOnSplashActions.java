/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

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
        int i = 0;
        Boolean app;
        try {
            ReportMsg.info("Groups of monitors are displaying on spash page");
            for (WebElement ele : elements("div_groupNameList")) {
                elements("div_groupNameList").get(i).click();
                String groupName = elements("div_groupNameList").get(i).getText();
                ReportMsg.log("clicked on group " + groupName);
                ReportMsg.log("verifying Apps inside " + groupName + "group");
                app = verifyAppsInsideThis1(groupName, appName);
                if (app) {
                    break;
                }
                i++;
            }
        } catch (NoSuchElementException e) {
            isElementDisplayed("singleApp", appName);
            ReportMsg.info("App is dispalying on splash page");
        }
    }

    private boolean verifyAppsInsideThis1(String groupName, String appName) {
        Boolean value = null;
        try {
            value = isElementDisplayed("singleApp", appName);
            ReportMsg.info("App is dispalying on splash page under " + groupName + " group name");
        } catch (NoSuchElementException e) {
            ReportMsg.info("App is not dispalying on splash page under " + groupName + " group name");
            value =false;
        }
        return value;
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
        ReportMsg.info("set reigon to " + region);
    }

    public void setRegionFromSplashPage(String region) {
        element("div_spalshLocation").click();
        element("option_setRegion", region).click();
        element("btn_ok").click();
        ReportMsg.info("set reigon to " + region);
    }
}
