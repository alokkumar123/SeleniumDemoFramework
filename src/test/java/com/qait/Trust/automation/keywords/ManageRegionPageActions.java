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
        // String newStr[] = newRegion.split(" ");
        
        ReportMsg.info("No. of Regions: " + elements("list_regions").size());
        for (WebElement elem : elements("list_regions")) {
            // for (String sub : newStr) {
                if (elem.getText().contains("Test")) {
                    element("span_trashIcon", String.valueOf(count)).click();
                    
                    executeJavascript("document.getElementsByClassName('btn btn-danger')[0].click()");
                    // element("btn_delete ").click();
                    ReportMsg.info("Clicked on 'Delete' button");
                    
                    // logMessage("Clicked on Region created by Automation script having '" + sub + "' string");
                }
           // }
            count++;
        }
        return flag;
    }
    
    public void deleteRegionCreatedByAutomationScript() {
        
    }

    public void verifyRegionHasBeenDeleted(boolean flag) {
        
    }
    
    
}
