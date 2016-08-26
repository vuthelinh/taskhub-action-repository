package com.synergix.processing.payroll.steps;

import com.synergix.processing.payroll.pages.PayrollAddPaymentByRecipientPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160727
 */
public class PayrollAddPaymentByRecipientSteps extends ScenarioSteps {
	PayrollAddPaymentByRecipientPage prAddPmentByRecipientPage;

	// Common Step
	@Step
	public void click_btn_confirm_submit_yes() {
		prAddPmentByRecipientPage.click_btn_confirm_submit_yes();
	}

	@Step
	public void click_btn_confirm_submit_no() {
		prAddPmentByRecipientPage.click_btn_confirm_submit_no();
	}

	@Step
	public void additional_payment_voucher_no(String _voucherNo) {
		System.out.println("***** INFO ***** Additional Payment Voucher No: " + _voucherNo);
	}

	// BEGIN Summary
	@Step
	public void switch_tab_by_recipient() {
		prAddPmentByRecipientPage.switch_tab_by_recipient();
	}

	@Step
	public boolean is_tab_active_by_recipient() {
		return prAddPmentByRecipientPage.is_tab_active_by_recipient();
	}

	@Step
	public void switch_tab_draft() {
		prAddPmentByRecipientPage.switch_tab_draft();
	}

	@Step
	public boolean is_tab_active_draft() {
		return prAddPmentByRecipientPage.is_tab_active_draft();
	}

	@Step
	public void switch_tab_outstanding() {
		prAddPmentByRecipientPage.switch_tab_outstanding();
	}

	@Step
	public boolean is_tab_active_outstanding() {
		return prAddPmentByRecipientPage.is_tab_active_outstanding();
	}

	@Step
	public void switch_tab_history() {
		prAddPmentByRecipientPage.switch_tab_history();
	}

	@Step
	public boolean is_tab_active_history() {
		return prAddPmentByRecipientPage.is_tab_active_history();
	}

	@Step
	public void switch_tab_pending_approval() {
		prAddPmentByRecipientPage.switch_tab_pending_approval();
	}

	@Step
	public boolean is_tab_active_pending_approval() {
		return prAddPmentByRecipientPage.is_tab_active_pending_approval();
	}

	@Step
	public void filter_by_voucher_no(String voucherNo) {
		prAddPmentByRecipientPage.filter_by_voucher_no(voucherNo);
	}

	@Step
	public void clear_filter_by_voucher_no(String voucherNo) {
		prAddPmentByRecipientPage.clear_filter_by_voucher_no(voucherNo);
	}

	@Step
	public void sort_filter_by_voucher_no() {
		prAddPmentByRecipientPage.sort_filter_by_voucher_no();
	}

	@Step
	public void filter_by_payroll_date(String payrollDateFrom, String payrollDateTo) {
		prAddPmentByRecipientPage.filter_by_payroll_date(payrollDateFrom, payrollDateTo);
	}

	@Step
	public void clear_filter_by_payroll_date() {
		prAddPmentByRecipientPage.clear_filter_by_payroll_date();
	}

	@Step
	public void sort_filter_by_payroll_date() {
		prAddPmentByRecipientPage.sort_filter_by_payroll_date();
	}

	@Step
	public void filter_by_voucher_date(String voucherDateFrom, String voucherDateTo) {
		prAddPmentByRecipientPage.filter_by_voucher_date(voucherDateFrom, voucherDateTo);
	}

	@Step
	public void clear_filter_by_voucher_date() {
		prAddPmentByRecipientPage.clear_filter_by_voucher_date();
	}

	@Step
	public void sort_filter_by_voucher_date() {
		prAddPmentByRecipientPage.sort_filter_by_voucher_date();
	}

	@Step
	public void filter_by_voucher_desc(String voucherDesc) {
		prAddPmentByRecipientPage.filter_by_voucher_desc(voucherDesc);
	}

	@Step
	public void clear_filter_by_voucher_desc() {
		prAddPmentByRecipientPage.clear_filter_by_voucher_desc();
	}

	@Step
	public void sort_filter_by_voucher_desc() {
		prAddPmentByRecipientPage.sort_filter_by_voucher_desc();
	}

	@Step
	public void filter_by_recipient(String recipient) {
		prAddPmentByRecipientPage.filter_by_recipient(recipient);
	}

	@Step
	public void clear_filter_by_recipient(String recipient) {
		prAddPmentByRecipientPage.clear_filter_by_recipient(recipient);
	}

