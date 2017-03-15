package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class ValidateHeaderAndFooterTest extends TestFundamentals {

    String appName = null;
    String systemView;

    @Test
    public void Step_01_Trust_535_Verify_Footer_On_Spalsh_Page() {
        test.aboutPage.verifyFooter();
    }

    @Test
    public void Step_02_Trust_535_Verify_Footer_On_Detailed_Screen_Page() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.cengageBrain"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageBrain"));
        test.aboutPage.verifyFooter();
        test.aboutPage.slectHoursFromDropDown("last 12 hours");
        test.aboutPage.verifyFooter();
        test.aboutPage.slectHoursFromDropDown("last 24 hours");
        test.aboutPage.verifyFooter();
        test.aboutPage.slectHoursFromDropDown("last 30 days");
        test.aboutPage.verifyFooter();
    }

//@Test
//    public void Step_03_Trust_535_ 
//}
}
