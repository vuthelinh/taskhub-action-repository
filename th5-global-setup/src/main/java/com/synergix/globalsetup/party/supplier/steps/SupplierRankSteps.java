package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupplierRankPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class SupplierRankSteps extends ScenarioSteps {
	SupplierRankPage glSupplierRankPage;

	@Step
	public void click_btn_new() {
		glSupplierRankPage.click_btn_new();
	}

	@Step
	public void click_btn_delete() {
		glSupplierRankPage.click_btn_delete();
	}

	@Step
	public void click_btn_close() {
		glSupplierRankPage.click_btn_close();
	}

	@Step
	public void click_btn_update() {
		glSupplierRankPage.click_btn_update();
	}

	@Step
	public String enter_supplier_rank_code(String _supplierRankCode) {
		String ret = glSupplierRankPage.enter_supplier_rank_code(_supplierRankCode);
		if (!ret.isEmpty()) {
			ret = glSupplierRankPage.getErrorMessagesThenClickOK();
		}
		return ret;
	}

	@Step
	public boolean search_supplier_rank_code(String _supplierRankCode) {
		return glSupplierRankPage.search_supplier_rank_code(_supplierRankCode);
	}

	@Step
	public void enter_description(String _description) {
		glSupplierRankPage.enter_description(_description);
	}

	// Tag company
	@Step
	public void tag_company(String _companyName) {
		glSupplierRankPage.chooseCompany(_companyName);
	}
}
