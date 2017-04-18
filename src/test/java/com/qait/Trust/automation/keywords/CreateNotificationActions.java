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
    }

    public void selectMonitorfromDropDown(String monitorName) {
        isElementDisplayed("div_selectMonitor");
        element("div_selectMonitor").click();
        element("div_monitorName", monitorName).click();
        element("div_commentSection").click();
        wait.waitForElementToBeVisible( element("div_selectMonitor"));
    }
    
    public void selectMonitorfromDropDown(String monitorName,String monitorName1) {
        isElementDisplayed("div_selectMonitor");
        element("div_selectMonitor").click();
        element("div_monitorName", monitorName).click();
        element("div_monitorName", monitorName1).click();
        element("div_commentSection").click();
    }

    public void enterValueInCommentSection(String message) {
        element("div_commentSection").clear();
        element("div_commentSection").sendKeys(message);
        ReportMsg.info("write " + "' "+message +" ' " + " message in comment box ");
    }

    public void clickOnSaveButton() {
        element("btn_save").click();
        ReportMsg.info("clicked on save button");
    }

    public void verifyMessageIsDisplayingOrNotDisplayingToUnauthenticatedUser(String splashPageView, String message) {
        if (splashPageView.contains("Grouping")) {
            ReportMsg.info(" Verifying created notification under Grouping View splash page");
        } else {
            ReportMsg.info("Verifying created notification under Front View splash page");
        }
        try {
            isElementDisplayed("span_notification", message);
            ReportMsg.info("Verified " + "'" +message + "'" + " is displaying to Unauthenticated user");
        } catch (NoSuchElementException e) {
            ReportMsg.info("Verified " + "'" +message + "'"+ " is not displaying to Unauthenticated user as notification is hided");
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
}
