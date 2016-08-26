package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CusLocalInfoTabPage extends TH5PageObject {

	public CusLocalInfoTabPage(WebDriver driver) {
		super(driver);
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	public String xAddBtnSpan = "//input[@value='Add'][@type='button'][parent::span]";
	public String xDeleteBtnSpan = "//input[@value='Delete'][@type='button'][parent::span]";
	private String xParentPricing = "//table[contains(@id, 'tblPriceListTagging')]";

	private String xPopup = "//table[contains(@id, 'ModalPanelContentTable')]";
	private String xParentListPricing = "//table[contains(@id, 'tblPriceListWTagging')]";

	private String xParentShipMode = "//td[contains(@id, 'ShipmentMode')][child::table[@class]]";
	private String xParentPort = "//table[contains(@id, 'tblPort')]";
	private String xParentCountry = "//table[contains(@id, 'tblCountry')]";

	private String xParentInventoryBrand = "//table[contains(@id, 'brandTable')]";

	private String xLocalInfo = "//table[contains(@id, 'localInfoTabPnl')]";

	public String xCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	public int countRowTb(String xParent) {
		waitForAllJSCompletes();
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	/**
	 * REGION LOCAL INFO TAB
	 */

	public int getRowIndexPricing(String currencyCode) {
		String xPath = xParentPricing + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
				+ currencyCode.toUpperCase() + "']]]";
		if (isElementExist(xPath)) {
			xPath += "/preceding-sibling::tr";
			return findAll(xPath).size() + 1;
		}
		return 0;
	}

	public void clickOnPriceListIcon(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPricing, "Price List Tagging by Working Area");
		String xPath = xCellByPosition(xParentPricing, rowIndex, colIndex) + "/a[@href]";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typeInventoryPriceListCode(String inventoryPriceListCode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPricing, "Inventory Price List Code");
		waitTypeAndEnterThenUpdateCodeValue(xPathTbDataCellByPosition(xParentPricing, rowIndex, colIndex) + "/input",
				inventoryPriceListCode);
	}

	public void typeServicePriceListCode(String servicePriceListCode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPricing, "Service Price List Code");
		waitTypeAndEnterThenUpdateCodeValue(xPathTbDataCellByPosition(xParentPricing, rowIndex, colIndex) + "/input",
				servicePriceListCode);
	}

	// List Pricing

	public void clickOnAddListPricing() {
		clickBtn(xPopup, "New");
		waitForAllJSCompletes();
	}

	public int countRowListPricing() {
		return countRowTb(xParentListPricing);
	}

	public void clickOnDoneListPricing() {
		clickBtn(xPopup, "Done");
	}

	public void typeListWorkingAreaCode(String listWorkingAreaCode, int listRowIndex) {
		int colIndex = getTbColHeaderIndex(xParentListPricing, "Working Area Code");
		waitTypeAndEnterThenUpdateCodeValue(
				xPathTbDataCellByPosition(xParentListPricing, listRowIndex, colIndex) + "/input", listWorkingAreaCode);
	}

	public void typeListInventoryPriceListCode(String listInventoryPriceListCode, int listRowIndex) {
		int colIndex = getTbColHeaderIndex(xParentListPricing, "Inventory Price List Code");
		waitTypeAndEnterThenUpdateCodeValue(
				xPathTbDataCellByPosition(xParentListPricing, listRowIndex, colIndex) + "/input",
				listInventoryPriceListCode);
	}

	public void typeListServicePriceListCode(String listServicePriceListCode, int listRowIndex) {
		int colIndex = getTbColHeaderIndex(xParentListPricing, "Service Price List Code");
		waitTypeAndEnterThenUpdateCodeValue(
				xPathTbDataCellByPosition(xParentListPricing, listRowIndex, colIndex) + "/input",
				listServicePriceListCode);
	}

	public void chooseDeleteListPricing(int listRowIndex) {
		int colIndex = getTbColHeaderIndex(xParentListPricing, "Delete");
		String xPath = xPathTbDataCellByPosition(xParentListPricing, listRowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();

			clickBtn(xPopup, "Delete");
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	// Credit Limit Term Tab

	public String getOperationCurrency() {
		String xOperationalCurrency = "//tbody//td[text()='Operational Currency']/following-sibling::td//input";
		try {
			return $(xOperationalCurrency).getValue();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	public void typeCreditLimitAmt(String creditLimitAmt) {
		enterInputFieldWithLabel("Credit Limit Amt", creditLimitAmt);
	}

	public void typeGracePeriod(String gracePeriod) {
		enterInputFieldWithLabel("Grace Period", gracePeriod);
	}

	// Shipment Term

	public void chooseInc(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Inc");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void typeShippingTerm(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Shipping Term");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseAir(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Air");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseSea(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Sea");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseRoad(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Road");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseRail(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Rail");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseShipmentDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Default");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	// Country Port Tab

	public void clickOnAddCountry() {
		$(xAddBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickToOpenPort(int rowIndex) {
		String xPath = "//table[contains(@id, 'tblCountry')]//tbody[preceding::thead]/tr[@class][" + rowIndex
				+ "]/td[1]/a[@href]";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowCountry() {
		return countRowTb(xParentCountry);
	}

	public int getRowIndexCountry(String country) {
		String xPath = xParentCountry + "//tbody[preceding::thead]/tr[@class][descendant::input[@value ='"
				+ country.toUpperCase() + "']]";
		if (isElementExist(xPath)) {
			xPath += "/preceding-sibling::tr";
			return findAll(By.xpath(xPath)).size() + 1;
		}

		else
			return 0;
	}

	public int getRowIndexShipTerm(String shippingTerm) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Shipping Term");
		String xPath = xParentShipMode + "//tbody[preceding::thead]/tr[@class][descendant::td[" + colIndex
				+ "][text()='" + shippingTerm + "']]";
		if (isElementExist(xPath)) {
			xPath += "/preceding-sibling::tr";
			return findAll(By.xpath(xPath)).size() + 1;
		} else
			return 0;
	}

	public int getRowIndexPort(String port) {
		String xRowSelected = "//table[@id='formPort:tblPort']/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
				+ port + "']]]";

		if (isElementExist(xRowSelected)) {
			xRowSelected += "/preceding-sibling::tr";
			return findAll(xRowSelected).size() + 1;
		}
		return 0;
		// return searchInTbMultiPage(xParentPort, "Port", 1, port, true);
	}

	public void typeCountry(String country, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Country");
		waitTypeAndEnter(xCellByPosition(xParentCountry, rowIndex, colIndex) + "/input", country);
		waitForAllJSCompletes();
	}

	public void chooseLoading(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Loading");
		String xPath = xCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseDischarge(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Discharge");
		String xPath = xCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseFinalDest(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Final Dest");
		String xPath = xCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseDelCountry(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Del");
		String xPath = xCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
		$(xDeleteBtn).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	// Port Tab

	public void choosePortLoading(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Loading");
		String xPath = xCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void choosePortDischange(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Discharge");
		String xPath = xCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void choosePortFinalDest(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Final Dest");
		String xPath = xCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	// Local Customer Inventory Tab

	public void clickOnAddInventoryBrand() {
		clickBtn(xLocalInfo, "Add");
		waitForAllJSCompletes();
	}

	public int countRowInventoryBrand() {
		return countRowTb(xParentInventoryBrand);
	}

	public void typeInventoryBrand(String inventoryBrand, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentInventoryBrand, "Inventory Brand");
		waitTypeAndEnterThenUpdateCodeValue(xCellByPosition(xParentInventoryBrand, rowIndex, colIndex) + "//input",
				inventoryBrand);
	}

	public void typeDiscountCode(String discountCode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentInventoryBrand, "Discount Code");
		waitTypeAndEnterThenUpdateCodeValue(xCellByPosition(xParentInventoryBrand, rowIndex, colIndex) + "//input",
				discountCode);
	}

	public void typeDiscount(String discount, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentInventoryBrand, "Discount %");
		waitTypeAndEnterThenUpdateCodeValue(xCellByPosition(xParentInventoryBrand, rowIndex, colIndex) + "/input",
				discount);
	}

	public void chooseDelInventoryBrand(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentInventoryBrand, "Del");
		String xPath = xCellByPosition(xParentInventoryBrand, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitABit(1000);
			clickBtn(xLocalInfo, "Delete");
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public String verifyMessagePopup() {
		try {
			return getErrorMessagesThenClickOK();
		} catch (Exception e) {
			System.out.println("Exception occur: " + e);
			return null;
		}
	}

	public void chooseLRA(String addressCode) {
		String xAddressTb = "//table[contains(@id, 'tblPartyAddress')][child::thead]";
		filterDataByHeader(xPathTbHeaderCell(xAddressTb, "Address", 2), addressCode);

		String xRowSelect = xAddressTb + "/tbody/tr[child::td[1 and descendant::*[text()='" + addressCode.toUpperCase()
				+ "']]]//*[@type='radio']";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
		}
		filterDataByHeader(xPathTbHeaderCell(xAddressTb, "Address", 2), "");
	}

	public void chooseDelAddress(String addressCode) {
		String xAddressTb = "//table[contains(@id, 'tblPartyAddress')][child::thead]";
		filterDataByHeader(xPathTbHeaderCell(xAddressTb, "Address", 2), addressCode);

		String xRowSelect = xAddressTb + "/tbody/tr[child::td[1 and descendant::*[text()='" + addressCode.toUpperCase()
				+ "']]]//*[@type='checkbox']";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			clickBtn("Delete", 2);
			chooseYesOnUpdateConfirmation();
		}
		filterDataByHeader(xPathTbHeaderCell(xAddressTb, "Address", 2), "");
	}

	public boolean chooseCountry(String country) {
		String xRowSelect = "//table[contains(@id, 'tblCountry')]//tbody/tr[descendant::*[@value='"
				+ country.toUpperCase() + "']]/td[1]/*[@href]";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			return true;
		}
		return false;
	}

	public boolean isCountryExit(String country) {
		String xRowSelect = "//table[contains(@id, 'tblCountry')]//tbody/tr[descendant::*[@value='"
				+ country.toUpperCase() + "']]";
		if(isElementExist(xRowSelect)) return true;
		return false;
		
	}

	public void chooseDelCountry(String country) {
		String xRowSelect = "//table[contains(@id, 'tblCountry')]//tbody/tr[descendant::*[@value='"
				+ country.toUpperCase() + "']]/td[6]//input";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			clickBtn("Delete", 2);
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}
}
