/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class ValidationOfAboutPageActions extends GetPage {

    public ValidationOfAboutPageActions(WebDriver driver) {
        super(driver, "ValidationAboutPage");
        this.driver = driver;
    }

    public void createAndSaveAbouPage(String pageName) {
        switchToFrame(element("iframe"));
        isElementDisplayed("div_aboutPageText");
//        element("div_aboutPageText").click();
//        element("div_aboutPageText").clear();
        String a=element("div_aboutPageText").getText();
//        element("div_aboutPageText").sendKeys(Keys.chord(Keys.CONTROL, a), pageName);
        Actions actions = new Actions(driver);
        actions.moveToElement(element("div_aboutPageText"));
        actions.click();
//         element("div_aboutPageText").click();
        //actions.clickAndHold();
        //element("div_aboutPageText").clear();
        actions.sendKeys(Keys.chord(Keys.CONTROL, a), pageName);
        actions.build().perform();
        ReportMsg.info("created about page named as " + pageName);
        switchToDefaultContent();
        clickOnSaveButton();
        waitTOSync();
    }

    public void clickOnSaveButton() {
        element("button_save").click();
        ReportMsg.info("Clicked On save button");
    }

    public void clickOnAboutTechcheckLink() {
        isElementDisplayed("link_aboutTechCheck");
        element("link_aboutTechCheck").click();
        ReportMsg.info("Clicked On About TechCheck Link");
    }

    public void verifyingSavedInformationOnTechChechLink(String abouPageText) {
        String info = abouPageText;
        isElementDisplayed("h_savedInfo", info);
        ReportMsg.info("Verified saved information is displaying on TechChech Link");
    }

    public void verifyFooter() {
        isElementDisplayed("link_footer");
    }
}
