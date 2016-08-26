package com.synergix.mastersetup.humanresource.employeeapprovingofficer.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class TimesheetActivityPage extends TH6PageObject {

	public TimesheetActivityPage(WebDriver driver) {
		super(driver);
	}

	public void typeActivityCode(String activityCode) {
		enterInputFieldCodeWithLabel("Activity Code", activityCode);
	}

	public void typeActivityDescription(String activityDescription) {
		enterInputFieldWithLabel("Activity Description", activityDescription);
	}

	public void typeDetailDescription(String detailDescription) {
		enterTextAreaWithLabel("Detail Description", detailDescription);
	}

	public void chooseType(String type) {
		selectRadioButton("Type", type);
	}
}
