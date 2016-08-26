package com.synergix.mtsetup.administration.company.steps;

import com.synergix.mtsetup.administration.company.pages.SetHomeCurrencyPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SetHomeCurrencySteps extends ScenarioSteps {

	SetHomeCurrencyPage onSetHomeCurrencyPage;

	public void switchToIFrame() {
		onSetHomeCurrencyPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onSetHomeCurrencyPage.switchOutDefaultIFrame();
	}

	@Step
	public void typeHomeCurrency(String homeCurrency) {
		onSetHomeCurrencyPage.typeHomeCurrency(homeCurrency);
	}

	@Step
	public void typeOperationCurrency(String operationCurrency) {
		onSetHomeCurrencyPage.typeOperationCurrency(operationCurrency);
	}

	public void chooseCompanyCode(String company) {
		onSetHomeCurrencyPage.chooseCompanyCode(company);
	}

	public void clickOnUpdateBtn() {
		onSetHomeCurrencyPage.clickBtn("Update");
		onSetHomeCurrencyPage.chooseYesOnUpdateConfirmation();
		onSetHomeCurrencyPage.clickBtnYesOnConfirmDelete();
		onSetHomeCurrencyPage.waitForAllJSCompletes();
	}

	public void chooseAndUpdateAllCompany() {
		onSetHomeCurrencyPage.chooseAndUpdateAllCompany();
	}

}
