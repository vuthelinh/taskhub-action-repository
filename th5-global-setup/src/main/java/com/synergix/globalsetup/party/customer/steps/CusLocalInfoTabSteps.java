package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CusLocalInfoTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusLocalInfoTabSteps extends ScenarioSteps {

	CusLocalInfoTabPage onCusLocalInfoTabPage;

	/**
	 * REGION LOCAL INFO TAB
	 */

	@Step
	public void moveToLocalInfoTab() {
		onCusLocalInfoTabPage.switch_to_tab("Local Info");
	}

	@Step
	public void moveToPricingTab() {
		onCusLocalInfoTabPage.switch_to_tab("Pricing");
	}

	@Step
	public void moveToShipmentInfo() {
		onCusLocalInfoTabPage.switch_to_tab("Shipment Info");
	}

	@Step
	public void moveToCreditLimitTab() {
		onCusLocalInfoTabPage.switch_to_tab("Credit Limit/Term");
	}

	@Step
	public void moveToShipmentTermTab() {
		onCusLocalInfoTabPage.switch_to_tab("Shipment Mode / Term");
	}

	@Step
	public void moveToShipmentPort() {
		onCusLocalInfoTabPage.switch_to_tab("Country / Port");
	}

	@Step
	public void moveToCustomerInventory() {
		onCusLocalInfoTabPage.switch_to_tab("Customer Inventory Brand Discount");
	}

	@Step
	public int getRowIndexPricing(String currencyCode) {
		return onCusLocalInfoTabPage.getRowIndexPricing(currencyCode);
	}

	@Step
	public void clickOnPriceListIcon(int rowIndex) {
		onCusLocalInfoTabPage.clickOnPriceListIcon(rowIndex);
	}

	@Step
	public void typeInventoryPriceListCode(String inventoryPriceListCode, int rowIndex) {
		onCusLocalInfoTabPage.typeInventoryPriceListCode(inventoryPriceListCode, rowIndex);
	}

	@Step
	public void typeServicePriceListCode(String servicePriceListCode, int rowIndex) {
		onCusLocalInfoTabPage.typeServicePriceListCode(servicePriceListCode, rowIndex);
	}

	// List Pricing

	public void clickOnAddListPricing() {
		onCusLocalInfoTabPage.clickOnAddListPricing();
	}

	public int countRowListPricing() {
		return onCusLocalInfoTabPage.countRowListPricing();
	}

	public void clickOnDoneListPricing() {
		onCusLocalInfoTabPage.clickOnDoneListPricing();
	}

	@Step
	public void typeListWorkingAreaCode(String listWorkingAreaCode, int listRowIndex) {
		onCusLocalInfoTabPage.typeListWorkingAreaCode(listWorkingAreaCode, listRowIndex);
	}

	@Step
	public void typeListInventoryPriceListCode(String listInventoryPriceListCode, int listRowIndex) {
		onCusLocalInfoTabPage.typeListInventoryPriceListCode(listInventoryPriceListCode, listRowIndex);
	}

	@Step
	public void typeListServicePriceListCode(String listServicePriceListCode, int listRowIndex) {
		onCusLocalInfoTabPage.typeListServicePriceListCode(listServicePriceListCode, listRowIndex);
	}

	@Step
	public void chooseDeleteListPricing(int listRowIndex) {
		onCusLocalInfoTabPage.chooseDeleteListPricing(listRowIndex);
	}

	// Credit Limit Term Tab
	@Step
	public String getOperationCurrency() {
		return onCusLocalInfoTabPage.getOperationCurrency();
	}

	@Step
	public void typeCreditLimitAmt(String creditLimitAmt) {
		onCusLocalInfoTabPage.typeCreditLimitAmt(creditLimitAmt);
	}

	@Step
	public void typeGracePeriod(String gracePeriod) {
		onCusLocalInfoTabPage.typeGracePeriod(gracePeriod);
	}

	// Shipment Mode Term

	@Step
	public int getRowIndexShipTerm(String shippingTerm) {
		return onCusLocalInfoTabPage.getRowIndexShipTerm(shippingTerm);
	}

	@Step
	public void chooseInc(int rowIndex) {
		onCusLocalInfoTabPage.chooseInc(rowIndex);
	}

	@Step
	public void chooseAir(int rowIndex) {
		onCusLocalInfoTabPage.chooseAir(rowIndex);
	}

	@Step
	public void chooseSea(int rowIndex) {
		onCusLocalInfoTabPage.chooseSea(rowIndex);
	}

	@Step
	public void chooseRoad(int rowIndex) {
		onCusLocalInfoTabPage.chooseRoad(rowIndex);
	}

	@Step
	public void chooseRail(int rowIndex) {
		onCusLocalInfoTabPage.chooseRail(rowIndex);
	}

	@Step
	public void chooseShipmentDefault(int rowIndex) {
		onCusLocalInfoTabPage.chooseShipmentDefault(rowIndex);
	}

	// Country Port

	@Step
	public int getRowIndexCountry(String country) {
		return onCusLocalInfoTabPage.getRowIndexCountry(country);
	}

	@Step
	public void clickOnAddCountry() {
		onCusLocalInfoTabPage.clickOnAddCountry();
	}

	@Step
	public int countRowCountry() {
		return onCusLocalInfoTabPage.countRowCountry();
	}

	@Step
	public void clickToOpenPort(int rowIndex) {
		onCusLocalInfoTabPage.clickToOpenPort(rowIndex);
	}

	@Step
	public void chooseLoading(int rowIndex) {
		onCusLocalInfoTabPage.chooseLoading(rowIndex);
	}

	@Step
	public void chooseDischarge(int rowIndex) {
		onCusLocalInfoTabPage.chooseDischarge(rowIndex);
	}

	@Step
	public void chooseFinalDest(int rowIndex) {
		onCusLocalInfoTabPage.chooseFinalDest(rowIndex);
	}

	@Step
	public void typeCountry(String country, int rowIndex) {
		onCusLocalInfoTabPage.typeCountry(country, rowIndex);
	}

	@Step
	public void chooseDelCountry(int rowIndex) {
		onCusLocalInfoTabPage.chooseDelCountry(rowIndex);
	}

	// Details Port

	@Step
	public int getRowIndexPort(String port) {
		return onCusLocalInfoTabPage.getRowIndexPort(port);
	}

	@Step
	public void choosePortLoading(int rowIndex) {
		onCusLocalInfoTabPage.choosePortLoading(rowIndex);
	}

	@Step
	public void choosePortDischange(int rowIndex) {
		onCusLocalInfoTabPage.choosePortDischange(rowIndex);
	}

	@Step
	public void choosePortFinalDest(int rowIndex) {
		onCusLocalInfoTabPage.choosePortFinalDest(rowIndex);
	}

	// Local Customer Inventory Tab

	@Step
	public void clickOnAddInventoryBrand() {
		onCusLocalInfoTabPage.clickOnAddInventoryBrand();
	}

	@Step
	public int countRowInventoryBrand() {
		return onCusLocalInfoTabPage.countRowInventoryBrand();
	}

	@Step
	public void typeInventoryBrand(String inventoryBrand, int listRowIndex) {
		onCusLocalInfoTabPage.typeInventoryBrand(inventoryBrand, listRowIndex);
	}

	@Step
	public void typeDiscountCode(String discountCode, int listRowIndex) {
		onCusLocalInfoTabPage.typeDiscountCode(discountCode, listRowIndex);
	}

	@Step
	public void typeDiscount(String discount, int listRowIndex) {
		onCusLocalInfoTabPage.typeDiscount(discount, listRowIndex);
	}

	@Step
	public void chooseDelInventoryBrand(int listRowIndex) {
		onCusLocalInfoTabPage.chooseDelInventoryBrand(listRowIndex);
	}

	public String verifyMessagePopup() {
		return onCusLocalInfoTabPage.verifyMessagePopup();
	}

	public void chooseLRA(String addressCode) {
		onCusLocalInfoTabPage.chooseLRA(addressCode);
	}

	public void chooseDelAddress(String addressCode) {
		onCusLocalInfoTabPage.chooseDelAddress(addressCode);
	}

	public boolean chooseContry(String country) {
		return onCusLocalInfoTabPage.chooseCountry(country);
	}

	public boolean isCountryExit(String country) {
		// TODO Auto-generated method stub
		return onCusLocalInfoTabPage.isCountryExit(country);
	}

	public void chooseDelCountry(String country) {
		onCusLocalInfoTabPage.chooseDelCountry(country);
	}

}
