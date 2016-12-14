/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class DetailScreenTest extends TestFundamentals {

    @Test
    public void TC04_Check_For_Breadcrumb() {
        test.detailScreenPage.vrifyBreadcrumb();
    }

    @Test
    public void TC05_Check_For_Drop_Down_Options_Available_In_Detail_Screen() {
        test.detailScreenPage.clickOnSingleApp("appName.cengageBrain");
        test.detailScreenPage.verfifyDropDownOptionsWithOptions("last 12 hours");
        test.detailScreenPage.verfifyDropDownOptionsWithOptions("last 24 hours");
        test.detailScreenPage.verfifyDropDownOptionsWithOptions("last 30 days");
    }

    @Test
    public void TC_06_Check_For_4_Time_Zones_Available_For_User() {
        test.detailScreenPage.verifyTimeZoneForUser("IST (local)");
        test.detailScreenPage.verifyTimeZoneForUser("EST");
        test.detailScreenPage.verifyTimeZoneForUser("CST");
        test.detailScreenPage.verifyTimeZoneForUser("PST");
        test.detailScreenPage.verifyTimeZoneForUser("GMT");
    }
}
