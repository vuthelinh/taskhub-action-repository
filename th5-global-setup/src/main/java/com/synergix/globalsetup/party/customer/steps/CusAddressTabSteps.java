package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CusAddressTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusAddressTabSteps extends ScenarioSteps {

	CusAddressTabPage onCusAddressTabPage;

	/**
	 * REGION ADDRESS TAB
	 */

	@Step
	public void moveToAddressTab() {
		onCusAddressTabPage.switch_to_tab("Address");
	}

	@Step
	public void clickOnAddAddress() {
		onCusAddressTabPage.clickOnAddAddress();
		onCusAddressTabPage.waitForAllJSCompletes();
	}

	@Step
	public void typeAddressCode(String addressCode) {
		onCusAddressTabPage.typeAddressCode(addressCode);
	}

	@Step
	public void typeDescription(String description) {
		onCusAddressTabPage.typeDescription(description);
	}

	@Step
	public void typeAddress(String address) {
		onCusAddressTabPage.typeAddress(address);
	}

	@Step
	public void typeCountryCode(String countryCode) {
		onCusAddressTabPage.typeCountryCode(countryCode);
	}

	@Step
	public void typeStateProvince(String stateProvince) {
		onCusAddressTabPage.typeStateProvince(stateProvince);
	}

	@Step
	public void typeCityTown(String cityTown) {
		onCusAddressTabPage.typeCityTown(cityTown);
	}

	@Step
	public void typePostalCode(String postalCode) {
		onCusAddressTabPage.typePostalCode(postalCode);
	}

	@Step
	public void typeBlockEstateName(String blockEstateName) {
		onCusAddressTabPage.typeBlockEstateName(blockEstateName);
	}

	@Step
	public void typeStreetName(String streetName) {
		onCusAddressTabPage.typeStreetName(streetName);
	}

	@Step
	public void typeBuildingBlockHouseNo(String buildingBlockHouseNo) {
		onCusAddressTabPage.typeBuildingBlockHouseNo(buildingBlockHouseNo);
	}

	@Step
	public void chooseBuildingType(String buildingType) {
		onCusAddressTabPage.chooseBuildingType(buildingType);
	}

	@Step
	public void typeUnitNo(String unitNo) {
		onCusAddressTabPage.typeUnitNo(unitNo);
	}

	@Step
	public void chooseIncType(String incType) {
		onCusAddressTabPage.chooseIncType(incType);
	}

	@Step
	public void chooseDefaultIncType(String addrDefault) {
		onCusAddressTabPage.chooseDefaultIncType(addrDefault);
	}

	@Step
	public void clickOnAddAddrContactType() {
		onCusAddressTabPage.clickOnAddAddrContactType();
	}

	@Step
	public int countRowAddrContactType() {
		return onCusAddressTabPage.countRowAddrContactType();
	}

	@Step
	public boolean is_added_contact(String contactType, String contactInformation) {
		return onCusAddressTabPage.is_added_contact(contactType, contactInformation);
	}

	@Step
	public void chooseContactType(String contactType, int rowIndex) {
		onCusAddressTabPage.chooseContactType(contactType, rowIndex);
	}

	@Step
	public void typeContactInformation(String contactInformation, int rowIndex) {
		onCusAddressTabPage.typeContactInformation(contactInformation, rowIndex);
	}

	@Step
	public void chooseAddrContactTypeDefault(int rowIndex) {
		onCusAddressTabPage.chooseAddrContactTypeDefault(rowIndex);
	}

	@Step
	public void chooseDelAddContactType(int rowIndex) {
		onCusAddressTabPage.chooseDel(rowIndex);
	}

	public void chooseLRA(String addressCode) {
		onCusAddressTabPage.chooseLRA(addressCode);
	}

	public void chooseDelAddress(String addressCode) {
		onCusAddressTabPage.chooseDelAddress(addressCode);
	}

	public boolean chooseAddressCode(String addressCode) {
		return onCusAddressTabPage.chooseAddressCode(addressCode);
	}

	public boolean isAddressCodeExit(String addressCode) {
		return onCusAddressTabPage.isAddressCodeExit(addressCode);
	}

}
