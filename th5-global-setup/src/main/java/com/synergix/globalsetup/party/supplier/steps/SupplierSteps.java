package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupplierPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupplierSteps extends ScenarioSteps {

    SupplierPage onSupplierPage;

    public void switchToIFrame() {
        onSupplierPage.switchToIFrame();
    }

    public void switchOutDefaultIFrame() {
        onSupplierPage.switchOutDefaultIFrame();
    }

    // ================= MOVE TAB
    @Step
    public void moveToCompanyTab() {
        onSupplierPage.switch_to_tab("Company");
    }

    @Step
    public void moveToCurrencyTab() {
        onSupplierPage.switch_to_tab("Currency");
    }

    @Step
    public void moveToPaymentTab() {
        onSupplierPage.switch_to_tab("Payment");
    }

    @Step
    public void moveToAddressTab() {
        onSupplierPage.switch_to_tab("Address");
        onSupplierPage.waitForAllJSCompletes();
    }

    @Step
    public void moveToContactTab() {
        onSupplierPage.switch_to_tab("Contact");
        onSupplierPage.waitForAllJSCompletes();
    }

    @Step
    public void moveToBankDetailTab() {
        onSupplierPage.switch_to_tab("Bank Detail");
        onSupplierPage.waitForAllJSCompletes();
    }

    @Step
    public void moveToSBUTab() {
        onSupplierPage.switch_to_tab("SBU");
        onSupplierPage.waitForAllJSCompletes();
    }

    @Step
    public void moveToLocalInfoTab() {
        onSupplierPage.switch_to_tab("Local Info");
    }

    @Step
    public void moveToShipmentInfoTab() {
        onSupplierPage.switch_to_tab("Shipment Info");
    }

    @Step
    public void moveToDefaultSettingTab() {
        onSupplierPage.switch_to_tab("Default Setting for HSBC iFile");
    }

    @Step
    public void moveToShipmentModeTermTab() {
        onSupplierPage.switch_to_tab("Shipment Mode / Term");
    }

    @Step
    public void moveToCountryPortTab() {
        onSupplierPage.switch_to_tab("Country / Port");
    }

    // ===========================================
    // SUPPLIER
    @Step
    public void clickOnUpdateButton() {
        onSupplierPage.onClickUpdateButton();
    }

    @Step
    public void addSupplier() {
        onSupplierPage.onClickNewButton();
    }

    @Step
    public void typeSupplier(String supplier) {
        onSupplierPage.typeSupplier(supplier);
    }

    @Step
    public void typeSupplierName(String supplierName) {
        onSupplierPage.typeSupplierName(supplierName);
    }

    @Step
    public void typeSupplierClassCode(String supplierClassCode) {
        onSupplierPage.typeSupplierClassCode(supplierClassCode);
    }

    @Step
    public void typePartyGroupCode(String partyGroupCode) {
        onSupplierPage.typePartyGroupCode(partyGroupCode);
    }

    @Step
    public void typeMainHomePage(String mainHomePage) {
        onSupplierPage.typeMainHomePage(mainHomePage);
    }

    @Step
    public void typeGSTRegistrationNo(String gSTRegistrationNo) {
        onSupplierPage.typeGSTRegistrationNo(gSTRegistrationNo);
    }

    @Step
    public void typeCountryOfIncorporation(String countryOfIncorporation) {
        onSupplierPage.typeCountryOfIncorporation(countryOfIncorporation);
    }

    @Step
    public void typeSubconWIPGlan(String subconWIPGlan) {
        onSupplierPage.typeSubconWIPGlan(subconWIPGlan);
    }

    @Step
    public void typeSalesTaxCode(String salesTaxCode) {
        onSupplierPage.typeSalesTaxCode(salesTaxCode);
    }

    @Step
    public void typeDefaultTenorTermCode(String defaultTenorTermCode) {
        onSupplierPage.typeDefaultTenorTermCode(defaultTenorTermCode);
    }

    @Step
    public void typeDefaultTenor(String defaultTenor) {
        onSupplierPage.typeDefaultTenor(defaultTenor);
    }

    @Step
    public void chooseIPTRelated(String iPTRelated) {
        onSupplierPage.chooseIPTRelated(iPTRelated);
    }

    @Step
    public void chooseStatus(String status) {
        onSupplierPage.chooseStatus(status);
    }

    @Step
    public void typeUniqueEntityNo(String uniqueEntityNo) {
        onSupplierPage.typeUniqueEntityNo(uniqueEntityNo);
    }

    @Step
    public void typeMainSupplierCode(String mainSupplierCode) {
        onSupplierPage.typeMainSupplierCode(mainSupplierCode);
    }

    @Step
    public void typeSupplierShortName(String supplierShortName) {
        onSupplierPage.typeSupplierShortName(supplierShortName);
    }

    @Step
    public void typeSupplierCategoryCode(String supplierCategoryCode) {
        onSupplierPage.typeSupplierCategoryCode(supplierCategoryCode);
    }

    @Step
    public void typeSupplierRankCode(String supplierRankCode) {
        onSupplierPage.typeSupplierRankCode(supplierRankCode);
    }

    @Step
    public void typePurchasingZone(String purchasingZone) {
        onSupplierPage.typePurchasingZone(purchasingZone);
    }

    @Step
    public void typePartyContraGLAN(String partyContraGLAN) {
        onSupplierPage.typePartyContraGLAN(partyContraGLAN);
    }

    @Step
    public void typeContraRealizedExchGLAN(String contraRealizedExchGLAN) {
        onSupplierPage.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
    }

    @Step
    public void typeDefaultDiscountPercent(String defaultDiscountPercent) {
        onSupplierPage.typeDefaultDiscountPercent(defaultDiscountPercent);
    }

    @Step
    public void chooseCombineShmtoInvoices(String combineShmtoInvoices) {
        onSupplierPage.chooseCombineShmtoInvoices(combineShmtoInvoices);
    }

    @Step
    public void typeRemarks(String remarks) {
        onSupplierPage.typeRemarks(remarks);
    }

    public String autoGenCode(String prefixAutoGenCode) {
        return onSupplierPage.autoGenCode(prefixAutoGenCode);
    }

    public String verifyMessagePopup() {
        return onSupplierPage.verifyMessagePopup();
    }

    @Step
    public boolean searchParty(String supplier) {
        return onSupplierPage.searchParty(supplier);
    }

    @Step
    public boolean searchSupplier(String supplier) {
        return onSupplierPage.searchSupplier(supplier);
    }

    /**
     * author: Ian
     */
    public void create_new_supplier(String supplierCode, String supplierName, String supplierClassCode, String currency) {

        onSupplierPage.click_add_new_button_on_functional_panel();
        onSupplierPage.waitForAllJSCompletes();

        typeSupplier(supplierCode);
        onSupplierPage.waitForAllJSCompletes();

        typeSupplierName(supplierName);
        onSupplierPage.waitForAllJSCompletes();

        typeSupplierClassCode(supplierClassCode);
        onSupplierPage.waitForAllJSCompletes();

        moveToCurrencyTab();
        onSupplierPage.clickOnAddCurrencyBtn();
        onSupplierPage.waitForAllJSCompletes();

        onSupplierPage.typeCurrency(currency);

        clickOnUpdateButton();
        onSupplierPage.waitForAllJSCompletes();
    }

    public void add_curency(String currency) {
        onSupplierPage.clickOnAddCurrencyBtn();
        onSupplierPage.waitForAllJSCompletes();

        onSupplierPage.typeCurrency(currency);
    }
}
