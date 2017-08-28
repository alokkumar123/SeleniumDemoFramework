/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.ConfigPropertyReader.getProperty;
import java.io.IOException;
import org.testng.annotations.Test;

/**
 *
 * @author alokkumar
 */
public class MissingDataVerificationTest extends TestFundamentals {

    String userName = getProperty("userName");
    String password = getProperty("password");
    String monitorName = "Regression-679";
    String systemName = "Regression Tests";

    @Test
    public void Step01_Trust_1162_Login_Into_Application_With_QaAdmin() throws IOException {
        test.createAndConfigPage.logAsAdmin(userName, password);

    }

    @Test
    public void Step02_Trust_1162_Navigate_To_Missing_Data_Monitor() {
        test.createNotificationPage.navigateToMonitorFromAdminPage(monitorName,systemName);
    }
    
    @Test
    public void Step03_Trust_1162_Get_The_Color_Status_Of_Current_Time_Frame_Of_Last_12_Hours(){
        test.detailScreenPage.selectLastAvailableHours("last 12 hours");
        test.detailScreenPage.getTheColorStatusOfTimeFrame("last 12 hours");
    }

    @Test
    public void Step04_Trust_1162_Get_The_Color_Status_Of_Current_Time_Frame_Of_Last_24_Hours(){
        test.detailScreenPage.selectLastAvailableHours("last 24 hours");
        test.detailScreenPage.getTheColorStatusOfTimeFrame("last 24 hours");
    }
    
    @Test
    public void Step05_Trust_1162_Verify_The_Cell_Status_Of_Current_Time(){
        test.detailScreenPage.verifyCellStatusOfCurrentTime("");
    }
            
}
