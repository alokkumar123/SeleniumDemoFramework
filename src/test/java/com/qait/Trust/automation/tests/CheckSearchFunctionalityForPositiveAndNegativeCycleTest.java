package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class CheckSearchFunctionalityForPositiveAndNegativeCycleTest extends TestFundamentals {

    @Test
    public void Trust_352_Check_Search_Functionality_Positive_Cycle() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.checkSearchFunctionality.validateSearchFunctionalityForPossitiveCycle();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void Trust_353_Check_Search_Functionality_Negative_Cycle() {
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.checkSearchFunctionality.validateSearchFunctionalityForNegativeCycle();
        test.createAndConfigPage.logOutFromAdmin();
    }
}
