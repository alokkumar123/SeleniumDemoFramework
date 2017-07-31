/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author alokkumar
 */
public class FAQLayoutActions extends GetPage {

    public FAQLayoutActions(WebDriver driver) {
        super(driver, "FAQLayoutPage");
        this.driver = driver;
    }

    public void verifyCollapseAndExpendUnderFAQSection() {
        isElementDisplayed("span_collapseSection");
        element("span_collapseSection").click();
        ReportMsg.info("Verified 'Collapse' section");
        isElementDisplayed("span_expendSection");
        element("span_expendSection").click();
        ReportMsg.info("Verified 'Expand' section");

    }

    public void clickonFAQLink() {
        element("link_faq").click();
        ReportMsg.info("Clicked on 'FAQ' Link");
    }

    public void verifyTheListOfSectionsDisplayingWithQuestions() {
        isElementDisplayed("h4_ListOfQuestions");
        ReportMsg.info("List of Sections is displaying with these question ....");
        for (WebElement e : elements("h4_ListOfQuestions")) {
            ReportMsg.info(e.getText());
        }
    }

    public void verifyQuestionAndAnswerAreMergeInsideOneBlock() {
        isElementDisplayed("div_QuesAndAnsBlock");
        int v = 1;
        for (WebElement ele : elements("div_QuesAndAnsBlock")) {
            ReportMsg.info("Verifying Questions and Answers in block: " + v);
            String val = String.valueOf(v);
            ReportMsg.log("**** Question and Answer under bloack : " + v + " ****");
            isElementDisplayed("div_blockSpecificQuestion", val);
            WebElement eleQues = element("div_blockSpecificQuestion", val);
            ReportMsg.info(eleQues.getText());
            isElementDisplayed("div_blockSpecificAnswer", val);
            WebElement eleAns = element("div_blockSpecificAnswer", val);
            ReportMsg.info(eleAns.getText());
            v = Integer.parseInt(val) + 1;

        }
    }

    public void verifyFAQsAnswersAreHavingFunctionalityOfExpandAndCollapseByClickingInQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
