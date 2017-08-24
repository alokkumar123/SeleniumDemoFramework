package com.qait.Trust.automation.tests;

import org.testng.annotations.Test;

import com.qait.Trust.automation.TestFundamentals;

public class PaginationNotificationPage extends TestFundamentals {

	@Test
	public void Step01_TRUST1068_verifyNotificationPageFromTop() {
		test.createAndConfigPage.logAsAdmin("qaadmin", "Cengage1");
		test.createAndConfigPage.navigateToAdminMenu("List service notifications");
		test.createNotificationPage.verifyNotifcationPageListTop("1");
		test.createNotificationPage.verifyNotifcationPageListTop("2");
		test.createNotificationPage.verifyNotifcationPageListTop("3");
	}

	@Test
	public void Step02_TRUST1068_verifyNotificationPageFromBottom() {
		test.createNotificationPage.verifyNotifcationPageListBottom("1");
		test.createNotificationPage.verifyNotifcationPageListBottom("2");
		test.createNotificationPage.verifyNotifcationPageListBottom("3");
	}
}