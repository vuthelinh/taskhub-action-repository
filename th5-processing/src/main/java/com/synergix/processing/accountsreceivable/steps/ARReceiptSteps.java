package com.synergix.processing.accountsreceivable.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountsreceivable.pages.ARReceiptPage;

public class ARReceiptSteps extends ScenarioSteps {
	ARReceiptPage onARReceiptPage;

	String xDrafTb = "//table[contains(@id, 'arRecNewHdrTable') and child::thead]";

	@Step
	public void switchOutDefaultIFrame() {
		onARReceiptPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onARReceiptPage.switchToIFrame();
	}

	@Step
	public boolean searchDrafReceiptNo(String crnNo) {
		return onARReceiptPage.searchByFilter(xDrafTb, "Receipt No", crnNo);
	}

	@Step
	public void clickOnNewBtn() {
		onARReceiptPage.clickBtn("New");
		onARReceiptPage.waitForAllJSCompletes();
	}

	@Step
	public void switchToDrafTab() {
		onARReceiptPage.switch_to_tab("Draf");
		onARReceiptPage.waitForAllJSCompletes();
	}

	@Step
	public void switchToHeaderTab() {
		onARReceiptPage.switch_to_tab("Header");
		onARReceiptPage.waitForAllJSCompletes();
	}

	@Step
	public void switchToOutstandingTab() {
		onARReceiptPage.switch_to_tab("Outstanding");
		onARReceiptPage.waitForAllJSCompletes();
	}

	@Step
	public String getToday() {
		return onARReceiptPage.getToday();
	}

	@Step
	public void typeCustomer(String customer) {
		onARReceiptPage.typeCustomer(customer);
	}

	@Step
	public void typeReceiptDate(String receiptDate) {
		onARReceiptPage.typeReceiptDate(receiptDate);
	}

	@Step
	public void typeReceiptCurrency(String receiptCurrency) {
		onARReceiptPage.typeReceiptCurrency(receiptCurrency);
	}

	@Step
	public void typeExchangeRate(String exchangeRate) {
		onARReceiptPage.typeExchangeRate(exchangeRate);
	}

	@Step
	public void typeReferenceNo(String referenceNo) {
		onARReceiptPage.typeReferenceNo(referenceNo);
	}

	@Step
	public void typeBankDraftNo(String bankDraftNo) {
		onARReceiptPage.typeBankDraftNo(bankDraftNo);
	}

	@Step
	public void typeDepositSlipNo(String depositSlipNo) {
		onARReceiptPage.typeDepositSlipNo(depositSlipNo);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onARReceiptPage.setSegment(listSegment);
	}

	@Step
	public void clickOnAddBtn() {
		onARReceiptPage.clickBtn("Add");
		onARReceiptPage.waitForAllJSCompletes();
	}

	// ====================== Payment Detail ========================
	@Step
	public void searchBankAcc(int rowIndex, String bankPartyCode,
			String bankAccountNo) {
		onARReceiptPage.searchBankAccount(rowIndex, bankPartyCode,
				bankAccountNo);
	}

	@Step
	public void choosePymtMethod(String pymtMethod, int rowIndex) {
		onARReceiptPage.choosePymtMethod(pymtMethod, rowIndex);
	}

	@Step
	public void typeChequeNo(String chequeNo, int rowIndex) {
		onARReceiptPage.typeChequeNo(chequeNo, rowIndex);
	}

	@Step
	public void typeChequeDate(String chequeDate, int rowIndex) {
		onARReceiptPage.typeChequeDate(chequeDate, rowIndex);
	}

	@Step
	public void typeCustomerBank(String customerBank, int rowIndex) {
		onARReceiptPage.typeCustomerBank(customerBank, rowIndex);
	}

	@Step
	public void chooseCardType(String cardType, int rowIndex) {
		onARReceiptPage.chooseCardType(cardType, rowIndex);
	}

	@Step
	public void chooseInstmtCodeInstmtDesc(String instmtCodeInstmtDesc,
			int rowIndex) {
		onARReceiptPage.chooseInstmtCodeInstmtDesc(instmtCodeInstmtDesc,
				rowIndex);
	}

	@Step
	public void typePymtAmt(String pymtAmt, int rowIndex) {
		onARReceiptPage.typePymtAmt(pymtAmt, rowIndex);
	}

	@Step
	public void typeTenderedAmt(String tenderedAmt, int rowIndex) {
		onARReceiptPage.typeTenderedAmt(tenderedAmt, rowIndex);
	}

	// =============== APPLICATION TAB ==========
	@Step
	public void typedCrnAmtHomeAmt(String dCrnAmtHomeAmt, int rowIndex) {
		onARReceiptPage.typedCrnAmtHomeAmt(dCrnAmtHomeAmt, rowIndex);
	}

	@Step
	public void typedInvAmtHomeAmt(String dInvAmtHomeAmt, int rowIndex) {
		onARReceiptPage.typedInvAmtHomeAmt(dInvAmtHomeAmt, rowIndex);
	}

	@Step
	public void typeApplyFull(int rowIndex) {
		onARReceiptPage.typeApplyFull(rowIndex);
	}

	@Step
	public boolean searchReceiptNoApplied(String invNo) {
		return onARReceiptPage.searchReceiptNoApplied(invNo);
	}

	@Step
	public void switchToApplicationTab() {
		onARReceiptPage.switch_to_tab("Application");
		onARReceiptPage.waitForAllJSCompletes();
	}

	@Step
	public void getInvoiceNo(String ssCrnInv) {
		onARReceiptPage.getInvoiceNo(ssCrnInv);
	}

	@Step
	public void clickOnSubmitBtn() {
		onARReceiptPage.clickBtn("Submit");
		onARReceiptPage.chooseYesOnUpdateConfirmation();
		onARReceiptPage.chooseOkOnInforPanel();
		onARReceiptPage.waitForAllJSCompletes();
	}

	@Step
	public void clickPreview(String reportName) {
		onARReceiptPage.clickPreviewBtn(reportName);
	}

	@Step
	public String getDataWithSession(String ssCrnInv) {
		return onARReceiptPage.getDataWithSession(ssCrnInv, 0);
	}

	@Step
	public void clickPreviewHST(String invNo, String reportName) {
		onARReceiptPage.clickOnPreviewHST(invNo, reportName);
	}

	@Step
	public boolean searchOstCrnNo(String invNo) {
		return onARReceiptPage.searchOstCrnNo(invNo);
	}

	@Step
	public void typeApplicationDate(String applicationDate) {
		onARReceiptPage.typeApplicationDate(applicationDate);
	}

}
