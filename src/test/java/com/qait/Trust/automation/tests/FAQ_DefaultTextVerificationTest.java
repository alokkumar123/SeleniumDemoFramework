/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class FAQ_DefaultTextVerificationTest extends TestFundamentals {

    String adminMenuMangeFaq = "Manage FAQs";
    String question = "New Question";
    String answer = "New Answer";

    @Test
    public void Step01_TRUST_826_Login_As_Admin() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
       

    }
    
    @Test
    public void Step02_TRUST_826_Navigate_To_Manage_FAQ() {
         test.createAndConfigPage.navigateToAdminMenu(adminMenuMangeFaq);
    }
    
    @Test
    public void Step03_TRUST_826_Verify_Default_New_Question_Text_In_Label_Box(){
        test.faqLayoutPage.verifyDefaultNewQuestionTextInFaqLabelBox(question);
        
    }

    @Test
    public void Step04_TRUST_826_Verify_Default_New_Answer_Text_In_Label_Box(){
        test.faqLayoutPage.verifyDefaultNewAnswerTextInFaqLabelBox(answer);
    }

}