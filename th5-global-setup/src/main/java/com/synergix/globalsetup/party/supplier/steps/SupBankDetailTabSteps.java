package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupBankDetailTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupBankDetailTabSteps extends ScenarioSteps {

	SupBankDetailTabPage onSupBankDetailTabPage;

	@Step
	public void moveToBankDetailTab() {
		onSupBankDetailTabPage.switch_to_tab("Bank Detail");
		onSupBankDetailTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddBankDetail() {
		onSupBankDetailTabPage.clickOnAddBankDetail();
	}

	@Step
	public int countRowBankDetail() {
		return onSupBankDetailTabPage.countRowBankDetal();
	}

	@Step
	public void typeBank(String bank, int rowIndex) {
		onSupBankDetailTabPage.typeBank(bank, rowIndex);
	}

	@Step
	public void typeDescription(String description, int rowIndex) {
		onSupBankDetailTabPage.typeDescription(description, rowIndex);
	}

	@Step
	public void typeAccountNo(String accountNo, int rowIndex) {
		onSupBankDetailTabPage.typeAccountNo(accountNo, rowIndex);
	}

	@Step
	public void typeBankCurrency(String currency, int rowIndex) {
		onSupBankDetailTabPage.typeBankCurrency(currency, rowIndex);
	}

	@Step
	public void chooseBankDefault(int rowIndex) {
		onSupBankDetailTabPage.chooseBankDefault(rowIndex);
	}

	@Step
	public void chooseBankDel(int rowIndex) {
		onSupBankDetailTabPage.chooseBankDel(rowIndex);
	}

	public boolean isBankExit(String bank) {
		return onSupBankDetailTabPage.isBankExit(bank);
	}

	public int getRowIndex(String bank) {
		return onSupBankDetailTabPage.getRowIndex(bank);
	}
}
