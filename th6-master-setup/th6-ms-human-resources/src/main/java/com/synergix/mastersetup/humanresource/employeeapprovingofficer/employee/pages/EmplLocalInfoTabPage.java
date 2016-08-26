package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplLocalInfoTabPage extends TH6PageObject {

	public EmplLocalInfoTabPage(WebDriver driver) {
		super(driver);
	}

	// *************************************************************
	// *************************************************************
	// HR TAB
	public void chooseDesignatedWorkingDays(String workingDay, String option) {
		String xOpenOption = "//div[preceding-sibling::div[text()='" + workingDay + "']]//span";
		String xOption = "//div[contains(@id, 'localInfoHr')][contains(@style, 'display')]//li[text()='" + option
				+ "']";
		$(xOpenOption).click();
		$(xOption).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public boolean clickOnSalaryTypeIcon() {
		return clickOnIconWithLabel("Salary Type");
	}

	public void typeSalaryTypeEffectiveDate(String salaryTypeEffectiveDate) {
		String xSalaryTypeEffectiveDate = "(//div[contains(@id, 'localInfoHr')][contains(@style, 'display')]//td[preceding-sibling::td[text()='Effective Date']]//input)[1]";
		waitTypeAndEnterThenUpdateDate(xSalaryTypeEffectiveDate, salaryTypeEffectiveDate);
	}

	public void chooseSalaryType(String salaryType) {
		String xOpenIcon = "//td[preceding-sibling::td[text()='Salary Type']]//div[contains(@class, 'corner-right')]/span";
		String xOption = "//ul[contains(@id, 'localInfoHr')]/li[text()='" + salaryType + "']";
		$(xOpenIcon).waitUntilClickable().click();
		$(xOption).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnSubmitSalaryTypeBtn() {
		waitForAllJSCompletes();
		String xSubmitSalaryTypeBtn = "//button[contains(@id, 'submitSalaryType')]";
		$(xSubmitSalaryTypeBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseRelatedToTimesheet(String relatedToTimesheet) {
		String xOption = "//div[preceding-sibling::div[text()='Related To Timesheet']]/table//input[following-sibling::label[text()=' "
				+ relatedToTimesheet + "']]";
		if (!$(xOption).isSelected())
			selectRadioButton(xOption);
	}

	public void clickOnCloseSalaryTypeIcon() {
		clickOnCloseIcon("History - Salary Type");
	}

	public void typeTotalWorkingHoursPerDay(String totalWorkingHoursPerDay) {
		enterInputFieldWithLabelNoVerify("Total Working Hours Per Day", totalWorkingHoursPerDay);
	}

	public void typeTotalWorkingHoursPerWeek(String totalWorkingHoursPerWeek) {
		enterInputFieldWithLabelNoVerify("Total Working Hours Per Week", totalWorkingHoursPerWeek);
	}

	public void typeAMTimeFrom(String aMTimeFrom) {
		String xTextBox = "(//td[preceding-sibling::td[descendant-or-self::*[text()='Morning Session (AM)']]])[1]/input";
		waitTypeAndEnterThenUpdateValue(xTextBox, aMTimeFrom);
	}

	public void typeAMTimeTo(String aMTimeTo) {
		String xTextBox = "(//td[preceding-sibling::td[descendant-or-self::*[text()='Morning Session (AM)']]])[2]/input";
		waitTypeAndEnterThenUpdateValue(xTextBox, aMTimeTo);
	}

	public void typePMTimeFrom(String pMTimeFrom) {
		String xTextBox = "(//td[preceding-sibling::td[descendant-or-self::*[text()='Afternoon Session (PM)']]])[1]/input";
		waitTypeAndEnterThenUpdateValue(xTextBox, pMTimeFrom);
	}

	public void typePMTimeTo(String pMTimeTo) {
		String xTextBox = "(//td[preceding-sibling::td[descendant-or-self::*[text()='Afternoon Session (PM)']]])[2]/input";
		waitTypeAndEnterThenUpdateValue(xTextBox, pMTimeTo);
	}

	public void typePaymentCycle(String paymentCycle) {
		String xSearchIcon="//td[1]/div[preceding-sibling::div[text()='Payment Cycle']]//button[contains(@id, 'searchButton')]";
		String xSearchLb="//table[@id='searchParameterPanel']//td[@align='right'][preceding-sibling::td[descendant-or-self::*[text()='Payment Cycle Code']]]//input";
		clickOnElement(xSearchIcon);
		waitForAllJSCompletes();
		waitTypeAndEnter(xSearchLb, paymentCycle);
		String xPCC="//tbody[@id='searchResultsForm:searchResultTable_data']//a[child::span[text()='"+paymentCycle+"']]";
		if(isElementExist(xPCC)){
			clickOnElement(xPCC);
		}
		
//		waitTypeAndTab(xLabel, paymentCycle);
//		enterInputFieldCodeWithLabel("Payment Cycle", paymentCycle);
	}

	public boolean clickOnEPCIcon() {
		return clickOnIconWithLabel("Employee Payroll Category");
	}

	public void clickOnCloseEPC() {
		clickOnCloseIcon("History - Employee Payroll Category");
	}

	public void typeEPC(String ePC) {
		enterInputFieldCodeWithLabel("Employee Payroll Category", ePC);
	}

	public void typeEffectiveDateEPC(String effectiveDate) {
		String xEffecticeDate = "(//td[preceding-sibling::td[text()='Effective Date']]//input)[1]";
		waitTypeAndEnterThenUpdateDate(xEffecticeDate, effectiveDate);
	}

	public boolean clickOnGradeIcon() {
		return clickOnIconWithLabel("Grade");
	}

	public void clickOnCloseGrace() {
		clickOnCloseIcon("History - Employee Grade");
	}

	public void typeGrace(String grace) {
		enterInputFieldCodeWithLabel("Grace", grace);
	}

	public void typeEffectiveDateGrace(String effectiveDate) {
		String xEffecticeDate = "(//td[preceding-sibling::td[text()='Effective Date']]//input)[1]";
		waitTypeAndEnterThenUpdateDate(xEffecticeDate, effectiveDate);
	}

	// *************************************************************
	// *************************************************************
	// PAYROLL TAB

	// *************************************************************
	// *************************************************************
	// SBU TAB

}
