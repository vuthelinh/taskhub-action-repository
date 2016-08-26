package com.synergix.processing.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class FADepreciationVchPage extends TH5PageObject {

	public FADepreciationVchPage(WebDriver driver) {
		super(driver);
	}

	private String xDraftTb = "//table[contains(@id, 'faDepreciationDraftTable') and child::thead]";
	private String xHistoryTb = "//table[contains(@id, 'faDepreciationHistoryTable') and child::thead]";

	public void typeFixedAssetClassFrom(String fixedAssetClassFrom) {
		enterInputFieldCodeWithLabel("Fixed Asset Class From",
				fixedAssetClassFrom);
	}

	public void typeFixedAssetClassTo(String fixedAssetClassTo) {
		enterInputFieldCodeWithLabel("Fixed Asset Class To", fixedAssetClassTo);
	}

	public void clickOnAllVch() {
		String xCheckboxAll = xDraftTb
				+ "/thead//th[1]//input[@type='checkbox']";
		clickOnElement(xCheckboxAll);
		waitForAllJSCompletes();
	}

	public void searchDraftVch(String vchNo) {
		searchByFilter(xDraftTb, "Voucher No.", vchNo);
		clickOnSubmitBtn();
	}

	public void clickOnSubmitVch(int rowIndex) {
		String xRowSelect = xDraftTb + "/tbody/tr[" + rowIndex
				+ "]/td[1]//input[@type='checkbox']";
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
		}
	}

	public void clickOnSubmitBtn() {
		clickBtn("Submit");
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}
}
