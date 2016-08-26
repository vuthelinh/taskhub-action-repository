package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupCurrencyTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupCurrencyTabSteps extends ScenarioSteps {

	SupCurrencyTabPage onSupCurrencyTabPage;

	@Step
	public void clickAddCurrency() {
		onSupCurrencyTabPage.clickOnAddCurrencyBtn();
	}

	@Step
	public void typeCurrency(String currency) {
		onSupCurrencyTabPage.typeCurrency(currency);
	}

	public void chooseDel(String currency) {
		onSupCurrencyTabPage.chooseDel(currency);
	}

	public boolean isCurrencyExit(String currency) {
		return onSupCurrencyTabPage.isCurrencyExit(currency);
	}
}
