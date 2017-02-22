package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;

public class CreateAndConfigureMonitorsPageActions extends GetPage {

    WebDriver driver;
    String monitorName = "Monitor created by automation script";
    String externalServiceId = "123";
    String userName = "harsh";
    String password = "12345";
    String EmailId = "harshsehgal@qainfotech.com";
    String editUserName = "harshNew";
    String searchingText;
    ArrayList<String> roleList = new ArrayList<String>();

    public CreateAndConfigureMonitorsPageActions(WebDriver driver) {
        super(driver, "CreateAndConfigureMonitors");
        this.driver = driver;
    }

    public void logAsAdmin() {
        isElementDisplayed("link_login");
        element("link_login").click();
        element("userName").clear();
        element("userName").click();
        element("userName").sendKeys("Admin");
        element("password").clear();
        element("password").click();
        element("password").sendKeys("Cengage1");
        element("button_login").click();
        ReportMsg.info("Login into admin account");
    }

    public void navigateToAdminMenu(String menuName) {
        isElementDisplayed("div_adminMenu");
        ReportMsg.info("Admin Menu list is displaying on Profile page");
        
        element("link_MenuName", menuName).click();
        ReportMsg.info("Clicked on '" + menuName + "' tab");
    }

    public void clickOnCreateButton() {
        isElementDisplayed("button_Create");
        element("button_Create").click();
        ReportMsg.info("Click on create button");
    }

    public void enterAllMandatoryFieldsAndClickOnSave() {
        isElementDisplayed("div_monitorName");
        element("div_monitorName").click();
        element("div_monitorName").clear();
        element("div_monitorName").sendKeys(monitorName);
        ReportMsg.info("Entered monitor name : " + monitorName + " in mandatory field");
        isElementDisplayed("div_externalServiceId");
        element("div_externalServiceId").click();
        element("div_externalServiceId").clear();
        element("div_externalServiceId").sendKeys(externalServiceId);
        ReportMsg.info("Entered external service id : " + externalServiceId + " in mandatory field");
        isElementDisplayed("button_save");
        element("button_save").click();
        ReportMsg.info("Click On save button");
    }

    public void newCreatedMonitorShouldBeOpen() {
        isElementDisplayed("link_newCreatedMonitor", monitorName);
        element("link_newCreatedMonitor", monitorName).click();
        ReportMsg.info("Created monitor is opened ");
    }

    public void newCreatedMonitorsShouldBeSeenOnTheList() {
        isElementDisplayed("link_newCreatedMonitor", monitorName);
        ReportMsg.info("New Created monitor is displaying on manage monitor list ");
    }

    public void allInformationEnteredInFormShouldBeSaved() {
        String savedMonitorName = element("div_monitorName").getAttribute("value");
        assertEquals(savedMonitorName, monitorName, "Saved information is not correct for moitor name ");
        ReportMsg.info("Verified saved monitor name is " + savedMonitorName);
        isElementDisplayed("div_externalServiceId");
        element("div_externalServiceId").getText();
        String savedExternamServiceId = element("div_externalServiceId").getAttribute("value");
        assertEquals(savedExternamServiceId, externalServiceId, "Saved information is not correct for external service id ");
        ReportMsg.info("Verified saved service external id is " + externalServiceId);
    }

    public void logOutFromAdmin() {
        isElementDisplayed("button_Admin");
        element("button_Admin").click();
        ReportMsg.info("Click on admin button");
        isElementDisplayed("logout_adminPage");
        element("logout_adminPage").click();
        element("link_ok").click();
        ReportMsg.info("Log out from admin account");
    }

    public void gridShouldBeAvailableFor(String string) {
        isElementDisplayed("span_gridFields", string);
        ReportMsg.info("'" + string + "' Grid is available on Manage Regions page");
    }

    public void createButtonAndSearchTextBarShouldBeAvailable() {
        isElementDisplayed("button_Create");
        ReportMsg.info("Created button is available");
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
    }

