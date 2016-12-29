package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;
import static com.qait.Trust.automation.utils.YamlReader.getData;

public class DetailScreenTest extends TestFundamentals {

    @Test
    public void TC01_verifying_All_Details_For_MindTap_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.mindtap"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12");
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24");
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC02_verifying_All_Details_For_Cengage_Brain_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageBrain"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12");
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24");
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC03_verifying_All_Details_For_Aplia_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.aplia"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12");
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24");
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC04_verifying_All_Details_For_CengageNOWv2_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageNOWv2"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12");
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24");
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC05_verifying_All_Details_For_OWLv2_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.OWLv2"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12");
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24");
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC06_verifying_All_Details_For_SAM_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.SAM"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12");
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24");
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC07_verifying_All_Details_For_4LTR_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.4LTR"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12");
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24");
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC08_verifying_All_Details_For_mindtapMathFoundation_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12");
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24");
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }
}
