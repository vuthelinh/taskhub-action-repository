package com.synergix.processing.accountspayable.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountspayable.page.APPaymentPage;

public class APPaymentSteps extends ScenarioSteps {
	APPaymentPage onAPPaymentPage;

	@Step
	public void switchOutDefaultIFrame() {
		onAPPaymentPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onAPPaymentPage.switchToIFrame();
	}

	@Step
	public void typeSupplier(String supplier) {
		onAPPaymentPage.typeSupplier(supplier);
	}

	@Step
	public void typePaymentVoucherDate(String paymentVoucherDate) {
		onAPPaymentPage.typePaymentVoucherDate(paymentVoucherDate);
	}

	@Step
	public void typeChequeDate(String chequeDate) {
		onAPPaymentPage.typeChequeDate(chequeDate);
	}

	@Step
	public void typeChequeNo(String chequeNo) {
		onAPPaymentPage.typeChequeNo(chequeNo);
	}

	@Step
	public void typeBankDraftNo(String bankDraftNo) {
		onAPPaymentPage.typeBankDraftNo(bankDraftNo);
	}

	@Step
	public void choosePayeeName(String payeeName) {
		onAPPaymentPage.choosePayeeName(payeeName);
	}

	@Step
	public void chooseExchangeRate(String exchangeRate) {
		onAPPaymentPage.chooseExchangeRate(exchangeRate);
	}

	@Step
	public void typeChequeAmount(String chequeAmount) {
		onAPPaymentPage.typeChequeAmount(chequeAmount);
	}

	@Step
	public void typeRefNo(String refNo) {
		onAPPaymentPage.typeRefNo(refNo);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onAPPaymentPage.setSegment(listSegment);
	}

	@Step
	public boolean searchDraftPaymentVch(String paymentVoucherNumber) {
		String xParentDrafTb = "//table[contains(@id, 'apPayNewHdrsTable')]";
		return onAPPaymentPage.searchPaymentVch(xParentDrafTb,
				paymentVoucherNumber);
	}

	@Step
	public boolean searchOSTPaymentVch(String paymentVoucherNumber) {
		String xParentOSTTb = "//table[contains(@id, 'apPayOstHdrsTable')]";
		return onAPPaymentPage.searchPaymentVch(xParentOSTTb,
				paymentVoucherNumber);
	}

	@Step
	public boolean searchHSTPaymentVch(String paymentVoucherNumber) {
		String xParentHSTTb = "//table[contains(@id, 'apPayHstHdrsTable')]";
		return onAPPaymentPage.searchPaymentVch(xParentHSTTb,
				paymentVoucherNumber);
	}

	@Step
	public void clickOnNewBtn() {
		onAPPaymentPage.clickBtn("New");
		onAPPaymentPage.waitForAllJSCompletes();
	}

	@Step
	public void searchBankAccount(String bankPartyCode, String bankAccountNo) {
		onAPPaymentPage.clickSearchIconWithLabel("Bank Account No");
		onAPPaymentPage.searchBankAccount(bankPartyCode, bankAccountNo);
	}

	// ========================================
	// =========== APPLICATION ================
	@Step
	public int typeInvNo(String invNo, String supInvNo) {
		return onAPPaymentPage.typeInvNo(invNo, supInvNo);
	}

	@Step
	public void typeInvDueDate(String invDueDate) {
		onAPPaymentPage.typeInvDueDate(invDueDate);
	}

	@Step
	public void typeSupInvDate(String supInvDate) {
		onAPPaymentPage.typeSupInvDate(supInvDate);
	}

	@Step
	public void typeAgeDate(String ageDate) {
		onAPPaymentPage.typeAgeDate(ageDate);
	}

	@Step
	public void typeChqAmtHomeAmt(String chqAmtHomeAmt, int rowIndex) {
		onAPPaymentPage.typeChqAmtHomeAmt(chqAmtHomeAmt, rowIndex);
	}

	@Step
	public void typeInvAmtHomeAmt(String invAmtHomeAmt, int rowIndex) {
		onAPPaymentPage.typeInvAmtHomeAmt(invAmtHomeAmt, rowIndex);
	}

	@Step
	public void typeCrossRateRealizedExch(String crossRateRealizedExch,
			int rowIndex) {
		onAPPaymentPage.typeCrossRateRealizedExch(crossRateRealizedExch,
				rowIndex);
	}

	@Step
	public void chooseApplyFull(int rowIndex) {
		onAPPaymentPage.chooseApplyFull(rowIndex);
	}

	@Step
	public void typeAmtToPayInInvCcy(String amtToPayInInvCcy, int rowIndex) {
		onAPPaymentPage.typeAmtToPayInInvCcy(amtToPayInInvCcy, rowIndex);
	}

	@Step
	public void clickOnPreviewBtn(String nameReport) {
		onAPPaymentPage.clickPreviewBtn(nameReport);
	}

	@Step
	public void clickOnSubmitBtn() {
		onAPPaymentPage.clickBtn("Submit");
		onAPPaymentPage.chooseYesOnUpdateConfirmation();
		onAPPaymentPage.chooseOkOnInforPanel();
		onAPPaymentPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToHeaderTab() {
		onAPPaymentPage.switch_to_tab("Header");
		onAPPaymentPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToApplicationtab() {
		onAPPaymentPage.switch_to_tab("Application");
		onAPPaymentPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToOutstandingTab() {
		onAPPaymentPage.switch_to_tab("Outstanding");
		onAPPaymentPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToHistoryTab() {
		onAPPaymentPage.switch_to_tab("History");
		onAPPaymentPage.waitForAllJSCompletes();
	}

	public String getToday() {
		return onAPPaymentPage.getToday();
	}

	@Step
	public void typeApplicationDate(String applicationDate) {
		onAPPaymentPage.typeApplicationDate(applicationDate);
	}

	public void getPaymentVchNo(String ssPymNo) {
		onAPPaymentPage.getPaymentVchNo(ssPymNo);
	}

	public void clickOnPreviewHSTBtn(String nameReport, String pymtVchNo) {
		onAPPaymentPage.clickPreviewHST("Pymt Vch No", pymtVchNo, nameReport);
	}
}
