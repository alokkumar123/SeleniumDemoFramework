/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alok.automation.tests;

import com.alok.automation.TestFundamentals;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class GmailAutomationTest extends TestFundamentals {

    @Test()
    public void Step01_click_On_Sign_In_Button() {
        test.pageAction.clickOnSignInButton();
    }

    @Test()
    public void Step02_Enter_User_Name() {
        test.pageAction.enterUserName("Your Email Id");
         test.pageAction.clickOnNextButton();
    }
    
    @Test()
    public void Step03_Enter_Password() {
       test.pageAction.enterPassword("Your password");
       test.pageAction.clickOnNextButton();
    }
    
    @Test()
    public void Step04_Logout_From_Profile(){
        test.pageAction.logoutFromProfile();
    }
  
}
