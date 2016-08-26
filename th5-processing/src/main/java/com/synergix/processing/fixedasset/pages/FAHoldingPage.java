package com.synergix.processing.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class FAHoldingPage extends TH5PageObject {

	public FAHoldingPage(WebDriver driver) {
		super(driver);
	}

	String xDraftTb = "//table[contains(@id, 'faHoldingDraftTable') and child::thead]";
	String xOutstandingTb = "//table[contains(@id, 'faHoldingOstTable') and child::thead]";
	String HistoryTb = "//table[contains(@id, 'faHoldingHistoryTable') and child::thead]";
	String xAssetDet = "//table[contains(@id, 'assetSnTable') and child::thead]";

	public void searchDraftAssetVoucherNo(String assetVoucherNo) {
		searchByFilter(xDraftTb, "Asset Voucher No", assetVoucherNo);
	}

	public void typeAssetSerialNo(String assetSerialNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAssetDet, "Asset Serial No");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAssetDet, rowIndex, colIndex)
						+ "//input", assetSerialNo);
	}

	public void typeLocation(String location, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAssetDet, "Location");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAssetDet, rowIndex, colIndex)
						+ "//input", location);
	}

}
