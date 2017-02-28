package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;
import static com.qait.Trust.automation.utils.YamlReader.getData;

public class PlatformAvailabiltyTest extends TestFundamentals {
    
    String systemView;
    
    @Test
    public void TRUST_314_Verify_List_Of_Apps_Are_Displaying_On_Platfrom_Availiblity() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.mindtap"), systemView);
        test.platformAvailabilityPage.verifyingAppOnPlatformScreen(getData("appName"));
    }
    
    @Test
    public void TRUST_315_Check_Last_Update_Time_Over_Platform_Availability() {
        test.platformAvailabilityPage.checkLastUpdateTimeOverPlatformAvailability();
    }

    @Test
    public void TRUST_316_Need_Product_Support_Link_Should_Be_Available() {
        test.platformAvailabilityPage.verifyNeedProductSupportLinkDisplaying();
        test.platformAvailabilityPage.onceClickedOnLinkNewTabShouldBeOpenAndNavigateToURL("");
    }
 
}
