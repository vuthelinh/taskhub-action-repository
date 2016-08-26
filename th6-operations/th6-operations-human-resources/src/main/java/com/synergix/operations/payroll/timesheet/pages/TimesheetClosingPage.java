package com.synergix.operations.payroll.timesheet.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class TimesheetClosingPage extends TH6PageObject {

	public TimesheetClosingPage(WebDriver driver) {
		super(driver);
	}

	private String xEmployeeUnderclockTb = "//div[@id='syn:timesheetClosing:tsClosingForm:timesheetClosing']";
	private String xEmployeesWithoutDesignationTb = "//div[@id='syn:timesheetClosing:tsClosingForm:empWoDesignHourRateTable']";

	private String xPopUp = "//div[@id='growl_container']";

	public void typeFrom(String from) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("From"), from);
	}

	public void typeTo(String to) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("To"), to);
	}

	public void typePostingDate(String postingDate) {
		waitTypeAndEnterThenUpdateDate(
				xPathInputFieldWithLabel("Posting Date"), postingDate);
	}

	public void typeEmployee(String employee) {
		enterInputFieldCodeWithLabel("Employee", employee);
	}

	public void chooseSendMailForEmployee(String employee) {
		String xRowEmployee = xEmployeeUnderclockTb
				+ "//tbody/tr[descendant-or-self::*[text()='" + employee
				+ "' and 2]]";
		if (isElementExist(xRowEmployee)) {
			xRowEmployee += "/td[6]//span";
			clickOnElement(xRowEmployee);
		}
	}

	public String clickOnSendMailBtnAndReturnMesg() {
		clickBtn("Send Email");
		waitForAllJSCompletes();
		String xMesg = xPopUp + "//span[@message-code]";
		String mesg = "";
		if (isElementExist(xMesg)) {
			mesg = $(xMesg).getText();
		}
		return mesg;
	}

	public String clickOnSubmitBtnAndReturnMesg() {
		clickBtn("Submit");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
		String xMesg = xPopUp + "//span[@message-code]";
		String mesg = "";
		if (isElementExist(xMesg)) {
			mesg = $(xMesg).getText();
		}
		return mesg;
	}
}
