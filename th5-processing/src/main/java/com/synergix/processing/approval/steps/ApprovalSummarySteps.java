package com.synergix.processing.approval.steps;

import com.synergix.processing.approval.pages.ApprovalSummaryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160810
 */
public class ApprovalSummarySteps extends ScenarioSteps {
	ApprovalSummaryPage approvalSummaryPage;

	@Step
	public int get_approval_summary_row_index(String _givenText) {
		return approvalSummaryPage.get_approval_summary_row_index(_givenText);
	}

	@Step
	public void click_on_in_queue_number_by_anytext(String _givenText) {
		approvalSummaryPage.click_on_in_queue_number_by_anytext(_givenText);
	}

	@Step
	public void click_btn_submit() {
		approvalSummaryPage.click_btn_submit();
	}

	@Step
	public void clickBtnYesOnConfirmSubmit() {
		approvalSummaryPage.click_btn_confirm_submit_yes();
	}

	@Step
	public void clickBtnNoOnConfirmSubmit() {
		approvalSummaryPage.click_btn_confirm_submit_no();
	}

	// BEGIN Payroll - Additional Payment(By Recipient)
	@Step
	public void filter_in_queue_by_add_payment_voucher_no(String additioanlPaymentVoucherNo) {
		approvalSummaryPage.filter_in_queue_by_add_payment_voucher_no(additioanlPaymentVoucherNo);
	}

	@Step
	public void filter_in_queue_by_recipient_code(String recipientCode) {
		approvalSummaryPage.filter_in_queue_by_recipient_code(recipientCode);
	}

	@Step
	public void filter_in_queue_by_recipient_name(String recipientName) {
		approvalSummaryPage.filter_in_queue_by_recipient_name(recipientName);
	}

	@Step
	public void enter_in_queue_payroll_date_first_row(String payrollDate) {
		approvalSummaryPage.enter_in_queue_payroll_date_first_row(payrollDate);
	}

	@Step
	public void enter_in_queue_remarks_first_row(String remarks) {
		approvalSummaryPage.enter_in_queue_remarks_first_row(remarks);
	}

	// END Payroll
	@Step
	public void filter_in_queue_by_pr_no(String _PRNo) {
		approvalSummaryPage.filter_in_queue_by_pr_no(_PRNo);
	}

	@Step
	public void filter_in_queue_by_so_no(String _SONo) {
		approvalSummaryPage.filter_in_queue_by_so_no(_SONo);
	}

	@Step
	public void select_in_queue_action_first_row(String _action) {
		approvalSummaryPage.select_in_queue_action_first_row(_action);
	}

	@Step
	public void enter_in_queue_approved_supplier_first_row(String _approvedSupplier) {
		approvalSummaryPage.enter_in_queue_approved_supplier_first_row(_approvedSupplier);
	}

	@Step
	public void open_first_pr_no() {
		approvalSummaryPage.open_first_pr_no();
	}

	// PR Pending Approval Details
	@Step
	public void switch_to_tab_prpad_header() {
		approvalSummaryPage.switch_to_tab_prpad_header();
	}

	@Step
	public void switch_to_tab_prpad_detail() {
		approvalSummaryPage.switch_to_tab_prpad_detail();
	}

	@Step
	public int get_prpad_row_index_by_no(String _No) {
		return approvalSummaryPage.get_prpad_row_index_by_no(_No);
	}

	@Step
	public void open_prpad_panel_line_item_information(int _rowIndex) {
		approvalSummaryPage.open_prpad_panel_line_item_information(_rowIndex);
	}

	// Line Item Information
	// Supplier
	@Step
	public void switch_to_tab_prpad_supplier() {
		approvalSummaryPage.switch_to_tab_prpad_supplier();
	}

	@Step
	public void switch_to_tab_prpad_detail_allocation() {
		approvalSummaryPage.switch_to_tab_prpad_detail_allocation();
	}

	@Step
	public int get_prpad_supplier_row_index_by_supplier(String _supplier) {
		return approvalSummaryPage.get_prpad_supplier_row_index_by_supplier(_supplier);
	}

	@Step
	public void set_prpad_supplier_approved_supplier(int rowIndex, String _approvedSupplier) {
		approvalSummaryPage.set_prpad_supplier_approved_supplier(rowIndex, _approvedSupplier);
	}

	@Step
	public void click_btn_prpad_done() {
		approvalSummaryPage.click_btn_prpad_done();
	}

}
