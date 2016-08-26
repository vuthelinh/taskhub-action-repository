package com.synergix.processing.accountsreceivable.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class ARRevaluationPage extends TH5PageObject {
	public ARRevaluationPage(WebDriver driver) {
		super(driver);
	}

	public void type_revaluationVoucherDate(String revaluationVoucherDate) {
		enterInputFieldWithLabel("Revaluation Voucher Date",
				revaluationVoucherDate);

	}

	public void type_description(String description) {
		enterTextAreaWithLabel("Description", description);
	}

	private String parenttableXpath = "//table[contains(@id, 'arRevalCurrTable') and child::thead]";

	public void type_curency(String currency, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parenttableXpath, "Currency");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(parenttableXpath, rowIndex, colIndex)
						+ "//input", currency);
		waitForAllJSCompletes();
	}

	public void type_exchRate(String exchRate, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parenttableXpath, "Exch Rate");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(parenttableXpath, rowIndex, colIndex)
						+ "//input", exchRate);
		waitForAllJSCompletes();

	}

	public void deleteAllCurrency() {
		String xParentTb = parenttableXpath + "/tbody/tr[@class]";
		int countRow = findAll(xParentTb).size();
		if (countRow > 0) {
			for (int i = 1; i <= countRow; i++) {
				String xRowSelect = xParentTb + "[" + i
						+ "]/td[3]//input[@type='checkbox']";
				clickOnElement(xRowSelect);
			}
			waitForAllJSCompletes();
			clickBtn("Delete");
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public void deleteCurrency(int rowIndex) {
		String xRowSelect = parenttableXpath + "/tbody/tr[@class][" + rowIndex
				+ "]/td[3]//input[@type='checkbox']";
		clickOnElement(xRowSelect);
		waitForAllJSCompletes();
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public int countRowTb() {
		String xParentTb = "//table[contains(@id, 'arRevalCurrTable') and child::thead]/tbody/tr[@class]";
		return findAll(xParentTb).size();
	}
}
