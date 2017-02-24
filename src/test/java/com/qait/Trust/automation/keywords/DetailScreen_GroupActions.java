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
        if (groupName.contains("Ungrouped")) {
            ReportMsg.log("***** Monitors those are not in any groups *****");
            for (WebElement el : elements("div_appsInsideGroup", groupName)) {
                elements("div_appsInsideGroup", groupName).get(j).click();
                String appName = element("txt_appName").getText();
                String a[] = appName.split("> ");
                appName = a[1];
                ReportMsg.log(appName);
                userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome1();
                j++;
            }
        }
        j = 0;
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
        isElementDisplayed("link_platformAvailabilityHome");
        element("link_platformAvailabilityHome").click();
        ReportMsg.info("Clicked on Platfrom Availability Home");
        isElementDisplayed("div_groupNameList");
        ReportMsg.info("verified user navigate to platform Availabilty Screen");
    }

    public void userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome1() {
        element("link_platformAvailabilityHome").click();
    }

    public String clickOnGroupAndVerifyApps1() {
        String appName = clickOnGroupAndVerifyAppsInsideGroup1();
        return appName;
    }

    private String clickOnGroupAndVerifyAppsInsideGroup1() {
        int i = 0;
        String app = null;
        for (WebElement ele : elements("div_groupNameList")) {
            elements("div_groupNameList").get(i).click();
            String groupName = elements("div_groupNameList").get(i).getText();
            ReportMsg.log("clicked on group " + groupName);
            ReportMsg.log("verifying Apps inside " + groupName + "group");
            app = verifyAppsInsideThis1(groupName);
            break;
        }
        return app;
    }

    private String verifyAppsInsideThis1(String groupName) {
        int j = 0;
        String appName = null;
        for (WebElement el : elements("div_appsInsideGroup", groupName)) {
            elements("div_appsInsideGroup", groupName).get(j).click();
            isElementDisplayed("txt_appName");
            appName = element("txt_appName").getText();
            String a[] = appName.split("> ");
            appName = a[1];
            ReportMsg.info("Clicked on " + appName + " app");

            userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
            break;

        }
        return appName;
    }
    
}
