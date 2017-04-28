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
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author alokkumar
 */
public class CreateNotificationActions extends GetPage {

    public CreateNotificationActions(WebDriver driver) {
        super(driver, "CreateNotification");
        this.driver = driver;
    }

    public void clickOnNotificationButton() {
        isElementDisplayed("btn_createNotification");
        element("btn_createNotification").click();
        ReportMsg.info("Clicked on Create New Notification button");
    }

    public void selectSystemFromSelectMonitorDropDown(String monitorName, String message) {
        selectMonitorfromDropDown(monitorName);
        setEndDateForMessageInformation();
        enterValueInCommentSection(message);
        clickOnSaveButton();
    }

    public void setEndDateForMessageInformation() {
        element("div_endTimeBox").click();
        element("div_selectTimeMode").click();
        element("btn_close").click();
        element("div_selectTimeMode").click();

        int x = element("div_mintueSlider").getLocation().getX();
        int y = element("div_mintueSlider").getLocation().getY();
        x = x + 1;
        new Actions(driver).dragAndDropBy(element("div_mintueSlider"), x, 0).build().perform();
        ReportMsg.info("Draged minute handle in right side");
        element("btn_ok").click();
        try {
            element("div_endTimeSecondBox").click();
            element("div_selectTimeMode").click();
            element("btn_close").click();
            element("div_selectTimeMode").click();
            int x1 = element("div_mintueSlider").getLocation().getX();
            x1 = x1 + 1;
            //ReportMsg.info(" now x " + x + " y " + y);
            new Actions(driver).dragAndDropBy(element("div_mintueSlider"), x1, 0).build().perform();
            ReportMsg.info("Draged minute handle in right side ");
            element("btn_ok").click();
        } catch (NoSuchElementException ee) {
            ReportMsg.info("Time Setting options is not for Message display");
        }
    }

    public void setStartDateForMessageInformation() {
        element("div_startTimeBox").click();
        element("div_selectTimeMode").click();
        // element("btn_close").click();
        element("div_selectTimeMode").click();

        int x = element("div_mintueSlider").getLocation().getX();
        int y = element("div_mintueSlider").getLocation().getY();
        x = x - 1;
        new Actions(driver).dragAndDropBy(element("div_mintueSlider"), x, 0).build().perform();
        ReportMsg.info("Draged minute handle in left side");
        element("btn_ok").click();
        try {
            element("div_startTimeSecondBox").click();
            element("div_selectTimeMode").click();
            element("btn_close").click();
            element("div_selectTimeMode").click();
            int x1 = element("div_mintueSlider").getLocation().getX();
            x1 = x1 - 1;
            //ReportMsg.info(" now x " + x + " y " + y);
            new Actions(driver).dragAndDropBy(element("div_mintueSlider"), x1, 0).build().perform();
            ReportMsg.info("Draged minute handle in left side ");
            element("btn_ok").click();
        } catch (NoSuchElementException ee) {
            ReportMsg.info("Time Setting options is not for Message display");
        }
    }

    public void selectMonitorfromDropDown(String monitorName) {
        isElementDisplayed("div_selectMonitor");
        element("div_selectMonitor").click();
        element("div_monitorName", monitorName).click();
        ReportMsg.info("Selected " + "'" + monitorName + "'" + " from select monitor drop down");
        element("div_commentSection").click();
    }

    public void selectMonitorfromDropDown(String monitorName, String monitorName1) {
        isElementDisplayed("div_selectMonitor");
        element("div_selectMonitor").click();
        element("div_monitorName", monitorName).click();
        ReportMsg.info("Selected " + monitorName + " from select monitor drop down");
        element("div_monitorName", monitorName1).click();
        ReportMsg.info("Selected " + monitorName1 + " from select monitor drop down");
        element("div_commentSection").click();
    }

    public void enterValueInCommentSection(String message) {
        element("div_commentSection").clear();
        element("div_commentSection").sendKeys(message);
        ReportMsg.info("write " + "'" + message + "'" + " message in comment box ");
    }

    public void clickOnSaveButton() {
        element("btn_save").click();
        ReportMsg.info("clicked on save button");
    }

