package com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.page.TimesheetActivityPage;

public class TimesheetActivitySteps extends ScenarioSteps {

	TimesheetActivityPage onTimesheetActivityPage;

	@Step
	public void typeActivityCode(String activityCode) {
		onTimesheetActivityPage.typeActivityCode(activityCode);
	}

	@Step
	public void typeActivityDescription(String activityDescription) {
		onTimesheetActivityPage.typeActivityDescription(activityDescription);
	}

	@Step
	public void typeDetailDescription(String detailDescription) {
		onTimesheetActivityPage.typeDetailDescription(detailDescription);
	}

	@Step
	public void chooseType(String type) {
		onTimesheetActivityPage.chooseType(type);
	}

	@Step
	public void chooseAllCompany() {
		onTimesheetActivityPage.chooseAllCompany();
	}

	@Step
	public void chooseCompany(String listCompanyName) {
		onTimesheetActivityPage.chooseCompany(listCompanyName);
	}

	@Step
	public void clickOnNewBtn() {
		onTimesheetActivityPage.clickBtn("New");
		onTimesheetActivityPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnUpdateBtn() {
		onTimesheetActivityPage.clickBtn("Update");
		onTimesheetActivityPage.waitForAllJSCompletes();
		onTimesheetActivityPage.chooseYesOnUpdateConfirmation();
	}

	@Step
	public void deleteTSActivity(String activityCode) {
		onTimesheetActivityPage.deleteValueByFilter("", "Activity Code",
				activityCode);
	}

	@Step
	public void moveToCompanyTab() {
		onTimesheetActivityPage.switch_to_tab("Company");
		onTimesheetActivityPage.waitForAllJSCompletes();
	}

}
