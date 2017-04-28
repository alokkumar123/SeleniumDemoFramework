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
public class ValidateInternalSystemsOnlyShowUpForUserInternalPrivilegeTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");
    String monitorName = "Regression Test 2";
    String internalUser = "internalqa";
    String internalPassword = "Cengage1";
    String privilege = "Internal";
    String systemView;

    @Test
    public void TRUST_593_TC01_Login_With_QaAdmin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        //monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_593_TC02_QaAdmin_Navigate_To_Manage_System_And_Find_System_With_Admin_Privileges() {
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.createNotificationPage.selectSystemAndVerifyItsPrivilege(monitorName);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void TRUST_593_TC03_Login_With_Internal_User() {
        test.createAndConfigPage.logAsAdmin(internalUser, internalPassword);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_593_TC04_Verify_Internal_Privilege_For_Internal_User() {
        String splashPageView = test.platformAvailabilityPage.verifyMonitroIsDisplayingOnSplashPageForPrivilegePurpose(monitorName, systemView);
        test.createNotificationPage.verifySytemUnderPrivileges(monitorName, privilege);
    }

    @Test
    public void TRUST_593_TC05_Verify_Internal_Privilege_For_public_User() {
        test.createAndConfigPage.logOutFromAdmin();
        test.createNotificationPage.verifySytemUnderPrivileges(monitorName, privilege);
    }
}
