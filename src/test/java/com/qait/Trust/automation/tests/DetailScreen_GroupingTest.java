/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import org.testng.annotations.Test;

public class DetailScreen_GroupingTest extends TestFundamentals {

    @Test
    public void Verify_Splash_Page_Contain_Groups_Or_Not() {
        test.detailScreen_group.verifyGroupOnSplashPage();

    }

}
