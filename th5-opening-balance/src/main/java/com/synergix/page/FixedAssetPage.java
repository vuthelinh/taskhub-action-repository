package com.synergix.page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class FixedAssetPage extends TH5PageObject {

	public FixedAssetPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnNewBtn() {
		clickBtn("New");
		waitForAllJSCompletes();
	}

	public void clickOnAddNewBtn() {
		clickBtn("Add");
		waitForAllJSCompletes();
	}

	public void clickOnSubmitButton() {
		String xPath = "//*[@value='Submit']";
		$(xPath).click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void update(String vchNo) {
		String xPathFilter = "//thead/tr/th[2]//input";
		$(xPathFilter).typeAndEnter(vchNo);
		waitForAllJSCompletes();
		waitABit(120);
		String xPathFirstRow = "//tbody[contains(@id, 'summaryTable')]//td[2 and descendant-or-self::*[text()='" + vchNo
				+ "' and @href]]//*[@href]";
		clickOnElement(xPathFirstRow);
		waitForAllJSCompletes();
	}

	public void clickInfoIcon(int row, int col) {
		String xPathInfoIcon = "(//*[@id='detailPanel']//tbody[preceding::thead]//tr[" + row
				+ "]/td[contains(@class,'cell')][" + col + "])//a";
		$(xPathInfoIcon).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnOkBtn() {
		String xPath = parentPopupXpath + "//*[@value='OK']";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnDoneBtn() {
		String xPath = parentPopupXpath + "//*[@value='Done']";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typeFixedAssetCode(String fixedAssetCode) {
		try {
			enterInputFieldCodeWithLabel("Fixed Asset Code", fixedAssetCode);
		} catch (Exception ex) {
		}
	}

	public void typeTransactionDate(String transactionDate) {
		enterInputFieldWithLabel("Transaction Date", transactionDate);
	}

	public void typeSupplier(String supplier) {
		enterInputFieldCodeWithLabel("Supplier", supplier);
	}

	public void typeSupplierInvoiceNo(String supplierInvoiceNo) {
		enterInputFieldWithLabel("Supplier Invoice No.", supplierInvoiceNo);
	}

	public void typeSupplierInvoiceDate(String supplierInvoiceDate) {
		enterInputFieldWithLabel("Supplier Invoice Date", supplierInvoiceDate);
	}

	public void typeSubject(String subject) {
		enterInputFieldWithLabel("Subject", subject);
	}

	public void typeDescription(String description) {
		enterTextAreaWithLabel("Description", description);
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

	// REMARKS
	public void typeInternalRemarksCode(String internalRemarksCode) {
		enterInputFieldCodeWithLabel("Internal Remarks Code", internalRemarksCode);
	}

	public void typeExternalRemarksCode(String externalRemarksCode) {
		enterInputFieldCodeWithLabel("External Remarks Code", externalRemarksCode);
	}

	public void typeInternalRemarks(String internalRemarks) {
		enterTextAreaWithLabel("Internal Remarks", internalRemarks);
	}

	public void typeExternalRemarks(String externalRemarks) {
		enterTextAreaWithLabel("External Remarks", externalRemarks);
	}

	private String parentDetailXpath = "//*[@id='detailPanel']";
	private String parentPopupXpath = "//*[@id='popupModalPanelCDiv']";

	public void typeSerialNo(String serialNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentDetailXpath, "Serial No");
		waitTypeAndEnterThenUpdateCodeValue(
				xPathTbDataCellByPosition(parentDetailXpath, rowIndex, colIndex) + "//input", serialNo);
	}

	public void typeLocation(String location, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentDetailXpath, "Location");
		waitTypeAndEnterThenUpdateCodeValue(
				xPathTbDataCellByPosition(parentDetailXpath, rowIndex, colIndex) + "//input", location);
	}

	public void typeAssetCost(String assetCost, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentDetailXpath, "Asset Cost");
		waitTypeAndEnter(xPathTbDataCellByPosition(parentDetailXpath, rowIndex, colIndex) + "//input", assetCost);
	}

	public void typeResidualValue(String residualValue, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentDetailXpath, "Residual Value");
		waitTypeAndEnter(xPathTbDataCellByPosition(parentDetailXpath, rowIndex, colIndex) + "//input", residualValue);
	}

	public void typeLastDepreciationDate(String lastDepreciationDate) {
		if (!lastDepreciationDate.isEmpty()) {
			enterInputFieldWithLabel(parentPopupXpath, "Last Depreciation Date", lastDepreciationDate);
		} else {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			String date = dateFormat.format(cal.getTime());
			enterInputFieldWithLabel(parentPopupXpath, "Last Depreciation Date", date);
		}
	}

	public void typeNoofDepreciation(String noofDepreciation) {
		enterInputFieldWithLabel(parentPopupXpath, "No. of Depreciation", noofDepreciation);
	}

	public void typeRemainingUsefulLife(String remainingUsefulLife) {
		enterInputFieldWithLabel(parentPopupXpath, "Remaining Useful Life", remainingUsefulLife);
	}

	public void typeDetailSegment1(String detailSegment1) {
		enterInputFieldCodeWithLabel(parentPopupXpath, "Segment 1", detailSegment1);
	}

	public void typeDetailSegment2(String detailSegment2) {
		enterInputFieldCodeWithLabel(parentPopupXpath, "Segment 2", detailSegment2);
	}

	public void typeDetailSegment3(String detailSegment3) {
		enterInputFieldCodeWithLabel(parentPopupXpath, "Segment 3", detailSegment3);
	}

	public void typeDetailSegment4(String detailSegment4) {
		enterInputFieldCodeWithLabel(parentPopupXpath, "Segment 4", detailSegment4);
	}

}
