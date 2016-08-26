package com.synergix.processing.accountspayable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountspayable.steps.APPaymentSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class APPaymentDefs {
	@Steps
	APPaymentSteps onAPPaymentSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	private String ssPymNo = "PaymentVchNo";

	@When("^user update AP payment as \"([^\"]*)\"$")
	public void user_update_AP_payment_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APPayment";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYPAYMENT = "KEY PAYMENT";
		String colPaymentVoucherNumber = "Payment Voucher Number";
		String colSupplier = "Supplier";
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
			String supplier = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSupplier);
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

			if (onAPPaymentSteps.searchDraftPaymentVch(paymentVoucherNumber)) {
				if (!supplier.isEmpty()) {
					onAPPaymentSteps.typeSupplier(supplier);
				}
				if (!paymentVoucherDate.isEmpty()) {
					onAPPaymentSteps.typePaymentVoucherDate(paymentVoucherDate);
				}
				if (!bankPartyCode.isEmpty()) {
					onAPPaymentSteps.searchBankAccount(bankPartyCode,
							bankAccountNo);
				}
				if (!chequeDate.isEmpty()) {
					onAPPaymentSteps.typeChequeDate(chequeDate);
				}
				if (!chequeNo.isEmpty()) {
					onAPPaymentSteps.typeChequeNo(chequeNo);
				}
				if (!bankDraftNo.isEmpty()) {
					onAPPaymentSteps.typeBankDraftNo(bankDraftNo);
				}
				if (!payeeName.isEmpty()) {
					onAPPaymentSteps.choosePayeeName(payeeName);
				}
				if (!exchangeRate.isEmpty()) {
					onAPPaymentSteps.chooseExchangeRate(exchangeRate);
				}
				if (!chequeAmount.isEmpty()) {
					onAPPaymentSteps.typeChequeAmount(chequeAmount);
				}
				if (!refNo.isEmpty()) {
					onAPPaymentSteps.typeRefNo(refNo);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPPaymentSteps.setSegment(listSegment);

				isUpdate = true;
				isContinue = true;
				onAPPaymentSteps.getPaymentVchNo(ssPymNo);
			}
		}
	}

	@When("^user create AP payment as \"([^\"]*)\"$")
	public void user_create_AP_payment_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APPaymentUpdate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYPAYMENT = "KEY PAYMENT";
		String colSupplier = "Supplier";
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
			String supplier = SessionData.getDataTbVal(dataTableKey,
					rowAPPayment, colSupplier);
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

			if (!supplier.isEmpty()) {
				onAPPaymentSteps.clickOnNewBtn();

				onAPPaymentSteps.typeSupplier(supplier);

				if (!paymentVoucherDate.isEmpty()) {
					onAPPaymentSteps.typePaymentVoucherDate(paymentVoucherDate);
				}
				if (!bankPartyCode.isEmpty()) {
					onAPPaymentSteps.searchBankAccount(bankPartyCode,
							bankAccountNo);
				}

				if (!chequeNo.isEmpty()) {
					onAPPaymentSteps.typeChequeNo(chequeNo);
				}
				if (!bankDraftNo.isEmpty()) {
					onAPPaymentSteps.typeBankDraftNo(bankDraftNo);
				}
				if (!payeeName.isEmpty()) {
					onAPPaymentSteps.choosePayeeName(payeeName);
				}
				if (!exchangeRate.isEmpty()) {
					onAPPaymentSteps.chooseExchangeRate(exchangeRate);
				}
				if (!chequeAmount.isEmpty()) {
					onAPPaymentSteps.typeChequeAmount(chequeAmount);
				}
				if (!refNo.isEmpty()) {
					onAPPaymentSteps.typeRefNo(refNo);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPPaymentSteps.setSegment(listSegment);
			}
			isUpdate = false;
			isContinue = true;

			onAPPaymentSteps.getPaymentVchNo(ssPymNo);
		}
	}

	@When("^AP payment is applied as \"([^\"]*)\"$")
	public void AP_payment_is_applied_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APPaymentApplied";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYPAYMENT = "KEY PAYMENT";
			String colInvNo = "Inv No.";
			String colSupInvNo = "Sup Inv No";
			String colInvDueDate = "Inv Due Date";
			String colSupInvDate = "Sup Inv Date";
			String colAgeDate = "Age Date";
			String colRefNo = "Ref No";
			String colChqAmtHomeAmt = "Chq Amt Home Amt";
			String colInvAmtHomeAmt = "Inv Amt Home Amt";
			String colCrossRateRealizedExch = "Cross Rate Realized Exch";
			String colApplyFull = "Apply Full";
			String colAmtToPayInInvCcy = "Amt to Pay in Inv Ccy";

			for (int rowAPPaymentApplied : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYPAYMENT,
							dataKey).keySet()) {
				String invNo = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colInvNo);
				String supInvNo = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colSupInvNo);
				String invDueDate = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colInvDueDate);
				String supInvDate = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colSupInvDate);
				String ageDate = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colAgeDate);
				String refNo = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colRefNo);
				String chqAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colChqAmtHomeAmt);
				String invAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colInvAmtHomeAmt);
				String crossRateRealizedExch = SessionData.getDataTbVal(
						dataTableKey, rowAPPaymentApplied,
						colCrossRateRealizedExch);
				String applyFull = SessionData.getDataTbVal(dataTableKey,
						rowAPPaymentApplied, colApplyFull);
				String amtToPayInInvCcy = SessionData.getDataTbVal(
						dataTableKey, rowAPPaymentApplied, colAmtToPayInInvCcy);
				onAPPaymentSteps.moveToApplicationtab();

				int rowIndex = onAPPaymentSteps.typeInvNo(invNo, supInvNo);
				if (rowIndex < 1)
					rowIndex = 1;

				if (!chqAmtHomeAmt.isEmpty()) {
					onAPPaymentSteps.typeChqAmtHomeAmt(chqAmtHomeAmt, rowIndex);
				}
				if (!invAmtHomeAmt.isEmpty()) {
					onAPPaymentSteps.typeInvAmtHomeAmt(invAmtHomeAmt, rowIndex);
				}
				if (!crossRateRealizedExch.isEmpty()) {
					onAPPaymentSteps.typeCrossRateRealizedExch(
							crossRateRealizedExch, rowIndex);
				}
				if (applyFull.toLowerCase().equals("y")) {
					onAPPaymentSteps.chooseApplyFull(rowIndex);
				}
				if (!amtToPayInInvCcy.isEmpty()) {
					onAPPaymentSteps.typeAmtToPayInInvCcy(amtToPayInInvCcy,
							rowIndex);
				}
			}
		}
	}

	@When("^AP payment is applied at outstanding tab as \"([^\"]*)\"$")
	public void AP_payment_is_applied_at_outstanding_tab_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APPaymentAppliedOst";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYPAYMENT = "KEY PAYMENT";
			String colPymtVchNo = "Pymt Vch No";
			String colApplicationDate = "Application Date";

			onAPPaymentSteps.moveToOutstandingTab();

			List<String> listNo = new ArrayList<>();
			listNo = Serenity.sessionVariableCalled(ssPymNo);
			String pymtVchNo = listNo.get(0).trim();

			if (onAPPaymentSteps.searchOSTPaymentVch(pymtVchNo)) {
				for (int rowAPPaymentAppliedOst : SessionData
						.getDataTbRowsByValEqualInCol(dataTableKey,
								colKEYPAYMENT, dataKey).keySet()) {
					String pymtVchNo1 = SessionData.getDataTbVal(dataTableKey,
							rowAPPaymentAppliedOst, colPymtVchNo);
					String applicationDate = SessionData.getDataTbVal(
							dataTableKey, rowAPPaymentAppliedOst,
							colApplicationDate);

					if (applicationDate.isEmpty())
						applicationDate = onAPPaymentSteps.getToday();
					onAPPaymentSteps.typeApplicationDate(applicationDate);
				}
			}
		}
	}

	@When("^AP payment is previewed with report name \"([^\"]*)\"$")
	public void AP_payment_is_previewed_with_report_name(String nameReport) {
		if (isContinue) {
			onAPPaymentSteps.clickOnPreviewBtn(nameReport);
		}
	}

	@When("^AP payment is previewed at history tab with report name \"([^\"]*)\"$")
	public void AP_payment_is_previewed_at_history_tab_with_report_name(
			String nameReport) {
		if (isContinue) {

			onAPPaymentSteps.moveToHistoryTab();

			List<String> listNo = new ArrayList<>();
			listNo = Serenity.sessionVariableCalled(ssPymNo);
			String pymtVchNo = listNo.get(0).trim();

			onAPPaymentSteps.clickOnPreviewHSTBtn(nameReport, pymtVchNo);

		}
	}

	@When("^AP payment is submitted$")
	public void AP_payment_is_submitted() {
		if (isContinue) {
			onAPPaymentSteps.clickOnSubmitBtn();
		}
	}
}
