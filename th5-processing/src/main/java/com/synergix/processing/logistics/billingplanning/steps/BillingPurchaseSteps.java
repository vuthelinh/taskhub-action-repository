package com.synergix.processing.logistics.billingplanning.steps;

import com.synergix.processing.logistics.billingplanning.pages.BillingPurchasePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160202
 */
public class BillingPurchaseSteps extends ScenarioSteps {
	BillingPurchasePage BPPage;

	// BEGIN Logistic Billing Purchase Supplier Summary
	@Step
	public void switch_to_tab_draft() {
		BPPage.switch_to_tab_draft();
	}

	@Step
	public void filter_supplier_summary_by_supplier_code(String _supplierCode) {
		BPPage.filter_supplier_summary_by_supplier_code(_supplierCode);
	}

	@Step
	public void filter_supplier_summary_by_supplier_name(String _supplierName) {
		BPPage.filter_supplier_summary_by_supplier_name(_supplierName);
	}

	@Step
	public void click_on_no_of_shipment_vch_for_combine(int _rowIndex) {
		BPPage.click_on_no_of_shipment_vch_for_combine(_rowIndex);
	}

	@Step
	public void click_on_no_of_invoice(int _rowIndex) {
		BPPage.click_on_no_of_invoice(_rowIndex);
	}

	// END Logistic Billing Purchase Supplier Summary
	// BEGIN Logistic Billing Purchase Invoice Summary
	@Step
	public void filter_invoice_summary_by_invoice_no(String _invoiceNo) {
		BPPage.filter_invoice_summary_by_invoice_no(_invoiceNo);
	}

	@Step
	public void filter_invoice_summary_by_shipment_no(String _shipmentNo) {
		BPPage.filter_invoice_summary_by_shipment_no(_shipmentNo);
	}

	@Step
	public void filter_invoice_summary_by_purchase_order_no(String _purchaseOrderNo) {
		BPPage.filter_invoice_summary_by_purchase_order_no(_purchaseOrderNo);
	}

	@Step
	public void filter_invoice_summary_by_grn_no(String _GRNNo) {
		BPPage.filter_invoice_summary_by_grn_no(_GRNNo);
	}

	@Step
	public void filter_invoice_summary_by_created_by(String _createdBy) {
		BPPage.filter_invoice_summary_by_created_by(_createdBy);
	}

	@Step
	public void filter_invoice_summary_by_created_date(String _createdDateFrom, String _createdDateTo) {
		BPPage.filter_invoice_summary_by_created_date(_createdDateFrom, _createdDateTo);
	}

	@Step
	public void filter_invoice_summary_by_last_updated_by(String _lastUpdatedBy) {
		BPPage.filter_invoice_summary_by_last_updated_by(_lastUpdatedBy);
	}

	@Step
	public void filter_invoice_summary_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		BPPage.filter_invoice_summary_by_last_updated_date(_lastUpdatedDateFrom, _lastUpdatedDateTo);
	}

	@Step
	public void open_lbpis_invoice_no(String _invoiceNo) {
		BPPage.open_lbpis_invoice_no(_invoiceNo);
	}

	@Step
	public void open_lbpis_first_invoice_no() {
		BPPage.open_lbpis_first_invoice_no();
	}

	// END Logistic Billing Purchase Invoice Summary
	// BEGIN Logistic Billing Purchase Details
	@Step
	public String get_invoice_no() {
		return BPPage.get_invoice_no();
	}

	@Step
	public void invoice_no(String _invoiceNo) {
		System.out.println("***** INFO ***** Invoice No: " + _invoiceNo);
	}

	@Step
	public void switch_to_tab_detail() {
		BPPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_payment_information() {
		BPPage.switch_to_tab_payment_information();
	}

	@Step
	public void switch_to_tab_sales_tax_adjustment() {
		BPPage.switch_to_tab_sales_tax_adjustment();
	}

	@Step
	public void switch_to_tab_remarks() {
		BPPage.switch_to_tab_remarks();
	}

	@Step
	public void click_btn_submit() {
		BPPage.click_btn_submit();
	}

	@Step
	public void clickBtnYesOnConfirmSubmit() {
		BPPage.clickBtnYesOnConfirmSubmit();
	}

	@Step
	public void clickBtnNoOnConfirmSubmit() {
		BPPage.clickBtnNoOnConfirmSubmit();
	}

	// Header
	@Step
	public void enter_supplier_invoice_date(String _supplierInvoiceDate) {
		BPPage.enter_supplier_invoice_date(_supplierInvoiceDate);
	}

	@Step
	public void enter_posting_date(String _postingDate) {
		BPPage.enter_posting_date(_postingDate);
	}

	@Step
	public void enter_due_date(String _dueDate) {
		BPPage.enter_due_date(_dueDate);
	}

	// END Logistic Billing Purchase Invoice Summary
}
