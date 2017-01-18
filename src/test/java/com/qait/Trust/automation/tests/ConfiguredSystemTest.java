/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ConfiguredSystemTest extends TestFundamentals {

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
    public void TRUST_395_Step02_Check_Move_Up_Functionality(){
        test.checkSearchFunctionality.verifyMoveUpFunctionality();
    }
    
    @Test
    public void TRUST_395_Step03_Check_Search_Functionality_Positive_Cycle() {
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.checkSearchFunctionality.validateSearchFunctionalityForPossitiveCycle();
    }
    
    @Test
    public void TRUST_395_Step04_Check_Search_Functionality_Negative_Cycle() {
        test.checkSearchFunctionality.validateSearchFunctionalityForNegativeCycle();
    }

    @Test
    public void TRUST_395_Step05_Check_And_Create_New_System() {
        test.checkSearchFunctionality.userCheckCreateNewSystem();
        test.checkSearchFunctionality.userCreateNewSystemFormAndSave();
        test.checkSearchFunctionality.savedDataShouldBeSeenInTheListScreen();
    }
    @Test
    public void TRUST_395_Step06_Delete_Systems(){
        test.checkSearchFunctionality.deleteNewlyCretedSystem();
    }
}
