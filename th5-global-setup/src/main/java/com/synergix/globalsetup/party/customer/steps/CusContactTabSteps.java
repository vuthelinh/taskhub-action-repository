package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CusContactTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusContactTabSteps extends ScenarioSteps {

	CusContactTabPage onCusContactTabPage;

	/**
	 * REGION CONTACT TAB
	 */
	@Step
	public void moveToContactTab() {
		onCusContactTabPage.switch_to_tab("Contact");
		onCusContactTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddContactTypeBtn() {
		onCusContactTabPage.clickOnAddContactTypeBtn();
	}

	@Step
	public int countRowContactContactTypeTb() {
		return onCusContactTabPage.countRowContactContactTypeTb();
	}

	@Step
	public void clickOnAddContact() {
		onCusContactTabPage.clickOnAddContact();
	}

	@Step
	public void typePartyContactCode(String partyContactCode) {
		onCusContactTabPage.typePartyContactCode(partyContactCode);
	}

	@Step
	public void chooseSalutation(String salutation) {
		onCusContactTabPage.chooseSalutation(salutation);
	}

	@Step
	public void typeFirstName(String firstName) {
		onCusContactTabPage.typeFirstName(firstName);
	}

	@Step
	public void typeMiddleName(String middleName) {
		onCusContactTabPage.typeMiddleName(middleName);
	}

	@Step
	public void typeLastName(String lastName) {
		onCusContactTabPage.typeLastName(lastName);
	}

	@Step
	public void typeName(String name) {
		onCusContactTabPage.typeName(name);
	}

	@Step
	public void chooseAddressCode(String addressCode) {
		onCusContactTabPage.chooseAddressCode(addressCode);
	}

	@Step
	public void typeDesignation(String designation) {
		onCusContactTabPage.typeDesignation(designation);
	}

	@Step
	public void typeDesignationGroup(String designationGroup) {
		onCusContactTabPage.typeDesignationGroup(designationGroup);
	}

	@Step
	public void typeDepartment(String department) {
		onCusContactTabPage.typeDepartment(department);
	}

	@Step
	public void chooseIncType(String incType) {
		onCusContactTabPage.chooseIncType(incType);
	}

	@Step
	public void chooseDefaultIncType(String addrDefault) {
		onCusContactTabPage.chooseDefaultIncType(addrDefault);
	}

	@Step
	public boolean is_added_contact(String contactType, String contactInformation) {
		return onCusContactTabPage.is_added_contact(contactType, contactInformation);
	}

	@Step
	public void chooseContactTypeContactType(String contactTypeContactType, int rowIndex) {
		onCusContactTabPage.chooseContactTypeContactType(contactTypeContactType, rowIndex);
	}

	@Step
	public void typeContactTypeContactInformation(String contactTypeContactInformation, int rowIndex) {
		onCusContactTabPage.typeContactTypeContactInformation(contactTypeContactInformation, rowIndex);
	}

	@Step
	public void chooseContactTypeTypeDefault(int rowIndex) {
		onCusContactTabPage.chooseContactTypeTypeDefault(rowIndex);
	}

	@Step
	public void chooseContactTypeDel(int rowIndex) {
		onCusContactTabPage.chooseContactTypeDel(rowIndex);
	}

	@Step
	public void chooseDelContact(String partyContactCode) {
		onCusContactTabPage.chooseDelContact(partyContactCode);
	}

	public boolean chooseContact(String partyContactCode) {
		return onCusContactTabPage.chooseContact(partyContactCode);
	}

	public boolean isContactExit(String partyContactCode) {
		return onCusContactTabPage.isContactExit(partyContactCode);
	}
}
