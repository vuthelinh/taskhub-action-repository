package com.synergix.mtsetup.financial.currency.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class ExchangeRatePage extends TH5PageObject {

	public ExchangeRatePage(WebDriver driver) {
		super(driver);
	}

	public void typeCurrency(String currency) {
		try {
			enterInputFieldCodeWithLabel("Currency", currency);
			waitForAllJSCompletes();
		} catch (Exception ex) {
			chooseOkInErrorMessage();
		}
	}

	public void typeSheet(String sheet) {
		enterInputFieldWithLabel("Sheet", sheet);
	}

	private String parentXpath = "//table[contains(@id, 'exchRateTable')][contains(@class, 'rich-table')]";

	@Override
	public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		String xPath = "//tbody[contains(@id, 'exchRateTable')]/tr[" + _rowIndex + "]/td[" + _headerIndex + "]";
		return xPath;
	}

	public void typeEffectiveDateFrom(String effectiveDateFrom, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Effective Date From");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "//input[@type='text']",
				effectiveDateFrom);
	}

	public void typeEffectiveDateTo(String effectiveDateTo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Effective Date To");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "//input[@type='text']", effectiveDateTo);
	}

	public void typeUpwardsVarianceAllowed(String upwardsVarianceAllowed, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "% Upwards Variance Allowed");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "//input[@type='text']",
				upwardsVarianceAllowed);
	}

	public void typeDownwardsVarianceAllowed(String downwardsVarianceAllowed, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "% Downwards Variance Allowed");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "//input[@type='text']",
				downwardsVarianceAllowed);
	}

	public void typeBankSellRate(String bankSellRate, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Sell Rate");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "//input[@type='text']", bankSellRate);
	}

	public void typeBankBuyRate(String bankBuyRate, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Buy Rate");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "//input[@type='text']", bankBuyRate);
	}

	public void typeRevaluationRate(String revaluationRate, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Revaluation Rate");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "//input[@type='text']", revaluationRate);
	}

	public void deleteOldRow() {
		String xPathCountRow = parentXpath + "/tbody/tr";
		int countRow = findAll(By.xpath(xPathCountRow)).size();
		if (countRow > 0) {
			int colDel = getTbColHeaderIndex(parentXpath, "Del");
			for (int i = 1; i <= countRow; i++) {
				$(xPathTbDataCellByPosition(parentXpath, i, colDel)).waitUntilClickable().click();
			}

			waitABit(500);
			String xPathDeleteBtn = "//*[@type='button'][@value='Delete']";
			$(xPathDeleteBtn).waitUntilClickable().click();
			waitForAllJSCompletes();
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public boolean isExitData() {
		String xRow = parentXpath + "/tbody/tr";
		if (findAll(xRow).size() > 0)
			return true;
		return false;
	}

}
