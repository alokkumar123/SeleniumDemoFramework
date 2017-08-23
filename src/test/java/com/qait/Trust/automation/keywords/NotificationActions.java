/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;

/**
 *
 * @author alokkumar
 */
public class NotificationActions extends GetPage {

    public String info;

    public NotificationActions(WebDriver driver) {
        super(driver, "NotificationPage");
        this.driver = driver;
    }

    public void serachNotification(String string) {
        element("link_serachNOtificationBox").click();
        element("link_serachNOtificationBox").clear();
        element("link_serachNOtificationBox").sendKeys(string);

    }

    public void verfiyEnbleAndDisableCheckBox() {
        String value = element("checkbox_EnableAndDisableButton").getAttribute("value");

        if (value.equalsIgnoreCase("on")) {
            ReportMsg.info("Checkbox is Enable");
        } else if (value.equalsIgnoreCase("on")) {

        }
    }

    public void dataRetrivedFromPublicStatusInformationPage() {
        info = element("pageInformation").getText();
        ReportMsg.log("******* Data Retrived from public status information page ********");
        ReportMsg.info(info);
    }

    public void verifyPublicStatusInformationPage(String data) {
        if (info.contains(data)) {
            ReportMsg.log("Verified '" + data + "' is displaying on public status information page");
        }
    }

}
