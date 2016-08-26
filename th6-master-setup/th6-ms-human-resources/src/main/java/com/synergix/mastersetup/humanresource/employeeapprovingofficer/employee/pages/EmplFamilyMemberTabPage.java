package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplFamilyMemberTabPage extends TH6PageObject{

	private String xpathTableDetails = "//div[contains(@id,'accordionPanel:contactTab:j_id')]//div[@class='ui-datatable-tablewrapper']/table/tbody/tr/";
	
	public EmplFamilyMemberTabPage(WebDriver driver) {
		super(driver);
	}

	public void name(String name) {
		input_field_text(1, name);
	}

	public void relationship(String relationship) {
		select_option_by_text(2, relationship);
	}

	public void date_of_birth(String date_of_birth) {
		input_calendar(3, date_of_birth);
	}

	public void nationality(String nationality) {
		select_option_by_text(4, nationality);
	}

	public void race(String race) {
		select_option_by_text(5, race);
	}

	public void identification_no(String identification_no) {
		input_field_text(6, identification_no);
	}

	public void home_phone_no(String home_phone_no) {
		input_field_text(7, home_phone_no);
	}

	public void mobile_no(String mobile_no) {
		input_field_text(8, mobile_no);
	}

	public void next_of_kin(String next_of_kin) {
		check_element(9, next_of_kin);
	}

	public void co_worker(String co_worker) {
		check_element(10, co_worker);
	}

	public void dependent_pass(String dependent_pass) {
		check_element(11, dependent_pass);
	}

	public void application_date(String application_date) {
		input_calendar(12, application_date);
	}

	public void issue_date(String issue_date) {
		input_calendar(13, issue_date);
	}

	public void expiry_date(String expiry_date) {
		input_calendar(14, expiry_date);
	}

	public void card_return_date(String card_return_date) {
		input_calendar(15, card_return_date);
	}
	
	public void select_option_by_text(int colsIndex, String optionLabel) {
		$("("+xpathTableDetails + "td["+colsIndex+"]/div/label)[last()]").waitUntilClickable().click();
		$("(//div[@class='ui-selectonemenu-items-wrapper']/ul/li[text()='"+optionLabel+"'])[last()]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}
	
	public void check_element(int colsIndex, String option) {
		if (option.equalsIgnoreCase("Yes"))
			$("("+xpathTableDetails+"td["+colsIndex+"]/div/div[2])[last()]").waitUntilClickable().click();
			waitForAllJSCompletes();
	}
	
	public void input_field_text(int colsIndex, String value) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails + "td["+colsIndex+"]/input)[last()]",value);
		waitForAllJSCompletes();
	}
	
	public void input_calendar(int colsIndex, String value) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails + "td["+colsIndex+"]/span/input)[last()]",value);
		waitForAllJSCompletes();
	}

	public void add_family_member() {
		$("//button[contains(@id,'accordionPanel:contactTab:j_id')]/span").click();
		waitForAllJSCompletes();
	}

}
