package com.synergix.processing.accountsreceivable.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountsreceivable.pages.ARCreditNotePage;

public class ARCreditNoteSteps extends ScenarioSteps {
	ARCreditNotePage onARCreditNotePage;

	String xDrafTb = "//table[contains(@id, 'arCrnNewHdrTable') and child::thead]";

	@Step
	public void switchOutDefaultIFrame() {
		onARCreditNotePage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onARCreditNotePage.switchToIFrame();
	}

	@Step
	public boolean searchDrafARCrnNo(String crnNo) {
		return onARCreditNotePage.searchByFilter(xDrafTb, "Crn No.", crnNo);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onARCreditNotePage.setSegment(listSegment);
	}

	@Step
	public void switchToBillingTab() {
		onARCreditNotePage.switch_to_tab("Billing");
		onARCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnNewBtn() {
		onARCreditNotePage.clickBtn("New");
		onARCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void switchToDrafTab() {
		onARCreditNotePage.switch_to_tab("Draf");
		onARCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void switchToOutstandingTab() {
		onARCreditNotePage.switch_to_tab("Outstanding");
		onARCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void typeCustomer(String customer) {
		onARCreditNotePage.typeCustomer(customer);
	}

	@Step
	public void typeCreditNoteDate(String creditNoteDate) {
		onARCreditNotePage.typeCreditNoteDate(creditNoteDate);
	}

	@Step
	public void typeRefNo(String refNo) {
		onARCreditNotePage.typeRefNo(refNo);
	}

	@Step
	public void typeCustomerPONo(String customerPONo) {
		onARCreditNotePage.typeCustomerPONo(customerPONo);
	}

	@Step
	public void typeCurrency(String currency) {
		onARCreditNotePage.typeCurrency(currency);
	}

	@Step
	public void typeDefaultSalesTax(String defaultSalesTax) {
		onARCreditNotePage.typeDefaultSalesTax(defaultSalesTax);
	}

	@Step
	public void choosePaymentOption(String paymentOption) {
		onARCreditNotePage.choosePaymentOption(paymentOption);
	}

	@Step
	public void typeBillingContact(String billingContact) {
		onARCreditNotePage.typeBillingContact(billingContact);
	}

	@Step
	public void typeDefaultDisc(String defaultDisc) {
		onARCreditNotePage.typeDefaultDisc(defaultDisc);
	}

	@Step
	public void typeLocation(String location) {
		onARCreditNotePage.typeLocation(location);
	}

	@Step
	public void typeSalesPerson(String salesPerson) {
		onARCreditNotePage.typeSalesPerson(salesPerson);
	}

	@Step
	public void typeBillingAddress(String billingAddress) {
		onARCreditNotePage.typeBillingAddress(billingAddress);
	}

	@Step
	public void typeCreditNoteCategory(String creditNoteCategory) {
		onARCreditNotePage.typeCreditNoteCategory(creditNoteCategory);
	}

	@Step
	public void typeCreditNoteJustification(String creditNoteJustification) {
		onARCreditNotePage.typeCreditNoteJustification(creditNoteJustification);
	}

	@Step
	public void typeRemarksToCustomer(String remarksToCustomer) {
		onARCreditNotePage.typeRemarksToCustomer(remarksToCustomer);
	}

	@Step
	public void deleteAllBillingDetail() {
		onARCreditNotePage.deleteAllBillingDetail();
	}

	@Step
	public String getToday() {
		return onARCreditNotePage.getToday();
	}

	// ============= BILLING DETAIL =================

	public int countRowBillingTb() {
		return onARCreditNotePage.countRowBillingTb();
	}

	@Step
	public void chooseType(String type, int rowIndex) {
		onARCreditNotePage.chooseType(type, rowIndex);
	}

	@Step
	public void typeItemCode(String itemCode, int rowIndex) {
		onARCreditNotePage.typeItemCode(itemCode, rowIndex);
	}

	@Step
	public void typeRemarksDescription(String remarksDescription, int rowIndex) {
		onARCreditNotePage.typeRemarksDescription(remarksDescription, rowIndex);
	}

	@Step
	public void typeQtyUOM(String qtyUOM, int rowIndex) {
		onARCreditNotePage.typeQtyUOM(qtyUOM, rowIndex);
	}

	@Step
	public void typePackSizeNoOfPacks(String packSizeNoOfPacks, int rowIndex) {
		onARCreditNotePage.choosePackSizeNoOfPacks(packSizeNoOfPacks, rowIndex);
	}

	@Step
	public void typePriceType(String priceType, int rowIndex) {
		onARCreditNotePage.typePriceType(priceType, rowIndex);
	}

	@Step
	public void typeUnitPrice(String unitPrice, int rowIndex) {
		onARCreditNotePage.typeUnitPrice(unitPrice, rowIndex);
	}

	@Step
	public void typeDiscount(String discount, int rowIndex) {
		onARCreditNotePage.typeDiscount(discount, rowIndex);
	}

	@Step
	public void chooseAmount(String amount, int rowIndex) {
		onARCreditNotePage.chooseAmount(amount, rowIndex);
	}

	@Step
	public void typeSalesTax(String salesTax, int rowIndex) {
		onARCreditNotePage.typeSalesTax(salesTax, rowIndex);
	}

	@Step
	public void clickOnAddBtn() {
		onARCreditNotePage.clickBtn("Add");
		onARCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void setSegment(List<String> listSegment, int rowIndex) {
		onARCreditNotePage.setSegment(listSegment, rowIndex);
	}

	@Step
	public void chooseDelete(int rowIndex) {
		onARCreditNotePage.chooseDelete(rowIndex);
	}

	// =============== APPLICATION TAB ==========
	@Step
	public void typedCrnAmtHomeAmt(String dCrnAmtHomeAmt, int rowIndex) {
		onARCreditNotePage.typedCrnAmtHomeAmt(dCrnAmtHomeAmt, rowIndex);
	}

	@Step
	public void typedInvAmtHomeAmt(String dInvAmtHomeAmt, int rowIndex) {
		onARCreditNotePage.typedInvAmtHomeAmt(dInvAmtHomeAmt, rowIndex);
	}

	@Step
	public void typeApplyFull(int rowIndex) {
		onARCreditNotePage.typeApplyFull(rowIndex);
	}

	@Step
	public boolean searchInvNoApplied(String invNo) {
		return onARCreditNotePage.searchInvNoApplied(invNo);
	}

	@Step
	public void switchToApplicationTab() {
		onARCreditNotePage.switch_to_tab("Application");
		onARCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void getInvoiceNo(String ssCrnInv) {
		onARCreditNotePage.getInvoiceNo(ssCrnInv);
	}

	@Step
	public void clickOnSubmitBtn() {
		onARCreditNotePage.clickBtn("Submit");
		onARCreditNotePage.chooseYesOnUpdateConfirmation();
		onARCreditNotePage.chooseOkOnInforPanel();
		onARCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void clickPreview(String reportName) {
		onARCreditNotePage.clickPreviewBtn(reportName);
	}

	@Step
	public String getDataWithSession(String ssCrnInv) {
		return onARCreditNotePage.getDataWithSession(ssCrnInv, 0);
	}

	@Step
	public void clickPreviewHST(String invNo, String reportName) {
		onARCreditNotePage.clickOnPreviewHST(invNo, reportName);
	}

	@Step
	public boolean searchOstCrnNo(String invNo) {
		return onARCreditNotePage.searchOstCrnNo(invNo);
	}

	@Step
	public void typeApplicationDate(String applicationDate) {
		onARCreditNotePage.typeApplicationDate(applicationDate);
	}
}
