package com.synergix.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class AccountsReceivablePage extends TH5PageObject {

	public AccountsReceivablePage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAddNewBtn(int index) {
		String xPath = "(//*[@id='formPage']//input[@value='New'])[" + index + "]";
		$(xPath).click();
		waitForAllJSCompletes();
	}

	public void typeCustomerCode(String customerCode) {
		enterInputFieldCodeWithLabel("Customer Code", customerCode);
	}

	public void typeInvoiceDate(String invoiceDate) {
		enterInputFieldWithLabel("Invoice Date", invoiceDate);
	}

	public void typeDueDate(String dueDate) {
		enterInputFieldWithLabel("Due Date", dueDate);
	}

	public void typeSalesPerson(String salesPerson) {
		enterInputFieldCodeWithLabel("Sales Person", salesPerson);
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

	public void typeCreditNoteDate(String creditNoteDate) {
		enterInputFieldWithLabel("Credit Note Date", creditNoteDate);
	}

	public void typeCreditNoteCategory(String creditNoteCategory) {
		enterInputFieldCodeWithLabel("Credit Note Category", creditNoteCategory);
	}

	public void typeCreditNoteJustification(String creditNoteJustification) {
		enterTextAreaWithLabel("Credit Note Justification", creditNoteJustification);
	}

	public void typeRemarksToCustomer(String remarksToCustomer) {
		enterTextAreaWithLabel("Remarks To Customer", remarksToCustomer);
	}

	public void clickOnSubmitButton() {
		String xPath = "//*[@value='Submit']";
		$(xPath).click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}
}
