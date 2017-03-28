package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class SearchFunctionalityForPositiveAndNegativeCycleTest extends TestFundamentals {

    @Test
    public void Trust_352_Check_Search_Functionality_Positive_Cycle() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.manageSystemPage.validateSearchFunctionalityForPositiveCycle();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void Trust_353_Check_Search_Functionality_Negative_Cycle() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.manageSystemPage.validateSearchFunctionalityForNegativeCycle();
        test.createAndConfigPage.logOutFromAdmin();
    }

}
