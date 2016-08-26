package com.synergix.processing.bankbook.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.bankbook.pages.BKReconciliationVchPage;

public class BKReconciliationVchSteps extends ScenarioSteps {
	BKReconciliationVchPage onBKReconciliationVchPage;

	public void switchOutDefaultIFrame() {
		onBKReconciliationVchPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onBKReconciliationVchPage.switchToIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onBKReconciliationVchPage.clickBtn("New");
		onBKReconciliationVchPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnSubmitBtn() {
		onBKReconciliationVchPage.clickBtn("Submit");
		onBKReconciliationVchPage.chooseYesOnUpdateConfirmation();
		onBKReconciliationVchPage.waitForAllJSCompletes();
	}

	@Step
	public void typeReconciliationVoucherDate(String reconciliationVoucherDate) {
		onBKReconciliationVchPage
				.typeReconciliationVoucherDate(reconciliationVoucherDate);
	}

	@Step
	public void typeBankStatementNo(String bankStatementNo) {
		onBKReconciliationVchPage.typeBankStatementNo(bankStatementNo);
	}

	@Step
	public void typeBankStatementAmount(String bankStatementAmount) {
		onBKReconciliationVchPage.typeBankStatementAmount(bankStatementAmount);
	}

	@Step
	public void typeBankStatementDate(String bankStatementDate) {
		onBKReconciliationVchPage.typeBankStatementDate(bankStatementDate);
	}

	@Step
	public void searchBankCode(String bankAccountName, String bankAccountNo) {
		onBKReconciliationVchPage.clickSearchIconWithLabel("Bank Account No");
		onBKReconciliationVchPage.searchBankAccount(bankAccountName,
				bankAccountNo);
	}

	public String getToday() {
		return onBKReconciliationVchPage.getToday();
	}

	@Step
	public void typeSourceVoucherNo(String sourceVoucherNo) {
		onBKReconciliationVchPage.typeSourceVoucherNo(sourceVoucherNo);
	}

	@Step
	public void typeType(String type) {
		onBKReconciliationVchPage.typeType(type);
	}

	@Step
	public void typeChequeNo(String chequeNo) {
		onBKReconciliationVchPage.typeChequeNo(chequeNo);
	}

	@Step
	public void typeSourceVoucherDocNo(String sourceVoucherDocNo) {
		onBKReconciliationVchPage.typeSourceVoucherDocNo(sourceVoucherDocNo);
	}

	@Step
	public void chooseSourceVchNo(int rowIndex) {
		onBKReconciliationVchPage.chooseSourceVchNo(rowIndex);
	}

	@Step
	public void chooseAllSourceVchNo() {
		onBKReconciliationVchPage.chooseAllSourceVchNo();
	}

	public String getTextReconcileBalanceAmount() {
		return onBKReconciliationVchPage
				.getTextValueWithLabel("Reconcile Balance Amount");
	}

}
