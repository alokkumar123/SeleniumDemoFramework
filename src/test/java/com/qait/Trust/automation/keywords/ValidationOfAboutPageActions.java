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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
        String a = element("div_aboutPageText").getText();
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
        ReportMsg.info("Verified footer is Displaying with Send Feedback link text");
    }

    public void slectHoursFromDropDown(String hours) {
        if (!hours.contains("last 12 hours")) {
            isElementDisplayed("span_lastHours");
            element("span_lastHours").click();
            element("select_hours", hours).click();
        }
        ReportMsg.info("selected " + hours + " from drop down");
    }

    public void navigateToDifferentMonitorFromHeadher() {
        try {
            isElementDisplayed("div_header");
            ReportMsg.info("Monitors are displaying on header in group format");
            int i = 0;
            for (WebElement ele : elements("div_header")) {
                ele.click();
                String header = ele.getText();
                ReportMsg.info("clicked on " + header + "from header");
                int j = 0;
                isElementDisplayed("link_mentuItems");
                ReportMsg.info("size of the apps = " + elements("link_mentuItems", header).size());
                for (WebElement l : elements("link_mentuItems", header)) {
                    String app = l.getText();
                    l.click();
                    ReportMsg.info("clicked on " + app + " form header and verifying footer");
                    verifyFooter();
                    break;

                }
                break;
            }
        } catch (NoSuchElementException e) {
            ReportMsg.info("Monitors are displaying on header");
            isElementDisplayed("link_appName");
            element("link_appName").click();
            ReportMsg.info("Cliked on app fron heade and verify footer");
            verifyFooter();
        }
    }
}
