package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupPaymentTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupPaymentTabSteps extends ScenarioSteps {

	SupPaymentTabPage onSupPaymentTabPage;

	@Step
	public void clickOnUpdateButton() {
		onSupPaymentTabPage.onClickUpdateButton();
	}

	@Step
	public void addSupplier() {
		onSupPaymentTabPage.onClickNewButton();
	}

	@Step
	public void typeSupplier(String supplier) {
		onSupPaymentTabPage.typeSupplier(supplier);
	}

	@Step
	public void typeSupplierName(String supplierName) {
		onSupPaymentTabPage.typeSupplierName(supplierName);
	}

	@Step
	public void typeSupplierClassCode(String supplierClassCode) {
		onSupPaymentTabPage.typeSupplierClassCode(supplierClassCode);
	}

	@Step
	public void typePartyGroupCode(String partyGroupCode) {
		onSupPaymentTabPage.typePartyGroupCode(partyGroupCode);
	}

	@Step
	public void typeMainHomePage(String mainHomePage) {
		onSupPaymentTabPage.typeMainHomePage(mainHomePage);
	}

	@Step
	public void typeGSTRegistrationNo(String gSTRegistrationNo) {
		onSupPaymentTabPage.typeGSTRegistrationNo(gSTRegistrationNo);
	}

	@Step
	public void typeCountryOfIncorporation(String countryOfIncorporation) {
		onSupPaymentTabPage.typeCountryOfIncorporation(countryOfIncorporation);
	}

	@Step
	public void typeSubconWIPGlan(String subconWIPGlan) {
		onSupPaymentTabPage.typeSubconWIPGlan(subconWIPGlan);
	}

	@Step
	public void typeSalesTaxCode(String salesTaxCode) {
		onSupPaymentTabPage.typeSalesTaxCode(salesTaxCode);
	}

	@Step
	public void typeDefaultTenorTermCode(String defaultTenorTermCode) {
		onSupPaymentTabPage.typeDefaultTenorTermCode(defaultTenorTermCode);
	}

	@Step
	public void typeDefaultTenor(String defaultTenor) {
		onSupPaymentTabPage.typeDefaultTenor(defaultTenor);
	}

	@Step
	public void chooseIPTRelated(String iPTRelated) {
		onSupPaymentTabPage.chooseIPTRelated(iPTRelated);
	}

	@Step
	public void chooseStatus(String status) {
		onSupPaymentTabPage.chooseStatus(status);
	}

	@Step
	public void typeUniqueEntityNo(String uniqueEntityNo) {
		onSupPaymentTabPage.typeUniqueEntityNo(uniqueEntityNo);
	}

	@Step
	public void typeMainSupplierCode(String mainSupplierCode) {
		onSupPaymentTabPage.typeMainSupplierCode(mainSupplierCode);
	}

	@Step
	public void typeSupplierShortName(String supplierShortName) {
		onSupPaymentTabPage.typeSupplierShortName(supplierShortName);
	}

	@Step
	public void typeSupplierCategoryCode(String supplierCategoryCode) {
		onSupPaymentTabPage.typeSupplierCategoryCode(supplierCategoryCode);
	}

	@Step
	public void typeSupplierRankCode(String supplierRankCode) {
		onSupPaymentTabPage.typeSupplierRankCode(supplierRankCode);
	}

	@Step
	public void typePurchasingZone(String purchasingZone) {
		onSupPaymentTabPage.typePurchasingZone(purchasingZone);
	}

	@Step
	public void typePartyContraGLAN(String partyContraGLAN) {
		onSupPaymentTabPage.typePartyContraGLAN(partyContraGLAN);
	}

	@Step
	public void typeContraRealizedExchGLAN(String contraRealizedExchGLAN) {
		onSupPaymentTabPage.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
	}

	@Step
	public void typeDefaultDiscountPercent(String defaultDiscountPercent) {
		onSupPaymentTabPage.typeDefaultDiscountPercent(defaultDiscountPercent);
	}

	@Step
	public void chooseCombineShmtoInvoices(String combineShmtoInvoices) {
		onSupPaymentTabPage.chooseCombineShmtoInvoices(combineShmtoInvoices);
	}

	@Step
	public void typeRemarks(String remarks) {
		onSupPaymentTabPage.typeRemarks(remarks);
	}

	@Step
	public void moveToCompanyTab() {
		onSupPaymentTabPage.switch_to_tab("Company");
	}

	@Step
	public void checkAllCompany() {
		onSupPaymentTabPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onSupPaymentTabPage.chooseCompany(company);
	}

	@Step
	public void clickAddCurrency() {
		onSupPaymentTabPage.clickOnAddCurrencyBtn();
	}

	@Step
	public void moveToCurrencyTab() {
		onSupPaymentTabPage.switch_to_tab("Currency");
	}

	@Step
	public void typeCurrency(String currency) {
		onSupPaymentTabPage.typeCurrency(currency);
	}

	@Step
	public void moveToPaymentTab() {
		onSupPaymentTabPage.switch_to_tab("Payment");
	}

	@Step
	public void selectOperationalCurrency(String operationalCurrency) {
		onSupPaymentTabPage.selectOperationalCurrency(operationalCurrency);
	}

	@Step
	public void typeOverallCreditLimit(String overallCreditLimit) {
		onSupPaymentTabPage.typeOverallCreditLimit(overallCreditLimit);
	}

	@Step
	public void selectDefault(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onSupPaymentTabPage.selectDefault(tableName, description);
	}

	@Step
	public void clickDescription(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onSupPaymentTabPage.clickDescription(tableName, description);
	}

	@Step
	public void chooseIsActive(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onSupPaymentTabPage.chooseIsActive(tableName, description);
	}

	@Step
	public void updateSupplier(String supplier) {
		onSupPaymentTabPage.updateSupplier(supplier);
	}

	@Step
	public void searchParty(String supplier) {
		onSupPaymentTabPage.searchParty(supplier);
	}

	/**
	 * Region Address Tab
	 */

	@Step
	public void moveToAddressTab() {
		onSupPaymentTabPage.switch_to_tab("Address");
		onSupPaymentTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddAddressBtn() {
		onSupPaymentTabPage.clickOnAddAddressBtn();
	}

	@Step
	public void clickOnAddContactTypeBtn() {
		onSupPaymentTabPage.clickOnAddContactTypeBtn();
	}

	@Step
	public int countRowContactTypeTb() {
		return onSupPaymentTabPage.countRowContactTypeTb();
	}

	@Step
	public void typeAddressCode(String addressCode) {
		onSupPaymentTabPage.typeAddressCode(addressCode);
	}

	@Step
	public void typeAddressDescription(String addressDescription) {
		onSupPaymentTabPage.typeAddressDescription(addressDescription);
	}

	@Step
	public void typeAddress(String address) {
		onSupPaymentTabPage.typeAddress(address);
	}

	@Step
	public void typeCountryCode(String countryCode) {
		onSupPaymentTabPage.typeCountryCode(countryCode);
	}

	@Step
	public void typeStateProvince(String stateProvince) {
		onSupPaymentTabPage.typeStateProvince(stateProvince);
	}

	@Step
	public void typeCityTown(String cityTown) {
		onSupPaymentTabPage.typeCityTown(cityTown);
	}

	@Step
	public void typePostalCode(String postalCode) {
		onSupPaymentTabPage.typePostalCode(postalCode);
	}

	@Step
	public void chooseIncType(String incType) {
		onSupPaymentTabPage.chooseIncType(incType);
	}

	@Step
	public void chooseTypeDefault(String incType) {
		onSupPaymentTabPage.chooseTypeDefault(incType);
	}

	@Step
	public void chooseContactType(String contactType, int rowIndex) {
		onSupPaymentTabPage.chooseContactType(contactType, rowIndex);
	}

	@Step
	public void typeContactInformation(String contactInformation, int rowIndex) {
		onSupPaymentTabPage.typeContactInformation(contactInformation, rowIndex);
	}

	@Step
	public void chooseContactTypeDefault(int rowIndex) {
		onSupPaymentTabPage.chooseContactTypeDefault(rowIndex);
	}

	@Step
	public void chooseDel(int rowIndex) {
		onSupPaymentTabPage.chooseDel(rowIndex);
	}

	/**
	 * Region Contact Tab
	 */

	@Step
	public void moveToContactTab() {
		onSupPaymentTabPage.switch_to_tab("Contact");
		onSupPaymentTabPage.waitForAllJSCompletes();
	}

	@Step
	public int countRowContactContactTypeTb() {
		return onSupPaymentTabPage.countRowContactContactTypeTb();
	}

	@Step
	public void clickOnAddContact() {
		onSupPaymentTabPage.clickOnAddContact();
	}

	@Step
	public void typePartyContactCode(String partyContactCode) {
		onSupPaymentTabPage.typePartyContactCode(partyContactCode);
	}

	@Step
	public void chooseSalutation(String salutation) {
		onSupPaymentTabPage.chooseSalutation(salutation);
	}

	@Step
	public void typeFirstName(String firstName) {
		onSupPaymentTabPage.typeFirstName(firstName);
	}

	@Step
	public void typeMiddleName(String middleName) {
		onSupPaymentTabPage.typeMiddleName(middleName);
	}

	@Step
	public void typeLastName(String lastName) {
		onSupPaymentTabPage.typeLastName(lastName);
	}

	@Step
	public void typeName(String name) {
		onSupPaymentTabPage.typeName(name);
	}

	@Step
	public void chooseAddressCode(String addressCode) {
		onSupPaymentTabPage.chooseAddressCode(addressCode);
	}

	@Step
	public void typeDesignation(String designation) {
		onSupPaymentTabPage.typeDesignation(designation);
	}

	@Step
	public void typeDesignationGroup(String designationGroup) {
		onSupPaymentTabPage.typeDesignationGroup(designationGroup);
	}

	@Step
	public void typeDepartment(String department) {
		onSupPaymentTabPage.typeDepartment(department);
	}

	@Step
	public void chooseIncDefault(String incType) {
		onSupPaymentTabPage.chooseTypeDefault(incType);
	}

	@Step
	public void chooseContactTypeContactType(String contactTypeContactType, int rowIndex) {
		onSupPaymentTabPage.chooseContactTypeContactType(contactTypeContactType, rowIndex);
	}

	@Step
	public void typeContactTypeContactInformation(String contactTypeContactInformation, int rowIndex) {
		onSupPaymentTabPage.typeContactTypeContactInformation(contactTypeContactInformation, rowIndex);
	}

	@Step
	public void chooseContactTypeTypeDefault(int rowIndex) {
		onSupPaymentTabPage.chooseContactTypeTypeDefault(rowIndex);
	}

	@Step
	public void chooseContactTypeDel(int rowIndex) {
		onSupPaymentTabPage.chooseContactTypeDel(rowIndex);
	}

	/**
	 * Region Bank Detail Tab
	 */

	@Step
	public void moveToBankDetailTab() {
		onSupPaymentTabPage.switch_to_tab("Bank Detail");
		onSupPaymentTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddBankDetail() {
		onSupPaymentTabPage.clickOnAddBankDetail();
	}

	@Step
	public int countRowBankDetail() {
		return onSupPaymentTabPage.countRowBankDetal();
	}

	@Step
	public void typeBank(String bank, int rowIndex) {
		onSupPaymentTabPage.typeBank(bank, rowIndex);
	}

	@Step
	public void typeDescription(String description, int rowIndex) {
		onSupPaymentTabPage.typeDescription(description, rowIndex);
	}

	@Step
	public void typeAccountNo(String accountNo, int rowIndex) {
		onSupPaymentTabPage.typeAccountNo(accountNo, rowIndex);
	}

	@Step
	public void typeBankCurrency(String currency, int rowIndex) {
		onSupPaymentTabPage.typeBankCurrency(currency, rowIndex);
	}

	@Step
	public void chooseBankDefault(int rowIndex) {
		onSupPaymentTabPage.chooseBankDefault(rowIndex);
	}

	@Step
	public void chooseBankDel(int rowIndex) {
		onSupPaymentTabPage.chooseBankDel(rowIndex);
	}

	/**
	 * Region SBU Tab
	 **/

	@Step
	public void moveToSBUTab() {
		onSupPaymentTabPage.switch_to_tab("SBU");
		onSupPaymentTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickAddSBU() {
		onSupPaymentTabPage.clickOnAddSBU();
	}

	@Step
	public int countRowSBU() {
		return onSupPaymentTabPage.countRowSBU();
	}

	@Step
	public void typeSBU(String sBU, int rowIndex) {
		onSupPaymentTabPage.typeSBU(sBU, rowIndex);
	}

	@Step
	public void typeSBUDescription(String description, int rowIndex) {
		onSupPaymentTabPage.typeSBUDescription(description, rowIndex);
	}

	@Step
	public void typeDel(int rowIndex) {
		onSupPaymentTabPage.typeDel(rowIndex);
	}

	/**
	 * Region Local Info Tab
	 */

	@Step
	public void clickOnAddCountry() {
		onSupPaymentTabPage.clickOnAddCountry();
	}

	@Step
	public void clickToOpenPort(int rowIndex) {
		onSupPaymentTabPage.clickToOpenPort(rowIndex);
	}

	@Step
	public int getRowIndexCountry(String country) {
		return onSupPaymentTabPage.getRowIndexCountry(country);
	}

	@Step
	public int countRowCountry() {
		return onSupPaymentTabPage.countRowCountry();
	}

	@Step
	public int getRowIndexShipTerm(String shippingTerm) {
		return onSupPaymentTabPage.getRowIndexShipTerm(shippingTerm);
	}

	@Step
	public int getRowIndexPort(String port) {
		return onSupPaymentTabPage.getRowIndexPort(port);
	}

	@Step
	public boolean findPort(String port) {
		return onSupPaymentTabPage.findPort(port);
	}

	@Step
	public void moveToLocalInfoTab() {
		onSupPaymentTabPage.switch_to_tab("Local Info");
	}

	@Step
	public void moveToShipmentInfoTab() {
		onSupPaymentTabPage.switch_to_tab("Shipment Info");
	}

	@Step
	public void moveToDefaultSettingTab() {
		onSupPaymentTabPage.switch_to_tab("Default Setting for HSBC iFile");
	}

	@Step
	public void moveToShipmentModeTermTab() {
		onSupPaymentTabPage.switch_to_tab("Shipment Mode / Term");
	}

	@Step
	public void moveToCountryPortTab() {
		onSupPaymentTabPage.switch_to_tab("Country / Port");
	}

	@Step
	public void chooseInc(int rowIndex) {
		onSupPaymentTabPage.chooseInc(rowIndex);
	}

	@Step
	public void chooseAir(int rowIndex) {
		onSupPaymentTabPage.chooseAir(rowIndex);
	}

	@Step
	public void chooseSea(int rowIndex) {
		onSupPaymentTabPage.chooseSea(rowIndex);
	}

	@Step
	public void chooseRoad(int rowIndex) {
		onSupPaymentTabPage.chooseRoad(rowIndex);
	}

	@Step
	public void chooseRail(int rowIndex) {
		onSupPaymentTabPage.chooseRail(rowIndex);
	}

	@Step
	public void chooseShipmentDefault(int rowIndex) {
		onSupPaymentTabPage.chooseShipmentDefault(rowIndex);
	}

	@Step
	public void typeCountry(String country, int rowIndex) {
		onSupPaymentTabPage.typeCountry(country, rowIndex);
	}

	@Step
	public void chooseLoading(int rowIndex) {
		onSupPaymentTabPage.chooseLoading(rowIndex);
	}

	@Step
	public void chooseDischarge(int rowIndex) {
		onSupPaymentTabPage.chooseDischarge(rowIndex);
	}

	@Step
	public void chooseFinalDest(int rowIndex) {
		onSupPaymentTabPage.chooseFinalDest(rowIndex);
	}

	@Step
	public void chooseDelCountry(int rowIndex) {
		onSupPaymentTabPage.chooseDelCountry(rowIndex);
	}

	@Step
	public void choosePortLoading(int rowIndex) {
		onSupPaymentTabPage.choosePortLoading(rowIndex);
	}

	@Step
	public void choosePortDischange(int rowIndex) {
		onSupPaymentTabPage.choosePortDischange(rowIndex);
	}

	@Step
	public void choosePortFinalDest(int rowIndex) {
		onSupPaymentTabPage.choosePortFinalDest(rowIndex);
	}

	/**
	 * REGION DEFAULT TAB
	 */

	@Step
	public void chooseDeductChargeFlag(String deductChargeFlag) {
		onSupPaymentTabPage.chooseDeductChargeFlag(deductChargeFlag);
	}

	@Step
	public void chooseDeliveryToFornonCC(String deliveryToFornonCC) {
		onSupPaymentTabPage.chooseDeliveryToFornonCC(deliveryToFornonCC);
	}

	@Step
	public void chooseDeliveryMode(String deliveryMode) {
		onSupPaymentTabPage.chooseDeliveryMode(deliveryMode);
	}

}
