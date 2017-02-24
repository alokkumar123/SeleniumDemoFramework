/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class RegionOnSplashPageTest extends TestFundamentals {

    String appName = null;
    String region = "Africa";

    @Test
    public void TC01_Set_System_Region_To_All_From_Admin_Page() {
        appName = test.detailScreen_group.getMonitorNameFromSpashPage(getData("appName.aplia"));
        test.createAndConfigPage.logAsAdmin();
        test.createAndConfigPage.breadcrumbShouldBeAvailableForNavigation("Admin");
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.regionSplashPage.setSystemToAllRegion(appName);
        test.regionSplashPage.clickOnButton("Save");
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC02_Set_verify_App_Is_Displaying_On_Spash_Page() {
        System.out.println("spp =" + appName);
        test.regionSplashPage.verifyAppIsDisplayingOnPage(getData("appName."+ appName.toLowerCase()));
        test.regionSplashPage.navigateToAdminPage();
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.regionSplashPage.setSystemToOtherRegion(appName, region);
        test.regionSplashPage.clickOnButton("Save");
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }

    @Test
    public void TC03_Verify_App_IS_Displaying_OR_Not_On_Spalsh_Page() {
        test.regionSplashPage.verifyAppIsDisplayingOnPage(getData("appName."+ appName.toLowerCase()));
        test.regionSplashPage.setRegionFromSplashPage(region);
        test.regionSplashPage.verifyAppIsDisplayingOnPage(getData("appName."+ appName.toLowerCase()));
        test.regionSplashPage.navigateToAdminPage();
        test.createAndConfigPage.navigateToAdminMenu("Manage systems");
        test.regionSplashPage.setSystemToOtherRegion(appName, "All");
        test.regionSplashPage.clickOnButton("Save");
        test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatfromAvailabilityHome();
    }
}
