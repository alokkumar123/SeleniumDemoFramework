/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;

public class CheckSearchFunctionalityCyclePageActions extends GetPage {

    public CheckSearchFunctionalityCyclePageActions(WebDriver driver) {
        super(driver, "CheckSearchFunctionalityCycle");
        this.driver = driver;
    }

    String searchingText = "MindTap Math Foundations";

    public void validateSearchFunctionalityForPossitiveCycle() {
        isElementDisplayed("input_serachBox");
        ReportMsg.info("Search box is available");
        element("input_serachBox").clear();
        element("input_serachBox").sendKeys(searchingText);
        isElementDisplayed("serarched_text", searchingText);
        ReportMsg.info("Validated " + searchingText + " is displaying after perfroming search operation ");

    }

    public void validateSearchFunctionalityForNegativeCycle() {
        searchingText = "Worng text";
        isElementDisplayed("input_serachBox");
        ReportMsg.info("Search box is available");
        element("input_serachBox").clear();
        element("input_serachBox").sendKeys(searchingText);
        ReportMsg.info("Validated no result is availble after performing " + searchingText + " in search box");

    }
}
