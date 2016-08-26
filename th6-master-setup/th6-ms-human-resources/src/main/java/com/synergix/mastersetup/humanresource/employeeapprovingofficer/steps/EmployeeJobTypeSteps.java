package com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.page.EmployeeJobTypePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Lily Hoang on 7/29/2016.
 */
public class EmployeeJobTypeSteps extends ScenarioSteps {

	EmployeeJobTypePage EJobTypePage;

	// button chung
	@Step
	public void clickon_btn_new_summary() {
		EJobTypePage.clickon_btn_new_summary();
	}

	@Step
	public void clickon_btn_new() {
		EJobTypePage.clickon_btn_new();
	}

	@Step
	public void clickon_btn_update() {
		EJobTypePage.clickon_btn_update();
	}

	@Step
	public void clickon_btn_delete() {
		EJobTypePage.clickon_btn_delete();
	}

	@Step
	public void clickon_btn_back_to_summary() {
		EJobTypePage.clickon_btn_back_to_summary();
	}

	public void confirm_yes() {
		EJobTypePage.confirm_yes();

	}

	@Step
	public void enter_employee_job_type_code(String _EJobTypeCode) {
		EJobTypePage.enter_employee_job_type_code(_EJobTypeCode);

	}

	@Step
	public boolean is_employee_job_type_code_enabled() {
		return EJobTypePage.is_employee_job_type_code_enabled();

	}

	@Step
	public void enter_employee_job_type_desc(String _EJobTypeDesc) {
		EJobTypePage.enter_employee_job_type_desc(_EJobTypeDesc);

	}

	@Step
	public void select_update_project_cost_yes() {
		EJobTypePage.select_update_project_cost_yes();
	}

	@Step
	public void select_update_project_cost_no() {

		EJobTypePage.select_update_project_cost_no();
	}

	@Step
	public int count_table_company() {
		return EJobTypePage.count_table_company();
	}

	@Step
	public void check_company_all() {
		EJobTypePage.check_company_all();
	}

	@Step

	public void uncheck_company_all() {
		EJobTypePage.uncheck_company_all();
	}

	@Step
	public void check_company(String _companyList) {
		EJobTypePage.check_company(_companyList);
	}

	@Step
	public void clickon_employee_job_type_code(String _EJobTypeCode) {
		EJobTypePage.clickon_employee_job_type_code(_EJobTypeCode);
	}

	@Step
	public boolean is_Employee_Job_Type_exist(String _EJobTypeCode) {
		return EJobTypePage.is_Employee_Job_Type_exist(_EJobTypeCode);
	}

	@Step
	public boolean is_value_exist_at_colname(String _value, int colindex, String _EJobTypeCode) {
		return EJobTypePage.is_value_exist_at_colname(_value, colindex, _EJobTypeCode);
	}

	@Step
	public void creat_new_employee_job_type(String _EJobTypeCode, String _EJobTypeDesc, String _CompanyNameList,
			String _UpdateProjectCost) {

		boolean check = EJobTypePage.is_Employee_Job_Type_exist(_EJobTypeCode);
		if (!check) {
			EJobTypePage.clickon_btn_new_summary();
			if (EJobTypePage.is_employee_job_type_code_enabled() == true) {
				EJobTypePage.enter_employee_job_type_code(_EJobTypeCode);
			}
			EJobTypePage.enter_employee_job_type_desc(_EJobTypeDesc);
			if (_UpdateProjectCost.equals("Yes")) {
				EJobTypePage.select_update_project_cost_yes();
			} else {
				EJobTypePage.select_update_project_cost_no();
			}

			EJobTypePage.check_company(_CompanyNameList);
			EJobTypePage.clickon_btn_update();
			EJobTypePage.confirm_yes();
		}

	}
}