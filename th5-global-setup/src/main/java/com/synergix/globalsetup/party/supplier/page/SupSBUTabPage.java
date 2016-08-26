package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SupSBUTabPage extends TH5PageObject {

	public SupSBUTabPage(WebDriver driver) {
		super(driver);
	}

	private String xAdd = "//input[@value='Add'][@type='button'][parent::form]";
	private String xDelete = "//input[@value='Delete'][@type='button'][parent::form]";

	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";

	private String xParentBankDetail = "//table[contains(@id, 'PartyBank')][child::thead]";

	private String xParentSBU = "//table[contains(@id, 'PartySbu')][child::thead]";

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

	public void typeDescription(String description, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Description");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input",
				description);
	}

	public int countRowSBU() {
		return countRowTb(xParentSBU);
	}

	public void clickOnAddSBU() {
		$(xAdd).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typeSBU(String sBU, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSBU, "SBU");
		waitTypeAndEnterThenUpdateCodeValue(xPathTbDataCellByPosition(xParentSBU, rowIndex, colIndex) + "/input", sBU);
	}

	public void typeSBUDescription(String description, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSBU, "description");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xParentSBU, rowIndex, colIndex) + "/input",
				description);
	}

	public void chooseDelSBU(int rowIndex) {
		int colIndex = 3;
		String xPath = xParentSBU + "/tbody//tr[" + rowIndex + "]/td[" + colIndex + "]/input";
		;
		clickOnElement(xPath);
		waitForAllJSCompletes();

		clickOnElement(xDeleteBtn);
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();

	}

	public boolean isSBUExit(String sBU) {
		String xRowSelect = xParentSBU + "//tr[child::td[1 and descendant-or-self::*[text()='" + sBU.toUpperCase()
				+ "' or @value='" + sBU.toUpperCase() + "']]]";
		if (isElementExist(xRowSelect))
			return true;
		return false;
	}

	public void chooseDelSBU(String sBU) {
		String xRowSelect = xParentSBU + "//tr[child::td[1 and descendant-or-self::*[text()='" + sBU.toUpperCase()
				+ "' or @value='" + sBU.toUpperCase() + "']]]/td[3]//input";

		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();

			$(xDelete).waitUntilClickable().click();
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}
}
