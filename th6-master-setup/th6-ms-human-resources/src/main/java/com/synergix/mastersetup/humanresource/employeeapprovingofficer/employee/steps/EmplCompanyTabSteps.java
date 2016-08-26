package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplCompanyTabPage;

public class EmplCompanyTabSteps extends ScenarioSteps {

	EmplCompanyTabPage onCompanyTabPage;

	public void moveToCompanyTab() {
		onCompanyTabPage.moveToTab("Company");
		onCompanyTabPage.waitForAllJSCompletes();
	}

	@Step
	public void chooseAllCompany() {
		onCompanyTabPage.chooseAllCompany();
	}

	@Step
	public void chooseCompany(String listCompanyName) {
		onCompanyTabPage.chooseCompany(listCompanyName);
	}
}
