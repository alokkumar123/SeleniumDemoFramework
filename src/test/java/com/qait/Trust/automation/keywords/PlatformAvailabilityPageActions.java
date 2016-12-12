/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;



public class PlatformAvailabilityPageActions extends GetPage {

    WebDriver driver;

    public PlatformAvailabilityPageActions(WebDriver driver) {
        super(driver, "PlatformAvailability");
        this.driver = driver;
    }

}
