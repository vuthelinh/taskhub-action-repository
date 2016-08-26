package com.synergix.processing.bankbook.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.bankbook.pages.BKTransactionVchPage;

public class BKTransactionVchSteps extends ScenarioSteps {
	BKTransactionVchPage onBKTransactionVchPage;


	@Step
	public void switchOutDefaultIFrame() {
		onBKTransactionVchPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onBKTransactionVchPage.switchToIFrame();
	}
		
	@Step
	public void clickOnNewBtn() {
		onBKTransactionVchPage.clickBtn("New");
		onBKTransactionVchPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnSubmitBtn() {
		onBKTransactionVchPage.clickBtn("Submit");
		onBKTransactionVchPage.chooseYesOnUpdateConfirmation();
		onBKTransactionVchPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnPreviewBtn(String reportName) {
		onBKTransactionVchPage.clickPreviewBtn(reportName);
	}

	@Step
	public boolean searchBankVchNo(String bankVoucherNo) {
		return onBKTransactionVchPage.searchBankVchNo(bankVoucherNo);
	}

	@Step
	public void typeBankVoucherDescription(String bankVoucherDescription) {
		onBKTransactionVchPage
				.typeBankVoucherDescription(bankVoucherDescription);
	}

	@Step
	public void typeReceivedFrom(String receivedFrom, String transactionType) {
		onBKTransactionVchPage.typeReceivedFrom(receivedFrom, transactionType);
	}

	@Step
	public void chooseTransactionType(String transactionType) {
		onBKTransactionVchPage.chooseTransactionType(transactionType);
	}

	// ==================================================
	// ================= DEPOSIT ========================
	@Step
	public void chooseModeofDeposit(String modeofDeposit) {
		onBKTransactionVchPage.chooseModeofDeposit(modeofDeposit);
	}

	@Step
	public void typeBankVchDate(String bankVchDate) {
		onBKTransactionVchPage.typeBankVchDate(bankVchDate);
	}

	@Step
	public void typeDepositSlipDate(String depositSlipDate) {
		onBKTransactionVchPage.typeDepositSlipDate(depositSlipDate);
	}

	@Step
	public void searchBankPartyCode(String labelSearch, String bankPartyCode,
			String bankAccountNo) {
		onBKTransactionVchPage.searchBankPartyCode(labelSearch, bankPartyCode,
				bankAccountNo);
	}

	@Step
	public void typeCurrency(String currency) {
		onBKTransactionVchPage.typeCurrency(currency);
	}

	@Step
	public void typeCrossRate(String crossRate) {
		onBKTransactionVchPage.typeCrossRate(crossRate);
	}

	@Step
	public void typeSBUCode(String sBUCode) {
		onBKTransactionVchPage.typeSBUCode(sBUCode);
	}

	@Step
	public void typeValueDate(String valueDate) {
		onBKTransactionVchPage.typeValueDate(valueDate);
	}

	@Step
	public void typeDepositSlipNo(String depositSlipNo) {
		onBKTransactionVchPage.typeDepositSlipNo(depositSlipNo);
	}

	@Step
	public void typeDepositBankExchRate(String depositBankExchRate) {
		onBKTransactionVchPage.typeDepositBankExchRate(depositBankExchRate);
	}

	@Step
	public void typeExchRate(String exchRate) {
		onBKTransactionVchPage.typeExchRate(exchRate);
	}

	@Step
	public void typeDefaultSalesTax(String defaultSalesTax) {
		onBKTransactionVchPage.typeDefaultSalesTax(defaultSalesTax);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onBKTransactionVchPage.setSegment(listSegment);
	}

	// Detail

	@Step
	public void typeReceivedFrom(String transactionType, String receivedFrom,
			int rowIndex) {
		onBKTransactionVchPage.typeReceivedFrom(transactionType, receivedFrom,
				rowIndex);
	}
	
	// ================================================
	// =============== FUND TRANSFER =====================

	@Step
	public void typeModeofTransfer(String modeofTransfer) {
		onBKTransactionVchPage.typeModeofTransfer(modeofTransfer);
	}

	@Step
	public void typeTransferAdviceDate(String transferAdviceDate) {
		onBKTransactionVchPage.typeTransferAdviceDate(transferAdviceDate);
	}
	
	@Step
	public void typeTransferAmount(String transferAmount) {
		onBKTransactionVchPage.typeTransferAmount(transferAmount);
	}

	@Step
	public void typeTransferAdviceNo(String transferAdviceNo) {
		onBKTransactionVchPage.typeTransferAdviceNo(transferAdviceNo);
	}

	@Step
	public void typeRemittanceBankExchRate(String remittanceBankExchRate) {
		onBKTransactionVchPage
				.typeRemittanceBankExchRate(remittanceBankExchRate);
	}

	@Step
	public void typeDestinationBankExchRate(String destinationBankExchRate) {
		onBKTransactionVchPage
				.typeDestinationBankExchRate(destinationBankExchRate);
	}
	
	@Step
	public void searchRemittanBank(String remittanceBankACName,
			String remittanceBankACNo) {
		onBKTransactionVchPage.clickSearchIconWithLabel("Remittance Bank A/C No");
		onBKTransactionVchPage.searchBankAccount(remittanceBankACName, remittanceBankACNo);
	}

	@Step
	public void searcDestinationBank(String destinationBankACName,
			String destinationBankACNo) {
		onBKTransactionVchPage.clickSearchIconWithLabel("Destination Bank A/C No");
		onBKTransactionVchPage.searchBankAccount(destinationBankACName, destinationBankACNo);
	}

	
	// ================================================
	// =============== WITHDRAWAL =====================
	@Step
	public void chooseModeofWithdrawal(String modeofWithdrawal) {
		onBKTransactionVchPage.chooseModeofWithdrawal(modeofWithdrawal);
	}

	@Step
	public void typeWithdrawalSlipDate(String withdrawalSlipDate) {
		onBKTransactionVchPage.typeWithdrawalSlipDate(withdrawalSlipDate);
	}

	@Step
	public void typeChequeNo(String chequeNo) {
		onBKTransactionVchPage.typeChequeNo(chequeNo);
	}

	@Step
	public void typeWithdrawalSlipNo(String withdrawalSlipNo) {
		onBKTransactionVchPage.typeWithdrawalSlipNo(withdrawalSlipNo);
	}

	@Step
	public void typeWithdrawalBankExchRate(String withdrawalBankExchRate) {
		onBKTransactionVchPage
				.typeWithdrawalBankExchRate(withdrawalBankExchRate);
	}

	// Detail
	@Step
	public void chooseCreditDebit(String transactionType, String creditDebit,
			int rowIndex) {
		onBKTransactionVchPage.chooseCreditDebit(transactionType, creditDebit,
				rowIndex);
	}

	@Step
	public void typePaidTo(String transactionType, String paidTo, int rowIndex) {
		onBKTransactionVchPage.typePaidTo(transactionType, paidTo, rowIndex);
	}

	@Step
	public void typeAmount(String transactionType, String amount, int rowIndex) {
		onBKTransactionVchPage.typeAmount(transactionType, amount, rowIndex);
	}

	@Step
	public void typeSalesTax(String transactionType, String salesTax,
			int rowIndex) {
		onBKTransactionVchPage
				.typeSalesTax(transactionType, salesTax, rowIndex);
	}

	@Step
	public void typeDocumentNo(String transactionType, String documentNo,
			int rowIndex) {
		onBKTransactionVchPage.typeDocumentNo(transactionType, documentNo,
				rowIndex);
	}

	@Step
	public void typeDocDate(String transactionType, String docDate, int rowIndex) {
		onBKTransactionVchPage.typeDocDate(transactionType, docDate, rowIndex);
	}

	@Step
	public void setSegment(String transactionType, List<String> listSegment,
			int rowIndex) {
		if (transactionType.equals("Withdrawal")) {
			String xWithdrawalTb = "//table[contains(@id, 'draftWdlLineItemsTable') and child::thead]";
			onBKTransactionVchPage.setSegment(xWithdrawalTb, listSegment,
					rowIndex);
		} else if (transactionType.equals("Deposit")) {
			String xDepositTb = "//table[contains(@id, 'draftDepositLineItemsTable') and child::thead]";
			onBKTransactionVchPage
					.setSegment(xDepositTb, listSegment, rowIndex);
		}
	}

	@Step
	public void clickOnAddBtn() {
		onBKTransactionVchPage.clickBtn("Add");
		onBKTransactionVchPage.waitForAllJSCompletes();
	}

	public int countRowDetailsTb(String transactionType) {
		String xParentTb = "";
		if (transactionType.equals("Withdrawal")) {
			xParentTb = "//table[contains(@id, 'draftWdlLineItemsTable') and child::thead]";
		} else if (transactionType.equals("Deposit")) {
			xParentTb = "//table[contains(@id, 'draftDepositLineItemsTable') and child::thead]";
		}
		return onBKTransactionVchPage.getTbCountDataRow(xParentTb);
	}

	// ===============================================
	// ============ ALLOCATION PROJECT ===============

	@Step
	public void clickOnAddAllocateBtn() {
		String xPopUp = "//table[@id='popupModalPanelContentTable']";
		onBKTransactionVchPage.clickBtn(xPopUp, "Add");
		onBKTransactionVchPage.waitForAllJSCompletes();
	}

	@Step
	public void chooseLiNo(String liNo) {
		onBKTransactionVchPage.chooseLiNo(liNo);
	}

	@Step
	public void chooseType(String type, int rowIndex) {
		onBKTransactionVchPage.chooseType(type, rowIndex);
	}

	@Step
	public void chooseOACode(String oACode, int rowIndex) {
		onBKTransactionVchPage.chooseOACode(oACode, rowIndex);
	}

	@Step
	public void chooseVoucherNo(String voucherNo, String phaseSequenceNo,
			String lINo, int rowIndex) {
		onBKTransactionVchPage.chooseVoucherNo(voucherNo, phaseSequenceNo,
				lINo, rowIndex);
	}

	@Step
	public void typePhaseSequenceNo(String phaseSequenceNo, int rowIndex) {
		onBKTransactionVchPage.typePhaseSequenceNo(phaseSequenceNo, rowIndex);
	}

	@Step
	public void typeLINo(String lINo, int rowIndex) {
		onBKTransactionVchPage.typeLINo(lINo, rowIndex);
	}

	@Step
	public void typeAllocationAmt(String allocationAmt, int rowIndex) {
		onBKTransactionVchPage.typeAllocationAmt(allocationAmt, rowIndex);
	}

	@Step
	public void chooseDelete(String delete, int rowIndex) {
		onBKTransactionVchPage.chooseDelete(delete, rowIndex);
	}

	@Step
	public void chooseSel(String sel, int rowIndex) {
		onBKTransactionVchPage.chooseSel(sel, rowIndex);
	}

	@Step
	public void clickOnCloseAllocationDetail() {
		onBKTransactionVchPage.closePopup();
	}

	@Step
	public int countRowAllocationTb() {
		return onBKTransactionVchPage.countRowAllocationTb();
	}

	@Step
	public void getVoucherNo(String ssBKTrans) {
		onBKTransactionVchPage.getVoucherNo(ssBKTrans);
	}

	@Step
	public String getDataWithSession(String ssBKTrans) {
		return onBKTransactionVchPage.getDataWithSession(ssBKTrans, 0);
	}

	@Step
	public void clickOnLastUpdateDatAtDratTab() {
		onBKTransactionVchPage.clickOnLastUpdateDatAtDratTab();
	}

	@Step
	public void chooseVchNoAtDraftTab(String firstVch, int amtVch) {
		onBKTransactionVchPage.chooseVchNoAtDraftTab(firstVch, amtVch);
	}

	@Step
	public void chooseVchNoAtDraftTab(String firstVch) {
		onBKTransactionVchPage.chooseVchNoAtDraftTab(firstVch);
	}
	
	@Step
	public void clickOnPreviewHSTBtn(String bankVchNo, String reportName) {
		String xHistoryTb = "//table[@id= 'bkTransHstHdrsForm:bkTransHstHdrsTable']";
		onBKTransactionVchPage.clickPreviewHST(xHistoryTb, "Bank Voucher No.", bankVchNo, reportName);
	}
}
