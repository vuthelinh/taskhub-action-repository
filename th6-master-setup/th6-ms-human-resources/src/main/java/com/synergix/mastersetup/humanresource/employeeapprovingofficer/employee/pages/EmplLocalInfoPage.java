package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplLocalInfoPage extends TH6PageObject {

	public EmplLocalInfoPage(WebDriver driver) {
		super(driver);
	}

	public void payment_cycle(String payment_cycle) {
		inputValue("Payment Cycle", payment_cycle);
	}

	public void employee_payroll_category(String employee_payroll_category) {
		inputValue("Employee Payroll Category", employee_payroll_category);

	}

	public void salary_type(String salary_type) {
		inputValue("Salary Type", salary_type);
	}

	public void grade(String grade) {
		inputValue("Grade", grade);
	}

	public void related_to_timesheet(String value) {
		checkbox("Related To Timesheet", value);
	}

	private void checkbox(String labelText, String value) {
		$("//*[contains(text(),'" + labelText + "')]/following-sibling::div//label[contains(text(),'" + value
				+ "')]/preceding-sibling::input").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void monitor_employee(String monitor_employee) {
		checkbox("Monitor employee", monitor_employee);
	}

	public void working_group(String working_group) {
		inputValue("Working Group", working_group);
	}

	private void inputValue(String namePopup, String value) {
		click_on_button(namePopup);
		String[] data = value.split(",");
		fill_effective_date(namePopup, data[0]);
		search_by_input_directly(namePopup, data[1]);
		click_sumbit(namePopup);
		close_popup(namePopup);
	}

	private void click_on_button(String labelText) {
		$("//form[contains(@id,'localInfoHr')]//*[text()='" + labelText
				+ "']/following-sibling::div//button[contains(@id,'localInfoHr')]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	private void fill_effective_date(String namePopup, String value) {
		waitTypeAndEnterThenUpdateDate(
				"//*[text()='" + namePopup
						+ "']/parent::div/following-sibling::div//td[text()='Effective Date']/following-sibling::td//input",
				value);
		waitForAllJSCompletes();
	}

	private void search_by_input_directly(String namePopup, String value) {
		// open popUp
		$("//*[text()='" + namePopup + "']/parent::div/following-sibling::div//td[text()='" + namePopup
				+ "']/following-sibling::td//button").waitUntilClickable().click();
		waitForAllJSCompletes();
		// type
		$("//*[@id='searchParameterPanel']//*[text()='Employee Code']/parent::div/parent::td/following-sibling::td//input")
				.typeAndEnter(value);
		waitForAllJSCompletes();
		// click search
		$("//*[@id='searchParameterPanel']//*[text()='Employee Code']/parent::div/parent::td/following-sibling::td//button")
				.waitUntilClickable().click();
		waitForAllJSCompletes();
		// click on the result
		$("//*[@id='searchResultsForm:searchResultTable_data']//*[text()='" + value + "']").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
	}

	private void click_sumbit(String namePopup) {
		$("//*[text()='" + namePopup + "']/parent::div/following-sibling::div//td[2]/button").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
	}

	private void close_popup(String namePopup) {
		$("//span[text()='" + namePopup + "']/following-sibling::a[@aria-label='Close']").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

}