	@Step
	public void sort_filter_by_recipient(String recipient) {
		prAddPmentByRecipientPage.sort_filter_by_recipient(recipient);
	}

	@Step
	public void filter_by_recipient_name(String recipientName) {
		prAddPmentByRecipientPage.filter_by_recipient_name(recipientName);
	}

	@Step
	public void clear_filter_by_recipient_name() {
		prAddPmentByRecipientPage.clear_filter_by_recipient_name();
	}

	@Step
	public void sort_filter_by_recipient_name() {
		prAddPmentByRecipientPage.sort_filter_by_recipient_name();
	}

	@Step
	public void filter_by_recipient_short_name(String recipientShortName) {
		prAddPmentByRecipientPage.filter_by_recipient_short_name(recipientShortName);
	}

	@Step
	public void clear_filter_by_recipient_short_name() {
		prAddPmentByRecipientPage.clear_filter_by_recipient_short_name();
	}

	@Step
	public void sort_filter_by_recipient_short_name() {
		prAddPmentByRecipientPage.sort_filter_by_recipient_short_name();
	}

	@Step
	public void filter_by_created_by(String createdByFrom, String createdByTo) {
		prAddPmentByRecipientPage.filter_by_created_by(createdByFrom, createdByTo);
	}

	@Step
	public void clear_filter_by_created_by() {
		prAddPmentByRecipientPage.clear_filter_by_created_by();
	}

	@Step
	public void sort_filter_by_created_by() {
		prAddPmentByRecipientPage.sort_filter_by_created_by();
	}

	@Step
	public void open_first_voucher_no() {
		prAddPmentByRecipientPage.open_first_voucher_no();
	}

	// END Summary
	// BEGIN Draft
	@Step
	public void switch_tab_draft_by_recipient(String byRecipient) {
		prAddPmentByRecipientPage.switch_tab_draft_by_recipient(byRecipient);
	}

	@Step
	public boolean is_tab_active_draft_by_recipient(String byRecipient) {
		return prAddPmentByRecipientPage.is_tab_active_draft_by_recipient(byRecipient);
	}

	@Step
	public void switch_tab_draft_remark() {
		prAddPmentByRecipientPage.switch_tab_draft_remark();
	}

	@Step
	public boolean is_tab_active_draft_remark(String remark) {
		return prAddPmentByRecipientPage.is_tab_active_draft_remark(remark);
	}

	@Step
	public void switch_tab_draft_attachments(String attachments) {
		prAddPmentByRecipientPage.switch_tab_draft_attachments(attachments);
	}

	@Step
	public boolean is_tab_active_draft_attachments(String attachments) {
		return prAddPmentByRecipientPage.is_tab_active_draft_attachments(attachments);
	}

	@Step
	public void click_btn_new() {
		prAddPmentByRecipientPage.click_btn_new();
	}

	@Step
	public boolean is_btn_clickable_new() {
		return prAddPmentByRecipientPage.is_btn_clickable_new();
	}

	@Step
	public void click_btn_abort() {
		prAddPmentByRecipientPage.click_btn_abort();
	}

	@Step
	public boolean is_btn_clickable_abort() {
		return prAddPmentByRecipientPage.is_btn_clickable_abort();
	}

	@Step
	public void click_btn_submit() {
		prAddPmentByRecipientPage.click_btn_submit();
	}

	@Step
	public boolean is_btn_clickable_submit() {
		return prAddPmentByRecipientPage.is_btn_clickable_submit();
	}

	@Step
	public void click_btn_back_to_summary() {
		prAddPmentByRecipientPage.click_btn_back_to_summary();
	}

	@Step
	public boolean is_btn_clickable_back_to_summary(String backToSummary) {
		return prAddPmentByRecipientPage.is_btn_clickable_back_to_summary(backToSummary);
	}

	// @Step
	// public void enter_voucher_no(String voucherNo) {
	// prAddPmentByRecipientPage.enter_voucher_no(voucherNo);
	// }

	@Step
	public String get_text_voucher_no() {
		return prAddPmentByRecipientPage.get_text_voucher_no();
	}

	@Step
	public void enter_description(String description) {
		prAddPmentByRecipientPage.enter_description(description);
	}

	@Step
	public String get_text_description() {
		return prAddPmentByRecipientPage.get_text_description();
	}

	// @Step
	// public String is_enabled_description(String description) {
	// return prAddPmentByRecipientPage.is_enabled_description(description);
	// }

