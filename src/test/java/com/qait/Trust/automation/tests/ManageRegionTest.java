/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ManageRegionTest extends TestFundamentals {

    String newRegion = "New Region";
    String index1 = "1";
    String index2 = "2";
    String index3 = "3";
    String name = "Name";
    String system = "System";
    String monitors = "Monitors";
    String oid = "OID123";
    String description = "Created By Automation Script";

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
        test.managRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Asia");
        test.managRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Australia");
        test.managRolePage.validateSearchFunctionalityForPossitiveCycleWithText("Eur");
        test.managRolePage.validateSearchFunctionalityForPossitiveCycleWithText("New");
    }

    @Test
    public void Step03_TRUST_437_Check_Search_Functionality_Negative_Cycle() {
        test.createAndConfigPage.validateSearchFunctionalityForNegativeCycle();
    }

    @Test
    public void Step04_TRUST_437_Check_Add_A_New_Role() {
        test.managRolePage.clickOnAdd("Add Region");
        test.managRolePage.newFormShouldBeOpened("Add region");
        test.managRolePage.enterValueInForm("Name", newRegion);
        test.managRolePage.enterValueInForm("OID", oid);
        test.managRolePage.enterValueInForm("Description", description);
        test.createAndConfigPage.clickOnSaveButton();
    }

    @Test
    public void Step05_TRUST_437_Shorting_Of_Records() {
        test.createAndConfigPage.shortingOfRecordswith(name, index1);
        test.createAndConfigPage.shortingOfRecordswith(system, index2);
        test.createAndConfigPage.shortingOfRecordswith(monitors, index3);
    }

    @Test
    public void Step06_TRUST_437_Delete_User_Creayed_By_Automation_Script() {
        test.managRolePage.clickOnDeleteButton(newRegion);
        test.createAndConfigPage.popUpShouldBeAppears("Cancel");
        test.managRolePage.clickOnDeleteButton(newRegion);
        test.createAndConfigPage.popUpShouldBeAppears("Delete");
    }
}
