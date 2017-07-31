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
public class FAQContentOnFaqLinkTest extends TestFundamentals {

    @Test
    public void TRUST_827_TC001_Login_And_Navigate_To_Splash_Page() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();

    }

    @Test
    public void TRUST_827_TC002_Click_On_FAQ_Link() {
        test.faqLayoutPage.clickonFAQLink();
    }

    @Test
    public void TRUST_827_TC003_Verify_The_List_Of_Sections_Displaying_With_Questions() {
        test.faqLayoutPage.verifyTheListOfSectionsDisplayingWithQuestions();
    }

    @Test
    public void TRUST_827_TC004_Verify_Question_And_Answer_Are_Merge_Inside_One_Block() {
        test.faqLayoutPage.verifyQuestionAndAnswerAreMergeInsideOneBlock();
    }
    
    @Test
    public void TRUST_827_TC005_Verify_FAQs_Answers_Are_Having_Functionality_Of_Expand_And_Collapse_By_Clicking_In_Question(){
        test.faqLayoutPage.verifyFAQsAnswersAreHavingFunctionalityOfExpandAndCollapseByClickingInQuestion();
    }
}
