package com.synergix.processing.purchase.purchaserequisition.steps;

import java.util.List;

import com.synergix.processing.purchase.purchaserequisition.pages.CombinePRPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class CombinePRSteps extends ScenarioSteps {
	CombinePRPage combinePRPage;

	@Step
	public void purchase_order_no(String _purchaseOrderNo) {
		System.out.println("***** INFO ***** Purchase Order No: " + _purchaseOrderNo);
	}

	@Step
	public void filter_by_supplier_code(String _supplierCode) {
		combinePRPage.filter_by_supplier_code(_supplierCode);
	}

	@Step
	public void filter_by_supplier_name(String _supplierName) {
		combinePRPage.filter_by_supplier_name(_supplierName);
	}

	@Step
	public void filter_by_currency(String _currency) {
		combinePRPage.filter_by_currency(_currency);
	}

	@Step
	public void click_on_no_of_pr_pending_to_generate_po(int _rowIndex) {
		combinePRPage.click_on_no_of_pr_pending_to_generate_po(_rowIndex);
	}

	@Step
	public void click_btn_back_to_summary() {
		combinePRPage.click_btn_back_to_summary();
	}

	@Step
	public void click_btn_submit() {
		combinePRPage.click_btn_submit();
	}

	@Step
	public String get_purchase_order_no() {
		return combinePRPage.get_purchase_order_no();
	}

	@Step
	public List<String> get_list_purchase_order_no() {
		return combinePRPage.get_list_purchase_order_no();
	}

	@Step
	public void click_btn_ok_infor_panel_confirm() {
		combinePRPage.click_btn_ok_infor_panel_confirm();
	}

	@Step
	public void clickBtnYesOnConfirmSubmit() {
		combinePRPage.clickBtnYesOnConfirmSubmit();
	}

	@Step
	public void clickBtnNoOnConfirmSubmit() {
		combinePRPage.clickBtnNoOnConfirmSubmit();
	}

	@Step
	public int get_group_prs_row_index_by_any_text(String _givenText) {
		return combinePRPage.get_group_prs_row_index_by_any_text(_givenText);
	}

	@Step
	public void select_group_prs_row_index_by_any_text(String _givenText) {
		combinePRPage.select_group_prs_row_index_by_any_text(_givenText);
	}

	@Step
	public int get_pr_row_index_by_pr_no(String _prNo) {
		return combinePRPage.get_pr_row_index_by_pr_no(_prNo);
	}

	@Step
	public void check_checkbox_pr_by_pr_no(String _prNo) {
		combinePRPage.check_checkbox_pr_by_pr_no(_prNo);
	}

}
