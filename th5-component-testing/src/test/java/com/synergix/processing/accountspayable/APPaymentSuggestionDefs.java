package com.synergix.processing.accountspayable;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountspayable.steps.APPaymentSuggestionSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class APPaymentSuggestionDefs {
	@Steps
	APPaymentSuggestionSteps onAPPaymentSuggestionSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	@When("^user create AP payment suggestion as \"([^\"]*)\"$")
	public void user_create_AP_payment_suggestion_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APPaymentSuggestion";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYPYTS = "KEY PYT S";
		String colBankPartyCode = "Bank Party Code";
		String colBankAccountNo = "Bank Account No";
		String colSelectSupplier = "Select Supplier";
		String colSupplierClassFrom = "Supplier Class From";
		String colCurrencyFrom = "Currency From";
		String colInvoiceDateFrom = "Invoice Date From";
		String colDueDateFrom = "Due Date From";
		String colGracePeriod = "Grace Period";
		String colExchRate = "Exch Rate";
		String colIncludeNonOverdue = "Include Non Overdue";
		String colSupplierClassTo = "Supplier Class To";
		String colCurrencyTo = "Currency To";
		String colInvoiceDateTo = "Invoice Date To";
		String colDueDateTo = "Due Date To";

		for (int rowAPPaymentSuggestion : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYPYTS, dataKey)
				.keySet()) {
			String bankPartyCode = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colBankPartyCode);
			String bankAccountNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colBankAccountNo);
			String selectSupplier = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colSelectSupplier);
			String supplierClassFrom = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colSupplierClassFrom);
			String currencyFrom = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colCurrencyFrom);
			String invoiceDateFrom = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colInvoiceDateFrom);
			String dueDateFrom = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colDueDateFrom);
			String gracePeriod = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colGracePeriod);
			String exchRate = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colExchRate);
			String includeNonOverdue = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colIncludeNonOverdue);
			String supplierClassTo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colSupplierClassTo);
			String currencyTo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colCurrencyTo);
			String invoiceDateTo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colInvoiceDateTo);
			String dueDateTo = SessionData.getDataTbVal(dataTableKey,
					rowAPPaymentSuggestion, colDueDateTo);

			if (onAPPaymentSuggestionSteps.searchBankAccount(bankPartyCode,
					bankAccountNo)) {
				if (!selectSupplier.isEmpty()) {
					onAPPaymentSuggestionSteps
							.typeSelectSupplier(selectSupplier);
				}
				if (!supplierClassFrom.isEmpty()) {
					onAPPaymentSuggestionSteps
							.typeSupplierClassFrom(supplierClassFrom);
				}
				if (!currencyFrom.isEmpty()) {
					onAPPaymentSuggestionSteps.typeCurrencyFrom(currencyFrom);
				}
				if (!invoiceDateFrom.isEmpty()) {
					onAPPaymentSuggestionSteps
							.typeInvoiceDateFrom(invoiceDateFrom);
				}
				if (!dueDateFrom.isEmpty()) {
					onAPPaymentSuggestionSteps.typeDueDateFrom(dueDateFrom);
				}
				if (!gracePeriod.isEmpty()) {
					onAPPaymentSuggestionSteps.typeGracePeriod(gracePeriod);
				}
				if (!exchRate.isEmpty()) {
					onAPPaymentSuggestionSteps.typeExchRate(exchRate);
				}
				if (!includeNonOverdue.isEmpty()) {
					onAPPaymentSuggestionSteps
							.typeIncludeNonOverdue(includeNonOverdue);
				}
				if (!supplierClassTo.isEmpty()) {
					onAPPaymentSuggestionSteps
							.chooseSupplierClassTo(supplierClassTo);
				}
				if (!currencyTo.isEmpty()) {
					onAPPaymentSuggestionSteps.typeCurrencyTo(currencyTo);
				}
				if (!invoiceDateTo.isEmpty()) {
					onAPPaymentSuggestionSteps.typeInvoiceDateTo(invoiceDateTo);
				}
				if (!dueDateTo.isEmpty()) {
					onAPPaymentSuggestionSteps.typeDueDateTo(dueDateTo);
				}
				onAPPaymentSuggestionSteps.clickOnViewBtn();
				isContinue = true;
			}
		}
	}

	@When("^user update AP payment suggestion as \"([^\"]*)\"$")
	public void user_update_AP_payment_suggestion_as(String dataKey,
			List<List<String>> dataTable) {

	}

	@When("^AP payment suggestion is submitted all$")
	public void AP_payment_suggestion_is_submitted_all() {
		if (isContinue) {
			onAPPaymentSuggestionSteps.clickOnSubmitAllInvoice();
		}
	}

	@When("^AP payment suggestion is submitted with detail invoice as \"([^\"]*)\"$")
	public void AP_payment_suggestion_is_submitted_with_detail_invoice_as(
			String dataKey, List<List<String>> dataTable) {

	}
}
