package com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.page.EmployeeGradePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EmployeeGradeSteps extends ScenarioSteps {
	EmployeeGradePage onEmployeeGradePage;

	@Step
	public void click_on_button_new() {
		onEmployeeGradePage.click_on_button_new();
	}

	@Step
	public void click_on_button_back_to_summary() {
		onEmployeeGradePage.click_on_button_back_to_summary();
	}

	@Step
	public void enter_employee_grade_code(String EmpGradeCode) {
		onEmployeeGradePage.enterEmployeeGradeCode(EmpGradeCode);
	}

	@Step
	public void enter_des_employee_grade(String des) {
		onEmployeeGradePage.enterDesEmployeeGrade(des);
	}

	@Step
	public boolean is_emp_grade_exist(String empGrade) {
		return onEmployeeGradePage.is_emp_grade_exist(empGrade);
	}

	@Step
	public boolean is_value_exist_at_colindex(String _value, String gradeCode) {
		return onEmployeeGradePage.is_value_exist_at_index(_value, gradeCode);
	}

	@Step
	public void click_on_grade_code(String gradeCode) {
		onEmployeeGradePage.click_on_grade_code(gradeCode);
	}

	@Step
	public void click_on_button_update() {
		onEmployeeGradePage.click_on_button_update();
	}

	@Step
	public void click_on_button_delete() {
		onEmployeeGradePage.click_on_button_delete();

	}

}
