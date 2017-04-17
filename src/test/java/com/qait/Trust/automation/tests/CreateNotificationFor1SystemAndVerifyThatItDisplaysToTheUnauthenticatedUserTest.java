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
public class CreateNotificationFor1SystemAndVerifyThatItDisplaysToTheUnauthenticatedUserTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");
    String appName = null;

    String monitorName = "4LTR Press";
    String message = "test of notification for single system";

    @Test
    public void TRUST_596_TC01_Login_With_Admin_User() {
        //appName = test.detailScreen_group.getMonitorNameFromSpashPage(getData("appNameforRegion.cengagebrain"));
//        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        System.out.println("userName : " + userName + ", password : " + password);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_596_TC02_Create_Notification_For_Single_System() {
        test.createNotificationPage.clickOnNotificationButton();
        test.createNotificationPage.selectSystemFromSelectMonitorDropDown(monitorName, message);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();

    }

    @Test
    public void TRUST_596_TC03_Verify_Created_Notification_Displays_To_Unauthenticated_User() {
        test.createNotificationPage.verifyMessageIsDisplayingToUnauthenticatedUser(message);

    }

    @Test
    public void TRUST_596_TC04_Delete_Created_Notifaction_By_Automation_Script() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.createNotificationPage.searchCreatedNotification(message);
        test.createNotificationPage.deleteCreatedNotification(message);
        test.createAndConfigPage.logOutFromAdmin();

    }
}
