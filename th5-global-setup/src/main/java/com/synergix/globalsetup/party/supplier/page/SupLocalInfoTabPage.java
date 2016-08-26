package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SupLocalInfoTabPage extends TH5PageObject {

	public SupLocalInfoTabPage(WebDriver driver) {
		super(driver);
	}

	private String xParentShipMode = "//td[contains(@id, 'ShipmentMode')][child::table[@class]]";
	private String xParentCountry = "//table[contains(@id, 'tblCountry')]";
	private String xAddCountry = "//table[contains(@id, 'shipmentInfoPanel')]//input[@value='Add'][@type='button']";
	private String xDeleteCountry = "//table[contains(@id, 'shipmentInfoPanel')]//input[@value='Delete'][@type='button']";

	private String xParentPort = "//table[contains(@id, 'tblPort')]";

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

	/**
	 * Region Local Info Tab
	 */
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
		$(xAddCountry).waitUntilClickable().click();
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
				+ country.toUpperCase() + "']]/preceding-sibling::tr";
		return findAll(By.xpath(xPath)).size() + 1;
	}

	public int getRowIndexShipTerm(String shippingTerm) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Shipping Term");
		String xPath = xParentShipMode + "//tbody[preceding::thead]/tr[@class][descendant::td[" + colIndex
				+ "][text()='" + shippingTerm + "']]/preceding-sibling::tr";
		return findAll(By.xpath(xPath)).size() + 1;
	}

	public int getRowIndexPort(String port) {
		return searchInTbMultiPage(xParentPort, "Port", 1, port, true);
	}

	public void typeCountry(String country, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Country");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input", country);
		waitForAllJSCompletes();
	}

	public void chooseLoading(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Loading");
		String xPath = xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseDischarge(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Discharge");
		String xPath = xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseFinalDest(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Final Dest");
		String xPath = xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseDelCountry(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Del");
		String xPath = xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";

		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();

		$(xDeleteCountry).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	// Port Tab

	public boolean findPort(String port) {

		String xPathPort = xParentPort
				+ "//tbody[preceding::thead]/tr[@class][descendant::td[1][text()='PORT 1-Port 1']]";
		return false;
	}

	public void choosePortLoading(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Loading");
		String xPath = xPathTbDataCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void choosePortDischange(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Discharge");
		String xPath = xPathTbDataCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void choosePortFinalDest(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Final Dest");
		String xPath = xPathTbDataCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseDeductChargeFlag(String deductChargeFlag) {
		selectRadioButton("Deduct Charge Flag (COS)", deductChargeFlag);
	}

	public void chooseDeliveryToFornonCC(String deliveryToFornonCC) {
		selectRadioButton("Delivery To For non-CC (COS)", deliveryToFornonCC);
	}

	public void chooseDeliveryMode(String deliveryMode) {
		selectRadioButton("Delivery Mode", deliveryMode);
	}

	public boolean chooseContry(String country) {
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
				+ country.toUpperCase() + "']]/td[1]/*[@href]";
		if (isElementExist(xRowSelect))
			return true;
		return false;
	}

	public void chooseDelCountry(String country) {
		String xRowSelect = "//table[contains(@id, 'tblCountry')]//tbody/tr[descendant::*[@value='"
				+ country.toUpperCase() + "']]/td[6]//input";

		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			
			$(xDeleteCountry).waitUntilClickable().click();
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}

	}
}
