package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.ConfigPropertyReader.getProperty;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class RegionOnSplashPageTest extends TestFundamentals {

    String systemView;
    String appName = null;
    String region = "Asia";
    String anyOtherRegion = "Australia";

    String userName = getProperty("userName");
    String password = getProperty("password");

    @Test
    public void TC01_Verify_Region_Of_Selected_System() {
        appName = test.detailScreen_group.getMonitorNameFromSpashPage(getData("appNameforRegion.cengagebrain"));
        test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.regionSplashPage.clickOnSystemFromManageSystem(appName);
        test.regionSplashPage.verifySystemDefaltRegion(appName);
    }

    @Test
    public void TC02_Change_System_Region_To_Any_Value_For_Visibility_On_Splash_Page() {
        test.regionSplashPage.setSystemRegionFromAdminPage(appName, region);
        test.regionSplashPage.clickOnButton("Save");
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }

    @Test
    public void TC03_Verify_Region_Of_System_On_Splash_For_Above_Value() {
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.verifyingAppOnPlatformScreen(getData("appNameforRegion." + appName.toLowerCase()), systemView);
        test.regionSplashPage.setRegionFromSplashPage(region);
        test.regionSplashPage.verifyAppIsDisplayingOnPage(getData("appNameforRegion." + appName.toLowerCase()));
    }

    @Test
    public void TC04_Verify_Region_Of_System_On_Splash_For_Any_Other_Value() {
        test.regionSplashPage.setRegionFromSplashPage(anyOtherRegion);
        systemView = test.platformAvailabilityPage.verifyViewModeOnSplashPage();
        test.platformAvailabilityPage.verifyingAppOnPlatformScreen(getData("appNameforRegion." + appName.toLowerCase()), systemView);
    }

    @Test
    public void TC05_Change_Region_of_System_To_Default_Value() {
        test.regionSplashPage.navigateToAdminPage();
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.regionSplashPage.clickOnSystemFromManageSystem(appName);
        test.regionSplashPage.setSystemRegionFromAdminPage(appName, "All");
        test.regionSplashPage.clickOnButton("Save");
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
    }
}
