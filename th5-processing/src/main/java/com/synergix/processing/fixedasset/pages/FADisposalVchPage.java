package com.synergix.processing.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class FADisposalVchPage extends TH5PageObject {

	public FADisposalVchPage(WebDriver driver) {
		super(driver);
	}

	String xDisposalTb = "//table[contains(@id, 'disposalTable') and child::thead]";

	public void chooseFixedAssetCode(String fixedAssetCode) {
		enterInputFieldCodeWithLabel("Fixed Asset Code", fixedAssetCode);
	}

	public void typeDisposalDate(String disposalDate) {
		enterInputFieldWithLabel("Disposal Date", disposalDate);
	}

	public void typeSubject(String subject) {
		enterInputFieldWithLabel("Subject", subject);
	}

	public void typeDescription(String description) {
		enterTextAreaWithLabel("Description", description);
	}

	// ================== DETAILs============================
	public void typeSerialNo(String serialNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDisposalTb, "Serial No");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDisposalTb, rowIndex, colIndex)
						+ "//input[@type]", serialNo);
	}

	public void typeRemarksDescription(String remarksDescription, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDisposalTb,
				"Serial No/ Remarks Description");
		enterRemarkByClickIcon(
				xPathTbDataCellByPosition(xDisposalTb, rowIndex, colIndex)
						+ "//a[@href and contains(@id, 'itemRemarks')]",
				remarksDescription);
		waitForAllJSCompletes();
	}

	public void typeDisposalAmt(String disposalAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDisposalTb, "Disposal Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDisposalTb, rowIndex, colIndex)
						+ "//input[@type]", disposalAmt);
	}

	public void chooseDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDisposalTb, "Del");
		clickOnElement(xPathTbDataCellByPosition(xDisposalTb, rowIndex,
				colIndex) + "//input[@checkbox]");
		waitForAllJSCompletes();
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
	}

	public void clickOnSubmitBtn() {
		clickBtn("Submit");
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}
}
