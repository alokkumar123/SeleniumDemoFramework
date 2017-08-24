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
    String internalSystem = "Regression Test 2";
    String publicSystem = "/systems/582042dddc7feb181696f604/logo.png";
    String internalUser = "internalqa";
    String internalPassword = "Cengage1";
    String internalPrivilege = "Internal";
    String publicPrivilege = "Public";
    String systemView;

    @Test
    public void TRUST_593_TC01_Login_With_QaAdmin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        //monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_593_TC02_QaAdmin_Navigate_To_Manage_System_And_Find_System_With_Internal_Privileges() {
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.createNotificationPage.selectSystemAndVerifyItsPrivilege(internalSystem);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void TRUST_593_TC03_Login_With_Internal_User() {
        test.createAndConfigPage.logAsAdmin(internalUser, internalPassword);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_593_TC04_Verify_Internal_User_Can_See_Internal_Privilages() {
        test.platformAvailabilityPage.verifyMonitorIsDisplayingOnSplashPageForPrivilegePurpose(internalSystem, systemView);
        test.createNotificationPage.verifySytemUnderPrivileges(internalSystem, internalPrivilege);
    }

    @Test
    public void TRUST_593_TC05_Verify_Internal_User_Can_See_Public_Privilages_Also() {
        test.createNotificationPage.verifySytemUnderPrivileges(publicSystem, publicPrivilege);
    }
}
