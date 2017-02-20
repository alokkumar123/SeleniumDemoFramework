/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;

public class DetailScreen_GroupActions extends GetPage {

    public DetailScreen_GroupActions(WebDriver driver) {
        super(driver, "DetailScreenGroup");
        this.driver = driver;
    }

    public void verifyGroupOnSplashPage() {
        isElementDisplayed("div_groupGroup");
    }
}
