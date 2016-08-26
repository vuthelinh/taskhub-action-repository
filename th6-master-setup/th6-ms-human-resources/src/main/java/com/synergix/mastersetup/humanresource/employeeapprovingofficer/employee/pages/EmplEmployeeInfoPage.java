package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplEmployeeInfoPage extends TH6PageObject {
	public EmplEmployeeInfoPage(WebDriver driver) {
		super(driver);
	}

	private void click_on_button(String labelText) {
		$("//div[contains(@id,'accordionPanel:employmentInfoDurationTab')]//div[text()='" + labelText
				+ "']/following-sibling::div/table//span/button[contains(@id,'accordionPanel:employmentInfoDurationTab')]")
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

	private void search_by_input_directly(String namePopup, String infoLable, String value) {
		// open popUp
		$("//*[text()='" + namePopup + "']/parent::div/following-sibling::div//td[text()='" + infoLable
				+ "']/following-sibling::td//button").waitUntilClickable().click();
		waitForAllJSCompletes();
		// type
		$("//*[@id='searchParameterPanel']//*[text()='" + infoLable
				+ " Code']/parent::div/parent::td/following-sibling::td//input").typeAndEnter(value);
		waitForAllJSCompletes();
		// click search
		$("//*[@id='searchParameterPanel']//*[text()='" + infoLable
				+ " Code']/parent::div/parent::td/following-sibling::td//button").waitUntilClickable().click();
		waitForAllJSCompletes();
		// click on the result
		$("//*[@id='searchResultsForm:searchResultTable_data']//*[text()='" + value + "']").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
	}

	private void search_by(String namePopup, String subInfo, String value) {
		$("//*[text()='" + namePopup + "']/parent::div/following-sibling::div//td[text()='" + subInfo
				+ "']/following-sibling::td//input").typeAndEnter(value);
		waitForAllJSCompletes();
		$("//span[@class='ui-autocomplete-query' and text()='" + value + "']").waitUntilVisible().click();
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

	private void sub_item(String namePopup, String labelItem, String value) {
		click_on_button(labelItem);

		String[] data = value.split(",");
		fill_effective_date(namePopup, data[0]);
		// search_by(namePopup, labelItem, data[1]);
		search_by_input_directly(namePopup, labelItem, data[1]);
		click_sumbit(namePopup);
		close_popup(namePopup);
	}

	public void sub_company(String subCompany) {
		sub_item("Sub Company Info", "Sub Company", subCompany);
	}

	public void regional_office(String regional_office) {
		sub_item("Regional Office Info", "Regional Office", regional_office);
	}

	public void employee_job_type(String employee_job_type) {
		sub_item("Employee Job Type", "Employee Job Type", employee_job_type);
	}

	public void designation(String designation) {
		sub_item("Designation Info", "Designation", designation);
	}

	public void designation_group(String designation_group) {
		sub_item("Designation Group Info", "Designation Group", designation_group);

	}

	public void designation_category(String designation_category) {
		select_option_by_text("Designation Category", designation_category);
	}

	private void select_option_by_text(String optionLabel, String valueText) {
		$("//div[contains(@id,'accordionPanel:employmentInfoDurationTab')]//div[text()='" + optionLabel
				+ "']/following-sibling::div//label[text()='Please Select']").waitUntilClickable().click();
		$("(//div[@class='ui-selectonemenu-items-wrapper']/ul/li[text()='" + valueText + "'])[last()]")
				.waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void working_location(String working_location) {
		select_option_by_text("Working Location", working_location);
	}

	public void designated_country(String designated_country) {
		select_option_by_text("Designated Country", designated_country);
	}

}
