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

    public void checkLastUpdateTimeOverPlatformAvailability() {
        Boolean value;
        for (WebElement wb : elements("list_backgroundImageHeader")) {

            String appName = wb.getText();

            isElementDisplayed("div_lastUpdatedTime", appName);
            String text = element("div_lastUpdatedTime", appName).getText();
            ReportMsg.info("Time on application = " + text);
            String a[] = text.split(":");
            String a1[] = a[2].split(" ");

            Date date = new Date();
            String strDateFormat = "HH:mm a";
            DateFormat sdf = new SimpleDateFormat(strDateFormat);
            String systemTime = sdf.format(date);
            ReportMsg.info("System time=" + systemTime);
            String b[] = systemTime.split(":");
            String b1[] = b[1].split(" ");
            int time = Integer.parseInt(a1[0]) - Integer.parseInt(b1[0]);

            if (time < 5) {
                ReportMsg.info("Verified Last updated time is not be more than 5 minutes from the system time for " + appName + "app");

                value = true;
            } else {
                ReportMsg.info("Last update time is be more than 5 minutes from the system time");
                value = false;
            }
            ReportMsg.info("Verified last updated time on platform availability page");
        }

    }

    public void verifyListofAppDisplaying() {
        String appName = null;
        List<WebElement> a = elements("list_backgroundImageHeader");

        for (WebElement el : a) {
            appName = el.getText();
            ReportMsg.info("Platform name:- " + appName);
            isElementDisplayed("div_platformName", appName);
            waitTOSync();
        }
    }

    public void verifyNeedProductSupportLinkDisplaying() {
        isElementDisplayed("lnk_productSupportLink");
    }

    public void onceClickedOnLinkNewTabShouldBeOpenAndNavigateToURL(String url) {
        waitForElementToDisappear("lnk_productSupportLink");
        element("lnk_productSupportLink").click();
        ReportMsg.log("Clicked on 'Product Support Link'");

        String a = element("lnk_productSupportLink").getAttribute("href");
        ReportMsg.info("Product Support link: " + a);
    }

}
