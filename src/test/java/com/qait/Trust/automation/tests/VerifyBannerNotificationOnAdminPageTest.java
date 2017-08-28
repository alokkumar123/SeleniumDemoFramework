package com.qait.Trust.automation.tests;

import org.testng.annotations.Test;

import com.qait.Trust.automation.TestFundamentals;

public class VerifyBannerNotificationOnAdminPageTest extends TestFundamentals {

	@Test
	public void Step01_Trust_1067_verifyBannerNotification(){
		test.createAndConfigPage.logAsAdmin("qaadmin", "Cengage1");
		test.createAndConfigPage.navigateToAdminMenu("Banner notifications");
		test.createNotificationPage.BannerNotifcation();
	}
}
