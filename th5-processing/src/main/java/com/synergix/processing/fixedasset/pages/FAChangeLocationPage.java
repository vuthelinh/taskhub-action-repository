package com.synergix.processing.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class FAChangeLocationPage extends TH5PageObject {

	public FAChangeLocationPage(WebDriver driver) {
		super(driver);
	}

	String xSearchVchNoTb = "//table[contains(@id, 'clTable') and child::thead]";
	String xChangeLocationDet = "//table[contains(@id, 'disposalTable') and child::thead]";

	public void typeFixedAssetCode(String fixedAssetCode) {
		enterInputFieldCodeWithLabel("Fixed Asset Code", fixedAssetCode);
	}

	public void typeTransactionDate(String transactionDate) {
		enterInputFieldWithLabel("Transaction Date", transactionDate);
	}

	public void typeSubject(String subject) {
		enterInputFieldWithLabel("Subject", subject);
	}

	public void typeDescription(String description) {
		enterTextAreaWithLabel("Description", description);
	}

	// ================== DETAILs============================
	public void typeSerialNo(String serialNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xChangeLocationDet, "Serial No");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xChangeLocationDet, rowIndex,
						colIndex) + "//input[@type]", serialNo);
	}

	public void typeRemarksDescription(String remarksDescription, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xChangeLocationDet,
				"Serial No/ Remarks Description");
		enterRemarkByClickIcon(
				xPathTbDataCellByPosition(xChangeLocationDet, rowIndex,
						colIndex)
						+ "//a[@href and contains(@id, 'itemRemarks')]",
				remarksDescription);
		waitForAllJSCompletes();
	}

	public void typeNewLocation(String newLocation, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xChangeLocationDet, "New Location");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xChangeLocationDet, rowIndex,
						colIndex) + "//input[@type]", newLocation);
	}

	public void chooseDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xChangeLocationDet, "Del");
		clickOnElement(xPathTbDataCellByPosition(xChangeLocationDet, rowIndex,
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
