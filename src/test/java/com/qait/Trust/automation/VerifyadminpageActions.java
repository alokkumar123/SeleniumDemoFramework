package com.qait.Trust.automation;

import org.openqa.selenium.WebDriver;

import com.qait.Trust.automation.getpageobjects.GetPage;
import com.qait.Trust.automation.utils.ReportMsg;

public class VerifyadminpageActions extends GetPage {
	
	public VerifyadminpageActions(WebDriver driver){
		super(driver,"");
		this.driver = driver;
	
	}

	public void logAsAdmin() {
	
	        isElementDisplayed("link_login");
	        element("link_login").click();
	        element("userName").clear();
	        element("userName").click();
	        element("userName").sendKeys("Admin");
	        element("password").clear();
	        element("password").click();
	        element("password").sendKeys("Cengage1");
	        element("button_login").click();
	        ReportMsg.info("Login into admin account");
	    }
	
	}


