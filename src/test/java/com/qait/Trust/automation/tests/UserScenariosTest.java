package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class UserScenariosTest extends TestFundamentals {

    String newRole = "Test Role";
    String editRole = "Edited New Role";
    String permission2 = "MonitorCreateAll";
    String permission3 = "MonitorDeleteAll";
    String userName1 = "aditya";
    String email1 = "aditya@qainfotech.com";
    String password1 = "123456";

    @Test
    public void Step_01_Trust_438_Using_Permission_And_Create_New_Role() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.navigateToAdminMenu("Manage roles");
        test.manageRolePage.clickOnAdd("Add Role");
        test.manageRolePage.newFormShouldBeOpened("Add role");
        test.manageRolePage.enterValueInForm("Name", newRole);
        test.manageRolePage.enterValueInForm("Description", "Created By Automation Script");
        test.manageRolePage.clickOnFormField("Permissions");
        test.manageRolePage.setPermissions(permission2);
        test.manageRolePage.setPermissions(permission3);
        test.manageRolePage.clickOnFormField("Permissions");
        test.createAndConfigPage.clickOnSaveButton();
    }

    @Test
    public void Step_02_Trust_438_Using_Role_And_Create_User_Administration() {
        test.createAndConfigPage.navigateToAdminMenu("User Administration");
        test.createAndConfigPage.clickOnAddNewUser();
        test.createAndConfigPage.enterValueInFields("User ID", userName1);
        test.createAndConfigPage.enterValueInFields("Email", email1);
        test.createAndConfigPage.enterValueInFields("Password", password1);
        test.createAndConfigPage.enterValueInFields("Repeat Password", password1);
        test.createAndConfigPage.clickOnSelectRole();
        test.createAndConfigPage.selectRoleFormList(newRole);
        test.createAndConfigPage.enterValueInFields("User ID", userName1);
        test.createAndConfigPage.clickOnSaveButton();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void Step_03_Trust_438_LogIn_With_New_Admin_And_Verify_Values() {
        test.createAndConfigPage.logAsAdmin(userName1, password1);
        test.createAndConfigPage.navigateToAdminMenu("Manage monitors");
        test.createAndConfigPage.clickOnCreateButton();
        test.createAndConfigPage.logOutFromAdmin();
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToAdminMenu("Manage roles");
        test.manageRolePage.clickOnDeleteButton(newRole);
        test.createAndConfigPage.popUpShouldBeAppears("Delete");
        test.createAndConfigPage.navigateToAdminMenu("User Administration");
        test.manageRolePage.clickOnDeleteButton(userName1);
        test.createAndConfigPage.popUpShouldBeAppears("OK");
    }

}
