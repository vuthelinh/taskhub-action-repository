package com.synergix.security.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class UserRoleAccessPage extends TH5PageObject {

	public UserRoleAccessPage(WebDriver driver) {
		super(driver);
	}

	private String xRoleAccessTb="//table[contains(@id, 'mtUserTable') and child::thead]";
	private String xDefaultTb = "//span[@id='defaultTab']//table[child::thead]";

	public void typeRoleCode(String roleCode) {
		String[] rRole = roleCode.split(">");
		int rowIndex = 0;

		switch_to_tab("Default");
		for (String role : rRole) {
			clickBtn("Add");
			rowIndex += 1;
			waitForAllJSCompletes();
			waitTypeAndEnter(
					xPathTbDataCellByPosition(xDefaultTb, rowIndex, 1)+"//input[@type='text']", role.trim());
			waitForAllJSCompletes();
		}
	}

	public boolean searchUserName(String userName) {
		String columnName="User Name";
		int colIndex=getTbColHeaderIndex(xRoleAccessTb, columnName);
		
		waitTypeAndEnter(xPathTbHeaderCell(xRoleAccessTb, columnName)+"//input", userName);
		
		String xFirstRowSelect = xRoleAccessTb + "/tbody/tr[child::td[" + colIndex
				+ " and descendant-or-self::*[text()='" + userName.toUpperCase()+ "']]]//a[@href]";
		
		if (findAll(xFirstRowSelect).size() > 0) {
			clickOnElement(xFirstRowSelect);
			waitForAllJSCompletes();
			return true;
		}
		return false;
	}
}
