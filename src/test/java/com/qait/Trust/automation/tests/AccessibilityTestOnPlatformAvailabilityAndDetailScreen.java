package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

import com.qait.Trust.automation.utils.HTMLCodeSniffer;

public class AccessibilityTestOnPlatformAvailabilityAndDetailScreen extends TestFundamentals {
    
    HTMLCodeSniffer htmlcs;
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
            
}
