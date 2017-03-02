package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ManageRolesTest extends TestFundamentals {

    String newRole = "New Role";
    String editRole = "Edited New Role";
    String permission1 = "Admin Stats";
    String permission2 = "MonitorCreateAll";
    String permission3 = "MonitorDeleteAll";

    @Test
    public void TRUST_422_Step01_Check_User_Administration_Manage_Users() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.navigateToAdminMenu("Manage roles");
        test.createAndConfigPage.gridShouldBeAvailableFor("Name");
        test.createAndConfigPage.gridShouldBeAvailableFor("Description");
        test.createAndConfigPage.gridShouldBeAvailableFor("Permissions");
    }

    @Test
    public void TRUST_422_Step02_Check_Search_Functionality_Positive_Cycle() {
        test.manageRolePage.validateSearchFunctionalityForPositiveCycleWithText("Admin");
        test.manageRolePage.validateSearchFunctionalityForPositiveCycleWithText("System Owner");
        test.manageRolePage.validateSearchFunctionalityForPositiveCycleWithText("Devops");
        test.manageRolePage.validateSearchFunctionalityForPositiveCycleWithText("System Owner (Aplia)");
    }

    @Test
    public void TRUST_422_Step03_Check_Search_Functionality_Negative_Cycle() {
        test.createAndConfigPage.validateSearchFunctionalityForNegativeCycle();
    }

    @Test
    public void TRUST_422_Step04_Check_Add_A_New_Role() {
        test.manageRolePage.clickOnAdd("Add Role");
        test.manageRolePage.newFormShouldBeOpened("Add role");
        test.manageRolePage.enterValueInForm("Name", newRole);
        test.manageRolePage.enterValueInForm("Description", "Created By Automation Script");
        test.manageRolePage.clickOnFormField("Permissions");
        test.manageRolePage.setPermissions(permission1);
        test.manageRolePage.setPermissions(permission2);
        test.manageRolePage.setPermissions(permission3);
        test.manageRolePage.clickOnFormField("Permissions");
        test.createAndConfigPage.clickOnSaveButton();
    }

    @Test
    public void TRUST_422_Step05_Check_Newly_Created_Role_Must_Be_Listed_On_The_Configured_Manage_Roles() {
        test.manageRolePage.newlyCreatedDataShouldBeAvailabeOnList(newRole);
        test.manageRolePage.verifyAddedPernissionsAreDisplayingOnManageList(newRole, permission1);
        test.manageRolePage.verifyAddedPernissionsAreDisplayingOnManageList(newRole, permission2);
        test.manageRolePage.verifyAddedPernissionsAreDisplayingOnManageList(newRole, permission3);
    }

    @Test
    public void TRUST_422_Step06_Click_Edit_Role() {
        test.manageRolePage.clickOnNewlyCreated(newRole);
        test.manageRolePage.enterValueInForm("Name", editRole);
        test.createAndConfigPage.clickOnSaveButton();
        test.manageRolePage.editedNewRoleIsDisplaying(editRole);
    }

    @Test
    public void TRUST_422_Step07_Delete_User_Created_By_Automation_Script() {
        test.manageRolePage.clickOnDeleteButton(editRole);
        test.createAndConfigPage.popUpShouldBeAppears("Cancel");
        test.manageRolePage.editedNewRoleIsDisplaying(editRole);
        test.manageRolePage.clickOnDeleteButton(editRole);
        test.createAndConfigPage.popUpShouldBeAppears("Delete");
    }
}