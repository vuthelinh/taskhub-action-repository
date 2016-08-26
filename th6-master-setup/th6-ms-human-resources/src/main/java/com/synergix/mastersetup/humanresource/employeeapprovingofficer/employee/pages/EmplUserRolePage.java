package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplUserRolePage extends TH6PageObject {

	public EmplUserRolePage(WebDriver driver) {
		super(driver);
	}

	
	public void check_allowed(String role) {
		String xFilter = "//*[text()='Employee System Role']/following::input[contains(@id,'accordionPanel:systemRoleTab:systemRoleForm:systemRoleTabe:j_id')]";
		$(xFilter).clear();
		$(xFilter).typeAndEnter(role);
		waitForAllJSCompletes();
		String xOption = "//td[@role='gridcell' and text()='" + role + "']/following-sibling::td/span/div/div[2]";
		if (isElementExist(xOption + "/span[contains(@class, 'blank')]")) { // Nancy
			$(xOption).click();
			waitForAllJSCompletes();
		}
	}

}
