/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alok.automation.keywords;

import com.alok.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.alok.automation.utils.ReportMsg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.alok.automation.utils.ConfigPropertyReader.getProperty;
import com.alok.automation.utils.ReportMsg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.TimeZone;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

/**
 *
 * @author alokkumar
 */
public class PageAction extends GetPage {

    public PageAction(WebDriver driver) {
        super(driver, "GmailLoginPage");
        this.driver = driver;
    }

    public void clickOnSignInButton() {
        isElementDisplayed("btn_signIn");
        element("btn_signIn").click();
    }

    public void enterUserName(String userName) {

        isElementDisplayed("text_userName");
        element("text_userName").sendKeys(userName);

        ReportMsg.info("Entered Username");

    }

    public void enterPassword(String password)  {
        waitTOSync(3000);
        isElementDisplayed("text_password");
        element("text_password").sendKeys(password);

        ReportMsg.info("Entered Passsword");
    }

    public void clickOnNextButton() {
        isElementDisplayed("btn_Next");
        element("btn_Next").click();
    }

    public void logoutFromProfile() {
        waitTOSync(5000);
        isElementDisplayed("userProfile");
        element("userProfile").click();
        
        ReportMsg.info("Clicked on User Profile");
        
        isElementDisplayed("btn_signOut");
        element("btn_signOut").click();
        
        ReportMsg.info("Signed out from gmail account");
    }

}
