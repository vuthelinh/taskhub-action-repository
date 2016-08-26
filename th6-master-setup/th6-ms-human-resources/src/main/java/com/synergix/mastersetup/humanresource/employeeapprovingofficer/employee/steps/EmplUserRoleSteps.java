package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.common.LogWork;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplUserRolePage;

public class EmplUserRoleSteps extends ScenarioSteps {

	EmplUserRolePage onUserRolePage;

	@Step
	public void moveToSystemRoleTab() {
		onUserRolePage.moveToTab("System Role");
	}

	@Step
	public void allowed(String roles) {
		for (String role : roles.split(", ")) {
			LogWork.log_debug(role);
			onUserRolePage.check_allowed(role);
		}
	}
}
