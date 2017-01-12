/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;

public class CheckSearchFunctionalityCyclePageActions extends GetPage {

    public CheckSearchFunctionalityCyclePageActions(WebDriver driver) {
        super(driver, "CheckSearchFunctionalityCycle");
        this.driver = driver;
    }

    String searchingText;
    String description = "Created new system by automation script";
    String newSystem = "New System";

    public void validateSearchFunctionalityForPossitiveCycle() {
        searchingText = "M";
        isElementDisplayed("input_serachBox");
        ReportMsg.info("Search box is available");
        element("input_serachBox").clear();
        element("input_serachBox").sendKeys(searchingText);
        isElementDisplayed("searched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after perfroming search operation ");
        searchingText = "Mind";
        isElementDisplayed("input_serachBox");
        ReportMsg.info("Search box is available");
        element("input_serachBox").clear();
        element("input_serachBox").sendKeys(searchingText);
        isElementDisplayed("searched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after perfroming search operation ");
        searchingText = "MindTap Math";
        isElementDisplayed("input_serachBox");
        ReportMsg.info("Search box is available");
        element("input_serachBox").clear();
        element("input_serachBox").sendKeys(searchingText);
        isElementDisplayed("searched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after perfroming search operation ");
        searchingText = "MindTap Math Foundations";
        isElementDisplayed("input_serachBox");
        ReportMsg.info("Search box is available");
        element("input_serachBox").clear();
        element("input_serachBox").sendKeys(searchingText);
        isElementDisplayed("searched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after perfroming search operation ");

    }

    public void validateSearchFunctionalityForNegativeCycle() {
        searchingText = "Worng text";
        isElementDisplayed("input_serachBox");
        ReportMsg.info("Search box is available");
        element("input_serachBox").clear();
        element("input_serachBox").sendKeys(searchingText);
        ReportMsg.info("Validated no result is availble after performing " + searchingText + " in search box");

    }

    public void userCheckCreateNewSystem() {
        isElementDisplayed("button_Create");
        element("button_Create").click();
        isElementDisplayed("h4_createSystem");
        ReportMsg.info(" User navigated to Create System screen");
    }

    public void userCreateNewSystemFormAndSave() {

        isElementDisplayed("div_SystemName");
        element("div_SystemName").click();
        element("div_SystemName").clear();
        element("div_SystemName").sendKeys(newSystem);
        ReportMsg.info("Entered system name : " + newSystem + " in mandatory field");
        element("div_discription").click();
        element("div_discription").clear();
        element("div_discription").sendKeys(description);
        ReportMsg.info("Entered description name : " + description + " in mandatory field");
        isElementDisplayed("button_save");
        element("button_save").click();
        ReportMsg.info("User Created new System Form and Saved Form");
    }

    public void savedDataShouldBeSeenInTheListScreen() {
        isElementDisplayed("link_newCreatedSystem", newSystem);
        ReportMsg.info("Verified new system created  by automatrion script named as " + newSystem + " is displaying on Screen list");
        isElementDisplayed("text_description", description);
        ReportMsg.info("Verified description of created system named as  " + description + " is displaying on on Screen list");
    }

    public void verifyMoveUpFunctionality() {
        String appBeforeMoveUp = element("text_moveUp").getText();
        ReportMsg.info("App on 3rd row before clicking on moveUp " + appBeforeMoveUp);
        element("link_moveUp").click();
        String appAfterMoveUp = element("text_moveUp").getText();
        ReportMsg.info("App on 3rd row after clicking on moveUp " + appAfterMoveUp);
    }

    public void deleteNewlyCretedSystem() {
        isElementDisplayed("span_deleteSyetem",newSystem);
        element("span_deleteSyetem",newSystem).click();
        element("button_delete").click();
        ReportMsg.info("Deleted nely system created by automation Script");
    }
}
