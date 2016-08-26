package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplTimesheetOfficerPage;

public class EmplTimesheetOfficerSteps extends ScenarioSteps {

	EmplTimesheetOfficerPage onTimesheetOfficerPage;

	@Step
	public void primary_reporting_officer(String primary_reporting_officer) {
		if (!primary_reporting_officer.isEmpty())
			onTimesheetOfficerPage
					.primary_reporting_officer(primary_reporting_officer);
	}

	@Step
	public void secondary_reporting_officer(String secondary_reporting_officer) {
		if (!secondary_reporting_officer.isEmpty())
			onTimesheetOfficerPage
					.secondary_reporting_officer(secondary_reporting_officer);
	}

}
