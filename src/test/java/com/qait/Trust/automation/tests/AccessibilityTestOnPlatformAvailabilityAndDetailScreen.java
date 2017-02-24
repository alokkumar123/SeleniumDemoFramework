package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

import static com.qait.Trust.automation.utils.YamlReader.getData;

public class AccessibilityTestOnPlatformAvailabilityAndDetailScreen extends TestFundamentals {
    
    String accessibilityStandard = "WCAG2AA";
    boolean statusErrors = true;
    boolean statusWarnings = true;
    boolean statusNotices = false;
    
    @Test
    public void Step01_Accessibility_Check_On_Platform_Availability_Page() { 
        test.injectBookMarkletMethodOnWebPage();
        test.codeSniffer.verifyHTMLCodeSnifferWrapperIsDisplayed();
        test.codeSniffer.accessibilityTestViaBookMarkletMethodInHTMLCodeSniffer(
                accessibilityStandard, statusErrors, statusWarnings, statusNotices);
    }
    
    @Test
    public void Step02_Accessibility_Check_On_Detail_Screen_Page_For_12_Hours() {
        test.detailScreenPage.verifyBreadCrumb(getData("appName.mindtap"));
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 12 hours", "12", getData("appName.mindtap"));
        test.injectBookMarkletMethodOnWebPage();
        test.codeSniffer.verifyHTMLCodeSnifferWrapperIsDisplayed();
        test.codeSniffer.accessibilityTestViaBookMarkletMethodInHTMLCodeSniffer(
                accessibilityStandard, statusErrors, statusWarnings, statusNotices);
    }
    
    @Test
    public void Step03_Accessibility_Check_On_Detail_Screen_Page_For_24_Hours() {
        test.detailScreenPage.verifyInformationAvailableForLastHours("last 24 hours", "24", getData("appName.mindtap"));
        test.injectBookMarkletMethodOnWebPage();
        test.codeSniffer.verifyHTMLCodeSnifferWrapperIsDisplayed();
        test.codeSniffer.accessibilityTestViaBookMarkletMethodInHTMLCodeSniffer(
                accessibilityStandard, statusErrors, statusWarnings, statusNotices);
    }
    
    @Test
    public void Step03_Accessibility_Check_On_Detail_Screen_Page_For_30_Days() {
        test.detailScreenPage.verifyInformationAvailableForLast30Days("last 30 days", "aplia");
        test.injectBookMarkletMethodOnWebPage();
        test.codeSniffer.verifyHTMLCodeSnifferWrapperIsDisplayed();
        test.codeSniffer.accessibilityTestViaBookMarkletMethodInHTMLCodeSniffer(
                accessibilityStandard, statusErrors, statusWarnings, statusNotices);
    }
            
}
