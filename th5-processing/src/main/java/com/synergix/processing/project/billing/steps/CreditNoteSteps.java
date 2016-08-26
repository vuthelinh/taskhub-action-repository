package com.synergix.processing.project.billing.steps;

import com.synergix.processing.project.billing.page.CreditNotePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreditNoteSteps extends ScenarioSteps {
	CreditNotePage creditNotePage;

	@Step
	public void click_btn_req_close_in_summany() {
		creditNotePage.click_btn_req_close_in_summany();
	}

	@Step
	public void filter_req_data_by_project_no(String _projectNo) {
		creditNotePage.filter_req_data_by_project_no(_projectNo);
	}

	@Step
	public int get_req_credit_note_row_by_project_no(String _projectNo) {
		return creditNotePage.get_req_credit_note_row_by_project_no(_projectNo);
	}

	@Step
	public void click_on_req_credit_note_by_project_no(String _projectNo) {
		creditNotePage.click_on_req_credit_note_by_project_no(_projectNo);
	}

	// Credit Note Request Detail
	@Step
	public void click_btn_req_detail_close() {
		creditNotePage.click_btn_req_detail_close();
	}

	@Step
	public void click_btn_req_detail_abort() {
		creditNotePage.click_btn_req_detail_abort();
	}

	@Step
	public void click_btn_req_detail_submit() {
		creditNotePage.click_btn_req_detail_submit();
	}

	@Step
	public String get_req_detail_project_no() {
		// TODOLATER
		return "";
	}

	@Step
	public String get_req_detail_customer_name() {
		// TODOLATER
		return "";
	}

	@Step
	public String get_req_detail_customer_job_no() {
		// TODOLATER
		return "";
	}

	@Step
	public void enter_req_detail_credit_note_date(String _creditNoteDate) {
		creditNotePage.enter_req_detail_credit_note_date(_creditNoteDate);
	}

	@Step
	public String get_req_detail_currency() {
		// TODOLATER
		return "";
	}

	@Step
	public String get_req_detail_subject() {
		// TODOLATER
		return "";
	}

	@Step
	public void enter_req_detail_credit_note_justification(String _creditNoteJustification) {
		creditNotePage.enter_req_detail_credit_note_justification(_creditNoteJustification);
	}

	@Step
	public void enter_req_amt_to_credit_amount(String _amtToCreditAmount) {
		creditNotePage.enter_req_amt_to_credit_amount(_amtToCreditAmount);
	}

	@Step
	public String get_req_retention_max_retention_amount_amount() {
		return creditNotePage.get_req_retention_max_retention_amount_amount();
	}

	@Step
	public String get_req_total_before_tax_amount_amount() {
		return creditNotePage.get_req_total_before_tax_amount_amount();
	}

	@Step
	public void switch_to_tab_credit_note_request() {
		creditNotePage.switch_to_tab_credit_note_request();
	}

	@Step
	public void switch_to_tab_credit_note() {
		creditNotePage.switch_to_tab_credit_note();
	}

	// Credit Note
	@Step
	public void filter_crd_note_data_by_project_no(String _projectNo) {
		creditNotePage.filter_crd_note_data_by_project_no(_projectNo);
	}

	@Step
	public int get_credit_note_row_by_project_no(String _projectNo) {
		return creditNotePage.get_credit_note_row_by_project_no(_projectNo);
	}

	@Step
	public void click_on_credit_node_no_by_project_no(String _projectNo) {
		creditNotePage.click_on_credit_node_no_by_project_no(_projectNo);
	}

	// Credit Note Header
	@Step
	public void switch_to_tab_draft() {
		creditNotePage.switch_to_tab_draft();
	}

	@Step
	public void switch_to_tab_history() {
		creditNotePage.switch_to_tab_history();
	}

	@Step
	public void switch_to_tab_header() {
		creditNotePage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_payment_info() {
		creditNotePage.switch_to_tab_payment_info();
	}

	@Step
	public void enter_header_credit_note_date(String _creditNoteDate) {
		creditNotePage.enter_header_credit_note_date(_creditNoteDate);
	}

	@Step
	public void enter_header_sale_tax(String _saleTax) {
		creditNotePage.enter_header_sale_tax(_saleTax);
	}

	@Step
	public void enter_header_credit_note_category(String _creditNoteCategory) {
		creditNotePage.enter_header_credit_note_category(_creditNoteCategory);
	}

	@Step
	public void enter_header_reference_no(String _referenceNo) {
		creditNotePage.enter_header_reference_no(_referenceNo);
	}

	@Step
	public void enter_header_remark_to_customer(String _remarkToCustomer) {
		creditNotePage.enter_header_remark_to_customer(_remarkToCustomer);
	}

	@Step
	public void enter_header_exchange_rate(String _exchangeRate) {
		creditNotePage.enter_header_exchange_rate(_exchangeRate);
	}

	// Credit Note Payment Info
	@Step
	public void select_pay_info_payment_option(String _paymentOption) {
		creditNotePage.select_pay_info_payment_option(_paymentOption);
	}

	@Step
	public void enter_pay_info_billing_address(String _billingAddress) {
		creditNotePage.enter_pay_info_billing_address(_billingAddress);
	}

	@Step
	public void enter_pay_info_billing_contact(String _billingContact) {
		creditNotePage.enter_pay_info_billing_contact(_billingContact);
	}
	@Step
	public void click_btn_crd_submit() {
		creditNotePage.click_btn_crd_submit();
	}

	@Step
	public void go_to_tab(String _tabName, int order) {
		creditNotePage.switch_to_tab(_tabName,order);
	}

	@Step
	public void credit_note_date(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void credit_note_justification(String lableText, String value) {
		creditNotePage.enterTextAreaWithLabel(lableText, value);
	}

	@Step
	public void amt_to_credit(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void retention_amount(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void search_project_no_on_credit_note_request_tab(String projectNo) {
		creditNotePage.search_project_no_on_credit_note_request_tab(projectNo);
	}
	
	@Step
	public void click_submit() {
		creditNotePage.click_btn_req_detail_submit();
	}

	@Step
	public void search_project_no_on_credit_note_tab(String projectNo) {
		creditNotePage.search_project_no_on_credit_note_tab(projectNo);
	}

	@Step
	public void sale_tax(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
		
	}

	@Step
	public void reference_no(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
		
	}

	@Step
	public void credit_note_category(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
		
	}

	@Step
	public void remark_to_customer(String lableText, String value) {
		creditNotePage.enterTextAreaWithLabel(lableText, value);
	}
	
	@Step
	public void payment_option(String lableText, String value) {
		creditNotePage.selectDdlWithLabelByText(lableText, value);
	}

	@Step
	public void billing_address(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void billing_contact(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void internal_remarks_code(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void external_remarks_code(String lableText, String value) {
		creditNotePage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void internal_remarks(String lableText, String value) {
		creditNotePage.enterTextAreaWithLabel(lableText, value);
	}

	@Step
	public void external_remarks(String lableText, String value) {
		creditNotePage.enterTextAreaWithLabel(lableText, value);
	}

	@Step
	public void click_summit() {
		creditNotePage.click_btn_crd_submit();
	}
}
