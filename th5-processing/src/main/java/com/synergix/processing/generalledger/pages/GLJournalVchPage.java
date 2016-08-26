package com.synergix.processing.generalledger.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class GLJournalVchPage extends TH5PageObject {

	public GLJournalVchPage(WebDriver driver) {
		super(driver);
	}

	String xDetailsTb = "//table[@id= 'lineItemsForm:lineItemsTable']";
	String xDraftTb = "//table[contains(@id, ':draftJV') and child::thead]";
	String xHistoryTb = "//table[contains(@id, ':HstJV') and child::thead]";

	public void chooseType(String type) {
		String xType = "//table[contains(@id, ':copy_selection')]//tbody//input[@type='radio' and following-sibling::*[text()='"
				+ type + "']]";
		clickOnElement(xType);
		waitForAllJSCompletes();
	}

	public void typeVoucherNo(String voucherNo) {
		enterInputFieldWithLabel("Voucher No", voucherNo);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeVoucherDate(String voucherDate) {
		enterInputFieldWithLabel("Voucher Date", voucherDate);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typeDocumentType(String documentType) {
		enterInputFieldCodeWithLabel("Document Type", documentType);
	}

	public void chooseExchangeRateType(String exchangeRateType) {
		selectRadioButton("Exchange Rate Type", exchangeRateType);
	}

	public void typeExchangeRate(String exchangeRate) {
		enterInputFieldWithLabelNoVerify("Exchange Rate", exchangeRate);
	}

	public void typeDocumentNo(String documentNo) {
		enterInputFieldWithLabel("Document No", documentNo);
	}

	public void setSegmentTb(List<String> listSegment, int rowIndex) {
		setSegment(xDetailsTb, listSegment, rowIndex);
	}

	public void getVchNoToSession(String ssGLJV) {
		String xParent = "//table[preceding-sibling::table[contains(@id, 'copy_selection')]]";
		String vchNo = getTextValueWithLabel(xParent, "Voucher No.", 2);
		setDataToNewSession(vchNo, ssGLJV);
	}

	public void clickPreviewHSTTab(String vchNo, String reportName) {
		clickPreviewHST(xHistoryTb, "Voucher No.", vchNo, reportName);
	}

	// ============== DETAILS ====================
	public void typeGLAccountNo(String gLAccountNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailsTb, "GL Account No / Remark");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailsTb, rowIndex, colIndex)
						+ "//input[@type='text']", gLAccountNo);
		waitForAllJSCompletes();
	}

	public void typeRemark(String remark, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailsTb, "GL Account No / Remark");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailsTb, rowIndex, colIndex)
						+ "//textarea", remark);
	}

	public void typeNatureDebit(String natureDebit, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailsTb,
				"Nature Debit Home Debit");
		waitTypeAndEnter(
				xPathTbDataCellByPosition("(" + xDetailsTb, rowIndex, colIndex)
						+ "//input[@type='text'])[1]", natureDebit);
	}

	public void typeHomeDebit(String homeDebit, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailsTb,
				"Nature Debit Home Debit");
		waitTypeAndEnter(
				xPathTbDataCellByPosition("(" + xDetailsTb, rowIndex, colIndex)
						+ "//input[@type='text'])[2]", homeDebit);
	}

	public void typeNatureCredit(String natureCredit, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailsTb,
				"Nature Credit Home Credit");
		waitTypeAndEnter(
				xPathTbDataCellByPosition("(" + xDetailsTb, rowIndex, colIndex)
						+ "//input[@type='text'])[1]", natureCredit);
	}

	public void typeHomeCredit(String homeCredit, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailsTb,
				"Nature Credit Home Credit");
		waitTypeAndEnter(
				xPathTbDataCellByPosition("(" + xDetailsTb, rowIndex, colIndex)
						+ "//input[@type='text'])[2]", homeCredit);
	}

	public void chooseDelete(String delete, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailsTb, "Delete");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailsTb, rowIndex, colIndex)
						+ "//input[@type='checkbox']", delete);
		waitForAllJSCompletes();
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
	}

	public boolean searchVchNo(String voucherNo) {
		return searchByFilter(xDraftTb, "Voucher No.", voucherNo);
	}

	public void chooseDeleteAll() {
		String xDeleteAll = xPathTbHeaderCell(xDetailsTb, "Delete")
				+ "//input[@type='checkbox']";
		clickOnElement(xDeleteAll);
		waitForAllJSCompletes();
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
	}
}
