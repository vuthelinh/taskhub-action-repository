package com.synergix.steps;

import com.synergix.page.FinancialPeriodOpeningPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FinancialPeriodOpeningSteps extends ScenarioSteps {

	FinancialPeriodOpeningPage onFinancialPeriodOpeningPage;

	public void switchToIFrame() {
		onFinancialPeriodOpeningPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onFinancialPeriodOpeningPage.switchOutDefaultIFrame();
	}

	@Step
	public void typeYearAndPeriod(String module, String year, String period) {
		onFinancialPeriodOpeningPage.typeYearAndPeriod(module, year, period);
	}

}
