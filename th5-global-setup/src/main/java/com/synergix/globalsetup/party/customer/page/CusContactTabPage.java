package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CusContactTabPage extends TH5PageObject {

	public CusContactTabPage(WebDriver driver) {
		super(driver);
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	
	public String xAddBtnSpan = "//input[@value='Add'][@type='button'][parent::span]";
	public String xDeleteBtnSpan = "//input[@value='Delete'][@type='button'][parent::span]";

	private String xBioDataTb = "//table[contains(@id, 'tblPartyContact')][child::thead]";

	private String xParentContactContactType = "//table[contains(@id, 'ContactContDetails')]";

	public String xCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	/**
	 * REGION CONTACT TAB
	 */

	public void clickOnAddContactTypeBtn() {
		$(xAddBtnSpan).waitUntilClickable().click();
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

	public void chooseIncType(String incType) {
		String xPathIncType = "//tr[child::*[text()='" + incType + "']]/td[1]/input";
		if (!$(xPathIncType).isSelected())
			$(xPathIncType).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseDefaultIncType(String incType) {
		String xPathDefault = "//tr[child::*[text()='" + incType + "']]/td[3]/input";
		if (!$(xPathDefault).isSelected())
			$(xPathDefault).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	/**
	 * Check if a contact type have been chosen or not in tab contact
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
		String xPath = "((" + xParentContactContactType
				+ "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')][" + colIndex + "])[" + rowIndex
				+ "]/select";
		selectDdlByText(xPath, contactTypeContactType);
	}

	public void typeContactTypeContactInformation(String contactTypeContactInformation, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Contact Information");
		String xPath = "((" + xParentContactContactType
				+ "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')][" + colIndex + "])[" + rowIndex
				+ "]/input";
		waitTypeAndEnterThenUpdateValue(xPath, contactTypeContactInformation);
	}

	public void chooseContactTypeTypeDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Default");
		String xPath = "((" + xParentContactContactType
				+ "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')][" + colIndex + "])[" + rowIndex
				+ "]//input[following-sibling::label[text()='Yes']]";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseContactTypeDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Del");
		String xPath = "((" + xParentContactContactType
				+ "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')][" + colIndex + "])[" + rowIndex
				+ "]/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
			$(xDeleteBtnSpan).waitUntilClickable().click();
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public void chooseDelContact(String partyContactCode) {
		String xRowSelect = xBioDataTb + "/tbody/tr[child::td[1 and descendant::*[text()='"
				+ partyContactCode.toUpperCase() + "']]]//*[@type='checkbox']";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			clickBtn("Delete", 2);
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public boolean chooseContact(String partyContactCode) {
		String xRowSelect = xBioDataTb + "/tbody/tr[child::td[1 and descendant::*[text()='"
				+ partyContactCode.toUpperCase() + "']]]//*[@href]";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		}
		return false;
	}

	public boolean isContactExit(String partyContactCode) {
		String xRowSelect = xBioDataTb + "/tbody/tr[child::td[1 and descendant::*[text()='"
				+ partyContactCode.toUpperCase() + "']]]//*[@href]";
		if (isElementExist(xRowSelect)) {
			return true;
		}
		return false;
	}
}