    public void verifyMessageAndLogoIsDisplayingOrNotDisplayingToUnauthenticatedUser(String splashPageView, String message, String eventType) {
        if (splashPageView.contains("Grouping")) {
            ReportMsg.info(" Verifying created notification under Grouping View splash page");
        } else {
            ReportMsg.info("Verifying created notification under Front View splash page");
        }
        try {
            isElementDisplayed("div_logo");
            ReportMsg.info("Planned maintenance logo is displaying");
            isElementDisplayed("span_notificationWithLogo", message);
            ReportMsg.info("Verified " + "'" + message + "'" + " is displaying to Unauthenticated user 'with logo' for " + " '" + eventType + "' " + " event Type");
        } catch (NoSuchElementException e1) {
            try {
                isElementDisplayed("span_notification", message);
                ReportMsg.info("Verified " + "'" + message + "'" + " is displaying to Unauthenticated user 'without logo' for " + " '" + eventType + "' " + "event Type");
            } catch (NoSuchElementException e) {
                ReportMsg.info("Verified " + "'" + message + "'" + " is not displaying to Unauthenticated user as notification is hided");
            }
        }
    }

    public void searchCreatedNotification(String message) {
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(message);
        ReportMsg.info("Searched notification created by automation script");
    }

    public void deleteCreatedNotification(String message) {
        isElementDisplayed("span_deleteNotification", message);
        element("span_deleteNotification", message).click();
        element("button_delete").click();
        ReportMsg.info("Deleted notifications created by automation Script");
    }

    public void selectSystemFromSelectMonitorDropDownAndHideNotification(String monitorName, String message) {
        selectMonitorfromDropDown(monitorName);
        setEndDateForMessageInformation();
        enterValueInCommentSection(message);
        hideNotificationfromUser();
        clickOnSaveButton();
    }

    private void hideNotificationfromUser() {
        isElementDisplayed("input_enabledCheckBox");
        element("input_enabledCheckBox").click();
        ReportMsg.info(" 'Unchecked on enable button which hides notification' ");
    }

    public void overrideNotificationfromUser() {
        isElementDisplayed("input_overrideCheckBox");
        element("input_overrideCheckBox").click();
        ReportMsg.info(" 'Overided System by clicking on override check box' ");
    }

    public void selectEventType(String eventType) {
        isElementDisplayed("div_eventContainer");
        element("div_eventContainer").click();
        element("div_eventType", eventType).click();
        ReportMsg.info("Selected " + " '" + eventType + "' " + "from event Type Drop Down");
    }

    public void clickOnCreatedNotificationMessage(String message, String monitorName) {
        isElementDisplayed("td_monitorName", monitorName);
        isElementDisplayed("link_Message", message);
        element("link_Message", message).click();
    }

    public void verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(String splashPageView, String message, String eventType, String color) {
        if (splashPageView.contains("Grouping")) {
            ReportMsg.info(" Verifying created notification under Grouping View splash page");
        } else {
            ReportMsg.info("Verifying created notification under Front View splash page");
        }

        if (color.contains("red")) {
            isElementDisplayed("span_redNotificationWithLogo", message);

            ReportMsg.info("Red color noitification is displaying with logo for " + "'" + eventType + "'" + " event type with " + "'" + message + "'" + " message");
        }
        if (color.contains("green")) {
            isElementDisplayed("span_greenNotificationWithLogo", message);
            ReportMsg.info("Green color noitification is displaying with logo for " + "'" + eventType + "'" + " event type with " + "'" + message + "'" + " message");

        }
        if (color.contains("orange")) {
            isElementDisplayed("span_orangeNotificationWithLogo", message);
            ReportMsg.info("Orange color noitification is displaying whith logo for " + "'" + eventType + "'" + " event type with " + "'" + message + "'" + " message");

        }
    }

    public void verifyOverriddenSystem(String monitorName) {
        String currentTime = element("td_currentTime").getText();
        isElementDisplayed("div_greenColor", currentTime);
        ReportMsg.info("Green color bricks are displaying under current time " + "'" + currentTime + "'" + " on Detail Screen Pagge for " + monitorName);
    }

    public void selectSystemAndVerifyItsPrivilege(String systemName) {
        isElementDisplayed("link_systemName", systemName);
        element("link_systemName", systemName).click();
        ReportMsg.info("Clicked on " + systemName + " Form mangae system");
        String text = element("div_accessLevel").getText();
        ReportMsg.info("Privilege of this system is '" + text + "'");
    }

    public void verifySytemUnderPrivileges(String systemName, String privilege) {
        try {
            isElementDisplayed("div_systemWithText", systemName);
            ReportMsg.info("'" + systemName + "'" + "is displaying for '" + privilege + "' privilege");
        } catch (NoSuchElementException e1) {
            ReportMsg.info("'" + systemName + "'" + "is not displaying for '" + privilege + "' privilege");
        }
    }
}
