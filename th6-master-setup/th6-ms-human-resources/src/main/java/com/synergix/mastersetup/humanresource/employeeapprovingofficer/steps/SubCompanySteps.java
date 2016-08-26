package com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.page.EmployeeJobTypePage;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.page.SubCompanyPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class SubCompanySteps extends ScenarioSteps {

	SubCompanyPage subCompanyPage;

	// button chung
	@Step
	public void clickon_btn_new_summary() {
		subCompanyPage.clickon_btn_new_summary();
	}

	@Step
	public void clickon_btn_new() {
		subCompanyPage.clickon_btn_new();
	}

	@Step
	public void clickon_btn_update() {
		subCompanyPage.clickon_btn_update();
	}

	@Step
	public void clickon_btn_delete() {
		subCompanyPage.clickon_btn_delete();
	}

	@Step
	public void clickon_btn_back_to_summary() {
		subCompanyPage.clickon_btn_back_to_summary();
	}

	public void confirm_yes() {
		subCompanyPage.confirm_yes();

	}

	@Step
	public void enter_sub_company_code(String _SubCompanyCode) {
		subCompanyPage.enter_sub_company_code(_SubCompanyCode);

	}

	@Step
	public boolean is_sub_company_code_enabled() {
		return subCompanyPage.is_sub_company_code_enabled();

	}

	@Step
	public void enter_sub_company_name(String _SubCompanyName) {
		subCompanyPage.enter_sub_company_name(_SubCompanyName);

	}

	
	@Step
	public int count_table_company() {
		return subCompanyPage.count_data_row_table_company();
	}

	@Step
	public void check_company_all() {
		subCompanyPage.check_company_all();
	}

	@Step

	public void uncheck_company_all() {
		subCompanyPage.uncheck_company_all();
	}

	@Step
	public void check_company_list(String _companyList) {
		subCompanyPage.check_company_list(_companyList);
	}

	@Step
	public void clickon_link_sub_company(String _SubCompanyCode) {
		subCompanyPage.clickon_link_sub_company(_SubCompanyCode);
	}

	@Step
	public boolean is_sub_company_exist(String _SubCompanyCode) {
		return subCompanyPage.is_sub_company_exist(_SubCompanyCode);
	}
	@Step
	public boolean is_value_exist_at_colindex(String _value, int colindex,String _SubCompanyCode) {
		return subCompanyPage.is_value_exist_at_index(_value, colindex, _SubCompanyCode);
	}
	@Step
	public String get_text_sub_company_code() {

		return subCompanyPage.get_text_sub_company_code();

	}
	@Step
	public String get_text_sub_company_name() {

		return subCompanyPage.get_text_sub_company_name();

	}
	@Step
	public String get_text_company_name(int i) {
		return subCompanyPage.get_text_company_name(i);
		
	}
	@Step
	public boolean is_checked_company_name(int i){
		return subCompanyPage.is_checked_company_name(i);
	}
	@Step
	public void creat_new_regional_office(String _SubCompanyCode, String _SubCompanyName,
			String _CompanyNameList) {

		boolean check = subCompanyPage.is_sub_company_exist(_SubCompanyCode);
		if (!check) {
			subCompanyPage.clickon_btn_new_summary();
			if (subCompanyPage.is_sub_company_code_enabled() == true) {
				subCompanyPage.enter_sub_company_code(_SubCompanyCode);
			}
			subCompanyPage.enter_sub_company_name(_SubCompanyName);
			subCompanyPage.check_company_list(_CompanyNameList);
			subCompanyPage.clickon_btn_update();
			subCompanyPage.confirm_yes();
		}

	}
	
}