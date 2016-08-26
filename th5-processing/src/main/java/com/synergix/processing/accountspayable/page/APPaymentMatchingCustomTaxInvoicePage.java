package com.synergix.processing.accountspayable.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class APPaymentMatchingCustomTaxInvoicePage extends TH5PageObject {

	public APPaymentMatchingCustomTaxInvoicePage(WebDriver driver) {
		super(driver);
	}

	private String xDetailTb = "//table[contains(@id, 'detailTable')]";
	private String xSearchInvoiceTb = "//table[@id = 'searchResult_Form:searchResult_Table']";

	public boolean typeCustomTaxInvoiceNo(String customTaxInvoiceNo) {
		if (customTaxInvoiceNo.isEmpty()) {
			clickSearchIconWithLabel("Custom Tax Invoice No");
			clickBtn("Search");
			waitForAllJSCompletes();
			return addFirstSearchResult();
		} else {
			enterInputFieldWithLabel("Custom Tax Invoice No",
					customTaxInvoiceNo.toUpperCase());
			return true;
		}
	}

	public void typeBillOfLadingNo(String billOfLadingNo) {
		try {
			enterInputFieldWithLabel("Bill Of Lading No.", billOfLadingNo);
		} catch (Exception ex) {
		}
	}

	public void chooseDelAllInvoice() {
		String xDelAll = xPathTbHeaderCell(xDetailTb, "Del") + "//input";
		if (findAll(xDetailTb + "/tbody/tr[@class]").size() > 0) {
			clickOnElement(xDelAll);
			waitForAllJSCompletes();
			clickBtn("Delete");
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public void typeInvoiceNo(String invoiceNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Invoice No.");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//input", invoiceNo);
	}

	public void chooseDel(String del, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Del");
		String xRowSelect = xPathTbDataCellByPosition(xDetailTb, rowIndex,
				colIndex) + "//input[@type='checkbox']";
		if (!$(xRowSelect).isSelected()) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			clickBtn("Delete");
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public int countRowInvoiceTb() {
		return findAll(xDetailTb + "/tbody/tr[@class]").size();
	}

	public boolean addFirstSearchResult() {
		String xFirstRow = xSearchInvoiceTb + "/tbody/tr[1]/td[1]/a[@href]";
		try {
			clickOnElement(xFirstRow);
			waitForAllJSCompletes();
			return true;
		} catch (Exception ex) {
			closePopup();
			System.out.println("***[ERROR MESSAGE]*** " + ex);
			return false;
		}
	}

	public void clickOnSearchIcon(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Invoice No.");
		String xRowSelect = xPathTbDataCellByPosition(xDetailTb, rowIndex,
				colIndex) + "//img";

		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
		}
	}
}
