package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ManagePermissionTest extends TestFundamentals {

    String index1 = "1";
    String index2 = "2";
    String name = "Name";
    String description = "Description";
    String newPermission = "New Permission";
    String descriptionTag = "Created By Automation Script";

    @Test
    public void TRUST_423_Step01_Check_User_Manage_Pemissions() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.navigateToAdminMenu("List permissions");
        test.createAndConfigPage.gridShouldBeAvailableFor("Name");
        test.createAndConfigPage.gridShouldBeAvailableFor("Description");
    }

    @Test
    public void TRUST_423_Step02_Shorting_Of_Records() {
        test.createAndConfigPage.shortingOfRecordswith(name, index1);
        test.createAndConfigPage.shortingOfRecordswith(description, index2);
    }

    @Test
    public void TRUST_423_Step03_Check_Search_Functionality_Positive_Cycle() {
        test.manageRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Ad");
        test.manageRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Admin");
        test.manageRolePage.validateSearchFunctionalityForPossitiveCycleWithText("MonitorCreateAll");
        test.manageRolePage.validateSearchFunctionalityForPossitiveCycleWithText("DeleteAll");
    }

    @Test
    public void TRUST_423_Step04_Check_Search_Functionality_Negative_Cycle() {
        test.createAndConfigPage.validateSearchFunctionalityForNegativeCycle();
    }

    @Test
    public void TRUST_423_Step05_Check_Add_Permission() {
        test.manageRolePage.clickOnAdd("Add Permission");
        test.manageRolePage.newFormShouldBeOpened("Add permission");
        test.manageRolePage.enterValueInForm(name, newPermission);
        test.manageRolePage.enterValueInForm(description, descriptionTag);
        test.manageRolePage.addGroup("Group", "Groups");
        test.manageRolePage.addGroup("Type", "Create");
        test.createAndConfigPage.clickOnSaveButton();
    }

    @Test
    public void TRUST_423_Step06_Delete_User_Creayed_By_Automation_Script() {
        test.manageRolePage.clickOnDeleteButton(newPermission);
        test.createAndConfigPage.popUpShouldBeAppears("Cancel");
        test.manageRolePage.clickOnDeleteButton(newPermission);
        test.createAndConfigPage.popUpShouldBeAppears("Delete");
    }
}
