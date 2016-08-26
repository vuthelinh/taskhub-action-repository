package com.synergix.processing.accountspayable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountspayable.steps.APPaymentToCustomerSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class APPaymentToCustomerDefs {
	@Steps
	APPaymentToCustomerSteps onAPPaymentToCustomerSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	private String ssPymtToCusNo = "PymtToCusNo";

	@When("^user update AP payment to customer as \"([^\"]*)\"$")
	public void user_update_AP_payment_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APPymtCusUpdate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYPAYMENT = "KEY";
		String colPaymentVoucherNumber = "Payment Voucher Number";
		String colCustomer = "Customer";
		String colPaymentVoucherDate = "Payment Voucher Date";
		String colBankPartyCode = "Bank Party Code";
		String colBankAccountNo = "Bank Account No";
		String colChequeDate = "Cheque Date";
		String colChequeNo = "Cheque No.";
		String colBankDraftNo = "Bank Draft No";
		String colPayeeName = "Payee Name";
		String colExchangeRate = "Exchange Rate";
		String colChequeAmount = "Cheque Amount";
		String colRefNo = "Ref No.";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowAPPayment : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEYPAYMENT, dataKey).keySet()) {
			String paymentVoucherNumber = SessionData.getDataTbVal(
					dataTableKey, rowAPPayment, colPaymentVoucherNumber);
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colCustomer);
			String paymentVoucherDate = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colPaymentVoucherDate);
			String bankPartyCode = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colBankPartyCode);
			String bankAccountNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colBankAccountNo);
			String chequeDate = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colChequeDate);
			String chequeNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colChequeNo);
			String bankDraftNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colBankDraftNo);
			String payeeName = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colPayeeName);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colExchangeRate);
			String chequeAmount = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colChequeAmount);
			String refNo = SessionData.getDataTbVal(dataTableKey, rowAPPayment,
					colRefNo);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSegment4);

			if (onAPPaymentToCustomerSteps
					.searchDraftPaymentVch(paymentVoucherNumber)) {
				if (!customer.isEmpty()) {
					onAPPaymentToCustomerSteps.typeCustomer(customer);
				}
				if (!paymentVoucherDate.isEmpty()) {
					onAPPaymentToCustomerSteps
							.typePaymentVoucherDate(paymentVoucherDate);
				}
				if (!bankPartyCode.isEmpty()) {
					onAPPaymentToCustomerSteps.searchBankAccount(bankPartyCode,
							bankAccountNo);
				}
				if (!chequeDate.isEmpty()) {
					onAPPaymentToCustomerSteps.typeChequeDate(chequeDate);
				}
				if (!chequeNo.isEmpty()) {
					onAPPaymentToCustomerSteps.typeChequeNo(chequeNo);
				}
				if (!bankDraftNo.isEmpty()) {
					onAPPaymentToCustomerSteps.typeBankDraftNo(bankDraftNo);
				}
				if (!payeeName.isEmpty()) {
					onAPPaymentToCustomerSteps.choosePayeeName(payeeName);
				}
				if (!exchangeRate.isEmpty()) {
					onAPPaymentToCustomerSteps.chooseExchangeRate(exchangeRate);
				}
				if (!chequeAmount.isEmpty()) {
					onAPPaymentToCustomerSteps.typeChequeAmount(chequeAmount);
				}
				if (!refNo.isEmpty()) {
					onAPPaymentToCustomerSteps.typeRefNo(refNo);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPPaymentToCustomerSteps.setSegment(listSegment);

				isUpdate = true;
				isContinue = true;
				onAPPaymentToCustomerSteps.getPaymentVchNo(ssPymtToCusNo);
			}
		}
	}

	@When("^user create AP payment to customer as \"([^\"]*)\"$")
	public void user_create_AP_payment_to_customer_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APPymtCus";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYPAYMENT = "KEY";
		String colCustomer = "Customer";
		String colPaymentVoucherDate = "Payment Voucher Date";
		String colBankPartyCode = "Bank Party Code";
		String colBankAccountNo = "Bank Account No";
		String colChequeDate = "Cheque Date";
		String colChequeNo = "Cheque No.";
		String colBankDraftNo = "Bank Draft No";
		String colPayeeName = "Payee Name";
		String colExchangeRate = "Exchange Rate";
		String colChequeAmount = "Cheque Amount";
		String colRefNo = "Ref No.";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowAPPayment : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEYPAYMENT, dataKey).keySet()) {
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colCustomer);
			String paymentVoucherDate = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colPaymentVoucherDate);
			String bankPartyCode = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colBankPartyCode);
			String bankAccountNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colBankAccountNo);
			String chequeDate = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colChequeDate);
			String chequeNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colChequeNo);
			String bankDraftNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colBankDraftNo);
			String payeeName = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colPayeeName);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colExchangeRate);
			String chequeAmount = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colChequeAmount);
			String refNo = SessionData.getDataTbVal(dataTableKey, rowAPPayment,
					colRefNo);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSegment4);

			if (!customer.isEmpty()) {
				onAPPaymentToCustomerSteps.clickOnNewBtn();

				onAPPaymentToCustomerSteps.typeCustomer(customer);

				if (paymentVoucherDate.isEmpty()) {
					paymentVoucherDate = onAPPaymentToCustomerSteps.getToday();
				}
				onAPPaymentToCustomerSteps
						.typePaymentVoucherDate(paymentVoucherDate);

				if (!bankPartyCode.isEmpty()) {
					onAPPaymentToCustomerSteps.searchBankAccount(bankPartyCode,
							bankAccountNo);
				}
				if (!chequeNo.isEmpty()) {
					onAPPaymentToCustomerSteps.typeChequeNo(chequeNo);
				}
				if (!bankDraftNo.isEmpty()) {
					onAPPaymentToCustomerSteps.typeBankDraftNo(bankDraftNo);
				}
				if (!payeeName.isEmpty()) {
					onAPPaymentToCustomerSteps.choosePayeeName(payeeName);
				}
				if (!exchangeRate.isEmpty()) {
					onAPPaymentToCustomerSteps.chooseExchangeRate(exchangeRate);
				}
				if (!chequeAmount.isEmpty()) {
					onAPPaymentToCustomerSteps.typeChequeAmount(chequeAmount);
				}
				if (!refNo.isEmpty()) {
					onAPPaymentToCustomerSteps.typeRefNo(refNo);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPPaymentToCustomerSteps.setSegment(listSegment);
			}
			isUpdate = false;
			isContinue = true;

			onAPPaymentToCustomerSteps.getPaymentVchNo(ssPymtToCusNo);
		}
	}

	@When("^AP payment to customer is applied to receipt as \"([^\"]*)\"$")
	public void AP_payment_to_customer_is_applied_to_receipt_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APPymtCusAppToRcpt";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colRcptNo = "Rcpt No";
		String colRcptDate = "Rcpt Date";
		String colCCY = "CCY";
		String coldPymtAmtHomeAmt = "d Pymt Amt Home Amt";
		String coldRecAmtHomeAmt = "d Rec Amt Home Amt";
		String colCrossRateRealizedExch = "Cross Rate Realized Exch";

		int rowIndex = 1;

		for (int rowAPPymtCusAppToRcpt : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String rcptNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPymtCusAppToRcpt, colRcptNo);
			String rcptDate = SessionData.getDataTbVal(dataTableKey,
					rowAPPymtCusAppToRcpt, colRcptDate);
			String cCY = SessionData.getDataTbVal(dataTableKey,
					rowAPPymtCusAppToRcpt, colCCY);
			String dPymtAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
					rowAPPymtCusAppToRcpt, coldPymtAmtHomeAmt);
			String dRecAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
					rowAPPymtCusAppToRcpt, coldRecAmtHomeAmt);
			String crossRateRealizedExch = SessionData.getDataTbVal(
					dataTableKey, rowAPPymtCusAppToRcpt,
					colCrossRateRealizedExch);

			onAPPaymentToCustomerSteps.switchToApplicationtab();
			onAPPaymentToCustomerSteps.switchToApplicationToReceiptstab();

			if (!rcptNo.isEmpty()) {
				onAPPaymentToCustomerSteps.typeRcptNo(rcptNo);
			}
			if (!dPymtAmtHomeAmt.isEmpty()) {
				onAPPaymentToCustomerSteps.typedPymtAmtHomeAmt(dPymtAmtHomeAmt,
						rowIndex);
			}
			if (!dRecAmtHomeAmt.isEmpty()) {
				onAPPaymentToCustomerSteps.typedRecAmtHomeAmt(dRecAmtHomeAmt,
						rowIndex);
			}
			if (!crossRateRealizedExch.isEmpty()) {
				onAPPaymentToCustomerSteps.typeCrossRateRealizedExch(
						crossRateRealizedExch, rowIndex);
			}
		}
	}

	@When("^AP payment to customer is applied to credit note as \"([^\"]*)\"$")
	public void AP_payment_to_customer_is_applied_to_credit_note_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "APPymtCusAppToCrn";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colCrnNo = "Crn No";
		String colCrnDate = "Crn Date";
		String colCrnCcy = "Crn Ccy";
		String colAppliedChqAmtHomeAmt = "Applied Chq Amt Home Amt";
		String colAppliedCrnAmtHomeAmt = "Applied Crn Amt Home Amt";
		String colCrossRateRealizedExch = "Cross Rate Realized Exch";

		int rowIndex = 1;

		for (int rowAPPymtCusAppToCrn : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String crnNo = SessionData.getDataTbVal(dataTableKey,
					rowAPPymtCusAppToCrn, colCrnNo);
			String crnDate = SessionData.getDataTbVal(dataTableKey,
					rowAPPymtCusAppToCrn, colCrnDate);
			String crnCcy = SessionData.getDataTbVal(dataTableKey,
					rowAPPymtCusAppToCrn, colCrnCcy);
			String appliedChqAmtHomeAmt = SessionData
					.getDataTbVal(dataTableKey, rowAPPymtCusAppToCrn,
							colAppliedChqAmtHomeAmt);
			String appliedCrnAmtHomeAmt = SessionData
					.getDataTbVal(dataTableKey, rowAPPymtCusAppToCrn,
							colAppliedCrnAmtHomeAmt);
			String crossRateRealizedExch = SessionData.getDataTbVal(
					dataTableKey, rowAPPymtCusAppToCrn,
					colCrossRateRealizedExch);

			onAPPaymentToCustomerSteps.switchToApplicationtab();
			onAPPaymentToCustomerSteps.switchToApplicationToCreditNotetab();

			if (!crnNo.isEmpty()) {
				onAPPaymentToCustomerSteps.typeCrnNo(crnNo);
			}
			if (!appliedChqAmtHomeAmt.isEmpty()) {
				onAPPaymentToCustomerSteps.typeAppliedChqAmtHomeAmt(
						appliedChqAmtHomeAmt, rowIndex);
			}
			if (!appliedCrnAmtHomeAmt.isEmpty()) {
				onAPPaymentToCustomerSteps.typeAppliedCrnAmtHomeAmt(
						appliedCrnAmtHomeAmt, rowIndex);
			}
			if (!crossRateRealizedExch.isEmpty()) {
				onAPPaymentToCustomerSteps.typeCrossRateRealizedExch(
						crossRateRealizedExch, rowIndex);
			}
		}
	}

	@When("^AP payment to customer is previewed with report name \"([^\"]*)\"$")
	public void AP_payment_to_customer_is_previewed_with_report_name(
			String nameReport) {
		if (isContinue) {
			onAPPaymentToCustomerSteps.clickOnPreviewBtn(nameReport);
		}
	}

	@When("^AP payment to customer is previewed at history tab with report name \"([^\"]*)\"$")
	public void AP_payment_to_customer_is_previewed_at_history_tab_with_report_name(
			String nameReport) {
		if (isContinue) {
			String pymtVchNo = onAPPaymentToCustomerSteps
					.getDataWithSession(ssPymtToCusNo);
			onAPPaymentToCustomerSteps.clickOnPreviewHSTBtn(nameReport,
					pymtVchNo);
		}
	}

	@When("^AP payment to customer is submitted$")
	public void AP_payment_to_customer_is_submitted() {
		if (isContinue) {
			onAPPaymentToCustomerSteps.clickOnSubmitBtn();
		}
	}
}
