/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class NotificationOneClickSelectFromMainNotificationListToEnableOrDisableTest extends TestFundamentals {

    String searchingText= "Testing Notification (Do not delete this)";
    
    @Test
    public void Step01_TRUST_1045_Login_As_Admin() {
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
    }

    @Test
    public void Step02_TRUST_1045_Search_NOtification() {
        test.notificationpage.serachNotification(searchingText);
    }

    @Test
    public void Step03_TRUST_1045_VerifyEnableAndDesibleButton(){
        test.notificationpage.verfiyEnbleAndDisableCheckBox();
    }
}
