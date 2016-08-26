package com.synergix.definition.test;

import java.util.List;

import com.synergix.processing.logistics.billingplanning.steps.BillingPurchaseSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class BillingPurchaseDefs {
	private final static String SV_NO = "Shipment Voucher No";
	private final static String PO_NO = "Purchase Order No";
	private final static String I_NO = "Invoice No";
	// private final static String DO_NO = "DO No";
	@Steps
	BillingPurchaseSteps BPSteps;

	@Then("^user selects No\\. of Invoice in Logistic Billing Purchase Supplier Summary as \"([^\"]*)\"$")
	public void user_selects_No_of_Invoice_in_Logistic_Billing_Purchase_Supplier_Summary_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		BPSteps.switch_to_tab_draft();
		SessionData.addDataTable("LBPSS_NO_OF_INVOICE", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LBPSS_NO_OF_INVOICE", "KEY", dataKey).keySet()) {
			String sSupplierCode = SessionData.getDataTbVal("LBPSS_NO_OF_INVOICE", row, "Supplier Code");
			String sSupplierName = SessionData.getDataTbVal("LBPSS_NO_OF_INVOICE", row, "Supplier Name");
			if (!sSupplierCode.isEmpty()) {
				BPSteps.filter_supplier_summary_by_supplier_code(sSupplierCode);
			}
			if (!sSupplierName.isEmpty()) {
				BPSteps.filter_supplier_summary_by_supplier_name(sSupplierName);
			}
			if (!sSupplierCode.isEmpty() || !sSupplierName.isEmpty()) {
				BPSteps.click_on_no_of_invoice(1);
			}
		}
	}

	@Then("^user opens created Invoice No\\. in Logistic Billing Purchase Details by (\\d+) before last created Shipment Voucher No$")
	public void user_opens_created_Invoice_No_in_Logistic_Billing_Purchase_Details_by_before_last_created_Shipment_Voucher_No(
			int arg1) throws Throwable {
		BPSteps.filter_invoice_summary_by_shipment_no(SessionData.getListStringByIndex(SV_NO, -arg1));
		BPSteps.open_lbpis_first_invoice_no();
		SessionData.addToListString(I_NO, BPSteps.get_invoice_no());
		BPSteps.invoice_no(SessionData.getListStringLastValue(I_NO).toString());
	}

	@Then("^user opens created Invoice No\\. in Logistic Billing Purchase Details$")
	public void user_opens_created_Invoice_No_in_Logistic_Billing_Purchase_Details() throws Throwable {
		BPSteps.filter_invoice_summary_by_shipment_no(SessionData.getListStringLastValue(SV_NO));
		BPSteps.open_lbpis_first_invoice_no();
		SessionData.addToListString(I_NO, BPSteps.get_invoice_no());
		BPSteps.invoice_no(SessionData.getListStringLastValue(I_NO).toString());
	}

	@Then("^user opens created Invoice No\\. in Logistic Billing Purchase Details by created Purchase Order No$")
	public void user_opens_created_Invoice_No_in_Logistic_Billing_Purchase_Details_by_created_Purchase_Order_No()
			throws Throwable {
		BPSteps.filter_invoice_summary_by_purchase_order_no(SessionData.getListStringLastValue(PO_NO));
		BPSteps.open_lbpis_first_invoice_no();
		SessionData.addToListString(I_NO, BPSteps.get_invoice_no());
		BPSteps.invoice_no(SessionData.getListStringLastValue(I_NO).toString());
	}

	@Then("^user inputs data for created Invoice No\\. in Logistic Billing Purchase Details as \"([^\"]*)\"$")
	public void user_inputs_data_for_created_Invoice_No_in_Logistic_Billing_Purchase_Details_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("LBPD_HEADER", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LBPD_HEADER", "KEY", dataKey).keySet()) {
			String sSupplierInvoiceDate = SessionData.getDataTbVal("LBPD_HEADER", row, "Supplier Invoice Date");
			if (!sSupplierInvoiceDate.isEmpty()) {
				BPSteps.enter_supplier_invoice_date(sSupplierInvoiceDate);
			}
		}
	}

	@Then("^user submits created Invoice No\\. in Logistic Billing Purchase Details$")
	public void user_submits_created_Invoice_No_in_Logistic_Billing_Purchase_Details() throws Throwable {
		BPSteps.click_btn_submit();
	}

}
