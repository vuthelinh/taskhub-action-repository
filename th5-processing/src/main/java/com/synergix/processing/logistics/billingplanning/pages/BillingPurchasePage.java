package com.synergix.processing.logistics.billingplanning.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160202
 */
public class BillingPurchasePage extends TH5PageObject {
	public BillingPurchasePage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Billing Purchase";

	// BEGIN Logistic Billing Purchase Supplier Summary
	private String xPathPanelLBPSSummary = "//*[text()='Logistic Billing Purchase Supplier Summary']//ancestor::div[2]";
	// private String xPathTbLBPSSummary =
	// "(//table[contains(@id,'outstandingPartyTable')])[1]";

	public void switch_to_tab_draft() {
		switch_to_tab("Draft");
	}

	public void filter_supplier_summary_by_supplier_code(String _supplierCode) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBPSSummary, "Supplier Code"), _supplierCode);
	}

	public void filter_supplier_summary_by_supplier_name(String _supplierName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBPSSummary, "Supplier Name"), _supplierName);
	}

	public void click_on_no_of_shipment_vch_for_combine(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPanelLBPSSummary, "No. Of Shipment Vch for Combine");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLBPSSummary, _rowIndex, colIndex) + "//a");
	}

	public void click_on_no_of_invoice(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPanelLBPSSummary, "No. Of Invoice");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLBPSSummary, _rowIndex, colIndex) + "//a");
	}

	// END Logistic Billing Purchase Supplier Summary
	// BEGIN Logistic Billing Purchase Invoice Summary
	private String xPathPanelLBPISummary = "//*[text()='Logistic Billing Purchase Invoice Summary']//ancestor::div[2]";
	// private String xPathTbLBPISummary =
	// "(//table[contains(@id,'lgApInvOstTable')])[1]";

	public void filter_invoice_summary_by_invoice_no(String _invoiceNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBPISummary, "Invoice No."), _invoiceNo);
	}

	public void filter_invoice_summary_by_shipment_no(String _shipmentNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBPISummary, "Shipment No."), _shipmentNo);
	}

	public void filter_invoice_summary_by_purchase_order_no(String _purchaseOrderNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBPISummary, "Purchase Order No."), _purchaseOrderNo);
	}

	public void filter_invoice_summary_by_grn_no(String _GRNNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBPISummary, "GRN No."), _GRNNo);
	}

	public void filter_invoice_summary_by_created_by(String _createdBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBPISummary, "Created By"), _createdBy);
	}

	public void filter_invoice_summary_by_created_date(String _createdDateFrom, String _createdDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelLBPISummary, "Created Date From To"), _createdDateFrom,
				_createdDateTo);
	}

	public void filter_invoice_summary_by_last_updated_by(String _lastUpdatedBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBPISummary, "Last Updated By"), _lastUpdatedBy);
	}

	public void filter_invoice_summary_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelLBPISummary, "Created Date From To"), _lastUpdatedDateFrom,
				_lastUpdatedDateTo);
	}

	public void open_lbpis_invoice_no(String _invoiceNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelLBPISummary, "Invoice No.", 1, _invoiceNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelLBPISummary, "Invoice No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLBPISummary, rowIndex, headerIndex) + "//a");
	}

	public void open_lbpis_first_invoice_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelLBPISummary, "Invoice No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLBPISummary, 1, headerIndex) + "//a");
	}
	// END Logistic Billing Purchase Invoice Summary

	// BEGIN Logistic Billing Purchase Details
	public String get_invoice_no() {
		return getTextWithLabel("Invoice No.", 2);
	}

	public void switch_to_tab_detail() {
		switch_to_tab("Detail");
	}

	public void switch_to_tab_payment_information() {
		switch_to_tab("Payment Information");
	}

	public void switch_to_tab_sales_tax_adjustment() {
		switch_to_tab("Sales Tax Adjustment");
	}

	public void switch_to_tab_remarks() {
		switch_to_tab("Remarks");
	}

	public void click_btn_submit() {
		clickBtn("Submit");
		clickBtnYesOnConfirmSubmit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelConfirmSubmit = "//div[" + sSpecialTextPredicates("You Are About To Submit This Invoice")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

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

	// Header
	// private String xPathPanelLBPDetails = "//*[text()='Logistic Billing
	// Purchase Details']//ancestor::span[@id='mainPanel']";

	public void enter_supplier_invoice_date(String _supplierInvoiceDate) {
		if (_supplierInvoiceDate.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Supplier Invoice Date");
		} else {
			enterInputFieldWithLabel("Supplier Invoice Date", _supplierInvoiceDate);
		}
	}

	public void enter_posting_date(String _postingDate) {
		if (_postingDate.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Posting Date");
		} else {
			enterInputFieldWithLabel("Posting Date", _postingDate);
		}
	}

	public void enter_due_date(String _dueDate) {
		if (_dueDate.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Due Date");
		} else {
			enterInputFieldWithLabel("Due Date", _dueDate);
		}
	}
	// END Logistic Billing Purchase Invoice Summary
}
