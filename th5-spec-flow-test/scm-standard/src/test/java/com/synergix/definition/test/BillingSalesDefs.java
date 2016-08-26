package com.synergix.definition.test;

import java.util.List;

import com.synergix.processing.logistics.billingplanning.steps.BillingSalesSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class BillingSalesDefs {
	private final static String SV_NO = "Shipment Voucher No";
	private final static String I_NO = "Invoice No";
	// private final static String DO_NO = "DO No";
	@Steps
	BillingSalesSteps BSSteps;

	@Then("^user selects No of Invoice in Logistic Billing Sales Customer Summary as \"([^\"]*)\"$")
	public void user_selects_No_of_Invoice_in_Logistic_Billing_Sales_Customer_Summary_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		BSSteps.switch_to_tab_draft();
		SessionData.addDataTable("LBSCS_NO_OF_INVOICE", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LBSCS_NO_OF_INVOICE", "KEY", dataKey).keySet()) {
			String sCustomerCode = SessionData.getDataTbVal("LBSCS_NO_OF_INVOICE", row, "Customer Code");
			String sCustomerName = SessionData.getDataTbVal("LBSCS_NO_OF_INVOICE", row, "Customer Name");
			if (!sCustomerCode.isEmpty()) {
				BSSteps.filter_customer_summary_by_customer_code(sCustomerCode);
			}
			if (!sCustomerName.isEmpty()) {
				BSSteps.filter_customer_summary_by_customer_name(sCustomerName);
			}
			if (!sCustomerCode.isEmpty() || !sCustomerName.isEmpty()) {
				BSSteps.click_on_no_of_invoice(1);
			}
		}
	}

	@Then("^user opens and submits created Invoice No\\. in Logistic Billing Sales Details$")
	public void user_opens_and_submits_created_Invoice_No_in_Logistic_Billing_Sales_Details() throws Throwable {
		BSSteps.filter_invoice_summary_by_shipment_no(SessionData.getListStringLastValue(SV_NO));
		BSSteps.open_lbsis_first_invoice_no();
		SessionData.addToListString(I_NO, BSSteps.get_invoice_no());
		BSSteps.invoice_no(SessionData.getListStringLastValue(I_NO).toString());
		BSSteps.click_btn_submit();
	}

	@Then("^user opens and submits created Invoice No\\. in Logistic Billing Sales Details by (\\d+) before last created Shipment Voucher No$")
	public void user_opens_and_submits_created_Invoice_No_in_Logistic_Billing_Sales_Details_by_before_last_created_Shipment_Voucher_No(
			int arg1) throws Throwable {
		BSSteps.filter_invoice_summary_by_shipment_no(SessionData.getListStringByIndex(SV_NO, -arg1));
		BSSteps.open_lbsis_first_invoice_no();
		SessionData.addToListString(I_NO, BSSteps.get_invoice_no());
		BSSteps.invoice_no(SessionData.getListStringLastValue(I_NO).toString());
		BSSteps.click_btn_submit();
	}
}
