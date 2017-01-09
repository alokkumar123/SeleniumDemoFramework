package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;
import static com.qait.Trust.automation.utils.YamlReader.getData;

public class PlatformAvailabiltyTest extends TestFundamentals {
    
    @Test
    public void TRUST_314_Verify_List_Of_Apps_Are_Displaying_On_Platfrom_Availiblity() {
        test.platfromAvailabilityPage.verifyingAppOnPlatfromScreen(getData("appName"));
    }
    
    @Test
    public void TRUST_315_Check_Last_Update_Time_Over_Platform_Availability() {
        test.platfromAvailabilityPage.checkLastUpdateTimeOverPlatformAvailability();
    }
    
    @Test
    public void TRUST_316_Need_Product_Support_Link_Should_Be_Available() {
        test.platfromAvailabilityPage.verifyNeedProductSupportLinkDisplaying();
        test.platfromAvailabilityPage.onceClickedOnLinkNewTabShouldBeOpenAndNavigateToURL("");
    }
    
}
