package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class ValidateHeaderAndFooterTest extends TestFundamentals {

    @Test
    public void Step_01_Trust_537_Verify_Footer_On_Spalsh_Page() {
        test.aboutPage.verifyFooter();
    }

    @Test
    public void Step_02_Trust_537_Verify_Footer_On_Detailed_Screen_Page() {
        
    }
}
