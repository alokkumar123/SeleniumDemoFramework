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
public class CreateNoficationForALLSystemsAndVerifyThoseMessagesDisplayToTheUnauthenticatedUserTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");

    String monitorName1 = null;
    String message = "test of notification for All monitors";
    String systemView;
    String eventType1 = "Planned Maintenance";
    String eventType2 = "Informational Message";

    @Test
    public void TRUST_600_TC01_Login_With_Admin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        monitorName1 = getData("appNameforRegion.allmonitors");
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_600_TC02_Create_Notification_For_Single_System() {
        test.createNotificationPage.clickOnNotificationButton();
        test.createNotificationPage.selectEventType(eventType1);
        test.createNotificationPage.selectMonitorfromDropDown(monitorName1);
        test.createNotificationPage.setEndDateForMessageInformation();
        test.createNotificationPage.enterValueInCommentSection(message);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();

    }

    @Test
    public void TRUST_600_TC03_Verify_Created_Notification_And_Logo_Displays_To_Unauthenticated_User() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitroIsDisplayingOnSplashPage(getData("appNameforRegion.4ltr"), systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotDisplayingToUnauthenticatedUser(splashPageView, message, eventType1);

    }

    @Test
    public void TRUST_600_TC04_Change_Event_Type_And_Verify_Created_Notification_And_Logo_Displays_To_Unauthenticated_User() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.clickOnCreatedNotificationMessage(message, monitorName1);
        test.createNotificationPage.selectEventType(eventType2);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();
        String splashPageView = test.platformAvailabilityPage.verifyMonitroIsDisplayingOnSplashPage(getData("appNameforRegion.4ltr"), systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotDisplayingToUnauthenticatedUser(splashPageView, message, eventType2);
    }

    @Test
    public void TRUST_600_TC05_Delete_Created_Notifaction_By_Automation_Script() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.deleteCreatedNotification(message);
        test.createAndConfigPage.logOutFromAdmin();
    }
}
