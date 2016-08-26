package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SupAddressTabPage extends TH5PageObject {

	public SupAddressTabPage(WebDriver driver) {
		super(driver);
	}

	private String xAdd = "//input[@value='Add'][@type='button'][parent::form]";
	private String xAddressTb = "//table[contains(@id, 'tblPartyAddress')][child::thead]";

	private String xParentContactType = "//table[contains(@id, 'ContactDetails')]";
	private String xAddContactType = "//span/input[@value='Add'][@type='button']";
	private String xDelContactType = "//span/input[@value='Delete'][@type='button']";

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
	 * Region Address Tab
	 */

	public void clickOnAddAddressBtn() {
		
		$(xAdd).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnAddContactTypeBtn() {
		clickOnElement(xAddContactType);
		waitForAllJSCompletes();
	}

	public int countRowContactTypeTb() {
		return countRowTb(xParentContactType);
	}

	public void typeAddressCode(String addressCode) {
		enterInputFieldWithLabelNoVerify("Address Code", addressCode);
	}

	public void typeAddressDescription(String addressDescription) {
		enterInputFieldWithLabel("Description", addressDescription);
	}

	public void typeAddress(String address) {
		enterTextAreaWithLabel("Address", address);
	}

	public void typeCountryCode(String countryCode) {
		enterInputFieldCodeWithLabel("Country Code", countryCode);
	}

	public void typeStateProvince(String stateProvince) {
		enterInputFieldWithLabel("State/Province", stateProvince);
	}

	public void typeCityTown(String cityTown) {
		enterInputFieldWithLabel("City/Town", cityTown);
	}

	public void typePostalCode(String postalCode) {
		enterInputFieldWithLabel("Postal Code", postalCode);
	}

	public void chooseIncType(String incType) {
		String xPathIncType = "//tr[child::*[text()='" + incType + "']]/td[1]/input";
		if (!$(xPathIncType).isSelected())
			$(xPathIncType).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseTypeDefault(String incType) {
		String xPathDefault = "//tr[child::*[text()='" + incType + "']]/td[3]/input";
		if (!$(xPathDefault).isSelected())
			$(xPathDefault).waitUntilClickable().click();
		waitForAllJSCompletes();
	}
	
	/**
	 * Check if a contact have been chosen or not in tab address
	 * Created by Steve on 15/08/2016
	 * @param contactType
	 * @param contactInformation
	 * @return
	 */
	public boolean is_added_contact(String contactType, String contactInformation){
		String elementTypeXpath = xParentContactType + "//td//*[text()='" + contactType + "' and @selected='selected']";
		
		if (isElementExist(elementTypeXpath)){
			String elementInfoXpath = elementTypeXpath + "/ancestor::tr//td//*[@value=" + contactInformation + "]";
			
			if (isElementExist(elementInfoXpath)){
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}

	public void chooseContactType(String contactType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Contact Type");
		selectDdlByText(xPathTbDataCellByPosition(xParentContactType, rowIndex, colIndex) + "/select", contactType);
	}

	public void typeContactInformation(String contactInformation, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Contact Information");
		waitTypeAndEnterThenUpdateCodeValue(
				xPathTbDataCellByPosition(xParentContactType, rowIndex, colIndex) + "/input", contactInformation);
	}

	public void chooseContactTypeDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Default");
		$(xPathTbDataCellByPosition(xParentContactType, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Del");
		$(xPathTbDataCellByPosition(xParentContactType, rowIndex, colIndex) + "/input").waitUntilClickable().click();
		waitForAllJSCompletes();
		$(xDelContactType).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void chooseLRA(String addressCode) {
		filterDataByHeader(xPathTbHeaderCell(xAddressTb, "Address", 2), addressCode);

		String xRowSelect = xAddressTb + "/tbody/tr[child::td[1 and descendant::*[text()='" + addressCode.toUpperCase()
				+ "']]]//*[@type='radio']";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
		}
		filterDataByHeader(xPathTbHeaderCell(xAddressTb, "Address", 2), "");
	}

	public void chooseDelAddress(String addressCode) {
		filterDataByHeader(xPathTbHeaderCell(xAddressTb, "Address", 2), addressCode);

		String xRowSelect = xAddressTb + "/tbody/tr[child::td[1 and descendant::*[text()='" + addressCode.toUpperCase()
				+ "']]]//*[@type='checkbox']";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			clickBtn("Delete", 2);
			chooseYesOnUpdateConfirmation();
		}
		filterDataByHeader(xPathTbHeaderCell(xAddressTb, "Address", 2), "");
		waitForAllJSCompletes();
	}

	public boolean chooseAddressCode(String addressCode) {
		String xRowSelect = xAddressTb + "/tbody/tr[child::td[1 and descendant::*[text()='" + addressCode.toUpperCase()
				+ "']]]//*[@href]";

		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		}
		return false;
	}

	public boolean isAddressCodeExit(String addressCode) {
		String xRowSelect = xAddressTb + "/tbody/tr[child::td[1 and descendant::*[text()='" + addressCode.toUpperCase()
				+ "']]]//*[@href]";
		if (isElementExist(xRowSelect))
			return true;
		return false;
	}
}
