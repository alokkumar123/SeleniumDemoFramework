package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class CreateAndConfigureMonitorsTest extends TestFundamentals {

    @Test
    public void Trust_350_Configure_Monitors() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToManageSystem();
        test.createAndConfigPage.gridShouldBeAvailableFor("Enabled");
        test.createAndConfigPage.gridShouldBeAvailableFor("Monitor");
        test.createAndConfigPage.gridShouldBeAvailableFor("System");
        test.createAndConfigPage.gridShouldBeAvailableFor("Description");
        test.createAndConfigPage.createButtonAndSearchTextBarShouldBeAvailable();
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void Trust_376_Create_Monitors() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToManageSystem();
        test.createAndConfigPage.clickOnCreateButton();
        test.createAndConfigPage.enterAllMandatoryFieldsAndClickOnSave();
        test.createAndConfigPage.newCreatedMonitorsShouldBeSeenOnTheList();
        test.createAndConfigPage.newCreatedMonitorShouldBeOpen();
        test.createAndConfigPage.allInformationEnteredInFormShouldBeSaved();
        test.createAndConfigPage.logOutFromAdmin();
    }

}
