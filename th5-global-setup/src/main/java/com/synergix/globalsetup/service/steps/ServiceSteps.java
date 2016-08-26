package com.synergix.globalsetup.service.steps;

import com.synergix.globalsetup.service.page.ServicePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ServiceSteps extends ScenarioSteps {

    ServicePage onServicePage;

    public void switchToIFrame() {
        onServicePage.switchToIFrame();
    }

    public void switchOutDefaultIFrame() {
        onServicePage.switchOutDefaultIFrame();
    }

    @Step
    public void clickOnNewBtn() {
        onServicePage.clickOnNewButton();
    }

    @Step
    public void clickOnUpdateBtn() {
        onServicePage.clickOnUpdateButton();
    }

    @Step
    public void typeServiceCode(String serviceCode) {
        onServicePage.typeServiceCode(serviceCode);
    }

    @Step
    public void typeServiceDescription(String serviceDescription) {
        onServicePage.typeServiceDescription(serviceDescription);
    }

    @Step
    public void typeServiceCategory(String serviceCategory) {
        onServicePage.typeServiceCategory(serviceCategory);
    }

    @Step
    public void typeUOM(String uOM) {
        onServicePage.typeUOM(uOM);
    }

    @Step
    public void chooseTrackQtyinProject(String trackQtyinProject) {
        onServicePage.chooseTrackQtyinProject(trackQtyinProject);
    }

    @Step
    public void typeBudgetCategoryCode(String budgetCategoryCode) {
        onServicePage.typeBudgetCategoryCode(budgetCategoryCode);
    }

    @Step
    public void chooseServiceType(String serviceType) {
        onServicePage.chooseServiceType(serviceType);
    }

    @Step
    public void chooseRevenueStatus(String revenueStatus) {
        onServicePage.chooseRevenueStatus(revenueStatus);
    }

    @Step
    public void typeRevenueGLAN(String revenueGLAN) {
        onServicePage.typeRevenueGLAN(revenueGLAN);
    }

    @Step
    public void typeUnearnedRevenueGLAN(String unearnedRevenueGLAN) {
        onServicePage.typeUnearnedRevenueGLAN(unearnedRevenueGLAN);
    }

    @Step
    public void typeSalesAccrualGLAN(String salesAccrualGLAN) {
        onServicePage.typeSalesAccrualGLAN(salesAccrualGLAN);
    }

    @Step
    public void typeReportGrouping(String reportGrouping) {
        onServicePage.typeReportGrouping(reportGrouping);
    }

    @Step
    public void chooseDefaultSalesTax(String defaultSalesTax) {
        onServicePage.chooseDefaultSalesTax(defaultSalesTax);
    }

    @Step
    public void typeIntercompanySalesTax(String intercompanySalesTax) {
        onServicePage.typeIntercompanySalesTax(intercompanySalesTax);
    }

    @Step
    public void chooseExpenseStatus(String expenseStatus) {
        onServicePage.chooseExpenseStatus(expenseStatus);
    }

    @Step
    public void typeExpenseGLAN(String expenseGLAN) {
        onServicePage.typeExpenseGLAN(expenseGLAN);
    }

    @Step
    public void typeAccruedCostGLAN(String accruedCostGLAN) {
        onServicePage.typeAccruedCostGLAN(accruedCostGLAN);
    }

    @Step
    public void typeOverheadGLAN(String overheadGLAN) {
        onServicePage.typeOverheadGLAN(overheadGLAN);
    }

    @Step
    public void chooseAllCompany() {
        onServicePage.chooseAllCompany();
    }

    @Step
    public void chooseCompany(String company) {
        onServicePage.chooseCompany(company);
    }

    // Move Tab
    @Step
    public void moveToServiceRelationTab() {
        onServicePage.switch_to_tab("Service Relation");
    }

    @Step
    public void typeRelation(String partyTypeGroup, String partyType) {
        onServicePage.typeRelation(partyTypeGroup, partyType);
    }

    @Step
    public void typePartyTypeGroup(String partyTypeGroup) {

    }

    @Step
    public void typePartyType(String partyType) {

    }

    @Step
    public void moveToSupplierTab() {
        onServicePage.switch_to_tab("Supplier");
    }

    @Step
    public void moveToPayrollTab() {
        onServicePage.switch_to_tab("Payroll");
    }

    @Step
    public void moveToMedicalSpecificTab() {
        onServicePage.switch_to_tab("Medical Specific");
    }

    @Step
    public void moveToManufacturingTab() {
        onServicePage.switch_to_tab("Manufacturing");
    }

    @Step
    public void moveToCompanyTab() {
        onServicePage.switch_to_tab("Company");
    }

    @Step
    public void moveToLocalInfoTab() {
        onServicePage.switch_to_tab("Local Info");
    }

    @Step
    public void moveToHeaderTab() {
        onServicePage.switch_to_tab("Header");
    }

    @Step
    public void chooseRevenue() {
        onServicePage.chooseRevenue();
    }

    @Step
    public void chooseExpense() {
        onServicePage.chooseExpense();
    }

    @Step
    public void chooseDelService(String serviceCode) {
        onServicePage.deleteValueBySearchBtn("Search", "Service Code", serviceCode);
    }

    public boolean searchServiceCode(String serviceCode) {
        onServicePage.clickBtn("Search");
        onServicePage.waitForAllJSCompletes();
        return onServicePage.getResultSearch("Service Code", serviceCode);

    }

    @Step
    public void create_new_service(String serviceCode, String description, String expenseGLAN) {
        switchToIFrame();

        clickOnNewBtn();
        onServicePage.waitForAllJSCompletes();

        typeServiceCode(serviceCode);
        onServicePage.waitForAllJSCompletes();

        typeServiceDescription(description);

        typeExpenseGLAN(expenseGLAN);
        onServicePage.waitForAllJSCompletes();

        clickOnUpdateBtn();

        switchOutDefaultIFrame();
    }
}
