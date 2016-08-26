package com.synergix.processing.accountspayable;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountspayable.steps.APPaymentMatchingCustomTaxInvoiceSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class APPaymentMatchingCustomTaxInvoiceDefs {
	@Steps
	APPaymentMatchingCustomTaxInvoiceSteps onAPPaymentMatchingCustomTaxInvoiceSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	@When("^user create AP payment matching custom tax invoice as \"([^\"]*)\"$")
	public void user_create_AP_payment_matching_custom_tax_invoice_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "APPaymentMatching";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colCustomTaxInvoiceNo = "Custom Tax Invoice No";
		String colBillOfLadingNo = "Bill Of Lading No.";

		for (int rowAPPaymentMatching : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String customTaxInvoiceNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentMatching, colCustomTaxInvoiceNo);
			String billOfLadingNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentMatching, colBillOfLadingNo);

			if (onAPPaymentMatchingCustomTaxInvoiceSteps
					.typeCustomTaxInvoiceNo(customTaxInvoiceNo)) {

				if (!billOfLadingNo.isEmpty()) {
					onAPPaymentMatchingCustomTaxInvoiceSteps
							.typeBillOfLadingNo(billOfLadingNo);
				}
				isContinue = true;
			}
		}
	}

	@When("^user update AP payment matching custom tax invoice as \"([^\"]*)\"$")
	public void user_update_AP_payment_matching_custom_tax_invoice_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "APPaymentMatching";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colCustomTaxInvoiceNo = "Custom Tax Invoice No";
		String colBillOfLadingNo = "Bill Of Lading No.";

		for (int rowAPPaymentMatching : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String customTaxInvoiceNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentMatching, colCustomTaxInvoiceNo);
			String billOfLadingNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentMatching, colBillOfLadingNo);

			if (onAPPaymentMatchingCustomTaxInvoiceSteps
					.typeCustomTaxInvoiceNo(customTaxInvoiceNo)) {

				if (!billOfLadingNo.isEmpty()) {
					onAPPaymentMatchingCustomTaxInvoiceSteps
							.typeUpdateBillOfLadingNo(billOfLadingNo);
				}
				isContinue = true;
			}
		}
	}

	@When("^AP payment matching custom tax invoice is added invoice as \"([^\"]*)\"$")
	public void AP_payment_matching_custom_tax_invoice_is_added_invoice_as(
			String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APPaymentMatchingDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colInvoiceNo = "Invoice No.";
			String colDel = "Del";

			int rowIndex = onAPPaymentMatchingCustomTaxInvoiceSteps
					.countRowInvoiceTb();

			for (int rowAPPaymentMatchingDetail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String invoiceNo = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentMatchingDetail, colInvoiceNo);
				String del = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentMatchingDetail, colDel);

				onAPPaymentMatchingCustomTaxInvoiceSteps.clickOnAddBtn();
				rowIndex = rowIndex + 1;
				if (!invoiceNo.isEmpty()) {
					onAPPaymentMatchingCustomTaxInvoiceSteps.typeInvoiceNo(
							invoiceNo, rowIndex);
				}
				if (del.toLowerCase().equals("y")) {
					onAPPaymentMatchingCustomTaxInvoiceSteps.chooseDel(del,
							rowIndex);
					rowIndex = rowIndex - 1;
				}
			}
		}
	}

	@When("^AP payment matching custom tax invoice is added all invoice$")
	public void AP_payment_matching_custom_tax_invoice_is_added_all_invoice() {
		if (isContinue) {
			boolean isAdd = true;
			while (isAdd) {
				onAPPaymentMatchingCustomTaxInvoiceSteps.clickOnAddBtn();
				int rowIndex = onAPPaymentMatchingCustomTaxInvoiceSteps
						.countRowInvoiceTb();
				onAPPaymentMatchingCustomTaxInvoiceSteps
						.clickOnSearchIcon(rowIndex);

				onAPPaymentMatchingCustomTaxInvoiceSteps.clickOnSearchBtn();
				if (!onAPPaymentMatchingCustomTaxInvoiceSteps.addFirstInvoice()) {
					isAdd = false;
				}
			}
		}
	}
}
