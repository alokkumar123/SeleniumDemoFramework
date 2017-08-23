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
public class OneSystemThatAlreadyGreenOverrideToRedTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");

    String monitorName = "RegTest-801";
    String message = "test of green system";
    String systemView;
    String eventType1 = "Service doesn't have any issues";
    String redColor = "red";
    String greenColor = "green";
    String orangeColor = "orange";
    String eventType2 = "Service temporarily unavailable";

    @Test
    public void TRUST_602_TC01_Login_With_Admin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
//        monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_602_TC02_Create_Notification_For_Green_System() {
        test.createNotificationPage.clickOnNotificationButton();
        test.createNotificationPage.selectMonitorfromDropDown(monitorName);
        test.createNotificationPage.overrideNotificationfromUser();
        test.createNotificationPage.selectEventType(eventType1);
        test.createNotificationPage.setStartDateForMessageInformation();
        test.createNotificationPage.enterValueInCommentSection(message);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();

    }

    @Test
    public void TRUST_602_TC03_Verify_Notification_For_Overrided_System_From_Green_To_Red() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitorIsDisplayingOnSplashPageForPrivilegePurpose("Regression Test 2", systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(splashPageView, message, eventType2, greenColor);
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.navigateToMonitorFromAdminPage(monitorName);
        test.createNotificationPage.verifyOverriddenSystemForRegressionTest(monitorName, greenColor);
    }

    @Test
    public void TRUST_602_TC04_Override_Green_System_To_Red() {
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.clickOnCreatedNotificationMessage(message, monitorName);
        test.createNotificationPage.selectEventType(eventType2);
        message = "Overriding green system to red System";
        test.createNotificationPage.enterValueInCommentSection(message);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_602_TC05_Verify_Notification_For_Overrided_System_From_Green_To_Red() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitorIsDisplayingOnSplashPageForPrivilegePurpose("Regression Test 2", systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(splashPageView, message, eventType2, redColor);
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.navigateToMonitorFromAdminPage(monitorName);
        test.createNotificationPage.verifyOverriddenSystemForRegressionTest(monitorName, redColor);
    }

    @Test
    public void TRUST_602_TC06_Delete_Created_Notifaction_By_Automation_Script() {
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.deleteCreatedNotification(message);
        test.createAndConfigPage.logOutFromAdmin();
    }

}
