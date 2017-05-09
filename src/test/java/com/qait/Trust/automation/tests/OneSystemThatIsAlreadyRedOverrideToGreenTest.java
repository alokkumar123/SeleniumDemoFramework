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
public class OneSystemThatIsAlreadyRedOverrideToGreenTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");

    String monitorName = "RegTest-802";
    String message = "test of red system";
    String systemView;
    String eventType1 = "Service temporarily unavailable";
    String redColor = "red";
    String greenColor = "green";
    String orangeColor = "orange";
    String eventType2 = "Service doesn't have any issues";

    @Test
    public void TRUST_601_TC01_Login_With_Admin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        // monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_601_TC02_Create_Notification_For_Red_System() {
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
    public void TRUST_601_TC03_Verify_Notification_For_Overrided_System_From_Red_To_Green() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitroIsDisplayingOnSplashPageForPrivilegePurpose("Regression Test 2", systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(splashPageView, message, eventType1, redColor);
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.navigateToMonitorFromAdminPage(monitorName);
        test.createNotificationPage.verifyOverriddenSystemForRegressionTest(monitorName,redColor);
    }

    @Test
    public void TRUST_601_TC04_Override_Red_System_To_Green() {
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.clickOnCreatedNotificationMessage(message, monitorName);
        test.createNotificationPage.selectEventType(eventType2);
        message = "Overriding red system to green System";
        test.createNotificationPage.enterValueInCommentSection(message);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_601_TC05_Verify_Notification_For_Overrided_System_From_Red_To_Green() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitroIsDisplayingOnSplashPageForPrivilegePurpose("Regression Test 2", systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotToUnauthenticatedUserForDifferntColor(splashPageView, message, eventType2, greenColor);
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.navigateToMonitorFromAdminPage(monitorName);
        test.createNotificationPage.verifyOverriddenSystemForRegressionTest(monitorName,greenColor);
    }

    @Test
    public void TRUST_601_TC06_Delete_Created_Notifaction_By_Automation_Script() {
        test.createNotificationPage.navigateToAdminPage();
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.deleteCreatedNotification(message);
        test.createAndConfigPage.logOutFromAdmin();
    }
}