    public void breadcrumbShouldBeAvailableForNavigation(String breadCrumb) {
        isElementDisplayed("link_breadCrumb", breadCrumb);
        ReportMsg.info("Verified breadcrumb for admin");
    }

    public void userNavigateToMonitorEditScreen() {
        isElementDisplayed("link_newCreatedMonitor", monitorName);
        element("link_newCreatedMonitor", monitorName).click();
        ReportMsg.info("User Navigated to Monitor Edit Screen");
    }

    public void userEditAndReSaveMangaeMonitor() {
        monitorName = "Monitor edited by automation script";
        isElementDisplayed("div_monitorName");
        element("div_monitorName").click();
        element("div_monitorName").clear();
        element("div_monitorName").sendKeys(monitorName);
        ReportMsg.info("Entered monitor name : " + monitorName + " in mandatory field");
        isElementDisplayed("div_externalServiceId");
        element("div_externalServiceId").click();
        element("div_externalServiceId").clear();
        element("div_externalServiceId").sendKeys(externalServiceId);
        ReportMsg.info("Entered external service id : " + externalServiceId + " in mandatory field");
        isElementDisplayed("button_save");
        element("button_save").click();
        ReportMsg.info("Resave edited manage monitor");
    }

    public void editedMonitorsShouldBeSeenOnTheList() {
        monitorName = "Monitor edited by automation script";
        isElementDisplayed("link_newCreatedMonitor", monitorName);
        ReportMsg.info("Edited monitor is displaying on manage monitor list ");
    }

    public void deleteMonitorCreatedByAutomationScript() {
        ReportMsg.info("Deleting monitor created by automation script - TRUST-398");
        isElementDisplayed("span_deleteMonitors");
        element("span_deleteMonitors").click();
        element("button_delete").click();
        ReportMsg.info("Deleted monitors created by automation Script");
    }

    public void clickOnAddNewUser() {
        isElementDisplayed("button_AddNewUser");
        element("button_AddNewUser").click();
        ReportMsg.info("Clicked on 'Add a New User' button");
    }

    public void userNavigatedToNewUserScreen() {
        isElementDisplayed("text_newUserScreen");
        ReportMsg.info("User Navigated to new user screen");
    }

    public void shortingOfRecordswith(String field, String index) {
        isElementDisplayed("span_shortingFields", index);
        elements("span_shortingFields", index);
        ReportMsg.info(field + " before sorting ");
        for (WebElement ele : elements("span_shortingFields", index)) {
            if (!(ele.getText().equals(null))) {
                ReportMsg.info(ele.getText());
            }
        }
        element("span_Assending", index).click();
        ReportMsg.info("Click on Assending order");
        ReportMsg.info(field + " after assendiing order ");
        for (WebElement ele : elements("span_shortingFields", index)) {
            if(!(ele.getText().equals(null))) {
                ReportMsg.info(ele.getText());
            }
        }
        element("span_Desending", index).click();
    }

    public void validateSearchFunctionalityForPossitiveCycle() {
        searchingText = "Jason Chin H";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        isElementDisplayed("searched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation ");
        searchingText = "GPT Ames ";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        isElementDisplayed("searched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation ");
        searchingText = "Patsy Ames";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        isElementDisplayed("searched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation ");
        searchingText = "jason.chin@cengage.com";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        isElementDisplayed("searched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after performing search operation ");
    }

    public void validateSearchFunctionalityForNegativeCycle() {
        ReportMsg.info("Searching with irrelavent word");
        searchingText = "Wrong text";
        isElementDisplayed("input_searchBox");
        ReportMsg.info("Search box is available");
        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(searchingText);
        ReportMsg.info("Validated no result is available after performing " + searchingText + " in search box");
        element("input_searchBox").click();
        element("input_searchBox").clear();
    }

    public void verifyNewFormShouldOpenWithFollowingFields(String formField) {
        element("input_text", formField).click();
        element("input_text", formField).clear();
        element("input_text", formField).sendKeys("");
    }

    public void enterUserIdInUserForm(String formField) {
        element("input_text", formField).click();
        element("input_text", formField).clear();
        element("input_text", formField).sendKeys(userName);
        ReportMsg.info("Entered user Id: '" + userName + "'");
    }

