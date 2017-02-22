/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailScreen_GroupActions extends GetPage {

    public DetailScreen_GroupActions(WebDriver driver) {
        super(driver, "DetailScreenGroup");
        this.driver = driver;
    }

    public void verifyGroupOnSplashPage() {
        isElementDisplayed("div_groupGroup");
        ReportMsg.info("Group view is displaying on Splash page");
    }

    public void verifyingGroupNamesDisplayingOnSplashPage() {
        isElementDisplayed("div_groupNameList");
        ReportMsg.info("Names of group displaying on splash page");
        for (WebElement ele : elements("div_groupNameList")) {
            ReportMsg.log(ele.getText());
        }
    }

    public void clickOnGroupAndVerifyApps() {
        clickOnGroupAndVerifyAppsInsideGroup();

    }

    private void clickOnGroupAndVerifyAppsInsideGroup() {
        int i = 0;
        for (WebElement ele : elements("div_groupNameList")) {
            elements("div_groupNameList").get(i).click();
            String groupName = elements("div_groupNameList").get(i).getText();
            ReportMsg.log("clicked on group " + groupName);
            ReportMsg.log("verifying Apps inside " + groupName + "group");
            verifyAppsInsideThis(groupName);
            i++;
        }
    }

    private void verifyAppsInsideThis(String groupName) {
        isElementDisplayed("div_appsInsideGroup", groupName);
        int j = 0;
        for (WebElement el : elements("div_appsInsideGroup", groupName)) {
            elements("div_appsInsideGroup", groupName).get(j).click();
            isElementDisplayed("txt_appName");
            String appName = element("txt_appName").getText();
            String a[] = appName.split("> ");
            appName = a[1];
            ReportMsg.info("Clicked on " + appName + " app");
            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
            j++;
        }
        ReportMsg.info("Verified all the apps under " + groupName + " group ");
    }

    public void userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome() {
        isElementDisplayed("link_platfromAvailabilityHome");
        element("link_platfromAvailabilityHome").click();
        ReportMsg.info("Clicked on Platfrom Availability Home");
        isElementDisplayed("div_groupNameList");
        ReportMsg.info("verified user navigate to platform Availabilty Screen");
    }
}
