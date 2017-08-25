package com.qait.Trust.automation.tests;

import org.testng.annotations.Test;

import com.qait.Trust.automation.TestFundamentals;

public class VerifyNoAdminPageAppearsForInternalAndGPTUserTest extends TestFundamentals  {

	@Test
	public void Step01_Trust_1024_Createdinternaluserlogin_Monitors(){
		test.createAndConfigPage.logAsAdmin("qaadmin", "Cengage1");
		test.createAndConfigPage.navigateToAdminMenu("Manage systems");
		test.manageSystemPage.userCheckCreateNewSystem();
		test.manageSystemPage.userCheckCreateNewSystemWithAccessLevel("Internal Access System","Internal","New monitor");   
	}
	
	@Test
	public void Step02_Trust_1024_CreatedInternaluserlogin_Monitors(){
		test.manageSystemPage.userCheckCreateNewSystem();
		test.manageSystemPage.userCheckCreateNewSystemWithAccessLevel("Admin Access System ","Admin","Test");
		test.createAndConfigPage.logOutFromAdmin();
	}
	
	@Test
	public void Step03_Trust_1024_Login_With_Internal_User() {
		test.createAndConfigPage.logAsAdmin("internalqa", "Cengage1");
		test.detailScreenPage.userNavigateToPlatfromAvailableScreenWhenClickOnPlatformAvailabilityHome();
		test.platformAvailabilityPage.verifyMonitorIsDisplayingOnSplashPageForPrivilegePurpose("internalSystem", "systemView");
		test.createNotificationPage.verifySytemUnderPrivileges("internalSystem", "internalPrivilege");
	}
}


