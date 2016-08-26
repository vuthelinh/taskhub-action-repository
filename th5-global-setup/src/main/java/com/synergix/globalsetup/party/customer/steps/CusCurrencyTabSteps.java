package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CusCurrencyTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusCurrencyTabSteps extends ScenarioSteps {

	CusCurrencyTabPage onCusCurrencyTabPage;

	@Step
	public void clickAddCurrency() {
		onCusCurrencyTabPage.clickOnAddCurrencyBtn();
	}

	@Step
	public void typeCurrency(String currency) {
		onCusCurrencyTabPage.typeCurrency(currency);
	}

	@Step
	public void chooseDelCurrency(String currency) {
		onCusCurrencyTabPage.chooseDelCurrency(currency);
	}

	public boolean isCurrencyExit(String currency) {
		return onCusCurrencyTabPage.isCurrencyExit(currency);
	}

}
