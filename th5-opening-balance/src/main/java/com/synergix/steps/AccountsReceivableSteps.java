package com.synergix.steps;

import java.util.List;

import com.synergix.page.AccountsReceivablePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AccountsReceivableSteps extends ScenarioSteps {

	AccountsReceivablePage onAccountsReceivablePage;

	public void switchToIFrame() {
		onAccountsReceivablePage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onAccountsReceivablePage.switchOutDefaultIFrame();
	}

	@Step
	public void addNewCreditNote() {
		onAccountsReceivablePage.clickOnAddNewBtn(2);
	}

	@Step
	public void addNewInvoice() {
		onAccountsReceivablePage.clickOnAddNewBtn(1);
	}

	@Step
	public void typeCustomerCode(String customerCode) {
		onAccountsReceivablePage.typeCustomerCode(customerCode);
	}

	@Step
	public void typeInvoiceDate(String invoiceDate) {
		onAccountsReceivablePage.typeInvoiceDate(invoiceDate);
	}

	@Step
	public void typeDueDate(String dueDate) {
		onAccountsReceivablePage.typeDueDate(dueDate);
	}

	@Step
	public void typeSalesPerson(String salesPerson) {
		onAccountsReceivablePage.typeSalesPerson(salesPerson);
	}

	@Step
	public void typeReferenceNo(String referenceNo) {
		onAccountsReceivablePage.typeReferenceNo(referenceNo);
	}

	@Step
	public void typeCurrency(String currency) {
		onAccountsReceivablePage.typeCurrency(currency);
	}

	@Step
	public void typeExchangeRate(String exchangeRate) {
		onAccountsReceivablePage.typeExchangeRate(exchangeRate);
	}

	@Step
	public void typeTotalAfterTaxAmt(String totalAfterTaxAmt) {
		onAccountsReceivablePage.typeTotalAfterTaxAmt(totalAfterTaxAmt);
	}

	@Step
	public void typeTotalAfterTaxHomeAmt(String totalAfterTaxHomeAmt) {
		onAccountsReceivablePage.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
	}

	@Step
	public void typeSegment1(String segment1) {
		onAccountsReceivablePage.typeSegment1(segment1);
	}

	@Step
	public void typeSegment2(String segment2) {
		onAccountsReceivablePage.typeSegment2(segment2);
	}

	@Step
	public void typeSegment3(String segment3) {
		onAccountsReceivablePage.typeSegment3(segment3);
	}

	@Step
	public void typeSegment4(String segment4) {
		onAccountsReceivablePage.typeSegment4(segment4);
	}

	@Step
	public void typeCreditNoteDate(String creditNoteDate) {
		onAccountsReceivablePage.typeCreditNoteDate(creditNoteDate);
	}

	@Step
	public void typeCreditNoteCategory(String creditNoteCategory) {
		onAccountsReceivablePage.typeCreditNoteCategory(creditNoteCategory);
	}

	@Step
	public void typeCreditNoteJustification(String creditNoteJustification) {
		onAccountsReceivablePage.typeCreditNoteJustification(creditNoteJustification);
	}

	@Step
	public void typeRemarksToCustomer(String remarksToCustomer) {
		onAccountsReceivablePage.typeRemarksToCustomer(remarksToCustomer);
	}

	@Step
	public void clickOnSubmitButton() {
		onAccountsReceivablePage.clickOnSubmitButton();
	}

	@Step
	public void moveToCreditNoteTab() {
		onAccountsReceivablePage.switch_to_tab("Credit Note");
	}

	@Step
	public void moveToInvoiceTab() {
		onAccountsReceivablePage.switch_to_tab("Invoice");
	}

	@Step
	public boolean isSegment() {
		return onAccountsReceivablePage.isSegment();
	}

	public void setSegment(List<String> listSegment) {
		onAccountsReceivablePage.setSegment(listSegment);
	}

}
