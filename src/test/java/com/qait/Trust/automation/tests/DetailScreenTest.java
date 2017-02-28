package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;
import static com.qait.Trust.automation.utils.YamlReader.getData;

public class DetailScreenTest extends TestFundamentals {
    
    String systemView;
    
    @Test
    public void TC01_Verifying_All_Details_For_MindTap_Platform() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.clickOnSystem(getData("appName.mindtap"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.mindtap"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.mindtap"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.mindtap"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "Mindtap");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.mindtap"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }
    
    @Test
    public void TC02_Verifying_All_Details_For_Cengage_Brain_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.cengageBrain"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageBrain"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.cengageBrain"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.cengageBrain"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "cengageBrain");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.cengageBrain"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TC03_Verifying_All_Details_For_Aplia_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.aplia"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.aplia"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.aplia"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.aplia"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "aplia");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.aplia"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.aplia"));
    }

    @Test
    public void TC04_Verifying_All_Details_For_CengageNOWv2_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.cengageNOWv2"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageNOWv2"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.cengageNOWv2"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.cengageNOWv2"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "cengageNOWv2");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.cengageNOWv2"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNOWv2"));
    }

    @Test
    public void TC05_Verifying_All_Details_For_OWLv2_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.OWLv2"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.OWLv2"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.OWLv2"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.OWLv2"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "OWLv2");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.OWLv2"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.OWLv2"));
    }

    @Test
    public void TC06_Verifying_All_Details_For_SAM_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.SAM"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.SAM"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.SAM"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.SAM"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "SAM");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.SAM"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.SAM"));
    }

    @Test
    public void TC07_Verifying_All_Details_For_4LTR_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.4LTR"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.4LTR"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.4LTR"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.4LTR"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "4LTR");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.4LTR"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.4LTR"));
    }

    @Test
    public void TC08_Verifying_All_Details_For_Mindtap_MathFoundation_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.mindtapMathFoundation"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "mindtapMathFoundation");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.mindtapMathFoundation"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.mindtapMathFoundation"));
    }

    @Test
    public void TC09_Verifying_All_Details_For_CengageNOW_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.cengageNow"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.cengageNow"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.cengageNow"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.cengageNow"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "CNOWv1");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.cengageNow"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.cengageNow"));
    }

    @Test
    public void TC10_Verifying_All_Details_For_Questia_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.questia"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.questia"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.questia"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.questia"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "questia");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.questia"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.questia"));
    }
    
    @Test
    public void TC11_Verifying_All_Details_For_Learning_Objects_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.learningObjects"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.learningObjects"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.learningObjects"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.learningObjects"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "learningObjects");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.learningObjects"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.learningObjects"));
    }
    
    @Test
    public void TC12_Verifying_All_Details_For_WebAssign_Platform() {
        test.platformAvailabilityPage.clickOnSystem(getData("appName.webAssign"), systemView);
        test.detailScreenPage.verifyBreadCrumb(getData("appName.webAssign"));
        test.detailScreenPage.verifyDropDownOptionsForLastHours();
        test.detailScreenPage.verifyTimeZoneDropDownForUser();
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.webAssign"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.webAssign"));
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "webAssign");
        test.detailScreenPage.checkCurrentInformationalAlertButtonforLast30Days(getData("appName.webAssign"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        test.detailScreenPage.checkForColorNotationGreenInThePlatformAvailabilityAndDetailScreen(getData("appName.webAssign"));
    }
    
}
