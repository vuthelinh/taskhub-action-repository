package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CusBankDetailTabPage extends TH5PageObject {

	public CusBankDetailTabPage(WebDriver driver) {
		super(driver);
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	public String xAddBtnSpan = "//input[@value='Add'][@type='button'][parent::span]";
	public String xDeleteBtnSpan = "//input[@value='Delete'][@type='button'][parent::span]";

	private String xParentBank = "//table[contains(@id, 'tblPartyBank')][child::thead]";

	public String xCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	/**
	 * REGION BANK DETAIL TAB
	 */

	public void clickOnAddBank() {
		$(xAddBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowBank() {
		return countRowTb(xParentBank);
	}

	public int getRowIndexBank(String bank) {
		String xPath = xParentBank + "//tr[@class][descendant::td[text()='" + bank.toUpperCase() + "']]";
		if (findAll(By.xpath(xPath)).size() > 0)
			return findAll(By.xpath(xPath + "/preceding-sibling::tr")).size() + 1;
		else
			return 0;
	}

	public void typeBank(String bank, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBank, "Bank");
		waitTypeAndEnter(xCellByPosition(xParentBank, rowIndex, colIndex) + "/input", bank);
	}

	public void typeDescription(String description, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBank, "Description");
		waitTypeAndEnterThenUpdateValue(xCellByPosition(xParentBank, rowIndex, colIndex) + "/input", description);
	}

	public void typeAccountNo(String accountNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBank, "Account No.");
		waitTypeAndEnterThenUpdateValue(xCellByPosition(xParentBank, rowIndex, colIndex) + "/input", accountNo);
	}

	public void typeCurrency(String currency, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBank, "Currency");
		waitTypeAndEnterThenUpdateCodeValue(xCellByPosition(xParentBank, rowIndex, colIndex) + "/input", currency);
	}

	public void chooseBankDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBank, "Default");
		String xPath = xCellByPosition(xParentBank, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]";
		if (!$(xPath).isSelected())
			$(xPath).waitUntilClickable().click();
	}

	public void chooseBankDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBank, "Del");
		String xPath = xCellByPosition(xParentBank, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
			$(xDeleteBtn).waitUntilClickable().click();
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public boolean isBankExit(String bank) {
		String xPath = xParentBank + "//tr[@class][descendant::td[text()='" + bank.toUpperCase() + "']]";
		if (isElementExist(xPath)) {
			return true;
		}
		return false;
	}
}
