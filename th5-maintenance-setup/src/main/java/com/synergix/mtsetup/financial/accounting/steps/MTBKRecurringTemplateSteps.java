package com.synergix.mtsetup.financial.accounting.steps;

import java.util.List;

import com.synergix.mtsetup.financial.accounting.pages.MTBKRecurringTemplatePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MTBKRecurringTemplateSteps extends ScenarioSteps {

	MTBKRecurringTemplatePage onMTBKRecurringTemplatePage;

	public void switchToIFrame() {
		onMTBKRecurringTemplatePage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onMTBKRecurringTemplatePage.switchOutDefaultIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onMTBKRecurringTemplatePage.clickBtn("New");
		onMTBKRecurringTemplatePage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnDelBKBtn() {
		onMTBKRecurringTemplatePage.clickBtn("Delete", 1);
		onMTBKRecurringTemplatePage.chooseYesOnUpdateConfirmation();
		onMTBKRecurringTemplatePage.waitForAllJSCompletes();
	}

	public String getToday() {
		return onMTBKRecurringTemplatePage.getToday();
	}

	public int getRowTb(String xParentTb) {
		return onMTBKRecurringTemplatePage.getRowTb(xParentTb);
	}

	@Step
	public boolean searchBankTemplateCode(String bankTemplateCode) {
		onMTBKRecurringTemplatePage.clickBtn("Search");
		return onMTBKRecurringTemplatePage.getResultSearch("Template No", bankTemplateCode);
	}

	@Step
	public void typeBankTemplateCode(String bankTemplateCode) {
		onMTBKRecurringTemplatePage.typeBankTemplateCode(bankTemplateCode);
	}

	@Step
	public void typeTemplateDescription(String templateDescription) {
		onMTBKRecurringTemplatePage.typeTemplateDescription(templateDescription);
	}

	@Step
	public void typeBankVoucherDescription(String bankVoucherDescription) {
		onMTBKRecurringTemplatePage.typeBankVoucherDescription(bankVoucherDescription);
	}

	@Step
	public void chooseRecurringFrequency(String recurringFrequency) {
		onMTBKRecurringTemplatePage.chooseRecurringFrequency(recurringFrequency);
	}

	@Step
	public void typeRecurringDay(String recurringDay) {
		onMTBKRecurringTemplatePage.chooseRecurringDay(recurringDay);
	}

	@Step
	public void typeRecurrenceStartDate(String recurrenceStartDate) {
		onMTBKRecurringTemplatePage.typeRecurrenceStartDate(recurrenceStartDate);
	}

	@Step
	public void typeRecurrenceEndDate(String recurrenceEndDate) {
		onMTBKRecurringTemplatePage.typeRecurrenceEndDate(recurrenceEndDate);
	}

	@Step
	public void typeLastRecurredDate(String lastRecurredDate) {
		onMTBKRecurringTemplatePage.typeLastRecurredDate(lastRecurredDate);
	}

	@Step
	public void chooseTransactionType(String transactionType) {
		onMTBKRecurringTemplatePage.chooseTransactionType(transactionType);
	}

	// ############ DEPOSIT #############
	@Step
	public void chooseModeofDeposit(String modeofDeposit) {
		onMTBKRecurringTemplatePage.chooseModeofDeposit(modeofDeposit);
	}

	@Step
	public void typeDepositbankkAcNo(String depositbankkAcNo) {
		onMTBKRecurringTemplatePage.typeDepositbankkAcNo(depositbankkAcNo);
	}

	@Step
	public void typeCurrency(String currency) {
		onMTBKRecurringTemplatePage.typeCurrency(currency);
	}

	@Step
	public void chooseDepositSlipNo(String depositSlipNo) {
		onMTBKRecurringTemplatePage.typeDepositSlipNo(depositSlipNo);
	}

	// Deposit Detail

	@Step
	public void clickOnAddBtn() {
		onMTBKRecurringTemplatePage.clickBtn("Add");
		onMTBKRecurringTemplatePage.waitForAllJSCompletes();
	}

	@Step
	public void typeReceivedFrom(String xParentTb, String receivedFrom, int rowIndex) {
		onMTBKRecurringTemplatePage.typeReceivedFrom(xParentTb, receivedFrom, rowIndex);
	}

	@Step
	public void typeChequeNo(String xParentTb, String chequeNo, int rowIndex) {
		onMTBKRecurringTemplatePage.typeChequeNo(xParentTb, chequeNo, rowIndex);
	}

	@Step
	public void typeAmount(String xParentTb, String amount, int rowIndex) {
		onMTBKRecurringTemplatePage.typeAmount(xParentTb, amount, rowIndex);
	}

	@Step
	public void typeSalesTax(String xParentTb, String salesTax, int rowIndex) {
		onMTBKRecurringTemplatePage.typeSalesTax(xParentTb, salesTax, rowIndex);
	}

	@Step
	public void typeDocumentNo(String xParentTb, String documentNo, int rowIndex) {
		onMTBKRecurringTemplatePage.typeDocumentNo(xParentTb, documentNo, rowIndex);
	}

	@Step
	public void typeDocDate(String xParentTb, String docDate, int rowIndex) {
		onMTBKRecurringTemplatePage.typeDocDate(xParentTb, docDate, rowIndex);
	}

	@Step
	public void setSegment(String xParentTb, List<String> listSegment, int rowIndex) {
		onMTBKRecurringTemplatePage.setSegment(xParentTb, listSegment, rowIndex);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onMTBKRecurringTemplatePage.setSegment(listSegment);
	}

	@Step
	public void chooseDelDetail(String xParentTb, int rowIndex) {
		onMTBKRecurringTemplatePage.chooseDelDepositDetail(xParentTb, rowIndex);
	}

	// ############ FUND TRANSFER #############
	public void typeRemittanceBankAcNo(String remittanceBankAcNo) {
		onMTBKRecurringTemplatePage.typeRemittanceBankAcNo(remittanceBankAcNo);
	}

	public void typeDestinationBankAcNo(String destinationBankAcNo) {
		onMTBKRecurringTemplatePage.typeDestinationBankAcNo(destinationBankAcNo);
	}

	public void typeTransferAmount(String transferAmount) {
		onMTBKRecurringTemplatePage.typeTransferAmount(transferAmount);
	}

	// ############# WITHDRAWAL ####################
	@Step
	public void typeModeofWithdrawal(String modeofWithdrawal) {
		onMTBKRecurringTemplatePage.chooseModeofWithdrawal(modeofWithdrawal);
	}

	@Step
	public void typeWithdrawalBankACNo(String withdrawalBankACNo) {
		onMTBKRecurringTemplatePage.typeWithdrawalBankACNo(withdrawalBankACNo);
	}

	@Step
	public void typeWithdrawalSlipNo(String withdrawalSlipNo) {
		onMTBKRecurringTemplatePage.typeWithdrawalSlipNo(withdrawalSlipNo);
	}

	@Step
	public void typePaidto(String xParentTb, String paidto, int rowIndex) {
		onMTBKRecurringTemplatePage.typePaidto(xParentTb, paidto, rowIndex);
	}

	@Step
	public void deleteValueBySearchBtn(String bankTemplateCode) {
		onMTBKRecurringTemplatePage.deleteValueBySearchBtn("Search", "Template No", bankTemplateCode);
	}
}
