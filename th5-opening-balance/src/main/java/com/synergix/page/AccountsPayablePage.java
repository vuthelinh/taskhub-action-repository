package com.synergix.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class AccountsPayablePage extends TH5PageObject {

	public AccountsPayablePage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAddNewBtn(int index) {
		String xPath = "(//*[@id='formPage']//input[@value='New'])[" + index + "]";
		$(xPath).click();
		waitForAllJSCompletes();
	}

	public void typeSupplierCode(String supplierCode) {
		enterInputFieldCodeWithLabel("Supplier Code", supplierCode);
	}

	public void typeSupplierInvoiceNo(String supplierInvoiceNo) {
		enterInputFieldWithLabel("Supplier Invoice No.", supplierInvoiceNo);
	}

	public void typeSupplierInvoiceDate(String supplierInvoiceDate) {
		enterInputFieldWithLabel("Supplier Invoice Date", supplierInvoiceDate);
	}

	public void typePostingDate(String postingDate) {
		enterInputFieldWithLabel("Posting Date", postingDate);
	}

	public void typeDueDate(String dueDate) {
		enterInputFieldWithLabel("Due Date", dueDate);
	}

	public void typeReferenceNo(String referenceNo) {
		enterInputFieldWithLabel("Reference No.", referenceNo);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typeExchangeRate(String exchangeRate) {
		enterInputFieldWithLabelNoVerify("Exchange Rate", exchangeRate);
	}

	public void typeTotalAfterTaxAmt(String totalAfterTaxAmt) {
		enterInputFieldWithLabelNoVerify("Total After Tax Amt", totalAfterTaxAmt);
	}

	public void typeTotalAfterTaxHomeAmt(String totalAfterTaxHomeAmt) {
		enterInputFieldWithLabel("Total After Tax Home Amt", totalAfterTaxHomeAmt);
	}

	public void typeSegment1(String segment1) {
		enterInputFieldCodeWithLabel("Segment 1", segment1);
	}

	public void typeSegment2(String segment2) {
		enterInputFieldCodeWithLabel("Segment 2", segment2);
	}

	public void typeSegment3(String segment3) {
		enterInputFieldCodeWithLabel("Segment 3", segment3);
	}

	public void typeSegment4(String segment4) {
		enterInputFieldCodeWithLabel("Segment 4", segment4);
	}

	public void typeSupplierCreditNoteNo(String supplierCreditNoteNo) {
		enterInputFieldWithLabel("Supplier Credit Note No", supplierCreditNoteNo);
	}

	public void typeSupplierCreditNoteDate(String supplierCreditNoteDate) {
		enterInputFieldWithLabel("Supplier Credit Note Date", supplierCreditNoteDate);
	}

	public void typeCreditNoteCategory(String creditNoteCategory) {
		enterInputFieldCodeWithLabel("Credit Note Category", creditNoteCategory);
	}

	public void typeCreditNoteJustification(String creditNoteJustification) {
		enterTextAreaWithLabel("Credit Note Justification", creditNoteJustification);
	}

	public void clickOnSubmitButton() {
		String xPath = "//*[@value='Submit']";
		$(xPath).click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void update(String noVCH, boolean isInv) {
		String xPathFilterInv = "//*[@id='invoiceTab']//thead/tr/th[2]//input";
		String xPathInv = "//*[@id='invoiceTab']//thead/following-sibling::tbody/tr[1]/td[2]";
		String xPathFilterCrn = "//*[@id='creditNoteTab']//thead/tr/th[2]//input";
		String xPathCrn = "//*[@id='creditNoteTab']//thead/following-sibling::tbody/tr[1]/td[2]";

		if (isInv) {
			waitTypeAndEnterThenUpdateValue(xPathFilterInv, noVCH);
			waitElementToBeClickable(xPathInv).click();
			waitForAllJSCompletes();
		} else {
			waitTypeAndEnterThenUpdateValue(xPathFilterCrn, noVCH);
			waitElementToBeClickable(xPathCrn).click();
			waitForAllJSCompletes();
		}
	}
}
