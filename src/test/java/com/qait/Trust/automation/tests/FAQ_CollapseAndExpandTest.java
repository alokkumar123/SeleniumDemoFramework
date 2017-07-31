/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class FAQ_CollapseAndExpandTest extends TestFundamentals {

    String adminMenuMangeFaq = "Manage FAQs";

    @Test
    public void TRUST_825_Login_And_Navigate_To_FAQ() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.createAndConfigPage.navigateToAdminMenu(adminMenuMangeFaq);

    }

    @Test
    public void TRUST_825_Verify_Collapse_And_Expends_In_FAQs() {
        test.faqLayoutPage.verifyCollapseAndExpendUnderFAQSection();
        test.createAndConfigPage.logOutFromAdmin();
    }

}
