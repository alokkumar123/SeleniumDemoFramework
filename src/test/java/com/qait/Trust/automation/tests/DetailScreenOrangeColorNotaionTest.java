/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class DetailScreenOrangeColorNotaionTest extends TestFundamentals {

    String color = "orange";
    String systemView;

    @Test
    public void TC01_Verifying_ColorNotations_For_MindTap_Platform() {
        test.createAndConfigPage.logAsAdmin("qaadmin", "Cengage1");
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
          systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.mindtap"), systemView);
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtap"), color);
    }

    @Test
    public void TC02_Verifying_ColorNotations_For_Cengage_Brain_Platform() {
          systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.cengageBrain"), systemView);
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageBrain"), color);
    }

    @Test
    public void TC03_verifying_ColorNotations_For_Aplia_Platform() {
          systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.aplia"), systemView);
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.aplia"), color);
    }

//    @Test
//    public void TC04_verifying_ColorNotations_For_CengageNOWv2_Platform() {
//
//        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNOWv2"),color);
//    }
    @Test
    public void TC05_verifying_ColorNotations_For_OWLv2_Platform() {
          systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.OWLv2"), systemView);
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.OWLv2"), color);
    }

    @Test
    public void TC06_verifying_ColorNotations_For_SAM_Platform() {
          systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.SAM"), systemView);
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.SAM"), color);
    }

    @Test
    public void TC07_verifying_ColorNotations_For_4LTR_Platform() {
          systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.4LTR"), systemView);
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.4LTR"), color);
    }

    @Test
    public void TC08_verifying_ColorNotations_For_mindtapMathFoundation_Platform() {
          systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.mindtapMathFoundation"), systemView);
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtapMathFoundation"), color);
    }

    @Test
    public void TC09_verifying_ColorNotations_For_CengageNOW_Platform() {
          systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.cengageNow"), systemView);
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNow"), color);
    }
}
