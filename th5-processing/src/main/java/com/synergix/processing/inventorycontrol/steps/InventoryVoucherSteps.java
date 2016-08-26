package com.synergix.processing.inventorycontrol.steps;

import com.synergix.processing.inventorycontrol.pages.InventoryVoucherPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160504
 */
public class InventoryVoucherSteps extends ScenarioSteps {
	InventoryVoucherPage IVPage;

	// BEGIN Logistic Billing Sales Customer Summary

	@Step
	public void click_btn_new_of_inventory_voucher_summany() {
		IVPage.click_btn_new_of_inventory_voucher_summany();
	}

	@Step
	public void switch_to_tab_draft() {
		IVPage.switch_to_tab_draft();
	}

	@Step
	public void switch_to_tab_outstanding() {
		IVPage.switch_to_tab_outstanding();
	}

	@Step
	public void filter_summary_by_voucher_no(String _voucherNo) {
		IVPage.filter_summary_by_voucher_no(_voucherNo);
	}

	@Step
	public void filter_summary_by_date(String _date) {
		IVPage.filter_summary_by_date(_date);
	}

	@Step
	public void filter_summary_by_transaction_type(String _transactionType) {
		IVPage.filter_summary_by_transaction_type(_transactionType);
	}

	@Step
	public void filter_summary_by_reference_no(String _referenceNo) {
		IVPage.filter_summary_by_reference_no(_referenceNo);
	}

	@Step
	public void filter_summary_by_subject(String _subject) {
		IVPage.filter_summary_by_subject(_subject);
	}

	@Step
	public void filter_summary_by_source_location_description(String _sourceLocationDescription) {
		IVPage.filter_summary_by_source_location_description(_sourceLocationDescription);
	}

	@Step
	public void filter_summary_by_created_by(String _createdBy) {
		IVPage.filter_summary_by_created_by(_createdBy);
	}

	@Step
	public void filter_summary_by_created_date(String _createdDateFrom, String _createdDateTo) {
		IVPage.filter_summary_by_created_date(_createdDateFrom, _createdDateTo);
	}

	@Step
	public void filter_summary_by_last_updated_by(String _lastUpdatedBy) {
		IVPage.filter_summary_by_last_updated_by(_lastUpdatedBy);
	}

	@Step
	public void filter_summary_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		IVPage.filter_summary_by_last_updated_date(_lastUpdatedDateFrom, _lastUpdatedDateTo);
	}

	@Step
	public void open_voucher_no(String _voucherNo) {
		IVPage.open_voucher_no(_voucherNo);
	}

	@Step
	public void open_first_voucher_no() {
		IVPage.open_first_voucher_no();
	}

	@Step
	public void open_and_verify_first_voucher(String _voucherNo) {
		IVPage.open_and_verify_first_voucher(_voucherNo);
	}

	@Step
	public String get_inventory_voucher_no() {
		return IVPage.get_inventory_voucher_no();
	}

	@Step
	public void submit_inventory_voucher() {
		IVPage.submit_inventory_voucher();
	}

	@Step
	public void click_btn_submit_inventory_voucher() {
		IVPage.click_btn_submit_inventory_voucher();
	}

	@Step
	public void clickBtnYesOnConfirmSubmit() {
		IVPage.clickBtnYesOnConfirmSubmit();
	}

	@Step
	public void clickBtnNoOnConfirmSubmit() {
		IVPage.clickBtnNoOnConfirmSubmit();
	}

}
