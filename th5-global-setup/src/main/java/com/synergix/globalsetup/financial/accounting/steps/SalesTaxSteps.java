package com.synergix.globalsetup.financial.accounting.steps;

import java.util.concurrent.TimeUnit;

import com.synergix.globalsetup.financial.accounting.pages.SalesTaxPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SalesTaxSteps extends ScenarioSteps {

	private static final String SEARCH = "Search";
	SalesTaxPage onGlobalSalesTaxPage;

	public void switchToIFrame() {
		onGlobalSalesTaxPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onGlobalSalesTaxPage.switchOutDefaultIFrame();
	}

	@Step
	public void addNewSalesTax() {
		onGlobalSalesTaxPage.clickOnNewButton();
	}

	@Step
	public void clickOnUpdateButton() {
		onGlobalSalesTaxPage.clickOnUpdateButton();
	}
	
	@Step
	/**
	 * Created by Steve
	 * @param salesTaxCode
	 * @return
	 */
	public boolean searchSalesTaxCode(String salesTaxCode) {
		onGlobalSalesTaxPage.clickBtn(SEARCH);
		onGlobalSalesTaxPage.waitForAllJSCompletes();
		return onGlobalSalesTaxPage.search("Sales Tax Code", salesTaxCode);
	}

	@Step
	public void typeSalesTaxCode(String salesTaxCode) {
		onGlobalSalesTaxPage.typeSalesTaxCode(salesTaxCode);
	}

	@Step
	public void typeDescription(String description) {
		onGlobalSalesTaxPage.typeDescription(description);
	}

	@Step
	public void typeSalesTax(String salesTax) {
		onGlobalSalesTaxPage.typeSalesTax(salesTax);
	}

	@Step
	public void typeInputTaxGLAN(String inputTaxGLAN) {
		onGlobalSalesTaxPage.typeInputTaxGLAN(inputTaxGLAN);
	}

	@Step
	public void typeOutputTaxGLAN(String outputTaxGLAN) {
		onGlobalSalesTaxPage.typeOutputTaxGLAN(outputTaxGLAN);
	}

	@Step
	public void selectIRASTaxTypeofPurchase(String iRASTaxTypeofPurchase) {
		onGlobalSalesTaxPage.selectIRASTaxTypeofPurchase(iRASTaxTypeofPurchase);
	}

	@Step
	public void selectIRASTaxTypeofSupply(String iRASTaxTypeofSupply) {
		onGlobalSalesTaxPage.selectIRASTaxTypeofSupply(iRASTaxTypeofSupply);
	}

	@Step
	public void moveToCompanyTab() {
		onGlobalSalesTaxPage.switch_to_tab("Company");
	}

	@Step
	public void checkAllCompany() {
		onGlobalSalesTaxPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onGlobalSalesTaxPage.chooseCompany(company);
	}

	@Step
	public void chooseDelSalesTax(String salesTaxCode) {
		onGlobalSalesTaxPage.deleteValueBySearchBtn(SEARCH, "Sales Tax Code", salesTaxCode);
	}

	public String autoGenCode(String prefix) {
		return onGlobalSalesTaxPage.autoGenCode(prefix, 10);
	}
}
