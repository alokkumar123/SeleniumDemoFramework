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
public class HideNotificationAndVerifyThatItDoesNotShowToTheUnauthenticatedUserTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");

    String monitorName = null;
    String message = "test of Hide Notification ";
    String systemView;
    String eventType1 = "Planned Maintenance";

    @Test
    public void TRUST_597_TC01_Login_With_Admin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_597_TC02_Create_Notification_And_Hide() {
        test.createNotificationPage.clickOnNotificationButton();
        test.createNotificationPage.selectSystemFromSelectMonitorDropDownAndHideNotification(monitorName, message);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();

    }

    @Test
    public void TRUST_597_TC03_Verify_Created_Notification_Does_Not_Display_To_Unauthenticated_User() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitroIsDisplayingOnSplashPage(getData("appNameforRegion.4ltr"), systemView);
        test.createNotificationPage.verifyMessageAndLogoIsDisplayingOrNotDisplayingToUnauthenticatedUser(splashPageView, message,eventType1);

    }

    @Test
    public void TRUST_597_TC04_Delete_Created_Notifaction_By_Automation_Script() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.deleteCreatedNotification(message);
        test.createAndConfigPage.logOutFromAdmin();
    }
}