	// @Step
	// public String is_readonly_description(String description) {
	// return prAddPmentByRecipientPage.is_readonly_description(description);
	// }

	@Step
	public void select_voucher_type(String voucherType) {
		prAddPmentByRecipientPage.select_voucher_type(voucherType);
	}

	// @Step
	// public boolean is_selected_voucher_type(String voucherType) {
	// return prAddPmentByRecipientPage.is_selected_voucher_type(voucherType);
	// }

	// @Step
	// public boolean is_enabled_voucher_type(String voucherType) {
	// return prAddPmentByRecipientPage.is_enabled_voucher_type(voucherType);
	// }

	@Step
	public void enter_voucher_date(String voucherDate) {
		prAddPmentByRecipientPage.enter_voucher_date(voucherDate);
	}

	@Step
	public String get_text_voucher_date() {
		return prAddPmentByRecipientPage.get_text_voucher_date();
	}

	// @Step
	// public String is_enabled_voucher_date(String voucherDate) {
	// return prAddPmentByRecipientPage.is_enabled_voucher_date(voucherDate);
	// }

	// @Step
	// public String is_readonly_voucher_date(String voucherDate) {
	// return prAddPmentByRecipientPage.is_readonly_voucher_date(voucherDate);
	// }

	// BEGIN By Recipient
	@Step
	public void enter_recipient(String recipient) {
		prAddPmentByRecipientPage.enter_recipient(recipient);
	}

	@Step
	public String get_text_recipient() {
		return prAddPmentByRecipientPage.get_text_recipient();
	}

	@Step
	public String get_text_recipient_name() {
		return prAddPmentByRecipientPage.get_text_recipient_name();
	}
	// @Step
	// public String is_enabled_recipient(String recipient) {
	// return prAddPmentByRecipientPage.is_enabled_recipient(recipient);
	// }

	// @Step
	// public String is_readonly_recipient(String recipient) {
	// return prAddPmentByRecipientPage.is_readonly_recipient(recipient);
	// }

	@Step
	public void enter_payroll_date(String payrollDate) {
		prAddPmentByRecipientPage.enter_payroll_date(payrollDate);
	}

	@Step
	public String get_text_payroll_date(String payrollDate) {
		return prAddPmentByRecipientPage.get_text_payroll_date(payrollDate);
	}

	// @Step
	// public String is_enabled_payroll_date(String payrollDate) {
	// return prAddPmentByRecipientPage.is_enabled_payroll_date(payrollDate);
	// }

	// @Step
	// public String is_readonly_payroll_date(String payrollDate) {
	// return prAddPmentByRecipientPage.is_readonly_payroll_date(payrollDate);
	// }

	@Step
	public void click_btn_ws_add() {
		prAddPmentByRecipientPage.click_btn_ws_add();
	}

	@Step
	public boolean is_btn_clickable_ws_add() {
		return prAddPmentByRecipientPage.is_btn_clickable_ws_add();
	}

	@Step
	public void click_btn_ws_delete(String delete) {
		prAddPmentByRecipientPage.click_btn_ws_delete(delete);
	}

	@Step
	public boolean is_btn_clickable_ws_delete(String delete) {
		return prAddPmentByRecipientPage.is_btn_clickable_ws_delete(delete);
	}

	@Step
	public int get_ws_row_by_no(String no) {
		return prAddPmentByRecipientPage.get_ws_row_by_no(no);
	}

	@Step
	public void enter_ws_wage_service(int rowIndex, String wageService) {
		prAddPmentByRecipientPage.enter_ws_wage_service(rowIndex, wageService);
	}

	@Step
	public String get_text_ws_wage_service(int rowIndex, String wageService) {
		return prAddPmentByRecipientPage.get_text_ws_wage_service(rowIndex, wageService);
	}

	// @Step
	// public String is_enabled_ws_wage_service(int rowIndex, String
	// wageService) {
	// return prAddPmentByRecipientPage.is_enabled_ws_wage_service(rowIndex,
	// wageService);
	// }

	// @Step
	// public String is_readonly_ws_wage_service(int rowIndex, String
	// wageService) {
	// return prAddPmentByRecipientPage.is_readonly_ws_wage_service(rowIndex,
	// wageService);
	// }

	@Step
	public String get_text_ws_description(int rowIndex) {
		System.out.println(prAddPmentByRecipientPage.get_text_ws_description(rowIndex));
		return prAddPmentByRecipientPage.get_text_ws_description(rowIndex);
	}

