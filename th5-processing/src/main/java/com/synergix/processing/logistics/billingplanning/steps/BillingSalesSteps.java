package com.synergix.processing.logistics.billingplanning.steps;

import com.synergix.processing.logistics.billingplanning.pages.BillingSalesPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160202
 */
public class BillingSalesSteps extends ScenarioSteps {
	BillingSalesPage BSPage;

	// BEGIN Logistic Billing Sales Customer Summary
	@Step
	public void switch_to_tab_draft() {
		BSPage.switch_to_tab_draft();
	}

	@Step
	public void set_group_by_customer(String _groupByCustomer) {
		BSPage.set_group_by_customer(_groupByCustomer);
	}

	@Step
	public void filter_customer_summary_by_customer_code(String _supplierCode) {
		BSPage.filter_customer_summary_by_customer_code(_supplierCode);
	}

	@Step
	public void filter_customer_summary_by_customer_name(String _customerName) {
		BSPage.filter_customer_summary_by_customer_name(_customerName);
	}

	@Step
	public void click_on_no_of_invoice(int _rowIndex) {
		BSPage.click_on_no_of_invoice(_rowIndex);
	}

	// END Logistic Billing Sales Customer Summary
	// BEGIN Logistic Billing Sales Invoice Summary
	@Step
	public void filter_invoice_summary_by_invoice_no(String _invoiceNo) {
		BSPage.filter_invoice_summary_by_invoice_no(_invoiceNo);
	}

	@Step
	public void filter_invoice_summary_by_shipment_no(String _shipmentNo) {
		BSPage.filter_invoice_summary_by_shipment_no(_shipmentNo);
	}

	@Step
	public void filter_invoice_summary_by_do_no(String _DONo) {
		BSPage.filter_invoice_summary_by_do_no(_DONo);
	}

	@Step
	public void filter_invoice_summary_by_created_by(String _createdBy) {
		BSPage.filter_invoice_summary_by_created_by(_createdBy);
	}

	@Step
	public void filter_invoice_summary_by_created_date(String _createdDateFrom, String _createdDateTo) {
		BSPage.filter_invoice_summary_by_created_date(_createdDateFrom, _createdDateTo);
	}

	@Step
	public void filter_invoice_summary_by_last_updated_by(String _lastUpdatedBy) {
		BSPage.filter_invoice_summary_by_last_updated_by(_lastUpdatedBy);
	}

	@Step
	public void filter_invoice_summary_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		BSPage.filter_invoice_summary_by_last_updated_date(_lastUpdatedDateFrom, _lastUpdatedDateTo);
	}

	@Step
	public void open_lbsis_invoice_no(String _invoiceNo) {
		BSPage.open_lbsis_invoice_no(_invoiceNo);
	}

	@Step
	public void open_lbsis_first_invoice_no() {
		BSPage.open_lbsis_first_invoice_no();
	}
	// END Logistic Billing Sales Invoice Summary

	// BEGIN Logistic Billing Sales Details
	@Step
	public String get_invoice_no() {
		return BSPage.get_invoice_no();
	}

	@Step
	public void invoice_no(String _invoiceNo) {
		System.out.println("***** INFO ***** Invoice No: " + _invoiceNo);
	}
	@Step
	public void switch_to_tab_detail() {
		BSPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_payment_information() {
		BSPage.switch_to_tab_payment_information();
	}

	@Step
	public void switch_to_tab_sales_tax_adjustment() {
		BSPage.switch_to_tab_sales_tax_adjustment();
	}

	@Step
	public void switch_to_tab_remarks() {
		BSPage.switch_to_tab_remarks();
	}

	@Step
	public void switch_to_tab_attachments() {
		BSPage.switch_to_tab_attachments();
	}

	@Step
	public void click_btn_submit() {
		BSPage.click_btn_submit();
	}

	@Step
	public void clickBtnYesOnConfirmSubmit() {
		BSPage.clickBtnYesOnConfirmSubmit();
	}

	@Step
	public void clickBtnNoOnConfirmSubmit() {
		BSPage.clickBtnNoOnConfirmSubmit();
	}
	// END Logistic Billing Sales Details

}
