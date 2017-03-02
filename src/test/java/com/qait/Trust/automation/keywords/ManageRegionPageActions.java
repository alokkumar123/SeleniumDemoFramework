package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageRegionPageActions extends GetPage {

    public ManageRegionPageActions(WebDriver driver) {
        super(driver, "ManageRegion");
        this.driver = driver;
    }

    public void verifyAnyRegionCreatedByAutomationScriptIsAppearing(String newRegion) {
        String popUp = "Delete";
        try {
            isElementDisplayed("div_region", newRegion);
            element("span_deleteNewRegion", newRegion).click();
            ReportMsg.info("Deleting " + newRegion + " created by automation script");

            isElementDisplayed("button_popUp", popUp);
            element("button_popUp", popUp).click();
            ReportMsg.info("Clicked on " + popUp);

        } catch (Exception NoSuchElementException) {
            isElementDisplayed("h_Region");
            ReportMsg.info("No region is created by automation is appearing in manage region list");
        }

    }

    public void deleteRegionCreatedByAutomationScript() {

    }

    public void verifyRegionHasBeenDeleted(boolean flag) {

    }

    public void clearSearchInputBox() {
        element("input_searchBox").clear();
        element("input_searchBox").click();
        ReportMsg.info("Cleared search input boz");
    }

    public void verifySearchedSystemOnRegions(String searchTerm) {
        ReportMsg.info("No. of matches: " + elements("td_searchedSystem").size());
        for (WebElement term : elements("td_searchedSystem")) {
            ReportMsg.info("Text of matched term: " + term.getText());
        }
    }

}
