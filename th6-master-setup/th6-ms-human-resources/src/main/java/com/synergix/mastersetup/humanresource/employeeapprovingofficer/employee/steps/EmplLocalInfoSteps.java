package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplLocalInfoPage;

public class EmplLocalInfoSteps extends ScenarioSteps {

	EmplLocalInfoPage onLocalInfoPage;

	@Step
	public void payment_cycle(String payment_cycle) {
		if (!payment_cycle.isEmpty())
			onLocalInfoPage.payment_cycle(payment_cycle);
	}

	@Step
	public void employee_payroll_category(String employee_payroll_category) {
		if (!employee_payroll_category.isEmpty())
			onLocalInfoPage
					.employee_payroll_category(employee_payroll_category);
	}

	@Step
	public void salary_type(String salary_type) {
		if (!salary_type.isEmpty())
			onLocalInfoPage.salary_type(salary_type);
	}

	@Step
	public void grade(String grade) {
		if (!grade.isEmpty())
			onLocalInfoPage.grade(grade);
	}

	@Step
	public void related_to_timesheet(String related_to_timesheet) {
		if (!related_to_timesheet.isEmpty())
			onLocalInfoPage.related_to_timesheet(related_to_timesheet);
	}

	@Step
	public void monitor_employee(String monitor_employee) {
		if (!monitor_employee.isEmpty())
			onLocalInfoPage.monitor_employee(monitor_employee);
	}

	@Step
	public void working_group(String working_group) {
		if (!working_group.isEmpty())
			onLocalInfoPage.working_group(working_group);
	}

}
