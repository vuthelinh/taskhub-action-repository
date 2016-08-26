package com.synergix.mtsetup.financial.currency.steps;

import com.synergix.mtsetup.financial.currency.pages.ExchangeRatePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ExchangeRateSteps extends ScenarioSteps {
	ExchangeRatePage onExchangeRatePage;

	public void switchToIFrame() {
		onExchangeRatePage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onExchangeRatePage.switchOutDefaultIFrame();
	}

	@Step
	public void typeCurrency(String currency) {
		onExchangeRatePage.typeCurrency(currency);
	}

	@Step
	public void typeEffectiveDateFrom(String effectiveDateFrom, int rowIndex) {
		onExchangeRatePage.typeEffectiveDateFrom(effectiveDateFrom, rowIndex);
	}

	@Step
	public void typeEffectiveDateTo(String effectiveDateTo, int rowIndex) {
		onExchangeRatePage.typeEffectiveDateTo(effectiveDateTo, rowIndex);
	}

	@Step
	public void typeUpwardsVarianceAllowed(String upwardsVarianceAllowed, int rowIndex) {
		onExchangeRatePage.typeUpwardsVarianceAllowed(upwardsVarianceAllowed, rowIndex);
	}

	@Step
	public void typeDownwardsVarianceAllowed(String downwardsVarianceAllowed, int rowIndex) {
		onExchangeRatePage.typeDownwardsVarianceAllowed(downwardsVarianceAllowed, rowIndex);
	}

	@Step
	public void typeBankSellRate(String bankSellRate, int rowIndex) {
		onExchangeRatePage.typeBankSellRate(bankSellRate, rowIndex);
	}

	@Step
	public void typeBankBuyRate(String bankBuyRate, int rowIndex) {
		onExchangeRatePage.typeBankBuyRate(bankBuyRate, rowIndex);
	}

	@Step
	public void typeRevaluationRate(String revaluationRate, int rowIndex) {
		onExchangeRatePage.typeRevaluationRate(revaluationRate, rowIndex);
	}

	@Step
	public void clickAddBtn() {
		onExchangeRatePage.clickBtn("Add");
		onExchangeRatePage.waitForAllJSCompletes();
	}

	@Step
	public void deleteOldRow() {
		onExchangeRatePage.deleteOldRow();
	}

	@Step
	public boolean isExitData() {
		return onExchangeRatePage.isExitData();
	}

}
