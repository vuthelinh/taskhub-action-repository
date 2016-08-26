package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CusCurrencyTabPage extends TH5PageObject {

	public CusCurrencyTabPage(WebDriver driver) {
		super(driver);
	}

	private String xPathTbCurrency = "//table[contains(@id,'tblCurrency')][child::thead]";

	public void clickOnAddCurrencyBtn() {
		clickBtn("Add");
		waitForAllJSCompletes();
		waitABit(1000);
		waitForAllJSCompletes();
	}

	public void typeCurrency(String currency) {
		waitElementToBePresent(xPathTbGetLastDataCellByHeaderIndex(xPathTbCurrency, 1) + "/input");
		waitTypeAndEnter(xPathTbGetLastDataCellByHeaderIndex(xPathTbCurrency, 1) + "/input", currency);
	}

	public void chooseDelCurrency(String currency) {
		String xRowSelect = xPathTbCurrency + "//tr[child::td[1 and descendant::*[text()='" + currency + "' or @value='"
				+ currency + "']]]//*[@type='checkbox']";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			clickBtn("Delete", 2);
			chooseYesOnUpdateConfirmation();
		}
	}

	public boolean isCurrencyExit(String currency) {
		String xRowSelect = xPathTbCurrency + "//tr[child::td[1 and descendant::*[text()='" + currency + "' or @value='"
				+ currency + "']]]";
		if (isElementExist(xRowSelect))
			return true;
		return false;
	}
}
