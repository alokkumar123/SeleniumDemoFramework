package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManageSystemsPageActions extends GetPage {
    
    String searchingText;
    String description = "Created new system by automation script";
    String newSystem = "New Automation System";
    
    public ManageSystemsPageActions(WebDriver driver) {
        super(driver, "ManageSystem");
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
           Assert.assertTrue(searchResult.getText().toLowerCase().contains(searchingText.toLowerCase()), 
                   "[Assertion Failed]: Search results are NOT matching as per search term!!!");
        }
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation");
        
        searchingText = "CengageBrain";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        ReportMsg.info("No. of search results: " + elements("list_searchSystem").size());
        for (WebElement searchResult : elements("list_searchSystem")){
           ReportMsg.info("List of systems displayed from '" + searchingText + "': " + searchResult.getText());
            Assert.assertTrue(searchResult.getText().toLowerCase().contains(searchingText.toLowerCase()), 
                   "[Assertion Failed]: Search results are NOT matching as per search term!!!");
        }
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation");
        
        searchingText = "CNOWv1";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        ReportMsg.info("No. of search results: " + elements("list_searchSystem").size());
        for (WebElement searchResult : elements("list_searchSystem")){
           ReportMsg.info("List of systems displayed from '" + searchingText + "': " + searchResult.getText());
            Assert.assertTrue(searchResult.getText().toLowerCase().contains(searchingText.toLowerCase()), 
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
        ReportMsg.info("User clicked on 'Create' button on Configured System page");
    }

    public void userCreateNewSystemFormAndSave() {
        element("div_SystemName").click();
        element("div_SystemName").clear();
        element("div_SystemName").sendKeys(newSystem);
        ReportMsg.info("Entered system name : " + newSystem + " in mandatory field");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        
        element("div_discription").click();
        element("div_discription").clear();
        element("div_discription").sendKeys(description);
        ReportMsg.info("Entered description name : " + description + " in mandatory field");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        
        // element("button_save").click();
        executeJavascript("document.getElementsByClassName('btn btn-primary')[1].click()");
        ReportMsg.info("User created system named: '" + newSystem + "'");
    }

    public void savedDataShouldBeSeenInTheListScreen() {
        element("input_searchBox").click();
        scrollTop();
        scrollDown();
        
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
        isElementDisplayed("span_deleteSystem", newSystem);
        element("span_deleteSystem", newSystem).click();
        element("button_delete").click();
        ReportMsg.info("Deleted newly system named as " + newSystem + " created by automation Script");
    }
    
    public boolean verifyAnySystemCreatedByAutomationScriptIsAppearing(String newSystem) {
        boolean flag = false;
        try {
            ReportMsg.info("No. of Systems: " + elements("list_searchSystem").size());
            for (WebElement system : elements("list_searchSystem")) {
                if (system.getText().equalsIgnoreCase(newSystem)) {
                    ReportMsg.info("Found system created by automation script: '" + system.getText() + "'");
                    flag = true;
                }
            }
            if (flag) {
                ReportMsg.info("Systems are appearing created from automation scripts!!!");
            } else {
                ReportMsg.info("NO existing systems are appearing created from automation scripts!!!");
            }
            return flag;
        } catch (TimeoutException ex) {
            ReportMsg.info("NO Systems found created by automation scripts!!!");
            return flag;
        }
    }
    
    public void verifyDeleteApplicationModalWindowIsDisplayed() {
        Assert.assertTrue(
                element("modal_deleteContent").isDisplayed(),
                "[Assertion Failed]: Delete Modal is NOT displayed!!!");
        logMessage("[Assertion Passed]: Delete Modal is DISPLAYED!!!");

        Assert.assertEquals(element("txt_deleteHeader").getText(), "Delete application",
                "[Assertion Failed]: Delete Modal Header is NOT matching!!!");
        logMessage("[Assertion Passed]: Delete Modal Header is MATCHING!!!");
        
        Assert.assertTrue(
                element("btn_modalFooter", "Delete").isDisplayed(),
                "[Assertion Failed]: 'Delete' button is NOT displayed!!!");
        logMessage("[Assertion Passed]: 'Delete' button is DISPLAYED!!!");

        Assert.assertTrue(
                element("btn_modalFooter", "Cancel").isDisplayed(),
                "[Assertion Failed]: 'Cancel' button is NOT displayed!!!");
        logMessage("[Assertion Passed]: 'Cancel' button is DISPLAYED!!!\n");
    }
    
    public void deleteNewlyCreatedSystem(boolean flag, String newSystem) {        
        if(flag) {
            ReportMsg.info("No. of Systems: " + elements("list_searchSystem").size());
            for (WebElement system : elements("list_searchSystem")) {
                // NOTE: To bypass StaleElement Reference exeception
                wait.hardWait(1);
                if (system.getText().equalsIgnoreCase(newSystem)) {
                    ReportMsg.info("Found system created by automation script: '" + system.getText() + "'");

                    element("span_trashIcon", newSystem).click();
                    ReportMsg.info("Clicked on 'Trash' icon");
                    
                    verifyDeleteApplicationModalWindowIsDisplayed();
                    
                    executeJavascript("document.getElementsByClassName('btn btn-danger')[0].click()");
                    ReportMsg.info("Clicked on 'Delete' button");
                }
            }
        }
    }
    
}
