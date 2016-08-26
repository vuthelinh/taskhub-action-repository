package com.synergix.processing.bankbook;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.bankbook.steps.BKReconciliationVchSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class BKReconciliationVchDefs {
	@Steps
	BKReconciliationVchSteps onBKReconciliationVchSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	String ssBKGenerate = "BKGenerateVch";

	// DONE
	@When("^user create reconliciation voucher as \"([^\"]*)\"$")
	public void user_create_reconliciation_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "BKReconliciation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colReconciliationVoucherDate = "Reconciliation Voucher Date";
		String colBankAccountName = "Bank Account Name";
		String colBankAccountNo = "Bank Account No";
		String colBankStatementNo = "Bank Statement No";
		String colBankStatementAmount = "Bank Statement Amount";
		String colBankStatementDate = "Bank Statement Date";

		for (int rowBKReconliciation : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String reconciliationVoucherDate = SessionData.getDataTbVal(
					dataTableKey, rowBKReconliciation,
					colReconciliationVoucherDate);
			String bankAccountName = SessionData.getDataTbVal(dataTableKey,
					rowBKReconliciation, colBankAccountName);
			String bankAccountNo = SessionData.getDataTbVal(dataTableKey,
					rowBKReconliciation, colBankAccountNo);
			String bankStatementNo = SessionData.getDataTbVal(dataTableKey,
					rowBKReconliciation, colBankStatementNo);
			String bankStatementAmount = SessionData.getDataTbVal(dataTableKey,
					rowBKReconliciation, colBankStatementAmount);
			String bankStatementDate = SessionData.getDataTbVal(dataTableKey,
					rowBKReconliciation, colBankStatementDate);

			onBKReconciliationVchSteps.clickOnNewBtn();

			if (reconciliationVoucherDate.isEmpty()) {
				reconciliationVoucherDate = onBKReconciliationVchSteps
						.getToday();
			}
			onBKReconciliationVchSteps
					.typeReconciliationVoucherDate(reconciliationVoucherDate);

			if (!bankAccountName.isEmpty()) {
				onBKReconciliationVchSteps.searchBankCode(bankAccountName,
						bankAccountNo);
			}
			if (!bankStatementNo.isEmpty()) {
				onBKReconciliationVchSteps.typeBankStatementNo(bankStatementNo);
			}
			if (!bankStatementAmount.isEmpty()) {
				onBKReconciliationVchSteps
						.typeBankStatementAmount(bankStatementAmount);
			}
			if (!bankStatementDate.isEmpty()) {
				onBKReconciliationVchSteps
						.typeBankStatementDate(bankStatementDate);
			}
		}
	}

	@When("^BK reconliciation is selected source voucher no as \"([^\"]*)\"$")
	public void BK_reconliciation_is_selected_source_voucher_no_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "BKReconliciationVch";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colSourceVoucherNo = "Source Voucher No";
		String colType = "Type";
		String colChequeNo = "Cheque No";
		String colSourceVoucherDocNo = "Source Voucher Doc No";

		int rowIndex = 1;
		for (int rowBKReconliciationVch : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String sourceVoucherNo = SessionData.getDataTbVal(dataTableKey,
					rowBKReconliciationVch, colSourceVoucherNo);
			if (!sourceVoucherNo.isEmpty()) {
				onBKReconciliationVchSteps.typeSourceVoucherNo(sourceVoucherNo);
			}
			onBKReconciliationVchSteps.chooseSourceVchNo(rowIndex);
		}
		String reconcileBalanceAmount = onBKReconciliationVchSteps
				.getTextReconcileBalanceAmount();
		onBKReconciliationVchSteps
				.typeBankStatementAmount(reconcileBalanceAmount);
	}

	@When("^BK reconliciation is selected all source voucher no$")
	public void BK_reconliciation_is_selected_all_source_voucher_no_as() {
		onBKReconciliationVchSteps.chooseAllSourceVchNo();
	}

	@When("^BK reconliciation is submitted$")
	public void BK_reconliciation_is_submitted() {
		onBKReconciliationVchSteps.clickOnSubmitBtn();
	}
}