	@Step
	public void enter_ws_wage_service_remark(int rowIndex, String remark) {
		prAddPmentByRecipientPage.enter_ws_wage_service_remark(rowIndex, remark);
	}

	// @Step
	// public String is_enabled_ws_description(int rowIndex, String description)
	// {
	// return prAddPmentByRecipientPage.is_enabled_ws_description(rowIndex,
	// description);
	// }

	// @Step
	// public String is_readonly_ws_description(int rowIndex, String
	// description) {
	// return prAddPmentByRecipientPage.is_readonly_ws_description(rowIndex,
	// description);
	// }

	@Step
	public void enter_ws_voucher_date(int rowIndex, String voucherDate) {
		prAddPmentByRecipientPage.enter_ws_voucher_date(rowIndex, voucherDate);
	}

	@Step
	public String get_text_ws_voucher_date(int rowIndex, String voucherDate) {
		return prAddPmentByRecipientPage.get_text_ws_voucher_date(rowIndex, voucherDate);
	}

	// @Step
	// public String is_enabled_ws_voucher_date(int rowIndex, String
	// voucherDate) {
	// return prAddPmentByRecipientPage.is_enabled_ws_voucher_date(rowIndex,
	// voucherDate);
	// }

	// @Step
	// public String is_readonly_ws_voucher_date(int rowIndex, String
	// voucherDate) {
	// return prAddPmentByRecipientPage.is_readonly_ws_voucher_date(rowIndex,
	// voucherDate);
	// }

	@Step
	public void select_in_ws_currency(int rowIndex, String currency) {
		prAddPmentByRecipientPage.select_in_ws_currency(rowIndex, currency);
	}

	// @Step
	// public List<String> get_all_option_ws_currency(int rowIndex, String
	// currency) {
	// return prAddPmentByRecipientPage.get_all_option_ws_currency(rowIndex,
	// currency);
	// }

	@Step
	public void enter_ws_exchange_rate(int rowIndex, String exchangeRate) {
		prAddPmentByRecipientPage.enter_ws_exchange_rate(rowIndex, exchangeRate);
	}

	@Step
	public String get_text_ws_exchange_rate(int rowIndex, String exchangeRate) {
		return prAddPmentByRecipientPage.get_text_ws_exchange_rate(rowIndex, exchangeRate);
	}

	// @Step
	// public String is_enabled_ws_exchange_rate(int rowIndex, String
	// exchangeRate) {
	// return prAddPmentByRecipientPage.is_enabled_ws_exchange_rate(rowIndex,
	// exchangeRate);
	// }

	// @Step
	// public String is_readonly_ws_exchange_rate(int rowIndex, String
	// exchangeRate) {
	// return prAddPmentByRecipientPage.is_readonly_ws_exchange_rate(rowIndex,
	// exchangeRate);
	// }
	@Step
	public void enter_ws_qty(int rowIndex, String qty) {
		prAddPmentByRecipientPage.enter_ws_qty(rowIndex, qty);
	}

	@Step
	public String get_text_ws_qty(int rowIndex, String unitPrice) {
		return prAddPmentByRecipientPage.get_text_ws_qty(rowIndex);
	}

	@Step
	public void enter_ws_unit_price(int rowIndex, String unitPrice) {
		prAddPmentByRecipientPage.enter_ws_unit_price(rowIndex, unitPrice);
	}

	@Step
	public String get_text_ws_unit_price(int rowIndex, String unitPrice) {
		return prAddPmentByRecipientPage.get_text_ws_unit_price(rowIndex);
	}

	// @Step
	// public String is_enabled_ws_unit_price(int rowIndex, String unitPrice) {
	// return prAddPmentByRecipientPage.is_enabled_ws_unit_price(rowIndex,
	// unitPrice);
	// }

	// @Step
	// public String is_readonly_ws_unit_price(int rowIndex, String unitPrice) {
	// return prAddPmentByRecipientPage.is_readonly_ws_unit_price(rowIndex,
	// unitPrice);
	// }

	@Step
	public void check_ws_incl_tax(int rowIndex) {
		prAddPmentByRecipientPage.check_ws_incl_tax(rowIndex);
	}

	@Step
	public void uncheck_ws_incl_tax(int rowIndex) {
		prAddPmentByRecipientPage.uncheck_ws_incl_tax(rowIndex);
	}

	@Step
	public void set_ws_incl_tax(int rowIndex, String inclTax) {
		prAddPmentByRecipientPage.set_ws_incl_tax(rowIndex, inclTax);
	}

