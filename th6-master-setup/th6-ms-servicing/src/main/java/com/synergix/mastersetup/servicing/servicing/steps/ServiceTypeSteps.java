package com.synergix.mastersetup.servicing.servicing.steps;

import com.synergix.mastersetup.servicing.servicing.page.ServiceTypePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class ServiceTypeSteps extends ScenarioSteps {

	ServiceTypePage serviceTypePage;

	// button chung
	@Step
	public void click_btn_add_new() {
		serviceTypePage.click_btn_add_new();
	}

	@Step
	public void click_btn_update() {
		serviceTypePage.click_btn_update();
	}

	@Step
	public void click_btn_delete() {
		serviceTypePage.click_btn_delete();
	}

	// Enter input
	@Step
	public void enter_service_type_code(String _serviceTypeCode) {
		serviceTypePage.enter_service_type_code(_serviceTypeCode);

	}

	@Step
	public void enter_description(String _description) {
		serviceTypePage.enter_description(_description);

	}

	// Check box
	@Step
	public void check_service_type() {
		serviceTypePage.check_service_type();
	}

	@Step
	public void uncheck_service_type() {
		serviceTypePage.uncheck_service_type();
	}

	@Step
	public void check_service_type_all() {
		serviceTypePage.check_service_type_all();
	}

	@Step
	public void uncheck_service_type_all() {
		serviceTypePage.uncheck_service_type_all();
	}

	@Step
	public int count_table_company() {
		return serviceTypePage.countDataRowTableCompany();
	}

	@Step
	public void check_company_all(String _serviceTypeCode) {
		// serviceTypePage.checkAllCompanyWithHeader(_serviceTypeCode);
		serviceTypePage.check_company_name_all();
	}

	@Step

	public void uncheck_company_all(String _serviceTypeCode) {
		// serviceTypePage.uncheckAllCompanyWithHeader(_serviceTypeCode);
		serviceTypePage.uncheck_company_name_all();
	}

	@Step
	public void check_company_list(String _companyList) {
		serviceTypePage.checkCompanyNameWithLabel(_companyList);
	}

	@Step
	public boolean is_exist_service_type_code(String _serviceTypeCode) {
		return serviceTypePage.is_exist_service_type_code(_serviceTypeCode);
	}

	@Step
	public boolean is_value_exist_at_colindex(String _value, int colindex, String _regionalOfficeCode) {
		return serviceTypePage.is_value_exist_at_colindex(_value, colindex, _regionalOfficeCode);
	}

	@Step
	public String get_text_company_name(int i) {
		return serviceTypePage.get_text_company_name(i);

	}

	@Step
	public boolean is_checked_company_name(int i) {
		return serviceTypePage.is_checked_company_name(i);
	}

	@Step
	public void enter_service_type_code_search(String _serviceTypeCode) {

		serviceTypePage.enter_service_type_code_search(_serviceTypeCode);

	}

	@Step
	public void click_btn_expand_company_name() {
		serviceTypePage.click_btn_expand_company_name_table();
	}

	@Step
	public boolean is_readonly_service_type_code() {
		return serviceTypePage.is_readonly_service_type_code();
	}

	@Step
	public void confirm_yes() {
		serviceTypePage.confirm_yes();
	}

	@Step
	public String get_text_status_before_update() {
		return serviceTypePage.get_text_status_before_update();
	}

	@Step
	public boolean is_checked_status_label(String label) {
		return serviceTypePage.is_checked_status_label(label);
	}

	@Step
	public String get_text_checked_local_status_label() {
		return serviceTypePage.get_text_checked_local_status_label();

	}

	@Step
	public String get_text_checked_status_label(String header) {
		return serviceTypePage.get_text_checked_status_label(header);
	}

	@Step
	public void selectRadioStatusWithLabel(String _statusName) {
		serviceTypePage.selectRadioStatusWithLabel(_statusName);
	}

	@Step
	public void selectRadioLocalInfoStatusWithLabel(String _localStatusName) {
		serviceTypePage.selectRadioLocalInfoStatusWithLabel(_localStatusName);
	}
	@Step
	public void create_new_service_type(String sServiceTypeCode,String sDescription,String sCompanyNameList, String sStatus,String sLocalStatus ) {
			
		serviceTypePage.enter_service_type_code_search(sServiceTypeCode);
		
		if (serviceTypePage.is_exist_service_type_code(sServiceTypeCode) == false) {
			
			serviceTypePage.enter_service_type_code_search("");
			serviceTypePage.click_btn_add_new();
			serviceTypePage.enter_service_type_code(sServiceTypeCode);
			serviceTypePage.enter_description(sDescription);
			// Choose Company
			serviceTypePage.click_btn_expand_company_name_table();
			serviceTypePage.check_company_name_all();
			serviceTypePage.uncheck_company_name_all();
			System.out.println("company="+sCompanyNameList);
			check_company_list(sCompanyNameList);
			
			// Choose Status
			serviceTypePage.click_btn_update();
			serviceTypePage.selectRadioStatusWithLabel(sStatus);

			if (sStatus.equals("Local Info")) {
				serviceTypePage.selectRadioLocalInfoStatusWithLabel(sLocalStatus);
			}
			serviceTypePage.click_btn_update();
			
		}

	}

}