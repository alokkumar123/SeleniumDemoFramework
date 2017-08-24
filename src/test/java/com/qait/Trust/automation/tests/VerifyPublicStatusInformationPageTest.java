/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestSessionInitiator;
import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.qait.Trust.automation.TestSessionInitiator.testMethodName;

/**
 *
 * @author alokkumar
 */
public class VerifyPublicStatusInformationPageTest {

    public String base_url;
    public TestSessionInitiator test;
    public String testCase;

    @BeforeClass
    public void start_test_session() throws IOException {
        test = new TestSessionInitiator(this.getClass().getSimpleName());
        base_url = "https://techcheck-stage.cengage.com/status";

    }

    @Test
    public void Step01_Trust_1046_Launch_Application_With_Status() throws IOException {
        test.launchApplication(base_url);
    }

    @Test
    public void Step02_Trust_1046_Retrive_Data_From_Public_Status_Information_Page() {
        test.notificationpage.dataRetrivedFromPublicStatusInformationPage();
    }

    @Test
    public void Step03_Trust_1046_Verify_Public_Status_Information_Page() {
        test.notificationpage.verifyPublicStatusInformationPage("API version");
        test.notificationpage.verifyPublicStatusInformationPage("Code revision version");
        test.notificationpage.verifyPublicStatusInformationPage("VCS data");
        test.notificationpage.verifyPublicStatusInformationPage("Last commit");
        test.notificationpage.verifyPublicStatusInformationPage("Date");
        test.notificationpage.verifyPublicStatusInformationPage("Current branch");
        test.notificationpage.verifyPublicStatusInformationPage("Current server date");
        
    }

    @BeforeMethod
    public void getMethodName(Method methodName) {
        testCase = methodName.getName();
        testMethodName(methodName.getName());
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result, testCase);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        test.closeBrowserSession();
    }
}
