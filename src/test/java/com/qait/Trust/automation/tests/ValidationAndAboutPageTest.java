package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class ValidationAndAboutPageTest extends TestFundamentals {

    String aboutPageText = "Testing About Page";
    String aboutPageEditedText = "Editing Testing About Page";
    String userName = "admin";
    String password = "Cengage1";

    @Test
    public void Step_01_Trust_537_Click_On_About_Page_And_Create_About_Page_And_Save() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.createAndConfigPage.navigateToAdminMenu("About page");
        test.aboutPage.createAndSaveAbouPage(aboutPageText);
    }

    @Test
    public void Step_02_Trust_537_Validating_From_Splash_Page_Whether_Saved_Information_Are_Available_Over_About_Techcheck_Link() {
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.aboutPage.clickOnAboutTechcheckLink();
        test.aboutPage.verifyingSavedInformationOnTechChechLink(aboutPageText);
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void Step_03_Trust_537_Login_With_Non_Admin_And_Click_On_About_Page_And_Edit_About_Page_And_Save() {
        test.createAndConfigPage.logAsAdmin(userName, password);
        test.createAndConfigPage.navigateToAdminMenu("About page");
        test.aboutPage.createAndSaveAbouPage(aboutPageEditedText);
    }

    @Test
    public void Step_04_Trust_537_Validating_From_Splash_Page_Whether_Saved_Information_Are_Available_Over_About_Techcheck_Link() {
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.aboutPage.clickOnAboutTechcheckLink();
        test.aboutPage.verifyingSavedInformationOnTechChechLink(aboutPageEditedText);
        test.createAndConfigPage.logOutFromAdmin();
    }

}
