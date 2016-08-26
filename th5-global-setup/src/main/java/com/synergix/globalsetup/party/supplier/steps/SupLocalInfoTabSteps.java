package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupLocalInfoTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupLocalInfoTabSteps extends ScenarioSteps {

	SupLocalInfoTabPage onSupLocalInfoTabPage;

	/**
	 * Region Local Info Tab
	 */

	@Step
	public void clickOnAddCountry() {
		onSupLocalInfoTabPage.clickOnAddCountry();
	}

	@Step
	public void clickToOpenPort(int rowIndex) {
		onSupLocalInfoTabPage.clickToOpenPort(rowIndex);
	}

	@Step
	public int getRowIndexCountry(String country) {
		return onSupLocalInfoTabPage.getRowIndexCountry(country);
	}

	@Step
	public int countRowCountry() {
		return onSupLocalInfoTabPage.countRowCountry();
	}

	@Step
	public int getRowIndexShipTerm(String shippingTerm) {
		return onSupLocalInfoTabPage.getRowIndexShipTerm(shippingTerm);
	}

	@Step
	public int getRowIndexPort(String port) {
		return onSupLocalInfoTabPage.getRowIndexPort(port);
	}

	@Step
	public boolean findPort(String port) {
		return onSupLocalInfoTabPage.findPort(port);
	}

	@Step
	public void moveToLocalInfoTab() {
		onSupLocalInfoTabPage.switch_to_tab("Local Info");
	}

	@Step
	public void moveToShipmentInfoTab() {
		onSupLocalInfoTabPage.switch_to_tab("Shipment Info");
	}

	@Step
	public void moveToDefaultSettingTab() {
		onSupLocalInfoTabPage.switch_to_tab("Default Setting for HSBC iFile");
	}

	@Step
	public void moveToShipmentModeTermTab() {
		onSupLocalInfoTabPage.switch_to_tab("Shipment Mode / Term");
	}

	@Step
	public void moveToCountryPortTab() {
		onSupLocalInfoTabPage.switch_to_tab("Country / Port");
	}

	@Step
	public void chooseInc(int rowIndex) {
		onSupLocalInfoTabPage.chooseInc(rowIndex);
	}

	@Step
	public void chooseAir(int rowIndex) {
		onSupLocalInfoTabPage.chooseAir(rowIndex);
	}

	@Step
	public void chooseSea(int rowIndex) {
		onSupLocalInfoTabPage.chooseSea(rowIndex);
	}

	@Step
	public void chooseRoad(int rowIndex) {
		onSupLocalInfoTabPage.chooseRoad(rowIndex);
	}

	@Step
	public void chooseRail(int rowIndex) {
		onSupLocalInfoTabPage.chooseRail(rowIndex);
	}

	@Step
	public void chooseShipmentDefault(int rowIndex) {
		onSupLocalInfoTabPage.chooseShipmentDefault(rowIndex);
	}

	@Step
	public void typeCountry(String country, int rowIndex) {
		onSupLocalInfoTabPage.typeCountry(country, rowIndex);
	}

	@Step
	public void chooseLoading(int rowIndex) {
		onSupLocalInfoTabPage.chooseLoading(rowIndex);
	}

	@Step
	public void chooseDischarge(int rowIndex) {
		onSupLocalInfoTabPage.chooseDischarge(rowIndex);
	}

	@Step
	public void chooseFinalDest(int rowIndex) {
		onSupLocalInfoTabPage.chooseFinalDest(rowIndex);
	}

	@Step
	public void chooseDelCountry(int rowIndex) {
		onSupLocalInfoTabPage.chooseDelCountry(rowIndex);
	}

	@Step
	public void choosePortLoading(int rowIndex) {
		onSupLocalInfoTabPage.choosePortLoading(rowIndex);
	}

	@Step
	public void choosePortDischange(int rowIndex) {
		onSupLocalInfoTabPage.choosePortDischange(rowIndex);
	}

	@Step
	public void choosePortFinalDest(int rowIndex) {
		onSupLocalInfoTabPage.choosePortFinalDest(rowIndex);
	}

	@Step
	public void chooseDeductChargeFlag(String deductChargeFlag) {
		onSupLocalInfoTabPage.chooseDeductChargeFlag(deductChargeFlag);
	}

	@Step
	public void chooseDeliveryToFornonCC(String deliveryToFornonCC) {
		onSupLocalInfoTabPage.chooseDeliveryToFornonCC(deliveryToFornonCC);
	}

	@Step
	public void chooseDeliveryMode(String deliveryMode) {
		onSupLocalInfoTabPage.chooseDeliveryMode(deliveryMode);
	}

	@Step
	public boolean chooseContry(String country) {
		return onSupLocalInfoTabPage.chooseContry(country);
	}

	public boolean isCountryExit(String country) {
		return onSupLocalInfoTabPage.isCountryExit(country);
	}

	public void chooseDelCountry(String country) {
		onSupLocalInfoTabPage.chooseDelCountry(country);
	}

}
