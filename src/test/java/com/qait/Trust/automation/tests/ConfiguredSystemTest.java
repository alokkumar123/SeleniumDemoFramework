package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ConfiguredSystemTest extends TestFundamentals {
    
    boolean flag;
    String newSystem = "New Automation System";
    
    @Test
    public void TRUST_395_Step01_Configure_System() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.createAndConfigPage.gridShouldBeAvailableFor("Enabled");
        test.createAndConfigPage.gridShouldBeAvailableFor("Monitors");
        test.createAndConfigPage.gridShouldBeAvailableFor("Tab order");
        test.createAndConfigPage.gridShouldBeAvailableFor("System");
        test.createAndConfigPage.gridShouldBeAvailableFor("Description");
        test.createAndConfigPage.createButtonAndSearchTextBarShouldBeAvailable();
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
    }

    @Test
    public void TRUST_395_Step02_Check_Move_Up_Functionality() {
        test.manageSystemPage.verifyMoveUpFunctionality();
    }

    @Test
    public void TRUST_395_Step03_Check_Search_Functionality_Positive_Cycle() {
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.manageSystemPage.validateSearchFunctionalityForPositiveCycle();
    }

    @Test
    public void TRUST_395_Step04_Check_Search_Functionality_Negative_Cycle() {
        test.manageSystemPage.validateSearchFunctionalityForNegativeCycle();
    }
    
    @Test
    public void TRUST_395_Step05_Verify_And_Delete_Any_System_Created_By_Automation_Scripts_Is_Appearing() {
        test.createAndConfigPage.navigateToAdminMenu("Manage regions");
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        flag = test.manageSystemPage.verifyAnySystemCreatedByAutomationScriptIsAppearing(newSystem);
        test.manageSystemPage.deleteNewlyCreatedSystem(flag, newSystem);
    }
    
    @Test
    public void TRUST_395_Step06_Create_New_System() {
        test.manageSystemPage.userCheckCreateNewSystem();
        test.manageSystemPage.userCreateNewSystemFormAndSave();
        test.manageSystemPage.savedDataShouldBeSeenInTheListScreen();
    }
    
    @Test
    public void TRUST_395_Step07_Delete_Newly_Created_System(){
        flag = test.manageSystemPage.verifyAnySystemCreatedByAutomationScriptIsAppearing(newSystem);
        test.manageSystemPage.deleteNewlyCreatedSystem(flag, newSystem);
    }
    
}
