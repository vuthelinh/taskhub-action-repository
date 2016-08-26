package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplEmploymentInfoDurationTabPage extends TH6PageObject {

	public EmplEmploymentInfoDurationTabPage(WebDriver driver) {
		super(driver);
	}


	// EMPLOYEE INFO & DURATION TAB
	public void typeDesignationEffectiveDate(String designationEffectiveDate) {
		String xDesignationEffectiveDate = "(//div[contains(@id, 'employmentInfoDurationTab')][contains(@style, 'display')]//td[preceding-sibling::td[text()='Effective Date']]//input)[1]";
		waitTypeAndEnterThenUpdateDate(xDesignationEffectiveDate, designationEffectiveDate);
	}

	public void typeDesignation(String designation) {
		String xDesignationTbx = "(//td[preceding-sibling::td[text()='Designation']]//input)[1]";
		waitTypeAndEnterThenUpdateValue(xDesignationTbx, designation);
	}

	public void clickOnDesignationIcon() {
		clickOnIconWithLabel("Designation");
	}

	public void clickOnSubmitDesignationBtn() {
		waitForAllJSCompletes();
		String xDesignationSubmitBtn = "//button[contains(@id, 'submitDesignation')]";
		$(xDesignationSubmitBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnCloseDesignationIcon() {
		clickOnCloseIcon("Designation Info");
	}

	public void clickOnAddDurationBtn() {
		String xAddDurationBtn = "(//div[contains(@id,'empDurationTbl')]//button[@aria-disabled='false'])[1]";
		$(xAddDurationBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowDurationTbl() {
		String xDurationTbl = "//tbody[contains(@id, 'empDurationTbl_data')]/tr";
		return findAll(xDurationTbl).size();
	}

	public void typeJoinDate(String joinDate, int rowIndex) {
		String xJoinDateCell = "//tbody[contains(@id, 'empDurationTbl_data')]/tr[" + rowIndex + "]/td[2]//input";
		waitTypeAndEnterThenUpdateDate(xJoinDateCell, joinDate);
	}

	public void typeCessationDate(String joinDate, int rowIndex) {
		String xJoinDateCell = "//tbody[contains(@id, 'empDurationTbl_data')]/tr[" + rowIndex + "]/td[6]//input";
		waitTypeAndEnterThenUpdateDate(xJoinDateCell, joinDate);
	}

	public void typeCompanyCode(String companyCode, int rowIndex) {
		String xCompanyCode = "(//tbody[contains(@id, 'empDurationTbl_data')]/tr[" + rowIndex + "]/td[10]//input)[1]";
		waitTypeAndEnterThenUpdateValue(xCompanyCode, companyCode);
	}


}
