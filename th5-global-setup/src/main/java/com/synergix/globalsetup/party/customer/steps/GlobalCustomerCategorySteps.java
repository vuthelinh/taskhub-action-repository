package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.GlobalCustomerCategoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class GlobalCustomerCategorySteps extends ScenarioSteps {
	GlobalCustomerCategoryPage glCusCategoryPage;

	@Step
	public void click_btn_new() {
		glCusCategoryPage.click_btn_new();
	}

	@Step
	public void click_btn_delete() {
		glCusCategoryPage.click_btn_delete();
	}

	@Step
	public void click_btn_close() {
		glCusCategoryPage.click_btn_close();
	}

	@Step
	public void click_btn_update() {
		glCusCategoryPage.click_btn_update();
	}

	@Step
	public void enter_customer_category_code(String _customerCategoryCode) {
		glCusCategoryPage.enter_customer_category_code(_customerCategoryCode);
	}

	@Step
	public void enter_description(String _description) {
		glCusCategoryPage.enter_description(_description);
	}

	public void select_customer_type(String _customerType) {
		glCusCategoryPage.select_customer_type(_customerType);
	}

	// Tag company
	@Step
	public void tag_company(String _companyName) {
		glCusCategoryPage.chooseCompany(_companyName);
	}
	
	@Step
	public void create_new_customer_category(String cusCategoryCode, String description,String customerType) {

		glCusCategoryPage.switchToIFrame("th5frame");
		glCusCategoryPage.click_btn_search();
		
		if (!glCusCategoryPage.search_result(cusCategoryCode)) {
			glCusCategoryPage.click_on_customer_category_code_link();
			glCusCategoryPage.click_btn_new();
			glCusCategoryPage.waitForAllJSCompletes();
			glCusCategoryPage.enter_customer_category_code(cusCategoryCode);
			glCusCategoryPage.waitForAllJSCompletes();
			glCusCategoryPage.enter_description(description);
			glCusCategoryPage.waitForAllJSCompletes();
			glCusCategoryPage.select_customer_type(customerType);
			glCusCategoryPage.click_btn_update();
			glCusCategoryPage.waitForAllJSCompletes();
			//glCusCategoryPage.clickBtnYesOnConfirmUpdate();
			glCusCategoryPage.waitForAllJSCompletes();
			//glCusCategoryPage.click_btn_status_popup();
		}

		glCusCategoryPage.switchOutDefaultIFrame();
	}
}
