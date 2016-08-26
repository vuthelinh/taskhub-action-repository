package com.synergix.mtsetup.financial.accounting.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class MTGLRecurringVCHPage extends TH5PageObject {

	public MTGLRecurringVCHPage(WebDriver driver) {
		super(driver);
	}

	public void typeRecurringVoucherCode(String recurringVoucherCode) {
		enterInputFieldCodeWithLabel("Recurring Voucher Code", recurringVoucherCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void chooseExchangeRateType(String exchangeRateType) {
		selectRadioButton("Exchange Rate Type", exchangeRateType);
	}

	public void typeSourceDocumentType(String sourceDocumentType) {
		enterInputFieldCodeWithLabel("Source Document Type", sourceDocumentType);
	}

	public void typeSourceDocumentNo(String sourceDocumentNo) {
		enterInputFieldWithLabel("Source Document No", sourceDocumentNo);
	}

	public void chooseRecurringDay(String recurringDay) {
		selectDdlWithLabelByText("Recurring Day", recurringDay);
	}

	public void chooseRecurringFrequency(String recurringFrequency) {
		selectRadioButton("Recurring Frequency", recurringFrequency);
	}

	public void typeRecurrenceStartDate(String recurrenceStartDate) {
		enterInputFieldWithLabel("Recurrence Start Date", recurrenceStartDate);
	}

	public void typeRecurrenceEndDate(String recurrenceEndDate) {
		enterInputFieldWithLabel("Recurrence End Date", recurrenceEndDate);
	}

	public void typeNextRecurrenceDate(String nextRecurrenceDate) {
		enterInputFieldWithLabel("Next Recurrence Date", nextRecurrenceDate);
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

	String xParentDetailTb = "//table[contains(@id, 'lineItemsForm:lineItemsTable')]";
	String xPathPopup = "//table[contains(@id, 'popupModalPanel')]";

	@Override
	public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "(" + xParentDetailTb + "/tbody[preceding::thead][1]/tr/td[contains(@class,'cell')][" + _headerIndex
				+ "])[" + _rowIndex + "]";
	}

	public void typeGLAccountCode(String gLAccountCode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "GL Account Code");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex) + "//input", gLAccountCode);
	}

	public void typeDetailDescription(String detailDescription, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Description");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex) + "//textarea",
				detailDescription);
	}

	public void typeNatureDebit(String natureDebit, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Nature Debit");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex) + "//input", natureDebit);
	}

	public void typeNaturalCredit(String naturalCredit, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Natural Credit");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex) + "//input", naturalCredit);
	}

	public void typeDetailSegment1(String detailSegment1) {
		enterInputFieldCodeWithLabel(xPathPopup, "Segment 1", detailSegment1);
	}

	public void typeDetailSegment2(String detailSegment2) {
		enterInputFieldCodeWithLabel(xPathPopup, "Segment 2", detailSegment2);
	}

	public void typeDetailSegment3(String detailSegment3) {
		enterInputFieldCodeWithLabel(xPathPopup, "Segment 3", detailSegment3);
	}

	public void typeDetailSegment4(String detailSegment4) {
		enterInputFieldCodeWithLabel(xPathPopup, "Segment 4", detailSegment4);
	}

	public void clickOnInfoSgmts(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Sgmts");
		$(xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex) + "//a[@href]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int getRowDetailTb() {
		String xCountRow = xParentDetailTb + "/tbody/tr";
		return findAll(xCountRow).size();
	}

}
