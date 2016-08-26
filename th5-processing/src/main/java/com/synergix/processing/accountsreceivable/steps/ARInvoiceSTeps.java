package com.synergix.processing.accountsreceivable.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountsreceivable.pages.ARInvoicePage;

public class ARInvoiceSTeps extends ScenarioSteps {

	ARInvoicePage onARInvoicePage;

	@Step
	public void switchOutDefaultIFrame() {
		onARInvoicePage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onARInvoicePage.switchToIFrame();
	}

	@Step
	public void switchToDrafTab() {
		onARInvoicePage.switch_to_tab("Draft");
		onARInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public void search(String invNo) {
		onARInvoicePage.search(invNo);
	}

	public void selectInv(String invNo) {
		onARInvoicePage.clickINv(invNo);
	}

	@Step
	public void clickOnNewBtn() {
		onARInvoicePage.clickBtn("New");
		onARInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public void type_Customer(String customer) {
		onARInvoicePage.type_Customer(customer);
	}

	@Step
	public void type_InvoiceDate(String invoiceDate) {
		onARInvoicePage.type_InvoiceDate(invoiceDate);
	}

	@Step
	public void type_RefNo(String refNo) {
		onARInvoicePage.type_RefNo(refNo);
	}

	@Step
	public void type_Currency(String currency) {
		onARInvoicePage.type_Currency(currency);
	}

	@Step
	public void type_salesPerson(String salesPerson) {
		onARInvoicePage.type_salesPerson(salesPerson);
	}

	@Step
	public void type_defaultSalesTax(String defaultSalesTax) {
		onARInvoicePage.type_defaultSalesTax(defaultSalesTax);
	}

	@Step
	public void type_customerPONo(String customerPONo) {
		onARInvoicePage.type_customerPONo(customerPONo);
	}

	@Step
	public void type_defaultDisc(String defaultDisc) {
		onARInvoicePage.type_defaultDisc(defaultDisc);
	}

	@Step
	public void type_location(String location) {
		onARInvoicePage.type_location(location);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onARInvoicePage.setSegment(listSegment);
	}

	String xBillingDetailTb = "//table[contains(@id, 'lineItemsTable') and child::thead]";

	@Step
	public int countRowTb() {
		return onARInvoicePage.findAll(xBillingDetailTb + "/tbody/tr[@class]")
				.size();
	}

	@Step
	public void addLI() {
		onARInvoicePage.clickBtn("Add");
		onARInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public void select_Type(String type, int rowIndex) {
		onARInvoicePage.select_Type(type, rowIndex);
	}

	@Step
	public void type_ItemCode(String ItemCode, int rowIndex) {
		onARInvoicePage.type_ItemCode(ItemCode, rowIndex);
	}

	@Step
	public void type_QtyUOM(String QtyUOM, int rowIndex) {
		onARInvoicePage.type_QtyUOM(QtyUOM, rowIndex);
	}

	@Step
	public void select_NoOfPacksPackSize(String NoOfPacksPackSize, int rowIndex) {
		onARInvoicePage.select_NoOfPacksPackSize(NoOfPacksPackSize, rowIndex);
	}

	@Step
	public void type_unitPricePriceType(String unitPricePriceType, int rowIndex) {
		onARInvoicePage.type_unitPricePriceType(unitPricePriceType, rowIndex);
	}

	@Step
	public void type_disc(String disc, int rowIndex) {
		onARInvoicePage.type_disc(disc, rowIndex);
	}

	public void type_amount(String amount, int rowIndex) {
		onARInvoicePage.type_amount(amount, rowIndex);
	}

	@Step
	public void setSegment(List<String> listSegment, int rowIndex) {
		onARInvoicePage.setSegment(xBillingDetailTb, listSegment, rowIndex);
	}

	@Step
	public void type_salesTax(String salesTax, int rowIndex) {
		onARInvoicePage.type_salesTax(salesTax, rowIndex);
	}

	@Step
	public void type_serialNo(String serialNo, int rowIndex) {
		onARInvoicePage.type_serialNo(serialNo, rowIndex);
	}

	@Step
	public void check_Delete1(int rowIndex) {
		onARInvoicePage.check_Delete(rowIndex);
	}

	@Step
	public void clickOnDeletetext(int rowIndex) {
		onARInvoicePage.clickOnDeletetext(rowIndex);
	}

	@Step
	public void check_Delete(int rowIndex) {
		onARInvoicePage.check_Delete(rowIndex);
	}

	@Step
	public void select_in_payment_option(String paymentOption) {
		onARInvoicePage.select_in_payment_option(paymentOption);
	}

	@Step
	public void select_in_payment_term(String paymentTerm) {
		onARInvoicePage.select_in_payment_term(paymentTerm);
	}

	@Step
	public void enter_payment_term_tenor(String paymentTermTenor) {
		onARInvoicePage.enter_payment_term_tenor(paymentTermTenor);
	}

	public void select_in_payment_method(String paymentMethod) {
		onARInvoicePage.select_in_payment_method(paymentMethod);
	}

	@Step
	public void enter_payment_term_tenor_code(String paymentTermTenorCode) {
		onARInvoicePage.enter_payment_term_tenor_code(paymentTermTenorCode);
	}

	@Step
	public void enter_billing_address(String billingAddress) {
		onARInvoicePage.enter_billing_address(billingAddress);
	}

	@Step
	public void enter_billingParty(String billingParty) {
		onARInvoicePage.enter_billingParty(billingParty);
	}

	@Step
	public void enter_billing_contact(String billingContact) {
		onARInvoicePage.enter_billing_contact(billingContact);
	}

	@Step
	public void intoPaymentInformation() {
		onARInvoicePage.switch_to_tab("Payment Information");
		onARInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public void clickSubmitbtn() {
		onARInvoicePage.clickBtn("Submit");
		onARInvoicePage.chooseYesOnUpdateConfirmation();
		onARInvoicePage.chooseOkOnInforPanel();
		onARInvoicePage.waitForAllJSCompletes();
	}

	@Step
	public String getToday() {
		return onARInvoicePage.getToday();
	}

	@Step
	public void getInvoiceNo(String ssARInv) {
		onARInvoicePage.getInvoiceNo(ssARInv);
	}

	@Step
	public void clickOnPreviewBtn(String reportName) {
		onARInvoicePage.clickPreviewBtn(reportName);
	}

	@Step
	public String getDataWithSession(String ssARInv) {
		return onARInvoicePage.getDataWithSession(ssARInv, 0);
	}

	@Step
	public void clickOnPreviewBtn(String invNo, String reportName) {
		String xHistoryTb = "//table[@id='arInvHstForm:arInvHstHdrTable']";
		onARInvoicePage.clickPreviewHST(xHistoryTb, "Inv No.", invNo,
				reportName);
	}
}
