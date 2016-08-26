package com.synergix.processing.accountspayable.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountspayable.page.APInvoicePage;

public class APInvoiceSteps extends ScenarioSteps {
	APInvoicePage onAPInvoicePage;

	public String getToday() {
		return onAPInvoicePage.getToday();
	}

	public void switchToIFrame() {
		onAPInvoicePage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onAPInvoicePage.switchOutDefaultIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onAPInvoicePage.clickBtn("New");
		onAPInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnSubmitBtn() {
		onAPInvoicePage.clickBtn("Submit");
		onAPInvoicePage.chooseYesOnUpdateConfirmation();
		onAPInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public void typeSupplier(String supplier) {
		onAPInvoicePage.typeSupplier(supplier);
	}

	@Step
	public void moveToheadertab() {
		onAPInvoicePage.switch_to_tab("Header");
		onAPInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public void typeCurrency(String currency) {
		onAPInvoicePage.typeCurrency(currency);
	}

	@Step
	public void typePostingDate(String postingDate) {
		onAPInvoicePage.typePostingDate(postingDate);
	}

	@Step
	public void typeSupplierInvoiceNo(String supplierInvoiceNo) {
		onAPInvoicePage.typeSupplierInvoiceNo(supplierInvoiceNo);
	}

	@Step
	public void typeDiscDate(String discDate) {
		onAPInvoicePage.typeDiscDate(discDate);
	}

	@Step
	public void typeSupplierDONo(String supplierDONo) {
		onAPInvoicePage.typeSupplierDONo(supplierDONo);
	}

	@Step
	public void typeBillOfLadingNo(String billOfLadingNo) {
		onAPInvoicePage.typeBillOfLadingNo(billOfLadingNo);
	}

	@Step
	public void chooseCustomTaxInvoice(String customTaxInvoice) {
		onAPInvoicePage.chooseCustomTaxInvoice(customTaxInvoice);
	}

	@Step
	public void typeSalesTax(String salesTax) {
		onAPInvoicePage.typeSalesTax(salesTax);
	}

	@Step
	public void typeDueDate(String dueDate) {
		onAPInvoicePage.typeDueDate(dueDate);
	}

	@Step
	public void typeSupplierInvoiceDate(String supplierInvoiceDate) {
		onAPInvoicePage.typeSupplierInvoiceDate(supplierInvoiceDate);
	}

	@Step
	public void typeDefaultDiscount(String defaultDiscount) {
		onAPInvoicePage.typeDefaultDiscount(defaultDiscount);
	}

	@Step
	public void typeSupplierDODate(String supplierDODate) {
		onAPInvoicePage.typeSupplierDODate(supplierDODate);
	}

	@Step
	public void typeImportPermitNo(String importPermitNo) {
		onAPInvoicePage.typeImportPermitNo(importPermitNo);
	}

	@Step
	public void typeReferenceNo(String referenceNo) {
		onAPInvoicePage.typeReferenceNo(referenceNo);
	}

	@Step
	public void typeInventoryLocation(String inventoryLocation) {
		onAPInvoicePage.typeInventoryLocation(inventoryLocation);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onAPInvoicePage.setSegment(listSegment);
	}

	public boolean searchVchNo(String voucherNo) {
		return onAPInvoicePage.searchVchNo(voucherNo);
	}

	// ======= DETAIL HEADER TAB ===========
	@Step
	public void typeType(String type, int rowIndex) {
		onAPInvoicePage.chooseType(type, rowIndex);
	}

	@Step
	public void typeItemCodeRemarks(String itemCodeRemarks, int rowIndex) {
		onAPInvoicePage.typeItemCodeRemarks(itemCodeRemarks, rowIndex);
	}

	@Step
	public void typeQtyUOM(String qtyUOM, int rowIndex) {
		onAPInvoicePage.typeQtyUOM(qtyUOM, rowIndex);
	}

	@Step
	public void typePackSize(String packSize, int rowIndex) {
		onAPInvoicePage.choosePackSize(packSize, rowIndex);
	}

	@Step
	public void typeCostType(String costType, int rowIndex) {
		onAPInvoicePage.typeCostType(costType, rowIndex);
	}

	@Step
	public void typeDiscount(String discount, int rowIndex) {
		onAPInvoicePage.typeDiscount(discount, rowIndex);
	}

	@Step
	public void typeTotalAmt(String totalAmt, int rowIndex) {
		onAPInvoicePage.typeTotalAmt(totalAmt, rowIndex);
	}

	@Step
	public void chooseSalesTax(String salesTax, int rowIndex) {
		onAPInvoicePage.typeSalesTax(salesTax, rowIndex);
	}

	@Step
	public void clickAddDetail() {
		onAPInvoicePage.clickBtn("Add");
		onAPInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public int countRowDetail() {
		return onAPInvoicePage.countRowDetail();
	}

	@Step
	public void setSegment(List<String> listSegment, int rowIndex) {
		String xParentTb = "//table[@id='lineItemsForm:lineItemsTable']";
		onAPInvoicePage.setSegment(xParentTb, listSegment, rowIndex);
	}

	// ======= PAYMENT INFORMATION TAB ===========
	public void moveToPaymentInformation() {
		onAPInvoicePage.switch_to_tab("Payment Information");
		onAPInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public void choosePaymentOption(String paymentOption) {
		onAPInvoicePage.choosePaymentOption(paymentOption);
	}

	@Step
	public void choosePaymentTerm(String paymentTerm) {
		onAPInvoicePage.choosePaymentTerm(paymentTerm);
	}

	@Step
	public void typePaymentTermTenor(String paymentTermTenor) {
		onAPInvoicePage.typePaymentTermTenor(paymentTermTenor);
	}

	@Step
	public void choosePaymentMethod(String paymentMethod) {
		onAPInvoicePage.choosePaymentMethod(paymentMethod);
	}

	@Step
	public void typePaymentAmount(String paymentAmount) {
		onAPInvoicePage.typePaymentAmount(paymentAmount);
	}

	@Step
	public void typePaymentParty(String paymentParty) {
		onAPInvoicePage.typePaymentParty(paymentParty);
	}

	@Step
	public void typePaymentAddress(String paymentAddress) {
		onAPInvoicePage.typePaymentAddress(paymentAddress);
	}

	@Step
	public void typePaymentContact(String paymentContact) {
		onAPInvoicePage.typePaymentContact(paymentContact);
	}

	@Step
	public void chooseDelDetailRow(int rowIndex) {
		onAPInvoicePage.chooseDelDetailRow(rowIndex);
	}

	@Step
	public void chooseDelAllDetailRow() {
		onAPInvoicePage.chooseDelAllDetailRow();
	}

	@Step
	public void getAPInvoiceNo(String ssAPInvNo) {
		onAPInvoicePage.getAPInvoiceNo(ssAPInvNo);
	}

	public List<String> getDatafromSession(String ssAPInvNo) {
		return onAPInvoicePage.getDataWithSession(ssAPInvNo);
	}

	@Step
	public void verify(String nameTable, String tableData) {
	}
}
