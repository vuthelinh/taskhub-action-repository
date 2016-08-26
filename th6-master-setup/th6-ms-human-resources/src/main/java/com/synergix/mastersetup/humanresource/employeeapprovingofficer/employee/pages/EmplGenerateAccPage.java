package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplGenerateAccPage extends TH6PageObject {

	public EmplGenerateAccPage(WebDriver driver) {
		super(driver);
	}

	public void current_password(String current_password) {
		enterInputFieldWithLabel("Current Password", current_password);
	}

	public void new_user_name(String new_user_name) {
		enterInputFieldWithLabel("New User Name", new_user_name);
	}

	public void new_password(String new_password) {
		enterInputFieldWithLabel("New Password", new_password);
	}

	public void confirm_new_password(String confirm_new_password) {
		enterInputFieldWithLabel("Confirm New Password", confirm_new_password);
	}

	public void clickSubmit() {
		$("//button/span[text()='Submit']").waitUntilClickable().click();
	}
}
