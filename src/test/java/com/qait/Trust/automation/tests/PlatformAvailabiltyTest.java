/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class PlatformAvailabiltyTest extends TestFundamentals {

    @Test
    public void TC_01_Verify_List_Of_Apps_Are_Displaying() {
        test.platfromAvailabilityPage.verifyListofAppDisplaying();
    }

    @Test
    public void TC_02_Check_Last_Update_Time_Over_Platform_Availability() {
        assert test.platfromAvailabilityPage.checkLastUpdateTimeOverPlatformAvailability();
    }

    @Test
    public void TC_03_Need_Product_Support_Link_Should_Be_Available() {
        test.platfromAvailabilityPage.verifyNeedProductSupportLinkDisplaying();
        test.platfromAvailabilityPage.onceClickedOnLinkNewTabShouldBeOpenAndNavigateToURL("");
    }
            

}
