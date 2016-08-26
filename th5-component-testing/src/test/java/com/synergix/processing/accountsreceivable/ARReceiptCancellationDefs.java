package com.synergix.processing.accountsreceivable;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountsreceivable.steps.ARReceiptCancellationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class ARReceiptCancellationDefs {
	@Steps
	ARReceiptCancellationSteps onARReceiptCancellationSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	String ssARRcpCancel = "ARRcpCancel";

	@When("^user create AR receipt cancellation as \"([^\"]*)\"$")
	public void user_create_AR_receipt_cancellation_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "ARRcpCancel";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colReceiptCancellationNo = "Receipt Cancellation No";
		String colReceiptCancellationDate = "Receipt Cancellation Date";
		String colCustomer = "Customer";
		String colChequeNo = "Cheque No.";
		String colReceiptNo = "Receipt No";
		String colCancellationType = "Cancellation Type";

		for (int rowARRcpCancel : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String receiptCancellationNo = SessionData.getDataTbVal(
					dataTableKey, rowARRcpCancel, colReceiptCancellationNo);
			String receiptCancellationDate = SessionData.getDataTbVal(
					dataTableKey, rowARRcpCancel, colReceiptCancellationDate);
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancel, colCustomer);
			String chequeNo = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancel, colChequeNo);
			String receiptNo = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancel, colReceiptNo);
			String cancellationType = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancel, colCancellationType);

			onARReceiptCancellationSteps.clickOnNewBtn();

			if (!receiptCancellationDate.isEmpty())
				receiptCancellationDate = onARReceiptCancellationSteps
						.getToday();
			onARReceiptCancellationSteps
					.typeReceiptCancellationDate(receiptCancellationDate);

			if (!customer.isEmpty()) {
				onARReceiptCancellationSteps.typeCustomer(customer);
			}
			if (!chequeNo.isEmpty()) {
				onARReceiptCancellationSteps.typeChequeNo(chequeNo);
			}

			onARReceiptCancellationSteps.typeReceiptNo(receiptNo);

			if (!cancellationType.isEmpty()) {
				onARReceiptCancellationSteps
						.chooseCancellationType(cancellationType);
			}
			isContinue = true;
			onARReceiptCancellationSteps.getInvoiceNo(ssARRcpCancel);
		}
	}

	@When("^user update AR receipt cancellation as \"([^\"]*)\"$")
	public void user_update_AR_receipt_cancellation_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "ARRcpCancel";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colReceiptCancellationNo = "Receipt Cancellation No";
		String colReceiptCancellationDate = "Receipt Cancellation Date";
		String colCustomer = "Customer";
		String colChequeNo = "Cheque No.";
		String colReceiptNo = "Receipt No";
		String colCancellationType = "Cancellation Type";

		for (int rowARRcpCancel : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String receiptCancellationNo = SessionData.getDataTbVal(
					dataTableKey, rowARRcpCancel, colReceiptCancellationNo);
			String receiptCancellationDate = SessionData.getDataTbVal(
					dataTableKey, rowARRcpCancel, colReceiptCancellationDate);
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancel, colCustomer);
			String chequeNo = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancel, colChequeNo);
			String receiptNo = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancel, colReceiptNo);
			String cancellationType = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancel, colCancellationType);

			if (onARReceiptCancellationSteps
					.searchDrafRcpCancelNo(receiptCancellationNo)) {
				if (!receiptCancellationDate.isEmpty()) {
					onARReceiptCancellationSteps
							.typeReceiptCancellationDate(receiptCancellationDate);
				}
				if (!customer.isEmpty()) {
					onARReceiptCancellationSteps.typeCustomer(customer);
				}
				if (!chequeNo.isEmpty()) {
					onARReceiptCancellationSteps.typeChequeNo(chequeNo);
				}
				if (!receiptNo.isEmpty()) {
					onARReceiptCancellationSteps.typeReceiptNo(receiptNo);
				}
				if (!cancellationType.isEmpty()) {
					onARReceiptCancellationSteps
							.chooseCancellationType(cancellationType);
				}
				isContinue = true;
				onARReceiptCancellationSteps.getInvoiceNo(ssARRcpCancel);
			}
		}
	}

	@When("^AR receipt is wrong application to invoice as \"([^\"]*)\"$")
	public void AR_receipt_is_wrong_application_to_invoice_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "ARRcpCancelInv";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colInvNo = "Inv No.";

		for (int rowARRcpCancelInv : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String invNo = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancelInv, colInvNo);

			onARReceiptCancellationSteps.chooseInvNo(invNo);
		}
	}

	@When("^AR receipt is wrong customer as \"([^\"]*)\"$")
	public void AR_receipt_is_wrong_customer_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "ARRcpCancelCus";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colNewCustomer = "New Customer";

		for (int rowARRcpCancelCus : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String newCustomer = SessionData.getDataTbVal(dataTableKey,
					rowARRcpCancelCus, colNewCustomer);
			if (!newCustomer.isEmpty()) {
				onARReceiptCancellationSteps.typeNewCustomer(newCustomer);
			}
		}
	}

	@When("^AR receipt cancellation is submitted$")
	public void AR_receipt_cancellation_is_submitted() {
		if (isContinue) {
			onARReceiptCancellationSteps.clickOnSubmitBtn();
		}
	}

	@When("^AR receipt cancellation is previewed with report name \"([^\"]*)\"$")
	public void AR_receipt_cancellation_is_previewed_with_report_name(
			String reportName) {
		if (isContinue) {
			onARReceiptCancellationSteps.clickPreview(reportName);
		}
	}

	@When("^AR receipt cancellation is preview at history tab with report name \"([^\"]*)\"$")
	public void AR_receipt_cancellation_is_previewed_at_history_tab_with_report_name(
			String reportName) {
		if (isContinue) {
			String invNo = onARReceiptCancellationSteps
					.getDataWithSession(ssARRcpCancel);
			onARReceiptCancellationSteps.clickPreviewHST(invNo, reportName);
		}
	}
}
