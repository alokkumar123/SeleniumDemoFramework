package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;
import static com.qait.Trust.automation.utils.YamlReader.getData;

public class DetailScreenTest extends TestFundamentals {

    @Test
    public void TC01_Verifying_All_Details_For_MindTap_Platform() {
        test.detailScreenPage.logAsAdmin();
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.verifyBreadCrumb(getData("appName.mindtap"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.mindtap"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.mindtap"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.mindtap"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtap"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtap"));

    }

    @Test
    public void TC02_Verifying_All_Details_For_Cengage_Brain_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageBrain"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.cengageBrain"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.cengageBrain"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "cengageBrain");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.cengageBrain"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageBrain"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageBrain"));
    }

    @Test
    public void TC03_verifying_All_Details_For_Aplia_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.aplia"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.aplia"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.aplia"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "aplia");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.aplia"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.aplia"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.aplia"));
    }

    @Test
    public void TC04_verifying_All_Details_For_CengageNOWv2_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageNOWv2"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.cengageNOWv2"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.cengageNOWv2"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "cengageNOWv2");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.cengageNOWv2"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNOWv2"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNOWv2"));
    }

    @Test
    public void TC05_verifying_All_Details_For_OWLv2_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.OWLv2"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.OWLv2"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.OWLv2"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "OWLv2");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.OWLv2"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.OWLv2"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.OWLv2"));
    }

    @Test
    public void TC06_verifying_All_Details_For_SAM_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.SAM"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.SAM"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.SAM"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "SAM");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.SAM"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.SAM"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.SAM"));
    }

    @Test
    public void TC07_verifying_All_Details_For_4LTR_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.4LTR"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.4LTR"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.4LTR"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "4LTR");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.4LTR"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.4LTR"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.4LTR"));
    }

    @Test
    public void TC08_verifying_All_Details_For_mindtapMathFoundation_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "mindtapMathFoundation");
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtapMathFoundation"));
    }

    @Test
    public void TC09_verifying_All_Details_For_CengageNOW_Platform() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageNow"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.checkCurrecntInformationAlertButtonforLastDays1(getData("appName.cengageNow"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 12 hours", "12", getData("appName.cengageNow"));
        test.detailScreenPage.verifyInformationAvailableForLastHours1("last 24 hours", "24", getData("appName.cengageNow"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days1("last 30 days", "CNOWv1");
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNow"));
        test.detailScreenPage.checkForColorNotationInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNow"));
    }
}
