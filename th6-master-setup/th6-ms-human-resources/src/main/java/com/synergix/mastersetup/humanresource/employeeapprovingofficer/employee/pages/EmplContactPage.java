package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplContactPage extends TH6PageObject {

	public EmplContactPage(WebDriver driver) {
		super(driver);
	}

	public void company_email(String company_email) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Company Email", 1), company_email);
	}

	public void personal_email(String personal_email) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Personal Email", 1), personal_email);
	}

	public void other_email(String other_email) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Other Email", 1), other_email);
	}

	public void office_phone_no(String office_phone_no) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Office Phone No.",1), office_phone_no);
	}

	public void extension_no(String extension_no) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Extension No.", 1), extension_no);
	}

	public void home_phone_no(String home_phone_no) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Home Phone No.", 1), home_phone_no);
	}

	public void mobile_phone_no(String mobile_phone_no) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Mobile Phone No.", 1), mobile_phone_no);
	}

	public void secondary_mobile_phone_no(String secondary_mobile_phone_no) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Secondary Mobile Phone No.", 1), secondary_mobile_phone_no);
	}

	public void other_phone_no(String other_phone_no) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Other Phone No.", 1), other_phone_no);
	}

}
