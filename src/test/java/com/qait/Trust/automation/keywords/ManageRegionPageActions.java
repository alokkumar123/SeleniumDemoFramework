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
    
    public boolean verifyAnyRegionCreatedByAutomationScriptIsAppearing(String newRegion) {
        int count = 0;
        boolean flag = false;
        
        ReportMsg.info("No. of Regions: " + elements("list_regions").size());
        for (WebElement elem : elements("list_regions")) {
                if (elem.getText().equalsIgnoreCase(newRegion)) {
                    element("span_trashIcon", String.valueOf(count)).click();
                    ReportMsg.info("Clicked on 'Trash' icon");
                    
                    executeJavascript("document.getElementsByClassName('btn btn-danger')[0].click()");
                    // element("btn_delete ").click();
                    ReportMsg.info("Clicked on 'Delete' button");
                }
            count++;
        }
        return flag;
    }
    
    public void deleteRegionCreatedByAutomationScript() {
        
    }

    public void verifyRegionHasBeenDeleted(boolean flag) {
        
    }
    
    public void clearSearchInputBox() {
        element("input_searchBox").clear();
        ReportMsg.info("Cleared search input boz");
    }
    
    public void verifySearchedSystemOnRegions(String searchTerm) {
        ReportMsg.info("No. of matches: " + elements("td_searchedSystem").size());
        for (WebElement term : elements("td_searchedSystem")) {
            ReportMsg.info("Text of matched term: " + term.getText());
        }
    }
    
    
}
