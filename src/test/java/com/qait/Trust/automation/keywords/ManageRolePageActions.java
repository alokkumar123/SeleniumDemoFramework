package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;

public class ManageRolePageActions extends GetPage {

    public ManageRolePageActions(WebDriver driver) {
        super(driver, "ManageRole");
        this.driver = driver;
    }

    public void validateSearchFunctionalityForPossitiveCycleWithText(String text) {
        ReportMsg.info("Searching with " + text + " text");
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(text);
        ReportMsg.info("Validated " + text + " is displaying after performing Search operation");
    }

    public void clickOnAdd(String addNew) {
        isElementDisplayed("button_addNew", addNew);
        element("button_addNew", addNew).click();
        ReportMsg.info("Clicked on '" + addNew + "' button");
    }

    public void newFormShouldBeOpened(String data) {
        isElementDisplayed("h4_formInfo", data);
        ReportMsg.info(data + " text is displaying on new form");
    }

    public void enterValueInForm(String formField, String name) {
        isElementDisplayed("input_text", formField);
        element("input_text", formField).click();
        element("input_text", formField).clear();
        element("input_text", formField).sendKeys(name);
    }
    
    public void clickOnFormField(String formField) {
        isElementDisplayed("div_selectPermission");
        element("div_selectPermission").click();
    }

    public void setPermissions(String permission) {
        element("div_menuItems", permission).click();
        ReportMsg.info("Set " + permission + " in Permission Field");
    }

    public void newlyCreatedDataShouldBeAvailabeOnList(String data) {
        isElementDisplayed("link_newData", data);
        ReportMsg.info("New created " + data + " is displaying on configured list");
    }

    public void verifyAddedPernissionsAreDisplayingOnManageList(String user, String permission) {
        isElementDisplayed("text_permission", permission);
        ReportMsg.info(permission + " permission is displaying for " + user);
    }

    public void clickOnNewlyCreated(String data) {
        isElementDisplayed("link_newData", data);
        element("link_newData", data).click();
        ReportMsg.info("Clicked on " + data);
    }

    public void editedNewRoleIsDisplaying(String data) {
        isElementDisplayed("link_newData", data);
        ReportMsg.info("Edited Role is Displaying on configured manage list");
    }

    public void clickOnDeleteButton(String editUserName) {
        isElementDisplayed("span_deleteNewUser", editUserName);
        element("span_deleteNewUser", editUserName).click();
        ReportMsg.info("Deleting new user created by automation Script");
    }

    public void addGroup(String groupType,String groupField) {
        element("label_groupField",groupType).click();
        element("list_group",groupField).click();
    }
    
}
