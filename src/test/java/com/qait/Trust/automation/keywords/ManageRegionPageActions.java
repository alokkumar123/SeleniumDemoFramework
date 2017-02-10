package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;

public class ManageRegionPageActions extends GetPage {

    public ManageRegionPageActions(WebDriver driver) {
        super(driver, "ManageRegion");
        this.driver = driver;
    }
    
    public boolean verifyAnyRegionCreatedByAutomationScriptIsAppearing() {
        boolean flag = false;
        
        ReportMsg.info("No. of Regions: " + elements("").size());
        for() {
            
        }
        
        return flag;
    }
    
    public void deleteRegionCreatedByAutomationScript() {
        
    }

    public void verifyRegionHasBeenDeleted(boolean flag) {
        
    }
    
    
}
