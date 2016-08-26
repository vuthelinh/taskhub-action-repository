package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SupCurrencyTabPage extends TH5PageObject {

	public SupCurrencyTabPage(WebDriver driver) {
		super(driver);
	}

	private String xPathTbCurrency = "//table[contains(@id,'tblCurrency')][child::thead]";

	@Override
	public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		String xPath = _parentXpath + "//tbody[preceding::thead]/tr[@class][" + _rowIndex + "]/td[" + _headerIndex
				+ "]";
		return xPath;
	}

	public void clickOnAddCurrencyBtn() {
		clickBtn("Add");
		waitForAllJSCompletes();
		waitABit(1000);
	}

	public void typeCurrency(String currency) {
		waitElementToBePresent(xPathTbGetLastDataCellByHeaderIndex(xPathTbCurrency, 1) + "/input");
		waitTypeAndEnter(xPathTbGetLastDataCellByHeaderIndex(xPathTbCurrency, 1) + "/input", currency);
	}

	public void chooseDel(String currency) {
		String xRowSelect = xPathTbCurrency + "//tr[child::td[1 and descendant::*[text()='" + currency + "' or @value='"
				+ currency.toUpperCase() + "']]]//*[@type='checkbox']";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			clickBtn("Delete", 2);
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public boolean isCurrencyExit(String currency) {
		String xRowSelect = xPathTbCurrency + "//tr[child::td[1 and descendant::*[text()='" + currency + "' or @value='"
				+ currency.toUpperCase() + "']]]";
		if (isElementExist(xRowSelect))
			return true;
		return false;
	}
}
