/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class RegressionTestsSystemTest extends TestFundamentals {

    String systemView;

    @Test
    public void Step_01_TRUST_570_LogIn_Into_Application() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.platformAvailabilityPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void Step_02_TRUST_570_LogIn_Into_Application() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.regressionTestPage.verifyRegressionTestsSystem();
        test.platformAvailabilityPage.clickOnAggreateSystem(getData("appName.mindtap"), systemView);
    }

}
