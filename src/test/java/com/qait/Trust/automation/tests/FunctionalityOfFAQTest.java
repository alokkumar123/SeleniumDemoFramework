/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class FunctionalityOfFAQTest extends TestFundamentals {

    String userFAQ = "qafaq";
    String passFAQ = "Cengage1";
    String faqRole = "FAQ-Role";
    String faqAdmin = "FAQ-admin";
    String faqInternal = "FAQ-internal";
    String faqGpt = "FAQ-GPT";

    @Test
    public void TRUST_652_TC001_Login_With_FAQ_User() {
        test.createAndConfigPage.logAsAdmin(userFAQ, passFAQ);

    }

    @Test
    public void TRUST_652_TC2_Add_FAQ_Admin_In_Role() {
        test.createAndConfigPage.navigateToAdminMenu("Manage roles");
        test.createNotificationPage.clickOnFaqRole(faqRole);
        test.createNotificationPage.addFQAPermissionInRoleDorpDown(faqAdmin);
        test.createNotificationPage.clickOnSaveButton();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void TRUST_652_TC3_Verify_New_Tab_Labeled_Manage_FAQs_IS_Displaying() {
        test.createAndConfigPage.logAsAdmin(userFAQ, passFAQ);
        test.createAndConfigPage.verifyAdminMenuisDisplaying("Manage FAQs");
    }

    @Test
    public void TRUST_652_TC3_When_Click_On_Manage_FAQs_New_FAQs_Should_Display() {
        test.createAndConfigPage.navigateToAdminMenu("Manage FAQs");
        test.createNotificationPage.verifyNewFAQsAreDisplaying();
    }

    @Test
    public void TRUST_652_TC4_Add_FAQ_GPT_In_Role() {
        test.createAndConfigPage.navigateToAdminMenu("Manage roles");
        test.createNotificationPage.clickOnFaqRole(faqRole);
        test.createNotificationPage.addFQAPermissionInRoleDorpDown(faqGpt);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_652_TC5_Verify_FAQ_Link_Is_Displaying_On_Splash_page() {
        test.createNotificationPage.verifyFAQsLinkOnSlapshPage();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void TRUST_652_TC6_Add_FAQ_Internal_In_Role() {
        test.createAndConfigPage.logAsAdmin(userFAQ, passFAQ);
        test.createAndConfigPage.navigateToAdminMenu("Manage roles");
        test.createNotificationPage.clickOnFaqRole(faqRole);
        test.createNotificationPage.addFQAPermissionInRoleDorpDown(faqInternal);
        test.createNotificationPage.clickOnSaveButton();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TRUST_652_TC7_Verify_FAQ_Link_Is_Displaying_On_Splash_page() {
        test.createNotificationPage.verifyFAQsLinkOnSlapshPage();
        test.createAndConfigPage.logOutFromAdmin();
    }

    @Test
    public void TRUST_652_TC8_Delete_All_FAQs_Permissions_From_FAQ_Role() {
        test.createAndConfigPage.logAsAdmin(userFAQ, passFAQ);
        test.createAndConfigPage.navigateToAdminMenu("Manage roles");
        test.createNotificationPage.clickOnFaqRole(faqRole);
        test.createNotificationPage.deleteFQAsPermissionFromFQARole(faqAdmin);
        test.createNotificationPage.deleteFQAsPermissionFromFQARole(faqGpt);
        test.createNotificationPage.deleteFQAsPermissionFromFQARole(faqInternal);
        test.createNotificationPage.clickOnSaveButton();
    }

}
