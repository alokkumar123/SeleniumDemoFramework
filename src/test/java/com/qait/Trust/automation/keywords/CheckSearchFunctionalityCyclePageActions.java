package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckSearchFunctionalityCyclePageActions extends GetPage {
    
    String searchingText;
    String description = "Created new system by automation script";
    String newSystem = "New System";
    
    public CheckSearchFunctionalityCyclePageActions(WebDriver driver) {
        super(driver, "CheckSearchFunctionalityCycle");
        this.driver = driver;
    }
    
    public void validateSearchFunctionalityForPositiveCycle() {
        searchingText = "MindTap";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText); 
        ReportMsg.info("No. of search results: " + elements("list_searchSystem").size());
        for (WebElement searchResult : elements("list_searchSystem")){
           ReportMsg.info("List of systems displayed from '" + searchingText + "': " + searchResult.getText());
           Assert.assertTrue(searchResult.getText().contains(searchingText), 
                   "[Assertion Failed]: Search results are NOT matching as per search term!!!");
        }
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation");
        
        searchingText = "MindTap Math";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        ReportMsg.info("No. of search results: " + elements("list_searchSystem").size());
        for (WebElement searchResult : elements("list_searchSystem")){
           ReportMsg.info("List of systems displayed from '" + searchingText + "': " + searchResult.getText());
           Assert.assertTrue(searchResult.getText().contains(searchingText), 
                   "[Assertion Failed]: Search results are NOT matching as per search term!!!");
        }
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation");
        
        searchingText = "MindTap Math Foundations";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        ReportMsg.info("No. of search results: " + elements("list_searchSystem").size());
        for (WebElement searchResult : elements("list_searchSystem")){
           ReportMsg.info("List of systems displayed from '" + searchingText + "': " + searchResult.getText());
           Assert.assertTrue(searchResult.getText().contains(searchingText), 
                   "[Assertion Failed]: Search results are NOT matching as per search term!!!");
        }
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation");
    }
    
    
    public void validateSearchFunctionalityForNegativeCycle() {
        searchingText = "Wrong text";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        ReportMsg.info("Validated no result is availble after performing " + searchingText + " in search box");
    }

    public void userCheckCreateNewSystem() {
        element("button_Create").click();
        isElementDisplayed("h4_createSystem");
        ReportMsg.info(" User navigated to Create System screen");
    }

    public void userCreateNewSystemFormAndSave() {
        element("div_SystemName").click();
        element("div_SystemName").clear();
        element("div_SystemName").sendKeys(newSystem);
        ReportMsg.info("Entered system name : " + newSystem + " in mandatory field");
        
        element("div_discription").click();
        element("div_discription").clear();
        element("div_discription").sendKeys(description);
        ReportMsg.info("Entered description name : " + description + " in mandatory field");
        
        element("button_save").click();
        ReportMsg.info("User created system named: " + newSystem);
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

    public void deleteNewlyCreatedSystem() {
        isElementDisplayed("span_deleteSyetem", newSystem);
        element("span_deleteSyetem", newSystem).click();
        element("button_delete").click();
        ReportMsg.info("Deleted newly system amaned as " + newSystem + " created by automation Script");
    }
}
