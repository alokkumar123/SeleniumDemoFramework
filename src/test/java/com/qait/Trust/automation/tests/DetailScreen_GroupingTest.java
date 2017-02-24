package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class DetailScreen_GroupingTest extends TestFundamentals {

    @Test
    public void TC01_Verify_Splash_Page_Contain_Groups_Or_Not() {
        test.detailScreen_group.verifyGroupOnSplashPage();
    }

    @Test
    public void TC02_Verify_Group_Names_Displaying_On_Spalsh_Page() {
        test.detailScreen_group.verifyingGroupNamesDisplayingOnSplashPage();
    }

    @Test
    public void TC03_Click_On_Group_And_Verify_Apps_Inside_Group() {
        test.detailScreen_group.clickOnGroupAndVerifyApps();
    }
}
