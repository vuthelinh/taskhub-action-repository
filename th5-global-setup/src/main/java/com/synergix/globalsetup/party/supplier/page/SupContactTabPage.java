package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SupContactTabPage extends TH5PageObject {

	public SupContactTabPage(WebDriver driver) {
		super(driver);
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";

	private String xContactTbl = "//table[contains(@id, 'tblPartyContact') and child::thead]";

	private String xAddContactType = "//span/input[@value='Add'][@type='button']";
	private String xDelContactType = "//span/input[@value='Delete'][@type='button']";

	private String xParentContactContactType = "//table[contains(@id, 'ContactContDetails')]";

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

	public void chooseIncType(String incType) {
		String xPathIncType = "//tr[child::*[text()='" + incType + "']]/td[1]/input";
		if (!$(xPathIncType).isSelected())
			clickOnElement(xPathIncType);
		waitForAllJSCompletes();
	}

	public void clickOnAddContactTypeBtn() {
		$(xAddContactType).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseTypeDefault(String incType) {
		String xPathDefault = "//tr[child::*[text()='" + incType + "']]/td[3]/input";
		if (!$(xPathDefault).isSelected())
			$(xPathDefault).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowContactContactTypeTb() {
		return countRowTb(xParentContactContactType);
	}

	public void clickOnAddContact() {
		$(xAddBtn).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typePartyContactCode(String partyContactCode) {
		enterInputFieldCodeWithLabel("Party Contact Code", partyContactCode);
	}

	public void chooseSalutation(String salutation) {
		selectDdlWithLabelByText("Salutation", salutation);
	}

	public void typeFirstName(String firstName) {
		enterInputFieldWithLabel("First Name", firstName);
	}

	public void typeMiddleName(String middleName) {
		enterInputFieldWithLabel("Middle Name", middleName);
	}

	public void typeLastName(String lastName) {
		enterInputFieldWithLabel("Last Name", lastName);
	}

	public void typeName(String name) {
		enterInputFieldWithLabel("Name", name);
	}

	public void chooseAddressCode(String addressCode) {
		selectDdlWithLabelByText("Address Code", addressCode.toUpperCase());
	}

	public void typeDesignation(String designation) {
		enterInputFieldWithLabel("Designation", designation);
	}

	public void typeDesignationGroup(String designationGroup) {
		enterInputFieldCodeWithLabel("Designation Group", designationGroup);
	}

	public void typeDepartment(String department) {
		enterInputFieldWithLabel("Department", department);
	}
	
	/**
	 * Check if a contact have been chosen or not in tab address
	 * Created by Steve on 15/08/2016
	 * @param contactType
	 * @param contactInformation
	 * @return
	 */
	public boolean is_added_contact(String contactType, String contactInformation){
		String elementTypeXpath = xParentContactContactType + "//td//*[text()='" + contactType + "' and @selected='selected']";
		
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

	public void chooseContactTypeContactType(String contactTypeContactType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Contact Type");
		selectDdlByText(xPathTbDataCellByPosition(xParentContactContactType, rowIndex, colIndex) + "/select",
				contactTypeContactType);
	}

	public void typeContactTypeContactInformation(String contactTypeContactInformation, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Contact Information");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xParentContactContactType, rowIndex, colIndex) + "/input",
				contactTypeContactInformation);
	}

	public void chooseContactTypeTypeDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Default");
		$(xPathTbDataCellByPosition(xParentContactContactType, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseContactTypeDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Del");
		$(xPathTbDataCellByPosition(xParentContactContactType, rowIndex, colIndex) + "/input").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
		$(xDelContactType).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void chooseDelContact(String partyContactCode) {
		String xRowSelected = xContactTbl + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
				+ partyContactCode.toUpperCase() + "']]]//input[@type='checkbox']";
		if (isElementExist(xRowSelected)) {
			clickOnElement(xRowSelected);
			waitForAllJSCompletes();
			clickBtn("Delete", 2);
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public boolean chooseContact(String partyContactCode) {
		String xRowSelected = xContactTbl + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
				+ partyContactCode.toUpperCase() + "']]]/td[1]//*[@href]";
		if (isElementExist(xRowSelected)) {
			clickOnElement(xRowSelected);
			return true;
		}
		return false;
	}

	public boolean isContactExit(String partyContactCode) {
		String xRowSelected = xContactTbl + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
				+ partyContactCode.toUpperCase() + "']]]/td[1]//*[@href]";
		if (isElementExist(xRowSelected)) {
			return true;
		}
		return false;
	}
}
