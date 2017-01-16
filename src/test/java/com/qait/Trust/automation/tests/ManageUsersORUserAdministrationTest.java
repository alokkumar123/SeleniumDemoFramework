/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ManageUsersORUserAdministrationTest extends TestFundamentals {

    @Test
    public void TC001_CheckUserAdministrationManageUsers() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToAdminMenu("User Administration");
        test.createAndConfigPage.gridShouldBeAvailableFor("User ID");
        test.createAndConfigPage.gridShouldBeAvailableFor("User Name");
        test.createAndConfigPage.gridShouldBeAvailableFor("Email");
        test.createAndConfigPage.clickOnAddNewUser();
        test.createAndConfigPage.userNavigatedToNewUserScreen();
    }

    @Test
    public void TC002_ShortingOfRecords() {
        test.createAndConfigPage.shortingOfRecordswith("Userd ID", "1");
        test.createAndConfigPage.shortingOfRecordswith("User Name", "2");
        test.createAndConfigPage.shortingOfRecordswith("Email", "3");
    }
    @Test
    public void TC003_CheckSearchFunctionalityPositiveCycle() {
        test.createAndConfigPage.validateSearchFunctionalityForPossitiveCycle();
    }

    @Test
    public void TC004_CheckSearchFunctionalityNegativeCycle() {
        test.createAndConfigPage.validateSearchFunctionalityForNegativeCycle();
    }
}
