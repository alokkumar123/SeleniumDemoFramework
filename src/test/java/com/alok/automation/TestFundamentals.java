package com.alok.automation;

import static com.alok.automation.TestSessionInitiator.testMethodName;
import static com.alok.automation.utils.YamlReader.*;
import java.io.IOException;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author alokkumar
 */

public class TestFundamentals {

    public TestSessionInitiator test;
    public String CourseKey;
    public String activityName;
    public String base_url;
    public String sso_url;
    public String testCase;

    public void init() {
   
    }

    @BeforeClass
    public void start_test_session() throws IOException {       
        test = new TestSessionInitiator(this.getClass().getSimpleName());
        base_url = getData("base_url");
        test.launchApplication(base_url);
        init();
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
