package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupSalePersonTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupSalePersonTabSteps extends ScenarioSteps {

	SupSalePersonTabPage onSupSalePersonTabPage;

	@Step
	public void clickOnUpdateButton() {
		onSupSalePersonTabPage.onClickUpdateButton();
	}

	@Step
	public void addSupplier() {
		onSupSalePersonTabPage.onClickNewButton();
	}

	@Step
	public void typeSupplier(String supplier) {
		onSupSalePersonTabPage.typeSupplier(supplier);
	}

	@Step
	public void typeSupplierName(String supplierName) {
		onSupSalePersonTabPage.typeSupplierName(supplierName);
	}

	@Step
	public void typeSupplierClassCode(String supplierClassCode) {
		onSupSalePersonTabPage.typeSupplierClassCode(supplierClassCode);
	}

	@Step
	public void typePartyGroupCode(String partyGroupCode) {
		onSupSalePersonTabPage.typePartyGroupCode(partyGroupCode);
	}

	@Step
	public void typeMainHomePage(String mainHomePage) {
		onSupSalePersonTabPage.typeMainHomePage(mainHomePage);
	}

	@Step
	public void typeGSTRegistrationNo(String gSTRegistrationNo) {
		onSupSalePersonTabPage.typeGSTRegistrationNo(gSTRegistrationNo);
	}

	@Step
	public void typeCountryOfIncorporation(String countryOfIncorporation) {
		onSupSalePersonTabPage.typeCountryOfIncorporation(countryOfIncorporation);
	}

	@Step
	public void typeSubconWIPGlan(String subconWIPGlan) {
		onSupSalePersonTabPage.typeSubconWIPGlan(subconWIPGlan);
	}

	@Step
	public void typeSalesTaxCode(String salesTaxCode) {
		onSupSalePersonTabPage.typeSalesTaxCode(salesTaxCode);
	}

	@Step
	public void typeDefaultTenorTermCode(String defaultTenorTermCode) {
		onSupSalePersonTabPage.typeDefaultTenorTermCode(defaultTenorTermCode);
	}

	@Step
	public void typeDefaultTenor(String defaultTenor) {
		onSupSalePersonTabPage.typeDefaultTenor(defaultTenor);
	}

	@Step
	public void chooseIPTRelated(String iPTRelated) {
		onSupSalePersonTabPage.chooseIPTRelated(iPTRelated);
	}

	@Step
	public void chooseStatus(String status) {
		onSupSalePersonTabPage.chooseStatus(status);
	}

	@Step
	public void typeUniqueEntityNo(String uniqueEntityNo) {
		onSupSalePersonTabPage.typeUniqueEntityNo(uniqueEntityNo);
	}

	@Step
	public void typeMainSupplierCode(String mainSupplierCode) {
		onSupSalePersonTabPage.typeMainSupplierCode(mainSupplierCode);
	}

	@Step
	public void typeSupplierShortName(String supplierShortName) {
		onSupSalePersonTabPage.typeSupplierShortName(supplierShortName);
	}

	@Step
	public void typeSupplierCategoryCode(String supplierCategoryCode) {
		onSupSalePersonTabPage.typeSupplierCategoryCode(supplierCategoryCode);
	}

	@Step
	public void typeSupplierRankCode(String supplierRankCode) {
		onSupSalePersonTabPage.typeSupplierRankCode(supplierRankCode);
	}

	@Step
	public void typePurchasingZone(String purchasingZone) {
		onSupSalePersonTabPage.typePurchasingZone(purchasingZone);
	}

	@Step
	public void typePartyContraGLAN(String partyContraGLAN) {
		onSupSalePersonTabPage.typePartyContraGLAN(partyContraGLAN);
	}

	@Step
	public void typeContraRealizedExchGLAN(String contraRealizedExchGLAN) {
		onSupSalePersonTabPage.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
	}

	@Step
	public void typeDefaultDiscountPercent(String defaultDiscountPercent) {
		onSupSalePersonTabPage.typeDefaultDiscountPercent(defaultDiscountPercent);
	}

	@Step
	public void chooseCombineShmtoInvoices(String combineShmtoInvoices) {
		onSupSalePersonTabPage.chooseCombineShmtoInvoices(combineShmtoInvoices);
	}

	@Step
	public void typeRemarks(String remarks) {
		onSupSalePersonTabPage.typeRemarks(remarks);
	}

	@Step
	public void moveToCompanyTab() {
		onSupSalePersonTabPage.switch_to_tab("Company");
	}

	@Step
	public void checkAllCompany() {
		onSupSalePersonTabPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onSupSalePersonTabPage.chooseCompany(company);
	}

	@Step
	public void clickAddCurrency() {
		onSupSalePersonTabPage.clickOnAddCurrencyBtn();
	}

	@Step
	public void moveToCurrencyTab() {
		onSupSalePersonTabPage.switch_to_tab("Currency");
	}

	@Step
	public void typeCurrency(String currency) {
		onSupSalePersonTabPage.typeCurrency(currency);
	}

	@Step
	public void moveToPaymentTab() {
		onSupSalePersonTabPage.switch_to_tab("Payment");
	}

	@Step
	public void selectOperationalCurrency(String operationalCurrency) {
		onSupSalePersonTabPage.selectOperationalCurrency(operationalCurrency);
	}

	@Step
	public void typeOverallCreditLimit(String overallCreditLimit) {
		onSupSalePersonTabPage.typeOverallCreditLimit(overallCreditLimit);
	}

	@Step
	public void selectDefault(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onSupSalePersonTabPage.selectDefault(tableName, description);
	}

	@Step
	public void clickDescription(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onSupSalePersonTabPage.clickDescription(tableName, description);
	}

	@Step
	public void chooseIsActive(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onSupSalePersonTabPage.chooseIsActive(tableName, description);
	}

	@Step
	public void updateSupplier(String supplier) {
		onSupSalePersonTabPage.updateSupplier(supplier);
	}

	@Step
	public void searchParty(String supplier) {
		onSupSalePersonTabPage.searchParty(supplier);
	}

	/**
	 * Region Address Tab
	 */

	@Step
	public void moveToAddressTab() {
		onSupSalePersonTabPage.switch_to_tab("Address");
		onSupSalePersonTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddAddressBtn() {
		onSupSalePersonTabPage.clickOnAddAddressBtn();
	}

	@Step
	public void clickOnAddContactTypeBtn() {
		onSupSalePersonTabPage.clickOnAddContactTypeBtn();
	}

	@Step
	public int countRowContactTypeTb() {
		return onSupSalePersonTabPage.countRowContactTypeTb();
	}

	@Step
	public void typeAddressCode(String addressCode) {
		onSupSalePersonTabPage.typeAddressCode(addressCode);
	}

	@Step
	public void typeAddressDescription(String addressDescription) {
		onSupSalePersonTabPage.typeAddressDescription(addressDescription);
	}

	@Step
	public void typeAddress(String address) {
		onSupSalePersonTabPage.typeAddress(address);
	}

	@Step
	public void typeCountryCode(String countryCode) {
		onSupSalePersonTabPage.typeCountryCode(countryCode);
	}

	@Step
	public void typeStateProvince(String stateProvince) {
		onSupSalePersonTabPage.typeStateProvince(stateProvince);
	}

	@Step
	public void typeCityTown(String cityTown) {
		onSupSalePersonTabPage.typeCityTown(cityTown);
	}

	@Step
	public void typePostalCode(String postalCode) {
		onSupSalePersonTabPage.typePostalCode(postalCode);
	}

	@Step
	public void chooseIncType(String incType) {
		onSupSalePersonTabPage.chooseIncType(incType);
	}

	@Step
	public void chooseTypeDefault(String incType) {
		onSupSalePersonTabPage.chooseTypeDefault(incType);
	}

	@Step
	public void chooseContactType(String contactType, int rowIndex) {
		onSupSalePersonTabPage.chooseContactType(contactType, rowIndex);
	}

	@Step
	public void typeContactInformation(String contactInformation, int rowIndex) {
		onSupSalePersonTabPage.typeContactInformation(contactInformation, rowIndex);
	}

	@Step
	public void chooseContactTypeDefault(int rowIndex) {
		onSupSalePersonTabPage.chooseContactTypeDefault(rowIndex);
	}

	@Step
	public void chooseDel(int rowIndex) {
		onSupSalePersonTabPage.chooseDel(rowIndex);
	}

	/**
	 * Region Contact Tab
	 */

	@Step
	public void moveToContactTab() {
		onSupSalePersonTabPage.switch_to_tab("Contact");
		onSupSalePersonTabPage.waitForAllJSCompletes();
	}

	@Step
	public int countRowContactContactTypeTb() {
		return onSupSalePersonTabPage.countRowContactContactTypeTb();
	}

	@Step
	public void clickOnAddContact() {
		onSupSalePersonTabPage.clickOnAddContact();
	}

	@Step
	public void typePartyContactCode(String partyContactCode) {
		onSupSalePersonTabPage.typePartyContactCode(partyContactCode);
	}

	@Step
	public void chooseSalutation(String salutation) {
		onSupSalePersonTabPage.chooseSalutation(salutation);
	}

	@Step
	public void typeFirstName(String firstName) {
		onSupSalePersonTabPage.typeFirstName(firstName);
	}

	@Step
	public void typeMiddleName(String middleName) {
		onSupSalePersonTabPage.typeMiddleName(middleName);
	}

	@Step
	public void typeLastName(String lastName) {
		onSupSalePersonTabPage.typeLastName(lastName);
	}

	@Step
	public void typeName(String name) {
		onSupSalePersonTabPage.typeName(name);
	}

	@Step
	public void chooseAddressCode(String addressCode) {
		onSupSalePersonTabPage.chooseAddressCode(addressCode);
	}

	@Step
	public void typeDesignation(String designation) {
		onSupSalePersonTabPage.typeDesignation(designation);
	}

	@Step
	public void typeDesignationGroup(String designationGroup) {
		onSupSalePersonTabPage.typeDesignationGroup(designationGroup);
	}

	@Step
	public void typeDepartment(String department) {
		onSupSalePersonTabPage.typeDepartment(department);
	}

	@Step
	public void chooseIncDefault(String incType) {
		onSupSalePersonTabPage.chooseTypeDefault(incType);
	}

	@Step
	public void chooseContactTypeContactType(String contactTypeContactType, int rowIndex) {
		onSupSalePersonTabPage.chooseContactTypeContactType(contactTypeContactType, rowIndex);
	}

	@Step
	public void typeContactTypeContactInformation(String contactTypeContactInformation, int rowIndex) {
		onSupSalePersonTabPage.typeContactTypeContactInformation(contactTypeContactInformation, rowIndex);
	}

	@Step
	public void chooseContactTypeTypeDefault(int rowIndex) {
		onSupSalePersonTabPage.chooseContactTypeTypeDefault(rowIndex);
	}

	@Step
	public void chooseContactTypeDel(int rowIndex) {
		onSupSalePersonTabPage.chooseContactTypeDel(rowIndex);
	}

	/**
	 * Region Bank Detail Tab
	 */

	@Step
	public void moveToBankDetailTab() {
		onSupSalePersonTabPage.switch_to_tab("Bank Detail");
		onSupSalePersonTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddBankDetail() {
		onSupSalePersonTabPage.clickOnAddBankDetail();
	}

	@Step
	public int countRowBankDetail() {
		return onSupSalePersonTabPage.countRowBankDetal();
	}

	@Step
	public void typeBank(String bank, int rowIndex) {
		onSupSalePersonTabPage.typeBank(bank, rowIndex);
	}

	@Step
	public void typeDescription(String description, int rowIndex) {
		onSupSalePersonTabPage.typeDescription(description, rowIndex);
	}

	@Step
	public void typeAccountNo(String accountNo, int rowIndex) {
		onSupSalePersonTabPage.typeAccountNo(accountNo, rowIndex);
	}

	@Step
	public void typeBankCurrency(String currency, int rowIndex) {
		onSupSalePersonTabPage.typeBankCurrency(currency, rowIndex);
	}

	@Step
	public void chooseBankDefault(int rowIndex) {
		onSupSalePersonTabPage.chooseBankDefault(rowIndex);
	}

	@Step
	public void chooseBankDel(int rowIndex) {
		onSupSalePersonTabPage.chooseBankDel(rowIndex);
	}

	/**
	 * Region SBU Tab
	 **/

	@Step
	public void moveToSBUTab() {
		onSupSalePersonTabPage.switch_to_tab("SBU");
		onSupSalePersonTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickAddSBU() {
		onSupSalePersonTabPage.clickOnAddSBU();
	}

	@Step
	public int countRowSBU() {
		return onSupSalePersonTabPage.countRowSBU();
	}

	@Step
	public void typeSBU(String sBU, int rowIndex) {
		onSupSalePersonTabPage.typeSBU(sBU, rowIndex);
	}

	@Step
	public void typeSBUDescription(String description, int rowIndex) {
		onSupSalePersonTabPage.typeSBUDescription(description, rowIndex);
	}

	@Step
	public void typeDel(int rowIndex) {
		onSupSalePersonTabPage.typeDel(rowIndex);
	}

	/**
	 * Region Local Info Tab
	 */

	@Step
	public void clickOnAddCountry() {
		onSupSalePersonTabPage.clickOnAddCountry();
	}

	@Step
	public void clickToOpenPort(int rowIndex) {
		onSupSalePersonTabPage.clickToOpenPort(rowIndex);
	}

	@Step
	public int getRowIndexCountry(String country) {
		return onSupSalePersonTabPage.getRowIndexCountry(country);
	}

	@Step
	public int countRowCountry() {
		return onSupSalePersonTabPage.countRowCountry();
	}

	@Step
	public int getRowIndexShipTerm(String shippingTerm) {
		return onSupSalePersonTabPage.getRowIndexShipTerm(shippingTerm);
	}

	@Step
	public int getRowIndexPort(String port) {
		return onSupSalePersonTabPage.getRowIndexPort(port);
	}

	@Step
	public boolean findPort(String port) {
		return onSupSalePersonTabPage.findPort(port);
	}

	@Step
	public void moveToLocalInfoTab() {
		onSupSalePersonTabPage.switch_to_tab("Local Info");
	}

	@Step
	public void moveToShipmentInfoTab() {
		onSupSalePersonTabPage.switch_to_tab("Shipment Info");
	}

	@Step
	public void moveToDefaultSettingTab() {
		onSupSalePersonTabPage.switch_to_tab("Default Setting for HSBC iFile");
	}

	@Step
	public void moveToShipmentModeTermTab() {
		onSupSalePersonTabPage.switch_to_tab("Shipment Mode / Term");
	}

	@Step
	public void moveToCountryPortTab() {
		onSupSalePersonTabPage.switch_to_tab("Country / Port");
	}

	@Step
	public void chooseInc(int rowIndex) {
		onSupSalePersonTabPage.chooseInc(rowIndex);
	}

	@Step
	public void chooseAir(int rowIndex) {
		onSupSalePersonTabPage.chooseAir(rowIndex);
	}

	@Step
	public void chooseSea(int rowIndex) {
		onSupSalePersonTabPage.chooseSea(rowIndex);
	}

	@Step
	public void chooseRoad(int rowIndex) {
		onSupSalePersonTabPage.chooseRoad(rowIndex);
	}

	@Step
	public void chooseRail(int rowIndex) {
		onSupSalePersonTabPage.chooseRail(rowIndex);
	}

	@Step
	public void chooseShipmentDefault(int rowIndex) {
		onSupSalePersonTabPage.chooseShipmentDefault(rowIndex);
	}

	@Step
	public void typeCountry(String country, int rowIndex) {
		onSupSalePersonTabPage.typeCountry(country, rowIndex);
	}

	@Step
	public void chooseLoading(int rowIndex) {
		onSupSalePersonTabPage.chooseLoading(rowIndex);
	}

	@Step
	public void chooseDischarge(int rowIndex) {
		onSupSalePersonTabPage.chooseDischarge(rowIndex);
	}

	@Step
	public void chooseFinalDest(int rowIndex) {
		onSupSalePersonTabPage.chooseFinalDest(rowIndex);
	}

	@Step
	public void chooseDelCountry(int rowIndex) {
		onSupSalePersonTabPage.chooseDelCountry(rowIndex);
	}

	@Step
	public void choosePortLoading(int rowIndex) {
		onSupSalePersonTabPage.choosePortLoading(rowIndex);
	}

	@Step
	public void choosePortDischange(int rowIndex) {
		onSupSalePersonTabPage.choosePortDischange(rowIndex);
	}

	@Step
	public void choosePortFinalDest(int rowIndex) {
		onSupSalePersonTabPage.choosePortFinalDest(rowIndex);
	}

	/**
	 * REGION DEFAULT TAB
	 */

	@Step
	public void chooseDeductChargeFlag(String deductChargeFlag) {
		onSupSalePersonTabPage.chooseDeductChargeFlag(deductChargeFlag);
	}

	@Step
	public void chooseDeliveryToFornonCC(String deliveryToFornonCC) {
		onSupSalePersonTabPage.chooseDeliveryToFornonCC(deliveryToFornonCC);
	}

	@Step
	public void chooseDeliveryMode(String deliveryMode) {
		onSupSalePersonTabPage.chooseDeliveryMode(deliveryMode);
	}

}
