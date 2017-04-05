/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author alokkumar
 */
public class RegressionTestsPageActions extends GetPage {

    public RegressionTestsPageActions(WebDriver driver) {
        super(driver, "RegressionTestsPage.");
        this.driver = driver;
    }

    public void verifyRegressionTestsSystem() {
        isElementDisplayed("div_RegressionApp");
    }
    
    
}
