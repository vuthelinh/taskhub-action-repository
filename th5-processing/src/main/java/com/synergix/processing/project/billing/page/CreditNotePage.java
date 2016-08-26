package com.synergix.processing.project.billing.page;

import com.synergix.common.TH5PageObject;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CreditNotePage extends TH5PageObject {
	public CreditNotePage(WebDriver driver) {
		super(driver);
	}

	private static final String sPageHeader = "Credit Note for Billing by Project/Phase and Direct Billing";
	private static final String xPathPanelCreditNoteReqSummany = "//table[contains(@id,'creditNoteRequestSummary')]//ancestor-or-self::form";
	private static final String xPathPanelCreditNoteReq = "//span[contains(@id,'cnrButtonPanel')]//ancestor-or-self::form[1]";
	private static final String xPathTbBillingByProject = "//span[contains(@id,'billingByProject')]";

	// Credit Note Credit Note Request
	public void click_btn_req_close_in_summany() {
		clickBtn(xPathPanelCreditNoteReqSummany, "Close");
	}

	public void filter_req_data_by_project_no(String _projectNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelCreditNoteReqSummany, "Project No."), _projectNo);
	}

	public int get_req_credit_note_row_by_project_no(String _projectNo) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathPanelCreditNoteReqSummany, _projectNo, 1, "Project No.", 1));
	}

	public void click_on_req_credit_note_by_project_no(String _projectNo) {
		clickBtn(xPathTbDataCellByPosition(xPathPanelCreditNoteReqSummany,
				get_req_credit_note_row_by_project_no(_projectNo),
				getTbColHeaderIndex(xPathPanelCreditNoteReqSummany, "-")), "Credit Note");
	}

	// Credit Note Request Detail
	public void click_btn_req_detail_close() {
		clickBtn(xPathPanelCreditNoteReq, "Close");
	}

	public void click_btn_req_detail_abort() {
		clickBtn(xPathPanelCreditNoteReq, "Abort");
	}

	public void click_btn_req_detail_submit() {
		clickBtn(xPathPanelCreditNoteReq, "Submit");
		clickBtnYesOnConfirmSubmit();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}

	private String xPathPanelConfirmSubmit = "//div[text()='Submit Confirmation' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void clickBtnNoOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void get_req_detail_project_no() {
		// TODOLATER
	}

	public void get_req_detail_customer_name() {
		// TODOLATER
	}

	public void get_req_detail_customer_job_no() {
		// TODOLATER
	}

	public void enter_req_detail_credit_note_date(String _creditNoteDate) {
		enterInputFieldWithLabel("Credit Note Date", _creditNoteDate);
	}

	public void get_req_detail_currency() {
		// TODOLATER
	}

	public void get_req_detail_subject() {
		// TODOLATER
	}

	public void enter_req_detail_credit_note_justification(String _creditNoteJustification) {
		enterTextAreaWithLabel("Credit Note Justification", _creditNoteJustification);
	}

	public void enter_req_amt_to_credit_amount(String _amtToCreditAmount) {
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbBillingByProject, 1,
				getTbColHeaderIndex(xPathTbBillingByProject, "Amount", 4)) + "//input", _amtToCreditAmount);
	}

	public String get_req_retention_max_retention_amount_amount() {
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbBillingByProject, 2,
				getTbColHeaderIndex(xPathTbBillingByProject, "Amount", 4)) + "//input").getValue();
	}

	public String get_req_total_before_tax_amount_amount() {
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbBillingByProject, 3,
				getTbColHeaderIndex(xPathTbBillingByProject, "Amount", 4))).getText();
	}

	public void switch_to_tab_credit_note_request() {
		switch_to_tab("Credit Note Request");
	}

	// Credit Note
	private static final String xPathTbCreditNoteSummary = "//table[contains(@id,'creditNoteSummary')]";

	public void click_btn_crd_submit() {
		clickBtn("Submit");
		clickBtnYesOnConfirmSubmit();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}

	public void switch_to_tab_credit_note() {
		switch_to_tab("Credit Note", 2);
	}

	public void filter_crd_note_data_by_project_no(String _projectNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbCreditNoteSummary, "Project No."), _projectNo);
	}

	public int get_credit_note_row_by_project_no(String _projectNo) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathTbCreditNoteSummary, _projectNo, 1, "Project No.", 1));
	}

	public void click_on_credit_node_no_by_project_no(String _projectNo) {
		waitElementToBeClickable(
				xPathTbDataCellByPosition(xPathTbCreditNoteSummary, get_credit_note_row_by_project_no(_projectNo),
						getTbColHeaderIndex(xPathTbCreditNoteSummary, "Credit Note No")) + "//a").click();
	}

	public void switch_to_tab_draft() {
		switch_to_tab("Draft");
	}

	public void switch_to_tab_history() {
		switch_to_tab("History");
	}

	public void switch_to_tab_header() {
		switch_to_tab("Header");
	}

	public void switch_to_tab_payment_info() {
		switch_to_tab("Payment Info");
	}

	// Credit Note Header
	public void enter_header_credit_note_date(String _creditNoteDate) {
		enterInputFieldWithLabel("Credit Note Date", _creditNoteDate);
	}

	public void enter_header_sale_tax(String _saleTax) {
		enterInputFieldWithLabel("Sale Tax", _saleTax);
	}

	public void enter_header_credit_note_category(String _creditNoteCategory) {
		enterInputFieldWithLabel("Credit Note Category", _creditNoteCategory);
	}

	// public String get_header_customer_po_no() {
	// return getTextWithLabel("Customer PO No.");
	// }
	// public String get_pay_info_billing_party(String _billingParty) {
	// return getTextWithLabel("Billing Party");
	// }
	public void enter_header_reference_no(String _referenceNo) {
		enterInputFieldWithLabel("Reference No.", _referenceNo);
	}

	public void enter_header_remark_to_customer(String _remarkToCustomer) {
		enterTextAreaWithLabel("Remark To Customer", _remarkToCustomer);
	}

	public void enter_header_exchange_rate(String _exchangeRate) {
		enterInputFieldWithLabel("Exchange Rate", _exchangeRate);
	}

	// Credit Note Payment Info
	public void select_pay_info_payment_option(String _paymentOption) {
		selectDdlWithLabelByText("Payment Option", _paymentOption);
	}

	public void enter_pay_info_billing_address(String _billingAddress) {
		enterInputFieldWithLabel("Billing Address", _billingAddress);
	}

	public void enter_pay_info_billing_contact(String _billingContact) {
		enterInputFieldWithLabel("Billing Contact", _billingContact);
	}

	public void search_project_no_on_credit_note_request_tab(String projectNo) {
		filterDataByHeader(xPathTbHeaderCell("//*[contains(@id,'creditNoteRequestSummary')]", "Project No."), projectNo);
		waitForAllJSCompletes();
		$("//tr[1]/td[11]/a | //tr[1]/td[11]/input").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void search_project_no_on_credit_note_tab(String projectNo) {
		filterDataByHeader(xPathTbHeaderCell("//*[contains(@id,'creditNoteSummaryForm:creditNoteSummary')]", "Project No."), projectNo);
		waitForAllJSCompletes();
		$("//tr[1]/td[1]/a").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

}
