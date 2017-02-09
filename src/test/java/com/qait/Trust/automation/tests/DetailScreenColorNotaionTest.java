/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class DetailScreenColorNotaionTest extends TestFundamentals {

    @Test
    public void TC01_Verifying_ColorNotations_For_MindTap_Platform() {
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtap"));
    }

    @Test
    public void TC02_Verifying_ColorNotations_For_Cengage_Brain_Platform() {
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageBrain"));
    }

    @Test
    public void TC03_verifying_ColorNotations_For_Aplia_Platform() {
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.aplia"));
    }

//    @Test
//    public void TC04_verifying_ColorNotations_For_CengageNOWv2_Platform() {
//
//        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNOWv2"));
//    }
    @Test
    public void TC05_verifying_ColorNotations_For_OWLv2_Platform() {
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.OWLv2"));
    }

    @Test
    public void TC06_verifying_ColorNotations_For_SAM_Platform() {
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.SAM"));
    }

    @Test
    public void TC07_verifying_ColorNotations_For_4LTR_Platform() {
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.4LTR"));
    }

    @Test
    public void TC08_verifying_ColorNotations_For_mindtapMathFoundation_Platform() {
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtapMathFoundation"));
    }

    @Test
    public void TC09_verifying_ColorNotations_For_CengageNOW_Platform() {
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNow"));
    }
}
