package com.qait.Trust.automation.tests;

import org.testng.annotations.Test;

import com.qait.Trust.automation.TestFundamentals;

public class VerifyStickyFiltersOnNotificationPageTest extends TestFundamentals {
	
	@Test
	public void Step01_Trust_1047_VerifyStickyFilterafterrefresshing(){
		test.createAndConfigPage.logAsAdmin("qaadmin", "Cengage1");
		test.createAndConfigPage.navigateToAdminMenu("List service notifications");
		test.createNotificationPage.verifysystemfilter();
		test.createNotificationPage.refreshPage();
		test.createNotificationPage.verifystickyfilter();	
	}
	
	@Test
	public void Step02_Trust_1047_VerifyStickyFilterAfterNavigatingToOtherPages(){
		test.createAndConfigPage.navigateToAdminMenu("Manage groups");
		test.createAndConfigPage.navigateToAdminMenu("List service notifications");
		test.createNotificationPage.verifystickyfilter();
	}
}
