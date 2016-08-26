package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CustomerPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CustomerSteps extends ScenarioSteps {

	CustomerPage onCustomerPage;

	public void switchToIFrame() {
		onCustomerPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onCustomerPage.switchOutDefaultIFrame();
	}

	@Step
	public void moveToCurrencyTab() {
		onCustomerPage.switch_to_tab("Currency");
	}

	@Step
	public void moveToPaymentTab() {
		onCustomerPage.switch_to_tab("Payment");
	}

	@Step
	public void moveToAddressTab() {
		onCustomerPage.switch_to_tab("Address");
	}

	@Step
	public void moveToContactTab() {
		onCustomerPage.switch_to_tab("Contact");
		onCustomerPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToBankDetailTab() {
		onCustomerPage.switch_to_tab("Bank Detail");
	}

	@Step
	public void moveToSBUTab() {
		onCustomerPage.switch_to_tab("SBU");
		onCustomerPage.waitForAllJSCompletes();
	}

	@Step
	public void moveToSalesPersonTab() {
		onCustomerPage.switch_to_tab("Sales Person");
	}

	@Step
	public void moveToLocalInfoTab() {
		onCustomerPage.switch_to_tab("Local Info");
	}

	@Step
	public void moveToPricingTab() {
		onCustomerPage.switch_to_tab("Pricing");
	}

	@Step
	public void moveToShipmentInfo() {
		onCustomerPage.switch_to_tab("Shipment Info");
	}

	@Step
	public void moveToCreditLimitTab() {
		onCustomerPage.switch_to_tab("Credit Limit/Term");
	}

	@Step
	public void moveToShipmentTermTab() {
		onCustomerPage.switch_to_tab("Shipment Mode / Term");
	}

	@Step
	public void moveToShipmentPort() {
		onCustomerPage.switch_to_tab("Country / Port");
	}

	@Step
	public void moveToCustomerInventory() {
		onCustomerPage.switch_to_tab("Customer Inventory Brand Discount");
	}

	public String verifyMessagePopup() {
		return onCustomerPage.verifyMessagePopup();
	}

	// CUSTOMER

	@Step
	public void clickOnUpdateButton() {
		onCustomerPage.onClickUpdateButton();
	}

	@Step
	public void clickOnNewBtn() {
		onCustomerPage.clickBtn("New");
		onCustomerPage.waitForAllJSCompletes();
	}

	@Step
	public void typeCustomerCode(String customerCode) {
		onCustomerPage.typeCustomerCode(customerCode);
	}

	@Step
	public void typeUniqueEntityNo(String uniqueEntityNo) {
		onCustomerPage.typeUniqueEntityNo(uniqueEntityNo);
	}

	@Step
	public void typeCustomerName(String customerName) {
		onCustomerPage.typeCustomerName(customerName);
	}

	@Step
	public void typeCustomerClassCode(String customerClassCode) {
		onCustomerPage.typeCustomerClassCode(customerClassCode);
	}

	@Step
	public void typePartyGroupCode(String partyGroupCode) {
		onCustomerPage.typePartyGroupCode(partyGroupCode);
	}

	@Step
	public void typeIndustryCode(String industryCode) {
		onCustomerPage.typeIndustryCode(industryCode);
	}

	@Step
	public void typeAcquiredBy(String acquiredBy) {
		onCustomerPage.typeAcquiredBy(acquiredBy);
	}

	@Step
	public void typeCountryOfIncorporation(String countryOfIncorporation) {
		onCustomerPage.typeCountryOfIncorporation(countryOfIncorporation);
	}

	@Step
	public void typeSalesTaxCode(String salesTaxCode) {
		onCustomerPage.typeSalesTaxCode(salesTaxCode);
	}

	@Step
	public void typeContraRealizedExchGLAN(String contraRealizedExchGLAN) {
		onCustomerPage.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
	}

	@Step
	public void selectStatementDeliveryOption(String statementDeliveryOption) {
		onCustomerPage.selectStatementDeliveryOption(statementDeliveryOption);
	}

	@Step
	public void typeDefaultTenor(String defaultTenor) {
		onCustomerPage.typeDefaultTenor(defaultTenor);
	}

	@Step
	public void typeDiscount(String discount) {
		onCustomerPage.typeDiscount(discount);
	}

	@Step
	public void selectDueARInvoiceCorrespondenceLanguage(String dueARInvoiceCorrespondenceLanguage) {
		onCustomerPage.selectDueARInvoiceCorrespondenceLanguage(dueARInvoiceCorrespondenceLanguage);
	}

	@Step
	public void typeCustomerRemarks(String customerRemarks) {
		onCustomerPage.typeCustomerRemarks(customerRemarks);
	}

	@Step
	public void typeMainCustomerCode(String mainCustomerCode) {
		onCustomerPage.typeMainCustomerCode(mainCustomerCode);
	}

	@Step
	public void typeCustomerShortName(String customerShortName) {
		onCustomerPage.typeCustomerShortName(customerShortName);
	}

	@Step
	public void typeCustomerCategoryCode(String customerCategoryCode) {
		onCustomerPage.typeCustomerCategoryCode(customerCategoryCode);
	}

	@Step
	public void typeCustomerGroupCode(String customerGroupCode) {
		onCustomerPage.typeCustomerGroupCode(customerGroupCode);
	}

	@Step
	public void selectCustomerType(String customerType) {
		onCustomerPage.selectCustomerType(customerType);
	}

	@Step
	public void typeMainHomePage(String mainHomePage) {
		onCustomerPage.typeMainHomePage(mainHomePage);
	}

	@Step
	public void typeGSTRegistrationNo(String gSTRegistrationNo) {
		onCustomerPage.typeGSTRegistrationNo(gSTRegistrationNo);
	}

	@Step
	public void typePartyContraGLAN(String partyContraGLAN) {
		onCustomerPage.typePartyContraGLAN(partyContraGLAN);
	}

	@Step
	public void typeDefaultValidity(String defaultValidity) {
		onCustomerPage.typeDefaultValidity(defaultValidity);
	}

	@Step
	public void typeDefaultTenorTermCode(String defaultTenorTermCode) {
		onCustomerPage.typeDefaultTenorTermCode(defaultTenorTermCode);
	}

	@Step
	public void typePriceMarkupPercent(String priceMarkupPercent) {
		onCustomerPage.typePriceMarkupPercent(priceMarkupPercent);
	}

	@Step
	public void selectCombineShmtoInvoices(String combineShmtoInvoices) {
		onCustomerPage.selectCombineShmtoInvoices(combineShmtoInvoices);
	}

	@Step
	public void selectIPTRelated(String iPTRelated) {
		onCustomerPage.selectIPTRelated(iPTRelated);
	}

	@Step
	public void typeShippingMarksCode(String shippingMarksCode) {
		onCustomerPage.typeShippingMarksCode(shippingMarksCode);
	}

	@Step
	public void selectStatus(String status) {
		onCustomerPage.selectStatus(status);
	}

	@Step
	public void moveToCompanyTab() {
		onCustomerPage.switch_to_tab("Company");
	}

	@Step
	public void checkAllCompany() {
		onCustomerPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onCustomerPage.chooseCompany(company);
	}

	@Step
	public boolean searchCustomer(String customerCode) {
		return onCustomerPage.searchCustomer(customerCode);
	}

	@Step
	public String autoGenCode(String autoGenCode) {
		return onCustomerPage.autoGenCode(autoGenCode);
	}

}
