package com.qait.Trust.automation.tests;

import org.testng.annotations.Test;

import com.qait.Trust.automation.TestFundamentals;

public class VerifyNotificationFilterAtSystemLevelTest extends TestFundamentals{

	@Test
	public void Step01_Trust_1066_VerifySystemFilter(){
		test.createAndConfigPage.logAsAdmin("qaadmin", "Cengage1");
		test.createAndConfigPage.navigateToAdminMenu("List service notifications");
		test.createNotificationPage.verifysystemfilter();
		test.createNotificationPage.validatesystemfilter();
	}
}
