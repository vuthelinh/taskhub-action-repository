package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplGenerateAccPage;

public class EmplGenerateAccSteps extends ScenarioSteps {

	EmplGenerateAccPage onGenerateAccPage;

	@Step
	public void current_password(String current_password) {
		onGenerateAccPage.current_password(current_password);
	}

	@Step
	public void new_user_name(String new_user_name) {
		onGenerateAccPage.new_user_name(new_user_name);
	}

	@Step
	public void new_password(String new_password) {
		onGenerateAccPage.new_password(new_password);
	}

	@Step
	public void confirm_new_password(String confirm_new_password) {
		onGenerateAccPage.confirm_new_password(confirm_new_password);
	}

	@Step
	public void submit() {
		onGenerateAccPage.clickSubmit();
	}

}
