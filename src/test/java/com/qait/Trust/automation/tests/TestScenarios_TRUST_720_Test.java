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
public class TestScenarios_TRUST_720_Test extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");

    String systemView;

    @Test
    public void TRUST_702_TC01_Navigate_To_Splash_Page() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_720_TC02_Navigate_To_30_Days_Of_Any_System() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.mindtap"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.mindtap"));
        test.detailScreenPage.selectLastAvailableHours("last 30 days");

    }

    @Test
    public void TRUST_720_TC03_Select_Any_Date_From_Calendar() {

    }

}
