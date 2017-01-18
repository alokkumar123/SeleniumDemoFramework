package com.qait.Trust.automation.utils;

import com.qait.Trust.automation.getpageobjects.GetPage;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class HTMLCodeSniffer extends GetPage {

    WebDriver driver;

    public HTMLCodeSniffer(WebDriver driver) {
        super(driver, "HTMLCodeSniffer");
    }

    public void verifyHTMLCodeSnifferWrapperIsDisplayed() {
        Assert.assertTrue(
                element("modal_htmlCodeSniffer").isDisplayed(),
                "[Assertion Failed]: HTML Code Sniffer Modal is NOT displayed!!!");
        logMessage("[Assertion Passed]: HTML Code Sniffer Modal is DISPLAYED!!!");

        Assert.assertEquals(
                element("txt_htmlCodeSnifferHeader").getText(),
                "HTML_CODESNIFFER BY SQUIZ",
                "[Assertion Failed]: HTML Code Sniffer Header is NOT matching!!!");
        logMessage("[Assertion Passed]: HTML Code Sniffer Header is MATCHING!!!");

        Assert.assertTrue(
                element("lnk_close").isDisplayed(),
                "[Assertion Failed]: 'Close' link is NOT displayed!!!");
        logMessage("[Assertion Passed]: 'Close' link is DISPLAYED!!!");

        Assert.assertTrue(
                element("div_settings").isDisplayed(),
                "[Assertion Failed]: Code Sniffer settings section is NOT displayed!!!");
        logMessage("[Assertion Passed]: Code Sniffer settings section is DISPLAYED!!!");

        Assert.assertTrue(
                element("div_useStandard").isDisplayed(),
                "[Assertion Failed]: 'Standard' settings dropbox is NOT displayed!!!");
        logMessage("[Assertion Passed]: 'Standard' settings dropbox is DISPLAYED!!!");

        Assert.assertTrue(
                element("div_issueCount").isDisplayed(),
                "[Assertion Failed]: Issue Count settings is NOT displayed!!!");
        logMessage("[Assertion Passed]: Issue count settings is DISPLAYED!!!");

        Assert.assertTrue(
                element("div_issueCountHelp").isDisplayed(),
                "[Assertion Failed]: Issue Count help text is NOT displayed!!!");
        logMessage("[Assertion Passed]: Issue Count help text is DISPLAYED!!!");

        Assert.assertTrue(
                element("div_viewReport").isDisplayed(),
                "[Assertion Failed]: 'View Report' button is NOT displayed!!!");
        logMessage("[Assertion Passed]: 'View Report' button is DISPLAYED!!!\n");
    }

    private void fetchIssueCountFromHTMLCodeSniffer() {
        logMessage("No. of Errors: " + element("txt_issueTitleValue ", "error").getText());
        Assert.assertTrue(
                element("div_issueTileError").isDisplayed(),
                "[Assertion Failed]: 'Errors' issue title is NOT displayed!!!");
        logMessage("[Assertion Passed]: 'Errors' issue title is DISPLAYED!!!\n");

        logMessage("No. of Warnings: " + element("txt_issueTitleValue ", "warning").getText());
        Assert.assertTrue(
                element("div_issueTileWarning").isDisplayed(),
                "[Assertion Failed]: 'Warnings' issue title is NOT displayed!!!");
        logMessage("[Assertion Passed]: 'Warnings' issue title is DISPLAYED!!!\n");

        logMessage("No. of Notices: " + element("txt_issueTitleValue ", "notice").getText());
        Assert.assertTrue(
                element("div_issueTileNotices").isDisplayed(),
                "[Assertion Failed]: 'Notices' issue title is NOT displayed!!!");
        logMessage("[Assertion Passed]: 'Notices' issue title is DISPLAYED!!!\n");
    }

    private void statusOfHTMLCodeSnifferErrorCheckbox(boolean errorReport) {
        String statusOfErrorCheckbox = element("label_checkboxStatus", "error").getAttribute("class");
        logMessage("'HTMLCS Error' Checkbox: '" + statusOfErrorCheckbox + "'");

        if (statusOfErrorCheckbox.contains("active") && errorReport == true) {
            logMessage("'HTMLCS Error Issue' Tile is ALREADY added to Accessibility Report!!!\n");
        } else if (!(statusOfErrorCheckbox.contains("active")) && errorReport == true) {
            element("span_checkboxSlider", "error").click();
            logMessage("Clicked on HTMLCS checkbox Slider of Error Issue");
            logMessage("'HTMLCS Error Issue' will be INCLUDED in Accessibility Report!!!\n");
        } else if (statusOfErrorCheckbox.contains("active") && errorReport == false) {
            element("span_checkboxSlider", "error").click();
            logMessage("Clicked on HTMLCS checkbox Slider of Error Issue");
            logMessage("'HTMLCS Error Issue' will NOT be INCLUDED in Accessibility Report!!!\n");
        } else if (!(statusOfErrorCheckbox.contains("active")) && errorReport == false) {
            logMessage("'HTMLCS Error Issue' Tile is ALREADY NOT selected in Accessibility Report!!!\n");
        }
    }

    private void statusOfHTMLCodeSnifferWarningCheckbox(boolean warningsReport) {
        String statusOfWarningCheckbox = element("label_checkboxStatus", "warning").getAttribute("class");
        logMessage("'HTMLCS Warning' Checkbox: '" + statusOfWarningCheckbox + "'");

        if (statusOfWarningCheckbox.contains("active") && warningsReport == true) {
            logMessage("'HTMLCS Warning Issue' Tile is ALREADY added to Accessibility Report!!!\n");
        } else if (!(statusOfWarningCheckbox.contains("active")) && warningsReport == true) {
            element("span_checkboxSlider", "warning").click();
            logMessage("Clicked on HTMLCS checkbox Slider of Warning Issue");
            logMessage("'HTMLCS Warning Issue' will be INCLUDED in Accessibility Report!!!\n");
        } else if (statusOfWarningCheckbox.contains("active") && warningsReport == false) {
            element("span_checkboxSlider", "warning").click();
            logMessage("Clicked on HTMLCS checkbox Slider of Warning Issue");
            logMessage("'HTMLCS Warning Issue' will NOT be INCLUDED in Accessibility Report!!!\n");
        } else if (!(statusOfWarningCheckbox.contains("active")) && warningsReport == false) {
            logMessage("'HTMLCS Warning Issue Tile' is ALREADY NOT selected in Accessibility Report!!!\n");
        }
    }

    private void statusOfHTMLCodeSnifferNoticeCheckbox(boolean noticesReport) {
        String statusOfNoticeCheckbox = element("label_checkboxStatus", "notice").getAttribute("class");
        logMessage("'HTMLCS Notice' Checkbox: '" + statusOfNoticeCheckbox + "'");

        if (statusOfNoticeCheckbox.contains("active") && noticesReport == true) {
            logMessage("'HTMLCS Notice Issue' Tile is ALREADY added to Accessibility Report!!!\n");
        } else if (!(statusOfNoticeCheckbox.contains("active")) && noticesReport == true) {
            element("span_checkboxSlider", "notice").click();
            logMessage("Clicked on HTMLCS checkbox Slider of Notice Issue");
            logMessage("'HTMLCS Notice Issue' will be INCLUDED in Accessibility Report!!!\n");
        } else if (statusOfNoticeCheckbox.contains("active") && noticesReport == false) {
            element("span_checkboxSlider", "notice").click();
            logMessage("Clicked on HTMLCS checkbox Slider of Notice Issue");
            logMessage("'HTMLCS Notice Issue' will NOT be INCLUDED in Accessibility Report!!!\n");
        } else if (!(statusOfNoticeCheckbox.contains("active")) && noticesReport == false) {
            logMessage("'HTMLCS Notice Issue' Tile is ALREADY NOT selected in Accessibility Report!!!\n");
        }
    }

    public void accessibilityTestViaBookMarkletMethodInHTMLCodeSniffer(
            String conformanceLevel, boolean errorReport,
            boolean warningsReport, boolean noticesReport) {

        String defaultValue = (String) executeJavascript("return document.getElementById('HTMLCS-settings-use-standard-select').value");
        logMessage("Default Value of Standard: " + defaultValue);

        if (defaultValue.equalsIgnoreCase(conformanceLevel)) {
            logMessage("'" + conformanceLevel + "' Standard is ALREADY selected!!!\n");
        } else {
            selectProvidedTextFromDropDown(element("drpdown_useStandard"), conformanceLevel);
            logMessage("Selected '" + conformanceLevel + "' value from Standard drop down!!!\n");
        }

        // NOTE: Wait for HTML Code Sniffer tool to detect the violatons as per selected Standard
        wait.hardWait(2);

        fetchIssueCountFromHTMLCodeSniffer();

        statusOfHTMLCodeSnifferErrorCheckbox(errorReport);

        statusOfHTMLCodeSnifferWarningCheckbox(warningsReport);

        statusOfHTMLCodeSnifferNoticeCheckbox(noticesReport);
        
        element("div_viewReport").click();
        logMessage("Clicked on 'View Report' button");
        
        String pageArray[] = element("btn_pageNumber").getText().split(" ");
        int totalPage = Integer.parseInt(pageArray[3]);
        ArrayList<String> errorList = new ArrayList<String>();
        ArrayList<String> warningList = new ArrayList<String>();
        ArrayList<String> noticeList = new ArrayList<String>();
        
        logMessage("Total No. of Pages: " + totalPage);
        for(int count = 1; count <= totalPage; count++) {
            for (WebElement elem : elements("list_accessibilityIssues", String.valueOf(count))) {
                if(elem.getAttribute("class").contains("HTMLCS-error")) {
                    errorList.add(element("txt_issueTitleReport", String.valueOf(count)).getText());
                }
                else if(elem.getAttribute("class").contains("HTMLCS-warning")) {
                    warningList.add(element("txt_issueTitleReport", String.valueOf(count)).getText());
                }
                else if(elem.getAttribute("class").contains("HTMLCS-notice")) {
                    noticeList.add(element("txt_issueTitleReport", String.valueOf(count)).getText());
                    logMessage("Issue added under 'Notice' type");
                }
            }
            if(totalPage != count) {
                element("btn_nextPage").click();
            }
        } 
        
        int errorCount = 1;
        if (!errorList.isEmpty()) {
            logMessage("\nBelow are type of Error type issues:-");
            for (String strError : errorList) {
                logMessage("Error " + errorCount + ": '" + strError + "'");
                errorCount++;
            }
        }
        
        int warningCount = 1;
        if (!warningList.isEmpty()) {
            logMessage("\nBelow are type of Warning type issues:-");
            for (String strWarning : warningList) {
                logMessage("Warning " + warningCount + ": '" + strWarning + "'");
                warningCount++;
            }
        }
        
        int noticeCount = 1;
        if (!noticeList.isEmpty()) {
            logMessage("\nBelow are type of Notice type issues:-");
            for (String strNotice : noticeList) {
                logMessage("Notice " + noticeCount + ": '" + strNotice + "'");
                noticeCount++;
            }
        }
        
        element("lnk_close").click();
        logMessage("\nClicked on 'Close' link of HTML_CodeSniffer tool");
        
        Assert.assertTrue((errorList.isEmpty() 
                && warningList.isEmpty() && noticeList.isEmpty()), 
                "[Assertion Failed]: Accessibility Issues FOUND on Web page!!!");
        logMessage("[Assertion Passed]: NO Accessibility Issues found on Web page!!!");
    }

}
