package com.synergix.processing.logistics.billingplanning.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160202
 */
public class BillingSalesPage extends TH5PageObject {
	public BillingSalesPage(WebDriver driver) {
		super(driver);
	}

	//private static final String sPageHeader = "Billing Sales";

	// BEGIN Logistic Billing Sales Customer Summary
	private String xPathPanelLBSCSummary = "//*[text()='Logistic Billing Sales Customer Summary']//ancestor::div[2]";
	//private String xPathTbLBSCSummary = "(//table[contains(@id,'outstandingPartyTable')])[1]";

	public void switch_to_tab_draft() {
		switch_to_tab("Draft");
	}

	public void set_group_by_customer(String _groupByCustomer) {
		setChkbox(xPathChkboxWithLabel("Group By Customer"), _groupByCustomer);
	}

	public void filter_customer_summary_by_customer_code(String _supplierCode) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBSCSummary, "Customer Code"), _supplierCode);
	}

	public void filter_customer_summary_by_customer_name(String _customerName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBSCSummary, "Customer Name"), _customerName);
	}

	public void click_on_no_of_invoice(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPanelLBSCSummary, "No. Of Invoice");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLBSCSummary, _rowIndex, colIndex) + "//a");
	}

	// END Logistic Billing Sales Customer Summary
	// BEGIN Logistic Billing Sales Invoice Summary
	private String xPathPanelLBSISummary = "//*[text()='Logistic Billing Sales Invoice Summary']//ancestor::div[2]";
	//private String xPathTbLBSISummary = "(//table[contains(@id,'lgArInvOstTable')])[1]";

	public void filter_invoice_summary_by_invoice_no(String _invoiceNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBSISummary, "Invoice No."), _invoiceNo);
	}

	public void filter_invoice_summary_by_shipment_no(String _shipmentNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBSISummary, "Shipment No."), _shipmentNo);
	}

	public void filter_invoice_summary_by_do_no(String _DONo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBSISummary, "DO No."), _DONo);
	}

	public void filter_invoice_summary_by_created_by(String _createdBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBSISummary, "Created By"), _createdBy);
	}

	public void filter_invoice_summary_by_created_date(String _createdDateFrom, String _createdDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelLBSISummary, "Created Date From To"), _createdDateFrom,
				_createdDateTo);
	}

	public void filter_invoice_summary_by_last_updated_by(String _lastUpdatedBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLBSISummary, "Last Updated By"), _lastUpdatedBy);
	}

	public void filter_invoice_summary_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelLBSISummary, "Created Date From To"), _lastUpdatedDateFrom,
				_lastUpdatedDateTo);
	}

	public void open_lbsis_invoice_no(String _invoiceNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelLBSISummary, "Invoice No.", 1, _invoiceNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelLBSISummary, "Invoice No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLBSISummary, rowIndex, headerIndex) + "//a");
	}

	public void open_lbsis_first_invoice_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelLBSISummary, "Invoice No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLBSISummary, 1, headerIndex) + "//a");
	}
	// END Logistic Billing Sales Invoice Summary

	// BEGIN Logistic Billing Sales Details
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

	public void switch_to_tab_attachments() {
		switch_to_tab("Attachments");
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
	//private String xPathPanelLBPDetails = "//*[text()='Logistic Billing Sales Details']//ancestor::span[@id='mainPanel']";
	// END Logistic Billing Sales Details
}
