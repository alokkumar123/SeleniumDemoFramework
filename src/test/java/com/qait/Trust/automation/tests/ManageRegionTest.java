package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class ManageRegionTest extends TestFundamentals {

    boolean flag = false;
    String newRegion = "Test Automation Region";
    String oid = "OID" + System.currentTimeMillis();
    String description = "Created By Automation script";

    @Test
    public void Step01_TRUST_437_Check_Manage_Region() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.navigateToAdminMenu("Manage regions");
        test.createAndConfigPage.gridShouldBeAvailableFor("Name");
        test.createAndConfigPage.gridShouldBeAvailableFor("Systems");
        test.createAndConfigPage.gridShouldBeAvailableFor("Monitors");
    }

     @Test
    public void Step02_TRUST_437_Verify_Region_Created_By_Automation_Script_Is_Deleted() {
        test.manageRegionPage.verifyAnyRegionCreatedByAutomationScriptIsAppearing(newRegion);
    }
    @Test
    public void Step03_TRUST_437_Check_Search_Functionality_Negative_Cycle() {
        test.createAndConfigPage.validateSearchFunctionalityForNegativeCycle();
    }

    @Test
    public void Step04_TRUST_437_Check_Search_Functionality_Positive_Cycle() {
        test.manageRolePage.validateSearchFunctionalityForPositiveCycleWithText("MindTap");
        test.manageRegionPage.verifySearchedSystemOnRegions("MindTap");
        test.manageRolePage.validateSearchFunctionalityForPositiveCycleWithText("SAM");
        test.manageRegionPage.verifySearchedSystemOnRegions("SAM");
        test.manageRolePage.validateSearchFunctionalityForPositiveCycleWithText("WebAssign");
        test.manageRegionPage.verifySearchedSystemOnRegions("Aplia");
        test.manageRegionPage.clearSearchInputBox();
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
    public void Step06_TRUST_437_Sorting_Of_Records() {
        test.createAndConfigPage.sortingOfRecordswith("Name", "1");
        test.createAndConfigPage.sortingOfRecordswith("System", "2");
        test.createAndConfigPage.sortingOfRecordswith("Monitors", "3");
    }

    @Test
    public void Step07_TRUST_437_Delete_User_Created_By_Automation_Script() {
        test.manageRolePage.clickOnDeleteButton(newRegion);
        test.createAndConfigPage.popUpShouldBeAppears("Cancel");
        test.manageRolePage.clickOnDeleteButton(newRegion);
        test.createAndConfigPage.popUpShouldBeAppears("Delete");
    }
}
