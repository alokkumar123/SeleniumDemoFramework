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
public class ValidateAdminSystemsOnlyShowUpForUserAdminPrivilegeTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");
    String internalSystem = "Regression Test 2";
    String gptSystem = "GPT General System";
    String adminSystem = "Admin System Test";
    String publicSystem = "/systems/582042dddc7feb181696f604/logo.png";
    String internalPrivilege = "Internal";
    String publicPrivilege = "Public";
    String gptPrivilege = "GPT";
    String adminPrivilege = "Admin";
    String systemView;

    @Test
    public void TRUST_595_TC01_Login_With_QaAdmin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        //monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_595_TC02_QaAdmin_Navigate_To_Manage_System_And_Find_System_With_GPT_Privileges() {
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.createNotificationPage.selectSystemAndVerifyItsPrivilege(adminSystem);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void TRUST_595_TC03_Login_With_Admin_User() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_595_TC04_Verify_Admin_User_Can_See_Admin_Privilages() {
        test.platformAvailabilityPage.verifyMonitorIsDisplayingOnSplashPageForPrivilegePurpose(adminSystem, systemView);
        test.createNotificationPage.verifySytemUnderPrivileges(adminSystem, adminPrivilege);
    }

    @Test
    public void TRUST_595_TC05_Verify_Admin_User_Can_See_GTP_Privilages_Also() {
        test.createNotificationPage.verifySytemUnderPrivileges(gptSystem, gptPrivilege);
    }

    @Test
    public void TRUST_595_TC06_Verify_Admin_User_Can_See_Internal_Privilages_Also() {
        test.createNotificationPage.verifySytemUnderPrivileges(internalSystem, internalPrivilege);
    }

    @Test
    public void TRUST_595_TC07_Verify_Admin_User_Can_See_Public_Privilages_Also() {
        test.createNotificationPage.verifySytemUnderPrivileges(publicSystem, publicPrivilege);
    }
}
