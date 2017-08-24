/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author alokkumar
 */
public class RegressionTestsPageActions extends GetPage {

    public RegressionTestsPageActions(WebDriver driver) {
        super(driver, "RegressionTestsPage");
        this.driver = driver;
    }

    public void verifyRegressionTestsSystem() {
        isElementDisplayed("div_RegressionApp");
        ReportMsg.info("Verified Regression App is displaying ");
    }

    public void checkTheSystemColor(String system) {
        isElementDisplayed("div_RegressionApp");
        String a[] = element("div_SystemColorStatus", system).getAttribute("style").split(":");
        if (a[1].contains("green")) {
            ReportMsg.info("System color is green");

        } else if (a[1].contains("orange")) {
            ReportMsg.info("System color is orange");
        } else if (a[1].contains("yellow")) {
            ReportMsg.info("System color is yellow");
        }
    }

    public void clickOnAggreateSystem(String systemName, String systemView) {
        int count = 0;
        if (systemView.equalsIgnoreCase("Grouping")) {
            for (WebElement grp : elements("list_groupHeading")) {
                try {
                    element("div_RegressionApp").click();
                    ReportMsg.info("Clicked on '" + systemName + "' System");
                    for (WebElement e : elements("list_system")) {
                        ReportMsg.info("monitor displaying with name " + e.getText());
                    }
                    break;
                } catch (TimeoutException ex) {
                    ReportMsg.info("Expanded state of '" + grp.getText() + "': " + grp.getAttribute("aria-expanded"));
                    if (grp.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
                        grp.click();
                        ReportMsg.info("Clicked on '" + grp.getText().trim() + "' group");

                    }
                }
                count++;
                if (elements("list_groupHeading").size() == count) {
                    element("div_RegressionApp").click();
                    ReportMsg.info("Clicked on system '" + systemName + "'");
                    element("div_RegressionApp").click();
                    for (WebElement e : elements("list_system")) {
                        ReportMsg.info("monitor displaying with name " + e.getText());
                    }
                }
            }
        } else if (systemView.equalsIgnoreCase("Front")) {
            isElementDisplayed("div_RegressionApp");
            element("div_RegressionApp").click();
            ReportMsg.info("Clicked on '" + systemName + "' System");
            for (WebElement e : elements("list_system")) {
                ReportMsg.info("monitor displaying with name " + e.getText());
            }

        }
    }

    public void navigateToAdminPage() {
        element("link_adminButton").click();
        element("link_adminPage").click();

    }

    public void setNewNoitifcation(String appName, String eventType) {
        isElementDisplayed("button_createNotification");
        element("button_createNotification").click();
        ReportMsg.info("Click on create new notification button");
        isElementDisplayed("div_selectMonitor");
        element("div_selectMonitor").click();
        isElementDisplayed("select_system", appName);
        element("select_system", appName).click();
        element("div_commentBox").click();
        element("div_endTimeBox").click();
        element("div_selectTimeMode").click();
        element("btn_close").click();
        element("div_selectTimeMode").click();
        int x = element("div_mintueSlider").getLocation().getX();
        // int y = element("div_mintueSlider").getLocation().getY();
        x = x + 1;
        new Actions(driver).dragAndDropBy(element("div_mintueSlider"), x, 0).build().perform();
        ReportMsg.info("Draged minute handle in right side");
        element("btn_ok").click();

        element("div_endTimeSecondBox").click();
        element("div_selectTimeMode").click();
        element("btn_close").click();
        element("div_selectTimeMode").click();
        int x1 = element("div_mintueSlider").getLocation().getX();
        // int y1 = element("div_mintueSlider").getLocation().getY();
        x = x + 1;
        new Actions(driver).dragAndDropBy(element("div_mintueSlider"), x1, 0).build().perform();
        ReportMsg.info("Draged minute handle in right side ");
        element("btn_ok").click();

        String message = "test of informational icon availability";
        element("div_commentBox").clear();
        element("div_commentBox").sendKeys(message);
        ReportMsg.info("write " + message + " in comment box ");
        isElementDisplayed("div_eventContainer");
        element("div_eventContainer").click();
        element("div_eventType", eventType).click();
        element("btn_save").click();
        ReportMsg.info("clicked on save button");
    }

    public void clickOnMonitorUnderRegressionTest(String monitorName) {
        element("link_RegressionTest").click();
        element("link_RegressionTestMonitor", monitorName).click();
    }
}
