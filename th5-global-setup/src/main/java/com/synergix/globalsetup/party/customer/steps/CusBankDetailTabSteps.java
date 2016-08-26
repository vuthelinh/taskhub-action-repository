package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CusBankDetailTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusBankDetailTabSteps extends ScenarioSteps {

	CusBankDetailTabPage onCusBankDetailTabPage;

	/**
	 * REGION BANK DETAIL TAB
	 */

	@Step
	public void typeBank(String bank, int rowIndex) {
		onCusBankDetailTabPage.typeBank(bank, rowIndex);
	}

	@Step
	public void typeDescription(String description, int rowIndex) {
		onCusBankDetailTabPage.typeDescription(description, rowIndex);
	}

	@Step
	public void typeAccountNo(String accountNo, int rowIndex) {
		onCusBankDetailTabPage.typeAccountNo(accountNo, rowIndex);
	}

	@Step
	public void typeCurrency(String currency, int rowIndex) {
		onCusBankDetailTabPage.typeCurrency(currency, rowIndex);
	}

	@Step
	public void chooseBankDefault(int rowIndex) {
		onCusBankDetailTabPage.chooseBankDefault(rowIndex);
	}

	@Step
	public void chooseBankDel(int rowIndex) {
		onCusBankDetailTabPage.chooseBankDel(rowIndex);
	}

	@Step
	public void clickOnAddBank() {
		onCusBankDetailTabPage.clickOnAddBank();
	}

	@Step
	public int getRowIndexBank(String bank) {
		return onCusBankDetailTabPage.getRowIndexBank(bank);
	}

	@Step
	public void moveToBankDetailTab() {
		onCusBankDetailTabPage.switch_to_tab("Bank Detail");
	}

	@Step
	public int countRowBank() {
		return onCusBankDetailTabPage.countRowBank();
	}

	public boolean isBankExit(String bank) {
		// TODO Auto-generated method stub
		return onCusBankDetailTabPage.isBankExit(bank);
	}
}
