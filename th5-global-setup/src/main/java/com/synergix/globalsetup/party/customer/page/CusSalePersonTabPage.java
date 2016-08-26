package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CusSalePersonTabPage extends TH5PageObject {

	public CusSalePersonTabPage(WebDriver driver) {
		super(driver);
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	public String xAddBtnSpan = "//input[@value='Add'][@type='button'][parent::span]";
	public String xDeleteBtnSpan = "//input[@value='Delete'][@type='button'][parent::span]";

	private String xParentSalesPerson = "//table[contains(@id, 'tblSalesPerson')][child::thead]";

	public String xCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	/**
	 * REGION SALES PERSON TAB
	 */

	public void clickOnAddSalesPeron() {
		$(xAddBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowSalesPerson() {
		return countRowTb(xParentSalesPerson);
	}

	public int getRowIndexSalesPerson(String salesPerson) {
		String xPath = xParentSalesPerson + "//tbody[preceding-sibling::thead]/tr[@class][descendant::input[@value='"
				+ salesPerson.toUpperCase() + "']]";
		if (findAll(xPath).size() > 0)
			return findAll(xPath + "/preceding-sibling::tr").size() + 1;
		else
			return 0;
	}

	public void typeSalesPerson(String salesPerson, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSalesPerson, "Sales Person");
		waitTypeAndEnterThenUpdateCodeValue(xCellByPosition(xParentSalesPerson, rowIndex, colIndex) + "/input",
				salesPerson);
	}

	public void typeName(String name, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSalesPerson, "Name");
		waitTypeAndEnterThenUpdateValue(xCellByPosition(xParentSalesPerson, rowIndex, colIndex) + "/input", name);
	}

	public void chooseSalesPersonDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSalesPerson, "Default");
		String xPath = xCellByPosition(xParentSalesPerson, rowIndex, colIndex) + "//input";
		if (!$(xPath).isSelected())
			$(xPath).waitUntilClickable().click();
	}

	public void chooseDSales(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSalesPerson, "D-Sales");
		String xPath = xCellByPosition(xParentSalesPerson, rowIndex, colIndex) + "//input";
		if (!$(xPath).isSelected())
			$(xPath).waitUntilClickable().click();

	}

	public void chooseSalesPersonDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSalesPerson, "Del");
		String xPath = xCellByPosition(xParentSalesPerson, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();

			$(xDeleteBtn).waitUntilClickable().click();
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public boolean isSalePersonExit(String salesPerson) {
		String xPath = xParentSalesPerson + "//tbody[preceding-sibling::thead]/tr[@class][descendant::input[@value='"
				+ salesPerson.toUpperCase() + "']]";
		if (isElementExist(xPath))
			return true;
		return false;
	}
}
