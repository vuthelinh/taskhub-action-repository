package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupContactTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupContactTabSteps extends ScenarioSteps {

	SupContactTabPage onSupContactTabPage;

	@Step
	public void clickOnAddContactTypeBtn() {
		onSupContactTabPage.clickOnAddContactTypeBtn();
	}

	@Step
	public void chooseIncType(String incType) {
		onSupContactTabPage.chooseIncType(incType);
	}

	@Step
	public void moveToContactTab() {
		onSupContactTabPage.switch_to_tab("Contact");
		onSupContactTabPage.waitForAllJSCompletes();
	}

	@Step
	public int countRowContactContactTypeTb() {
		return onSupContactTabPage.countRowContactContactTypeTb();
	}

	@Step
	public void clickOnAddContact() {
		onSupContactTabPage.clickOnAddContact();
	}

	@Step
	public void typePartyContactCode(String partyContactCode) {
		onSupContactTabPage.typePartyContactCode(partyContactCode);
	}

	@Step
	public void chooseSalutation(String salutation) {
		onSupContactTabPage.chooseSalutation(salutation);
	}

	@Step
	public void typeFirstName(String firstName) {
		onSupContactTabPage.typeFirstName(firstName);
	}

	@Step
	public void typeMiddleName(String middleName) {
		onSupContactTabPage.typeMiddleName(middleName);
	}

	@Step
	public void typeLastName(String lastName) {
		onSupContactTabPage.typeLastName(lastName);
	}

	@Step
	public void typeName(String name) {
		onSupContactTabPage.typeName(name);
	}

	@Step
	public void chooseAddressCode(String addressCode) {
		onSupContactTabPage.chooseAddressCode(addressCode);
	}

	@Step
	public void typeDesignation(String designation) {
		onSupContactTabPage.typeDesignation(designation);
	}

	@Step
	public void typeDesignationGroup(String designationGroup) {
		onSupContactTabPage.typeDesignationGroup(designationGroup);
	}

	@Step
	public void typeDepartment(String department) {
		onSupContactTabPage.typeDepartment(department);
	}

	@Step
	public void chooseIncDefault(String incType) {
		onSupContactTabPage.chooseTypeDefault(incType);
	}

	@Step
	public boolean is_added_contact(String contactType, String contactInformation) {
		return onSupContactTabPage.is_added_contact(contactType, contactInformation);
	}

	@Step
	public void chooseContactTypeContactType(String contactTypeContactType, int rowIndex) {
		onSupContactTabPage.chooseContactTypeContactType(contactTypeContactType, rowIndex);
	}

	@Step
	public void typeContactTypeContactInformation(String contactTypeContactInformation, int rowIndex) {
		onSupContactTabPage.typeContactTypeContactInformation(contactTypeContactInformation, rowIndex);
	}

	@Step
	public void chooseContactTypeTypeDefault(int rowIndex) {
		onSupContactTabPage.chooseContactTypeTypeDefault(rowIndex);
	}

	@Step
	public void chooseDelContactType(int rowIndex) {
		onSupContactTabPage.chooseContactTypeDel(rowIndex);
	}

	public void chooseDelContact(String partyContactCode) {
		onSupContactTabPage.chooseDelContact(partyContactCode);
	}

	public boolean chooseContact(String partyContactCode) {

		return onSupContactTabPage.chooseContact(partyContactCode);
	}

	public boolean isContactExit(String partyContactCode) {
		return onSupContactTabPage.isContactExit(partyContactCode);
	}
}
