package com.qait.Trust.automation.keywords;

import com.qait.Trust.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import com.qait.Trust.automation.utils.ReportMsg;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebElement;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;

public class PlatformAvailabilityPageActions extends GetPage {

    WebDriver driver;

    public PlatformAvailabilityPageActions(WebDriver driver) {
        super(driver, "PlatformAvailability");
        this.driver = driver;
    }

    public void checkLastUpdateTimeOverPlatformAvailability() {
        try {
            isElementDisplayed("groupPattern");
            ReportMsg.info("Platform Availability screen is in form of group");
            isElementDisplayed("list_groupPanel");
            int i = 0;
            String groupName = null;
            for (WebElement ele : elements("list_groupPanel")) {
                groupName = elements("list_groupPanel").get(i).getText();

                element("apps_inGroups", groupName).click();
                ReportMsg.info("Group Name = " + groupName);
                elements("list_groupPanel").get(i).click();
                ReportMsg.info("Clicked on " + groupName + " group");

                int j = 0;
                isElementDisplayed("apps_inGroups", groupName);
                for (WebElement e : elements("apps_inGroups", groupName)) {
                    String appName = null;
                    ReportMsg.info("app size in group =" + elements("apps_inGroups", groupName).size());
                    elements("apps_inGroups", groupName).get(j).click();
                    isElementDisplayed("txt_appName");
                    appName = element("txt_appName").getText();
                    String a[] = appName.split("> ");
                    appName = a[1];
                    ReportMsg.info("AppName = " + appName);
                    ReportMsg.info("clicked on " + appName);
                    //verifyBreadcrumb(appName);
                    //userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
                    elements("list_groupPanel").get(i).click();
                    ReportMsg.info("Clicked on " + groupName + " group");
                    j++;

                }
                ReportMsg.info("covered all app of = " + groupName + "group");
                i++;
            }
        } catch (Exception e) {
            int i = 0;
            Boolean value;
            String appName = null;
            for (WebElement ele : elements("div_app_systemApp")) {

                if (elements("div_app_systemApp").get(i).getText().contains("system test")) {
                    break;
                } else {
                    //elements("div_lastUpdatedTime").size();

                    String text = elements("div_lastUpdatedTime").get(i).getText();
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
                        ReportMsg.info("Verified Last updated time is not be more than 5 minutes from the system time for app on platfrom screen");

                        value = true;
                    } else {
                        ReportMsg.info("Last update time is be more than 5 minutes from the system time");
                        value = false;
                    }
                    ReportMsg.info("Verified last updated time on platform availability page");
                }

//                isElementDisplayed("txt_appName");
//                appName = element("txt_appName").getText();
//                String a[] = appName.split("> ");
//                appName = a[1];
//                ReportMsg.info("AppName = " + appName);
//            }
                i++;
            }
        }

//        Boolean value;
//        for (WebElement wb : elements("list_backgroundImageHeader")) {
//
//            String appName = wb.getText();
//
//            isElementDisplayed("div_lastUpdatedTime", appName);
//            String text = element("div_lastUpdatedTime", appName).getText();
//            ReportMsg.info("Time on application = " + text);
//            String a[] = text.split(":");
//            String a1[] = a[2].split(" ");
//
//            Date date = new Date();
//            String strDateFormat = "HH:mm a";
//            DateFormat sdf = new SimpleDateFormat(strDateFormat);
//            String systemTime = sdf.format(date);
//            ReportMsg.info("System time=" + systemTime);
//            String b[] = systemTime.split(":");
//            String b1[] = b[1].split(" ");
//            int time = Integer.parseInt(a1[0]) - Integer.parseInt(b1[0]);
//
//            if (time < 5) {
//                ReportMsg.info("Verified Last updated time is not be more than 5 minutes from the system time for " + appName + "app");
//
//                value = true;
//            } else {
//                ReportMsg.info("Last update time is be more than 5 minutes from the system time");
//                value = false;
//            }
//            ReportMsg.info("Verified last updated time on platform availability page");
//        }    
    }

//public void verifyListofAppDisplaying() {
//        String appName = null;
//        for (WebElement ele : elements("div_app_systemApp")) {
//            // appName=ele.getText();
//            ReportMsg.info("hello");
//        }
//        String appName = null;
//        List<WebElement> a = elements("list_backgroundImageHeader");
//
//        for (WebElement el : a) {
//            appName = el.getText();
//            ReportMsg.info("Platform name:- " + appName);
//            isElementDisplayed("div_platformName", appName);
//            waitTOSync();
//        }
//}
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

    public void verifyingAppOnPlatfromScreen(String appName) {
//        ReportMsg.info("appname:= " + appName);
        int i = 0;
        String a[] = appName.split(",");
        ReportMsg.info("Number of apps are displaying on platform screen " + elements("url_systemLogo").size());
        for (WebElement e : elements("url_systemLogo")) {

            //ReportMsg.info(" attribute " + e.getAttribute("style"));
            String app[] = a[i].split("=");
            //ReportMsg.info("app name = " + app[1]);
            if (e.getAttribute("style").contains(app[1])) {
                //  ReportMsg.info(" i = " + i);
                ReportMsg.info("App name =" + app[0] + " is displaying with " + app[1]);
            }
                    i++;
                }

        }

    }

//    private ArrayList getAppFromYmal() {
//        String cengageBrain = getData("appName.cengageBrain");
//        String mindtap = getData("appName.mindtap");
//        String aplia = getData("appName.aplia");
//        String cengageNow = getData("appName.cengageNow");
//        String cengageNOWv2 = getData("appName.cengageNOWv2");
//        String OWLv2 = getData("appName.OWLv2");
//        String SAM = getData("appName.SAM");
//        String a4LTR = getData("appName.4LTR");
//        String mindtapMathFoundation = getData("appName.mindtapMathFoundation");
//
//        ArrayList<String> list = new ArrayList<String>();
//
//        {
//            {
//                list.add(mindtap);
//                list.add(cengageBrain);
//                list.add(aplia);
//                list.add(cengageNow);
//                list.add(cengageNOWv2);
//                list.add(OWLv2);
//                list.add(SAM);
//                list.add(a4LTR);
//                list.add(mindtapMathFoundation);
//            }
//        }
//        return list;
//    }


