package com.synergix.mastersetup.project.project.project.steps;

import java.util.List;

import com.synergix.mastersetup.project.project.project.page.CostItemGroupPage;
import com.synergix.utilities.SessionData;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class CostItemGroupSteps extends ScenarioSteps {

	CostItemGroupPage costItemGroupPage;

	// button chung
	@Step
	public void click_btn_add_new() {
		costItemGroupPage.click_btn_add_new();
	}

	@Step
	public void click_btn_update() {
		costItemGroupPage.click_btn_update();
	}

	@Step
	public void click_btn_delete() {
		costItemGroupPage.click_btn_delete();
	}

	// Enter input
	@Step
	public void enter_cost_item_group_code(String _serviceTypeCode) {
		costItemGroupPage.enter_cost_item_group_code(_serviceTypeCode);

	}

	@Step
	public void enter_description(String _description) {
		costItemGroupPage.enter_description(_description);

	}

	// Check box
	@Step
	public void check_cost_item_group() {
		costItemGroupPage.check_cost_item_group();
	}

	@Step
	public void uncheck_cost_item_group() {
		costItemGroupPage.uncheck_cost_item_group();
	}

	@Step
	public void check_cost_item_group_all() {
		costItemGroupPage.check_cost_item_group_all();
	}

	@Step
	public void uncheck_cost_item_group_all() {
		costItemGroupPage.uncheck_cost_item_group_all();
	}

	@Step
	public int count_table_company() {
		return costItemGroupPage.countDataRowTableCompany();
	}

	@Step
	public void check_company_all(String _serviceTypeCode) {
		// costItemGroupPage.checkAllCompanyWithHeader(_serviceTypeCode);
		costItemGroupPage.check_company_name_all();
	}

	@Step

	public void uncheck_company_all(String _serviceTypeCode) {
		// costItemGroupPage.uncheckAllCompanyWithHeader(_serviceTypeCode);
		costItemGroupPage.uncheck_company_name_all();
	}

	@Step
	public void check_company_list(String _companyList) {
		costItemGroupPage.checkCompanyNameWithLabel(_companyList);
	}

	@Step
	public boolean is_exist_cost_item_group_code(String _serviceTypeCode) {
		return costItemGroupPage.is_exist_cost_item_group_code(_serviceTypeCode);
	}

	@Step
	public boolean is_value_exist_at_colindex(String _value, int colindex, String _regionalOfficeCode) {
		return costItemGroupPage.is_value_exist_at_colindex(_value, colindex, _regionalOfficeCode);
	}

	@Step
	public String get_text_company_name(int i) {
		return costItemGroupPage.get_text_company_name(i);

	}

	@Step
	public boolean is_checked_company_name(int i) {
		return costItemGroupPage.is_checked_company_name(i);
	}

	@Step
	public void enter_cost_item_group_code_search(String _serviceTypeCode) {

		costItemGroupPage.enter_cost_item_group_code_search(_serviceTypeCode);

	}

	@Step
	public void click_btn_expand_company_name() {
		costItemGroupPage.click_btn_expand_company_name_table();
	}

	@Step
	public boolean is_readonly_cost_item_group_code() {
		return costItemGroupPage.is_readonly_cost_item_group_code();
	}

	@Step
	public void confirm_yes() {
		costItemGroupPage.confirm_yes();
	}

	@Step
	public String get_text_status_before_update() {
		return costItemGroupPage.get_text_status_before_update();
	}

	@Step
	public boolean is_checked_status_label(String label) {
		return costItemGroupPage.is_checked_status_label(label);
	}

	@Step
	public String get_text_checked_local_status_label() {
		return costItemGroupPage.get_text_checked_local_status_label();

	}

	@Step
	public String get_text_checked_status_label(String header) {
		return costItemGroupPage.get_text_checked_status_label(header);
	}

	@Step
	public void selectRadioStatusWithLabel(String _statusName) {
		costItemGroupPage.selectRadioStatusWithLabel(_statusName);
	}

	@Step
	public void selectRadioLocalInfoStatusWithLabel(String _localStatusName) {
		costItemGroupPage.selectRadioLocalInfoStatusWithLabel(_localStatusName);
	}

	@Step
	public void create_new_cost_item_group(String _CostItemGroupCode, String _Description, String _CompanyNameList,
			String _Status, String _LocalStatus) {

			costItemGroupPage.enter_cost_item_group_code_search(_CostItemGroupCode);

		if (costItemGroupPage.is_exist_cost_item_group_code(_CostItemGroupCode) == false) {
			
			costItemGroupPage.enter_cost_item_group_code_search("");
			costItemGroupPage.click_btn_add_new();
			costItemGroupPage.enter_cost_item_group_code(_CostItemGroupCode);
			costItemGroupPage.enter_description(_Description);
			// Choose Company
			costItemGroupPage.click_btn_expand_company_name_table();
			costItemGroupPage.checkCompanyNameWithLabel(_CompanyNameList);
			// Choose Status
			costItemGroupPage.click_btn_update();
			costItemGroupPage.confirm_yes();
			costItemGroupPage.selectRadioStatusWithLabel(_Status);

			if (_Status.equals("Local Info")) {
				costItemGroupPage.selectRadioLocalInfoStatusWithLabel(_LocalStatus);
			}
			costItemGroupPage.click_btn_update();
			costItemGroupPage.confirm_yes();

		}

	}

}