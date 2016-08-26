package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplTimesheetOfficerPage extends TH6PageObject {

	public EmplTimesheetOfficerPage(WebDriver driver) {
		super(driver);
	}

	public void primary_reporting_officer(String primary_reporting_officer) {
		inputValue("Primary Reporting Officer", primary_reporting_officer);
	}

	public void secondary_reporting_officer(String secondary_reporting_officer) {
		inputValue("Secondary Reporting Officer", secondary_reporting_officer);
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
		$("//form[contains(@id,'timesheetOfficerInchargeTab')]//*[text()='" + labelText
				+ "']/following-sibling::div/button[contains(@id,'timesheetOfficerInchargeTab')]")
						.waitUntilClickable().click();
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
