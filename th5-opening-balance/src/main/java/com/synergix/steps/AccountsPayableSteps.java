package com.synergix.steps;

import java.util.List;

import com.synergix.page.AccountsPayablePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AccountsPayableSteps extends ScenarioSteps {

	AccountsPayablePage onAccountsPayablePage;

	public void switchToIFrame() {
		onAccountsPayablePage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onAccountsPayablePage.switchOutDefaultIFrame();
	}

	@Step
	public boolean checkSegment() {
		return onAccountsPayablePage.isSegment();
	}

	@Step
	public void moveToInvoiceTab() {
		onAccountsPayablePage.switch_to_tab("Invoice");
	}

	@Step
	public void addNewInvoice() {
		onAccountsPayablePage.clickOnAddNewBtn(1);
	}

	@Step
	public void clickOnSubmit() {
		onAccountsPayablePage.clickOnSubmitButton();
	}

	@Step
	public void updateInvoice(String noVCH) {
		onAccountsPayablePage.update(noVCH, true);
	}

	@Step
	public void updateCreditNote(String noVCH) {
		onAccountsPayablePage.update(noVCH, false);
	}

	@Step
	public void typeSupplierCode(String supplierCode) {
		onAccountsPayablePage.typeSupplierCode(supplierCode);
	}

	@Step
	public void typeSupplierInvoiceNo(String supplierInvoiceNo) {
		onAccountsPayablePage.typeSupplierInvoiceNo(supplierInvoiceNo);
	}

	@Step
	public void typeSupplierInvoiceDate(String supplierInvoiceDate) {
		onAccountsPayablePage.typeSupplierInvoiceDate(supplierInvoiceDate);
	}

	@Step
	public void typePostingDate(String postingDate) {
		onAccountsPayablePage.typePostingDate(postingDate);
	}

	@Step
	public void typeDueDate(String dueDate) {
		onAccountsPayablePage.typeDueDate(dueDate);
	}

	@Step
	public void typeReferenceNo(String referenceNo) {
		onAccountsPayablePage.typeReferenceNo(referenceNo);
	}

	@Step
	public void typeCurrency(String currency) {
		onAccountsPayablePage.typeCurrency(currency);
	}

	@Step
	public void typeExchangeRate(String exchangeRate) {
		onAccountsPayablePage.typeExchangeRate(exchangeRate);
	}

	@Step
	public void typeTotalAfterTaxAmt(String totalAfterTaxAmt) {
		onAccountsPayablePage.typeTotalAfterTaxAmt(totalAfterTaxAmt);
	}

	@Step
	public void typeTotalAfterTaxHomeAmt(String totalAfterTaxHomeAmt) {
		onAccountsPayablePage.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
	}

	@Step
	public void typeSegment1(String segment1) {
		onAccountsPayablePage.typeSegment1(segment1);
	}

	@Step
	public void typeSegment2(String segment2) {
		onAccountsPayablePage.typeSegment2(segment2);
	}

	@Step
	public void typeSegment3(String segment3) {
		onAccountsPayablePage.typeSegment3(segment3);
	}

	@Step
	public void typeSegment4(String segment4) {
		onAccountsPayablePage.typeSegment4(segment4);
	}

	@Step
	public void typeSupplierCreditNoteNo(String supplierCreditNoteNo) {
		onAccountsPayablePage.typeSupplierCreditNoteNo(supplierCreditNoteNo);
	}

	@Step
	public void typeSupplierCreditNoteDate(String supplierCreditNoteDate) {
		onAccountsPayablePage.typeSupplierCreditNoteDate(supplierCreditNoteDate);
	}

	@Step
	public void typeCreditNoteCategory(String creditNoteCategory) {
		onAccountsPayablePage.typeCreditNoteCategory(creditNoteCategory);
	}

	@Step
	public void typeCreditNoteJustification(String creditNoteJustification) {
		onAccountsPayablePage.typeCreditNoteJustification(creditNoteJustification);
	}

	@Step
	public void moveToCreditNoteTab() {
		onAccountsPayablePage.switch_to_tab("Credit Note");
	}

	@Step
	public void addNewCreditNote() {
		onAccountsPayablePage.clickOnAddNewBtn(2);
	}

	public String getToday() {
		return onAccountsPayablePage.getToday();
	}

	public void setSegment(List<String> listSegment) {
		onAccountsPayablePage.setSegment(listSegment);
	}

}
