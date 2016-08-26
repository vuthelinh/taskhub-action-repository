package com.synergix.globalsetup.warranty.steps;

import com.synergix.globalsetup.warranty.pages.WarrantyTermPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class WarrantyTermSteps extends ScenarioSteps {
	WarrantyTermPage glWarrantyTermPage;

	@Step
	public void click_btn_new_summary() {
		glWarrantyTermPage.click_btn_new_summary();
	}

	@Step
	public void click_btn_new() {
		glWarrantyTermPage.click_btn_new();
	}

	@Step
	public void click_btn_delete() {
		glWarrantyTermPage.click_btn_delete();
	}

	@Step
	public void click_btn_close() {
		glWarrantyTermPage.click_btn_close();
	}

	@Step
	public void click_btn_update() {
		glWarrantyTermPage.click_btn_update();
	}

	@Step
	public void enter_warranty_term_code(String _warrantyTermCode) {
		glWarrantyTermPage.enter_warranty_term_code(_warrantyTermCode);
	}

	@Step
	public void enter_description(String _description) {
		glWarrantyTermPage.enter_description(_description);
	}

	@Step
	public void enter_warranty_days(String _warrantyDays) {
		glWarrantyTermPage.enter_warranty_days(_warrantyDays);
	}

	@Step
	public String get_global_status() {
		return glWarrantyTermPage.get_global_status();
	}

	@Step
	public void select_global_status(String _globalStatus) {
		glWarrantyTermPage.select_global_status(_globalStatus);
	}

	// Local Info
	@Step
	public void select_local_info(String _localInfo) {
		glWarrantyTermPage.select_local_info(_localInfo);
	}

	@Step
	public void switch_to_tab_company() {
		glWarrantyTermPage.switch_to_tab_company();
	}

	@Step
	public void switch_to_tab_local_info() {
		glWarrantyTermPage.switch_to_tab_local_info();
	}

	// Tag company
	@Step
	public void tag_company(String _companyName) {
		glWarrantyTermPage.chooseCompany(_companyName);
	}
}
