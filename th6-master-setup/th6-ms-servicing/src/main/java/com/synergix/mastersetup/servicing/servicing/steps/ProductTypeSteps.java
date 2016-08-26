package com.synergix.mastersetup.servicing.servicing.steps;

import java.util.List;

import com.synergix.mastersetup.servicing.servicing.page.ProductTypePage;
import com.synergix.utilities.SessionData;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class ProductTypeSteps extends ScenarioSteps {

	ProductTypePage productTypePage;

	// button chung
	@Step
	public void click_btn_add_new() {
		productTypePage.click_btn_add_new();
	}

	@Step
	public void click_btn_update() {
		productTypePage.click_btn_update();
	}

	@Step
	public void click_btn_delete() {
		productTypePage.click_btn_delete();
	}

	//Enter input
	@Step
	public void enter_product_type_code(String _productTypeCode) {
		productTypePage.enter_product_type_code(_productTypeCode);

	}

	@Step
	public void enter_description(String _description) {
		productTypePage.enter_description(_description);

	}
	
	// Check box
	@Step
	public void check_product_type(String _productTypeCode) {
		productTypePage.check_product_type(_productTypeCode);
	}

	@Step
	public void uncheck_product_type(String _productTypeCode) {
		productTypePage.uncheck_product_type(_productTypeCode);
	}

	@Step
	public void check_product_type_all() {
		productTypePage.check_product_type_all();
	}

	@Step
	public void uncheck_product_type_all() {
		productTypePage.uncheck_product_type_all();
	}

	@Step
	public int count_table_company(String _productTypeCode) {
		return productTypePage.countDataRowTableCompanyWithHeader(_productTypeCode);
	}

	@Step
	public void check_company_all(String _productTypeCode) {
		productTypePage.checkAllCompanyWithHeader(_productTypeCode);
	}

	@Step

	public void uncheck_company_all(String _productTypeCode) {
		productTypePage.uncheckAllCompanyWithHeader(_productTypeCode);
	}

	@Step
	public void check_company_list(String _productTypeCode, String _companyList) {
		productTypePage.checkCompanyNameWithLable(_productTypeCode, _companyList);
	}

	
	
	@Step
	public boolean is_exist_product_type_code(String _productTypeCode) {
		return productTypePage.is_exist_product_type_code(_productTypeCode);
	}

	@Step
	public boolean is_value_exist_at_colindex(String _value, int colindex, String _regionalOfficeCode) {
		return productTypePage.is_value_exist_at_colindex(_value, colindex, _regionalOfficeCode);
	}

	@Step
	public String get_text_company_name(int i, String _productTypeCode) {
		return productTypePage.get_text_company_name(i, _productTypeCode);

	}

	@Step
	public boolean is_checked_company_name(int i, String _productTypeCode) {
		return productTypePage.is_checked_company_name(i, _productTypeCode);
	}
	@Step
	public void enter_product_type_code_search(String _productTypeCode) {

		productTypePage.enter_product_type_code_search(_productTypeCode);

	}
	@Step
	public void click_btn_collapse_company_name(String _productTypeCode){
		productTypePage.click_btn_collapse_company_name(_productTypeCode);
	}
	@Step
	public boolean is_readonly_product_type_code(){
		return productTypePage.is_readonly_product_type_code();
	}
	@Step
	public void confirm_yes() {
		productTypePage.confirm_yes();
	}
	@Step
	public String get_text_status_before_update() {
		return productTypePage.get_text_status_before_update();
	}
	@Step
	public boolean is_checked_status_label(String header, String label){
		return productTypePage.is_checked_status_label(header, label);
	}
	@Step
	public String get_text_checked_status_label(String header) {
		return productTypePage.get_text_checked_status_label(header); 
	}
	@Step
	public void selectRadioStatusWithLabel(String header, String label) {
		productTypePage.selectRadioStatusWithLabel(header, label);
	}
	@Step
	public void selectRadioLocalInfoStatusWithLabel(String header, String label) {
		productTypePage.selectRadioLocalInfoStatusWithLabel(header, label);
	}
	@Step
	public void create_new_product_type(String sProductTypeCode,String sDescription,String sCompanyNameList, String sStatus,String sLocalStatus ) {
			
		productTypePage.enter_product_type_code_search(sProductTypeCode);
		
		if (productTypePage.is_exist_product_type_code(sProductTypeCode) == false) {
			
			productTypePage.enter_product_type_code_search("");
			productTypePage.click_btn_add_new();
			productTypePage.enter_product_type_code(sProductTypeCode);
			productTypePage.enter_description(sDescription);
			// Choose Company
			productTypePage.click_btn_collapse_company_name(sProductTypeCode);
			productTypePage.checkAllCompanyWithHeader(sProductTypeCode);
			productTypePage.uncheckAllCompanyWithHeader(sProductTypeCode);
			productTypePage.checkCompanyNameWithLable(sProductTypeCode, sCompanyNameList);
			// Choose Status
			productTypePage.click_btn_update();
			productTypePage.selectRadioStatusWithLabel(sProductTypeCode, sStatus);

			if (sStatus.equals("Local Info")) {
				productTypePage.selectRadioLocalInfoStatusWithLabel(sProductTypeCode, sLocalStatus);
			}
			productTypePage.click_btn_update();

		}

	}


}