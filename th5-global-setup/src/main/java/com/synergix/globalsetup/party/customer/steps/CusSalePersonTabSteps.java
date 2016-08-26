package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CusSalePersonTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusSalePersonTabSteps extends ScenarioSteps {

	CusSalePersonTabPage onCusSalePersonTabPage;

	/**
	 * REGION SALES PERSON TAB
	 */

	@Step
	public void moveToSalesPersonTab() {
		onCusSalePersonTabPage.switch_to_tab("Sales Person");
	}

	@Step
	public void clickOnAddSalesPeron() {
		onCusSalePersonTabPage.clickOnAddSalesPeron();
	}

	@Step
	public int countRowSalesPerson() {
		return onCusSalePersonTabPage.countRowSalesPerson();
	}

	@Step
	public int getRowIndexSalesPerson(String salesPerson) {
		return onCusSalePersonTabPage.getRowIndexSalesPerson(salesPerson);
	}

	@Step
	public void typeSalesPerson(String salesPerson, int rowIndex) {
		onCusSalePersonTabPage.typeSalesPerson(salesPerson, rowIndex);
	}

	@Step
	public void typeName(String name, int rowIndex) {
		onCusSalePersonTabPage.typeName(name, rowIndex);
	}

	@Step
	public void chooseSalesPersonDefault(int rowIndex) {
		onCusSalePersonTabPage.chooseSalesPersonDefault(rowIndex);
	}

	@Step
	public void chooseDSales(int rowIndex) {
		onCusSalePersonTabPage.chooseDSales(rowIndex);
	}

	@Step
	public void chooseSalesPersonDel(int rowIndex) {
		onCusSalePersonTabPage.chooseSalesPersonDel(rowIndex);
	}

	public boolean isSalePersonExit(String salesPerson) {
		return onCusSalePersonTabPage.isSalePersonExit(salesPerson);
	}
}
