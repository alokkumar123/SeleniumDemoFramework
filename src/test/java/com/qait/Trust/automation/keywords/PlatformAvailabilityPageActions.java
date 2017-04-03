package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PlatformAvailabilityPageActions extends GetPage {

    WebDriver driver;

    public PlatformAvailabilityPageActions(WebDriver driver) {
        super(driver, "PlatformAvailability");
        this.driver = driver;
    }

    public void checkLastUpdateTimeOverPlatformAvailability(String systemView) {
        int i = 0;
        boolean value = false;
        if (systemView.equalsIgnoreCase("Grouping")) {
            for (WebElement ele : elements("div_systemUnderGroups")) {
                if (elements("div_systemUnderGroups").get(i).getText().contains("system test")) {
                    ReportMsg.info("For 'System Test' system NO TESTING NEEDS TO BE DONE");
                    break;
                } else {
                    String text = elements("div_lastUpdatedTimeUnderGroups").get(i).getText();
                    ReportMsg.info("Time on application: " + text);
                    String a[] = text.split(":");
                    String a1[] = a[2].split(" ");

                    Date date = new Date();
                    String strDateFormat = "HH:mm a";
                    DateFormat sdf = new SimpleDateFormat(strDateFormat);
                    String systemTime = sdf.format(date);
                    ReportMsg.info("System Time: " + systemTime);
                    String b[] = systemTime.split(":");
                    String b1[] = b[1].split(" ");

                    int time = Integer.parseInt(a1[0]) - Integer.parseInt(b1[0]);
                    if (time < 5) {
                        ReportMsg.info("Verified Last updated time is not be more than 5 minutes from the system time for app on platfrom screen");
                        value = true;
                    } else {
                        ReportMsg.info("Last update time is be more than 5 minutes from the system time");
                        value = false;
                    }
                    ReportMsg.info("Verified last updated time on platform availability page");
                }
            }
            i++;
        } else if (systemView.equalsIgnoreCase("Front")) {
            for (WebElement ele : elements("div_app_systemApp")) {
                if (elements("div_app_systemApp").get(i).getText().contains("system test")) {
                    ReportMsg.info("System Test App is displaying ,not testing this app");
                    break;
                } else {
                    String text = elements("div_lastUpdatedTime").get(i).getText();
                    ReportMsg.info("Time on application: " + text);
                    String a[] = text.split(":");
                    String a1[] = a[2].split(" ");

                    Date date = new Date();
                    String strDateFormat = "HH:mm a";
                    DateFormat sdf = new SimpleDateFormat(strDateFormat);
                    String systemTime = sdf.format(date);
                    ReportMsg.info("System Time: " + systemTime);
                    String b[] = systemTime.split(":");
                    String b1[] = b[1].split(" ");

                    int time = Integer.parseInt(a1[0]) - Integer.parseInt(b1[0]);
                    if (time < 5) {
                        ReportMsg.info("Verified Last updated time is not be more than 5 minutes from the system time for app on platfrom screen");
                        value = true;
                    } else {
                        ReportMsg.info("Last update time is be more than 5 minutes from the system time");
                        value = false;
                    }
                    ReportMsg.info("Verified last updated time on platform availability page");
                }
            }
            i++;
        }
    }

    public void verifyNeedProductSupportLinkDisplaying() {
        isElementDisplayed("lnk_productSupportLink");
    }

    public void onceClickedOnLinkNewTabShouldBeOpenAndNavigateToURL(String url) {
        waitForElementToDisappear("lnk_productSupportLink");
        element("lnk_productSupportLink").click();
        ReportMsg.info("Clicked on 'Product Support Link'");

        String a = element("lnk_productSupportLink").getAttribute("href");
        ReportMsg.info("Product Support link: " + a);
    }

    public void verifyingAppOnPlatformScreen(String systemName, String systemView) {
        if (systemView.equalsIgnoreCase("Grouping")) {
            for (WebElement grp : elements("list_groupHeading")) {
                ReportMsg.info("Expanded state of '" + grp.getText() + "': " + grp.getAttribute("aria-expanded"));
                if (grp.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
                    grp.click();
                    ReportMsg.info("Clicked on '" + grp.getText().trim() + "' group");
                }
                for (WebElement panel : elements("list_panelCollapse")) {
                    ReportMsg.info("System under " + grp.getText() + " group: '" + panel.getText() + "'");
                }
            }
        } else if (systemView.equalsIgnoreCase("Front")) {
            int i = 0;
            String a[] = systemName.split(",");
            ReportMsg.info("Number of apps are displaying on Platform Screen: " + elements("url_systemLogo").size());
            for (WebElement e : elements("url_systemLogo")) {
                try {
                    String app[] = a[i].split("=");
                    String b[] = e.getAttribute("style").split(": ");
                    if (e.getText().contains("")) {
                        if (b[1].contains(app[1]) || b[1].contains(app[1].substring(0, 48))) {
                            ReportMsg.info("App name = " + app[0] + " is displaying with " + b[1]);
                            i++;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e1) {
                    ReportMsg.info("All apps are verified ");
                    break;
                }
            }
        }
    }

    public String verifyViewModeOnSplashPage() {
        String viewMode;
        try {
            isElementDisplayed("list_panelGroups");
            ReportMsg.info("All Systems are appearing under GROUPS!!!");
            viewMode = "Grouping";

            ReportMsg.info("No. of groups on Splash Page: " + elements("list_panelGroups").size());
            for (WebElement grp : elements("list_groupHeading")) {
                ReportMsg.info("Group Name: '" + grp.getText().trim() + "'");
            }
            return viewMode;
        } catch (NoSuchElementException ex) {
            isElementDisplayed("list_frontGroups");
            viewMode = "Front";
            ReportMsg.info("All Systems are appearing on FRONT i.e., NO GROUPING!!!");
            return viewMode;
        }
    }

    public void clickOnSystem(String systemName, String systemView) {
        int count = 0;
        if (systemView.equalsIgnoreCase("Grouping")) {
            for (WebElement grp : elements("list_groupHeading")) {
                try {
                    element("div_systemLogo", systemName).click();
                    ReportMsg.info("Clicked on '" + systemName + "' System");
                    break;
                } catch (TimeoutException ex) {
                    ReportMsg.info("Expanded state of '" + grp.getText() + "': " + grp.getAttribute("aria-expanded"));
                    if (grp.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
                        grp.click();
                        ReportMsg.info("Clicked on '" + grp.getText().trim() + "' group");
                    }
                }
                count++;
                if (elements("list_groupHeading").size() == count) {
                    element("div_systemLogo", systemName).click();
                    ReportMsg.info("Clicked on system having backgound URL '" + systemName + "'");
                }
            }
        } else if (systemView.equalsIgnoreCase("Front")) {
            element("div_systemLogo", systemName).click();
            ReportMsg.info("Click on App = " + systemName);

            systemName = element("txt_systemName").getText();
            String a[] = systemName.split("> ");
            systemName = a[1];
            ReportMsg.info("System: " + systemName);
        }
    }

    public void checkWhetherInformationIconIsAvailableOnSpalshPage(String systemName, String systemView) {
        int count = 0;
        if (systemView.equalsIgnoreCase("Grouping")) {
            for (WebElement grp : elements("list_groupHeading")) {
                try {
//                    element("div_systemLogo", systemName).click();
//                    ReportMsg.info("Clicked on '" + systemName + "' System");
                    checkInfomationIconAvailbilityOnSplashPage(systemName);
                    break;
                } catch (TimeoutException ex) {
                    ReportMsg.info("Expanded state of '" + grp.getText() + "': " + grp.getAttribute("aria-expanded"));
                    if (grp.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
                        grp.click();
                        ReportMsg.info("Clicked on '" + grp.getText().trim() + "' group");
                    }
                }
                count++;
                if (elements("list_groupHeading").size() == count) {
                    element("div_systemLogo", systemName).click();
                    ReportMsg.info("Clicked on system having backgound URL '" + systemName + "'");
                }
            }
        } else if (systemView.equalsIgnoreCase("Front")) {

            try {

                isElementDisplayed("div_msgInfo", systemName);
                ReportMsg.info("Information message icon is avaialbe on monitor ");

            } catch (NoSuchElementException e) {
                ReportMsg.info("Information message icon is not avaialbe on monitor ");
                checkInfomationIconAvailbilityOnSplashPage(systemName);
                logOutFromAdmin();

            }
        }
    }

    public void logOutFromAdmin() {
        isElementDisplayed("button_Admin");
        element("button_Admin").click();
        ReportMsg.info("Click on admin button");
        isElementDisplayed("logout_adminPage");
        element("logout_adminPage").click();
        element("link_ok").click();
        ReportMsg.info("Log out from admin account");
    }

    public void userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome() {
        wait.waitForElementToBeVisible(element("link_platfromAvailabilityHome"));
        isElementDisplayed("link_platfromAvailabilityHome");
        element("link_platfromAvailabilityHome").click();
        ReportMsg.info("User navigated to Splash Page on PlatformAvailability Page");
    }

    public void logAsAdmin() {
        isElementDisplayed("link_login");
        element("link_login").click();
        element("userName").clear();
        element("userName").click();
        element("userName").sendKeys("qaadmin");
        element("password").clear();
        element("password").click();
        element("password").sendKeys("Cengage1");
        element("button_login").click();
        ReportMsg.info("Login into admin account");
    }

    public void checkWhetherInformationIconIsAvailableOnSpalshPageForTBD(String systemName, String systemView) {
        int count = 0;
        if (systemView.equalsIgnoreCase("Grouping")) {
            for (WebElement grp : elements("list_groupHeading")) {
                try {
//                    element("div_systemLogo", systemName).click();
//                    ReportMsg.info("Clicked on '" + systemName + "' System");
                    checkInfomationIconAvialbilityForTBD(systemName);

                    break;
                } catch (TimeoutException ex) {
                    ReportMsg.info("Expanded state of '" + grp.getText() + "': " + grp.getAttribute("aria-expanded"));
                    if (grp.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
                        grp.click();
                        ReportMsg.info("Clicked on '" + grp.getText().trim() + "' group");
                    }
                }
                count++;
                if (elements("list_groupHeading").size() == count) {
                    element("div_systemLogo", systemName).click();
                    ReportMsg.info("Clicked on system having backgound URL '" + systemName + "'");
                }
            }
        } else if (systemView.equalsIgnoreCase("Front")) {
            try {
                isElementDisplayed("div_msgInfo", systemName);
                ReportMsg.info("Information message icon is avaialbe on monitor ");
            } catch (NoSuchElementException e) {
                checkInfomationIconAvialbilityForTBD(systemName);
            }
        }
    }

    private void checkInfomationIconAvialbilityForTBD(String systemName) {
        String systemUrl = systemName;
        element("div_systemLogo", systemName).click();
        systemName = element("txt_systemName").getText();
        String a[] = systemName.split("> ");
        systemName = a[1];
        ReportMsg.info("System: " + systemName);
        logAsAdmin();
        isElementDisplayed("button_createNotification");
        element("button_createNotification").click();
        ReportMsg.info("Click on create new notification button");
        isElementDisplayed("div_selectMonitor");
        element("div_selectMonitor").click();
        isElementDisplayed("div_monitorName", systemName);
        element("div_monitorName", systemName).click();
        element("div_commentBox").click();

        element("div_startTimeBox").click();
        element("btn_prvMonth").click();
        ReportMsg.info("Set start date to privous month ");
        element("btn_ok").click();

        element("div_startSecondTimeBox").click();
        element("btn_prvMonth").click();
        ReportMsg.info("Set start date to privous month ");

        element("btn_ok").click();
        isElementDisplayed("checkBox_NoEndDate");
        element("checkBox_NoEndDate").click();
        ReportMsg.info("clicked on No end date check box");

        String message = "test of informational icon availability";
        element("div_commentBox").clear();
        element("div_commentBox").sendKeys(message);
        ReportMsg.info("write s" + message + " in comment box ");

        if (element("div_enableCheckBox").getAttribute("value").contains("on")) {
            element("div_enableCheckBox").click();
        }
        ReportMsg.info("Checked notification is not be enabled");
        element("btn_save").click();
        ReportMsg.info("clicked on save button");

        element("input_searchBox").clear();
        element("input_searchBox").sendKeys("TBD");
        isElementDisplayed("td_textTBD");

        ReportMsg.info("Verified TBD is displaying after perform search operation on list notification");

        isElementDisplayed("span_deleteMonitors", systemName);
        element("span_deleteMonitors", systemName).click();
        element("button_delete").click();
        ReportMsg.info("Deleted notifications created by automation Script");

    }

    private void checkInfomationIconAvailbilityOnSplashPage(String systemName) {
        String systemUrl = systemName;
        element("div_systemLogo", systemName).click();

        systemName = element("txt_systemName").getText();
        String a[] = systemName.split("> ");
        systemName = a[1];
        ReportMsg.info("System: " + systemName);
        logAsAdmin();
        isElementDisplayed("button_createNotification");
        element("button_createNotification").click();
        ReportMsg.info("Click on create new notification button");
        isElementDisplayed("div_selectMonitor");
        element("div_selectMonitor").click();
        isElementDisplayed("div_monitorName", systemName);
        element("div_monitorName", systemName).click();
        element("div_commentBox").click();

        element("div_endTimeBox").click();
        element("div_selectTimeMode").click();
        element("btn_close").click();
        element("div_selectTimeMode").click();
        int x = element("div_mintueSlider").getLocation().getX();
        int y = element("div_mintueSlider").getLocation().getY();
        x = x + 1;
        new Actions(driver).dragAndDropBy(element("div_mintueSlider"), x, 0).build().perform();
        ReportMsg.info("Draged minute handle in right side");
        element("btn_ok").click();

        element("div_endTimeSecondBox").click();
        element("div_selectTimeMode").click();
        element("btn_close").click();
        element("div_selectTimeMode").click();
        int x1 = element("div_mintueSlider").getLocation().getX();
        int y1 = element("div_mintueSlider").getLocation().getY();
        x = x + 1;
        //ReportMsg.info(" now x " + x + " y " + y);
        new Actions(driver).dragAndDropBy(element("div_mintueSlider"), x1, 0).build().perform();
        ReportMsg.info("Draged minute handle in right side ");
        element("btn_ok").click();

        String message = "test of informational icon availability";
        element("div_commentBox").clear();
        element("div_commentBox").sendKeys(message);
        ReportMsg.info("write " + message + " in comment box ");
        element("btn_save").click();
        ReportMsg.info("clicked on save button");
        userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        waitTOSync();
//        wait.waitForElementToBeVisible(element("div_msgInfo", systemUrl));
        userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
        isElementDisplayed("div_msgInfo", systemUrl);
        ReportMsg.info("checked informational message on monitor as icon is displaying on spalsh page for " + systemName + " monitor");
        element("div_systemLogo", systemUrl).click();
        ReportMsg.info("Navigated to detail Screen of " + systemName + "monitor");
        executeJavascript("document.getElementsByClassName('info-alerts')[0].click()");
        ReportMsg.info("Clicked on current information alerts button");
        isElementDisplayed("td_msgDislpyaing", message);
        ReportMsg.info("checked on information message available on details screen");
//        element("btn_close").click();
        executeJavascript("document.getElementsByClassName('btn btn-default')[0].click()");
        ReportMsg.info("clicked on close button");
        element("link_adminButton").click();
        element("link_adminPage").click();

        element("input_searchBox").clear();
        element("input_searchBox").sendKeys(message);
        isElementDisplayed("span_deleteMonitors", systemName);
        element("span_deleteMonitors", systemName).click();
        element("button_delete").click();
        ReportMsg.info("Deleted notifications created by automation Script");

        userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();

    }

}
