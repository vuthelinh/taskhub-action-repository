package com.synergix.processing.bankbook.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.bankbook.pages.BKRevaluationPage;

public class BKRevaluationSteps extends ScenarioSteps {
	BKRevaluationPage onBKRevaluationPage;

	public void switchOutDefaultIFrame() {
		onBKRevaluationPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onBKRevaluationPage.switchToIFrame();
	}

	@Step
	public void typeRevaluationVoucherDate(String revaluationVoucherDate) {
		onBKRevaluationPage.typeRevaluationVoucherDate(revaluationVoucherDate);
	}

	@Step
	public void typeCurrency(String currency) {
		onBKRevaluationPage.typeCurrency(currency);
	}

	@Step
	public void typeExchangeRate(String exchangeRate) {
		onBKRevaluationPage.typeExchangeRate(exchangeRate);
	}

	@Step
	public void typeDescription(String description) {
		onBKRevaluationPage.typeDescription(description);
	}

	@Step
	public void clickOnNewBtn() {
		onBKRevaluationPage.clickBtn("New");
		onBKRevaluationPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnSubmitBtn() {
		onBKRevaluationPage.clickBtn("Submit");
		onBKRevaluationPage.chooseYesOnUpdateConfirmation();
		onBKRevaluationPage.chooseOkOnInforPanel();
		onBKRevaluationPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddBtn() {
		onBKRevaluationPage.clickBtn("Add");
		onBKRevaluationPage.waitForAllJSCompletes();
		waitABit(500);
	}

	@Step
	public void searchGLAccount(String gLAccountCode) {
		onBKRevaluationPage.searchGLAccount(gLAccountCode);
	}
}
