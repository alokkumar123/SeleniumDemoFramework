/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.ConfigPropertyReader.getProperty;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class OneSystemThatAlreadyGreenOverrideToRedTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");

    String monitorName = null;
    String message = "test of green system";
    String systemView;
    String eventType1 = "Service temporarily unavailable";
    String redColor = "red";
    String greenColor = "green";
    String orangeColor = "orange";
    String eventType2 = "Critical disruption";

    @Test
    public void TRUST_601_TC01_Login_With_Admin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_601_TC02_Create_Notification_Red_System() {
        test.createNotificationPage.clickOnNotificationButton();
        test.createNotificationPage.selectMonitorfromDropDown(monitorName);
        test.createNotificationPage.selectEventType(eventType1);
        test.createNotificationPage.setEndDateForMessageInformation();
        test.createNotificationPage.enterValueInCommentSection(message);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();

    }

    @Test
    public void TRUST_601_TC03_Verify_Created_Notification_Displays_To_Unauthenticated_User() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitroIsDisplayingOnSplashPage(getData("appNameforRegion.4ltr"), systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(splashPageView, message, eventType1, orangeColor);

    }

    @Test
    public void TRUST_601_TC04_Override_Red_System_To_Green() {

        test.createAndConfigPage.logAsAdmin(userName, password);
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.clickOnCreatedNotificationMessage(message, monitorName);
        test.createNotificationPage.selectEventType(eventType2);
        message = "Overriding green system to red System";
        test.createNotificationPage.enterValueInCommentSection(message);
        test.createNotificationPage.overrideNotificationfromUser();
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void TRUST_601_TC05_Verify_Notification_For_Overrided_System() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitroIsDisplayingOnSplashPage(getData("appNameforRegion.4ltr"), systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(splashPageView, message, eventType2, redColor);
    }

    @Test
    public void TRUST_602_TC06_Delete_Created_Notifaction_By_Automation_Script() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.deleteCreatedNotification(message);
        test.createAndConfigPage.logOutFromAdmin();
    }

}
