package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ManageRolesTest extends TestFundamentals {

    String newRole = "New Role";
    String editRole = "Edited New Role";
    String permission1 = "Create region";
    String permission2 = "MonitorDeleteAll";
    String permission3 = "MonitorEditAll";


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
        test.managRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Admin");
        test.managRolePage.validateSearchFunctionalityForPossitiveCycleWithText("System Owner");
        test.managRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Devops");
        test.managRolePage.validateSearchFunctionalityForPossitiveCycleWithText("System Owner (Aplia)");
    }

    @Test
    public void TRUST_422_Step03_Check_Search_Functionality_Negative_Cycle() {
        test.createAndConfigPage.validateSearchFunctionalityForNegativeCycle();
    }

    @Test
    public void TRUST_422_Step04_Check_Add_A_New_Role() {
        test.managRolePage.clickOnAdd("Add Role");
        test.managRolePage.newFormShouldBeOpened("Add role");
        test.managRolePage.enterValueInForm("Name", newRole);
        test.managRolePage.enterValueInForm("Description", "Created By Automation Script");
        test.managRolePage.clickOnFormField("Permissions");
        test.managRolePage.setPermissions(permission1);
        test.managRolePage.setPermissions(permission2);
        test.managRolePage.setPermissions(permission3);
        test.managRolePage.clickOnFormField("Permissions");
        test.createAndConfigPage.clickOnSaveButton();
    }

    @Test
    public void TRUST_422_Step05_Check_Newly_Created_Role_Must_Be_Listed_On_The_Configured_Manage_Roles() {
        test.managRolePage.newlyCreatedDataShouldBeAvailabeOnList(newRole);
        test.managRolePage.verifyAddedPernissionsAreDisplayingOnManageList(newRole, permission1);
        test.managRolePage.verifyAddedPernissionsAreDisplayingOnManageList(newRole, permission2);
        test.managRolePage.verifyAddedPernissionsAreDisplayingOnManageList(newRole, permission3);
    }

    @Test
    public void TRUST_422_Step06_Click_Edit_Role() {
        test.managRolePage.clickOnNewlyCreated(newRole);
        test.managRolePage.enterValueInForm("Name", editRole);
        test.createAndConfigPage.clickOnSaveButton();
        test.managRolePage.editedNewRoleIsDisplaying(editRole);
    }

    @Test
    public void TRUST_422_Step07_Delete_User_Creayed_By_Automation_Script() {
        test.managRolePage.clickOnDeleteButton(editRole);
        test.createAndConfigPage.popUpShouldBeAppears("Cancel");
        test.managRolePage.editedNewRoleIsDisplaying(editRole);
        test.managRolePage.clickOnDeleteButton(editRole);
        test.createAndConfigPage.popUpShouldBeAppears("Delete");
    }
}
