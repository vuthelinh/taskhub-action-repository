package com.synergix.processing.accountspayable.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountspayable.page.APPaymentMatchingCustomTaxInvoicePage;

public class APPaymentMatchingCustomTaxInvoiceSteps extends ScenarioSteps {

	APPaymentMatchingCustomTaxInvoicePage onAPPaymentMatchingCustomTaxInvoicePage;

	@Step
	public void switchOutDefaultIFrame() {
		onAPPaymentMatchingCustomTaxInvoicePage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onAPPaymentMatchingCustomTaxInvoicePage.switchToIFrame();
	}

	@Step
	public boolean typeCustomTaxInvoiceNo(String customTaxInvoiceNo) {
		return onAPPaymentMatchingCustomTaxInvoicePage
				.typeCustomTaxInvoiceNo(customTaxInvoiceNo);
	}

	@Step
	public void typeBillOfLadingNo(String billOfLadingNo) {
		onAPPaymentMatchingCustomTaxInvoicePage.chooseDelAllInvoice();
		onAPPaymentMatchingCustomTaxInvoicePage
				.typeBillOfLadingNo(billOfLadingNo);
	}

	@Step
	public void typeUpdateBillOfLadingNo(String billOfLadingNo) {
		onAPPaymentMatchingCustomTaxInvoicePage
				.typeBillOfLadingNo(billOfLadingNo);
	}

	@Step
	public void typeInvoiceNo(String invoiceNo, int rowIndex) {
		onAPPaymentMatchingCustomTaxInvoicePage.typeInvoiceNo(invoiceNo,
				rowIndex);
	}

	@Step
	public void chooseDel(String del, int rowIndex) {
		onAPPaymentMatchingCustomTaxInvoicePage.chooseDel(del, rowIndex);
	}

	@Step
	public void clickOnAddBtn() {
		onAPPaymentMatchingCustomTaxInvoicePage.waitForAllJSCompletes();
		waitABit(1000);
		onAPPaymentMatchingCustomTaxInvoicePage.clickBtn("Add");
		onAPPaymentMatchingCustomTaxInvoicePage.waitForAllJSCompletes();
		waitABit(1000);
	}

	@Step
	public int countRowInvoiceTb() {
		return onAPPaymentMatchingCustomTaxInvoicePage.countRowInvoiceTb();
	}

	public void clickOnSearchIcon(int rowIndex) {
		onAPPaymentMatchingCustomTaxInvoicePage.clickOnSearchIcon(rowIndex);
	}

	public void clickOnSearchBtn() {
		onAPPaymentMatchingCustomTaxInvoicePage.clickBtn("Search");
		onAPPaymentMatchingCustomTaxInvoicePage.waitForAllJSCompletes();
	}

	public boolean addFirstInvoice() {
		return onAPPaymentMatchingCustomTaxInvoicePage.addFirstSearchResult();
	}

}
