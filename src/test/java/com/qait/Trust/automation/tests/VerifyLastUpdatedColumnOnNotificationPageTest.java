package com.qait.Trust.automation.tests;

import org.testng.annotations.Test;

import com.qait.Trust.automation.TestFundamentals;

public class VerifyLastUpdatedColumnOnNotificationPage  extends TestFundamentals {
	
	@Test
	public void Step01_Trust_1064_verifylastupdatedcolumn(){
		test.createAndConfigPage.logAsAdmin("qaadmin", "Cengage1");
		test.createAndConfigPage.navigateToAdminMenu("List service notifications");
		test.createNotificationPage.Lastupdated();
	}
}
