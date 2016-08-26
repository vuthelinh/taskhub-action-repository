package com.synergix.mastersetup.humanresource.employeeapprovingofficer.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;
import com.thoughtworks.selenium.webdriven.commands.GetXpathCount;

public class EmployeePage extends TH6PageObject {

	public EmployeePage(WebDriver driver) {
		super(driver);
	}

	public void typeEmployeeCode(String employeeCode) {
		enterInputFieldCodeWithLabel("Employee Code", employeeCode);
	}

	public void typeEmployeeName(String employeeName) {
		enterInputFieldWithLabel("Employee Name (NRIC/FIN/Bank account)", employeeName);
	}

	public void typeEmployeeShortName(String employeeShortName) {
		enterInputFieldWithLabel("Employee Short Name", employeeShortName);
	}

	// Have space in text
	public void changeUserIDStatus(String userIdStatus) {
		checkChkbox("//label[text()=' " + userIdStatus + "']/preceding-sibling::input");
	}

	public void backToSummary() {
		back_to_summary();
	}

	public void searchEmployeeByCode(String employee_code) {
		$("//label[text()='Filter by Employee Code']/following-sibling::input").typeAndTab(employee_code);
		waitForAllJSCompletes();
		$("//a[text()='" + employee_code + "']").waitUntilClickable().click();
		waitForAllJSCompletes();		
	}

	public void searchEmployeeByUserName(String userName) {
		filterDataByHeader(xPathTbHeaderCell("User Name", 1), userName);
		waitForAllJSCompletes();
		String xSearchResultRow = "//table[descendant::*[*='Employee Code']]/tbody//td[4][descendant-or-self::*[text()='"+userName+"']]/parent::tr";
		if (isElementExist(xSearchResultRow)) {
			xSearchResultRow += "/td[1]/*[@href]";
			$(xSearchResultRow).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}
	
	public boolean searchEmployeeByEmployeeCode(String employeeCode) {
		filterDataByHeader(xPathTbHeaderCell("Employee Code", 1), employeeCode);
		waitForAllJSCompletes();
		String xSearchResultRow = "//table[descendant::*[*='Employee Code']]/tbody//td[1][descendant-or-self::*[text()='"+employeeCode.toUpperCase()+"']]/*[@href]";
		if (isElementExist(xSearchResultRow)) {
			$(xSearchResultRow).waitUntilClickable().click();
			waitForAllJSCompletes();
			return true;
		}
		return false;
	}

	public String getPwd() {
		String userInfor = $("//span[text()='New Username/Password Info']/parent::span/following-sibling::p").waitUntilVisible().getText();
		String [] pwd = userInfor.split("Password: ");
		return pwd[1];
	}

	public void add_remarks(String sRemarks) {
		waitTypeAndTab("//textarea[contains(@id,'txtRemark')]", sRemarks);
		waitForAllJSCompletes();
	}
}
