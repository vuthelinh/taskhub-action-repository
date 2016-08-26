package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CusAddressTabPage extends TH5PageObject {

	public CusAddressTabPage(WebDriver driver) {
		super(driver);
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	
	public String xAddBtnSpan = "//input[@value='Add'][@type='button'][parent::span]";
	public String xDeleteBtnSpan = "//input[@value='Delete'][@type='button'][parent::span]";

	private String xParentContactType = "//table[contains(@id, 'ContactDetails')][child::thead]";

	private String xAddressTb = "//table[contains(@id, 'tblPartyAddress')][child::thead]";

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	/**
	 * REGION ADDRESS TAB
	 */

	public void clickOnAddAddress() {
		$(xAddBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowAddrContactType() {
		return countRowTb(xParentContactType);
	}

	public void clickOnAddAddrContactType() {
		$(xAddBtnSpan).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typeAddressCode(String addressCode) {
		enterInputFieldWithLabelNoVerify("Address Code", addressCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeAddress(String address) {
		enterTextAreaWithLabel("Address", address);
	}

	public void typeCountryCode(String countryCode) {
		enterInputFieldCodeWithLabel("Country Code", countryCode);
	}

	public void typeStateProvince(String stateProvince) {
		enterInputFieldCodeWithLabel("State/Province", stateProvince);
	}

	public void typeCityTown(String cityTown) {
		enterInputFieldCodeWithLabel("City/Town", cityTown);
	}

	public void typePostalCode(String postalCode) {
		enterInputFieldWithLabel("Postal Code", postalCode);
	}

	public void typeBlockEstateName(String blockEstateName) {
		enterInputFieldWithLabel("Block / Estate Name", blockEstateName);
	}

	public void typeStreetName(String streetName) {
		enterInputFieldWithLabel("Street Name", streetName);
	}

	public void typeBuildingBlockHouseNo(String buildingBlockHouseNo) {
		enterInputFieldWithLabel("Building / Block / House No", buildingBlockHouseNo);
	}

	public void chooseBuildingType(String buildingType) {
		selectDdlWithLabelByText("Building Type", buildingType);
	}

	public void typeUnitNo(String unitNo) {
		enterInputFieldWithLabel("Unit No.", unitNo);
	}

	public void chooseIncType(String incType) {
		String xPathIncType = "//tr[child::*[text()='" + incType + "']]/td[1]/input";
		// if (!isElementExist(xPathIncType + "[@checked]"))
		if (!$(xPathIncType).isSelected())
			$(xPathIncType).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseDefaultIncType(String incType) {
		String xPathDefault = "//tr[child::*[text()='" + incType + "']]/td[3]/input";
		// if (!isElementExist(xPathDefault + "[@checked]"))
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
		String xPath = "((" + xParentContactType
				+ "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')][" + colIndex + "])[" + rowIndex
				+ "]/select";
		selectDdlByText(xPath, contactType);
	}

	public void typeContactInformation(String contactInformation, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Contact Information");
		String xPath = "((" + xParentContactType
				+ "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')][" + colIndex + "])[" + rowIndex
				+ "]/input";
		waitTypeAndEnterThenUpdateCodeValue(xPath, contactInformation);
	}

	public void chooseAddrContactTypeDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Default");
		String xPath = "((" + xParentContactType
				+ "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')][" + colIndex + "])[" + rowIndex
				+ "]//input[following-sibling::label[text()='Yes']]";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Del");
		String xPath = "((" + xParentContactType
				+ "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')][" + colIndex + "])[" + rowIndex
				+ "]/input";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
		$(xDeleteBtnSpan).waitUntilClickable().click();
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
		if (isElementExist(xRowSelect)) {
			return true;
		}
		return false;
	}
}
