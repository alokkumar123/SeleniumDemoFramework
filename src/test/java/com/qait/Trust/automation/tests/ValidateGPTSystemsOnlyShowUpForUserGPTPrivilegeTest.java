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
public class ValidateGPTSystemsOnlyShowUpForUserGPTPrivilegeTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");
    String internalSystem = "Regression Test 2";
    String gptSystem = "GPT General System";
    String publicSystem = "/systems/582042dddc7feb181696f604/logo.png";
    String gptUser = "gptqa";
    String gptPassword = "Cengage1";
    String internalPrivilege = "Internal";
    String publicPrivilege = "Public";
    String gptPrivilege = "GPT";
    String systemView;

    @Test
    public void TRUST_594_TC01_Login_With_QaAdmin_User() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        //monitorName = test.platformAvailabilityPage.getMonitor(getData("appNameforRegion.4ltr"), systemView);
        test.createAndConfigPage.logAsAdmin(userName, password);
    }

    @Test
    public void TRUST_594_TC02_QaAdmin_Navigate_To_Manage_System_And_Find_System_With_GPT_Privileges() {
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.createNotificationPage.selectSystemAndVerifyItsPrivilege(gptSystem);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void TRUST_594_TC03_Login_With_GPT_User() {
        test.createAndConfigPage.logAsAdmin(gptUser, gptPassword);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_594_TC04_Verify_GPT_User_Can_See_GPT_Privilages() {
        test.platformAvailabilityPage.verifyMonitorIsDisplayingOnSplashPageForPrivilegePurpose(gptSystem, systemView);
        test.createNotificationPage.verifySytemUnderPrivileges(gptSystem, gptPrivilege);
    }

    @Test
    public void TRUST_594_TC05_Verify_GPT_User_Can_See_Internal_Privilages_Also() {
        test.createNotificationPage.verifySytemUnderPrivileges(internalSystem, internalPrivilege);
    }

    @Test
    public void TRUST_594_TC06_Verify_GPT_User_Can_See_Public_Privilages_Also() {
        test.createNotificationPage.verifySytemUnderPrivileges(publicSystem, publicPrivilege);
    }
    
}
