package com.synergix.processing.accountspayable.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountspayable.page.APPaymentToCustomerPage;

public class APPaymentToCustomerSteps extends ScenarioSteps {
	APPaymentToCustomerPage onAPPaymentToCustomerPage;

	@Step
	public void switchOutDefaultIFrame() {
		onAPPaymentToCustomerPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onAPPaymentToCustomerPage.switchToIFrame();
	}

	@Step
	public void typeCustomer(String customer) {
		onAPPaymentToCustomerPage.typeCustomer(customer);
	}

	@Step
	public void typePaymentVoucherDate(String paymentVoucherDate) {
		onAPPaymentToCustomerPage.typePaymentVoucherDate(paymentVoucherDate);
	}

	@Step
	public void typeChequeDate(String chequeDate) {
		onAPPaymentToCustomerPage.typeChequeDate(chequeDate);
	}

	@Step
	public void typeChequeNo(String chequeNo) {
		onAPPaymentToCustomerPage.typeChequeNo(chequeNo);
	}

	@Step
	public void typeBankDraftNo(String bankDraftNo) {
		onAPPaymentToCustomerPage.typeBankDraftNo(bankDraftNo);
	}

	@Step
	public void choosePayeeName(String payeeName) {
		onAPPaymentToCustomerPage.choosePayeeName(payeeName);
	}

	@Step
	public void chooseExchangeRate(String exchangeRate) {
		onAPPaymentToCustomerPage.chooseExchangeRate(exchangeRate);
	}

	@Step
	public void typeChequeAmount(String chequeAmount) {
		onAPPaymentToCustomerPage.typeChequeAmount(chequeAmount);
	}

	@Step
	public void typeRefNo(String refNo) {
		onAPPaymentToCustomerPage.typeRefNo(refNo);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onAPPaymentToCustomerPage.setSegment(listSegment);
	}

	@Step
	public boolean searchDraftPaymentVch(String paymentVoucherNumber) {
		return onAPPaymentToCustomerPage
				.searchDraftPaymentVch(paymentVoucherNumber);
	}

	@Step
	public boolean searchHSTPaymentVch(String paymentVoucherNumber) {
		return onAPPaymentToCustomerPage
				.searchHSTPaymentVch(paymentVoucherNumber);
	}

	@Step
	public void clickOnNewBtn() {
		onAPPaymentToCustomerPage.clickBtn("New");
		onAPPaymentToCustomerPage.waitForAllJSCompletes();
	}

	@Step
	public void searchBankAccount(String bankPartyCode, String bankAccountNo) {
		onAPPaymentToCustomerPage.clickSearchIconWithLabel("Bank Account No");
		onAPPaymentToCustomerPage.searchBankAccount(bankPartyCode,
				bankAccountNo);
	}

	@Step
	public void clickOnPreviewBtn(String nameReport) {
		onAPPaymentToCustomerPage.clickPreviewBtn(nameReport);
	}

	@Step
	public void clickOnSubmitBtn() {
		onAPPaymentToCustomerPage.clickBtn("Submit");
		onAPPaymentToCustomerPage.chooseYesOnUpdateConfirmation();
		onAPPaymentToCustomerPage.chooseOkOnInforPanel();
		onAPPaymentToCustomerPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToHeaderTab() {
		onAPPaymentToCustomerPage.switch_to_tab("Header");
		onAPPaymentToCustomerPage.waitForAllJSCompletes();
	}

	@Step
	public void switchToApplicationtab() {
		onAPPaymentToCustomerPage.switch_to_tab("Application");
		onAPPaymentToCustomerPage.waitForAllJSCompletes();
	}

	public String getToday() {
		return onAPPaymentToCustomerPage.getToday();
	}

	public void getPaymentVchNo(String ssPymNo) {
		onAPPaymentToCustomerPage.getPaymentVchNo(ssPymNo);
	}

	@Step
	public void clickOnPreviewHSTBtn(String nameReport, String pymtVchNo) {
		onAPPaymentToCustomerPage.clickPreviewHST("Pymt Vch No", pymtVchNo,
				nameReport);
	}

	public String getDataWithSession(String ssPymtToCusNo) {
		return onAPPaymentToCustomerPage.getDataWithSession(ssPymtToCusNo, 0);
	}

	@Step
	public void switchToApplicationToCreditNotetab() {
		onAPPaymentToCustomerPage.switch_to_tab("Application to Credit Notes");
		onAPPaymentToCustomerPage.waitForAllJSCompletes();
	}

	@Step
	public void switchToApplicationToReceiptstab() {
		onAPPaymentToCustomerPage.switch_to_tab("Application to Receipts");
		onAPPaymentToCustomerPage.waitForAllJSCompletes();
	}

	// ======================================
	// ======== APPLICATION TAB =============
	@Step
	public void typeRcptNo(String rcptNo) {
		onAPPaymentToCustomerPage.typeRcptNo(rcptNo);
	}

	@Step
	public void typeRcptDate(String rcptDate) {
		onAPPaymentToCustomerPage.typeRcptDate(rcptDate);
	}

	@Step
	public void typeCCY(String cCY) {
		onAPPaymentToCustomerPage.typeCCY(cCY);
	}

	@Step
	public void typedPymtAmtHomeAmt(String dPymtAmtHomeAmt, int rowIndex) {
		onAPPaymentToCustomerPage
				.typedPymtAmtHomeAmt(dPymtAmtHomeAmt, rowIndex);
	}

	@Step
	public void typedRecAmtHomeAmt(String dRecAmtHomeAmt, int rowIndex) {
		onAPPaymentToCustomerPage.typedRecAmtHomeAmt(dRecAmtHomeAmt, rowIndex);
	}

	@Step
	public void typeCrossRateRealizedExch(String crossRateRealizedExch,
			int rowIndex) {
		onAPPaymentToCustomerPage.typeCrossRateRealizedExch(
				crossRateRealizedExch, rowIndex);
	}

	@Step
	public void typeCrnNo(String crnNo) {
		onAPPaymentToCustomerPage.typeCrnNo(crnNo);
	}

	@Step
	public void typeCrnDate(String crnDate) {
		onAPPaymentToCustomerPage.typeCrnDate(crnDate);
	}

	@Step
	public void typeCrnCcy(String crnCcy) {
		onAPPaymentToCustomerPage.typeCrnCcy(crnCcy);
	}

	@Step
	public void typeAppliedChqAmtHomeAmt(String appliedChqAmtHomeAmt,
			int rowIndex) {
		onAPPaymentToCustomerPage.typeAppliedChqAmtHomeAmt(
				appliedChqAmtHomeAmt, rowIndex);
	}

	@Step
	public void typeAppliedCrnAmtHomeAmt(String appliedCrnAmtHomeAmt,
			int rowIndex) {
		onAPPaymentToCustomerPage.typeAppliedCrnAmtHomeAmt(
				appliedCrnAmtHomeAmt, rowIndex);
	}

}
