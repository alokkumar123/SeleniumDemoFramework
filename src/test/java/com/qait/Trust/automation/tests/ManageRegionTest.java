package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ManageRegionTest extends TestFundamentals {
    
    boolean flag = false;
    String newRegion = "Test Automation Region";
    String oid = "PID123";
    String description = "Created By Automation script";

    @Test
    public void Step01_TRUST_437__Check_Manage_Region() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.navigateToAdminMenu("Manage regions");
        test.createAndConfigPage.gridShouldBeAvailableFor("Name");
        test.createAndConfigPage.gridShouldBeAvailableFor("Systems");
        test.createAndConfigPage.gridShouldBeAvailableFor("Monitors");
    }

    @Test
    public void Step02_TRUST_437_Check_Search_Functionality_Positive_Cycle() {
        test.manageRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Asia");
        test.manageRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Australia");
        test.manageRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Eur");
        test.manageRolePage.validateSearchFunctionalityForPossitiveCycleWithText("New");
    }

    @Test
    public void Step03_TRUST_437_Check_Search_Functionality_Negative_Cycle() {
        test.createAndConfigPage.validateSearchFunctionalityForNegativeCycle();
    }
    
    @Test
    public void Step04_Delete_Region_Created_By_Automation_Script() {
        test.createAndConfigPage.navigateToAdminMenu("Manage monitors");
        test.createAndConfigPage.navigateToAdminMenu("Manage regions");
        flag = test.manageRegionPage.verifyAnyRegionCreatedByAutomationScriptIsAppearing(newRegion);
        test.manageRegionPage.deleteRegionCreatedByAutomationScript();
        test.manageRegionPage.verifyRegionHasBeenDeleted(flag);
    }
    
    @Test
    public void Step05_TRUST_437_Check_Add_Region() {
        test.manageRolePage.clickOnAdd("Add Region");
        test.manageRolePage.newFormShouldBeOpened("Add region");
        test.manageRolePage.enterValueInForm("Name", newRegion);
        test.manageRolePage.enterValueInForm("OID", oid);
        test.manageRolePage.enterValueInForm("Description", description);
        test.createAndConfigPage.clickOnSaveButton();
    }

    @Test
    public void Step06_TRUST_437_Shorting_Of_Records() {
        test.createAndConfigPage.shortingOfRecordswith("Name", "1");
        test.createAndConfigPage.shortingOfRecordswith("System", "2");
        test.createAndConfigPage.shortingOfRecordswith("Monitors", "3");
    }

    @Test
    public void Step07_TRUST_437_Delete_User_Created_By_Automation_Script() {
        test.manageRolePage.clickOnDeleteButton(newRegion);
        test.createAndConfigPage.popUpShouldBeAppears("Cancel");
        test.manageRolePage.clickOnDeleteButton(newRegion);
        test.createAndConfigPage.popUpShouldBeAppears("Delete");
    }
}