    public void clickOnRoleSelector() {
        element("div_Selector").click();
        ReportMsg.info("Clicked on 'Roles' dropdown on 'Add new User' screen");
        for (WebElement ele : elements("div_menuItems")) {
            String menuItem = ele.getText();
            roleList.add(menuItem);
            ReportMsg.info(menuItem);
        }
    }

    public void rolesDisplayingOnManageRoles() {
        Iterator<String> itr = roleList.iterator();
        for (WebElement el : elements("div_ItemRoles")) {
            String item = el.getText();
            String roleItem = itr.next();
            if (roleItem.contains(item)) {
                ReportMsg.info("Existing Roles appearing on Manage Role Tab: '" + roleItem + "'");
            }
        }
    }

    public void enterEmailIdInUserForm(String formField) {
        element("input_text", formField).click();
        element("input_text", formField).clear();
        element("input_text", formField).sendKeys(EmailId);
        ReportMsg.info("Entered Email Id ");
    }

    public void enterPasswordInUserForm(String formField) {
        element("input_text", formField).click();
        element("input_text", formField).clear();
        element("input_text", formField).sendKeys(password);
        ReportMsg.info("Entered Password ");
    }

    public void enterRepasswordInUserForm(String formField) {
        element("input_text", formField).click();
        element("input_text", formField).clear();
        element("input_text", formField).sendKeys(password);
        ReportMsg.info("Entered Repassword ");
    }

    public void clickOnSaveButton() {
        element("button_save").click();
        ReportMsg.info("Clicked On save button");
    }

    public void newCreatedUserIsDisplayingOnMonitorScreen() {
        isElementDisplayed("div_userName", userName);
        ReportMsg.info("Newly Created User is displaying on Configure Monitor Screen");
    }

    public void EditNewlyCreatedUser(String formField) {
        element("div_userName", userName).click();
        element("input_text", formField).click();
        element("input_text", formField).clear();
        element("input_text", formField).sendKeys(editUserName);
        ReportMsg.info("Edited User Id ");
    }

    public void EditedUserIsDisplayingOnMonitorScreen() {
        isElementDisplayed("div_editedUserName", editUserName);
        ReportMsg.info("Edited User is displaying on Configure Monitor Screen");
    }

    public void userNavigateToSameUserAndCheckLogBelowSaveButton() {
        element("div_editedUserName", editUserName).click();
        ReportMsg.info("Navigated to same user ");

        isElementDisplayed("td_oldValue", userName);
        ReportMsg.info("Old value of user name is dislapying below save button");
        isElementDisplayed("td_newValue", editUserName);
        ReportMsg.info("New value of user name is dislapying below save button");
    }

    public void popUpShouldBeAppears(String popUp) {
        isElementDisplayed("button_popUp", popUp);
        element("button_popUp", popUp).click();
        ReportMsg.info("Clicked on " + popUp);
    }

    public void clickOnDeleteButton() {
        isElementDisplayed("span_deleteNewUser", editUserName);
        element("span_deleteNewUser", editUserName).click();
        ReportMsg.info("Deleting new user created by automation Script");
    }

    public void enterValueInFields(String formField, String value) {
        element("input_text", formField).click();
        element("input_text", formField).clear();
        element("input_text", formField).sendKeys(value);
        ReportMsg.info("Entered " + formField + " value");
    }

    public void clickOnSelectRole() {
        element("div_selectRole").click();
    }

    public void selectRoleFormList(String newRole) {
        element("div_selectRoleValue", newRole).click();
        ReportMsg.info("Selected " + newRole + " from role list");
    }

    public void logAsAdmin(String userName, String password) {
        isElementDisplayed("link_login");
        element("link_login").click();
        element("userName").clear();
        element("userName").click();
        element("userName").sendKeys(userName);
        element("password").clear();
        element("password").click();
        element("password").sendKeys(password);
        element("button_login").click();
        ReportMsg.info("Login into admin account");
    }
}
