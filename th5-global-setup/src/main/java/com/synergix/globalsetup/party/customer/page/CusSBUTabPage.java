package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CusSBUTabPage extends TH5PageObject {

	public CusSBUTabPage(WebDriver driver) {
		super(driver);
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	public String xAddBtnSpan = "//input[@value='Add'][@type='button'][parent::span]";
	public String xDeleteBtnSpan = "//input[@value='Delete'][@type='button'][parent::span]";

	private String xParentSBU = "//table[contains(@id, 'PartySbu')][child::thead]";

	public String xCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	/**
	 * Region SBU Tab
	 */

	public int countRowSBU() {
		return countRowTb(xParentSBU);
	}

	public void clickOnAddSBU() {
		$(xAddBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typeSBU(String sBU, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSBU, "SBU");
		waitTypeAndEnterThenUpdateCodeValue(xCellByPosition(xParentSBU, rowIndex, colIndex) + "/input", sBU);
	}

	public void typeSBUDescription(String description, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSBU, "description");
		waitTypeAndEnterThenUpdateValue(xCellByPosition(xParentSBU, rowIndex, colIndex) + "/input", description);
	}

	public void chooseDelSBU(int rowIndex) {
		// int colIndex = getTbColHeaderIndex(xParentSBU, "Del");
		int colIndex = 3;
		String xPath = xParentSBU+"/tbody//tr["+rowIndex+"]/td["+colIndex+"]/input";;
		clickOnElement(xPath);
		waitForAllJSCompletes();

		clickOnElement(xDeleteBtn);
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();

	}

	public boolean isSBUExit(String sBU) {
		String xPath = xParentSBU + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='" + sBU + "' or @value='"
				+ sBU + "']]]";
		if (isElementExist(xPath))
			return true;
		return false;
	}

	public int getRowIndexSBU(String sBU) {
		String xPath = xParentSBU + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='" + sBU + "' or @value='"
				+ sBU + "']]]";
		if (isElementExist(xPath)) {
			return findAll(xPath + "/preceding-sibling::tr").size() + 1;
		}
		return 0;
	}
}
