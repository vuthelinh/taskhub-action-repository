package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupplierCategoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class SupplierCategorySteps extends ScenarioSteps {
	SupplierCategoryPage glSupplierCategoryPage;

	@Step
	public void click_btn_new() {
		glSupplierCategoryPage.click_btn_new();
	}

	@Step
	public void click_btn_delete() {
		glSupplierCategoryPage.click_btn_delete();
	}

	@Step
	public void click_btn_close() {
		glSupplierCategoryPage.click_btn_close();
	}

	@Step
	public void click_btn_update() {
		glSupplierCategoryPage.click_btn_update();
	}

	@Step
	public String enter_supplier_category_code(String _supplierCategoryCode) {
		String ret = glSupplierCategoryPage.enter_supplier_category_code(_supplierCategoryCode);
		if (!ret.isEmpty()) {
			ret = glSupplierCategoryPage.getErrorMessagesThenClickOK();
		}
		return ret;
	}

	@Step
	public boolean search_supplier_category_code(String _supplierCategoryCode) {
		return glSupplierCategoryPage.search_supplier_category_code(_supplierCategoryCode);
	}

	@Step
	public void enter_description(String _description) {
		glSupplierCategoryPage.enter_description(_description);
	}

	// Tag company
	@Step
	public void tag_company(String _companyName) {
		glSupplierCategoryPage.chooseCompany(_companyName);
	}
}
