package com.synergix.globalsetup.party.supplier.page;

import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.javascript.background.BackgroundJavaScriptFactory;
import com.synergix.common.TH5PageObject;

public class SupBankDetailTabPage extends TH5PageObject {

	public SupBankDetailTabPage(WebDriver driver) {
		super(driver);
	}

	private String xAdd = "//input[@value='Add'][@type='button'][parent::form]";

	private String xParentBankDetail = "//table[contains(@id, 'PartyBank')][child::thead]";

	@Override
	public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		String xPath = _parentXpath + "//tbody[preceding::thead]/tr[@class][" + _rowIndex + "]/td[" + _headerIndex
				+ "]";
		return xPath;
	}

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	public void clickOnAddBankDetail() {
		$(xAdd).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowBankDetal() {
		return countRowTb(xParentBankDetail);
	}

	public void typeBank(String bank, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Bank");
		String xPath = xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input";
		$(xPath).waitUntilPresent().typeAndEnter(bank);
		waitForAllJSCompletes();
	}

	public void typeDescription(String description, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Description");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input",
				description);
	}

	public void typeAccountNo(String accountNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Account No.");
		waitTypeAndEnterThenUpdateCodeValue(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input",
				accountNo);
	}

	public void typeBankCurrency(String currency, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Currency");
		waitTypeAndEnterThenUpdateCodeValue(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input",
				currency);
	}

	public void chooseBankDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Default");
		$(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseBankDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Del");
		String xPath = xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			clickOnElement(xPath);
			waitForAllJSCompletes();
			clickBtn("Delete", 2);
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public boolean isBankExit(String bank) {
		String xRowSelect = xParentBankDetail + "//tr[child::td[1 and descendant-or-self::*[text()='"
				+ bank.toUpperCase() + "']]]";
		if (isElementExist(xRowSelect))
			return true;
		return false;
	}

	public int getRowIndex(String bank) {
		String xRowSelect = xParentBankDetail + "//tr[child::td[1 and descendant-or-self::*[text()='"
				+ bank.toUpperCase() + "']]]";
		if (isElementExist(xRowSelect))
			return findAll(xRowSelect + "/preceding-sibling::tr").size() + 1;
		return 0;
	}
}
