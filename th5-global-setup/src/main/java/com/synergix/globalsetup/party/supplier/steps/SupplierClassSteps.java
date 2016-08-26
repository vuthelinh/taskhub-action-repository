package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupplierClassPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupplierClassSteps extends ScenarioSteps {

	SupplierClassPage onSupplierClassPage;

	public void switchToIFrame() {
		onSupplierClassPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onSupplierClassPage.switchOutDefaultIFrame();
	}

	@Step
	public void typeSupplierClassCode(String supplierClassCode) {
		onSupplierClassPage.typeSupplierClassCode(supplierClassCode);
	}

	@Step
	public void typeDescription(String description) {
		onSupplierClassPage.typeDescription(description);
	}

	@Step
	public void typePayableGLAN(String payableGLAN) {
		onSupplierClassPage.typePayableGLAN(payableGLAN);
	}

	@Step
	public void typeRealizedGLAN(String realizedGLAN) {
		onSupplierClassPage.typeRealizedGLAN(realizedGLAN);
	}

	@Step
	public void typeUnrealizedGLAN(String unrealizedGLAN) {
		onSupplierClassPage.typeUnrealizedGLAN(unrealizedGLAN);
	}

	@Step
	public void typeGoodsReceiptClearingGLAN(String goodsReceiptClearingGLAN) {
		onSupplierClassPage.typeGoodsReceiptClearingGLAN(goodsReceiptClearingGLAN);
	}

	@Step
	public void typePurchaseVarianceGLAN(String purchaseVarianceGLAN) {
		onSupplierClassPage.typePurchaseVarianceGLAN(purchaseVarianceGLAN);
	}

	@Step
	public void typeAdditionalCost(String additionalCost) {
		onSupplierClassPage.typeAdditionalCost(additionalCost);
	}

	@Step
	public void typeAdditionalCostVariance(String additionalCostVariance) {
		onSupplierClassPage.typeAdditionalCostVariance(additionalCostVariance);
	}

	@Step
	public void typeAdditionalCostExchange(String additionalCostExchange) {
		onSupplierClassPage.typeAdditionalCostExchange(additionalCostExchange);
	}

	@Step
	public void typePurchaseReturnVariance(String purchaseReturnVariance) {
		onSupplierClassPage.typePurchaseReturnVariance(purchaseReturnVariance);
	}

	@Step
	public void typePurchaseVarianceExchDiff(String purchaseVarianceExchDiff) {
		onSupplierClassPage.typePurchaseVarianceExchDiff(purchaseVarianceExchDiff);
	}

	@Step
	public void typeSalesTaxExchDifference(String salesTaxExchDifference) {
		onSupplierClassPage.typeSalesTaxExchDifference(salesTaxExchDifference);
	}

	@Step
	public void typeRetentionGLAN(String retentionGLAN) {
		onSupplierClassPage.typeRetentionGLAN(retentionGLAN);
	}

	@Step
	public void typeOtherIncomeGLAN(String otherIncomeGLAN) {
		onSupplierClassPage.typeOtherIncomeGLAN(otherIncomeGLAN);
	}

	@Step
	public void addSupplierClass() {
		onSupplierClassPage.clickOnNewButton();
	}

	@Step
	public void moveToCompanyTab() {
		onSupplierClassPage.switch_to_tab("Company");
	}

	@Step
	public void checkAllCompany() {
		onSupplierClassPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onSupplierClassPage.chooseCompany(company);
	}

	@Step
	public void clickOnUpdateButton() {
		onSupplierClassPage.clickOnUpdateButton();
	}

	/**
	 * Created by Steve on 12/08/2016
	 * 
	 * @param supplierClassCode
	 * @return
	 */
	@Step
	public boolean searchSupplierClassCode(String supplierClassCode) {
		onSupplierClassPage.click_search_button_on_functional_panel();
		onSupplierClassPage.waitForAllJSCompletes();
		return onSupplierClassPage.search(onSupplierClassPage.SUPPLIER_CLASS_CODE,
				supplierClassCode);
	}

	@Step
	public void chooseDelSupClass(String supplierClassCode) {
		onSupplierClassPage.deleteValueBySearchBtn("Search", "Supplier Class Code", supplierClassCode);
	}

}
