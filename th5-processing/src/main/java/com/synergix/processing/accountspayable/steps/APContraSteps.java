package com.synergix.processing.accountspayable.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountspayable.page.APContraPage;

public class APContraSteps extends ScenarioSteps {
	APContraPage onAPContraPage;

	@Step
	public void switchOutDefaultIFrame() {
		onAPContraPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onAPContraPage.switchToIFrame();
	}

	@Step
	public void typeParty(String party) {
		onAPContraPage.typeParty(party);
	}

	public void clickOnNewBtn() {
		onAPContraPage.clickBtn("New");
		onAPContraPage.waitForAllJSCompletes();
	}

	public boolean searchDrafVoucherNo(String contraVoucherNo) {
		return onAPContraPage.searchDrafVoucherNo(contraVoucherNo);
	}

	public boolean searchHSTVoucherNo(String contraVoucherNo) {
		return onAPContraPage.searchHSTVoucherNo(contraVoucherNo);
	}

	// =====================================
	// ============= HEADER TAB ============
	@Step
	public void chooseContraVoucherDate(String contraVoucherDate) {
		onAPContraPage.chooseContraVoucherDate(contraVoucherDate);
	}

	@Step
	public void typeCurrency(String currency) {
		onAPContraPage.typeCurrency(currency);
	}

	@Step
	public void typeExchRateBuyRate(String exchRateBuyRate) {
		onAPContraPage.typeExchRateBuyRate(exchRateBuyRate);
	}

	@Step
	public void typeExchRateSellRate(String exchRateSellRate) {
		onAPContraPage.typeExchRateSellRate(exchRateSellRate);
	}

	@Step
	public void typeRemarksCode(String remarksCode) {
		onAPContraPage.typeRemarksCode(remarksCode);
	}

	@Step
	public void typeRemarks(String remarks) {
		onAPContraPage.typeRemarks(remarks);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onAPContraPage.setSegment(listSegment);
	}

	public String getToday() {
		return onAPContraPage.getToday();
	}

	@Step
	public void moveToHeaderTab() {
		onAPContraPage.switch_to_tab("Header");
		onAPContraPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToARInvoiceTab() {
		onAPContraPage.switch_to_tab("AR Invoices");
		onAPContraPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToAPInvoiceTab() {
		onAPContraPage.switch_to_tab("AP Invoices");
		onAPContraPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToDrafTab() {
		onAPContraPage.switch_to_tab("Draf");
		onAPContraPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToHSTTab() {
		onAPContraPage.switch_to_tab("History");
		onAPContraPage.waitForAllJSCompletes();
	}

	// ====================================================
	// =================== AP INVOICE TAB ==================
	private String xAPInvoiceTb = "//table[@id='apInvForm:AP_INVOICE_TABLE']";

	@Step
	public int typeAPInvNo(String invNo) {
		return onAPContraPage.typeAPInvNo(invNo);
	}

	@Step
	public void typeSupInvNo(String supInvNo) {
		onAPContraPage.typeAPInvNo(supInvNo);
	}

	@Step
	public void typeAgeDate(String ageDate) {
		onAPContraPage.typeAgeDate(ageDate);
	}

	@Step
	public void typeAPInvCcyRefNo(String invCcyRefNo) {
		onAPContraPage.typeInvCcyRefNo(xARInvoiceTb, invCcyRefNo);
	}

	@Step
	public void typeAPdInvAmtHomeAmt(String dInvAmtHomeAmt, int rowIndex) {
		onAPContraPage.typedInvAmtHomeAmt(xAPInvoiceTb, dInvAmtHomeAmt,
				rowIndex);
	}

	@Step
	public void chooseAPApplyFull(String applyFull, int rowIndex) {
		onAPContraPage.chooseApplyFull(xAPInvoiceTb, applyFull, rowIndex);
	}

	// ====================================================
	// =================== AR INVOICE TAB ==================
	private String xARInvoiceTb = "//table[@id='arInvForm:AR_INVOICE_TABLE']";

	@Step
	public int typeARInvoiceNo(String invoiceNo) {
		return onAPContraPage.typeARInvoiceNo(invoiceNo);
	}

	@Step
	public void typeInvoiceDate(String invoiceDate) {
		onAPContraPage.typeInvoiceDate(invoiceDate);
	}

	@Step
	public void typeDueDate(String dueDate) {
		onAPContraPage.typeDueDate(dueDate);
	}

	@Step
	public void typeARInvCcyRefNo(String invCcyRefNo) {
		onAPContraPage.typeInvCcyRefNo(xARInvoiceTb, invCcyRefNo);
	}

	@Step
	public void typeARdInvAmtHomeAmt(String dInvAmtHomeAmt, int rowIndex) {
		onAPContraPage.typedInvAmtHomeAmt(xARInvoiceTb, dInvAmtHomeAmt,
				rowIndex);
	}

	@Step
	public void chooseARApplyFull(String applyFull, int rowIndex) {
		onAPContraPage.chooseApplyFull(xARInvoiceTb, applyFull, rowIndex);
	}

	@Step
	public void clickOnSubmitBtn() {
		onAPContraPage.clickBtn("Submit");
		onAPContraPage.chooseYesOnUpdateConfirmation();
		onAPContraPage.chooseOkOnInforPanel();
		onAPContraPage.waitForAllJSCompletes();
	}

	public void clickPreviewBtn(String reportName) {
		onAPContraPage.clickPreviewBtn(reportName);
	}

	public void clickPreviewHSTBtn(String voucherNo, String reportName) {
		onAPContraPage.clickPreviewHSTBtn(voucherNo, reportName);
	}

	public void getVchNo(String ssContraVch) {
		onAPContraPage.getVchNo(ssContraVch);
	}

	public String getDataWithSession(String ssContraVch) {
		return onAPContraPage.getDataWithSession(ssContraVch, 0);
	}
}
