package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.LogWork;
import com.synergix.common.TH6PageObject;

public class EmplChildrenTabPage extends TH6PageObject {

	private String xpathTableDetails = "//div[contains(@id,'accordionPanel:childrenTab:childrenForm:childrenTable')]//div[@class='ui-datatable-tablewrapper']/table/tbody/tr/";
	
	public EmplChildrenTabPage(WebDriver driver) {
		super(driver);
	}
	
	public void employee_code(String employee_code) {
		enterInputFieldWithLabel("Employee Code", employee_code);
	}

	public void name(String name) {
		input_field_text(1, name);
	}

	public String age_as_at2015() {
		return $("("+xpathTableDetails + "td[4])[last()]").getText();
	}

	public void date_of_birth(String date_of_birth) {
		input_calendar(3, date_of_birth);
	}

	public void nationality(String nationality) {
		select_option_by_text(2, nationality);
	}

	public void select_option_by_text(int colsIndex, String optionLabel) {
		LogWork.log_debug("("+xpathTableDetails + "td["+colsIndex+"]/div/label)[last()]");
		$("("+xpathTableDetails + "td["+colsIndex+"]/div/label)[last()]").waitUntilClickable().click();
		
		LogWork.log_debug("(//div[@class='ui-selectonemenu-items-wrapper']/ul/li[text()='"+optionLabel+"'])[last()]");
		$("(//div[@class='ui-selectonemenu-items-wrapper']/ul/li[text()='"+optionLabel+"'])[last()]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}
	
	public void input_field_text(int colsIndex, String value) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails + "td["+colsIndex+"]/input)[last()]",value);
		waitForAllJSCompletes();
	}
	
	public void input_calendar(int colsIndex, String value) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails + "td["+colsIndex+"]/span/span/input)[last()]",value);
		waitForAllJSCompletes();
	}

	public void addChildren() {
		$("//button[contains(@id,'accordionPanel:childrenTab:childrenForm:childrenTable:j_id')]/span").click();
		waitForAllJSCompletes();
	}

}
