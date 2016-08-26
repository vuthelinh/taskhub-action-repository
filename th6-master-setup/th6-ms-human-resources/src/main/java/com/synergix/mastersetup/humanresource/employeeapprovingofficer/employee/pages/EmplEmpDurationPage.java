package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplEmpDurationPage extends TH6PageObject {

	private String xpathTableDetails = "//div[contains(@id,'accordionPanel:employmentInfoDurationTab:j_id')]//div[@class='ui-datatable-tablewrapper']/table/tbody/tr/";
	
	public EmplEmpDurationPage(WebDriver driver) {
		super(driver);
	}

	public void type(String type) {
		select_option_by_text(1, type);
	}

	public void join_date(String join_date) {
		input_calendar(2, join_date);
	}

	public void contract_start_date(String contract_start_date) {
		input_calendar(3, contract_start_date);
	}

	public void confirmation_date(String confirmation_date) {
		input_calendar(4, confirmation_date);
	}

	public void contract_end_date(String contract_end_date) {
		input_calendar(5, contract_end_date);
	}

	public void cessation_date(String cessation_date) {
		input_calendar(6, cessation_date);
	}

	public void reason_for_cessation(String reason_for_cessation) {
		select_option_by_text(7, reason_for_cessation);
	}

	public void sabbatical_leave_end_date(String sabbatical_leave_end_date) {
		input_calendar(8, sabbatical_leave_end_date);
	}

	public void include_in_year_of_service(String include_in_year_of_service) {
		check_element(9, include_in_year_of_service);
	}

	public void company_code(String company_code) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails + "td[10]/span/span/input[1])[last()]",company_code);
		waitForAllJSCompletes();
	}

	public String company_name() {
		return $("("+xpathTableDetails+"td[11]/span)[last()]").getText(); 
	}

	public void employer_cpf_submission_no(String employer_cpf_submission_no) {
		select_option_by_text(12, employer_cpf_submission_no);
	}

	public void employment_status(String employment_status) {
		select_option_by_text(13, employment_status);
	}

	public void del(String del) {
		check_element(14, del);
	}

	public void addEmployDuration() {
		$("//div[@class='ui-datatable-header ui-widget-header ui-corner-top']//span[contains(@id,'accordionPanel:employmentInfoDurationTab:j_id')]/button").click();
		waitForAllJSCompletes();
	}
	

	public void select_option_by_text(int colsIndex, String optionLabel) {
		$("("+xpathTableDetails + "td["+colsIndex+"]//label)[last()]").waitUntilClickable().click();
		$("(//div[@class='ui-selectonemenu-items-wrapper']/ul/li[text()='"+optionLabel+"'])[last()]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void check_element(int colsIndex, String option) {
		if (option.equalsIgnoreCase("Yes"))
			$("("+xpathTableDetails+"td["+colsIndex+"]/span/div/div[2])[last()]").waitUntilClickable().click();
			waitForAllJSCompletes();
	}
	
	public void input_field_text(int colsIndex, String value) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails + "td["+colsIndex+"]/span/input)[last()]",value);
		waitForAllJSCompletes();
	}
	

	public void input_calendar(int colsIndex, String value) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails + "td["+colsIndex+"]/span/span/input)[last()]",value);
		waitForAllJSCompletes();
	}

}
