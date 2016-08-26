package com.synergix.mtsetup.financial.accounting.steps;

import com.synergix.mtsetup.financial.accounting.pages.MTPeriodEndClosingPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MTPeriodEndClosingSteps extends ScenarioSteps {

	MTPeriodEndClosingPage onMTPeriodEndClosingPage;

	public void switchToIFrame() {
		onMTPeriodEndClosingPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onMTPeriodEndClosingPage.switchOutDefaultIFrame();
	}

	@Step
	public void chooseModuleCode(String moduleCode) {
		onMTPeriodEndClosingPage.chooseModuleCode(moduleCode);
	}

	@Step
	public void clickOnSubmitBtn() {
		onMTPeriodEndClosingPage.clickBtn("Submit");
		onMTPeriodEndClosingPage.waitForAllJSCompletes();
		onMTPeriodEndClosingPage.chooseYesOnUpdateConfirmation();
	}

}
