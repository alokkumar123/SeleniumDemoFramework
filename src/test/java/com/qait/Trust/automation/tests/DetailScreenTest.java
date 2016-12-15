package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class DetailScreenTest extends TestFundamentals {

    @Test
    public void TRUST_317_Check_For_Breadcrumb() {
        test.detailScreenPage.verifyBreadcrumb();
    }

    @Test
    public void TRUST_318_Check_For_Drop_Down_Options_Available_In_Detail_Screen() {
        test.detailScreenPage.clickOnSingleApp("appName.cengageBrain");
        test.detailScreenPage.verifyDropDownOptionsWithOptions("last 12 hours");
        test.detailScreenPage.verifyDropDownOptionsWithOptions("last 24 hours");
        test.detailScreenPage.verifyDropDownOptionsWithOptions("last 30 days");
    }

    @Test
    public void TRUST_319_Check_For_4_Time_Zones_Available_For_User() {
        test.detailScreenPage.verifyTimeZoneForUser("IST (local)");
        test.detailScreenPage.verifyTimeZoneForUser("EST");
        test.detailScreenPage.verifyTimeZoneForUser("CST");
        test.detailScreenPage.verifyTimeZoneForUser("PST");
        test.detailScreenPage.verifyTimeZoneForUser("GMT");
    }
    
}
