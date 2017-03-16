package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class CreateAndConfigureMonitorsTest extends TestFundamentals {

    @Test
    public void Step01_Trust_350_Configure_Monitors() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToAdminMenu("Manage monitors");
        test.createAndConfigPage.gridShouldBeAvailableFor("Enabled");
        test.createAndConfigPage.gridShouldBeAvailableFor("Monitor");
        test.createAndConfigPage.gridShouldBeAvailableFor("System");
        test.createAndConfigPage.gridShouldBeAvailableFor("Description");
        test.createAndConfigPage.createButtonAndSearchTextBarShouldBeAvailable();
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void Step02_Trust_376_Create_Monitors() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToAdminMenu("Manage monitors");
        test.createAndConfigPage.clickOnCreateButton();
        test.createAndConfigPage.enterAllMandatoryFieldsAndClickOnSave();
        test.createAndConfigPage.newCreatedMonitorsShouldBeSeenOnTheList();
        test.createAndConfigPage.newCreatedMonitorShouldBeOpen();
        test.createAndConfigPage.allInformationEnteredInFormShouldBeSaved();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void Step03_Trust_394_Edit_Monitors_Created_By_Automation_Script() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToAdminMenu("Manage monitors");
        test.createAndConfigPage.userNavigateToMonitorEditScreen();
        test.createAndConfigPage.userEditAndReSaveMangaeMonitor();
        test.createAndConfigPage.editedMonitorsShouldBeSeenOnTheList();

    }

    @Test
    public void Step04_Trust_544_Search_And_Delete_Monitor_Created_By_Automation_Script() {
        test.createAndConfigPage.searchCreatedMonitorFormMonitorPage();
        test.createAndConfigPage.deleteMonitorCreatedByAutomationScript();
        test.createAndConfigPage.logOutFromAdmin();
    }
}
