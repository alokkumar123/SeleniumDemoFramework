package com.qait.Trust.automation.tests;

import com.qait.Trust.automation.TestFundamentals;
import static com.qait.Trust.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;

public class ManageUsersORUserAdministrationTest extends TestFundamentals {

	String userName = "harsh";

	@Test
	public void TC001_Check_User_Administration_Manage_Users() {
		test.createAndConfigPage.logAsAdmin(getData("admin.username"), getData("admin.password"));
		test.createAndConfigPage.navigateToAdminMenu("User Administration");
		test.createAndConfigPage.gridShouldBeAvailableFor("User ID");
		test.createAndConfigPage.gridShouldBeAvailableFor("User Name");
		test.createAndConfigPage.gridShouldBeAvailableFor("Email");
	}

	@Test
	public void TC002_Sorting_Of_Records() {
		//        test.createAndConfigPage.sortingOfRecordswith("User ID", "1");
		//        test.createAndConfigPage.sortingOfRecordswith("User Name", "2");
		//        test.createAndConfigPage.sortingOfRecordswith("Email", "3");
	}

	@Test
	public void TC003_Delete_Existing_User_If_Present() {
		test.manageRolePage.clickOnDeleteButton(userName);
		test.createAndConfigPage.popUpShouldBeAppears("Cancel");
		test.manageRolePage.clickOnDeleteButton(userName);
		test.createAndConfigPage.popUpShouldBeAppears("OK");
	}

	@Test
	public void TC004_Check_Search_Functionality_Positive_Cycle() {
		 test.createAndConfigPage.validateSearchFunctionalityForPossitiveCycle();
	}

	@Test
	public void TC005_Check_Search_Functionality_Negative_Cycle() {
		 test.createAndConfigPage.validateSearchFunctionalityForNegativeCycle();
	}

	@Test
	public void TC006_Check_Add_A_New_User() {
		test.createAndConfigPage.clickOnAddNewUser();
		test.createAndConfigPage.userNavigatedToNewUserScreen();
		test.createAndConfigPage.clickOnRoleSelector();
		test.createAndConfigPage.navigateToAdminMenu("Manage roles");
		test.createAndConfigPage.rolesDisplayingOnManageRoles();
		test.createAndConfigPage.navigateToAdminMenu("User Administration");
		test.createAndConfigPage.clickOnAddNewUser();
		test.createAndConfigPage.enterUserIdInUserForm("User ID");
		test.createAndConfigPage.enterEmailIdInUserForm("Email");
		test.createAndConfigPage.enterPasswordInUserForm("Password");
		test.createAndConfigPage.enterRepasswordInUserForm("Repeat Password");
		test.createAndConfigPage.clickOnSaveButtonByScript();
	}

	@Test
	public void TC007_Check_Newly_Created_User_Must_Be_Listed_On_The_Configured_Monitor_Screen() {
		test.createAndConfigPage.newCreatedUserIsDisplayingOnMonitorScreen();
	}

	@Test
	public void TC008_Edit_Newly_Created_User() {
		test.createAndConfigPage.EditNewlyCreatedUser("First Name");
		test.createAndConfigPage.clickOnSaveButtonByScript();
		test.createAndConfigPage.editedUserFirstNameIsDisplayingOnMonitorScreen();
	}
	

	//    @Test this functionality is changed now
	//    public void TC008_Check_History_Of_Edit_Information_For_User() {
	//        test.createAndConfigPage.expendOnChnageLog();
	//        test.createAndConfigPage.userNavigateToSameUserAndCheckLogBelowSaveButton();
	//        test.createAndConfigPage.clickOnSaveButtonByScript();
	//    }

	/*@Test
	public void TC009_Delete_User_Created_By_Automation_Script() {
		test.createAndConfigPage.clickOnDeleteButton();
		test.createAndConfigPage.popUpShouldBeAppears("Cancel");
		test.createAndConfigPage.editedUserFirstNameIsDisplayingOnMonitorScreen();
		test.createAndConfigPage.clickOnDeleteButton();
		test.createAndConfigPage.popUpShouldBeAppears("OK");

	}*/}
