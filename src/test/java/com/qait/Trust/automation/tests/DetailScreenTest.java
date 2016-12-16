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
        test.detailScreenPage.verifyDropDownOptionsWithOptions("last 12 hours");
        test.detailScreenPage.verifyDropDownOptionsWithOptions("last 24 hours");
        test.detailScreenPage.verifyDropDownOptionsWithOptions("last 30 days");
    }

    @Test
    public void TRUST_319_Check_For_4_Time_Zones_Available_For_User() {
        test.detailScreenPage.verifyTimeZoneForUser("EST (local)");
//        test.detailScreenPage.verifyTimeZoneForUser("IST");
        test.detailScreenPage.verifyTimeZoneForUser("CST");
        test.detailScreenPage.verifyTimeZoneForUser("PST");
        test.detailScreenPage.verifyTimeZoneForUser("GMT");
    }

    @Test
    public void TRUST_320_Check_Information_Available_For_Last12_Hours() {
        test.detailScreenPage.verifyInformationAvailableForHours("last 12 hours", "12");

    }

    @Test
    public void TRUST_321_Check_Information_Available_For_Last24_Hours() {
        test.detailScreenPage.verifyInformationAvailableForHours("last 24 hours", "24");

    }

    @Test
    public void TRUST_323_Check_Information_Available_For_Last30_Days() {
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days");

    }

    @Test
    public void Trust_324_Check_Current_Information_Alert_Button_Vailable_For_Last30Days_View() {
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays("last 30 days");
    }
}