	@Step
	public boolean is_checked_ws_incl_tax(int rowIndex, String inclTax) {
		return prAddPmentByRecipientPage.is_checked_ws_incl_tax(rowIndex, inclTax);
	}

	@Step
	public boolean is_unchecked_ws_incl_tax(int rowIndex, String inclTax) {
		return prAddPmentByRecipientPage.is_unchecked_ws_incl_tax(rowIndex, inclTax);
	}

	@Step
	public boolean is_enabled_ws_incl_tax(int rowIndex, String inclTax) {
		return prAddPmentByRecipientPage.is_enabled_ws_incl_tax(rowIndex, inclTax);
	}

	@Step
	public void enter_ws_sales_tax(int rowIndex, String salesTax) {
		prAddPmentByRecipientPage.enter_ws_sales_tax(rowIndex, salesTax);
	}

	@Step
	public String get_text_ws_sales_tax(int rowIndex, String salesTax) {
		return prAddPmentByRecipientPage.get_text_ws_sales_tax(rowIndex, salesTax);
	}

	// @Step
	// public String is_enabled_ws_sales_tax(int rowIndex, String salesTax) {
	// return prAddPmentByRecipientPage.is_enabled_ws_sales_tax(rowIndex,
	// salesTax);
	// }

	// @Step
	// public String is_readonly_ws_sales_tax(int rowIndex, String salesTax) {
	// return prAddPmentByRecipientPage.is_readonly_ws_sales_tax(rowIndex,
	// salesTax);
	// }

	@Step
	public String get_text_ws_nature_amt_before_tax(int rowIndex) {
		return prAddPmentByRecipientPage.get_text_ws_nature_amt_before_tax(rowIndex);
	}

	@Step
	public String get_text_ws_nature_amt_after_tax(int rowIndex) {
		return prAddPmentByRecipientPage.get_text_ws_nature_amt_after_tax(rowIndex);
	}

	@Step
	public void enter_ws_commission(int rowIndex, String startDate, String endDate, String monthlyCommission) {
		prAddPmentByRecipientPage.enter_ws_commission(rowIndex, startDate, endDate, monthlyCommission);
	}

	@Step
	public void open_ws_allocation_detail(int rowIndex) {
		prAddPmentByRecipientPage.open_ws_allocation_detail(rowIndex);
	}

	@Step
	public void close_ws_allocation_detail() {
		prAddPmentByRecipientPage.close_ws_allocation_detail();
	}

	@Step
	public void enter_alloc_detail_voucher_no(String voucherNo) {
		prAddPmentByRecipientPage.enter_alloc_detail_voucher_no(voucherNo);
	}

	@Step
	public void enter_alloc_detail_phase_sequence_no(String phaseSequenceNo) {
		prAddPmentByRecipientPage.enter_alloc_detail_phase_sequence_no(phaseSequenceNo);
	}

	@Step
	public String get_alloc_detail_line_no() {
		return prAddPmentByRecipientPage.get_alloc_detail_line_no();
	}

	@Step
	public String get_alloc_detail_wage_service_code() {
		return prAddPmentByRecipientPage.get_alloc_detail_wage_service_code();
	}

	@Step
	public String get_alloc_detail_wage_service_description() {
		return prAddPmentByRecipientPage.get_alloc_detail_wage_service_description();
	}

	@Step
	public String get_alloc_detail_alloc_line_no() {
		return prAddPmentByRecipientPage.get_alloc_detail_alloc_line_no();
	}

	@Step
	public String enter_ws_allocation(int rowIndex, String voucherNo, String phaseSequenceNo, String liNo) {
		return prAddPmentByRecipientPage.enter_ws_allocation(rowIndex, voucherNo, phaseSequenceNo, liNo);
	}

	// END By Recipient
	// BEGIN Remarks
	@Step
	public void enter_internal_remarks_code(String internalRemarksCode) {
		prAddPmentByRecipientPage.enter_internal_remarks_code(internalRemarksCode);
	}

	@Step
	public void enter_external_remarks_code(String externalRemarksCode) {
		prAddPmentByRecipientPage.enter_external_remarks_code(externalRemarksCode);
	}

	@Step
	public void enter_internal_remarks(String internalRemarks) {
		prAddPmentByRecipientPage.enter_internal_remarks(internalRemarks);
	}

	@Step
	public void enter_external_remarks(String externalRemarks) {
		prAddPmentByRecipientPage.enter_external_remarks(externalRemarks);
	}
	// END Remarks

	// END Draft
}
