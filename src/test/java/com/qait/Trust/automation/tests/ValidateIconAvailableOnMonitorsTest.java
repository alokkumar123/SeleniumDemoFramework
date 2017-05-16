package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.ConfigPropertyReader.getProperty;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class ValidateIconAvailableOnMonitorsTest extends TestFundamentals {

    String systemView;
    String userName = getProperty("userName");
    String password = getProperty("password");

    @Test
    public void Step01_TRUST_538_Check_Over_Splash_Page_Check_Whether_Information_Icon_Is_Available() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.checkWhetherInformationIconIsAvailableOnSpalshPage(getData("appName.webAssign"), systemView, userName, password);

    }

    @Test
    public void Step02_TRUST_538_Check_Over_Splash_Page_Check_Whether_Information_Icon_Is_Available_For_TBD() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.checkWhetherInformationIconIsAvailableOnSpalshPageForTBD(getData("appName.webAssign"), systemView, userName, password);
    }
}
