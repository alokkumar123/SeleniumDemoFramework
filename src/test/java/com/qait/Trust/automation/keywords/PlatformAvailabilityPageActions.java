/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebElement;

public class PlatformAvailabilityPageActions extends GetPage {

    WebDriver driver;

    public PlatformAvailabilityPageActions(WebDriver driver) {
        super(driver, "PlatformAvailability");
        this.driver = driver;
    }

    public boolean checkLastUpdateTimeOverPlatformAvailability() {
        assert element("lastUpatedTime").isDisplayed();
        String text = element("lastUpatedTime").getText();
        ReportMsg.info("Time on application = " + text);
        String a[] = text.split(":");
        String a1[] = a[2].split(" ");
        //System.out.println("a1[0] = " + a1[0]);
        Boolean value;
        Date date = new Date();
        String strDateFormat = "HH:mm a";
        DateFormat sdf = new SimpleDateFormat(strDateFormat);
        String systemTime = sdf.format(date);
        ReportMsg.info("System time=" + systemTime);
        String b[] = systemTime.split(":");
        String b1[] = b[1].split(" ");
        int time = Integer.parseInt(a1[0]) - Integer.parseInt(b1[0]);

        if (time < 5) {
            ReportMsg.info("Verified Last updated time is not be more than 5 minutes from the system time");
            value = true;
        } else {
            ReportMsg.info("Last update time is be more than 5 minutes from the system time");
            value = false;
        }

        ReportMsg.info("Verified last updated time on platform availability page");
        return value;
    }

    public void verifyListofAppDisplaying() {

        String appName = null;
        List<WebElement> a = elements("app_List");

        for (WebElement el : a) {
            appName = el.getText();
            ReportMsg.info("App name is = " + appName);
            isElementDisplayed("app", appName);
            waitTOSync();

        }

    }

    public void verifyNeedProductSupportLinkDisplaying() {
        assert element("productSupportLink").isDisplayed();
    }

    public void onceClickedOnLinkNewTabShouldBeOpenAndNavigateToURL(String url) {
        waitForElementToDisappear("productSupportLink");
        element("productSupportLink").click();

        String a = element("productSupportLink").getAttribute("href");
        ReportMsg.info("product suport link = " + a);
    }

}
