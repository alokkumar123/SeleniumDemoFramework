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
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.cengageBrain"));
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.mindtap"));
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.aplia"));
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.cengageNow"));
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.cengageNOWv2"));
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.OWLv2"));
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.SAM"));
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.4LTR"));
        test.platfromAvailabilityPage.verifyListofAppDisplaying(getData("appName.mindtapMathFoundation"));
    }

    @Test
    public void TC_02_Check_Last_Update_Time_Over_Platform_Availability() {
        assert test.platfromAvailabilityPage.checkLastUpdateTimeOverPlatformAvailability();
    }

}
