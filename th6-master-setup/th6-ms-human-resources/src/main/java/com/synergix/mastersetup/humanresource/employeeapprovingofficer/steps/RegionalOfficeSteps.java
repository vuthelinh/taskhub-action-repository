package com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps;

import java.util.List;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.page.RegionalOfficePage;
import com.synergix.utilities.SessionData;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class RegionalOfficeSteps extends ScenarioSteps {

	RegionalOfficePage regionalOfficePage;

	// button chung
	@Step
	public void clickon_btn_new_summary() {
		regionalOfficePage.clickon_btn_new_summary();
	}

	@Step
	public void clickon_btn_new() {
		regionalOfficePage.clickon_btn_new();
	}

	@Step
	public void clickon_btn_update() {
		regionalOfficePage.clickon_btn_update();
	}

	@Step
	public void clickon_btn_delete() {
		regionalOfficePage.clickon_btn_delete();
	}

	@Step
	public void clickon_btn_back_to_summary() {
		regionalOfficePage.clickon_btn_back_to_summary();
	}

	public void confirm_yes() {
		regionalOfficePage.confirm_yes();

	}

	@Step
	public void enter_regional_office_code(String _regionalOfficeCode) {
		regionalOfficePage.enter_regional_office_code(_regionalOfficeCode);

	}

	@Step
	public boolean is_readonly_regional_office_code() {
		return regionalOfficePage.is_readonly_regional_office_code();

	}

	@Step
	public void enter_regional_office_name(String _regionalOfficeName) {
		regionalOfficePage.enter_regional_office_name(_regionalOfficeName);

	}

	@Step
	public int count_table_company() {
		return regionalOfficePage.count_data_row_table_company();
	}

	@Step
	public void check_company_all() {
		regionalOfficePage.check_company_all();
	}

	@Step

	public void uncheck_company_all() {
		regionalOfficePage.uncheck_company_all();
	}

	@Step
	public void check_company_list(String _companyList) {
		regionalOfficePage.check_company_list(_companyList);
	}

	@Step
	public void clickon_link_regional_office(String _regionalOfficeCode) {
		regionalOfficePage.clickon_link_regional_office(_regionalOfficeCode);
	}

	@Step
	public boolean is_exist_regional_office_at_list(String _regionalOfficeCode) {
		return regionalOfficePage.is_exist_regional_office_at_list(_regionalOfficeCode);
	}

	@Step
	public boolean is_value_exist_at_colindex(String _value, int colindex, String _regionalOfficeCode) {
		return regionalOfficePage.is_value_exist_at_colindex(_value, colindex, _regionalOfficeCode);
	}

	@Step
	public String get_text_regional_office_code() {

		return regionalOfficePage.get_text_regional_office_code();

	}

	@Step
	public String get_text_regional_office_name() {

		return regionalOfficePage.get_text_regional_office_name();

	}

	@Step
	public String get_text_company_name(int i) {
		return regionalOfficePage.get_text_company_name(i);

	}

	@Step
	public boolean is_checked_company_name(int i) {
		return regionalOfficePage.is_checked_company_name(i);
	}

	@Step
	public String get_today() {
		return regionalOfficePage.get_today();

	}
	@Step
	public void creat_new_regional_office(String _RegionalOfficeCode, String _RegionalOfficeName,
			String _CompanyNameList) {

		boolean check = regionalOfficePage.is_exist_regional_office_at_list(_RegionalOfficeCode);
		if (!check) {
			regionalOfficePage.clickon_btn_new_summary();
			if (regionalOfficePage.is_readonly_regional_office_code() == true) {
				regionalOfficePage.enter_regional_office_code(_RegionalOfficeCode);
			}
			regionalOfficePage.enter_regional_office_name(_RegionalOfficeName);
			regionalOfficePage.check_company_list(_CompanyNameList);
			regionalOfficePage.clickon_btn_update();
			regionalOfficePage.confirm_yes();
		}

	}

}