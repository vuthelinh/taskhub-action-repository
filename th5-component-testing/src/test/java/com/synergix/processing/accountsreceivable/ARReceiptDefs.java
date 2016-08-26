package com.synergix.processing.accountsreceivable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountsreceivable.steps.ARReceiptSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class ARReceiptDefs {
	@Steps
	ARReceiptSteps onARReceiptSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	String ssReceiptNo = "ARReceiptNo";

	@When("^user create AR receipt as \"([^\"]*)\"$")
	public void user_create_AR_receipt_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "ARReceipt";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colReceiptNo = "Receipt No.";
		String colCustomer = "Customer";
		String colReceiptDate = "Receipt Date";
		String colReceiptCurrency = "Receipt Currency";
		String colExchangeRate = "Exchange Rate";
		String colReferenceNo = "Reference No.";
		String colBankDraftNo = "Bank Draft No";
		String colDepositSlipNo = "Deposit Slip No";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onARReceiptSteps.switchToDrafTab();

		for (int rowARReceipt : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String receiptNo = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colReceiptNo);
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colCustomer);
			String receiptDate = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colReceiptDate);
			String receiptCurrency = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colReceiptCurrency);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colExchangeRate);
			String referenceNo = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colReferenceNo);
			String bankDraftNo = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colBankDraftNo);
			String depositSlipNo = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colDepositSlipNo);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colSegment4);

			if (!customer.isEmpty()) {
				onARReceiptSteps.clickOnNewBtn();

				onARReceiptSteps.typeCustomer(customer);

				onARReceiptSteps.switchToHeaderTab();

				if (receiptDate.isEmpty())
					receiptDate = onARReceiptSteps.getToday();
				onARReceiptSteps.typeReceiptDate(receiptDate);

				if (!receiptCurrency.isEmpty()) {
					onARReceiptSteps.typeReceiptCurrency(receiptCurrency);
				}
				if (!exchangeRate.isEmpty()) {
					onARReceiptSteps.typeExchangeRate(exchangeRate);
				}
				if (!referenceNo.isEmpty()) {
					onARReceiptSteps.typeReferenceNo(referenceNo);
				}
				if (!bankDraftNo.isEmpty()) {
					onARReceiptSteps.typeBankDraftNo(bankDraftNo);
				}
				if (!depositSlipNo.isEmpty()) {
					onARReceiptSteps.typeDepositSlipNo(depositSlipNo);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onARReceiptSteps.setSegment(listSegment);

				isContinue = true;
				isUpdate = false;
				onARReceiptSteps.getInvoiceNo(ssReceiptNo);
			}
		}
	}

	@When("^user update AR receipt as \"([^\"]*)\"$")
	public void user_update_AR_receipt_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "ARReceiptUpdate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colReceiptNo = "Receipt No.";
		String colCustomer = "Customer";
		String colReceiptDate = "Receipt Date";
		String colReceiptCurrency = "Receipt Currency";
		String colExchangeRate = "Exchange Rate";
		String colReferenceNo = "Reference No.";
		String colBankDraftNo = "Bank Draft No";
		String colDepositSlipNo = "Deposit Slip No";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onARReceiptSteps.switchToDrafTab();

		for (int rowARReceipt : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String receiptNo = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colReceiptNo);
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colCustomer);
			String receiptDate = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colReceiptDate);
			String receiptCurrency = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colReceiptCurrency);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colExchangeRate);
			String referenceNo = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colReferenceNo);
			String bankDraftNo = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colBankDraftNo);
			String depositSlipNo = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colDepositSlipNo);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowARReceipt, colSegment4);

			if (onARReceiptSteps.searchDrafReceiptNo(receiptNo)) {
				if (!customer.isEmpty()) {
					onARReceiptSteps.typeCustomer(customer);
				}

				onARReceiptSteps.switchToHeaderTab();

				if (receiptDate.isEmpty())
					receiptDate = onARReceiptSteps.getToday();
				onARReceiptSteps.typeReceiptDate(receiptDate);

				if (!receiptCurrency.isEmpty()) {
					onARReceiptSteps.typeReceiptCurrency(receiptCurrency);
				}
				if (!exchangeRate.isEmpty()) {
					onARReceiptSteps.typeExchangeRate(exchangeRate);
				}
				if (!referenceNo.isEmpty()) {
					onARReceiptSteps.typeReferenceNo(referenceNo);
				}
				if (!bankDraftNo.isEmpty()) {
					onARReceiptSteps.typeBankDraftNo(bankDraftNo);
				}
				if (!depositSlipNo.isEmpty()) {
					onARReceiptSteps.typeDepositSlipNo(depositSlipNo);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onARReceiptSteps.setSegment(listSegment);
				isContinue = true;
				isUpdate = true;
				onARReceiptSteps.getInvoiceNo(ssReceiptNo);
			}
		}
	}

	@When("^AR receipt is added payment detail as \"([^\"]*)\"$")
	public void AR_receipt_is_added_payment_detail_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "ARReceiptDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colBankPartyCode = "Bank Party Code";
			String colBankAccountNo = "Bank Account No";
			String colPymtMethod = "Pymt Method";
			String colChequeNo = "Cheque No.";
			String colChequeDate = "Cheque Date";
			String colCustomerBank = "Customer Bank";
			String colCardType = "Card Type";
			String colInstmtCodeInstmtDesc = "Instmt Code Instmt Desc";
			String colPymtAmt = "Pymt Amt";
			String colTenderedAmt = "Tendered Amt";

			int rowIndex = 1;

			for (int rowARReceiptDetail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String bankPartyCode = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colBankPartyCode);
				String bankAccountNo = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colBankAccountNo);
				String pymtMethod = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colPymtMethod);
				String chequeNo = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colChequeNo);
				String chequeDate = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colChequeDate);
				String customerBank = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colCustomerBank);
				String cardType = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colCardType);
				String instmtCodeInstmtDesc = SessionData.getDataTbVal(
						dataTableKey, rowARReceiptDetail,
						colInstmtCodeInstmtDesc);
				String pymtAmt = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colPymtAmt);
				String tenderedAmt = SessionData.getDataTbVal(dataTableKey,
						rowARReceiptDetail, colTenderedAmt);

				onARReceiptSteps.switchToHeaderTab();

				if (!bankPartyCode.isEmpty()) {
					onARReceiptSteps.searchBankAcc(rowIndex, bankPartyCode,
							bankAccountNo);
				}
				if (!pymtMethod.isEmpty()) {
					onARReceiptSteps.choosePymtMethod(pymtMethod, rowIndex);
				}
				if (!chequeNo.isEmpty()) {
					onARReceiptSteps.typeChequeNo(chequeNo, rowIndex);
				}
				if (!chequeDate.isEmpty()) {
					onARReceiptSteps.typeChequeDate(chequeDate, rowIndex);
				}
				if (!customerBank.isEmpty()) {
					onARReceiptSteps.typeCustomerBank(customerBank, rowIndex);
				}
				if (!cardType.isEmpty()) {
					onARReceiptSteps.chooseCardType(cardType, rowIndex);
				}
				if (!instmtCodeInstmtDesc.isEmpty()) {
					onARReceiptSteps.chooseInstmtCodeInstmtDesc(
							instmtCodeInstmtDesc, rowIndex);
				}
				if (!pymtAmt.isEmpty()) {
					onARReceiptSteps.typePymtAmt(pymtAmt, rowIndex);
				}
				if (!tenderedAmt.isEmpty()) {
					onARReceiptSteps.typeTenderedAmt(tenderedAmt, rowIndex);
				}
			}
		}
	}

	@When("^AR receipt is applied as \"([^\"]*)\"$")
	public void AR_receipt_is_applied_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "ARReceiptApplied";
			SessionData.addDataTable(dataTableKey, dataTable, false);

			String colKEY = "KEY";
			String colReceiptNo = "Receipt No.";
			String colInvoiceDate = "Inv Date";
			String colDueDate = "Due Date";
			String colInvCcy = "Inv Ccy";
			String colRefNo = "Ref No.";
			String coldCrnAmtHomeAmt = "d Crn Amt Home Amt";
			String coldInvAmtHomeAmt = "d Inv Amt Home Amt";
			String colApplyFull = "Apply Full";

			for (int rowARCreditNoteApplied : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String kEY = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colKEY);
				String receiptNo = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colReceiptNo);
				String invoiceDate = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colInvoiceDate);
				String dueDate = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colDueDate);
				String invCcy = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colInvCcy);
				String refNo = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colRefNo);
				String dCrnAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, coldCrnAmtHomeAmt);
				String dInvAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, coldInvAmtHomeAmt);
				String applyFull = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colApplyFull);

				onARReceiptSteps.switchToApplicationTab();

				if (onARReceiptSteps.searchReceiptNoApplied(receiptNo)) {
					int rowIndex = 1;
					if (!dCrnAmtHomeAmt.isEmpty()) {
						onARReceiptSteps.typedCrnAmtHomeAmt(dCrnAmtHomeAmt,
								rowIndex);
					}
					if (!applyFull.isEmpty()) {
						onARReceiptSteps.typeApplyFull(rowIndex);
					}
				}
			}
		}
	}

	@When("^AR receipt is submitted$")
	public void AR_receipt_is_submitted() {
		if (isContinue) {
			onARReceiptSteps.clickOnSubmitBtn();
		}
	}

	@When("^AR receipt is applied at outstanding tab as \"([^\"]*)\"$")
	public void AR_receipt_is_applied_at_outstanding_tab_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "ARReceiptAppliedOst";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colInvNo = "Receipt No.";
			String colApplicationDate = "Application Date";

			onARReceiptSteps.switchToOutstandingTab();

			for (int rowARCreditNoteAppliedOst : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String invNo = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteAppliedOst, colInvNo);
				String applicationDate = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteAppliedOst, colApplicationDate);

				if (invNo.isEmpty())
					invNo = onARReceiptSteps.getDataWithSession(ssReceiptNo);
				if (onARReceiptSteps.searchOstCrnNo(invNo)) {
					if (applicationDate.isEmpty())
						applicationDate = onARReceiptSteps.getToday();
					onARReceiptSteps.typeApplicationDate(applicationDate);
				}
			}
		}
	}

	@When("^AR receipt is previewed with report name \"([^\"]*)\"$")
	public void AR_receipt_is_previewed_with_report_name(String reportName) {
		if (isContinue) {
			onARReceiptSteps.clickPreview(reportName);
		}
	}

	@When("^AR receipt is preview at history tab with report name \"([^\"]*)\"$")
	public void AR_receipt_is_previewed_at_history_tab_with_report_name(
			String reportName) {
		if (isContinue) {
			String invNo = onARReceiptSteps.getDataWithSession(ssReceiptNo);
			onARReceiptSteps.clickPreviewHST(invNo, reportName);
		}
	}
}
