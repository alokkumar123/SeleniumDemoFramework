package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class ValidateHeaderAndFooterTest extends TestFundamentals {

    String appName = null;
    String systemView;
    String userName = "admin";
    String password = "Cengage1";

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

    @Test
    public void Step_03_Trust_535_Verify_Footer_By_Navigating_Different_Monitors_From_Header() {
        test.aboutPage.navigateToDifferentMonitorFromHeadher();
    }

    @Test
    public void Step_04Trust_535_Verify_Footer_Login_With_Admin_Aand_Navigate_To_Menu_List() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.createAndConfigPage.navigateToAdminMenu("List service notifications");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.navigateToAdminMenu("Manage groups");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.navigateToAdminMenu("Manage monitors");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.navigateToAdminMenu("Manage regions");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.navigateToAdminMenu("User Administration");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.navigateToAdminMenu("Manage roles");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.navigateToAdminMenu("List permissions");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.navigateToAdminMenu("About page");
        test.aboutPage.verifyFooter();
        test.createAndConfigPage.logOutFromAdmin();
    }
}
