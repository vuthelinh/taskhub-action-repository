package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupAddressTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupAddressTabSteps extends ScenarioSteps {

	SupAddressTabPage onSupAddressTabPage;

	/**
	 * Region Address Tab
	 */

	@Step
	public void moveToAddressTab() {
		onSupAddressTabPage.switch_to_tab("Address");
		onSupAddressTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddAddressBtn() {
		onSupAddressTabPage.clickOnAddAddressBtn();
	}

	@Step
	public void clickOnAddContactTypeBtn() {
		onSupAddressTabPage.clickOnAddContactTypeBtn();
	}

	@Step
	public int countRowContactTypeTb() {
		return onSupAddressTabPage.countRowContactTypeTb();
	}

	@Step
	public void typeAddressCode(String addressCode) {
		onSupAddressTabPage.typeAddressCode(addressCode);
	}

	@Step
	public void typeAddressDescription(String addressDescription) {
		onSupAddressTabPage.typeAddressDescription(addressDescription);
	}

	@Step
	public void typeAddress(String address) {
		onSupAddressTabPage.typeAddress(address);
	}

	@Step
	public void typeCountryCode(String countryCode) {
		onSupAddressTabPage.typeCountryCode(countryCode);
	}

	@Step
	public void typeStateProvince(String stateProvince) {
		onSupAddressTabPage.typeStateProvince(stateProvince);
	}

	@Step
	public void typeCityTown(String cityTown) {
		onSupAddressTabPage.typeCityTown(cityTown);
	}

	@Step
	public void typePostalCode(String postalCode) {
		onSupAddressTabPage.typePostalCode(postalCode);
	}

	@Step
	public void chooseIncType(String incType) {
		onSupAddressTabPage.chooseIncType(incType);
	}

	@Step
	public void chooseTypeDefault(String incType) {
		onSupAddressTabPage.chooseTypeDefault(incType);
	}

	@Step
	public boolean is_added_contact(String contactType, String contactInformation) {
		return onSupAddressTabPage.is_added_contact(contactType, contactInformation);
	}

	@Step
	public void chooseContactType(String contactType, int rowIndex) {
		onSupAddressTabPage.chooseContactType(contactType, rowIndex);
	}

	@Step
	public void typeContactInformation(String contactInformation, int rowIndex) {
		onSupAddressTabPage.typeContactInformation(contactInformation, rowIndex);
	}

	@Step
	public void chooseContactTypeDefault(int rowIndex) {
		onSupAddressTabPage.chooseContactTypeDefault(rowIndex);
	}

	@Step
	public void chooseDel(int rowIndex) {
		onSupAddressTabPage.chooseDel(rowIndex);
	}

	@Step
	public void chooseLRA(String addressCode) {
		onSupAddressTabPage.chooseLRA(addressCode);
	}

	@Step
	public void chooseDelAddress(String addressCode) {
		onSupAddressTabPage.chooseDelAddress(addressCode);
	}

	@Step
	public boolean chooseAddressCode(String addressCode) {
		return onSupAddressTabPage.chooseAddressCode(addressCode);
	}

	public boolean isAddressCodeExit(String addressCode) {
		return onSupAddressTabPage.isAddressCodeExit(addressCode);
	}

}
