/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.ConfigPropertyReader.getProperty;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class VerifyDisableAutogeneratedMessageAndShouldNotContinueToGenerateMessagesTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");

    String monitorName = "RegTest-801";
    String message = "test of red system message auto generation";
    String systemView;
    String eventType1 = "Service temporarily unavailable";
    String redColor = "red";
    String greenColor = "green";
    String greenEmpty = "green empty";
    String eventType2 = "Planned Maintenance";

    @Test
    public void TRUST_603_TC01_Login_With_Admin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        //monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_603_TC02_Create_Red_System_With_Auto_Generation_Message() {
        test.createNotificationPage.clickOnNotificationButton();
        test.createNotificationPage.selectMonitorfromDropDown(monitorName);
        test.createNotificationPage.overrideNotificationfromUser();
        test.createNotificationPage.selectEventType(eventType1);
        test.createNotificationPage.setStartDateForMessageInformation();
        test.createNotificationPage.enterValueInCommentSection(message);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        // test.createAndConfigPage.logOutFromAdmin();

    }

    @Test
    public void TRUST_603_TC03_Verify_Generated_Message_For_Red_System_IS_Displaying_Or_Not() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitorIsDisplayingOnSplashPageForPrivilegePurpose("Regression Test 2", systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(splashPageView, message, eventType1, redColor);
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.navigateToMonitorFromAdminPage(monitorName);
        test.createNotificationPage.verifyOverriddenSystemForRegressionTest(monitorName,redColor);
    }

    @Test
    public void TRUST_603_TC04_Override_Red_System_To_Planned_Maintenance_And_Disable_Autogenerated_Message() {
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.clickOnCreatedNotificationMessage(message, monitorName);
        test.createNotificationPage.selectEventType(eventType2);
        message = "Select Planned Maintenance event type and Disable auto generated message";
        test.createNotificationPage.enterValueInCommentSection(message);
        test.createNotificationPage.hideNotificationfromUser();
        test.createNotificationPage.setDateToTBD();
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_603_TC05_Verify_Generated_Message_For_Planned_Maintenance_System_Is_Displaying_Or_Not() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitorIsDisplayingOnSplashPageForPrivilegePurpose("Regression Test 2", systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(splashPageView, message, eventType2, greenEmpty);
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.navigateToMonitorFromAdminPage(monitorName);
        test.createNotificationPage.verifyOverriddenSystemForRegressionTest(monitorName,greenEmpty);
    }

    @Test
    public void TRUST_603_TC06_Delete_Created_Notifaction_By_Automation_Script() {
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.deleteCreatedNotification(message);
        test.createAndConfigPage.logOutFromAdmin();
    }

}
